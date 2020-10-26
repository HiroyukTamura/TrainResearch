// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import com.google.common.base.Predicates;
import java.util.Collection;
import com.google.common.base.MoreObjects;
import java.util.ArrayList;
import com.google.common.base.Predicate;
import java.util.AbstractSet;
import java.util.Set;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import java.util.Collections;
import java.util.Map;
import java.util.NavigableMap;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.Beta;

@Beta
@GwtIncompatible("NavigableMap")
public final class TreeRangeMap<K extends Comparable, V> implements RangeMap<K, V>
{
    private static final RangeMap EMPTY_SUB_RANGE_MAP;
    private final NavigableMap<Cut<K>, RangeMapEntry<K, V>> entriesByLowerBound;
    
    static {
        EMPTY_SUB_RANGE_MAP = new RangeMap() {
            @Override
            public Map<Range, Object> asMapOfRanges() {
                return (Map<Range, Object>)Collections.emptyMap();
            }
            
            @Override
            public void clear() {
            }
            
            @Nullable
            @Override
            public Object get(final Comparable comparable) {
                return null;
            }
            
            @Nullable
            @Override
            public Map.Entry<Range, Object> getEntry(final Comparable comparable) {
                return null;
            }
            
            @Override
            public void put(final Range obj, final Object o) {
                Preconditions.checkNotNull(obj);
                final String value = String.valueOf(String.valueOf(obj));
                throw new IllegalArgumentException(new StringBuilder(value.length() + 46).append("Cannot insert range ").append(value).append(" into an empty subRangeMap").toString());
            }
            
            @Override
            public void putAll(final RangeMap rangeMap) {
                if (!rangeMap.asMapOfRanges().isEmpty()) {
                    throw new IllegalArgumentException("Cannot putAll(nonEmptyRangeMap) into an empty subRangeMap");
                }
            }
            
            @Override
            public void remove(final Range range) {
                Preconditions.checkNotNull(range);
            }
            
            @Override
            public Range span() {
                throw new NoSuchElementException();
            }
            
            @Override
            public RangeMap subRangeMap(final Range range) {
                Preconditions.checkNotNull(range);
                return this;
            }
        };
    }
    
    private TreeRangeMap() {
        this.entriesByLowerBound = (NavigableMap<Cut<K>, RangeMapEntry<K, V>>)Maps.newTreeMap();
    }
    
    public static <K extends Comparable, V> TreeRangeMap<K, V> create() {
        return new TreeRangeMap<K, V>();
    }
    
    private RangeMap<K, V> emptySubRangeMap() {
        return (RangeMap<K, V>)TreeRangeMap.EMPTY_SUB_RANGE_MAP;
    }
    
    private void putRangeMapEntry(final Cut<K> cut, final Cut<K> cut2, final V v) {
        this.entriesByLowerBound.put(cut, new RangeMapEntry<K, V>(cut, cut2, v));
    }
    
    @Override
    public Map<Range<K>, V> asMapOfRanges() {
        return new AsMapOfRanges();
    }
    
    @Override
    public void clear() {
        this.entriesByLowerBound.clear();
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof RangeMap && this.asMapOfRanges().equals(((RangeMap)o).asMapOfRanges());
    }
    
    @Nullable
    @Override
    public V get(final K k) {
        final Map.Entry<Range<K>, V> entry = this.getEntry(k);
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }
    
    @Nullable
    @Override
    public Map.Entry<Range<K>, V> getEntry(final K k) {
        final Map.Entry<Cut<K>, RangeMapEntry<K, V>> floorEntry = this.entriesByLowerBound.floorEntry(Cut.belowValue(k));
        if (floorEntry != null && floorEntry.getValue().contains(k)) {
            return (Map.Entry<Range<K>, V>)floorEntry.getValue();
        }
        return null;
    }
    
    @Override
    public int hashCode() {
        return this.asMapOfRanges().hashCode();
    }
    
    @Override
    public void put(final Range<K> range, final V v) {
        if (!range.isEmpty()) {
            Preconditions.checkNotNull(v);
            this.remove(range);
            this.entriesByLowerBound.put(range.lowerBound, new RangeMapEntry<K, V>(range, v));
        }
    }
    
    @Override
    public void putAll(final RangeMap<K, V> rangeMap) {
        for (final Map.Entry<Range<K>, V> entry : rangeMap.asMapOfRanges().entrySet()) {
            this.put((Range<K>)entry.getKey(), (V)entry.getValue());
        }
    }
    
