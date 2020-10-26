// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.IndexedPredicate;
import com.annimon.stream.iterator.IndexedIterator;
import com.annimon.stream.iterator.LsaExtIterator;

public class ObjTakeUntilIndexed<T> extends LsaExtIterator<T>
{
    private final IndexedIterator<? extends T> iterator;
    private final IndexedPredicate<? super T> stopPredicate;
    
    public ObjTakeUntilIndexed(final IndexedIterator<? extends T> iterator, final IndexedPredicate<? super T> stopPredicate) {
        this.iterator = iterator;
        this.stopPredicate = stopPredicate;
    }
    
    @Override
    protected void nextIteration() {
        this.hasNext = (this.iterator.hasNext() && (!this.isInit || !this.stopPredicate.test(this.iterator.getIndex(), (Object)this.next)));
        if (this.hasNext) {
            this.next = (T)this.iterator.next();
        }
    }
}
