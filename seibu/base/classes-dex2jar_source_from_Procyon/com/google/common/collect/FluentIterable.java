// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.List;
import com.google.common.base.Joiner;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.annotations.GwtIncompatible;
import java.util.Collection;
import javax.annotation.Nullable;
import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import com.google.common.base.Predicate;
import com.google.common.annotations.Beta;
import java.util.Iterator;
import com.google.common.base.Preconditions;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
public abstract class FluentIterable<E> implements Iterable<E>
{
    private final Iterable<E> iterable;
    
    protected FluentIterable() {
        this.iterable = this;
    }
    
    FluentIterable(final Iterable<E> iterable) {
        this.iterable = Preconditions.checkNotNull(iterable);
    }
    
    @Deprecated
    public static <E> FluentIterable<E> from(final FluentIterable<E> fluentIterable) {
        return Preconditions.checkNotNull(fluentIterable);
    }
    
    public static <E> FluentIterable<E> from(final Iterable<E> iterable) {
        if (iterable instanceof FluentIterable) {
            return (FluentIterable<E>)iterable;
        }
        return new FluentIterable<E>(iterable) {
            @Override
            public Iterator<E> iterator() {
                return iterable.iterator();
            }
        };
    }
    
    @Beta
    public static <E> FluentIterable<E> of(final E[] array) {
        return from(Lists.newArrayList(array));
    }
    
    public final boolean allMatch(final Predicate<? super E> predicate) {
        return Iterables.all(this.iterable, predicate);
    }
    
    public final boolean anyMatch(final Predicate<? super E> predicate) {
        return Iterables.any(this.iterable, predicate);
    }
    
    @CheckReturnValue
    @Beta
    public final FluentIterable<E> append(final Iterable<? extends E> iterable) {
        return from(Iterables.concat((Iterable<? extends E>)this.iterable, iterable));
    }
    
    @CheckReturnValue
    @Beta
    public final FluentIterable<E> append(final E... a) {
        return from(Iterables.concat((Iterable<? extends E>)this.iterable, (Iterable<? extends E>)Arrays.asList(a)));
    }
    
    public final boolean contains(@Nullable final Object o) {
        return Iterables.contains(this.iterable, o);
    }
    
    public final <C extends Collection<? super E>> C copyInto(final C c) {
        Preconditions.checkNotNull(c);
        if (this.iterable instanceof Collection) {
            c.addAll(Collections2.cast((Iterable<? extends E>)this.iterable));
        }
        else {
            final Iterator<E> iterator = this.iterable.iterator();
            while (iterator.hasNext()) {
                c.add((Object)iterator.next());
            }
        }
        return c;
    }
    
    @CheckReturnValue
    public final FluentIterable<E> cycle() {
        return from((Iterable<E>)Iterables.cycle((Iterable<E>)this.iterable));
    }
    
    @CheckReturnValue
    public final FluentIterable<E> filter(final Predicate<? super E> predicate) {
        return from((Iterable<E>)Iterables.filter((Iterable<E>)this.iterable, (Predicate<? super E>)predicate));
    }
    
    @CheckReturnValue
    @GwtIncompatible("Class.isInstance")
    public final <T> FluentIterable<T> filter(final Class<T> clazz) {
        return from((Iterable<T>)Iterables.filter(this.iterable, (Class<E>)clazz));
    }
    
    public final Optional<E> first() {
        final Iterator<E> iterator = this.iterable.iterator();
        if (iterator.hasNext()) {
            return Optional.of(iterator.next());
        }
        return Optional.absent();
    }
    
    public final Optional<E> firstMatch(final Predicate<? super E> predicate) {
        return Iterables.tryFind(this.iterable, predicate);
    }
    
    public final E get(final int n) {
        return Iterables.get(this.iterable, n);
    }
    
    public final <K> ImmutableListMultimap<K, E> index(final Function<? super E, K> function) {
        return Multimaps.index(this.iterable, function);
    }
    
    public final boolean isEmpty() {
        return !this.iterable.iterator().hasNext();
    }
    
    @Beta
    public final String join(final Joiner joiner) {
        return joiner.join(this);
    }
    
    public final Optional<E> last() {
        if (this.iterable instanceof List) {
            final List list = (List)this.iterable;
            if (list.isEmpty()) {
                return Optional.absent();
            }
            return Optional.of((E)list.get(list.size() - 1));
        }
        else {
            final Iterator<E> iterator = this.iterable.iterator();
            if (!iterator.hasNext()) {
                return Optional.absent();
            }
            if (this.iterable instanceof SortedSet) {
                return Optional.of(((SortedSet)this.iterable).last());
            }
            E next;
            do {
                next = iterator.next();
            } while (iterator.hasNext());
            return Optional.of(next);
        }
    }
    
    @CheckReturnValue
    public final FluentIterable<E> limit(final int n) {
        return from((Iterable<E>)Iterables.limit((Iterable<E>)this.iterable, n));
    }
    
    public final int size() {
        return Iterables.size(this.iterable);
    }
    
    @CheckReturnValue
    public final FluentIterable<E> skip(final int n) {
        return from((Iterable<E>)Iterables.skip((Iterable<E>)this.iterable, n));
    }
    
    @GwtIncompatible("Array.newArray(Class, int)")
    public final E[] toArray(final Class<E> clazz) {
        return Iterables.toArray((Iterable<? extends E>)this.iterable, clazz);
    }
    
    public final ImmutableList<E> toList() {
        return ImmutableList.copyOf((Iterable<? extends E>)this.iterable);
    }
    
    public final <V> ImmutableMap<E, V> toMap(final Function<? super E, V> function) {
        return Maps.toMap(this.iterable, function);
    }
    
    public final ImmutableSet<E> toSet() {
        return ImmutableSet.copyOf((Iterable<? extends E>)this.iterable);
    }
    
    public final ImmutableList<E> toSortedList(final Comparator<? super E> comparator) {
        return Ordering.from(comparator).immutableSortedCopy(this.iterable);
    }
    
    public final ImmutableSortedSet<E> toSortedSet(final Comparator<? super E> comparator) {
        return ImmutableSortedSet.copyOf(comparator, (Iterable<? extends E>)this.iterable);
    }
    
    @Override
    public String toString() {
        return Iterables.toString(this.iterable);
    }
    
    public final <T> FluentIterable<T> transform(final Function<? super E, T> function) {
        return from(Iterables.transform(this.iterable, (Function<? super E, ? extends T>)function));
    }
    
    public <T> FluentIterable<T> transformAndConcat(final Function<? super E, ? extends Iterable<? extends T>> function) {
        return from(Iterables.concat((Iterable<? extends Iterable<? extends T>>)this.transform((Function<? super E, Object>)function)));
    }
    
    public final <K> ImmutableMap<K, E> uniqueIndex(final Function<? super E, K> function) {
        return Maps.uniqueIndex(this.iterable, function);
    }
    
    private static class FromIterableFunction<E> implements Function<Iterable<E>, FluentIterable<E>>
    {
        @Override
        public FluentIterable<E> apply(final Iterable<E> iterable) {
            return FluentIterable.from(iterable);
        }
    }
}
