// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;

public class IntSkip extends OfInt
{
    private final OfInt iterator;
    private final long n;
    private long skipped;
    
    public IntSkip(final OfInt iterator, final long n) {
        this.iterator = iterator;
        this.n = n;
        this.skipped = 0L;
    }
    
    @Override
    public boolean hasNext() {
        while (this.iterator.hasNext() && this.skipped != this.n) {
            this.iterator.nextInt();
            ++this.skipped;
        }
        return this.iterator.hasNext();
    }
    
    @Override
    public int nextInt() {
        return this.iterator.nextInt();
    }
}
