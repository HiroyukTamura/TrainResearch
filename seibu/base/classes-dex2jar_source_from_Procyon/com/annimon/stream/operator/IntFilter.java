// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import java.util.NoSuchElementException;
import com.annimon.stream.function.IntPredicate;
import com.annimon.stream.iterator.PrimitiveIterator;

public class IntFilter extends OfInt
{
    private boolean hasNext;
    private boolean hasNextEvaluated;
    private final OfInt iterator;
    private int next;
    private final IntPredicate predicate;
    
    public IntFilter(final OfInt iterator, final IntPredicate predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
    }
    
    private void nextIteration() {
        while (this.iterator.hasNext()) {
            this.next = this.iterator.nextInt();
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
    public int nextInt() {
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
