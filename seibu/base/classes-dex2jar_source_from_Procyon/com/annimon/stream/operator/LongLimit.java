// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;

public class LongLimit extends OfLong
{
    private long index;
    private final OfLong iterator;
    private final long maxSize;
    
    public LongLimit(final OfLong iterator, final long maxSize) {
        this.iterator = iterator;
        this.maxSize = maxSize;
        this.index = 0L;
    }
    
    @Override
    public boolean hasNext() {
        return this.index < this.maxSize && this.iterator.hasNext();
    }
    
    @Override
    public long nextLong() {
        ++this.index;
        return this.iterator.nextLong();
    }
}
