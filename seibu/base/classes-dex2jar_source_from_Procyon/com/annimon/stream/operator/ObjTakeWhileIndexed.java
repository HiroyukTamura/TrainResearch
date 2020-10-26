// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.IndexedPredicate;
import com.annimon.stream.iterator.IndexedIterator;
import com.annimon.stream.iterator.LsaExtIterator;

public class ObjTakeWhileIndexed<T> extends LsaExtIterator<T>
{
    private final IndexedIterator<? extends T> iterator;
    private final IndexedPredicate<? super T> predicate;
    
    public ObjTakeWhileIndexed(final IndexedIterator<? extends T> iterator, final IndexedPredicate<? super T> predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
    }
    
    @Override
    protected void nextIteration() {
        while (true) {
            Label_0058: {
                if (!this.iterator.hasNext()) {
                    break Label_0058;
                }
                final IndexedPredicate<? super T> predicate = this.predicate;
                final int index = this.iterator.getIndex();
                final T next = (T)this.iterator.next();
                this.next = next;
                if (!predicate.test(index, next)) {
                    break Label_0058;
                }
                final boolean hasNext = true;
                this.hasNext = hasNext;
                return;
            }
            final boolean hasNext = false;
            continue;
        }
    }
}
