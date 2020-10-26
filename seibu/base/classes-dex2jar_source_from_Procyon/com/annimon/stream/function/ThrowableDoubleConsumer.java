// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface ThrowableDoubleConsumer<E extends Throwable>
{
    void accept(final double p0) throws E, Throwable;
}
