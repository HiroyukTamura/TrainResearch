// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import java.util.Iterator;
import com.annimon.stream.function.Consumer;
import com.annimon.stream.iterator.LsaIterator;

public class ObjPeek<T> extends LsaIterator<T>
{
    private final Consumer<? super T> action;
    private final Iterator<? extends T> iterator;
    
    public ObjPeek(final Iterator<? extends T> iterator, final Consumer<? super T> action) {
        this.iterator = iterator;
        this.action = action;
    }
    
    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }
    
    @Override
    public T nextIteration() {
        final T next = (T)this.iterator.next();
        this.action.accept((Object)next);
        return next;
    }
}
