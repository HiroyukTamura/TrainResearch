// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import java.util.Iterator;
import com.annimon.stream.iterator.LsaIterator;

public class ObjSkip<T> extends LsaIterator<T>
{
    private final Iterator<? extends T> iterator;
    private final long n;
    private long skipped;
    
    public ObjSkip(final Iterator<? extends T> iterator, final long n) {
        this.iterator = iterator;
        this.n = n;
        this.skipped = 0L;
    }
    
    @Override
    public boolean hasNext() {
        while (this.skipped < this.n) {
            if (!this.iterator.hasNext()) {
                return false;
            }
            this.iterator.next();
            ++this.skipped;
        }
        return this.iterator.hasNext();
    }
    
    @Override
    public T nextIteration() {
        return (T)this.iterator.next();
    }
}
