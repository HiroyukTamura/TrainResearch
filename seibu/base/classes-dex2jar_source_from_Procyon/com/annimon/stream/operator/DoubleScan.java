// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;
import com.annimon.stream.function.DoubleBinaryOperator;
import com.annimon.stream.iterator.PrimitiveExtIterator;

public class DoubleScan extends OfDouble
{
    private final DoubleBinaryOperator accumulator;
    private final PrimitiveIterator.OfDouble iterator;
    
    public DoubleScan(final PrimitiveIterator.OfDouble iterator, final DoubleBinaryOperator accumulator) {
        this.iterator = iterator;
        this.accumulator = accumulator;
    }
    
    @Override
    protected void nextIteration() {
        this.hasNext = this.iterator.hasNext();
        if (this.hasNext) {
            final double nextDouble = this.iterator.nextDouble();
            if (!this.isInit) {
                this.next = nextDouble;
                return;
            }
            this.next = this.accumulator.applyAsDouble(this.next, nextDouble);
        }
    }
}
