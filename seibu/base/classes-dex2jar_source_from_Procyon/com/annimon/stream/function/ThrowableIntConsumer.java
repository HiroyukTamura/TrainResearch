// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface ThrowableIntConsumer<E extends Throwable>
{
    void accept(final int p0) throws E, Throwable;
}
