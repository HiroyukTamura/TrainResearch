// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.base;

import javax.annotation.Nullable;
import java.util.Iterator;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

@GwtCompatible(serializable = true)
final class PairwiseEquivalence<T> extends Equivalence<Iterable<T>> implements Serializable
{
    private static final long serialVersionUID = 1L;
    final Equivalence<? super T> elementEquivalence;
    
    PairwiseEquivalence(final Equivalence<? super T> equivalence) {
        this.elementEquivalence = Preconditions.checkNotNull(equivalence);
    }
    
    @Override
    protected boolean doEquivalent(final Iterable<T> iterable, final Iterable<T> iterable2) {
        final Iterator<T> iterator = iterable.iterator();
        final Iterator<T> iterator2 = iterable2.iterator();
        while (iterator.hasNext() && iterator2.hasNext()) {
            if (!this.elementEquivalence.equivalent((Object)iterator.next(), (Object)iterator2.next())) {
                return false;
            }
        }
        if (!iterator.hasNext() && !iterator2.hasNext()) {
            return true;
        }
        return false;
    }
    
    @Override
    protected int doHash(final Iterable<T> iterable) {
        int n = 78721;
        final Iterator<T> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            n = n * 24943 + this.elementEquivalence.hash((Object)iterator.next());
        }
        return n;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof PairwiseEquivalence && this.elementEquivalence.equals(((PairwiseEquivalence)o).elementEquivalence);
    }
    
    @Override
    public int hashCode() {
        return this.elementEquivalence.hashCode() ^ 0x46A3EB07;
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(String.valueOf(this.elementEquivalence));
        return new StringBuilder(value.length() + 11).append(value).append(".pairwise()").toString();
    }
}
