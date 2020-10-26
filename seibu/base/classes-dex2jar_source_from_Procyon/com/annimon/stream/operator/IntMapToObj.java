// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.IntFunction;
import com.annimon.stream.iterator.PrimitiveIterator;
import com.annimon.stream.iterator.LsaIterator;

public class IntMapToObj<R> extends LsaIterator<R>
{
    private final PrimitiveIterator.OfInt iterator;
    private final IntFunction<? extends R> mapper;
    
    public IntMapToObj(final PrimitiveIterator.OfInt iterator, final IntFunction<? extends R> mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }
    
    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }
    
    @Override
    public R nextIteration() {
        return (R)this.mapper.apply(this.iterator.nextInt());
    }
}
