// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.IntPredicate;
import com.annimon.stream.iterator.PrimitiveIterator;
import com.annimon.stream.iterator.PrimitiveExtIterator;

public class IntTakeWhile extends OfInt
{
    private final PrimitiveIterator.OfInt iterator;
    private final IntPredicate predicate;
    
    public IntTakeWhile(final PrimitiveIterator.OfInt iterator, final IntPredicate predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
    }
    
    @Override
    protected void nextIteration() {
        while (true) {
            Label_0049: {
                if (!this.iterator.hasNext()) {
                    break Label_0049;
                }
                final IntPredicate predicate = this.predicate;
                final int intValue = this.iterator.next();
                this.next = intValue;
                if (!predicate.test(intValue)) {
                    break Label_0049;
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
