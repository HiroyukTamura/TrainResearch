// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.IntToLongFunction;
import com.annimon.stream.iterator.PrimitiveIterator;

public class IntMapToLong extends OfLong
{
    private final OfInt iterator;
    private final IntToLongFunction mapper;
    
    public IntMapToLong(final OfInt iterator, final IntToLongFunction mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }
    
    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }
    
    @Override
    public long nextLong() {
        return this.mapper.applyAsLong(this.iterator.nextInt());
    }
}
