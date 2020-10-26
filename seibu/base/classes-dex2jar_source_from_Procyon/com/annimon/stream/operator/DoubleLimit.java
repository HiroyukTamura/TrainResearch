// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;

public class DoubleLimit extends OfDouble
{
    private long index;
    private final OfDouble iterator;
    private final long maxSize;
    
    public DoubleLimit(final OfDouble iterator, final long maxSize) {
        this.iterator = iterator;
        this.maxSize = maxSize;
        this.index = 0L;
    }
    
    @Override
    public boolean hasNext() {
        return this.index < this.maxSize && this.iterator.hasNext();
    }
    
    @Override
    public double nextDouble() {
        ++this.index;
        return this.iterator.nextDouble();
    }
}
