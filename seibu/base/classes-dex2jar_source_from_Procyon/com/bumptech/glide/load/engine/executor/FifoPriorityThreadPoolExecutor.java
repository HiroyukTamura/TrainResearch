// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.engine.executor;

import android.util.Log;
import java.util.concurrent.FutureTask;
import android.os.Process;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ThreadPoolExecutor;

public class FifoPriorityThreadPoolExecutor extends ThreadPoolExecutor
{
    private static final String TAG = "PriorityExecutor";
    private final AtomicInteger ordering;
    private final UncaughtThrowableStrategy uncaughtThrowableStrategy;
    
    public FifoPriorityThreadPoolExecutor(final int n) {
        this(n, UncaughtThrowableStrategy.LOG);
    }
    
    public FifoPriorityThreadPoolExecutor(final int corePoolSize, final int maximumPoolSize, final long keepAliveTime, final TimeUnit unit, final ThreadFactory threadFactory, final UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, new PriorityBlockingQueue<Runnable>(), threadFactory);
        this.ordering = new AtomicInteger();
        this.uncaughtThrowableStrategy = uncaughtThrowableStrategy;
    }
    
    public FifoPriorityThreadPoolExecutor(final int n, final UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        this(n, n, 0L, TimeUnit.MILLISECONDS, new DefaultThreadFactory(), uncaughtThrowableStrategy);
    }
    
    @Override
    protected void afterExecute(final Runnable r, final Throwable t) {
        super.afterExecute(r, t);
        if (t != null || !(r instanceof Future)) {
            return;
        }
        final Future future = (Future)r;
        if (!future.isDone() || future.isCancelled()) {
            return;
        }
        try {
            future.get();
        }
        catch (InterruptedException ex) {
            this.uncaughtThrowableStrategy.handle(ex);
        }
        catch (ExecutionException ex2) {
            this.uncaughtThrowableStrategy.handle(ex2);
        }
    }
    
    @Override
    protected <T> RunnableFuture<T> newTaskFor(final Runnable runnable, final T t) {
        return new LoadTask<T>(runnable, t, this.ordering.getAndIncrement());
    }
    
    public static class DefaultThreadFactory implements ThreadFactory
    {
        int threadNum;
        
        public DefaultThreadFactory() {
            this.threadNum = 0;
        }
        
        @Override
        public Thread newThread(final Runnable runnable) {
            final Thread thread = new Thread(runnable, "fifo-pool-thread-" + this.threadNum) {
                @Override
                public void run() {
                    Process.setThreadPriority(10);
                    super.run();
                }
            };
            ++this.threadNum;
            return thread;
        }
    }
    
    static class LoadTask<T> extends FutureTask<T> implements Comparable<LoadTask<?>>
    {
        private final int order;
        private final int priority;
        
        public LoadTask(final Runnable runnable, final T result, final int order) {
            super(runnable, result);
            if (!(runnable instanceof Prioritized)) {
                throw new IllegalArgumentException("FifoPriorityThreadPoolExecutor must be given Runnables that implement Prioritized");
            }
            this.priority = ((Prioritized)runnable).getPriority();
            this.order = order;
        }
        
        @Override
        public int compareTo(final LoadTask<?> loadTask) {
            int n;
            if ((n = this.priority - loadTask.priority) == 0) {
                n = this.order - loadTask.order;
            }
            return n;
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b2;
            final boolean b = b2 = false;
            if (o instanceof LoadTask) {
                final LoadTask loadTask = (LoadTask)o;
                b2 = b;
                if (this.order == loadTask.order) {
                    b2 = b;
                    if (this.priority == loadTask.priority) {
                        b2 = true;
                    }
                }
            }
            return b2;
        }
        
        @Override
        public int hashCode() {
            return this.priority * 31 + this.order;
        }
    }
    
    public enum UncaughtThrowableStrategy
    {
        IGNORE, 
        LOG {
            @Override
            protected void handle(final Throwable t) {
                if (Log.isLoggable("PriorityExecutor", 6)) {
                    Log.e("PriorityExecutor", "Request threw uncaught throwable", t);
                }
            }
        }, 
        THROW {
            @Override
            protected void handle(final Throwable cause) {
                super.handle(cause);
                throw new RuntimeException(cause);
            }
        };
        
        protected void handle(final Throwable t) {
        }
    }
}
