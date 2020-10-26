// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.IndexedPredicate;
import com.annimon.stream.iterator.IndexedIterator;
import com.annimon.stream.iterator.LsaExtIterator;

public class ObjDropWhileIndexed<T> extends LsaExtIterator<T>
{
    private final IndexedIterator<? extends T> iterator;
    private final IndexedPredicate<? super T> predicate;
    
    public ObjDropWhileIndexed(final IndexedIterator<? extends T> iterator, final IndexedPredicate<? super T> predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
    }
    
    @Override
    protected void nextIteration() {
        Label_0061: {
            if (this.isInit) {
                break Label_0061;
            }
            int index;
            do {
                final boolean hasNext = this.iterator.hasNext();
                this.hasNext = hasNext;
                if (!hasNext) {
                    break Label_0061;
                }
                index = this.iterator.getIndex();
                this.next = (T)this.iterator.next();
            } while (this.predicate.test(index, (Object)this.next));
            return;
        }
        this.hasNext = (this.hasNext && this.iterator.hasNext());
        if (this.hasNext) {
            this.next = (T)this.iterator.next();
        }
    }
}
