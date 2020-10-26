// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.io.Serializable;
import java.util.NoSuchElementException;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.LinkedHashSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.SortedSet;
import com.google.common.annotations.GwtIncompatible;
import java.util.NavigableSet;
import javax.annotation.Nullable;
import java.util.Iterator;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Preconditions;
import java.util.EnumSet;
import java.util.Collection;
import java.util.Arrays;
import java.util.Set;
import java.util.List;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
public final class Sets
{
    private Sets() {
    }
    
    public static <B> Set<List<B>> cartesianProduct(final List<? extends Set<? extends B>> list) {
        return CartesianSet.create(list);
    }
    
    public static <B> Set<List<B>> cartesianProduct(final Set<? extends B>... a) {
        return cartesianProduct((List<? extends Set<? extends B>>)Arrays.asList((Set<? extends B>[])a));
    }
    
    public static <E extends Enum<E>> EnumSet<E> complementOf(final Collection<E> collection) {
        if (collection instanceof EnumSet) {
            return EnumSet.complementOf((EnumSet<E>)collection);
        }
        Preconditions.checkArgument(!collection.isEmpty(), (Object)"collection is empty; use the other version of this method");
        return makeComplementByHand(collection, collection.iterator().next().getDeclaringClass());
    }
    
    public static <E extends Enum<E>> EnumSet<E> complementOf(final Collection<E> collection, final Class<E> clazz) {
        Preconditions.checkNotNull(collection);
        if (collection instanceof EnumSet) {
            return EnumSet.complementOf((EnumSet<E>)collection);
        }
        return (EnumSet<E>)makeComplementByHand((Collection<E>)collection, (Class<E>)clazz);
    }
    
    public static <E> SetView<E> difference(final Set<E> set, final Set<?> set2) {
        Preconditions.checkNotNull(set, (Object)"set1");
        Preconditions.checkNotNull(set2, (Object)"set2");
        return (SetView<E>)new SetView<E>() {
            final /* synthetic */ Predicate val$notInSet2 = Predicates.not(Predicates.in((Collection<?>)set2));
            
            @Override
            public boolean contains(final Object o) {
                return set.contains(o) && !set2.contains(o);
            }
            
            @Override
            public boolean isEmpty() {
                return set2.containsAll(set);
            }
            
            @Override
            public Iterator<E> iterator() {
                return (Iterator<E>)Iterators.filter(set.iterator(), this.val$notInSet2);
            }
            
            @Override
            public int size() {
                return Iterators.size(this.iterator());
            }
        };
    }
    
    static boolean equalsImpl(final Set<?> set, @Nullable final Object o) {
        final boolean b = true;
        boolean b2 = false;
        if (set == o) {
            b2 = true;
        }
        else if (o instanceof Set) {
            final Set set2 = (Set)o;
            try {
                return set.size() == set2.size() && set.containsAll(set2) && b;
            }
            catch (NullPointerException ex) {
                return false;
            }
            catch (ClassCastException ex2) {
                return false;
            }
        }
        return b2;
    }
    
    @GwtIncompatible("NavigableSet")
    public static <E> NavigableSet<E> filter(final NavigableSet<E> set, final Predicate<? super E> predicate) {
        if (set instanceof FilteredSet) {
            final FilteredSet set2 = (FilteredSet)set;
            return new FilteredNavigableSet<E>((NavigableSet)set2.unfiltered, Predicates.and((Predicate<? super Object>)set2.predicate, (Predicate<? super Object>)predicate));
        }
        return new FilteredNavigableSet<E>(Preconditions.checkNotNull(set), Preconditions.checkNotNull(predicate));
    }
    
    public static <E> Set<E> filter(final Set<E> set, final Predicate<? super E> predicate) {
        if (set instanceof SortedSet) {
            return (Set<E>)filter((SortedSet<Object>)set, (Predicate<? super Object>)predicate);
        }
        if (set instanceof FilteredSet) {
            final FilteredSet<E> set2 = (FilteredSet<E>)set;
            return new FilteredSet<E>((Set)set2.unfiltered, Predicates.and((Predicate<? super Object>)set2.predicate, (Predicate<? super Object>)predicate));
        }
        return new FilteredSet<E>(Preconditions.checkNotNull(set), Preconditions.checkNotNull(predicate));
    }
    
    public static <E> SortedSet<E> filter(final SortedSet<E> set, final Predicate<? super E> predicate) {
        return Platform.setsFilterSortedSet(set, predicate);
    }
    
