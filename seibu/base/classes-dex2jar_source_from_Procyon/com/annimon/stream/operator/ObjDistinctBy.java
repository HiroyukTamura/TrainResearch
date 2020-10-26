// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.operator;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;
import com.annimon.stream.function.Function;
import com.annimon.stream.iterator.LsaExtIterator;

public class ObjDistinctBy<T, K> extends LsaExtIterator<T>
{
    private final Function<? super T, ? extends K> classifier;
    private final Iterator<? extends T> iterator;
    private final Set<K> set;
    
    public ObjDistinctBy(final Iterator<? extends T> iterator, final Function<? super T, ? extends K> classifier) {
        this.iterator = iterator;
        this.classifier = classifier;
        this.set = new HashSet<K>();
    }
    
    @Override
    protected void nextIteration() {
        do {
            final boolean hasNext = this.iterator.hasNext();
            this.hasNext = hasNext;
            if (!hasNext) {
                break;
            }
            this.next = (T)this.iterator.next();
        } while (!this.set.add((K)this.classifier.apply((Object)this.next)));
    }
}
