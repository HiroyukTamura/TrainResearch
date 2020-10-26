// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.LongToDoubleFunction;
import com.annimon.stream.iterator.PrimitiveIterator;

public class LongMapToDouble extends OfDouble
{
    private final OfLong iterator;
    private final LongToDoubleFunction mapper;
    
    public LongMapToDouble(final OfLong iterator, final LongToDoubleFunction mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }
    
    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }
    
    @Override
    public double nextDouble() {
        return this.mapper.applyAsDouble(this.iterator.nextLong());
    }
}
