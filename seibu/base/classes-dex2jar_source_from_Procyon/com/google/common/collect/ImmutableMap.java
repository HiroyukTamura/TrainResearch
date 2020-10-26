// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;
import com.google.common.annotations.Beta;
import java.util.Comparator;
import java.util.Iterator;
import java.util.EnumMap;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Map;

@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable
{
    private static final Entry<?, ?>[] EMPTY_ENTRY_ARRAY;
    private transient ImmutableSet<Entry<K, V>> entrySet;
    private transient ImmutableSet<K> keySet;
    private transient ImmutableSetMultimap<K, V> multimapView;
    private transient ImmutableCollection<V> values;
    
    static {
        EMPTY_ENTRY_ARRAY = new Entry[0];
    }
    
    ImmutableMap() {
    }
    
    public static <K, V> Builder<K, V> builder() {
        return new Builder<K, V>();
    }
    
    static void checkNoConflict(final boolean b, String value, final Entry<?, ?> obj, final Entry<?, ?> obj2) {
        if (!b) {
            value = String.valueOf(String.valueOf(value));
            final String value2 = String.valueOf(String.valueOf(obj));
            final String value3 = String.valueOf(String.valueOf(obj2));
            throw new IllegalArgumentException(new StringBuilder(value.length() + 34 + value2.length() + value3.length()).append("Multiple entries with same ").append(value).append(": ").append(value2).append(" and ").append(value3).toString());
        }
    }
    
    public static <K, V> ImmutableMap<K, V> copyOf(final Map<? extends K, ? extends V> map) {
        if (map instanceof ImmutableMap && !(map instanceof ImmutableSortedMap)) {
            final ImmutableMap<K, V> immutableMap = (ImmutableMap<K, V>)map;
            if (!immutableMap.isPartialView()) {
                return immutableMap;
            }
        }
        else if (map instanceof EnumMap) {
            return (ImmutableMap<K, V>)copyOfEnumMapUnsafe((Map<?, ?>)map);
        }
        final Entry[] array = map.entrySet().toArray(ImmutableMap.EMPTY_ENTRY_ARRAY);
        switch (array.length) {
            default: {
                return new RegularImmutableMap<K, V>(array);
            }
            case 0: {
                return of();
            }
            case 1: {
                final Entry entry = array[0];
                return of((K)entry.getKey(), (V)entry.getValue());
            }
        }
    }
    
    private static <K extends Enum<K>, V> ImmutableMap<K, V> copyOfEnumMap(final Map<K, ? extends V> m) {
        final EnumMap<K, V> enumMap = new EnumMap<K, V>(m);
        for (final Entry<K, V> entry : enumMap.entrySet()) {
            CollectPreconditions.checkEntryNotNull(entry.getKey(), entry.getValue());
        }
        return ImmutableEnumMap.asImmutable(enumMap);
    }
    
    private static <K, V> ImmutableMap<K, V> copyOfEnumMapUnsafe(final Map<? extends K, ? extends V> map) {
        return (ImmutableMap<K, V>)copyOfEnumMap((Map<Enum, ?>)map);
    }
    
    private ImmutableSetMultimap<K, V> createMultimapView() {
        final ImmutableMap<K, ImmutableSet<V>> viewMapValuesAsSingletonSets = (ImmutableMap<K, ImmutableSet<V>>)this.viewMapValuesAsSingletonSets();
        return new ImmutableSetMultimap<K, V>((ImmutableMap<Object, ImmutableSet<Object>>)viewMapValuesAsSingletonSets, viewMapValuesAsSingletonSets.size(), null);
    }
    
    static <K, V> ImmutableMapEntry.TerminalEntry<K, V> entryOf(final K k, final V v) {
        CollectPreconditions.checkEntryNotNull(k, v);
        return (ImmutableMapEntry.TerminalEntry<K, V>)new ImmutableMapEntry.TerminalEntry(k, v);
    }
    
    public static <K, V> ImmutableMap<K, V> of() {
        return (ImmutableMap<K, V>)ImmutableBiMap.of();
    }
    
    public static <K, V> ImmutableMap<K, V> of(final K k, final V v) {
        return ImmutableBiMap.of(k, v);
    }
    
    public static <K, V> ImmutableMap<K, V> of(final K k, final V v, final K i, final V v2) {
        return new RegularImmutableMap<K, V>((ImmutableMapEntry.TerminalEntry<?, ?>[])new ImmutableMapEntry.TerminalEntry[] { entryOf(k, v), entryOf(i, v2) });
    }
    
    public static <K, V> ImmutableMap<K, V> of(final K k, final V v, final K i, final V v2, final K j, final V v3) {
        return new RegularImmutableMap<K, V>((ImmutableMapEntry.TerminalEntry<?, ?>[])new ImmutableMapEntry.TerminalEntry[] { entryOf(k, v), entryOf(i, v2), entryOf(j, v3) });
    }
    
    public static <K, V> ImmutableMap<K, V> of(final K k, final V v, final K i, final V v2, final K j, final V v3, final K l, final V v4) {
        return new RegularImmutableMap<K, V>((ImmutableMapEntry.TerminalEntry<?, ?>[])new ImmutableMapEntry.TerminalEntry[] { entryOf(k, v), entryOf(i, v2), entryOf(j, v3), entryOf(l, v4) });
    }
    
    public static <K, V> ImmutableMap<K, V> of(final K k, final V v, final K i, final V v2, final K j, final V v3, final K l, final V v4, final K m, final V v5) {
        return new RegularImmutableMap<K, V>((ImmutableMapEntry.TerminalEntry<?, ?>[])new ImmutableMapEntry.TerminalEntry[] { entryOf(k, v), entryOf(i, v2), entryOf(j, v3), entryOf(l, v4), entryOf(m, v5) });
    }
    
    private ImmutableMap<K, ImmutableSet<V>> viewMapValuesAsSingletonSets() {
        return (ImmutableMap<K, ImmutableSet<V>>)new MapViewOfValuesAsSingletonSets((ImmutableMap<Object, Object>)this);
    }
    
    @Beta
    public ImmutableSetMultimap<K, V> asMultimap() {
        ImmutableSetMultimap<K, V> multimapView;
        if ((multimapView = this.multimapView) == null) {
            multimapView = this.createMultimapView();
            this.multimapView = multimapView;
        }
        return multimapView;
    }
    
    @Deprecated
    @Override
    public final void clear() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean containsKey(@Nullable final Object o) {
        return this.get(o) != null;
    }
    
    @Override
    public boolean containsValue(@Nullable final Object o) {
        return this.values().contains(o);
    }
    
    abstract ImmutableSet<Entry<K, V>> createEntrySet();
    
    ImmutableSet<K> createKeySet() {
        return (ImmutableSet<K>)new ImmutableMapKeySet((ImmutableMap<Object, Object>)this);
    }
    
    @Override
    public ImmutableSet<Entry<K, V>> entrySet() {
        ImmutableSet<Entry<K, V>> entrySet;
        if ((entrySet = this.entrySet) == null) {
            entrySet = this.createEntrySet();
            this.entrySet = entrySet;
        }
        return entrySet;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return Maps.equalsImpl(this, o);
    }
    
    @Override
    public abstract V get(@Nullable final Object p0);
    
    @Override
    public int hashCode() {
        return this.entrySet().hashCode();
    }
    
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }
    
    abstract boolean isPartialView();
    
    @Override
    public ImmutableSet<K> keySet() {
        ImmutableSet<K> keySet;
        if ((keySet = this.keySet) == null) {
            keySet = this.createKeySet();
            this.keySet = keySet;
        }
        return keySet;
    }
    
    @Deprecated
    @Override
    public final V put(final K k, final V v) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public final void putAll(final Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public final V remove(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public String toString() {
        return Maps.toStringImpl(this);
    }
    
    @Override
    public ImmutableCollection<V> values() {
        ImmutableCollection<V> values;
        if ((values = this.values) == null) {
            values = (ImmutableCollection<V>)new ImmutableMapValues((ImmutableMap<Object, Object>)this);
            this.values = values;
        }
        return values;
    }
    
    Object writeReplace() {
        return new SerializedForm(this);
    }
    
    public static class Builder<K, V>
    {
        ImmutableMapEntry.TerminalEntry<K, V>[] entries;
        int size;
        
        public Builder() {
            this(4);
        }
        
        Builder(final int n) {
            this.entries = (ImmutableMapEntry.TerminalEntry<K, V>[])new ImmutableMapEntry.TerminalEntry[n];
            this.size = 0;
        }
        
        private void ensureCapacity(final int n) {
            if (n > this.entries.length) {
                this.entries = ObjectArrays.arraysCopyOf(this.entries, ImmutableCollection.Builder.expandedCapacity(this.entries.length, n));
            }
        }
        
        public ImmutableMap<K, V> build() {
            switch (this.size) {
                default: {
                    return new RegularImmutableMap<K, V>(this.size, this.entries);
                }
                case 0: {
                    return ImmutableMap.of();
                }
                case 1: {
                    return ImmutableMap.of(this.entries[0].getKey(), this.entries[0].getValue());
                }
            }
        }
        
        public Builder<K, V> put(final K k, final V v) {
            this.ensureCapacity(this.size + 1);
            this.entries[this.size++] = ImmutableMap.entryOf(k, v);
            return this;
        }
        
        public Builder<K, V> put(final Entry<? extends K, ? extends V> entry) {
            return (Builder<K, V>)this.put(entry.getKey(), entry.getValue());
        }
        
        public Builder<K, V> putAll(final Map<? extends K, ? extends V> map) {
            this.ensureCapacity(this.size + map.size());
            final Iterator<Entry<? extends K, ? extends V>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                this.put((Entry<? extends K, ? extends V>)iterator.next());
            }
            return this;
        }
    }
    
    private static final class MapViewOfValuesAsSingletonSets<K, V> extends ImmutableMap<K, ImmutableSet<V>>
    {
        private final ImmutableMap<K, V> delegate;
        
        MapViewOfValuesAsSingletonSets(final ImmutableMap<K, V> immutableMap) {
            this.delegate = Preconditions.checkNotNull(immutableMap);
        }
        
        @Override
        public boolean containsKey(@Nullable final Object o) {
            return this.delegate.containsKey(o);
        }
        
        @Override
        ImmutableSet<Entry<K, ImmutableSet<V>>> createEntrySet() {
            return (ImmutableSet<Entry<K, ImmutableSet<V>>>)new ImmutableMapEntrySet<K, ImmutableSet<V>>() {
                @Override
                public UnmodifiableIterator<Entry<K, ImmutableSet<V>>> iterator() {
                    return new UnmodifiableIterator<Entry<K, ImmutableSet<V>>>() {
                        final /* synthetic */ Iterator val$backingIterator = MapViewOfValuesAsSingletonSets.this.delegate.entrySet().iterator();
                        
                        @Override
                        public boolean hasNext() {
                            return this.val$backingIterator.hasNext();
                        }
                        
                        @Override
                        public Entry<K, ImmutableSet<V>> next() {
                            return new AbstractMapEntry<K, ImmutableSet<V>>() {
                                final /* synthetic */ Entry val$backingEntry = ImmutableMap$MapViewOfValuesAsSingletonSets$1$1.this.val$backingIterator.next();
                                
                                @Override
                                public K getKey() {
                                    return this.val$backingEntry.getKey();
                                }
                                
                                @Override
                                public ImmutableSet<V> getValue() {
                                    return ImmutableSet.of(this.val$backingEntry.getValue());
                                }
                            };
                        }
                    };
                }
                
                @Override
                ImmutableMap<K, ImmutableSet<V>> map() {
                    return (ImmutableMap<K, ImmutableSet<V>>)MapViewOfValuesAsSingletonSets.this;
                }
            };
        }
        
        @Override
        public ImmutableSet<V> get(@Nullable Object value) {
            value = this.delegate.get(value);
            if (value == null) {
                return null;
            }
            return ImmutableSet.of(value);
        }
        
        @Override
        boolean isPartialView() {
            return false;
        }
        
        @Override
        public int size() {
            return this.delegate.size();
        }
    }
    
    static class SerializedForm implements Serializable
    {
        private static final long serialVersionUID = 0L;
        private final Object[] keys;
        private final Object[] values;
        
        SerializedForm(final ImmutableMap<?, ?> immutableMap) {
            this.keys = new Object[immutableMap.size()];
            this.values = new Object[immutableMap.size()];
            int n = 0;
            for (final Entry<Object, V> entry : immutableMap.entrySet()) {
                this.keys[n] = entry.getKey();
                this.values[n] = entry.getValue();
                ++n;
            }
        }
        
        Object createMap(final Builder<Object, Object> builder) {
            for (int i = 0; i < this.keys.length; ++i) {
                builder.put(this.keys[i], this.values[i]);
            }
            return builder.build();
        }
        
        Object readResolve() {
            return this.createMap((Builder<Object, Object>)new Builder());
        }
    }
}
