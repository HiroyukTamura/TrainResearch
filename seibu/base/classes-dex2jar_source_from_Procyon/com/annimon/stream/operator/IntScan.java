// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;
import com.annimon.stream.function.IntBinaryOperator;
import com.annimon.stream.iterator.PrimitiveExtIterator;

public class IntScan extends OfInt
{
    private final IntBinaryOperator accumulator;
    private final PrimitiveIterator.OfInt iterator;
    
    public IntScan(final PrimitiveIterator.OfInt iterator, final IntBinaryOperator accumulator) {
        this.iterator = iterator;
        this.accumulator = accumulator;
    }
    
    @Override
    protected void nextIteration() {
        this.hasNext = this.iterator.hasNext();
        if (this.hasNext) {
            final int intValue = this.iterator.next();
            if (!this.isInit) {
                this.next = intValue;
                return;
            }
            this.next = this.accumulator.applyAsInt(this.next, intValue);
        }
    }
}
