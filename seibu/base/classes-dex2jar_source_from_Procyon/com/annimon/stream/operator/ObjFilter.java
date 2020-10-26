// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import java.util.NoSuchElementException;
import com.annimon.stream.function.Predicate;
import java.util.Iterator;

public class ObjFilter<T> implements Iterator<T>
{
    private boolean hasNext;
    private boolean hasNextEvaluated;
    private final Iterator<? extends T> iterator;
    private T next;
    private final Predicate<? super T> predicate;
    
    public ObjFilter(final Iterator<? extends T> iterator, final Predicate<? super T> predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
    }
    
    private void nextIteration() {
        while (this.iterator.hasNext()) {
            this.next = (T)this.iterator.next();
            if (this.predicate.test((Object)this.next)) {
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
    public T next() {
        if (!this.hasNextEvaluated) {
            this.hasNext = this.hasNext();
        }
        if (!this.hasNext) {
            throw new NoSuchElementException();
        }
        this.hasNextEvaluated = false;
        return this.next;
    }
    
    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove not supported");
    }
}
