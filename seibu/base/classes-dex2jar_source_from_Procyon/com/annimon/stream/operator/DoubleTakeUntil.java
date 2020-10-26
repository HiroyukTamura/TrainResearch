// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.DoublePredicate;
import com.annimon.stream.iterator.PrimitiveIterator;
import com.annimon.stream.iterator.PrimitiveExtIterator;

public class DoubleTakeUntil extends OfDouble
{
    private final PrimitiveIterator.OfDouble iterator;
    private final DoublePredicate stopPredicate;
    
    public DoubleTakeUntil(final PrimitiveIterator.OfDouble iterator, final DoublePredicate stopPredicate) {
        this.iterator = iterator;
        this.stopPredicate = stopPredicate;
    }
    
    @Override
    protected void nextIteration() {
        this.hasNext = (this.iterator.hasNext() && (!this.isInit || !this.stopPredicate.test(this.next)));
        if (this.hasNext) {
            this.next = this.iterator.next();
        }
    }
}
