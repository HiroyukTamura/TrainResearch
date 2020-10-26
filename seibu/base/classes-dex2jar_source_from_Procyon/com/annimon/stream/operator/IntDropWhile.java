// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.IntPredicate;
import com.annimon.stream.iterator.PrimitiveIterator;
import com.annimon.stream.iterator.PrimitiveExtIterator;

public class IntDropWhile extends OfInt
{
    private final PrimitiveIterator.OfInt iterator;
    private final IntPredicate predicate;
    
    public IntDropWhile(final PrimitiveIterator.OfInt iterator, final IntPredicate predicate) {
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
