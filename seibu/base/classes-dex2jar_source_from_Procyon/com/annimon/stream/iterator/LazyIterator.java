// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.iterator;

import java.util.Iterator;

public class LazyIterator<T> implements Iterator<T>
{
    private final Iterable<? extends T> iterable;
    private Iterator<? extends T> iterator;
    
    public LazyIterator(final Iterable<? extends T> iterable) {
        this.iterable = iterable;
    }
    
    private void ensureIterator() {
        if (this.iterator != null) {
            return;
        }
        this.iterator = this.iterable.iterator();
    }
    
    @Override
    public boolean hasNext() {
        this.ensureIterator();
        return this.iterator.hasNext();
    }
    
    @Override
    public T next() {
        this.ensureIterator();
        return (T)this.iterator.next();
    }
    
    @Override
    public void remove() {
        this.ensureIterator();
        this.iterator.remove();
    }
}
