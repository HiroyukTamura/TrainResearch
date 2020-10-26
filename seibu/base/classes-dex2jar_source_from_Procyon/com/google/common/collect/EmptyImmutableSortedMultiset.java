// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.Iterator;
import com.google.common.base.Preconditions;
import java.util.SortedSet;
import java.util.Set;
import java.util.NavigableSet;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Comparator;

final class EmptyImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E>
{
    private final ImmutableSortedSet<E> elementSet;
    
    EmptyImmutableSortedMultiset(final Comparator<? super E> comparator) {
        this.elementSet = ImmutableSortedSet.emptySet(comparator);
    }
    
    @Override
    public ImmutableList<E> asList() {
        return ImmutableList.of();
    }
    
    @Override
    public boolean containsAll(final Collection<?> collection) {
        return collection.isEmpty();
    }
    
    @Override
    int copyIntoArray(final Object[] array, final int n) {
        return n;
    }
    
    @Override
    public int count(@Nullable final Object o) {
        return 0;
    }
    
    @Override
    public ImmutableSortedSet<E> elementSet() {
        return this.elementSet;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof Multiset && ((Multiset)o).isEmpty();
    }
    
    @Override
    public Entry<E> firstEntry() {
        return null;
    }
    
    @Override
    Entry<E> getEntry(final int n) {
        throw new AssertionError((Object)"should never be called");
    }
    
    @Override
    public ImmutableSortedMultiset<E> headMultiset(final E e, final BoundType boundType) {
        Preconditions.checkNotNull(e);
        Preconditions.checkNotNull(boundType);
        return this;
    }
    
    @Override
    boolean isPartialView() {
        return false;
    }
    
    @Override
    public UnmodifiableIterator<E> iterator() {
        return Iterators.emptyIterator();
    }
    
    @Override
    public Entry<E> lastEntry() {
        return null;
    }
    
    @Override
    public int size() {
        return 0;
    }
    
    @Override
    public ImmutableSortedMultiset<E> tailMultiset(final E e, final BoundType boundType) {
        Preconditions.checkNotNull(e);
        Preconditions.checkNotNull(boundType);
        return this;
    }
}
