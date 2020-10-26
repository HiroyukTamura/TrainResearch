// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.iterator;

import java.util.NoSuchElementException;
import java.util.Iterator;

public abstract class LsaExtIterator<T> implements Iterator<T>
{
    protected boolean hasNext;
    protected boolean isInit;
    protected T next;
    
    @Override
    public boolean hasNext() {
        if (!this.isInit) {
            this.nextIteration();
            this.isInit = true;
        }
        return this.hasNext;
    }
    
    @Override
    public T next() {
        if (!this.isInit) {
            this.hasNext();
        }
        if (!this.hasNext) {
            throw new NoSuchElementException();
        }
        final T next = this.next;
        this.nextIteration();
        if (!this.hasNext) {
            this.next = null;
        }
        return next;
    }
    
    protected abstract void nextIteration();
    
    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove not supported");
    }
}
