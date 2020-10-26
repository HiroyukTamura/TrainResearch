// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import java.util.List;
import java.util.Collections;
import com.annimon.stream.internal.Operators;
import java.util.Iterator;
import java.util.Comparator;
import com.annimon.stream.iterator.LsaExtIterator;

public class ObjSorted<T> extends LsaExtIterator<T>
{
    private final Comparator<? super T> comparator;
    private final Iterator<? extends T> iterator;
    private Iterator<T> sortedIterator;
    
    public ObjSorted(final Iterator<? extends T> iterator, final Comparator<? super T> comparator) {
        this.iterator = iterator;
        this.comparator = comparator;
    }
    
    @Override
    protected void nextIteration() {
        if (!this.isInit) {
            final List<T> list = Operators.toList(this.iterator);
            Collections.sort(list, this.comparator);
            this.sortedIterator = list.iterator();
        }
        this.hasNext = this.sortedIterator.hasNext();
        if (this.hasNext) {
            this.next = this.sortedIterator.next();
        }
    }
}
