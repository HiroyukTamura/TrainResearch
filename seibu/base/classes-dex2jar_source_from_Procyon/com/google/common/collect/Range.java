// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import com.google.common.base.Preconditions;
import com.google.common.base.Function;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import com.google.common.base.Predicate;

@GwtCompatible
public final class Range<C extends Comparable> implements Predicate<C>, Serializable
{
    private static final Range<Comparable> ALL;
    private static final Function<Range, Cut> LOWER_BOUND_FN;
    static final Ordering<Range<?>> RANGE_LEX_ORDERING;
    private static final Function<Range, Cut> UPPER_BOUND_FN;
    private static final long serialVersionUID = 0L;
    final Cut<C> lowerBound;
    final Cut<C> upperBound;
    
    static {
        LOWER_BOUND_FN = new Function<Range, Cut>() {
            @Override
            public Cut apply(final Range range) {
                return range.lowerBound;
            }
        };
        UPPER_BOUND_FN = new Function<Range, Cut>() {
            @Override
            public Cut apply(final Range range) {
                return range.upperBound;
            }
        };
        RANGE_LEX_ORDERING = new Ordering<Range<?>>() {
            @Override
            public int compare(final Range<?> range, final Range<?> range2) {
                return ComparisonChain.start().compare(range.lowerBound, range2.lowerBound).compare(range.upperBound, range2.upperBound).result();
            }
        };
        ALL = new Range<Comparable>((Cut<Comparable>)Cut.belowAll(), (Cut<Comparable>)Cut.aboveAll());
    }
    
    private Range(final Cut<C> cut, final Cut<C> cut2) {
        if (cut.compareTo(cut2) > 0 || cut == Cut.aboveAll() || cut2 == Cut.belowAll()) {
            final String value = String.valueOf(toString(cut, cut2));
            String concat;
            if (value.length() != 0) {
                concat = "Invalid range: ".concat(value);
            }
            else {
                concat = new String("Invalid range: ");
            }
            throw new IllegalArgumentException(concat);
        }
        this.lowerBound = Preconditions.checkNotNull(cut);
        this.upperBound = Preconditions.checkNotNull(cut2);
    }
    
    public static <C extends Comparable<?>> Range<C> all() {
        return (Range<C>)Range.ALL;
    }
    
    public static <C extends Comparable<?>> Range<C> atLeast(final C c) {
        return create((Cut<C>)Cut.belowValue((C)c), Cut.aboveAll());
    }
    
    public static <C extends Comparable<?>> Range<C> atMost(final C c) {
        return create(Cut.belowAll(), (Cut<C>)Cut.aboveValue((C)c));
    }
    
    private static <T> SortedSet<T> cast(final Iterable<T> iterable) {
        return (SortedSet<T>)iterable;
    }
    
    public static <C extends Comparable<?>> Range<C> closed(final C c, final C c2) {
        return create((Cut<C>)Cut.belowValue((C)c), (Cut<C>)Cut.aboveValue((C)c2));
    }
    
    public static <C extends Comparable<?>> Range<C> closedOpen(final C c, final C c2) {
        return create((Cut<C>)Cut.belowValue((C)c), (Cut<C>)Cut.belowValue((C)c2));
    }
    
    static int compareOrThrow(final Comparable comparable, final Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }
    
    static <C extends Comparable<?>> Range<C> create(final Cut<C> cut, final Cut<C> cut2) {
        return new Range<C>(cut, cut2);
    }
    
    public static <C extends Comparable<?>> Range<C> downTo(final C c, final BoundType boundType) {
        switch (boundType) {
            default: {
                throw new AssertionError();
            }
            case OPEN: {
                return greaterThan(c);
            }
            case CLOSED: {
                return atLeast(c);
            }
        }
    }
    
