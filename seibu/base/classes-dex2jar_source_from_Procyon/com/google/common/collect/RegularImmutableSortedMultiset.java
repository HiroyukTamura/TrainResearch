// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import com.google.common.primitives.Ints;
import com.google.common.base.Preconditions;
import java.util.SortedSet;
import java.util.Set;
import java.util.NavigableSet;
import javax.annotation.Nullable;

final class RegularImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E>
{
    private final transient int[] counts;
    private final transient long[] cumulativeCounts;
    private final transient RegularImmutableSortedSet<E> elementSet;
    private final transient int length;
    private final transient int offset;
    
    RegularImmutableSortedMultiset(final RegularImmutableSortedSet<E> elementSet, final int[] counts, final long[] cumulativeCounts, final int offset, final int length) {
        this.elementSet = elementSet;
        this.counts = counts;
        this.cumulativeCounts = cumulativeCounts;
        this.offset = offset;
        this.length = length;
    }
    
    @Override
    public int count(@Nullable final Object o) {
        final int index = this.elementSet.indexOf(o);
        if (index == -1) {
            return 0;
        }
        return this.counts[this.offset + index];
    }
    
    @Override
    public ImmutableSortedSet<E> elementSet() {
        return this.elementSet;
    }
    
    @Override
    public Entry<E> firstEntry() {
        return this.getEntry(0);
    }
    
    @Override
    Entry<E> getEntry(final int n) {
        return Multisets.immutableEntry(this.elementSet.asList().get(n), this.counts[this.offset + n]);
    }
    
    ImmutableSortedMultiset<E> getSubMultiset(final int n, final int n2) {
        Preconditions.checkPositionIndexes(n, n2, this.length);
        if (n != n2) {
            if (n == 0) {
                final ImmutableSortedMultiset<E> emptyMultiset = this;
                if (n2 == this.length) {
                    return emptyMultiset;
                }
            }
            return new RegularImmutableSortedMultiset((RegularImmutableSortedSet)this.elementSet.getSubSet(n, n2), this.counts, this.cumulativeCounts, this.offset + n, n2 - n);
        }
        return ImmutableSortedMultiset.emptyMultiset(this.comparator());
    }
    
    @Override
    public ImmutableSortedMultiset<E> headMultiset(final E e, final BoundType boundType) {
        return this.getSubMultiset(0, this.elementSet.headIndex(e, Preconditions.checkNotNull(boundType) == BoundType.CLOSED));
    }
    
    @Override
    boolean isPartialView() {
        return this.offset > 0 || this.length < this.counts.length;
    }
    
    @Override
    public Entry<E> lastEntry() {
        return this.getEntry(this.length - 1);
    }
    
    @Override
    public int size() {
        return Ints.saturatedCast(this.cumulativeCounts[this.offset + this.length] - this.cumulativeCounts[this.offset]);
    }
    
    @Override
    public ImmutableSortedMultiset<E> tailMultiset(final E e, final BoundType boundType) {
        return this.getSubMultiset(this.elementSet.tailIndex(e, Preconditions.checkNotNull(boundType) == BoundType.CLOSED), this.length);
    }
}
