// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;

public class LongSkip extends OfLong
{
    private final OfLong iterator;
    private final long n;
    private long skipped;
    
    public LongSkip(final OfLong iterator, final long n) {
        this.iterator = iterator;
        this.n = n;
        this.skipped = 0L;
    }
    
    @Override
    public boolean hasNext() {
        while (this.iterator.hasNext() && this.skipped != this.n) {
            this.iterator.nextLong();
            ++this.skipped;
        }
        return this.iterator.hasNext();
    }
    
    @Override
    public long nextLong() {
        return this.iterator.nextLong();
    }
}