    static <E> SortedSet<E> filterSortedIgnoreNavigable(final SortedSet<E> set, final Predicate<? super E> predicate) {
        if (set instanceof FilteredSet) {
            final FilteredSet set2 = (FilteredSet)set;
            return new FilteredSortedSet<E>((SortedSet)set2.unfiltered, Predicates.and((Predicate<? super Object>)set2.predicate, (Predicate<? super Object>)predicate));
        }
        return new FilteredSortedSet<E>(Preconditions.checkNotNull(set), Preconditions.checkNotNull(predicate));
    }
    
    static int hashCodeImpl(final Set<?> set) {
        int n = 0;
        for (final Object next : set) {
            int hashCode;
            if (next != null) {
                hashCode = next.hashCode();
            }
            else {
                hashCode = 0;
            }
            n = ~(~(n + hashCode));
        }
        return n;
    }
    
    @GwtCompatible(serializable = true)
    public static <E extends Enum<E>> ImmutableSet<E> immutableEnumSet(final E first, final E... rest) {
        return ImmutableEnumSet.asImmutable((EnumSet<E>)EnumSet.of(first, (E[])rest));
    }
    
    @GwtCompatible(serializable = true)
    public static <E extends Enum<E>> ImmutableSet<E> immutableEnumSet(final Iterable<E> iterable) {
        if (iterable instanceof ImmutableEnumSet) {
            return (ImmutableEnumSet<E>)iterable;
        }
        if (iterable instanceof Collection) {
            final ImmutableEnumSet<Object> c = (ImmutableEnumSet<Object>)iterable;
            if (c.isEmpty()) {
                return ImmutableSet.of();
            }
            return ImmutableEnumSet.asImmutable((EnumSet<E>)EnumSet.copyOf((Collection<E>)c));
        }
        else {
            final Iterator<E> iterator = iterable.iterator();
            if (iterator.hasNext()) {
                final EnumSet<E> of = EnumSet.of((E)iterator.next());
                Iterators.addAll(of, (Iterator<? extends E>)iterator);
                return ImmutableEnumSet.asImmutable(of);
            }
            return ImmutableSet.of();
        }
    }
    
    public static <E> SetView<E> intersection(final Set<E> set, final Set<?> set2) {
        Preconditions.checkNotNull(set, (Object)"set1");
        Preconditions.checkNotNull(set2, (Object)"set2");
        return (SetView<E>)new SetView<E>() {
            final /* synthetic */ Predicate val$inSet2 = Predicates.in((Collection<?>)set2);
            
            @Override
            public boolean contains(final Object o) {
                return set.contains(o) && set2.contains(o);
            }
            
            @Override
            public boolean containsAll(final Collection<?> collection) {
                return set.containsAll(collection) && set2.containsAll(collection);
            }
            
            @Override
            public boolean isEmpty() {
                return !this.iterator().hasNext();
            }
            
            @Override
            public Iterator<E> iterator() {
                return (Iterator<E>)Iterators.filter(set.iterator(), this.val$inSet2);
            }
            
            @Override
            public int size() {
                return Iterators.size(this.iterator());
            }
        };
    }
    
    private static <E extends Enum<E>> EnumSet<E> makeComplementByHand(final Collection<E> c, final Class<E> elementType) {
        final EnumSet<E> all = EnumSet.allOf(elementType);
        all.removeAll(c);
        return all;
    }
    
    public static <E> Set<E> newConcurrentHashSet() {
        return newSetFromMap(new ConcurrentHashMap<E, Boolean>());
    }
    
    public static <E> Set<E> newConcurrentHashSet(final Iterable<? extends E> iterable) {
        final Set<Object> concurrentHashSet = newConcurrentHashSet();
        Iterables.addAll(concurrentHashSet, iterable);
        return (Set<E>)concurrentHashSet;
    }
    
    @GwtIncompatible("CopyOnWriteArraySet")
    public static <E> CopyOnWriteArraySet<E> newCopyOnWriteArraySet() {
        return new CopyOnWriteArraySet<E>();
    }
    
    @GwtIncompatible("CopyOnWriteArraySet")
    public static <E> CopyOnWriteArraySet<E> newCopyOnWriteArraySet(final Iterable<? extends E> iterable) {
        Collection<Object> c;
        if (iterable instanceof Collection) {
            c = Collections2.cast((Iterable<Object>)iterable);
        }
        else {
            c = Lists.newArrayList((Iterable<?>)iterable);
        }
        return new CopyOnWriteArraySet<E>((Collection<? extends E>)c);
    }
    
