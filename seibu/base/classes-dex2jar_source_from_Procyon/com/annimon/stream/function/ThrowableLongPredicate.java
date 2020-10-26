// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface ThrowableLongPredicate<E extends Throwable>
{
    boolean test(final long p0) throws E, Throwable;
}
