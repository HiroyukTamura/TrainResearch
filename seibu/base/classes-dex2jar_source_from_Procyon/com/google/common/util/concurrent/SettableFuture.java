// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.util.concurrent;

import javax.annotation.Nullable;

public final class SettableFuture<V> extends AbstractFuture<V>
{
    private SettableFuture() {
    }
    
    public static <V> SettableFuture<V> create() {
        return new SettableFuture<V>();
    }
    
    public boolean set(@Nullable final V v) {
        return super.set(v);
    }
    
    public boolean setException(final Throwable exception) {
        return super.setException(exception);
    }
}
