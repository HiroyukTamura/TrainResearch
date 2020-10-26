// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.IntPredicate;
import com.annimon.stream.iterator.PrimitiveIterator;
import com.annimon.stream.iterator.PrimitiveExtIterator;

public class IntTakeUntil extends OfInt
{
    private final PrimitiveIterator.OfInt iterator;
    private final IntPredicate stopPredicate;
    
    public IntTakeUntil(final PrimitiveIterator.OfInt iterator, final IntPredicate stopPredicate) {
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
