// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.util.concurrent;

import javax.annotation.Nullable;
import com.google.common.base.Preconditions;
import java.util.concurrent.Future;

final class AsyncSettableFuture<V> extends ForwardingListenableFuture<V>
{
    private final ListenableFuture<V> dereferenced;
    private final NestedFuture<V> nested;
    
    private AsyncSettableFuture() {
        this.nested = new NestedFuture<V>();
        this.dereferenced = Futures.dereference((ListenableFuture<? extends ListenableFuture<? extends V>>)this.nested);
    }
    
    public static <V> AsyncSettableFuture<V> create() {
        return new AsyncSettableFuture<V>();
    }
    
    @Override
    protected ListenableFuture<V> delegate() {
        return this.dereferenced;
    }
    
    public boolean isSet() {
        return this.nested.isDone();
    }
    
    public boolean setException(final Throwable t) {
        return this.setFuture(Futures.immediateFailedFuture(t));
    }
    
    public boolean setFuture(final ListenableFuture<? extends V> listenableFuture) {
        return this.nested.setFuture(Preconditions.checkNotNull(listenableFuture));
    }
    
    public boolean setValue(@Nullable final V v) {
        return this.setFuture(Futures.immediateFuture(v));
    }
    
    private static final class NestedFuture<V> extends AbstractFuture<ListenableFuture<? extends V>>
    {
        boolean setFuture(final ListenableFuture<? extends V> listenableFuture) {
            final boolean set = this.set(listenableFuture);
            if (this.isCancelled()) {
                listenableFuture.cancel(this.wasInterrupted());
            }
            return set;
        }
    }
}
