// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.NoSuchElementException;
import com.google.common.base.Function;
import java.util.List;
import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.Beta;

@Beta
@GwtIncompatible("NavigableMap")
public class ImmutableRangeMap<K extends Comparable<?>, V> implements RangeMap<K, V>
{
    private static final ImmutableRangeMap<Comparable<?>, Object> EMPTY;
    private final ImmutableList<Range<K>> ranges;
    private final ImmutableList<V> values;
    
    static {
        EMPTY = new ImmutableRangeMap<Comparable<?>, Object>(ImmutableList.of(), ImmutableList.of());
    }
    
    ImmutableRangeMap(final ImmutableList<Range<K>> ranges, final ImmutableList<V> values) {
        this.ranges = ranges;
        this.values = values;
    }
    
    public static <K extends Comparable<?>, V> Builder<K, V> builder() {
        return new Builder<K, V>();
    }
    
    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> copyOf(final RangeMap<K, ? extends V> rangeMap) {
        if (rangeMap instanceof ImmutableRangeMap) {
            return (ImmutableRangeMap<K, V>)rangeMap;
        }
        final Map<Range<Comparable>, V> mapOfRanges = (Map<Range<Comparable>, V>)rangeMap.asMapOfRanges();
        final ImmutableList.Builder builder = new ImmutableList.Builder<Range<Comparable>>(mapOfRanges.size());
        final ImmutableList.Builder builder2 = new ImmutableList.Builder<Object>(mapOfRanges.size());
        for (final Map.Entry<Range<Comparable>, V> entry : mapOfRanges.entrySet()) {
            builder.add(entry.getKey());
            builder2.add(entry.getValue());
        }
        return new ImmutableRangeMap<K, V>(builder.build(), builder2.build());
    }
    
    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of() {
        return (ImmutableRangeMap<K, V>)ImmutableRangeMap.EMPTY;
    }
    
    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of(final Range<K> range, final V v) {
        return new ImmutableRangeMap<K, V>((ImmutableList<Range<K>>)ImmutableList.of((Range<K>)range), ImmutableList.of(v));
    }
    
