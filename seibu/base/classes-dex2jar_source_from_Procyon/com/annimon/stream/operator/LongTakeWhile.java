// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.LongPredicate;
import com.annimon.stream.iterator.PrimitiveIterator;
import com.annimon.stream.iterator.PrimitiveExtIterator;

public class LongTakeWhile extends OfLong
{
    private final PrimitiveIterator.OfLong iterator;
    private final LongPredicate predicate;
    
    public LongTakeWhile(final PrimitiveIterator.OfLong iterator, final LongPredicate predicate) {
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
                final LongPredicate predicate = this.predicate;
                final long longValue = this.iterator.next();
                this.next = longValue;
                if (!predicate.test(longValue)) {
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
