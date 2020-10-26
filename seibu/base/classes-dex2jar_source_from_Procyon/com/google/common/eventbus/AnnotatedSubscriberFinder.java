// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.eventbus;

import com.google.common.base.Objects;
import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Set;
import java.util.Collection;
import java.lang.annotation.Annotation;
import com.google.common.collect.Maps;
import com.google.common.reflect.TypeToken;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.common.base.Throwables;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheBuilder;
import java.lang.reflect.Method;
import com.google.common.collect.ImmutableList;
import com.google.common.cache.LoadingCache;

class AnnotatedSubscriberFinder implements SubscriberFindingStrategy
{
    private static final LoadingCache<Class<?>, ImmutableList<Method>> subscriberMethodsCache;
    
    static {
        subscriberMethodsCache = CacheBuilder.newBuilder().weakKeys().build((CacheLoader<? super Class<?>, ImmutableList<Method>>)new CacheLoader<Class<?>, ImmutableList<Method>>() {
            @Override
            public ImmutableList<Method> load(final Class<?> clazz) throws Exception {
                return getAnnotatedMethodsInternal(clazz);
            }
        });
    }
    
    private static ImmutableList<Method> getAnnotatedMethods(final Class<?> clazz) {
        try {
            return AnnotatedSubscriberFinder.subscriberMethodsCache.getUnchecked(clazz);
        }
        catch (UncheckedExecutionException ex) {
            throw Throwables.propagate(ex.getCause());
        }
    }
    
    private static ImmutableList<Method> getAnnotatedMethodsInternal(final Class<?> clazz) {
        final Set<Class<? super T>> rawTypes = TypeToken.of(clazz).getTypes().rawTypes();
        final HashMap<Object, Object> hashMap = Maps.newHashMap();
        final Iterator<Class<? super T>> iterator = rawTypes.iterator();
        while (iterator.hasNext()) {
            final Method[] methods = iterator.next().getMethods();
            for (int length = methods.length, i = 0; i < length; ++i) {
                final Method obj = methods[i];
                if (obj.isAnnotationPresent(Subscribe.class) && !obj.isBridge()) {
                    final Class<?>[] parameterTypes = obj.getParameterTypes();
                    if (parameterTypes.length != 1) {
                        final String value = String.valueOf(String.valueOf(obj));
                        throw new IllegalArgumentException(new StringBuilder(value.length() + 128).append("Method ").append(value).append(" has @Subscribe annotation, but requires ").append(parameterTypes.length).append(" arguments.  Event subscriber methods must require a single argument.").toString());
                    }
                    final MethodIdentifier methodIdentifier = new MethodIdentifier(obj);
                    if (!hashMap.containsKey(methodIdentifier)) {
                        hashMap.put(methodIdentifier, obj);
                    }
                }
            }
        }
        return (ImmutableList<Method>)ImmutableList.copyOf((Collection<?>)hashMap.values());
    }
    
    private static EventSubscriber makeSubscriber(final Object o, final Method method) {
        if (methodIsDeclaredThreadSafe(method)) {
            return new EventSubscriber(o, method);
        }
        return new SynchronizedEventSubscriber(o, method);
    }
    
    private static boolean methodIsDeclaredThreadSafe(final Method method) {
        return method.getAnnotation(AllowConcurrentEvents.class) != null;
    }
    
    @Override
    public Multimap<Class<?>, EventSubscriber> findAllSubscribers(final Object o) {
        final HashMultimap<Class<?>, EventSubscriber> create = HashMultimap.create();
        for (final Method method : getAnnotatedMethods(o.getClass())) {
            create.put(method.getParameterTypes()[0], makeSubscriber(o, method));
        }
        return create;
    }
    
    private static final class MethodIdentifier
    {
        private final String name;
        private final List<Class<?>> parameterTypes;
        
        MethodIdentifier(final Method method) {
            this.name = method.getName();
            this.parameterTypes = Arrays.asList(method.getParameterTypes());
        }
        
        @Override
        public boolean equals(@Nullable final Object o) {
            boolean b2;
            final boolean b = b2 = false;
            if (o instanceof MethodIdentifier) {
                final MethodIdentifier methodIdentifier = (MethodIdentifier)o;
                b2 = b;
                if (this.name.equals(methodIdentifier.name)) {
                    b2 = b;
                    if (this.parameterTypes.equals(methodIdentifier.parameterTypes)) {
                        b2 = true;
                    }
                }
            }
            return b2;
        }
        
        @Override
        public int hashCode() {
            return Objects.hashCode(this.name, this.parameterTypes);
        }
    }
}
