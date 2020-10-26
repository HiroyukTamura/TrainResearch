// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.eventbus;

import java.util.Collection;
import java.util.Map;
import com.google.common.collect.Multimap;
import java.util.Iterator;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.common.base.Throwables;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.common.base.Preconditions;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import com.google.common.collect.HashMultimap;
import com.google.common.reflect.TypeToken;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheBuilder;
import java.util.concurrent.locks.ReadWriteLock;
import com.google.common.collect.SetMultimap;
import java.util.Queue;
import java.util.Set;
import com.google.common.cache.LoadingCache;
import com.google.common.annotations.Beta;

@Beta
public class EventBus
{
    private static final LoadingCache<Class<?>, Set<Class<?>>> flattenHierarchyCache;
    private final ThreadLocal<Queue<EventWithSubscriber>> eventsToDispatch;
    private final SubscriberFindingStrategy finder;
    private final ThreadLocal<Boolean> isDispatching;
    private SubscriberExceptionHandler subscriberExceptionHandler;
    private final SetMultimap<Class<?>, EventSubscriber> subscribersByType;
    private final ReadWriteLock subscribersByTypeLock;
    
    static {
        flattenHierarchyCache = CacheBuilder.newBuilder().weakKeys().build((CacheLoader<? super Class<?>, Set<Class<?>>>)new CacheLoader<Class<?>, Set<Class<?>>>() {
            @Override
            public Set<Class<?>> load(final Class<?> clazz) {
                return (Set<Class<?>>)TypeToken.of(clazz).getTypes().rawTypes();
            }
        });
    }
    
    public EventBus() {
        this("default");
    }
    
    public EventBus(final SubscriberExceptionHandler subscriberExceptionHandler) {
        this.subscribersByType = (SetMultimap<Class<?>, EventSubscriber>)HashMultimap.create();
        this.subscribersByTypeLock = new ReentrantReadWriteLock();
        this.finder = new AnnotatedSubscriberFinder();
        this.eventsToDispatch = new ThreadLocal<Queue<EventWithSubscriber>>() {
            @Override
            protected Queue<EventWithSubscriber> initialValue() {
                return new LinkedList<EventWithSubscriber>();
            }
        };
        this.isDispatching = new ThreadLocal<Boolean>() {
            @Override
            protected Boolean initialValue() {
                return false;
            }
        };
        this.subscriberExceptionHandler = Preconditions.checkNotNull(subscriberExceptionHandler);
    }
    
    public EventBus(final String s) {
        this(new LoggingSubscriberExceptionHandler(s));
    }
    
    void dispatch(final Object o, final EventSubscriber eventSubscriber) {
        try {
            eventSubscriber.handleEvent(o);
        }
        catch (InvocationTargetException ex) {
            try {
                this.subscriberExceptionHandler.handleException(ex.getCause(), new SubscriberExceptionContext(this, o, eventSubscriber.getSubscriber(), eventSubscriber.getMethod()));
            }
            catch (Throwable thrown) {
                Logger.getLogger(EventBus.class.getName()).log(Level.SEVERE, String.format("Exception %s thrown while handling exception: %s", thrown, ex.getCause()), thrown);
            }
        }
    }
    
    void dispatchQueuedEvents() {
        if (this.isDispatching.get()) {
            return;
        }
        this.isDispatching.set(true);
        try {
            final Queue<EventWithSubscriber> queue = this.eventsToDispatch.get();
            while (true) {
                final EventWithSubscriber eventWithSubscriber = queue.poll();
                if (eventWithSubscriber == null) {
                    break;
                }
                this.dispatch(eventWithSubscriber.event, eventWithSubscriber.subscriber);
            }
        }
        finally {
            this.isDispatching.remove();
            this.eventsToDispatch.remove();
        }
        this.isDispatching.remove();
        this.eventsToDispatch.remove();
    }
    
    void enqueueEvent(final Object o, final EventSubscriber eventSubscriber) {
        this.eventsToDispatch.get().offer(new EventWithSubscriber(o, eventSubscriber));
    }
    
