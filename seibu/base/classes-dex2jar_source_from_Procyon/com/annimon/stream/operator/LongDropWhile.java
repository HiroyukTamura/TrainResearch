// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.LongPredicate;
import com.annimon.stream.iterator.PrimitiveIterator;
import com.annimon.stream.iterator.PrimitiveExtIterator;

public class LongDropWhile extends OfLong
{
    private final PrimitiveIterator.OfLong iterator;
    private final LongPredicate predicate;
    
    public LongDropWhile(final PrimitiveIterator.OfLong iterator, final LongPredicate predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
    }
    
    @Override
    protected void nextIteration() {
        Label_0055: {
            if (this.isInit) {
                break Label_0055;
            }
            do {
                final boolean hasNext = this.iterator.hasNext();
                this.hasNext = hasNext;
                if (!hasNext) {
                    break Label_0055;
                }
                this.next = this.iterator.next();
            } while (this.predicate.test(this.next));
            return;
        }
        this.hasNext = (this.hasNext && this.iterator.hasNext());
        if (this.hasNext) {
            this.next = this.iterator.next();
        }
    }
}
