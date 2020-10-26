// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import java.util.Iterator;
import com.annimon.stream.function.BiFunction;
import com.annimon.stream.iterator.LsaExtIterator;

public class ObjScan<T> extends LsaExtIterator<T>
{
    private final BiFunction<T, T, T> accumulator;
    private final Iterator<? extends T> iterator;
    
    public ObjScan(final Iterator<? extends T> iterator, final BiFunction<T, T, T> accumulator) {
        this.iterator = iterator;
        this.accumulator = accumulator;
    }
    
    @Override
    protected void nextIteration() {
        this.hasNext = this.iterator.hasNext();
        if (this.hasNext) {
            final T next = (T)this.iterator.next();
            if (!this.isInit) {
                this.next = next;
                return;
            }
            this.next = this.accumulator.apply(this.next, next);
        }
    }
}