    @VisibleForTesting
    Set<Class<?>> flattenHierarchy(final Class<?> clazz) {
        try {
            return EventBus.flattenHierarchyCache.getUnchecked(clazz);
        }
        catch (UncheckedExecutionException ex) {
            throw Throwables.propagate(ex.getCause());
        }
    }
    
    public void post(final Object o) {
        final Set<Class<?>> flattenHierarchy = this.flattenHierarchy(o.getClass());
        int n = 0;
        for (final Class<?> clazz : flattenHierarchy) {
            this.subscribersByTypeLock.readLock().lock();
            try {
                final Set<EventSubscriber> value = this.subscribersByType.get(clazz);
                if (!value.isEmpty()) {
                    final int n2 = 1;
                    final Iterator<EventSubscriber> iterator2 = value.iterator();
                    while (true) {
                        n = n2;
                        if (!iterator2.hasNext()) {
                            break;
                        }
                        this.enqueueEvent(o, iterator2.next());
                    }
                }
            }
            finally {
                this.subscribersByTypeLock.readLock().unlock();
            }
            this.subscribersByTypeLock.readLock().unlock();
        }
        if (n == 0 && !(o instanceof DeadEvent)) {
            this.post(new DeadEvent(this, o));
        }
        this.dispatchQueuedEvents();
    }
    
    public void register(final Object o) {
        final Multimap<Class<?>, EventSubscriber> allSubscribers = this.finder.findAllSubscribers(o);
        this.subscribersByTypeLock.writeLock().lock();
        try {
            this.subscribersByType.putAll((Multimap<?, ?>)allSubscribers);
        }
        finally {
            this.subscribersByTypeLock.writeLock().unlock();
        }
    }
    
    public void unregister(final Object obj) {
        for (final Map.Entry<Class<?>, Collection<EventSubscriber>> entry : this.finder.findAllSubscribers(obj).asMap().entrySet()) {
            Object value = entry.getKey();
            final Collection<EventSubscriber> collection = entry.getValue();
            this.subscribersByTypeLock.writeLock().lock();
            try {
                value = this.subscribersByType.get((Class<?>)value);
                if (!((Set)value).containsAll(collection)) {
                    final String value2 = String.valueOf(String.valueOf(obj));
                    throw new IllegalArgumentException(new StringBuilder(value2.length() + 65).append("missing event subscriber for an annotated method. Is ").append(value2).append(" registered?").toString());
                }
            }
            finally {
                this.subscribersByTypeLock.writeLock().unlock();
            }
            ((Set)value).removeAll(collection);
            this.subscribersByTypeLock.writeLock().unlock();
        }
    }
    
    static class EventWithSubscriber
    {
        final Object event;
        final EventSubscriber subscriber;
        
        public EventWithSubscriber(final Object o, final EventSubscriber eventSubscriber) {
            this.event = Preconditions.checkNotNull(o);
            this.subscriber = Preconditions.checkNotNull(eventSubscriber);
        }
    }
    
    private static final class LoggingSubscriberExceptionHandler implements SubscriberExceptionHandler
    {
        private final Logger logger;
        
        public LoggingSubscriberExceptionHandler(String value) {
            final String value2 = String.valueOf(String.valueOf(EventBus.class.getName()));
            value = String.valueOf(String.valueOf(Preconditions.checkNotNull(value)));
            this.logger = Logger.getLogger(new StringBuilder(value2.length() + 1 + value.length()).append(value2).append(".").append(value).toString());
        }
        
        @Override
        public void handleException(final Throwable t, final SubscriberExceptionContext subscriberExceptionContext) {
            final Logger logger = this.logger;
            final Level severe = Level.SEVERE;
            final String value = String.valueOf(String.valueOf(subscriberExceptionContext.getSubscriber()));
            final String value2 = String.valueOf(String.valueOf(subscriberExceptionContext.getSubscriberMethod()));
            logger.log(severe, new StringBuilder(value.length() + 30 + value2.length()).append("Could not dispatch event: ").append(value).append(" to ").append(value2).toString(), t.getCause());
        }
    }
}
