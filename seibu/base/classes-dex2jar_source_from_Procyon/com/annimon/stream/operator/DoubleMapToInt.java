// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.DoubleToIntFunction;
import com.annimon.stream.iterator.PrimitiveIterator;

public class DoubleMapToInt extends OfInt
{
    private final OfDouble iterator;
    private final DoubleToIntFunction mapper;
    
    public DoubleMapToInt(final OfDouble iterator, final DoubleToIntFunction mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }
    
    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }
    
    @Override
    public int nextInt() {
        return this.mapper.applyAsInt(this.iterator.nextDouble());
    }
}
