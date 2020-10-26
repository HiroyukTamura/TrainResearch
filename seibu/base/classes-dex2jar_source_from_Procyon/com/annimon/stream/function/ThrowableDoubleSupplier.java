// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface ThrowableDoubleSupplier<E extends Throwable>
{
    double getAsDouble() throws E, Throwable;
}
