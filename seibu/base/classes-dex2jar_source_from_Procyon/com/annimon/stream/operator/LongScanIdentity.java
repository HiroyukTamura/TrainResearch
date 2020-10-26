// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;
import com.annimon.stream.function.LongBinaryOperator;
import com.annimon.stream.iterator.PrimitiveExtIterator;

public class LongScanIdentity extends OfLong
{
    private final LongBinaryOperator accumulator;
    private final long identity;
    private final PrimitiveIterator.OfLong iterator;
    
    public LongScanIdentity(final PrimitiveIterator.OfLong iterator, final long identity, final LongBinaryOperator accumulator) {
        this.iterator = iterator;
        this.identity = identity;
        this.accumulator = accumulator;
    }
    
    @Override
    protected void nextIteration() {
        if (!this.isInit) {
            this.hasNext = true;
            this.next = this.identity;
        }
        else {
            this.hasNext = this.iterator.hasNext();
            if (this.hasNext) {
                this.next = this.accumulator.applyAsLong(this.next, this.iterator.next());
            }
        }
    }
}