    public static <E extends Enum<E>> EnumSet<E> newEnumSet(final Iterable<E> iterable, final Class<E> elementType) {
        final EnumSet<E> none = EnumSet.noneOf(elementType);
        Iterables.addAll(none, (Iterable<? extends E>)iterable);
        return none;
    }
    
    public static <E> HashSet<E> newHashSet() {
        return new HashSet<E>();
    }
    
    public static <E> HashSet<E> newHashSet(final Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new HashSet<E>((Collection<? extends E>)Collections2.cast((Iterable<? extends E>)iterable));
        }
        return newHashSet((Iterator<? extends E>)iterable.iterator());
    }
    
    public static <E> HashSet<E> newHashSet(final Iterator<? extends E> iterator) {
        final HashSet<Object> hashSet = newHashSet();
        Iterators.addAll(hashSet, iterator);
        return (HashSet<E>)hashSet;
    }
    
    public static <E> HashSet<E> newHashSet(final E... elements) {
        final HashSet<? super E> hashSetWithExpectedSize = newHashSetWithExpectedSize(elements.length);
        Collections.addAll(hashSetWithExpectedSize, elements);
        return (HashSet<E>)hashSetWithExpectedSize;
    }
    
    public static <E> HashSet<E> newHashSetWithExpectedSize(final int n) {
        return new HashSet<E>(Maps.capacity(n));
    }
    
    public static <E> Set<E> newIdentityHashSet() {
        return newSetFromMap((Map<E, Boolean>)Maps.newIdentityHashMap());
    }
    
    public static <E> LinkedHashSet<E> newLinkedHashSet() {
        return new LinkedHashSet<E>();
    }
    
    public static <E> LinkedHashSet<E> newLinkedHashSet(final Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new LinkedHashSet<E>((Collection<? extends E>)Collections2.cast((Iterable<? extends E>)iterable));
        }
        final LinkedHashSet<Object> linkedHashSet = newLinkedHashSet();
        Iterables.addAll(linkedHashSet, iterable);
        return (LinkedHashSet<E>)linkedHashSet;
    }
    
    public static <E> LinkedHashSet<E> newLinkedHashSetWithExpectedSize(final int n) {
        return new LinkedHashSet<E>(Maps.capacity(n));
    }
    
    public static <E> Set<E> newSetFromMap(final Map<E, Boolean> map) {
        return Platform.newSetFromMap(map);
    }
    
    public static <E extends Comparable> TreeSet<E> newTreeSet() {
        return new TreeSet<E>();
    }
    
    public static <E extends Comparable> TreeSet<E> newTreeSet(final Iterable<? extends E> iterable) {
        final TreeSet<Object> treeSet = (TreeSet<Object>)newTreeSet();
        Iterables.addAll(treeSet, iterable);
        return (TreeSet<E>)treeSet;
    }
    
    public static <E> TreeSet<E> newTreeSet(final Comparator<? super E> comparator) {
        return new TreeSet<E>(Preconditions.checkNotNull(comparator));
    }
    
    @GwtCompatible(serializable = false)
    public static <E> Set<Set<E>> powerSet(final Set<E> set) {
        return (Set<Set<E>>)new PowerSet((Set<Object>)set);
    }
    
    static boolean removeAllImpl(final Set<?> set, final Collection<?> collection) {
        Preconditions.checkNotNull(collection);
        Object elementSet = collection;
        if (collection instanceof Multiset) {
            elementSet = ((Multiset<?>)collection).elementSet();
        }
        if (elementSet instanceof Set && ((Collection)elementSet).size() > set.size()) {
            return Iterators.removeAll(set.iterator(), (Collection<?>)elementSet);
        }
        return removeAllImpl(set, ((Collection<?>)elementSet).iterator());
    }
    
    static boolean removeAllImpl(final Set<?> set, final Iterator<?> iterator) {
        boolean b = false;
        while (iterator.hasNext()) {
            b |= set.remove(iterator.next());
        }
        return b;
    }
    
    public static <E> SetView<E> symmetricDifference(final Set<? extends E> set, final Set<? extends E> set2) {
        Preconditions.checkNotNull(set, (Object)"set1");
        Preconditions.checkNotNull(set2, (Object)"set2");
        return (SetView<E>)difference(union((Set<?>)set, (Set<?>)set2), intersection((Set<Object>)set, set2));
    }
    
    @GwtIncompatible("NavigableSet")
    public static <E> NavigableSet<E> synchronizedNavigableSet(final NavigableSet<E> set) {
        return Synchronized.navigableSet(set);
    }
    
    public static <E> SetView<E> union(final Set<? extends E> set, final Set<? extends E> set2) {
        Preconditions.checkNotNull(set, (Object)"set1");
        Preconditions.checkNotNull(set2, (Object)"set2");
        return (SetView<E>)new SetView<E>() {
            final /* synthetic */ Set val$set2minus1 = difference((Set<Object>)set2, set);
            
            @Override
            public boolean contains(final Object o) {
                return set.contains(o) || set2.contains(o);
            }
            
            @Override
            public <S extends Set<E>> S copyInto(final S n) {
                n.addAll(set);
                n.addAll(set2);
                return n;
            }
            
            @Override
            public ImmutableSet<E> immutableCopy() {
                return new ImmutableSet.Builder<E>().addAll(set).addAll(set2).build();
            }
            
            @Override
            public boolean isEmpty() {
                return set.isEmpty() && set2.isEmpty();
            }
            
            @Override
            public Iterator<E> iterator() {
                return (Iterator<E>)Iterators.unmodifiableIterator(Iterators.concat(set.iterator(), this.val$set2minus1.iterator()));
            }
            
            @Override
            public int size() {
                return set.size() + this.val$set2minus1.size();
            }
        };
    }
    
    @GwtIncompatible("NavigableSet")
    public static <E> NavigableSet<E> unmodifiableNavigableSet(final NavigableSet<E> set) {
        if (set instanceof ImmutableSortedSet || set instanceof UnmodifiableNavigableSet) {
            return set;
        }
        return new UnmodifiableNavigableSet<E>(set);
    }
    
    private static final class CartesianSet<E> extends ForwardingCollection<List<E>> implements Set<List<E>>
    {
        private final transient ImmutableList<ImmutableSet<E>> axes;
        private final transient CartesianList<E> delegate;
        
        private CartesianSet(final ImmutableList<ImmutableSet<E>> axes, final CartesianList<E> delegate) {
            this.axes = axes;
            this.delegate = delegate;
        }
        
        static <E> Set<List<E>> create(final List<? extends Set<? extends E>> list) {
            final ImmutableList.Builder<ImmutableSet<E>> builder = new ImmutableList.Builder<ImmutableSet<E>>(list.size());
            final Iterator<? extends Set<? extends E>> iterator = list.iterator();
            while (iterator.hasNext()) {
                final ImmutableSet<Object> copy = ImmutableSet.copyOf((Collection<?>)iterator.next());
                if (copy.isEmpty()) {
                    return (Set<List<E>>)ImmutableSet.of();
                }
                builder.add((ImmutableSet<E>)copy);
            }
            final ImmutableList<ImmutableSet<E>> build = builder.build();
            return new CartesianSet<E>((ImmutableList<ImmutableSet<Object>>)build, new CartesianList<Object>((ImmutableList<List<Object>>)new ImmutableList<List<E>>() {
                @Override
                public List<E> get(final int n) {
                    return (List<E>)((ImmutableSet)build.get(n)).asList();
                }
                
                @Override
                boolean isPartialView() {
                    return true;
                }
                
                @Override
                public int size() {
                    return build.size();
                }
            }));
        }
        
        @Override
        protected Collection<List<E>> delegate() {
            return (Collection<List<E>>)this.delegate;
        }
        
        @Override
        public boolean equals(@Nullable final Object obj) {
            if (obj instanceof CartesianSet) {
                return this.axes.equals(((CartesianSet)obj).axes);
            }
            return super.equals(obj);
        }
        
        @Override
        public int hashCode() {
            int n = this.size() - 1;
            for (int i = 0; i < this.axes.size(); ++i) {
                n = ~(~(n * 31));
            }
            int n2 = 1;
            for (final Set set : this.axes) {
                n2 = ~(~(n2 * 31 + this.size() / set.size() * set.hashCode()));
            }
            return ~(~(n2 + n));
        }
    }
    
    @GwtIncompatible("NavigableSet")
    static class DescendingSet<E> extends ForwardingNavigableSet<E>
    {
        private final NavigableSet<E> forward;
        
        DescendingSet(final NavigableSet<E> forward) {
            this.forward = forward;
        }
        
        private static <T> Ordering<T> reverse(final Comparator<T> comparator) {
            return Ordering.from(comparator).reverse();
        }
        
        @Override
        public E ceiling(final E e) {
            return this.forward.floor(e);
        }
        
        @Override
        public Comparator<? super E> comparator() {
            final Comparator<? super Object> comparator = this.forward.comparator();
            if (comparator == null) {
                return Ordering.natural().reverse();
            }
            return reverse(comparator);
        }
        
        @Override
        protected NavigableSet<E> delegate() {
            return this.forward;
        }
        
        @Override
        public Iterator<E> descendingIterator() {
            return this.forward.iterator();
        }
        
        @Override
        public NavigableSet<E> descendingSet() {
            return this.forward;
        }
        
        @Override
        public E first() {
            return this.forward.last();
        }
        
        @Override
        public E floor(final E e) {
            return this.forward.ceiling(e);
        }
        
        @Override
        public NavigableSet<E> headSet(final E e, final boolean b) {
            return this.forward.tailSet(e, b).descendingSet();
        }
        
        @Override
        public SortedSet<E> headSet(final E e) {
            return this.standardHeadSet(e);
        }
        
        @Override
        public E higher(final E e) {
            return this.forward.lower(e);
        }
        
        @Override
        public Iterator<E> iterator() {
            return this.forward.descendingIterator();
        }
        
        @Override
        public E last() {
            return this.forward.first();
        }
        
        @Override
        public E lower(final E e) {
            return this.forward.higher(e);
        }
        
        @Override
        public E pollFirst() {
            return this.forward.pollLast();
        }
        
        @Override
        public E pollLast() {
            return this.forward.pollFirst();
        }
        
        @Override
        public NavigableSet<E> subSet(final E e, final boolean b, final E e2, final boolean b2) {
            return this.forward.subSet(e2, b2, e, b).descendingSet();
        }
        
        @Override
        public SortedSet<E> subSet(final E e, final E e2) {
            return this.standardSubSet(e, e2);
        }
        
        @Override
        public NavigableSet<E> tailSet(final E e, final boolean b) {
            return this.forward.headSet(e, b).descendingSet();
        }
        
        @Override
        public SortedSet<E> tailSet(final E e) {
            return this.standardTailSet(e);
        }
        
        @Override
        public Object[] toArray() {
            return this.standardToArray();
        }
        
        @Override
        public <T> T[] toArray(final T[] array) {
            return this.standardToArray(array);
        }
        
        @Override
        public String toString() {
            return this.standardToString();
        }
    }
    
    @GwtIncompatible("NavigableSet")
    private static class FilteredNavigableSet<E> extends FilteredSortedSet<E> implements NavigableSet<E>
    {
        FilteredNavigableSet(final NavigableSet<E> set, final Predicate<? super E> predicate) {
            super(set, predicate);
        }
        
        @Override
        public E ceiling(final E e) {
            return Iterables.getFirst((Iterable<? extends E>)this.tailSet(e, true), (E)null);
        }
        
        @Override
        public Iterator<E> descendingIterator() {
            return Iterators.filter(this.unfiltered().descendingIterator(), this.predicate);
        }
        
        @Override
        public NavigableSet<E> descendingSet() {
            return Sets.filter(this.unfiltered().descendingSet(), this.predicate);
        }
        
        @Nullable
        @Override
        public E floor(final E e) {
            return Iterators.getNext((Iterator<? extends E>)this.headSet(e, true).descendingIterator(), (E)null);
        }
        
        @Override
        public NavigableSet<E> headSet(final E e, final boolean b) {
            return Sets.filter(this.unfiltered().headSet(e, b), this.predicate);
        }
        
        @Override
        public E higher(final E e) {
            return Iterables.getFirst((Iterable<? extends E>)this.tailSet(e, false), (E)null);
        }
        
        @Override
        public E last() {
            return this.descendingIterator().next();
        }
        
        @Nullable
        @Override
        public E lower(final E e) {
            return Iterators.getNext((Iterator<? extends E>)this.headSet(e, false).descendingIterator(), (E)null);
        }
        
        @Override
        public E pollFirst() {
            return Iterables.removeFirstMatching(this.unfiltered(), this.predicate);
        }
        
        @Override
        public E pollLast() {
            return Iterables.removeFirstMatching(this.unfiltered().descendingSet(), this.predicate);
        }
        
        @Override
        public NavigableSet<E> subSet(final E e, final boolean b, final E e2, final boolean b2) {
            return Sets.filter(this.unfiltered().subSet(e, b, e2, b2), this.predicate);
        }
        
        @Override
        public NavigableSet<E> tailSet(final E e, final boolean b) {
            return Sets.filter(this.unfiltered().tailSet(e, b), this.predicate);
        }
        
        NavigableSet<E> unfiltered() {
            return (NavigableSet<E>)(NavigableSet)this.unfiltered;
        }
    }
    
    private static class FilteredSet<E> extends FilteredCollection<E> implements Set<E>
    {
        FilteredSet(final Set<E> set, final Predicate<? super E> predicate) {
            super(set, predicate);
        }
        
        @Override
        public boolean equals(@Nullable final Object o) {
            return Sets.equalsImpl(this, o);
        }
        
        @Override
        public int hashCode() {
            return Sets.hashCodeImpl(this);
        }
    }
    
    private static class FilteredSortedSet<E> extends FilteredSet<E> implements SortedSet<E>
    {
        FilteredSortedSet(final SortedSet<E> set, final Predicate<? super E> predicate) {
            super(set, predicate);
        }
        
        @Override
        public Comparator<? super E> comparator() {
            return (Comparator<? super E>)((SortedSet)this.unfiltered).comparator();
        }
        
        @Override
        public E first() {
            return this.iterator().next();
        }
        
        @Override
        public SortedSet<E> headSet(final E e) {
            return new FilteredSortedSet((SortedSet<Object>)((SortedSet)this.unfiltered).headSet(e), (Predicate<? super Object>)this.predicate);
        }
        
        @Override
        public E last() {
            SortedSet<E> headSet = (SortedSet<E>)(SortedSet)this.unfiltered;
            E last;
            while (true) {
                last = headSet.last();
                if (this.predicate.apply((Object)last)) {
                    break;
                }
                headSet = headSet.headSet(last);
            }
            return last;
        }
        
        @Override
        public SortedSet<E> subSet(final E e, final E e2) {
            return new FilteredSortedSet((SortedSet<Object>)((SortedSet)this.unfiltered).subSet(e, e2), (Predicate<? super Object>)this.predicate);
        }
        
        @Override
        public SortedSet<E> tailSet(final E e) {
            return new FilteredSortedSet((SortedSet<Object>)((SortedSet)this.unfiltered).tailSet(e), (Predicate<? super Object>)this.predicate);
        }
    }
    
    abstract static class ImprovedAbstractSet<E> extends AbstractSet<E>
    {
        @Override
        public boolean removeAll(final Collection<?> collection) {
            return Sets.removeAllImpl(this, collection);
        }
        
        @Override
        public boolean retainAll(final Collection<?> collection) {
            return super.retainAll(Preconditions.checkNotNull(collection));
        }
    }
    
    private static final class PowerSet<E> extends AbstractSet<Set<E>>
    {
        final ImmutableMap<E, Integer> inputSet;
        
        PowerSet(final Set<E> set) {
            final ImmutableMap.Builder<E, Integer> builder = ImmutableMap.builder();
            int i = 0;
            final Iterator<E> iterator = Preconditions.checkNotNull(set).iterator();
            while (iterator.hasNext()) {
                builder.put(iterator.next(), i);
                ++i;
            }
            this.inputSet = builder.build();
            Preconditions.checkArgument(this.inputSet.size() <= 30, "Too many elements to create power set: %s > 30", this.inputSet.size());
        }
        
        @Override
        public boolean contains(@Nullable final Object o) {
            return o instanceof Set && this.inputSet.keySet().containsAll((Collection<?>)o);
        }
        
        @Override
        public boolean equals(@Nullable final Object o) {
            if (o instanceof PowerSet) {
                return this.inputSet.equals(((PowerSet)o).inputSet);
            }
            return super.equals(o);
        }
        
        @Override
        public int hashCode() {
            return this.inputSet.keySet().hashCode() << this.inputSet.size() - 1;
        }
        
        @Override
        public boolean isEmpty() {
            return false;
        }
        
        @Override
        public Iterator<Set<E>> iterator() {
            return new AbstractIndexedListIterator<Set<E>>(this.size()) {
                @Override
                protected Set<E> get(final int n) {
                    return new SubSet<E>(PowerSet.this.inputSet, n);
                }
            };
        }
        
        @Override
        public int size() {
            return 1 << this.inputSet.size();
        }
        
        @Override
        public String toString() {
            final String value = String.valueOf(String.valueOf(this.inputSet));
            return new StringBuilder(value.length() + 10).append("powerSet(").append(value).append(")").toString();
        }
    }
    
    public abstract static class SetView<E> extends AbstractSet<E>
    {
        private SetView() {
        }
        
        public <S extends Set<E>> S copyInto(final S n) {
            n.addAll((Collection<? extends E>)this);
            return n;
        }
        
        public ImmutableSet<E> immutableCopy() {
            return ImmutableSet.copyOf((Collection<? extends E>)this);
        }
    }
    
    private static final class SubSet<E> extends AbstractSet<E>
    {
        private final ImmutableMap<E, Integer> inputSet;
        private final int mask;
        
        SubSet(final ImmutableMap<E, Integer> inputSet, final int mask) {
            this.inputSet = inputSet;
            this.mask = mask;
        }
        
        @Override
        public boolean contains(@Nullable final Object o) {
            final Integer n = this.inputSet.get(o);
            return n != null && (this.mask & 1 << n) != 0x0;
        }
        
        @Override
        public Iterator<E> iterator() {
            return new UnmodifiableIterator<E>() {
                final ImmutableList<E> elements = SubSet.this.inputSet.keySet().asList();
                int remainingSetBits = SubSet.this.mask;
                
                @Override
                public boolean hasNext() {
                    return this.remainingSetBits != 0;
                }
                
                @Override
                public E next() {
                    final int numberOfTrailingZeros = Integer.numberOfTrailingZeros(this.remainingSetBits);
                    if (numberOfTrailingZeros == 32) {
                        throw new NoSuchElementException();
                    }
                    this.remainingSetBits &= ~(1 << numberOfTrailingZeros);
                    return (E)this.elements.get(numberOfTrailingZeros);
                }
            };
        }
        
        @Override
        public int size() {
            return Integer.bitCount(this.mask);
        }
    }
    
    @GwtIncompatible("NavigableSet")
    static final class UnmodifiableNavigableSet<E> extends ForwardingSortedSet<E> implements NavigableSet<E>, Serializable
    {
        private static final long serialVersionUID = 0L;
        private final NavigableSet<E> delegate;
        private transient UnmodifiableNavigableSet<E> descendingSet;
        
        UnmodifiableNavigableSet(final NavigableSet<E> set) {
            this.delegate = Preconditions.checkNotNull(set);
        }
        
        @Override
        public E ceiling(final E e) {
            return this.delegate.ceiling(e);
        }
        
        @Override
        protected SortedSet<E> delegate() {
            return Collections.unmodifiableSortedSet(this.delegate);
        }
        
        @Override
        public Iterator<E> descendingIterator() {
            return Iterators.unmodifiableIterator(this.delegate.descendingIterator());
        }
        
        @Override
        public NavigableSet<E> descendingSet() {
            UnmodifiableNavigableSet<E> descendingSet;
            if ((descendingSet = this.descendingSet) == null) {
                descendingSet = new UnmodifiableNavigableSet<E>(this.delegate.descendingSet());
                this.descendingSet = descendingSet;
                descendingSet.descendingSet = this;
            }
            return descendingSet;
        }
        
        @Override
        public E floor(final E e) {
            return this.delegate.floor(e);
        }
        
        @Override
        public NavigableSet<E> headSet(final E e, final boolean b) {
            return Sets.unmodifiableNavigableSet(this.delegate.headSet(e, b));
        }
        
        @Override
        public E higher(final E e) {
            return this.delegate.higher(e);
        }
        
        @Override
        public E lower(final E e) {
            return this.delegate.lower(e);
        }
        
        @Override
        public E pollFirst() {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public E pollLast() {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public NavigableSet<E> subSet(final E e, final boolean b, final E e2, final boolean b2) {
            return Sets.unmodifiableNavigableSet(this.delegate.subSet(e, b, e2, b2));
        }
        
        @Override
        public NavigableSet<E> tailSet(final E e, final boolean b) {
            return Sets.unmodifiableNavigableSet(this.delegate.tailSet(e, b));
        }
    }
}
