// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.DoublePredicate;
import com.annimon.stream.iterator.PrimitiveIterator;
import com.annimon.stream.iterator.PrimitiveExtIterator;

public class DoubleTakeWhile extends OfDouble
{
    private final PrimitiveIterator.OfDouble iterator;
    private final DoublePredicate predicate;
    
    public DoubleTakeWhile(final PrimitiveIterator.OfDouble iterator, final DoublePredicate predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
    }
    
    @Override
    protected void nextIteration() {
        while (true) {
            Label_0051: {
                if (!this.iterator.hasNext()) {
                    break Label_0051;
                }
                final DoublePredicate predicate = this.predicate;
                final double doubleValue = this.iterator.next();
                this.next = doubleValue;
                if (!predicate.test(doubleValue)) {
                    break Label_0051;
                }
                final boolean hasNext = true;
                this.hasNext = hasNext;
                return;
            }
            final boolean hasNext = false;
            continue;
        }
    }
}
