// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.ConcurrentLinkedQueue;
import com.google.common.annotations.Beta;

@Beta
public class AsyncEventBus extends EventBus
{
    private final ConcurrentLinkedQueue<EventWithSubscriber> eventsToDispatch;
    private final Executor executor;
    
    public AsyncEventBus(final String s, final Executor executor) {
        super(s);
        this.eventsToDispatch = new ConcurrentLinkedQueue<EventWithSubscriber>();
        this.executor = Preconditions.checkNotNull(executor);
    }
    
    public AsyncEventBus(final Executor executor) {
        super("default");
        this.eventsToDispatch = new ConcurrentLinkedQueue<EventWithSubscriber>();
        this.executor = Preconditions.checkNotNull(executor);
    }
    
    public AsyncEventBus(final Executor executor, final SubscriberExceptionHandler subscriberExceptionHandler) {
        super(subscriberExceptionHandler);
        this.eventsToDispatch = new ConcurrentLinkedQueue<EventWithSubscriber>();
        this.executor = Preconditions.checkNotNull(executor);
    }
    
    @Override
    void dispatch(final Object o, final EventSubscriber eventSubscriber) {
        Preconditions.checkNotNull(o);
        Preconditions.checkNotNull(eventSubscriber);
        this.executor.execute(new Runnable() {
            @Override
            public void run() {
                EventBus.this.dispatch(o, eventSubscriber);
            }
        });
    }
    
    protected void dispatchQueuedEvents() {
        while (true) {
            final EventWithSubscriber eventWithSubscriber = this.eventsToDispatch.poll();
            if (eventWithSubscriber == null) {
                break;
            }
            this.dispatch(eventWithSubscriber.event, eventWithSubscriber.subscriber);
        }
    }
    
    @Override
    void enqueueEvent(final Object o, final EventSubscriber eventSubscriber) {
        this.eventsToDispatch.offer(new EventWithSubscriber(o, eventSubscriber));
    }
}