    @Override
    public ImmutableMap<Range<K>, V> asMapOfRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableMap.of();
        }
        return new RegularImmutableSortedMap<Range<K>, V>(new RegularImmutableSortedSet<Range<K>>(this.ranges, Range.RANGE_LEX_ORDERING), this.values);
    }
    
    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof RangeMap && this.asMapOfRanges().equals(((RangeMap)o).asMapOfRanges());
    }
    
    @Nullable
    @Override
    public V get(final K k) {
        final int binarySearch = SortedLists.binarySearch(this.ranges, (Function<? super Range<K>, Cut<Comparable>>)Range.lowerBoundFn(), (Cut<Comparable>)Cut.belowValue(k), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (binarySearch != -1 && ((Range<K>)this.ranges.get(binarySearch)).contains(k)) {
            return (V)this.values.get(binarySearch);
        }
        return null;
    }
    
    @Nullable
    @Override
    public Map.Entry<Range<K>, V> getEntry(final K k) {
        final int binarySearch = SortedLists.binarySearch(this.ranges, (Function<? super Range<K>, Cut<Comparable>>)Range.lowerBoundFn(), (Cut<Comparable>)Cut.belowValue(k), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (binarySearch != -1) {
            final Range<K> range = this.ranges.get(binarySearch);
            if (range.contains(k)) {
                return Maps.immutableEntry(range, this.values.get(binarySearch));
            }
        }
        return null;
    }
    
    @Override
    public int hashCode() {
        return this.asMapOfRanges().hashCode();
    }
    
    @Override
    public void put(final Range<K> range, final V v) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void putAll(final RangeMap<K, V> rangeMap) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void remove(final Range<K> range) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public Range<K> span() {
        if (this.ranges.isEmpty()) {
            throw new NoSuchElementException();
        }
        return Range.create((Cut<K>)this.ranges.get(0).lowerBound, (Cut<K>)this.ranges.get(this.ranges.size() - 1).upperBound);
    }
    
    @Override
    public ImmutableRangeMap<K, V> subRangeMap(final Range<K> range) {
        if (Preconditions.checkNotNull(range).isEmpty()) {
            return of();
        }
        if (this.ranges.isEmpty() || range.encloses(this.span())) {
            return this;
        }
        final int binarySearch = SortedLists.binarySearch(this.ranges, (Function<? super Range<K>, Cut<Comparable>>)Range.upperBoundFn(), (Cut<Comparable>)range.lowerBound, SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
        final int binarySearch2 = SortedLists.binarySearch(this.ranges, (Function<? super Range<K>, Cut<Comparable>>)Range.lowerBoundFn(), (Cut<Comparable>)range.upperBound, SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
        if (binarySearch >= binarySearch2) {
            return of();
        }
        return new ImmutableRangeMap<K, V>(new ImmutableList<Range<K>>() {
            final /* synthetic */ int val$len = binarySearch2 - binarySearch;
            
            @Override
            public Range<K> get(final int n) {
                Preconditions.checkElementIndex(n, this.val$len);
                if (n == 0 || n == this.val$len - 1) {
                    return ((Range)ImmutableRangeMap.this.ranges.get(binarySearch + n)).intersection(range);
                }
                return (Range<K>)ImmutableRangeMap.this.ranges.get(binarySearch + n);
            }
            
            @Override
            boolean isPartialView() {
                return true;
            }
            
            @Override
            public int size() {
                return this.val$len;
            }
        }, this.values.subList(binarySearch, binarySearch2)) {
            @Override
            public ImmutableRangeMap<K, V> subRangeMap(final Range<K> range) {
                if (range.isConnected(range)) {
                    return ImmutableRangeMap.this.subRangeMap(range.intersection(range));
                }
                return ImmutableRangeMap.of();
            }
        };
    }
    
    @Override
    public String toString() {
        return this.asMapOfRanges().toString();
    }
    
    public static final class Builder<K extends Comparable<?>, V>
    {
        private final RangeSet<K> keyRanges;
        private final RangeMap<K, V> rangeMap;
        
        public Builder() {
            this.keyRanges = (RangeSet<K>)TreeRangeSet.create();
            this.rangeMap = (RangeMap<K, V>)TreeRangeMap.create();
        }
        
        public ImmutableRangeMap<K, V> build() {
            final Map<Range<K>, V> mapOfRanges = this.rangeMap.asMapOfRanges();
            final ImmutableList.Builder builder = new ImmutableList.Builder<Range<K>>(mapOfRanges.size());
            final ImmutableList.Builder builder2 = new ImmutableList.Builder<V>(mapOfRanges.size());
            for (final Map.Entry<Range<K>, V> entry : mapOfRanges.entrySet()) {
                builder.add(entry.getKey());
                builder2.add(entry.getValue());
            }
            return new ImmutableRangeMap<K, V>((ImmutableList<Range<Comparable>>)builder.build(), (ImmutableList<Object>)builder2.build());
        }
        
        public Builder<K, V> put(final Range<K> obj, final V v) {
            Preconditions.checkNotNull(obj);
            Preconditions.checkNotNull(v);
            Preconditions.checkArgument(!obj.isEmpty(), "Range must not be empty, but was %s", obj);
            if (!this.keyRanges.complement().encloses(obj)) {
                for (final Map.Entry<Range<K>, V> obj2 : this.rangeMap.asMapOfRanges().entrySet()) {
                    final Range<K> range = obj2.getKey();
                    if (range.isConnected(obj) && !range.intersection(obj).isEmpty()) {
                        final String value = String.valueOf(String.valueOf(obj));
                        final String value2 = String.valueOf(String.valueOf(obj2));
                        throw new IllegalArgumentException(new StringBuilder(value.length() + 47 + value2.length()).append("Overlapping ranges: range ").append(value).append(" overlaps with entry ").append(value2).toString());
                    }
                }
            }
            this.keyRanges.add(obj);
            this.rangeMap.put(obj, v);
            return this;
        }
        
        public Builder<K, V> putAll(final RangeMap<K, ? extends V> rangeMap) {
            for (final Map.Entry<Range<K>, ? extends V> entry : rangeMap.asMapOfRanges().entrySet()) {
                this.put((Range<K>)entry.getKey(), (V)entry.getValue());
            }
            return this;
        }
    }
}
