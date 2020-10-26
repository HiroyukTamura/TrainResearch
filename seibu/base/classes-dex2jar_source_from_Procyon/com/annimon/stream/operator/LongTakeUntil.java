// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.LongPredicate;
import com.annimon.stream.iterator.PrimitiveIterator;
import com.annimon.stream.iterator.PrimitiveExtIterator;

public class LongTakeUntil extends OfLong
{
    private final PrimitiveIterator.OfLong iterator;
    private final LongPredicate stopPredicate;
    
    public LongTakeUntil(final PrimitiveIterator.OfLong iterator, final LongPredicate stopPredicate) {
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
