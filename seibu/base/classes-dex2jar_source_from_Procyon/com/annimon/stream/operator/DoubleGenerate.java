// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.DoubleSupplier;
import com.annimon.stream.iterator.PrimitiveIterator;

public class DoubleGenerate extends OfDouble
{
    private final DoubleSupplier supplier;
    
    public DoubleGenerate(final DoubleSupplier supplier) {
        this.supplier = supplier;
    }
    
    @Override
    public boolean hasNext() {
        return true;
    }
    
    @Override
    public double nextDouble() {
        return this.supplier.getAsDouble();
    }
}
