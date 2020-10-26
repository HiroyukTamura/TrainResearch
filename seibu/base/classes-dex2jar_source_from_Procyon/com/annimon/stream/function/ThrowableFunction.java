// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface ThrowableFunction<I, R, E extends Throwable>
{
    R apply(final I p0) throws E, Throwable;
}
