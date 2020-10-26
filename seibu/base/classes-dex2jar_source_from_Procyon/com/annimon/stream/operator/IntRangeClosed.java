// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;

public class IntRangeClosed extends OfInt
{
    private int current;
    private final int endInclusive;
    private boolean hasNext;
    
    public IntRangeClosed(final int current, final int endInclusive) {
        this.endInclusive = endInclusive;
        this.current = current;
        this.hasNext = (this.current <= endInclusive);
    }
    
    @Override
    public boolean hasNext() {
        return this.hasNext;
    }
    
    @Override
    public int nextInt() {
        if (this.current >= this.endInclusive) {
            this.hasNext = false;
            return this.endInclusive;
        }
        return this.current++;
    }
}
