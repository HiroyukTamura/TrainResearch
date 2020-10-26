// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.LongUnaryOperator;
import com.annimon.stream.iterator.PrimitiveIterator;

public class LongMap extends OfLong
{
    private final OfLong iterator;
    private final LongUnaryOperator mapper;
    
    public LongMap(final OfLong iterator, final LongUnaryOperator mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }
    
    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }
    
    @Override
    public long nextLong() {
        return this.mapper.applyAsLong(this.iterator.nextLong());
    }
}
