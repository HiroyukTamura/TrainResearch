// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;
import com.annimon.stream.function.IntBinaryOperator;
import com.annimon.stream.iterator.PrimitiveExtIterator;

public class IntScanIdentity extends OfInt
{
    private final IntBinaryOperator accumulator;
    private final int identity;
    private final PrimitiveIterator.OfInt iterator;
    
    public IntScanIdentity(final PrimitiveIterator.OfInt iterator, final int identity, final IntBinaryOperator accumulator) {
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
                this.next = this.accumulator.applyAsInt(this.next, this.iterator.next());
            }
        }
    }
}
