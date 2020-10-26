// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.Predicate;
import java.util.Iterator;
import com.annimon.stream.iterator.LsaExtIterator;

public class ObjTakeUntil<T> extends LsaExtIterator<T>
{
    private final Iterator<? extends T> iterator;
    private final Predicate<? super T> stopPredicate;
    
    public ObjTakeUntil(final Iterator<? extends T> iterator, final Predicate<? super T> stopPredicate) {
        this.iterator = iterator;
        this.stopPredicate = stopPredicate;
    }
    
    @Override
    protected void nextIteration() {
        this.hasNext = (this.iterator.hasNext() && (!this.isInit || !this.stopPredicate.test((Object)this.next)));
        if (this.hasNext) {
            this.next = (T)this.iterator.next();
        }
    }
}
