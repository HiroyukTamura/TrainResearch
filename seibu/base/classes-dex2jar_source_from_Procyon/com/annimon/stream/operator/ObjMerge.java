// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import java.util.LinkedList;
import com.annimon.stream.function.BiFunction;
import java.util.Iterator;
import java.util.Queue;
import com.annimon.stream.iterator.LsaIterator;

public class ObjMerge<T> extends LsaIterator<T>
{
    private final Queue<T> buffer1;
    private final Queue<T> buffer2;
    private final Iterator<? extends T> iterator1;
    private final Iterator<? extends T> iterator2;
    private final BiFunction<? super T, ? super T, MergeResult> selector;
    
    public ObjMerge(final Iterator<? extends T> iterator1, final Iterator<? extends T> iterator2, final BiFunction<? super T, ? super T, MergeResult> selector) {
        this.iterator1 = iterator1;
        this.iterator2 = iterator2;
        this.selector = selector;
        this.buffer1 = new LinkedList<T>();
        this.buffer2 = new LinkedList<T>();
    }
    
    private T select(final T t, final T t2) {
        switch (this.selector.apply((Object)t, (Object)t2)) {
            default: {
                this.buffer1.add(t);
                return t2;
            }
            case TAKE_FIRST: {
                this.buffer2.add(t2);
                return t;
            }
        }
    }
    
    @Override
    public boolean hasNext() {
        return !this.buffer1.isEmpty() || !this.buffer2.isEmpty() || this.iterator1.hasNext() || this.iterator2.hasNext();
    }
    
    @Override
    public T nextIteration() {
        if (!this.buffer1.isEmpty()) {
            Object o;
            final T t = (T)(o = this.buffer1.poll());
            if (this.iterator2.hasNext()) {
                o = this.select(t, this.iterator2.next());
            }
            return (T)o;
        }
        if (!this.buffer2.isEmpty()) {
            final T poll = this.buffer2.poll();
            if (this.iterator1.hasNext()) {
                return (T)this.select(this.iterator1.next(), (T)poll);
            }
            return poll;
        }
        else {
            if (!this.iterator1.hasNext()) {
                return (T)this.iterator2.next();
            }
            if (!this.iterator2.hasNext()) {
                return (T)this.iterator1.next();
            }
            return this.select((T)this.iterator1.next(), (T)this.iterator2.next());
        }
    }
    
    public enum MergeResult
    {
        TAKE_FIRST, 
        TAKE_SECOND;
    }
}
