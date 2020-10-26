// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;

public class LongRangeClosed extends OfLong
{
    private long current;
    private final long endInclusive;
    private boolean hasNext;
    
    public LongRangeClosed(final long current, final long endInclusive) {
        this.endInclusive = endInclusive;
        this.current = current;
        this.hasNext = (this.current <= endInclusive);
    }
    
    @Override
    public boolean hasNext() {
        return this.hasNext;
    }
    
    @Override
    public long nextLong() {
        if (this.current >= this.endInclusive) {
            this.hasNext = false;
            return this.endInclusive;
        }
        final long current = this.current;
        this.current = 1L + current;
        return current;
    }
}
