// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.Predicate;
import java.util.Iterator;
import com.annimon.stream.iterator.LsaExtIterator;

public class ObjTakeWhile<T> extends LsaExtIterator<T>
{
    private final Iterator<? extends T> iterator;
    private final Predicate<? super T> predicate;
    
    public ObjTakeWhile(final Iterator<? extends T> iterator, final Predicate<? super T> predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
    }
    
    @Override
    protected void nextIteration() {
        while (true) {
            Label_0050: {
                if (!this.iterator.hasNext()) {
                    break Label_0050;
                }
                final Predicate<? super T> predicate = this.predicate;
                final T next = (T)this.iterator.next();
                this.next = next;
                if (!predicate.test(next)) {
                    break Label_0050;
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
