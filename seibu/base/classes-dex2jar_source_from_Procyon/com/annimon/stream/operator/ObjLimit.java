// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import java.util.Iterator;
import com.annimon.stream.iterator.LsaIterator;

public class ObjLimit<T> extends LsaIterator<T>
{
    private long index;
    private final Iterator<? extends T> iterator;
    private final long maxSize;
    
    public ObjLimit(final Iterator<? extends T> iterator, final long maxSize) {
        this.iterator = iterator;
        this.maxSize = maxSize;
        this.index = 0L;
    }
    
    @Override
    public boolean hasNext() {
        return this.index < this.maxSize && this.iterator.hasNext();
    }
    
    @Override
    public T nextIteration() {
        ++this.index;
        return (T)this.iterator.next();
    }
}
