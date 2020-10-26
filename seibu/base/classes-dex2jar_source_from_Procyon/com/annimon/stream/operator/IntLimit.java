// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;

public class IntLimit extends OfInt
{
    private long index;
    private final OfInt iterator;
    private final long maxSize;
    
    public IntLimit(final OfInt iterator, final long maxSize) {
        this.iterator = iterator;
        this.maxSize = maxSize;
        this.index = 0L;
    }
    
    @Override
    public boolean hasNext() {
        return this.index < this.maxSize && this.iterator.hasNext();
    }
    
    @Override
    public int nextInt() {
        ++this.index;
        return this.iterator.nextInt();
    }
}
