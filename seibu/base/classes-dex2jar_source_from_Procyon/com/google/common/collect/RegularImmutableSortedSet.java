// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;
import com.google.common.annotations.GwtIncompatible;
import java.util.Iterator;
import java.util.Collection;
import java.util.List;
import java.util.Collections;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true, serializable = true)
final class RegularImmutableSortedSet<E> extends ImmutableSortedSet<E>
{
    private final transient ImmutableList<E> elements;
    
    RegularImmutableSortedSet(final ImmutableList<E> elements, final Comparator<? super E> comparator) {
        super(comparator);
        this.elements = elements;
        Preconditions.checkArgument(!elements.isEmpty());
    }
    
    private int unsafeBinarySearch(final Object key) throws ClassCastException {
        return Collections.binarySearch(this.elements, key, this.unsafeComparator());
    }
    
    @Override
    public E ceiling(final E e) {
        final int tailIndex = this.tailIndex(e, true);
        if (tailIndex == this.size()) {
            return null;
        }
        return (E)this.elements.get(tailIndex);
    }
    
    @Override
    public boolean contains(final Object o) {
        boolean b = false;
        if (o == null) {
            return b;
        }
        try {
            final int unsafeBinarySearch = this.unsafeBinarySearch(o);
            b = b;
            if (unsafeBinarySearch >= 0) {
                b = true;
            }
            return b;
        }
        catch (ClassCastException ex) {
            return false;
        }
    }
    
    @Override
    public boolean containsAll(final Collection<?> collection) {
        final boolean b = true;
        Object elementSet = collection;
        if (collection instanceof Multiset) {
            elementSet = ((Multiset<?>)collection).elementSet();
        }
        boolean containsAll;
        if (!SortedIterables.hasSameComparator(this.comparator(), (Iterable<?>)elementSet) || ((Collection)elementSet).size() <= 1) {
            containsAll = super.containsAll((Collection<?>)elementSet);
        }
        else {
            final PeekingIterator<Object> peekingIterator = Iterators.peekingIterator((Iterator<?>)this.iterator());
            final Iterator<?> iterator = ((Collection<?>)elementSet).iterator();
            Object o = iterator.next();
            try {
                while (peekingIterator.hasNext()) {
                    final int unsafeCompare = this.unsafeCompare(peekingIterator.peek(), o);
                    if (unsafeCompare < 0) {
                        peekingIterator.next();
                    }
                    else if (unsafeCompare == 0) {
                        containsAll = b;
                        if (!iterator.hasNext()) {
                            return containsAll;
                        }
                        o = iterator.next();
                    }
                    else {
                        if (unsafeCompare > 0) {
                            return false;
                        }
                        continue;
                    }
                }
                goto Label_0157;
            }
            catch (ClassCastException ex) {
                return false;
            }
            catch (NullPointerException ex2) {
                return false;
            }
        }
        return containsAll;
    }
    
    @Override
    int copyIntoArray(final Object[] array, final int n) {
        return this.elements.copyIntoArray(array, n);
    }
    
    @Override
    ImmutableList<E> createAsList() {
        return new ImmutableSortedAsList<E>(this, this.elements);
    }
    
    @Override
    ImmutableSortedSet<E> createDescendingSet() {
        return new RegularImmutableSortedSet((ImmutableList<Object>)this.elements.reverse(), Ordering.from(this.comparator).reverse());
    }
    
    @GwtIncompatible("NavigableSet")
    @Override
    public UnmodifiableIterator<E> descendingIterator() {
        return this.elements.reverse().iterator();
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (o != this) {
            if (!(o instanceof Set)) {
                return false;
            }
            final Set set = (Set)o;
            if (this.size() != set.size()) {
                return false;
            }
            if (SortedIterables.hasSameComparator(this.comparator, set)) {
                final Iterator<?> iterator = set.iterator();
                try {
                    for (final Object next : this) {
                        final Object next2 = iterator.next();
                        if (next2 == null || this.unsafeCompare(next, next2) != 0) {
                            return false;
                        }
                    }
                    return true;
                }
                catch (ClassCastException ex) {
                    return false;
                }
                catch (NoSuchElementException ex2) {
                    return false;
                }
            }
            return this.containsAll(set);
        }
        return true;
    }
    
