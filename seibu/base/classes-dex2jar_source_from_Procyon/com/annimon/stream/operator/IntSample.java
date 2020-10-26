// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;

public class IntSample extends OfInt
{
    private final OfInt iterator;
    private final int stepWidth;
    
    public IntSample(final OfInt iterator, final int stepWidth) {
        this.iterator = iterator;
        this.stepWidth = stepWidth;
    }
    
    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }
    
    @Override
    public int nextInt() {
        final int nextInt = this.iterator.nextInt();
        for (int n = 1; n < this.stepWidth && this.iterator.hasNext(); ++n) {
            this.iterator.nextInt();
        }
        return nextInt;
    }
}
