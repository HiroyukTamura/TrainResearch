// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface ThrowableLongFunction<R, E extends Throwable>
{
    R apply(final long p0) throws E, Throwable;
}
