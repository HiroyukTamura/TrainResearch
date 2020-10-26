// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.iterator;

import java.util.Iterator;

public class IndexedIterator<T> implements Iterator<T>
{
    private int index;
    private final Iterator<? extends T> iterator;
    private final int step;
    
    public IndexedIterator(final int index, final int step, final Iterator<? extends T> iterator) {
        this.iterator = iterator;
        this.step = step;
        this.index = index;
    }
    
    public IndexedIterator(final Iterator<? extends T> iterator) {
        this(0, 1, iterator);
    }
    
    public int getIndex() {
        return this.index;
    }
    
    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }
    
    @Override
    public T next() {
        final T next = (T)this.iterator.next();
        this.index += this.step;
        return next;
    }
    
    @Override
    public void remove() {
        this.iterator.remove();
    }
}
