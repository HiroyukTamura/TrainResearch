// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;

public class LongSample extends OfLong
{
    private final OfLong iterator;
    private final int stepWidth;
    
    public LongSample(final OfLong iterator, final int stepWidth) {
        this.iterator = iterator;
        this.stepWidth = stepWidth;
    }
    
    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }
    
    @Override
    public long nextLong() {
        final long nextLong = this.iterator.nextLong();
        for (int n = 1; n < this.stepWidth && this.iterator.hasNext(); ++n) {
            this.iterator.nextLong();
        }
        return nextLong;
    }
}
