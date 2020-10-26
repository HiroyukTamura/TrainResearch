// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface ThrowableLongConsumer<E extends Throwable>
{
    void accept(final long p0) throws E, Throwable;
}
