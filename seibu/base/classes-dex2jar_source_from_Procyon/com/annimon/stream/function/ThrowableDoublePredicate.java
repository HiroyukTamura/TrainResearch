// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface ThrowableDoublePredicate<E extends Throwable>
{
    boolean test(final double p0) throws E, Throwable;
}
