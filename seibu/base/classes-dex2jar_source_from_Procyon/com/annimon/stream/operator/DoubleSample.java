// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;

public class DoubleSample extends OfDouble
{
    private final OfDouble iterator;
    private final int stepWidth;
    
    public DoubleSample(final OfDouble iterator, final int stepWidth) {
        this.iterator = iterator;
        this.stepWidth = stepWidth;
    }
    
    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }
    
    @Override
    public double nextDouble() {
        final double nextDouble = this.iterator.nextDouble();
        for (int n = 1; n < this.stepWidth && this.iterator.hasNext(); ++n) {
            this.iterator.nextDouble();
        }
        return nextDouble;
    }
}
