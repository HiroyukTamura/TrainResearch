// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.iterator.PrimitiveIterator;
import com.annimon.stream.function.DoubleBinaryOperator;
import com.annimon.stream.iterator.PrimitiveExtIterator;

public class DoubleScanIdentity extends OfDouble
{
    private final DoubleBinaryOperator accumulator;
    private final double identity;
    private final PrimitiveIterator.OfDouble iterator;
    
    public DoubleScanIdentity(final PrimitiveIterator.OfDouble iterator, final double identity, final DoubleBinaryOperator accumulator) {
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
                this.next = this.accumulator.applyAsDouble(this.next, this.iterator.next());
            }
        }
    }
}
