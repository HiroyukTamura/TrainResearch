// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface ThrowableDoubleFunction<R, E extends Throwable>
{
    R apply(final double p0) throws E, Throwable;
}