    public static <C extends Comparable<?>> Range<C> encloseAll(final Iterable<C> iterable) {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof ContiguousSet) {
            return ((ContiguousSet<C>)iterable).range();
        }
        final Iterator<T> iterator = (Iterator<T>)iterable.iterator();
        Comparable<?> comparable2;
        Comparable<?> comparable = comparable2 = Preconditions.checkNotNull((C)iterator.next());
        while (iterator.hasNext()) {
            final Comparable<?> comparable3 = Preconditions.checkNotNull((C)iterator.next());
            comparable = Ordering.natural().min(comparable, comparable3);
            comparable2 = Ordering.natural().max(comparable2, comparable3);
        }
        return closed(comparable, comparable2);
    }
    
    public static <C extends Comparable<?>> Range<C> greaterThan(final C c) {
        return create((Cut<C>)Cut.aboveValue((C)c), Cut.aboveAll());
    }
    
    public static <C extends Comparable<?>> Range<C> lessThan(final C c) {
        return create(Cut.belowAll(), (Cut<C>)Cut.belowValue((C)c));
    }
    
    static <C extends Comparable<?>> Function<Range<C>, Cut<C>> lowerBoundFn() {
        return (Function<Range<C>, Cut<C>>)Range.LOWER_BOUND_FN;
    }
    
    public static <C extends Comparable<?>> Range<C> open(final C c, final C c2) {
        return create((Cut<C>)Cut.aboveValue((C)c), (Cut<C>)Cut.belowValue((C)c2));
    }
    
    public static <C extends Comparable<?>> Range<C> openClosed(final C c, final C c2) {
        return create((Cut<C>)Cut.aboveValue((C)c), (Cut<C>)Cut.aboveValue((C)c2));
    }
    
    public static <C extends Comparable<?>> Range<C> range(final C c, final BoundType boundType, final C c2, final BoundType boundType2) {
        Preconditions.checkNotNull(boundType);
        Preconditions.checkNotNull(boundType2);
        Cut<C> cut;
        if (boundType == BoundType.OPEN) {
            cut = Cut.aboveValue(c);
        }
        else {
            cut = (Cut<C>)Cut.belowValue((C)c);
        }
        Cut<C> cut2;
        if (boundType2 == BoundType.OPEN) {
            cut2 = Cut.belowValue(c2);
        }
        else {
            cut2 = (Cut<C>)Cut.aboveValue((C)c2);
        }
        return create(cut, cut2);
    }
    
    public static <C extends Comparable<?>> Range<C> singleton(final C c) {
        return closed(c, c);
    }
    
    private static String toString(final Cut<?> cut, final Cut<?> cut2) {
        final StringBuilder sb = new StringBuilder(16);
        cut.describeAsLowerBound(sb);
        sb.append('\u2025');
        cut2.describeAsUpperBound(sb);
        return sb.toString();
    }
    
    public static <C extends Comparable<?>> Range<C> upTo(final C c, final BoundType boundType) {
        switch (boundType) {
            default: {
                throw new AssertionError();
            }
            case OPEN: {
                return lessThan(c);
            }
            case CLOSED: {
                return atMost(c);
            }
        }
    }
    
    static <C extends Comparable<?>> Function<Range<C>, Cut<C>> upperBoundFn() {
        return (Function<Range<C>, Cut<C>>)Range.UPPER_BOUND_FN;
    }
    
    @Deprecated
    @Override
    public boolean apply(final C c) {
        return this.contains(c);
    }
    
    public Range<C> canonical(final DiscreteDomain<C> discreteDomain) {
        Preconditions.checkNotNull(discreteDomain);
        final Cut<C> canonical = this.lowerBound.canonical(discreteDomain);
        final Cut<C> canonical2 = this.upperBound.canonical(discreteDomain);
        if (canonical == this.lowerBound && canonical2 == this.upperBound) {
            return this;
        }
        return create(canonical, canonical2);
    }
    
    public boolean contains(final C c) {
        Preconditions.checkNotNull(c);
        return this.lowerBound.isLessThan(c) && !this.upperBound.isLessThan(c);
    }
    
    public boolean containsAll(final Iterable<? extends C> iterable) {
        if (!Iterables.isEmpty(iterable)) {
            if (iterable instanceof SortedSet) {
                final SortedSet<C> cast = cast((Iterable<C>)iterable);
                final Comparator<? super C> comparator = cast.comparator();
                if (Ordering.natural().equals(comparator) || comparator == null) {
                    return this.contains(cast.first()) && this.contains(cast.last());
                }
            }
            final Iterator<C> iterator = iterable.iterator();
            while (iterator.hasNext()) {
                if (!this.contains(iterator.next())) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean encloses(final Range<C> range) {
        return this.lowerBound.compareTo(range.lowerBound) <= 0 && this.upperBound.compareTo(range.upperBound) >= 0;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        boolean b2;
        final boolean b = b2 = false;
        if (o instanceof Range) {
            final Range range = (Range)o;
            b2 = b;
            if (this.lowerBound.equals(range.lowerBound)) {
                b2 = b;
                if (this.upperBound.equals(range.upperBound)) {
                    b2 = true;
                }
            }
        }
        return b2;
    }
    
    public boolean hasLowerBound() {
        return this.lowerBound != Cut.belowAll();
    }
    
    public boolean hasUpperBound() {
        return this.upperBound != Cut.aboveAll();
    }
    
    @Override
    public int hashCode() {
        return this.lowerBound.hashCode() * 31 + this.upperBound.hashCode();
    }
    
    public Range<C> intersection(final Range<C> range) {
        final int compareTo = this.lowerBound.compareTo(range.lowerBound);
        final int compareTo2 = this.upperBound.compareTo(range.upperBound);
        if (compareTo >= 0 && compareTo2 <= 0) {
            return this;
        }
        if (compareTo <= 0 && compareTo2 >= 0) {
            return range;
        }
        Cut<C> cut;
        if (compareTo >= 0) {
            cut = this.lowerBound;
        }
        else {
            cut = range.lowerBound;
        }
        Cut<C> cut2;
        if (compareTo2 <= 0) {
            cut2 = this.upperBound;
        }
        else {
            cut2 = range.upperBound;
        }
        return create(cut, cut2);
    }
    
    public boolean isConnected(final Range<C> range) {
        return this.lowerBound.compareTo(range.upperBound) <= 0 && range.lowerBound.compareTo(this.upperBound) <= 0;
    }
    
    public boolean isEmpty() {
        return this.lowerBound.equals(this.upperBound);
    }
    
    public BoundType lowerBoundType() {
        return this.lowerBound.typeAsLowerBound();
    }
    
    public C lowerEndpoint() {
        return this.lowerBound.endpoint();
    }
    
    Object readResolve() {
        Range<Comparable> all = (Range<Comparable>)this;
        if (this.equals(Range.ALL)) {
            all = all();
        }
        return all;
    }
    
    public Range<C> span(final Range<C> range) {
        final int compareTo = this.lowerBound.compareTo(range.lowerBound);
        final int compareTo2 = this.upperBound.compareTo(range.upperBound);
        if (compareTo <= 0 && compareTo2 >= 0) {
            return this;
        }
        if (compareTo >= 0 && compareTo2 <= 0) {
            return range;
        }
        Cut<C> cut;
        if (compareTo <= 0) {
            cut = this.lowerBound;
        }
        else {
            cut = range.lowerBound;
        }
        Cut<C> cut2;
        if (compareTo2 >= 0) {
            cut2 = this.upperBound;
        }
        else {
            cut2 = range.upperBound;
        }
        return create(cut, cut2);
    }
    
    @Override
    public String toString() {
        return toString(this.lowerBound, this.upperBound);
    }
    
    public BoundType upperBoundType() {
        return this.upperBound.typeAsUpperBound();
    }
    
    public C upperEndpoint() {
        return this.upperBound.endpoint();
    }
}
