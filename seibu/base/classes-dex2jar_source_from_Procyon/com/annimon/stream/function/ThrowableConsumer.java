// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface ThrowableConsumer<T, E extends Throwable>
{
    void accept(final T p0) throws E, Throwable;
}
