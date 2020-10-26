// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface ThrowableIntSupplier<E extends Throwable>
{
    int getAsInt() throws E, Throwable;
}
