// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;
import com.annimon.stream.function.LongBinaryOperator;
import com.annimon.stream.iterator.PrimitiveExtIterator;

public class LongScan extends OfLong
{
    private final LongBinaryOperator accumulator;
    private final PrimitiveIterator.OfLong iterator;
    
    public LongScan(final PrimitiveIterator.OfLong iterator, final LongBinaryOperator accumulator) {
        this.iterator = iterator;
        this.accumulator = accumulator;
    }
    
    @Override
    protected void nextIteration() {
        this.hasNext = this.iterator.hasNext();
        if (this.hasNext) {
            final long nextLong = this.iterator.nextLong();
            if (!this.isInit) {
                this.next = nextLong;
                return;
            }
            this.next = this.accumulator.applyAsLong(this.next, nextLong);
        }
    }
}
