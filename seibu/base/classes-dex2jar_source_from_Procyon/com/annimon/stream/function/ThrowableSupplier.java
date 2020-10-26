// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface ThrowableSupplier<T, E extends Throwable>
{
    T get() throws E, Throwable;
}