    @Override
    public void remove(final Range<K> range) {
        if (range.isEmpty()) {
            return;
        }
        final Map.Entry<Cut<K>, RangeMapEntry<K, V>> lowerEntry = this.entriesByLowerBound.lowerEntry(range.lowerBound);
        if (lowerEntry != null) {
            final RangeMapEntry<K, V> rangeMapEntry = lowerEntry.getValue();
            if (rangeMapEntry.getUpperBound().compareTo(range.lowerBound) > 0) {
                if (rangeMapEntry.getUpperBound().compareTo(range.upperBound) > 0) {
                    this.putRangeMapEntry((Cut<C>)range.upperBound, (Cut<C>)rangeMapEntry.getUpperBound(), lowerEntry.getValue().getValue());
                }
                this.putRangeMapEntry((Cut<C>)rangeMapEntry.getLowerBound(), (Cut<C>)range.lowerBound, lowerEntry.getValue().getValue());
            }
        }
        final Map.Entry<Cut<K>, RangeMapEntry<K, V>> lowerEntry2 = this.entriesByLowerBound.lowerEntry(range.upperBound);
        if (lowerEntry2 != null) {
            final RangeMapEntry<K, V> rangeMapEntry2 = lowerEntry2.getValue();
            if (rangeMapEntry2.getUpperBound().compareTo(range.upperBound) > 0) {
                this.putRangeMapEntry((Cut<C>)range.upperBound, (Cut<C>)rangeMapEntry2.getUpperBound(), lowerEntry2.getValue().getValue());
                this.entriesByLowerBound.remove(range.lowerBound);
            }
        }
        this.entriesByLowerBound.subMap(range.lowerBound, range.upperBound).clear();
    }
    
    @Override
    public Range<K> span() {
        final Map.Entry<Cut<K>, RangeMapEntry<K, V>> firstEntry = this.entriesByLowerBound.firstEntry();
        final Map.Entry<Cut<K>, RangeMapEntry<K, V>> lastEntry = this.entriesByLowerBound.lastEntry();
        if (firstEntry == null) {
            throw new NoSuchElementException();
        }
        return Range.create(firstEntry.getValue().getKey().lowerBound, lastEntry.getValue().getKey().upperBound);
    }
    
    @Override
    public RangeMap<K, V> subRangeMap(final Range<K> range) {
        if (range.equals(Range.all())) {
            return this;
        }
        return new SubRangeMap(range);
    }
    
    @Override
    public String toString() {
        return this.entriesByLowerBound.values().toString();
    }
    
    private final class AsMapOfRanges extends AbstractMap<Range<K>, V>
    {
        @Override
        public boolean containsKey(@Nullable final Object o) {
            return this.get(o) != null;
        }
        
        @Override
        public Set<Entry<Range<K>, V>> entrySet() {
            return new AbstractSet<Entry<Range<K>, V>>() {
                @Override
                public Iterator<Entry<Range<K>, V>> iterator() {
                    return (Iterator<Entry<Range<K>, V>>)TreeRangeMap.this.entriesByLowerBound.values().iterator();
                }
                
                @Override
                public int size() {
                    return TreeRangeMap.this.entriesByLowerBound.size();
                }
            };
        }
        
        @Override
        public V get(@Nullable final Object o) {
            if (o instanceof Range) {
                final Range range = (Range)o;
                final RangeMapEntry rangeMapEntry = (RangeMapEntry)TreeRangeMap.this.entriesByLowerBound.get(range.lowerBound);
                if (rangeMapEntry != null && rangeMapEntry.getKey().equals(range)) {
                    return rangeMapEntry.getValue();
                }
            }
            return null;
        }
    }
    
    private static final class RangeMapEntry<K extends Comparable, V> extends AbstractMapEntry<Range<K>, V>
    {
        private final Range<K> range;
        private final V value;
        
        RangeMapEntry(final Cut<K> cut, final Cut<K> cut2, final V v) {
            this(Range.create(cut, cut2), v);
        }
        
        RangeMapEntry(final Range<K> range, final V value) {
            this.range = range;
            this.value = value;
        }
        
        public boolean contains(final K k) {
            return this.range.contains(k);
        }
        
        @Override
        public Range<K> getKey() {
            return this.range;
        }
        
        Cut<K> getLowerBound() {
            return this.range.lowerBound;
        }
        
        Cut<K> getUpperBound() {
            return this.range.upperBound;
        }
        
        @Override
        public V getValue() {
            return this.value;
        }
    }
    
    private class SubRangeMap implements RangeMap<K, V>
    {
        private final Range<K> subRange;
        
        SubRangeMap(final Range<K> subRange) {
            this.subRange = subRange;
        }
        
        @Override
        public Map<Range<K>, V> asMapOfRanges() {
            return new SubRangeMapAsMap();
        }
        
