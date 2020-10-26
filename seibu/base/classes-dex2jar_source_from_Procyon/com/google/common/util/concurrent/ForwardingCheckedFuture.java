// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.TimeUnit;
import com.google.common.annotations.Beta;

@Beta
public abstract class ForwardingCheckedFuture<V, X extends Exception> extends ForwardingListenableFuture<V> implements CheckedFuture<V, X>
{
    @Override
    public V checkedGet() throws X, Exception {
        return this.delegate().checkedGet();
    }
    
    @Override
    public V checkedGet(final long n, final TimeUnit timeUnit) throws TimeoutException, X, Exception {
        return this.delegate().checkedGet(n, timeUnit);
    }
    
    @Override
    protected abstract CheckedFuture<V, X> delegate();
    
    @Beta
    public abstract static class SimpleForwardingCheckedFuture<V, X extends Exception> extends ForwardingCheckedFuture<V, X>
    {
        private final CheckedFuture<V, X> delegate;
        
        protected SimpleForwardingCheckedFuture(final CheckedFuture<V, X> checkedFuture) {
            this.delegate = Preconditions.checkNotNull(checkedFuture);
        }
        
        @Override
        protected final CheckedFuture<V, X> delegate() {
            return this.delegate;
        }
    }
}