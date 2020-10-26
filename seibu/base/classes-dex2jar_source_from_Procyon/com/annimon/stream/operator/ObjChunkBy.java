// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import java.util.ArrayList;
import java.util.Iterator;
import com.annimon.stream.function.Function;
import java.util.List;
import com.annimon.stream.iterator.LsaIterator;

public class ObjChunkBy<T, K> extends LsaIterator<List<T>>
{
    private final Function<? super T, ? extends K> classifier;
    private final Iterator<? extends T> iterator;
    private T next;
    private boolean peekedNext;
    
    public ObjChunkBy(final Iterator<? extends T> iterator, final Function<? super T, ? extends K> classifier) {
        this.iterator = iterator;
        this.classifier = classifier;
    }
    
    private T peek() {
        if (!this.peekedNext) {
            this.next = (T)this.iterator.next();
            this.peekedNext = true;
        }
        return this.next;
    }
    
    private T takeNext() {
        final T peek = this.peek();
        this.peekedNext = false;
        return peek;
    }
    
    @Override
    public boolean hasNext() {
        return this.peekedNext || this.iterator.hasNext();
    }
    
    @Override
    public List<T> nextIteration() {
        final K apply = (K)this.classifier.apply(this.peek());
        final ArrayList<Object> list = (ArrayList<Object>)new ArrayList<T>();
        do {
            list.add(this.takeNext());
        } while (this.iterator.hasNext() && apply.equals(this.classifier.apply(this.peek())));
        return (List<T>)list;
    }
}
