// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.SortedSet;
import java.util.NavigableSet;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Predicate;
import java.util.NoSuchElementException;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.Beta;

@Beta
@GwtCompatible(emulated = true)
public abstract class ContiguousSet<C extends Comparable> extends ImmutableSortedSet<C>
{
    final DiscreteDomain<C> domain;
    
    ContiguousSet(final DiscreteDomain<C> domain) {
        super(Ordering.natural());
        this.domain = domain;
    }
    
    @Deprecated
    public static <E> Builder<E> builder() {
        throw new UnsupportedOperationException();
    }
    
    public static <C extends Comparable> ContiguousSet<C> create(final Range<C> range, final DiscreteDomain<C> discreteDomain) {
        Predicate<C> intersection2;
        while (true) {
            Preconditions.checkNotNull(range);
            Preconditions.checkNotNull(discreteDomain);
            Range<C> intersection = range;
            while (true) {
                try {
                    if (!range.hasLowerBound()) {
                        intersection = range.intersection(Range.atLeast(discreteDomain.minValue()));
                    }
                    intersection2 = (Predicate<C>)intersection;
                    if (!range.hasUpperBound()) {
                        intersection2 = (Predicate<C>)intersection.intersection(Range.atMost(discreteDomain.maxValue()));
                    }
                    if (((Range)intersection2).isEmpty() || Range.compareOrThrow(range.lowerBound.leastValueAbove(discreteDomain), range.upperBound.greatestValueBelow(discreteDomain)) > 0) {
                        final int n = 1;
                        if (n != 0) {
                            return new EmptyContiguousSet<C>(discreteDomain);
                        }
                        break;
                    }
                }
                catch (NoSuchElementException cause) {
                    throw new IllegalArgumentException(cause);
                }
                final int n = 0;
                continue;
            }
        }
        return new RegularContiguousSet<C>((Range<Comparable>)intersection2, (DiscreteDomain<Comparable>)discreteDomain);
    }
    
    @Override
    public ContiguousSet<C> headSet(final C c) {
        return this.headSetImpl(Preconditions.checkNotNull(c), false);
    }
    
    @GwtIncompatible("NavigableSet")
    @Override
    public ContiguousSet<C> headSet(final C c, final boolean b) {
        return this.headSetImpl(Preconditions.checkNotNull(c), b);
    }
    
    @Override
    abstract ContiguousSet<C> headSetImpl(final C p0, final boolean p1);
    
    public abstract ContiguousSet<C> intersection(final ContiguousSet<C> p0);
    
    public abstract Range<C> range();
    
    public abstract Range<C> range(final BoundType p0, final BoundType p1);
    
    @Override
    public ContiguousSet<C> subSet(final C c, final C c2) {
        Preconditions.checkNotNull(c);
        Preconditions.checkNotNull(c2);
        Preconditions.checkArgument(this.comparator().compare((Object)c, (Object)c2) <= 0);
        return this.subSetImpl(c, true, c2, false);
    }
    
    @GwtIncompatible("NavigableSet")
    @Override
    public ContiguousSet<C> subSet(final C c, final boolean b, final C c2, final boolean b2) {
        Preconditions.checkNotNull(c);
        Preconditions.checkNotNull(c2);
        Preconditions.checkArgument(this.comparator().compare((Object)c, (Object)c2) <= 0);
        return this.subSetImpl(c, b, c2, b2);
    }
    
    @Override
    abstract ContiguousSet<C> subSetImpl(final C p0, final boolean p1, final C p2, final boolean p3);
    
    @Override
    public ContiguousSet<C> tailSet(final C c) {
        return this.tailSetImpl(Preconditions.checkNotNull(c), true);
    }
    
    @GwtIncompatible("NavigableSet")
    @Override
    public ContiguousSet<C> tailSet(final C c, final boolean b) {
        return this.tailSetImpl(Preconditions.checkNotNull(c), b);
    }
    
    @Override
    abstract ContiguousSet<C> tailSetImpl(final C p0, final boolean p1);
    
    @Override
    public String toString() {
        return this.range().toString();
    }
}
