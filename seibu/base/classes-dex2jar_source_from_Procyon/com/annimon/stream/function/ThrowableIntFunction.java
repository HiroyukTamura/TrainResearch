// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface ThrowableIntFunction<R, E extends Throwable>
{
    R apply(final int p0) throws E, Throwable;
}
