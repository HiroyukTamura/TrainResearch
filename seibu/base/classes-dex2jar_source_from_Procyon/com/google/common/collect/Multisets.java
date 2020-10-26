// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.Collections;
import java.util.NoSuchElementException;
import java.io.Serializable;
import com.google.common.base.Objects;
import java.util.Set;
import com.google.common.base.Predicates;
import com.google.common.base.Predicate;
import javax.annotation.Nullable;
import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Collection;
import com.google.common.primitives.Ints;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public final class Multisets
{
    private static final Ordering<Multiset.Entry<?>> DECREASING_COUNT_ORDERING;
    
    static {
        DECREASING_COUNT_ORDERING = new Ordering<Multiset.Entry<?>>() {
            @Override
            public int compare(final Multiset.Entry<?> entry, final Multiset.Entry<?> entry2) {
                return Ints.compare(entry2.getCount(), entry.getCount());
            }
        };
    }
    
    private Multisets() {
    }
    
    static <E> boolean addAllImpl(final Multiset<E> multiset, final Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        if (collection instanceof Multiset) {
            for (final Multiset.Entry<Object> entry : cast((Iterable<Object>)collection).entrySet()) {
                multiset.add(entry.getElement(), entry.getCount());
            }
        }
        else {
            Iterators.addAll(multiset, collection.iterator());
        }
        return true;
    }
    
    static <T> Multiset<T> cast(final Iterable<T> iterable) {
        return (Multiset<T>)iterable;
    }
    
    public static boolean containsOccurrences(final Multiset<?> multiset, final Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        for (final Multiset.Entry<Object> entry : multiset2.entrySet()) {
            if (multiset.count(entry.getElement()) < entry.getCount()) {
                return false;
            }
        }
        return true;
    }
    
    @Beta
    public static <E> ImmutableMultiset<E> copyHighestCountFirst(final Multiset<E> multiset) {
        return ImmutableMultiset.copyFromEntries((Collection<? extends Multiset.Entry<? extends E>>)Multisets.DECREASING_COUNT_ORDERING.immutableSortedCopy(multiset.entrySet()));
    }
    
    @Beta
    public static <E> Multiset<E> difference(final Multiset<E> multiset, final Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        return new AbstractMultiset<E>() {
            @Override
            public int count(@Nullable final Object o) {
                final int count = multiset.count(o);
                if (count == 0) {
                    return 0;
                }
                return Math.max(0, count - multiset2.count(o));
            }
            
            @Override
            int distinctElements() {
                return Iterators.size(this.entryIterator());
            }
            
            @Override
            Iterator<Entry<E>> entryIterator() {
                return new AbstractIterator<Entry<E>>() {
                    final /* synthetic */ Iterator val$iterator1 = multiset.entrySet().iterator();
                    
                    @Override
                    protected Entry<E> computeNext() {
                        while (this.val$iterator1.hasNext()) {
                            final Multiset.Entry<Object> entry = this.val$iterator1.next();
                            final E element = entry.getElement();
                            final int n = entry.getCount() - multiset2.count(element);
                            if (n > 0) {
                                return Multisets.immutableEntry(element, n);
                            }
                        }
                        return (Entry<E>)((AbstractIterator<Multiset.Entry>)this).endOfData();
                    }
                };
            }
        };
    }
    
    static boolean equalsImpl(final Multiset<?> multiset, @Nullable final Object o) {
        if (o != multiset) {
            if (!(o instanceof Multiset)) {
                return false;
            }
            final Multiset multiset2 = (Multiset)o;
            if (multiset.size() != multiset2.size() || multiset.entrySet().size() != multiset2.entrySet().size()) {
                return false;
            }
            for (final Multiset.Entry<Object> entry : multiset2.entrySet()) {
                if (multiset.count(entry.getElement()) != entry.getCount()) {
                    return false;
                }
            }
        }
        return true;
    }
    
    @Beta
    public static <E> Multiset<E> filter(final Multiset<E> multiset, final Predicate<? super E> predicate) {
        if (multiset instanceof FilteredMultiset) {
            final FilteredMultiset filteredMultiset = (FilteredMultiset<E>)multiset;
            return new FilteredMultiset<E>((Multiset<Object>)filteredMultiset.unfiltered, Predicates.and((Predicate<? super Object>)filteredMultiset.predicate, (Predicate<? super Object>)predicate));
        }
        return new FilteredMultiset<E>(multiset, predicate);
    }
    
    public static <E> Multiset.Entry<E> immutableEntry(@Nullable final E e, final int n) {
        return new ImmutableEntry<E>(e, n);
    }
    
    static int inferDistinctElements(final Iterable<?> iterable) {
        if (iterable instanceof Multiset) {
            return ((Multiset)iterable).elementSet().size();
        }
        return 11;
    }
    
    public static <E> Multiset<E> intersection(final Multiset<E> multiset, final Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        return new AbstractMultiset<E>() {
            @Override
            public int count(final Object o) {
                final int count = multiset.count(o);
                if (count == 0) {
                    return 0;
                }
                return Math.min(count, multiset2.count(o));
            }
            
            @Override
            Set<E> createElementSet() {
                return (Set<E>)Sets.intersection(multiset.elementSet(), multiset2.elementSet());
            }
            
            @Override
            int distinctElements() {
                return this.elementSet().size();
            }
            
            @Override
            Iterator<Entry<E>> entryIterator() {
                return new AbstractIterator<Entry<E>>() {
                    final /* synthetic */ Iterator val$iterator1 = multiset.entrySet().iterator();
                    
                    @Override
                    protected Entry<E> computeNext() {
                        while (this.val$iterator1.hasNext()) {
                            final Multiset.Entry<Object> entry = this.val$iterator1.next();
                            final E element = entry.getElement();
                            final int min = Math.min(entry.getCount(), multiset2.count(element));
                            if (min > 0) {
                                return Multisets.immutableEntry(element, min);
                            }
                        }
                        return (Entry<E>)((AbstractIterator<Multiset.Entry>)this).endOfData();
                    }
                };
            }
        };
    }
    
    static <E> Iterator<E> iteratorImpl(final Multiset<E> multiset) {
        return new MultisetIteratorImpl<E>(multiset, multiset.entrySet().iterator());
    }
    
    static boolean removeAllImpl(final Multiset<?> multiset, Collection<?> elementSet) {
        if (elementSet instanceof Multiset) {
            elementSet = ((Multiset<?>)elementSet).elementSet();
        }
        return multiset.elementSet().removeAll(elementSet);
    }
    
    public static boolean removeOccurrences(final Multiset<?> multiset, final Iterable<?> iterable) {
        if (iterable instanceof Multiset) {
            return removeOccurrencesImpl(multiset, (Multiset<?>)iterable);
        }
        return removeOccurrencesImpl(multiset, iterable);
    }
    
    private static <E> boolean removeOccurrencesImpl(final Multiset<E> multiset, final Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        boolean b = false;
        final Iterator<Multiset.Entry<E>> iterator = multiset.entrySet().iterator();
        while (iterator.hasNext()) {
            final Multiset.Entry<E> entry = iterator.next();
            final int count = multiset2.count(entry.getElement());
            if (count >= entry.getCount()) {
                iterator.remove();
                b = true;
            }
            else {
                if (count <= 0) {
                    continue;
                }
                multiset.remove(entry.getElement(), count);
                b = true;
            }
        }
        return b;
    }
    
    private static boolean removeOccurrencesImpl(final Multiset<?> multiset, final Iterable<?> iterable) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(iterable);
        boolean b = false;
        final Iterator<?> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            b |= multiset.remove(iterator.next());
        }
        return b;
    }
    
    static boolean retainAllImpl(final Multiset<?> multiset, Collection<?> elementSet) {
        Preconditions.checkNotNull(elementSet);
        if (elementSet instanceof Multiset) {
            elementSet = ((Multiset<?>)elementSet).elementSet();
        }
        return multiset.elementSet().retainAll(elementSet);
    }
    
    public static boolean retainOccurrences(final Multiset<?> multiset, final Multiset<?> multiset2) {
        return retainOccurrencesImpl(multiset, multiset2);
    }
    
    private static <E> boolean retainOccurrencesImpl(final Multiset<E> multiset, final Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        final Iterator<Multiset.Entry<E>> iterator = multiset.entrySet().iterator();
        boolean b = false;
        while (iterator.hasNext()) {
            final Multiset.Entry<E> entry = iterator.next();
            final int count = multiset2.count(entry.getElement());
            if (count == 0) {
                iterator.remove();
                b = true;
            }
            else {
                if (count >= entry.getCount()) {
                    continue;
                }
                multiset.setCount(entry.getElement(), count);
                b = true;
            }
        }
        return b;
    }
    
    static <E> int setCountImpl(final Multiset<E> multiset, final E e, int n) {
        CollectPreconditions.checkNonnegative(n, "count");
        final int count = multiset.count(e);
        n -= count;
        if (n > 0) {
            multiset.add(e, n);
        }
        else if (n < 0) {
            multiset.remove(e, -n);
            return count;
        }
        return count;
    }
    
    static <E> boolean setCountImpl(final Multiset<E> multiset, final E e, final int n, final int n2) {
        CollectPreconditions.checkNonnegative(n, "oldCount");
        CollectPreconditions.checkNonnegative(n2, "newCount");
        if (multiset.count(e) == n) {
            multiset.setCount(e, n2);
            return true;
        }
        return false;
    }
    
    static int sizeImpl(final Multiset<?> multiset) {
        long n = 0L;
        final Iterator<Multiset.Entry<?>> iterator = multiset.entrySet().iterator();
        while (iterator.hasNext()) {
            n += iterator.next().getCount();
        }
        return Ints.saturatedCast(n);
    }
    
    @Beta
    public static <E> Multiset<E> sum(final Multiset<? extends E> multiset, final Multiset<? extends E> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        return new AbstractMultiset<E>() {
            @Override
            public boolean contains(@Nullable final Object o) {
                return multiset.contains(o) || multiset2.contains(o);
            }
            
            @Override
            public int count(final Object o) {
                return multiset.count(o) + multiset2.count(o);
            }
            
            @Override
            Set<E> createElementSet() {
                return (Set<E>)Sets.union(multiset.elementSet(), multiset2.elementSet());
            }
            
            @Override
            int distinctElements() {
                return this.elementSet().size();
            }
            
            @Override
            Iterator<Entry<E>> entryIterator() {
                return new AbstractIterator<Entry<E>>() {
                    final /* synthetic */ Iterator val$iterator1 = multiset.entrySet().iterator();
                    final /* synthetic */ Iterator val$iterator2 = multiset2.entrySet().iterator();
                    
                    @Override
                    protected Entry<E> computeNext() {
                        if (this.val$iterator1.hasNext()) {
                            final Multiset.Entry<Object> entry = this.val$iterator1.next();
                            final E element = entry.getElement();
                            return Multisets.immutableEntry(element, entry.getCount() + multiset2.count(element));
                        }
                        while (this.val$iterator2.hasNext()) {
                            final Multiset.Entry<Object> entry2 = this.val$iterator2.next();
                            final E element2 = entry2.getElement();
                            if (!multiset.contains(element2)) {
                                return Multisets.immutableEntry(element2, entry2.getCount());
                            }
                        }
                        return (Entry<E>)((AbstractIterator<Multiset.Entry>)this).endOfData();
                    }
                };
            }
            
            @Override
            public boolean isEmpty() {
                return multiset.isEmpty() && multiset2.isEmpty();
            }
            
            @Override
            public int size() {
                return multiset.size() + multiset2.size();
            }
        };
    }
    
    @Beta
    public static <E> Multiset<E> union(final Multiset<? extends E> multiset, final Multiset<? extends E> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        return new AbstractMultiset<E>() {
            @Override
            public boolean contains(@Nullable final Object o) {
                return multiset.contains(o) || multiset2.contains(o);
            }
            
            @Override
            public int count(final Object o) {
                return Math.max(multiset.count(o), multiset2.count(o));
            }
            
            @Override
            Set<E> createElementSet() {
                return (Set<E>)Sets.union(multiset.elementSet(), multiset2.elementSet());
            }
            
            @Override
            int distinctElements() {
                return this.elementSet().size();
            }
            
            @Override
            Iterator<Entry<E>> entryIterator() {
                return new AbstractIterator<Entry<E>>() {
                    final /* synthetic */ Iterator val$iterator1 = multiset.entrySet().iterator();
                    final /* synthetic */ Iterator val$iterator2 = multiset2.entrySet().iterator();
                    
                    @Override
                    protected Entry<E> computeNext() {
                        if (this.val$iterator1.hasNext()) {
                            final Multiset.Entry<Object> entry = this.val$iterator1.next();
                            final E element = entry.getElement();
                            return Multisets.immutableEntry(element, Math.max(entry.getCount(), multiset2.count(element)));
                        }
                        while (this.val$iterator2.hasNext()) {
                            final Multiset.Entry<Object> entry2 = this.val$iterator2.next();
                            final E element2 = entry2.getElement();
                            if (!multiset.contains(element2)) {
                                return Multisets.immutableEntry(element2, entry2.getCount());
                            }
                        }
                        return (Entry<E>)((AbstractIterator<Multiset.Entry>)this).endOfData();
                    }
                };
            }
            
            @Override
            public boolean isEmpty() {
                return multiset.isEmpty() && multiset2.isEmpty();
            }
        };
    }
    
    @Deprecated
    public static <E> Multiset<E> unmodifiableMultiset(final ImmutableMultiset<E> immutableMultiset) {
        return Preconditions.checkNotNull(immutableMultiset);
    }
    
    public static <E> Multiset<E> unmodifiableMultiset(final Multiset<? extends E> multiset) {
        if (multiset instanceof UnmodifiableMultiset || multiset instanceof ImmutableMultiset) {
            return (Multiset<E>)multiset;
        }
        return new UnmodifiableMultiset<E>((Multiset<? extends E>)Preconditions.checkNotNull((Multiset<E>)multiset));
    }
    
    @Beta
    public static <E> SortedMultiset<E> unmodifiableSortedMultiset(final SortedMultiset<E> sortedMultiset) {
        return new UnmodifiableSortedMultiset<E>(Preconditions.checkNotNull(sortedMultiset));
    }
    
    abstract static class AbstractEntry<E> implements Entry<E>
    {
        @Override
        public boolean equals(@Nullable final Object o) {
            boolean b2;
            final boolean b = b2 = false;
            if (o instanceof Entry) {
                final Entry entry = (Entry)o;
                b2 = b;
                if (this.getCount() == entry.getCount()) {
                    b2 = b;
                    if (Objects.equal(this.getElement(), entry.getElement())) {
                        b2 = true;
                    }
                }
            }
            return b2;
        }
        
        @Override
        public int hashCode() {
            final Object element = this.getElement();
            int hashCode;
            if (element == null) {
                hashCode = 0;
            }
            else {
                hashCode = element.hashCode();
            }
            return hashCode ^ this.getCount();
        }
        
        @Override
        public String toString() {
            final String value = String.valueOf(this.getElement());
            final int count = this.getCount();
            if (count == 1) {
                return value;
            }
            final String value2 = String.valueOf(String.valueOf(value));
            return new StringBuilder(value2.length() + 14).append(value2).append(" x ").append(count).toString();
        }
    }
    
    abstract static class ElementSet<E> extends ImprovedAbstractSet<E>
    {
        @Override
        public void clear() {
            this.multiset().clear();
        }
        
        @Override
        public boolean contains(final Object o) {
            return this.multiset().contains(o);
        }
        
        @Override
        public boolean containsAll(final Collection<?> collection) {
            return this.multiset().containsAll(collection);
        }
        
        @Override
        public boolean isEmpty() {
            return this.multiset().isEmpty();
        }
        
        @Override
        public Iterator<E> iterator() {
            return new TransformedIterator<Multiset.Entry<E>, E>(this.multiset().entrySet().iterator()) {
                @Override
                E transform(final Multiset.Entry<E> entry) {
                    return entry.getElement();
                }
            };
        }
        
        abstract Multiset<E> multiset();
        
        @Override
        public boolean remove(final Object o) {
            final int count = this.multiset().count(o);
            if (count > 0) {
                this.multiset().remove(o, count);
                return true;
            }
            return false;
        }
        
        @Override
        public int size() {
            return this.multiset().entrySet().size();
        }
    }
    
    abstract static class EntrySet<E> extends ImprovedAbstractSet<Multiset.Entry<E>>
    {
        @Override
        public void clear() {
            this.multiset().clear();
        }
        
        @Override
        public boolean contains(@Nullable final Object o) {
            if (o instanceof Multiset.Entry) {
                final Multiset.Entry entry = (Multiset.Entry)o;
                if (entry.getCount() > 0 && this.multiset().count(entry.getElement()) == entry.getCount()) {
                    return true;
                }
            }
            return false;
        }
        
        abstract Multiset<E> multiset();
        
        @Override
        public boolean remove(final Object o) {
            boolean setCount = false;
            if (o instanceof Multiset.Entry) {
                final Multiset.Entry entry = (Multiset.Entry)o;
                final E element = entry.getElement();
                final int count = entry.getCount();
                setCount = setCount;
                if (count != 0) {
                    setCount = this.multiset().setCount(element, count, 0);
                }
            }
            return setCount;
        }
    }
    
    private static final class FilteredMultiset<E> extends AbstractMultiset<E>
    {
        final Predicate<? super E> predicate;
        final Multiset<E> unfiltered;
        
        FilteredMultiset(final Multiset<E> multiset, final Predicate<? super E> predicate) {
            this.unfiltered = Preconditions.checkNotNull(multiset);
            this.predicate = Preconditions.checkNotNull(predicate);
        }
        
        @Override
        public int add(@Nullable final E e, final int n) {
            Preconditions.checkArgument(this.predicate.apply((Object)e), "Element %s does not match predicate %s", e, this.predicate);
            return this.unfiltered.add(e, n);
        }
        
        @Override
        public void clear() {
            this.elementSet().clear();
        }
        
        @Override
        public int count(@Nullable final Object o) {
            final int count = this.unfiltered.count(o);
            if (count <= 0) {
                return 0;
            }
            if (this.predicate.apply((Object)o)) {
                return count;
            }
            return 0;
        }
        
        @Override
        Set<E> createElementSet() {
            return Sets.filter(this.unfiltered.elementSet(), this.predicate);
        }
        
        @Override
        Set<Entry<E>> createEntrySet() {
            return Sets.filter(this.unfiltered.entrySet(), (Predicate<? super Entry<E>>)new Predicate<Entry<E>>() {
                @Override
                public boolean apply(final Entry<E> entry) {
                    return FilteredMultiset.this.predicate.apply((Object)entry.getElement());
                }
            });
        }
        
        @Override
        int distinctElements() {
            return this.elementSet().size();
        }
        
        @Override
        Iterator<Entry<E>> entryIterator() {
            throw new AssertionError((Object)"should never be called");
        }
        
        @Override
        public UnmodifiableIterator<E> iterator() {
            return Iterators.filter(this.unfiltered.iterator(), this.predicate);
        }
        
        @Override
        public int remove(@Nullable final Object o, final int n) {
            CollectPreconditions.checkNonnegative(n, "occurrences");
            if (n == 0) {
                return this.count(o);
            }
            if (this.contains(o)) {
                return this.unfiltered.remove(o, n);
            }
            return 0;
        }
    }
    
    static final class ImmutableEntry<E> extends AbstractEntry<E> implements Serializable
    {
        private static final long serialVersionUID = 0L;
        final int count;
        @Nullable
        final E element;
        
        ImmutableEntry(@Nullable final E element, final int count) {
            this.element = element;
            CollectPreconditions.checkNonnegative(this.count = count, "count");
        }
        
        @Override
        public int getCount() {
            return this.count;
        }
        
        @Nullable
        @Override
        public E getElement() {
            return this.element;
        }
    }
    
    static final class MultisetIteratorImpl<E> implements Iterator<E>
    {
        private boolean canRemove;
        private Multiset.Entry<E> currentEntry;
        private final Iterator<Multiset.Entry<E>> entryIterator;
        private int laterCount;
        private final Multiset<E> multiset;
        private int totalCount;
        
        MultisetIteratorImpl(final Multiset<E> multiset, final Iterator<Multiset.Entry<E>> entryIterator) {
            this.multiset = multiset;
            this.entryIterator = entryIterator;
        }
        
        @Override
        public boolean hasNext() {
            return this.laterCount > 0 || this.entryIterator.hasNext();
        }
        
        @Override
        public E next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            if (this.laterCount == 0) {
                this.currentEntry = this.entryIterator.next();
                final int count = this.currentEntry.getCount();
                this.laterCount = count;
                this.totalCount = count;
            }
            --this.laterCount;
            this.canRemove = true;
            return this.currentEntry.getElement();
        }
        
        @Override
        public void remove() {
            CollectPreconditions.checkRemove(this.canRemove);
            if (this.totalCount == 1) {
                this.entryIterator.remove();
            }
            else {
                this.multiset.remove(this.currentEntry.getElement());
            }
            --this.totalCount;
            this.canRemove = false;
        }
    }
    
    static class UnmodifiableMultiset<E> extends ForwardingMultiset<E> implements Serializable
    {
        private static final long serialVersionUID = 0L;
        final Multiset<? extends E> delegate;
        transient Set<E> elementSet;
        transient Set<Entry<E>> entrySet;
        
        UnmodifiableMultiset(final Multiset<? extends E> delegate) {
            this.delegate = delegate;
        }
        
        @Override
        public int add(final E e, final int n) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean add(final E e) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean addAll(final Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void clear() {
            throw new UnsupportedOperationException();
        }
        
        Set<E> createElementSet() {
            return Collections.unmodifiableSet(this.delegate.elementSet());
        }
        
        @Override
        protected Multiset<E> delegate() {
            return (Multiset<E>)this.delegate;
        }
        
        @Override
        public Set<E> elementSet() {
            Set<E> elementSet;
            if ((elementSet = this.elementSet) == null) {
                elementSet = this.createElementSet();
                this.elementSet = elementSet;
            }
            return elementSet;
        }
        
        @Override
        public Set<Entry<E>> entrySet() {
            Set<Entry<E>> entrySet;
            if ((entrySet = this.entrySet) == null) {
                entrySet = Collections.unmodifiableSet((Set<? extends Entry<E>>)this.delegate.entrySet());
                this.entrySet = entrySet;
            }
            return entrySet;
        }
        
        @Override
        public Iterator<E> iterator() {
            return (Iterator<E>)Iterators.unmodifiableIterator(this.delegate.iterator());
        }
        
        @Override
        public int remove(final Object o, final int n) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean remove(final Object o) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean removeAll(final Collection<?> collection) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean retainAll(final Collection<?> collection) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public int setCount(final E e, final int n) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean setCount(final E e, final int n, final int n2) {
            throw new UnsupportedOperationException();
        }
    }
}
