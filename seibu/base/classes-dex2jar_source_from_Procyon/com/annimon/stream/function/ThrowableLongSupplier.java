// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface ThrowableLongSupplier<E extends Throwable>
{
    long getAsLong() throws E, Throwable;
}