    @Override
    public E first() {
        return this.elements.get(0);
    }
    
    @Override
    public E floor(final E e) {
        final int n = this.headIndex(e, true) - 1;
        if (n == -1) {
            return null;
        }
        return (E)this.elements.get(n);
    }
    
    ImmutableSortedSet<E> getSubSet(final int n, final int n2) {
        if (n == 0 && n2 == this.size()) {
            return this;
        }
        if (n < n2) {
            return new RegularImmutableSortedSet((ImmutableList<Object>)this.elements.subList(n, n2), (Comparator<? super Object>)this.comparator);
        }
        return ImmutableSortedSet.emptySet(this.comparator);
    }
    
    int headIndex(final E e, final boolean b) {
        final ImmutableList<E> elements = this.elements;
        final E checkNotNull = Preconditions.checkNotNull(e);
        final Comparator<? super E> comparator = this.comparator();
        SortedLists.KeyPresentBehavior keyPresentBehavior;
        if (b) {
            keyPresentBehavior = SortedLists.KeyPresentBehavior.FIRST_AFTER;
        }
        else {
            keyPresentBehavior = SortedLists.KeyPresentBehavior.FIRST_PRESENT;
        }
        return SortedLists.binarySearch((List<? extends E>)elements, checkNotNull, comparator, keyPresentBehavior, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
    }
    
    @Override
    ImmutableSortedSet<E> headSetImpl(final E e, final boolean b) {
        return this.getSubSet(0, this.headIndex(e, b));
    }
    
    @Override
    public E higher(final E e) {
        final int tailIndex = this.tailIndex(e, false);
        if (tailIndex == this.size()) {
            return null;
        }
        return (E)this.elements.get(tailIndex);
    }
    
    @Override
    int indexOf(@Nullable final Object o) {
        if (o == null) {
            return -1;
        }
        while (true) {
            try {
                final int binarySearch = SortedLists.binarySearch(this.elements, o, this.unsafeComparator(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.INVERTED_INSERTION_INDEX);
                if (binarySearch >= 0) {
                    return binarySearch;
                }
            }
            catch (ClassCastException ex) {
                return -1;
            }
            return -1;
        }
    }
    
    @Override
    public boolean isEmpty() {
        return false;
    }
    
    @Override
    boolean isPartialView() {
        return this.elements.isPartialView();
    }
    
    @Override
    public UnmodifiableIterator<E> iterator() {
        return this.elements.iterator();
    }
    
    @Override
    public E last() {
        return this.elements.get(this.size() - 1);
    }
    
    @Override
    public E lower(final E e) {
        final int n = this.headIndex(e, false) - 1;
        if (n == -1) {
            return null;
        }
        return (E)this.elements.get(n);
    }
    
    @Override
    public int size() {
        return this.elements.size();
    }
    
    @Override
    ImmutableSortedSet<E> subSetImpl(final E e, final boolean b, final E e2, final boolean b2) {
        return this.tailSetImpl(e, b).headSetImpl(e2, b2);
    }
    
    int tailIndex(final E e, final boolean b) {
        final ImmutableList<E> elements = this.elements;
        final E checkNotNull = Preconditions.checkNotNull(e);
        final Comparator<? super E> comparator = this.comparator();
        SortedLists.KeyPresentBehavior keyPresentBehavior;
        if (b) {
            keyPresentBehavior = SortedLists.KeyPresentBehavior.FIRST_PRESENT;
        }
        else {
            keyPresentBehavior = SortedLists.KeyPresentBehavior.FIRST_AFTER;
        }
        return SortedLists.binarySearch((List<? extends E>)elements, checkNotNull, comparator, keyPresentBehavior, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
    }
    
    @Override
    ImmutableSortedSet<E> tailSetImpl(final E e, final boolean b) {
        return this.getSubSet(this.tailIndex(e, b), this.size());
    }
    
    Comparator<Object> unsafeComparator() {
        return (Comparator<Object>)this.comparator;
    }
}
