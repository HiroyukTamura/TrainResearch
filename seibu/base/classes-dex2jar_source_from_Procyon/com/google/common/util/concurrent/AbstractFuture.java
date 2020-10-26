// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.util.concurrent;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import com.google.common.base.Preconditions;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;

public abstract class AbstractFuture<V> implements ListenableFuture<V>
{
    private final ExecutionList executionList;
    private final Sync<V> sync;
    
    protected AbstractFuture() {
        this.sync = new Sync<V>();
        this.executionList = new ExecutionList();
    }
    
    static final CancellationException cancellationExceptionWithCause(@Nullable final String message, @Nullable final Throwable cause) {
        final CancellationException ex = new CancellationException(message);
        ex.initCause(cause);
        return ex;
    }
    
    @Override
    public void addListener(final Runnable runnable, final Executor executor) {
        this.executionList.add(runnable, executor);
    }
    
    @Override
    public boolean cancel(final boolean b) {
        if (!this.sync.cancel(b)) {
            return false;
        }
        this.executionList.execute();
        if (b) {
            this.interruptTask();
        }
        return true;
    }
    
    @Override
    public V get() throws InterruptedException, ExecutionException {
        return this.sync.get();
    }
    
    @Override
    public V get(final long duration, final TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        return this.sync.get(timeUnit.toNanos(duration));
    }
    
    protected void interruptTask() {
    }
    
    @Override
    public boolean isCancelled() {
        return this.sync.isCancelled();
    }
    
    @Override
    public boolean isDone() {
        return this.sync.isDone();
    }
    
    protected boolean set(@Nullable final V v) {
        final boolean set = this.sync.set(v);
        if (set) {
            this.executionList.execute();
        }
        return set;
    }
    
    protected boolean setException(final Throwable t) {
        final boolean setException = this.sync.setException(Preconditions.checkNotNull(t));
        if (setException) {
            this.executionList.execute();
        }
        return setException;
    }
    
    protected final boolean wasInterrupted() {
        return this.sync.wasInterrupted();
    }
    
    static final class Sync<V> extends AbstractQueuedSynchronizer
    {
        static final int CANCELLED = 4;
        static final int COMPLETED = 2;
        static final int COMPLETING = 1;
        static final int INTERRUPTED = 8;
        static final int RUNNING = 0;
        private static final long serialVersionUID = 0L;
        private Throwable exception;
        private V value;
        
        private boolean complete(@Nullable final V value, @Nullable Throwable exception, final int arg) {
            final boolean compareAndSetState = this.compareAndSetState(0, 1);
            if (compareAndSetState) {
                this.value = value;
                if ((arg & 0xC) != 0x0) {
                    exception = new CancellationException("Future.cancel() was called.");
                }
                this.exception = exception;
                this.releaseShared(arg);
            }
            else if (this.getState() == 1) {
                this.acquireShared(-1);
                return compareAndSetState;
            }
            return compareAndSetState;
        }
        
        private V getValue() throws CancellationException, ExecutionException {
            final int state = this.getState();
            switch (state) {
                default: {
                    throw new IllegalStateException(new StringBuilder(49).append("Error, synchronizer in invalid state: ").append(state).toString());
                }
                case 2: {
                    if (this.exception != null) {
                        throw new ExecutionException(this.exception);
                    }
                    return this.value;
                }
                case 4:
                case 8: {
                    throw AbstractFuture.cancellationExceptionWithCause("Task was cancelled.", this.exception);
                }
            }
        }
        
        boolean cancel(final boolean b) {
            int n;
            if (b) {
                n = 8;
            }
            else {
                n = 4;
            }
            return this.complete(null, null, n);
        }
        
        V get() throws CancellationException, ExecutionException, InterruptedException {
            this.acquireSharedInterruptibly(-1);
            return this.getValue();
        }
        
        V get(final long nanosTimeout) throws TimeoutException, CancellationException, ExecutionException, InterruptedException {
            if (!this.tryAcquireSharedNanos(-1, nanosTimeout)) {
                throw new TimeoutException("Timeout waiting for task.");
            }
            return this.getValue();
        }
        
        boolean isCancelled() {
            return (this.getState() & 0xC) != 0x0;
        }
        
        boolean isDone() {
            return (this.getState() & 0xE) != 0x0;
        }
        
        boolean set(@Nullable final V v) {
            return this.complete(v, null, 2);
        }
        
        boolean setException(final Throwable t) {
            return this.complete(null, t, 2);
        }
        
        @Override
        protected int tryAcquireShared(final int n) {
            if (this.isDone()) {
                return 1;
            }
            return -1;
        }
        
        @Override
        protected boolean tryReleaseShared(final int state) {
            this.setState(state);
            return true;
        }
        
        boolean wasInterrupted() {
            return this.getState() == 8;
        }
    }
}
