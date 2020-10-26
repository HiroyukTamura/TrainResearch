// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.DoubleFunction;
import com.annimon.stream.iterator.PrimitiveIterator;
import com.annimon.stream.iterator.LsaIterator;

public class DoubleMapToObj<R> extends LsaIterator<R>
{
    private final PrimitiveIterator.OfDouble iterator;
    private final DoubleFunction<? extends R> mapper;
    
    public DoubleMapToObj(final PrimitiveIterator.OfDouble iterator, final DoubleFunction<? extends R> mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }
    
    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }
    
    @Override
    public R nextIteration() {
        return (R)this.mapper.apply(this.iterator.nextDouble());
    }
}