        @Override
        public void clear() {
            TreeRangeMap.this.remove(this.subRange);
        }
        
        @Override
        public boolean equals(@Nullable final Object o) {
            return o instanceof RangeMap && this.asMapOfRanges().equals(((RangeMap)o).asMapOfRanges());
        }
        
        @Nullable
        @Override
        public V get(final K k) {
            if (this.subRange.contains(k)) {
                return TreeRangeMap.this.get(k);
            }
            return null;
        }
        
        @Nullable
        @Override
        public Map.Entry<Range<K>, V> getEntry(final K k) {
            if (this.subRange.contains(k)) {
                final Map.Entry<Range<K>, V> entry = TreeRangeMap.this.getEntry(k);
                if (entry != null) {
                    return Maps.immutableEntry(entry.getKey().intersection(this.subRange), (V)entry.getValue());
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
            Preconditions.checkArgument(this.subRange.encloses(range), "Cannot put range %s into a subRangeMap(%s)", range, this.subRange);
            TreeRangeMap.this.put(range, v);
        }
        
        @Override
        public void putAll(final RangeMap<K, V> rangeMap) {
            if (rangeMap.asMapOfRanges().isEmpty()) {
                return;
            }
            final Range<K> span = rangeMap.span();
            Preconditions.checkArgument(this.subRange.encloses(span), "Cannot putAll rangeMap with span %s into a subRangeMap(%s)", span, this.subRange);
            TreeRangeMap.this.putAll(rangeMap);
        }
        
        @Override
        public void remove(final Range<K> range) {
            if (range.isConnected(this.subRange)) {
                TreeRangeMap.this.remove(range.intersection(this.subRange));
            }
        }
        
        @Override
        public Range<K> span() {
            final Map.Entry<Cut<K>, RangeMapEntry<K, V>> floorEntry = TreeRangeMap.this.entriesByLowerBound.floorEntry(this.subRange.lowerBound);
            Cut<K> lowerBound = null;
            Label_0057: {
                if (floorEntry == null || floorEntry.getValue().getUpperBound().compareTo(this.subRange.lowerBound) <= 0) {
                    final Cut<K> cut = TreeRangeMap.this.entriesByLowerBound.ceilingKey(this.subRange.lowerBound);
                    if (cut != null) {
                        lowerBound = cut;
                        if (cut.compareTo(this.subRange.upperBound) < 0) {
                            break Label_0057;
                        }
                    }
                    throw new NoSuchElementException();
                }
                lowerBound = this.subRange.lowerBound;
            }
            final Map.Entry<Cut<K>, RangeMapEntry<K, V>> lowerEntry = TreeRangeMap.this.entriesByLowerBound.lowerEntry(this.subRange.upperBound);
            if (lowerEntry == null) {
                throw new NoSuchElementException();
            }
            Cut<K> cut2;
            if (lowerEntry.getValue().getUpperBound().compareTo(this.subRange.upperBound) >= 0) {
                cut2 = this.subRange.upperBound;
            }
            else {
                cut2 = lowerEntry.getValue().getUpperBound();
            }
            return Range.create(lowerBound, cut2);
        }
        
        @Override
        public RangeMap<K, V> subRangeMap(final Range<K> range) {
            if (!range.isConnected(this.subRange)) {
                return (RangeMap<K, V>)TreeRangeMap.this.emptySubRangeMap();
            }
            return TreeRangeMap.this.subRangeMap(range.intersection(this.subRange));
        }
        
        @Override
        public String toString() {
            return this.asMapOfRanges().toString();
        }
        
        class SubRangeMapAsMap extends AbstractMap<Range<K>, V>
        {
            private boolean removeEntryIf(final Predicate<? super Entry<Range<K>, V>> predicate) {
                final ArrayList<Object> arrayList = Lists.newArrayList();
                for (final Map.Entry<?, ?> entry : this.entrySet()) {
                    if (predicate.apply((Object)entry)) {
                        arrayList.add(entry.getKey());
                    }
                }
                final Iterator<Range<K>> iterator2 = arrayList.iterator();
                while (iterator2.hasNext()) {
                    TreeRangeMap.this.remove(iterator2.next());
                }
                return !arrayList.isEmpty();
            }
            
            @Override
            public void clear() {
                SubRangeMap.this.clear();
            }
            
            @Override
            public boolean containsKey(final Object o) {
                return this.get(o) != null;
            }
            
            @Override
            public Set<Entry<Range<K>, V>> entrySet() {
                return (Set<Entry<Range<K>, V>>)new Maps.EntrySet<Range<K>, V>() {
                    @Override
                    public boolean isEmpty() {
                        return !this.iterator().hasNext();
                    }
                    
                    @Override
                    public Iterator<Entry<Range<K>, V>> iterator() {
                        if (SubRangeMap.this.subRange.isEmpty()) {
                            return (Iterator<Entry<Range<K>, V>>)Iterators.emptyIterator();
                        }
                        return new AbstractIterator<Entry<Range<K>, V>>() {
                            final /* synthetic */ Iterator val$backingItr = TreeRangeMap.this.entriesByLowerBound.tailMap(MoreObjects.firstNonNull((Cut<C>)TreeRangeMap.this.entriesByLowerBound.floorKey(SubRangeMap.this.subRange.lowerBound), SubRangeMap.this.subRange.lowerBound), true).values().iterator();
                            
                            @Override
                            protected Entry<Range<K>, V> computeNext() {
                                while (this.val$backingItr.hasNext()) {
                                    final RangeMapEntry<C, V> rangeMapEntry = this.val$backingItr.next();
                                    if (rangeMapEntry.getLowerBound().compareTo(SubRangeMap.this.subRange.upperBound) >= 0) {
                                        break;
                                    }
                                    if (rangeMapEntry.getUpperBound().compareTo(SubRangeMap.this.subRange.lowerBound) > 0) {
                                        return Maps.immutableEntry((Range<K>)rangeMapEntry.getKey().intersection(SubRangeMap.this.subRange), (V)rangeMapEntry.getValue());
                                    }
                                }
                                return (Entry<Range<K>, V>)((AbstractIterator<Map.Entry>)this).endOfData();
                            }
                        };
                    }
                    
                    @Override
                    Map<Range<K>, V> map() {
                        return SubRangeMapAsMap.this;
                    }
                    
                    @Override
                    public boolean retainAll(final Collection<?> collection) {
                        return SubRangeMapAsMap.this.removeEntryIf(Predicates.not(Predicates.in(collection)));
                    }
                    
                    @Override
                    public int size() {
                        return Iterators.size(this.iterator());
                    }
                };
            }
            
            @Override
            public V get(final Object o) {
                try {
                    if (o instanceof Range) {
                        final Range range = (Range)o;
                        if (SubRangeMap.this.subRange.encloses(range)) {
                            if (range.isEmpty()) {
                                return null;
                            }
                            RangeMapEntry<Comparable, V> rangeMapEntry = null;
                            if (range.lowerBound.compareTo(SubRangeMap.this.subRange.lowerBound) == 0) {
                                final Map.Entry<Cut<C>, Object> floorEntry = TreeRangeMap.this.entriesByLowerBound.floorEntry(range.lowerBound);
                                if (floorEntry != null) {
                                    rangeMapEntry = floorEntry.getValue();
                                }
                            }
                            else {
                                rangeMapEntry = (RangeMapEntry<Comparable, V>)TreeRangeMap.this.entriesByLowerBound.get(range.lowerBound);
                            }
                            if (rangeMapEntry != null && rangeMapEntry.getKey().isConnected(SubRangeMap.this.subRange) && rangeMapEntry.getKey().intersection(SubRangeMap.this.subRange).equals(range)) {
                                return rangeMapEntry.getValue();
                            }
                        }
                    }
                }
                catch (ClassCastException ex) {}
                return null;
            }
            
            @Override
            public Set<Range<K>> keySet() {
                return (Set<Range<K>>)new Maps.KeySet<Range<K>, V>(this) {
                    @Override
                    public boolean remove(@Nullable final Object o) {
                        return SubRangeMapAsMap.this.remove(o) != null;
                    }
                    
                    @Override
                    public boolean retainAll(final Collection<?> collection) {
                        return SubRangeMapAsMap.this.removeEntryIf(Predicates.compose((Predicate<Object>)Predicates.not(Predicates.in((Collection<? extends B>)collection)), Maps.keyFunction()));
                    }
                };
            }
            
            @Override
            public V remove(final Object o) {
                final V value = this.get(o);
                if (value != null) {
                    TreeRangeMap.this.remove((Range<K>)o);
                    return value;
                }
                return null;
            }
            
            @Override
            public Collection<V> values() {
                return (Collection<V>)new Maps.Values<Range<K>, V>(this) {
                    @Override
                    public boolean removeAll(final Collection<?> collection) {
                        return SubRangeMapAsMap.this.removeEntryIf(Predicates.compose(Predicates.in(collection), Maps.valueFunction()));
                    }
                    
                    @Override
                    public boolean retainAll(final Collection<?> collection) {
                        return SubRangeMapAsMap.this.removeEntryIf(Predicates.compose((Predicate<Object>)Predicates.not(Predicates.in((Collection<? extends B>)collection)), Maps.valueFunction()));
                    }
                };
            }
        }
    }
}
