// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface ThrowableIntPredicate<E extends Throwable>
{
    boolean test(final int p0) throws E, Throwable;
}
