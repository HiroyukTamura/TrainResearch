// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.IntUnaryOperator;
import com.annimon.stream.iterator.PrimitiveIterator;

public class IntMap extends OfInt
{
    private final OfInt iterator;
    private final IntUnaryOperator mapper;
    
    public IntMap(final OfInt iterator, final IntUnaryOperator mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }
    
    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }
    
    @Override
    public int nextInt() {
        return this.mapper.applyAsInt(this.iterator.nextInt());
    }
}
