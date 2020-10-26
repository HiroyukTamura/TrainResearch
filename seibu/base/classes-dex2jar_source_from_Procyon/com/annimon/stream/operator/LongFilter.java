// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import java.util.NoSuchElementException;
import com.annimon.stream.function.LongPredicate;
import com.annimon.stream.iterator.PrimitiveIterator;

public class LongFilter extends OfLong
{
    private boolean hasNext;
    private boolean hasNextEvaluated;
    private final OfLong iterator;
    private long next;
    private final LongPredicate predicate;
    
    public LongFilter(final OfLong iterator, final LongPredicate predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
    }
    
    private void nextIteration() {
        while (this.iterator.hasNext()) {
            this.next = this.iterator.nextLong();
            if (this.predicate.test(this.next)) {
                this.hasNext = true;
                return;
            }
        }
        this.hasNext = false;
    }
    
    @Override
    public boolean hasNext() {
        if (!this.hasNextEvaluated) {
            this.nextIteration();
            this.hasNextEvaluated = true;
        }
        return this.hasNext;
    }
    
    @Override
    public long nextLong() {
        if (!this.hasNextEvaluated) {
            this.hasNext = this.hasNext();
        }
        if (!this.hasNext) {
            throw new NoSuchElementException();
        }
        this.hasNextEvaluated = false;
        return this.next;
    }
}
