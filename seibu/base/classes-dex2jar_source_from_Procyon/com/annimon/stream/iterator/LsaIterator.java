// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.iterator;

import java.util.NoSuchElementException;
import java.util.Iterator;

public abstract class LsaIterator<T> implements Iterator<T>
{
    @Override
    public final T next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        return this.nextIteration();
    }
    
    public abstract T nextIteration();
    
    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove not supported");
    }
}
