// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.DoubleUnaryOperator;
import com.annimon.stream.iterator.PrimitiveIterator;

public class DoubleMap extends OfDouble
{
    private final OfDouble iterator;
    private final DoubleUnaryOperator mapper;
    
    public DoubleMap(final OfDouble iterator, final DoubleUnaryOperator mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }
    
    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }
    
    @Override
    public double nextDouble() {
        return this.mapper.applyAsDouble(this.iterator.nextDouble());
    }
}
