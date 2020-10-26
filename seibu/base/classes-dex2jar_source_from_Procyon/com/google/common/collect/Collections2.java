// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.Arrays;
import java.util.ArrayList;
import com.google.common.math.IntMath;
import java.util.Collections;
import com.google.common.math.LongMath;
import java.util.Iterator;
import java.util.AbstractCollection;
import com.google.common.base.Function;
import javax.annotation.Nullable;
import com.google.common.annotations.Beta;
import java.util.Comparator;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.Collection;
import java.util.List;
import com.google.common.base.Joiner;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public final class Collections2
{
    static final Joiner STANDARD_JOINER;
    
    static {
        STANDARD_JOINER = Joiner.on(", ").useForNull("null");
    }
    
    private Collections2() {
    }
    
    static <T> Collection<T> cast(final Iterable<T> iterable) {
        return (Collection<T>)iterable;
    }
    
    static boolean containsAllImpl(final Collection<?> collection, final Collection<?> collection2) {
        return Iterables.all(collection2, Predicates.in(collection));
    }
    
    public static <E> Collection<E> filter(final Collection<E> collection, final Predicate<? super E> predicate) {
        if (collection instanceof FilteredCollection) {
            return ((FilteredCollection<E>)collection).createCombined(predicate);
        }
        return new FilteredCollection<E>(Preconditions.checkNotNull(collection), Preconditions.checkNotNull(predicate));
    }
    
    private static boolean isPermutation(final List<?> list, final List<?> list2) {
        return list.size() == list2.size() && HashMultiset.create((Iterable<?>)list).equals(HashMultiset.create((Iterable<?>)list2));
    }
    
    private static boolean isPositiveInt(final long n) {
        return n >= 0L && n <= 2147483647L;
    }
    
    static StringBuilder newStringBuilderForCollection(final int n) {
        CollectPreconditions.checkNonnegative(n, "size");
        return new StringBuilder((int)Math.min(n * 8L, 1073741824L));
    }
    
    @Beta
    public static <E extends Comparable<? super E>> Collection<List<E>> orderedPermutations(final Iterable<E> iterable) {
        return orderedPermutations(iterable, Ordering.natural());
    }
    
    @Beta
    public static <E> Collection<List<E>> orderedPermutations(final Iterable<E> iterable, final Comparator<? super E> comparator) {
        return (Collection<List<E>>)new OrderedPermutationCollection((Iterable<Object>)iterable, (Comparator<? super Object>)comparator);
    }
    
    @Beta
    public static <E> Collection<List<E>> permutations(final Collection<E> collection) {
        return (Collection<List<E>>)new PermutationCollection(ImmutableList.copyOf((Collection<?>)collection));
    }
    
    static boolean safeContains(final Collection<?> collection, @Nullable final Object o) {
        Preconditions.checkNotNull(collection);
        try {
            return collection.contains(o);
        }
        catch (ClassCastException ex) {
            return false;
        }
        catch (NullPointerException ex2) {
            return false;
        }
    }
    
    static boolean safeRemove(final Collection<?> collection, @Nullable final Object o) {
        Preconditions.checkNotNull(collection);
        try {
            return collection.remove(o);
        }
        catch (ClassCastException ex) {
            return false;
        }
        catch (NullPointerException ex2) {
            return false;
        }
    }
    
    static String toStringImpl(final Collection<?> collection) {
        final StringBuilder append = newStringBuilderForCollection(collection.size()).append('[');
        Collections2.STANDARD_JOINER.appendTo(append, Iterables.transform((Iterable<Object>)collection, (Function<? super Object, ?>)new Function<Object, Object>() {
            @Override
            public Object apply(final Object o) {
                Object o2 = o;
                if (o == collection) {
                    o2 = "(this Collection)";
                }
                return o2;
            }
        }));
        return append.append(']').toString();
    }
    
    public static <F, T> Collection<T> transform(final Collection<F> collection, final Function<? super F, T> function) {
        return (Collection<T>)new TransformedCollection((Collection<Object>)collection, (Function<? super Object, ?>)function);
    }
    
    static class FilteredCollection<E> extends AbstractCollection<E>
    {
        final Predicate<? super E> predicate;
        final Collection<E> unfiltered;
        
        FilteredCollection(final Collection<E> unfiltered, final Predicate<? super E> predicate) {
            this.unfiltered = unfiltered;
            this.predicate = predicate;
        }
        
        @Override
        public boolean add(final E e) {
            Preconditions.checkArgument(this.predicate.apply((Object)e));
            return this.unfiltered.add(e);
        }
        
        @Override
        public boolean addAll(final Collection<? extends E> collection) {
            final Iterator<? extends E> iterator = collection.iterator();
            while (iterator.hasNext()) {
                Preconditions.checkArgument(this.predicate.apply((Object)iterator.next()));
            }
            return this.unfiltered.addAll(collection);
        }
        
        @Override
        public void clear() {
            Iterables.removeIf(this.unfiltered, this.predicate);
        }
        
        @Override
        public boolean contains(@Nullable final Object o) {
            return Collections2.safeContains(this.unfiltered, o) && this.predicate.apply((Object)o);
        }
        
        @Override
        public boolean containsAll(final Collection<?> collection) {
            return Collections2.containsAllImpl(this, collection);
        }
        
        FilteredCollection<E> createCombined(final Predicate<? super E> predicate) {
            return new FilteredCollection<E>(this.unfiltered, Predicates.and(this.predicate, predicate));
        }
        
        @Override
        public boolean isEmpty() {
            return !Iterables.any(this.unfiltered, this.predicate);
        }
        
        @Override
        public Iterator<E> iterator() {
            return Iterators.filter(this.unfiltered.iterator(), this.predicate);
        }
        
        @Override
        public boolean remove(final Object o) {
            return this.contains(o) && this.unfiltered.remove(o);
        }
        
        @Override
        public boolean removeAll(final Collection<?> collection) {
            return Iterables.removeIf(this.unfiltered, Predicates.and(this.predicate, Predicates.in((Collection<? extends E>)collection)));
        }
        
        @Override
        public boolean retainAll(final Collection<?> collection) {
            return Iterables.removeIf(this.unfiltered, Predicates.and(this.predicate, (Predicate<? super E>)Predicates.not(Predicates.in((Collection<? extends T>)collection))));
        }
        
        @Override
        public int size() {
            return Iterators.size(this.iterator());
        }
        
        @Override
        public Object[] toArray() {
            return Lists.newArrayList(this.iterator()).toArray();
        }
        
        @Override
        public <T> T[] toArray(final T[] a) {
            return Lists.newArrayList(this.iterator()).toArray(a);
        }
    }
    
    private static final class OrderedPermutationCollection<E> extends AbstractCollection<List<E>>
    {
        final Comparator<? super E> comparator;
        final ImmutableList<E> inputList;
        final int size;
        
        OrderedPermutationCollection(final Iterable<E> iterable, final Comparator<? super E> comparator) {
            this.inputList = Ordering.from(comparator).immutableSortedCopy(iterable);
            this.comparator = comparator;
            this.size = calculateSize(this.inputList, comparator);
        }
        
        private static <E> int calculateSize(final List<E> list, final Comparator<? super E> comparator) {
            long n = 1L;
            int i = 1;
            int n2 = 1;
            while (i < list.size()) {
                long n3 = n;
                int n4 = n2;
                if (comparator.compare(list.get(i - 1), list.get(i)) < 0) {
                    final long n5 = n * LongMath.binomial(i, n2);
                    n4 = 0;
                    n3 = n5;
                    if (!isPositiveInt(n5)) {
                        return Integer.MAX_VALUE;
                    }
                }
                ++i;
                n2 = n4 + 1;
                n = n3;
            }
            final long n6 = n * LongMath.binomial(i, n2);
            if (isPositiveInt(n6)) {
                return (int)n6;
            }
            return Integer.MAX_VALUE;
        }
        
        @Override
        public boolean contains(@Nullable final Object o) {
            return o instanceof List && isPermutation(this.inputList, (List)o);
        }
        
        @Override
        public boolean isEmpty() {
            return false;
        }
        
        @Override
        public Iterator<List<E>> iterator() {
            return (Iterator<List<E>>)new OrderedPermutationIterator((List<Object>)this.inputList, (Comparator<? super Object>)this.comparator);
        }
        
        @Override
        public int size() {
            return this.size;
        }
        
        @Override
        public String toString() {
            final String value = String.valueOf(String.valueOf(this.inputList));
            return new StringBuilder(value.length() + 30).append("orderedPermutationCollection(").append(value).append(")").toString();
        }
    }
    
    private static final class OrderedPermutationIterator<E> extends AbstractIterator<List<E>>
    {
        final Comparator<? super E> comparator;
        List<E> nextPermutation;
        
        OrderedPermutationIterator(final List<E> list, final Comparator<? super E> comparator) {
            this.nextPermutation = (List<E>)Lists.newArrayList((Iterable<?>)list);
            this.comparator = comparator;
        }
        
        void calculateNextPermutation() {
            final int nextJ = this.findNextJ();
            if (nextJ == -1) {
                this.nextPermutation = null;
                return;
            }
            Collections.swap(this.nextPermutation, nextJ, this.findNextL(nextJ));
            Collections.reverse(this.nextPermutation.subList(nextJ + 1, this.nextPermutation.size()));
        }
        
        @Override
        protected List<E> computeNext() {
            if (this.nextPermutation == null) {
                return this.endOfData();
            }
            final ImmutableList<E> copy = ImmutableList.copyOf((Collection<? extends E>)this.nextPermutation);
            this.calculateNextPermutation();
            return copy;
        }
        
        int findNextJ() {
            for (int i = this.nextPermutation.size() - 2; i >= 0; --i) {
                if (this.comparator.compare((Object)this.nextPermutation.get(i), (Object)this.nextPermutation.get(i + 1)) < 0) {
                    return i;
                }
            }
            return -1;
        }
        
        int findNextL(final int n) {
            final E value = this.nextPermutation.get(n);
            for (int i = this.nextPermutation.size() - 1; i > n; --i) {
                if (this.comparator.compare((Object)value, (Object)this.nextPermutation.get(i)) < 0) {
                    return i;
                }
            }
            throw new AssertionError((Object)"this statement should be unreachable");
        }
    }
    
    private static final class PermutationCollection<E> extends AbstractCollection<List<E>>
    {
        final ImmutableList<E> inputList;
        
        PermutationCollection(final ImmutableList<E> inputList) {
            this.inputList = inputList;
        }
        
        @Override
        public boolean contains(@Nullable final Object o) {
            return o instanceof List && isPermutation(this.inputList, (List)o);
        }
        
        @Override
        public boolean isEmpty() {
            return false;
        }
        
        @Override
        public Iterator<List<E>> iterator() {
            return (Iterator<List<E>>)new PermutationIterator((List<Object>)this.inputList);
        }
        
        @Override
        public int size() {
            return IntMath.factorial(this.inputList.size());
        }
        
        @Override
        public String toString() {
            final String value = String.valueOf(String.valueOf(this.inputList));
            return new StringBuilder(value.length() + 14).append("permutations(").append(value).append(")").toString();
        }
    }
    
    private static class PermutationIterator<E> extends AbstractIterator<List<E>>
    {
        final int[] c;
        int j;
        final List<E> list;
        final int[] o;
        
        PermutationIterator(final List<E> c) {
            this.list = new ArrayList<E>((Collection<? extends E>)c);
            final int size = c.size();
            this.c = new int[size];
            this.o = new int[size];
            Arrays.fill(this.c, 0);
            Arrays.fill(this.o, 1);
            this.j = Integer.MAX_VALUE;
        }
        
        void calculateNextPermutation() {
            this.j = this.list.size() - 1;
            int n = 0;
            if (this.j != -1) {
                int n2;
                while (true) {
                    n2 = this.c[this.j] + this.o[this.j];
                    if (n2 < 0) {
                        this.switchDirection();
                    }
                    else {
                        if (n2 != this.j + 1) {
                            break;
                        }
                        if (this.j == 0) {
                            return;
                        }
                        ++n;
                        this.switchDirection();
                    }
                }
                Collections.swap(this.list, this.j - this.c[this.j] + n, this.j - n2 + n);
                this.c[this.j] = n2;
            }
        }
        
        @Override
        protected List<E> computeNext() {
            if (this.j <= 0) {
                return this.endOfData();
            }
            final ImmutableList<E> copy = ImmutableList.copyOf((Collection<? extends E>)this.list);
            this.calculateNextPermutation();
            return copy;
        }
        
        void switchDirection() {
            this.o[this.j] = -this.o[this.j];
            --this.j;
        }
    }
    
    static class TransformedCollection<F, T> extends AbstractCollection<T>
    {
        final Collection<F> fromCollection;
        final Function<? super F, ? extends T> function;
        
        TransformedCollection(final Collection<F> collection, final Function<? super F, ? extends T> function) {
            this.fromCollection = Preconditions.checkNotNull(collection);
            this.function = Preconditions.checkNotNull(function);
        }
        
        @Override
        public void clear() {
            this.fromCollection.clear();
        }
        
        @Override
        public boolean isEmpty() {
            return this.fromCollection.isEmpty();
        }
        
        @Override
        public Iterator<T> iterator() {
            return Iterators.transform(this.fromCollection.iterator(), this.function);
        }
        
        @Override
        public int size() {
            return this.fromCollection.size();
        }
    }
}
