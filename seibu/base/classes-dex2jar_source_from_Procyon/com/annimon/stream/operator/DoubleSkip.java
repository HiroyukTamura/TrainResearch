// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;

public class DoubleSkip extends OfDouble
{
    private final OfDouble iterator;
    private final long n;
    private long skipped;
    
    public DoubleSkip(final OfDouble iterator, final long n) {
        this.iterator = iterator;
        this.n = n;
        this.skipped = 0L;
    }
    
    @Override
    public boolean hasNext() {
        while (this.iterator.hasNext() && this.skipped != this.n) {
            this.iterator.nextDouble();
            ++this.skipped;
        }
        return this.iterator.hasNext();
    }
    
    @Override
    public double nextDouble() {
        return this.iterator.nextDouble();
    }
}
