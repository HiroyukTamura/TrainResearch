// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.DoubleToLongFunction;
import com.annimon.stream.iterator.PrimitiveIterator;

public class DoubleMapToLong extends OfLong
{
    private final OfDouble iterator;
    private final DoubleToLongFunction mapper;
    
    public DoubleMapToLong(final OfDouble iterator, final DoubleToLongFunction mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }
    
    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }
    
    @Override
    public long nextLong() {
        return this.mapper.applyAsLong(this.iterator.nextDouble());
    }
}
