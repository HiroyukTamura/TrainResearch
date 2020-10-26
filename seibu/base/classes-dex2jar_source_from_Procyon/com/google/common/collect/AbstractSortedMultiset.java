// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import javax.annotation.Nullable;
import java.util.SortedSet;
import java.util.Set;
import java.util.NavigableSet;
import java.util.Iterator;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
abstract class AbstractSortedMultiset<E> extends AbstractMultiset<E> implements SortedMultiset<E>
{
    @GwtTransient
    final Comparator<? super E> comparator;
    private transient SortedMultiset<E> descendingMultiset;
    
    AbstractSortedMultiset() {
        this((Comparator)Ordering.natural());
    }
    
    AbstractSortedMultiset(final Comparator<? super E> comparator) {
        this.comparator = Preconditions.checkNotNull(comparator);
    }
    
    @Override
    public Comparator<? super E> comparator() {
        return this.comparator;
    }
    
    SortedMultiset<E> createDescendingMultiset() {
        return new DescendingMultiset<E>() {
            @Override
            Iterator<Entry<E>> entryIterator() {
                return AbstractSortedMultiset.this.descendingEntryIterator();
            }
            
            @Override
            SortedMultiset<E> forwardMultiset() {
                return (SortedMultiset<E>)AbstractSortedMultiset.this;
            }
            
            @Override
            public Iterator<E> iterator() {
                return AbstractSortedMultiset.this.descendingIterator();
            }
        };
    }
    
    @Override
    NavigableSet<E> createElementSet() {
        return new SortedMultisets.NavigableElementSet<E>(this);
    }
    
    abstract Iterator<Entry<E>> descendingEntryIterator();
    
    Iterator<E> descendingIterator() {
        return Multisets.iteratorImpl(this.descendingMultiset());
    }
    
    @Override
    public SortedMultiset<E> descendingMultiset() {
        SortedMultiset<E> descendingMultiset;
        if ((descendingMultiset = this.descendingMultiset) == null) {
            descendingMultiset = this.createDescendingMultiset();
            this.descendingMultiset = descendingMultiset;
        }
        return descendingMultiset;
    }
    
    @Override
    public NavigableSet<E> elementSet() {
        return (NavigableSet<E>)(NavigableSet)super.elementSet();
    }
    
    @Override
    public Entry<E> firstEntry() {
        final Iterator<Entry<E>> entryIterator = this.entryIterator();
        if (entryIterator.hasNext()) {
            return (Entry<E>)(Multiset.Entry)entryIterator.next();
        }
        return null;
    }
    
    @Override
    public Entry<E> lastEntry() {
        final Iterator<Entry<E>> descendingEntryIterator = this.descendingEntryIterator();
        if (descendingEntryIterator.hasNext()) {
            return (Entry<E>)(Multiset.Entry)descendingEntryIterator.next();
        }
        return null;
    }
    
    @Override
    public Entry<E> pollFirstEntry() {
        final Iterator<Entry<E>> entryIterator = this.entryIterator();
        if (entryIterator.hasNext()) {
            final Multiset.Entry<E> entry = entryIterator.next();
            final Entry<E> immutableEntry = Multisets.immutableEntry(entry.getElement(), entry.getCount());
            entryIterator.remove();
            return immutableEntry;
        }
        return null;
    }
    
    @Override
    public Entry<E> pollLastEntry() {
        final Iterator<Entry<E>> descendingEntryIterator = this.descendingEntryIterator();
        if (descendingEntryIterator.hasNext()) {
            final Multiset.Entry<E> entry = (Multiset.Entry<E>)descendingEntryIterator.next();
            final Entry<E> immutableEntry = Multisets.immutableEntry((E)entry.getElement(), entry.getCount());
            descendingEntryIterator.remove();
            return immutableEntry;
        }
        return null;
    }
    
    @Override
    public SortedMultiset<E> subMultiset(@Nullable final E e, final BoundType boundType, @Nullable final E e2, final BoundType boundType2) {
        Preconditions.checkNotNull(boundType);
        Preconditions.checkNotNull(boundType2);
        return this.tailMultiset(e, boundType).headMultiset(e2, boundType2);
    }
}
