// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface ThrowablePredicate<T, E extends Throwable>
{
    boolean test(final T p0) throws E, Throwable;
}
