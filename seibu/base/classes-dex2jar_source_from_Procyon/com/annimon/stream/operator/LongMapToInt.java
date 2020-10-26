// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.LongToIntFunction;
import com.annimon.stream.iterator.PrimitiveIterator;

public class LongMapToInt extends OfInt
{
    private final OfLong iterator;
    private final LongToIntFunction mapper;
    
    public LongMapToInt(final OfLong iterator, final LongToIntFunction mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }
    
    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }
    
    @Override
    public int nextInt() {
        return this.mapper.applyAsInt(this.iterator.nextLong());
    }
}
