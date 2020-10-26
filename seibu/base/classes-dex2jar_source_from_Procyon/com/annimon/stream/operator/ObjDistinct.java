// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;
import com.annimon.stream.iterator.LsaExtIterator;

public class ObjDistinct<T> extends LsaExtIterator<T>
{
    private final Iterator<? extends T> iterator;
    private final Set<T> set;
    
    public ObjDistinct(final Iterator<? extends T> iterator) {
        this.iterator = iterator;
        this.set = new HashSet<T>();
    }
    
    @Override
    protected void nextIteration() {
        do {
            final boolean hasNext = this.iterator.hasNext();
            this.hasNext = hasNext;
            if (!hasNext) {
                break;
            }
            this.next = (T)this.iterator.next();
        } while (!this.set.add(this.next));
    }
}
