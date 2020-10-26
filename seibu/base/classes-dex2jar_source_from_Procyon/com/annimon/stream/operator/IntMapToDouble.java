// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.IntToDoubleFunction;
import com.annimon.stream.iterator.PrimitiveIterator;

public class IntMapToDouble extends OfDouble
{
    private final OfInt iterator;
    private final IntToDoubleFunction mapper;
    
    public IntMapToDouble(final OfInt iterator, final IntToDoubleFunction mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }
    
    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }
    
    @Override
    public double nextDouble() {
        return this.mapper.applyAsDouble(this.iterator.nextInt());
    }
}
