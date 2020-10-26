// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.Collection;
import java.util.Set;
import java.util.NavigableSet;
import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.SortedMap;
import com.google.common.base.Preconditions;
import java.util.Map;
import java.util.Comparator;
import com.google.common.annotations.GwtCompatible;
import java.util.NavigableMap;

@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableSortedMap<K, V> extends ImmutableSortedMapFauxverideShim<K, V> implements NavigableMap<K, V>
{
    private static final ImmutableSortedMap<Comparable, Object> NATURAL_EMPTY_MAP;
    private static final Comparator<Comparable> NATURAL_ORDER;
    private static final long serialVersionUID = 0L;
    private transient ImmutableSortedMap<K, V> descendingMap;
    
    static {
        NATURAL_ORDER = Ordering.natural();
        NATURAL_EMPTY_MAP = new EmptyImmutableSortedMap<Comparable, Object>(ImmutableSortedMap.NATURAL_ORDER);
    }
    
    ImmutableSortedMap() {
    }
    
    ImmutableSortedMap(final ImmutableSortedMap<K, V> descendingMap) {
        this.descendingMap = descendingMap;
    }
    
    public static <K, V> ImmutableSortedMap<K, V> copyOf(final Map<? extends K, ? extends V> map) {
        return copyOfInternal(map, (Comparator<? super K>)Ordering.natural());
    }
    
    public static <K, V> ImmutableSortedMap<K, V> copyOf(final Map<? extends K, ? extends V> map, final Comparator<? super K> comparator) {
        return (ImmutableSortedMap<K, V>)copyOfInternal((Map<?, ?>)map, (Comparator<? super Object>)Preconditions.checkNotNull(comparator));
    }
    
    private static <K, V> ImmutableSortedMap<K, V> copyOfInternal(final Map<? extends K, ? extends V> map, final Comparator<? super K> comparator) {
        boolean equals = false;
        if (map instanceof SortedMap) {
            final Comparator<? super Object> comparator2 = ((ImmutableSortedMap<Object, Object>)map).comparator();
            if (comparator2 == null) {
                equals = (comparator == ImmutableSortedMap.NATURAL_ORDER);
            }
            else {
                equals = comparator.equals(comparator2);
            }
        }
        if (equals && map instanceof ImmutableSortedMap) {
            final ImmutableSortedMap<Object, Object> immutableSortedMap = (ImmutableSortedMap<Object, Object>)map;
            if (!immutableSortedMap.isPartialView()) {
                return (ImmutableSortedMap<K, V>)immutableSortedMap;
            }
        }
        final Entry[] array = map.entrySet().toArray((Entry<K, V>[])new Entry[0]);
        return fromEntries(comparator, equals, array.length, (Entry<K, V>[])array);
    }
    
    public static <K, V> ImmutableSortedMap<K, V> copyOfSorted(final SortedMap<K, ? extends V> sortedMap) {
        Object o;
        if ((o = sortedMap.comparator()) == null) {
            o = ImmutableSortedMap.NATURAL_ORDER;
        }
        return (ImmutableSortedMap<K, V>)copyOfInternal((Map<?, ?>)sortedMap, (Comparator<? super Object>)o);
    }
    
    static <K, V> ImmutableSortedMap<K, V> emptyMap(final Comparator<? super K> obj) {
        if (Ordering.natural().equals(obj)) {
            return of();
        }
        return new EmptyImmutableSortedMap<K, V>(obj);
    }
    
    static <K, V> ImmutableSortedMap<K, V> from(final ImmutableSortedSet<K> set, final ImmutableList<V> list) {
        if (set.isEmpty()) {
            return emptyMap((Comparator<? super K>)set.comparator());
        }
        return new RegularImmutableSortedMap<K, V>((RegularImmutableSortedSet<K>)set, list);
    }
    
    static <K, V> ImmutableSortedMap<K, V> fromEntries(final Comparator<? super K> comparator, final boolean b, final int n, final Entry<K, V>... array) {
        for (int i = 0; i < n; ++i) {
            final Entry<K, V> entry = array[i];
            array[i] = ImmutableMap.entryOf(entry.getKey(), entry.getValue());
        }
        if (!b) {
            sortEntries(comparator, n, array);
            validateEntries(n, array, comparator);
        }
        return fromSortedEntries(comparator, n, array);
    }
    
    static <K, V> ImmutableSortedMap<K, V> fromSortedEntries(final Comparator<? super K> comparator, final int n, final Entry<K, V>[] array) {
        if (n == 0) {
            return (ImmutableSortedMap<K, V>)emptyMap((Comparator<? super Object>)comparator);
        }
        final ImmutableList.Builder<K> builder = ImmutableList.builder();
        final ImmutableList.Builder<V> builder2 = ImmutableList.builder();
        for (int i = 0; i < n; ++i) {
            final Entry<K, V> entry = array[i];
            builder.add(entry.getKey());
            builder2.add(entry.getValue());
        }
        return new RegularImmutableSortedMap<K, V>(new RegularImmutableSortedSet<Object>((ImmutableList<Object>)builder.build(), (Comparator<? super Object>)comparator), (ImmutableList<Object>)builder2.build());
    }
    
    public static <K extends Comparable<?>, V> Builder<K, V> naturalOrder() {
        return new Builder<K, V>(Ordering.natural());
    }
    
    public static <K, V> ImmutableSortedMap<K, V> of() {
        return (ImmutableSortedMap<K, V>)ImmutableSortedMap.NATURAL_EMPTY_MAP;
    }
    
    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(final K k, final V v) {
        return from((ImmutableSortedSet<K>)ImmutableSortedSet.of((K)k), (ImmutableList<V>)ImmutableList.of((V)v));
    }
    
    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(final K k, final V v, final K i, final V v2) {
        return fromEntries(Ordering.natural(), false, 2, (Entry<K, V>[])new Entry[] { ImmutableMap.entryOf(k, v), ImmutableMap.entryOf(i, v2) });
    }
    
    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(final K k, final V v, final K i, final V v2, final K j, final V v3) {
        return fromEntries(Ordering.natural(), false, 3, (Entry<K, V>[])new Entry[] { ImmutableMap.entryOf(k, v), ImmutableMap.entryOf(i, v2), ImmutableMap.entryOf(j, v3) });
    }
    
    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(final K k, final V v, final K i, final V v2, final K j, final V v3, final K l, final V v4) {
        return fromEntries(Ordering.natural(), false, 4, (Entry<K, V>[])new Entry[] { ImmutableMap.entryOf(k, v), ImmutableMap.entryOf(i, v2), ImmutableMap.entryOf(j, v3), ImmutableMap.entryOf(l, v4) });
    }
    
    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(final K k, final V v, final K i, final V v2, final K j, final V v3, final K l, final V v4, final K m, final V v5) {
        return fromEntries(Ordering.natural(), false, 5, (Entry<K, V>[])new Entry[] { ImmutableMap.entryOf(k, v), ImmutableMap.entryOf(i, v2), ImmutableMap.entryOf(j, v3), ImmutableMap.entryOf(l, v4), ImmutableMap.entryOf(m, v5) });
    }
    
    public static <K, V> Builder<K, V> orderedBy(final Comparator<K> comparator) {
        return new Builder<K, V>(comparator);
    }
    
    public static <K extends Comparable<?>, V> Builder<K, V> reverseOrder() {
        return new Builder<K, V>(Ordering.natural().reverse());
    }
    
    private static <K, V> void sortEntries(final Comparator<? super K> comparator, final int toIndex, final Entry<K, V>[] a) {
        Arrays.sort(a, 0, toIndex, (Comparator<? super Entry<K, V>>)Ordering.from(comparator).onKeys());
    }
    
    private static <K, V> void validateEntries(final int n, final Entry<K, V>[] array, final Comparator<? super K> comparator) {
        for (int i = 1; i < n; ++i) {
            ImmutableMap.checkNoConflict(comparator.compare(array[i - 1].getKey(), array[i].getKey()) != 0, "key", array[i - 1], array[i]);
        }
    }
    
    @Override
    public Entry<K, V> ceilingEntry(final K k) {
        return this.tailMap(k, true).firstEntry();
    }
    
    @Override
    public K ceilingKey(final K k) {
        return Maps.keyOrNull((Entry<K, ?>)this.ceilingEntry((K)k));
    }
    
    @Override
    public Comparator<? super K> comparator() {
        return this.keySet().comparator();
    }
    
    @Override
    public boolean containsValue(@Nullable final Object o) {
        return this.values().contains(o);
    }
    
    abstract ImmutableSortedMap<K, V> createDescendingMap();
    
    @Override
    public ImmutableSortedSet<K> descendingKeySet() {
        return this.keySet().descendingSet();
    }
    
    @Override
    public ImmutableSortedMap<K, V> descendingMap() {
        ImmutableSortedMap<K, V> descendingMap;
        if ((descendingMap = this.descendingMap) == null) {
            descendingMap = this.createDescendingMap();
            this.descendingMap = descendingMap;
        }
        return descendingMap;
    }
    
    @Override
    public ImmutableSet<Entry<K, V>> entrySet() {
        return super.entrySet();
    }
    
    @Override
    public Entry<K, V> firstEntry() {
        if (this.isEmpty()) {
            return null;
        }
        return (Entry<K, V>)this.entrySet().asList().get(0);
    }
    
    @Override
    public K firstKey() {
        return this.keySet().first();
    }
    
    @Override
    public Entry<K, V> floorEntry(final K k) {
        return this.headMap(k, true).lastEntry();
    }
    
    @Override
    public K floorKey(final K k) {
        return Maps.keyOrNull((Entry<K, ?>)this.floorEntry((K)k));
    }
    
    @Override
    public ImmutableSortedMap<K, V> headMap(final K k) {
        return this.headMap(k, false);
    }
    
    @Override
    public abstract ImmutableSortedMap<K, V> headMap(final K p0, final boolean p1);
    
    @Override
    public Entry<K, V> higherEntry(final K k) {
        return this.tailMap(k, false).firstEntry();
    }
    
    @Override
    public K higherKey(final K k) {
        return Maps.keyOrNull((Entry<K, ?>)this.higherEntry((K)k));
    }
    
    @Override
    boolean isPartialView() {
        return this.keySet().isPartialView() || this.values().isPartialView();
    }
    
    @Override
    public abstract ImmutableSortedSet<K> keySet();
    
    @Override
    public Entry<K, V> lastEntry() {
        if (this.isEmpty()) {
            return null;
        }
        return (Entry<K, V>)this.entrySet().asList().get(this.size() - 1);
    }
    
    @Override
    public K lastKey() {
        return this.keySet().last();
    }
    
    @Override
    public Entry<K, V> lowerEntry(final K k) {
        return this.headMap(k, false).lastEntry();
    }
    
    @Override
    public K lowerKey(final K k) {
        return Maps.keyOrNull((Entry<K, ?>)this.lowerEntry((K)k));
    }
    
    @Override
    public ImmutableSortedSet<K> navigableKeySet() {
        return this.keySet();
    }
    
    @Deprecated
    @Override
    public final Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public final Entry<K, V> pollLastEntry() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public int size() {
        return this.values().size();
    }
    
    @Override
    public ImmutableSortedMap<K, V> subMap(final K k, final K i) {
        return this.subMap(k, true, i, false);
    }
    
    @Override
    public ImmutableSortedMap<K, V> subMap(final K k, final boolean b, final K i, final boolean b2) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(i);
        Preconditions.checkArgument(this.comparator().compare((Object)k, (Object)i) <= 0, "expected fromKey <= toKey but %s > %s", k, i);
        return this.headMap(i, b2).tailMap(k, b);
    }
    
    @Override
    public ImmutableSortedMap<K, V> tailMap(final K k) {
        return this.tailMap(k, true);
    }
    
    @Override
    public abstract ImmutableSortedMap<K, V> tailMap(final K p0, final boolean p1);
    
    @Override
    public abstract ImmutableCollection<V> values();
    
    @Override
    Object writeReplace() {
        return new SerializedForm(this);
    }
    
    public static class Builder<K, V> extends ImmutableMap.Builder<K, V>
    {
        private final Comparator<? super K> comparator;
        
        public Builder(final Comparator<? super K> comparator) {
            this.comparator = Preconditions.checkNotNull(comparator);
        }
        
        public ImmutableSortedMap<K, V> build() {
            return ImmutableSortedMap.fromEntries(this.comparator, false, this.size, (Entry<K, V>[])this.entries);
        }
        
        public Builder<K, V> put(final K k, final V v) {
            super.put(k, v);
            return this;
        }
        
        public Builder<K, V> put(final Entry<? extends K, ? extends V> entry) {
            super.put(entry);
            return this;
        }
        
        public Builder<K, V> putAll(final Map<? extends K, ? extends V> map) {
            super.putAll(map);
            return this;
        }
    }
    
    private static class SerializedForm extends ImmutableMap.SerializedForm
    {
        private static final long serialVersionUID = 0L;
        private final Comparator<Object> comparator;
        
        SerializedForm(final ImmutableSortedMap<?, ?> immutableSortedMap) {
            super(immutableSortedMap);
            this.comparator = (Comparator<Object>)immutableSortedMap.comparator();
        }
        
        @Override
        Object readResolve() {
            return ((ImmutableMap.SerializedForm)this).createMap(new ImmutableSortedMap.Builder<Object, Object>(this.comparator));
        }
    }
}
