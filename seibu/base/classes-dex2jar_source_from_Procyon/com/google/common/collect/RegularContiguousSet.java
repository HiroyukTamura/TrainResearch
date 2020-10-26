// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.io.Serializable;
import com.google.common.base.Preconditions;
import java.util.Set;
import java.util.Iterator;
import com.google.common.annotations.GwtIncompatible;
import java.util.Collection;
import javax.annotation.Nullable;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
final class RegularContiguousSet<C extends Comparable> extends ContiguousSet<C>
{
    private static final long serialVersionUID = 0L;
    private final Range<C> range;
    
    RegularContiguousSet(final Range<C> range, final DiscreteDomain<C> discreteDomain) {
        super(discreteDomain);
        this.range = range;
    }
    
    private static boolean equalsOrThrow(final Comparable<?> comparable, @Nullable final Comparable<?> comparable2) {
        return comparable2 != null && Range.compareOrThrow(comparable, comparable2) == 0;
    }
    
    private ContiguousSet<C> intersectionInCurrentDomain(final Range<C> range) {
        if (this.range.isConnected(range)) {
            return ContiguousSet.create(this.range.intersection(range), this.domain);
        }
        return new EmptyContiguousSet<C>(this.domain);
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        if (o == null) {
            return false;
        }
        try {
            return this.range.contains((C)o);
        }
        catch (ClassCastException ex) {
            return false;
        }
    }
    
    @Override
    public boolean containsAll(final Collection<?> collection) {
        return Collections2.containsAllImpl(this, collection);
    }
    
    @GwtIncompatible("NavigableSet")
    @Override
    public UnmodifiableIterator<C> descendingIterator() {
        return new AbstractSequentialIterator<C>(this.last()) {
            final C first = RegularContiguousSet.this.first();
            
            @Override
            protected C computeNext(final C c) {
                if (equalsOrThrow(c, this.first)) {
                    return null;
                }
                return (C)RegularContiguousSet.this.domain.previous((C)c);
            }
        };
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (o != this) {
            if (o instanceof RegularContiguousSet) {
                final RegularContiguousSet set = (RegularContiguousSet)o;
                if (this.domain.equals(set.domain)) {
                    if (!this.first().equals(set.first()) || !this.last().equals(set.last())) {
                        return false;
                    }
                    return true;
                }
            }
            return super.equals(o);
        }
        return true;
    }
    
    @Override
    public C first() {
        return this.range.lowerBound.leastValueAbove(this.domain);
    }
    
    @Override
    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }
    
    @Override
    ContiguousSet<C> headSetImpl(final C c, final boolean b) {
        return this.intersectionInCurrentDomain(Range.upTo(c, BoundType.forBoolean(b)));
    }
    
    @GwtIncompatible("not used by GWT emulation")
    @Override
    int indexOf(final Object o) {
        if (this.contains(o)) {
            return (int)this.domain.distance(this.first(), (C)o);
        }
        return -1;
    }
    
    @Override
    public ContiguousSet<C> intersection(final ContiguousSet<C> set) {
        Preconditions.checkNotNull(set);
        Preconditions.checkArgument(this.domain.equals(set.domain));
        if (set.isEmpty()) {
            return set;
        }
        final Comparable comparable = Ordering.natural().max(this.first(), set.first());
        final Comparable comparable2 = Ordering.natural().min(this.last(), set.last());
        ContiguousSet<C> create;
        if (comparable.compareTo(comparable2) < 0) {
            create = ContiguousSet.create((Range<C>)Range.closed((C)comparable, comparable2), this.domain);
        }
        else {
            create = new EmptyContiguousSet<C>(this.domain);
        }
        return create;
    }
    
    @Override
    public boolean isEmpty() {
        return false;
    }
    
    @Override
    boolean isPartialView() {
        return false;
    }
    
    @Override
    public UnmodifiableIterator<C> iterator() {
        return new AbstractSequentialIterator<C>(this.first()) {
            final C last = RegularContiguousSet.this.last();
            
            @Override
            protected C computeNext(final C c) {
                if (equalsOrThrow(c, this.last)) {
                    return null;
                }
                return (C)RegularContiguousSet.this.domain.next((C)c);
            }
        };
    }
    
    @Override
    public C last() {
        return this.range.upperBound.greatestValueBelow(this.domain);
    }
    
    @Override
    public Range<C> range() {
        return this.range(BoundType.CLOSED, BoundType.CLOSED);
    }
    
    @Override
    public Range<C> range(final BoundType boundType, final BoundType boundType2) {
        return Range.create(this.range.lowerBound.withLowerBoundType(boundType, this.domain), this.range.upperBound.withUpperBoundType(boundType2, this.domain));
    }
    
    @Override
    public int size() {
        final long distance = this.domain.distance(this.first(), this.last());
        if (distance >= 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int)distance + 1;
    }
    
    @Override
    ContiguousSet<C> subSetImpl(final C c, final boolean b, final C c2, final boolean b2) {
        if (c.compareTo(c2) == 0 && !b && !b2) {
            return new EmptyContiguousSet<C>(this.domain);
        }
        return this.intersectionInCurrentDomain(Range.range(c, BoundType.forBoolean(b), c2, BoundType.forBoolean(b2)));
    }
    
    @Override
    ContiguousSet<C> tailSetImpl(final C c, final boolean b) {
        return this.intersectionInCurrentDomain(Range.downTo(c, BoundType.forBoolean(b)));
    }
    
    @GwtIncompatible("serialization")
    @Override
    Object writeReplace() {
        return new SerializedForm((Range)this.range, (DiscreteDomain)this.domain);
    }
    
    @GwtIncompatible("serialization")
    private static final class SerializedForm<C extends Comparable> implements Serializable
    {
        final DiscreteDomain<C> domain;
        final Range<C> range;
        
        private SerializedForm(final Range<C> range, final DiscreteDomain<C> domain) {
            this.range = range;
            this.domain = domain;
        }
        
        private Object readResolve() {
            return new RegularContiguousSet((Range<Comparable>)this.range, (DiscreteDomain<Comparable>)this.domain);
        }
    }
}
