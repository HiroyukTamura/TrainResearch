// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import com.annimon.stream.function.Predicate;
import java.util.Iterator;
import com.annimon.stream.iterator.LsaExtIterator;

public class ObjDropWhile<T> extends LsaExtIterator<T>
{
    private final Iterator<? extends T> iterator;
    private final Predicate<? super T> predicate;
    
    public ObjDropWhile(final Iterator<? extends T> iterator, final Predicate<? super T> predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
    }
    
    @Override
    protected void nextIteration() {
        Label_0056: {
            if (this.isInit) {
                break Label_0056;
            }
            do {
                final boolean hasNext = this.iterator.hasNext();
                this.hasNext = hasNext;
                if (!hasNext) {
                    break Label_0056;
                }
                this.next = (T)this.iterator.next();
            } while (this.predicate.test((Object)this.next));
            return;
        }
        this.hasNext = (this.hasNext && this.iterator.hasNext());
        if (this.hasNext) {
            this.next = (T)this.iterator.next();
        }
    }
}
