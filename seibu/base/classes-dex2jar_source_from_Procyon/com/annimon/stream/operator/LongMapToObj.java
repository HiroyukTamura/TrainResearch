// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.LongFunction;
import com.annimon.stream.iterator.PrimitiveIterator;
import com.annimon.stream.iterator.LsaIterator;

public class LongMapToObj<R> extends LsaIterator<R>
{
    private final PrimitiveIterator.OfLong iterator;
    private final LongFunction<? extends R> mapper;
    
    public LongMapToObj(final PrimitiveIterator.OfLong iterator, final LongFunction<? extends R> mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }
    
    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }
    
    @Override
    public R nextIteration() {
        return (R)this.mapper.apply(this.iterator.nextLong());
    }
}
