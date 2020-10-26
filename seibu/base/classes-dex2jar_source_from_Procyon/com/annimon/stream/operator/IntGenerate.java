// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.IntSupplier;
import com.annimon.stream.iterator.PrimitiveIterator;

public class IntGenerate extends OfInt
{
    private final IntSupplier supplier;
    
    public IntGenerate(final IntSupplier supplier) {
        this.supplier = supplier;
    }
    
    @Override
    public boolean hasNext() {
        return true;
    }
    
    @Override
    public int nextInt() {
        return this.supplier.getAsInt();
    }
}
