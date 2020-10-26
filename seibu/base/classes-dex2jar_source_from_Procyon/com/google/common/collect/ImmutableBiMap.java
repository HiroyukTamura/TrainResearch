// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.Set;
import java.util.Collection;
import java.util.Map;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V> implements BiMap<K, V>
{
    private static final Entry<?, ?>[] EMPTY_ENTRY_ARRAY;
    
    static {
        EMPTY_ENTRY_ARRAY = new Entry[0];
    }
    
    ImmutableBiMap() {
    }
    
    public static <K, V> Builder<K, V> builder() {
        return new Builder<K, V>();
    }
    
    public static <K, V> ImmutableBiMap<K, V> copyOf(final Map<? extends K, ? extends V> map) {
        if (map instanceof ImmutableBiMap) {
            final ImmutableBiMap<K, V> immutableBiMap = (ImmutableBiMap<K, V>)map;
            if (!immutableBiMap.isPartialView()) {
                return immutableBiMap;
            }
        }
        final Map.Entry[] array = map.entrySet().toArray(ImmutableBiMap.EMPTY_ENTRY_ARRAY);
        switch (array.length) {
            default: {
                return new RegularImmutableBiMap<K, V>(array);
            }
            case 0: {
                return of();
            }
            case 1: {
                final Map.Entry entry = array[0];
                return of(entry.getKey(), entry.getValue());
            }
        }
    }
    
    public static <K, V> ImmutableBiMap<K, V> of() {
        return (ImmutableBiMap<K, V>)EmptyImmutableBiMap.INSTANCE;
    }
    
    public static <K, V> ImmutableBiMap<K, V> of(final K k, final V v) {
        return new SingletonImmutableBiMap<K, V>(k, v);
    }
    
    public static <K, V> ImmutableBiMap<K, V> of(final K k, final V v, final K i, final V v2) {
        return new RegularImmutableBiMap<K, V>((ImmutableMapEntry.TerminalEntry<?, ?>[])new ImmutableMapEntry.TerminalEntry[] { ImmutableMap.entryOf(k, v), ImmutableMap.entryOf(i, v2) });
    }
    
    public static <K, V> ImmutableBiMap<K, V> of(final K k, final V v, final K i, final V v2, final K j, final V v3) {
        return new RegularImmutableBiMap<K, V>((ImmutableMapEntry.TerminalEntry<?, ?>[])new ImmutableMapEntry.TerminalEntry[] { ImmutableMap.entryOf(k, v), ImmutableMap.entryOf(i, v2), ImmutableMap.entryOf(j, v3) });
    }
    
    public static <K, V> ImmutableBiMap<K, V> of(final K k, final V v, final K i, final V v2, final K j, final V v3, final K l, final V v4) {
        return new RegularImmutableBiMap<K, V>((ImmutableMapEntry.TerminalEntry<?, ?>[])new ImmutableMapEntry.TerminalEntry[] { ImmutableMap.entryOf(k, v), ImmutableMap.entryOf(i, v2), ImmutableMap.entryOf(j, v3), ImmutableMap.entryOf(l, v4) });
    }
    
    public static <K, V> ImmutableBiMap<K, V> of(final K k, final V v, final K i, final V v2, final K j, final V v3, final K l, final V v4, final K m, final V v5) {
        return new RegularImmutableBiMap<K, V>((ImmutableMapEntry.TerminalEntry<?, ?>[])new ImmutableMapEntry.TerminalEntry[] { ImmutableMap.entryOf(k, v), ImmutableMap.entryOf(i, v2), ImmutableMap.entryOf(j, v3), ImmutableMap.entryOf(l, v4), ImmutableMap.entryOf(m, v5) });
    }
    
    @Deprecated
    @Override
    public V forcePut(final K k, final V v) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public abstract ImmutableBiMap<V, K> inverse();
    
    @Override
    public ImmutableSet<V> values() {
        return (ImmutableSet<V>)this.inverse().keySet();
    }
    
    @Override
    Object writeReplace() {
        return new SerializedForm(this);
    }
    
    public static final class Builder<K, V> extends ImmutableMap.Builder<K, V>
    {
        public ImmutableBiMap<K, V> build() {
            switch (this.size) {
                default: {
                    return new RegularImmutableBiMap<K, V>(this.size, this.entries);
                }
                case 0: {
                    return ImmutableBiMap.of();
                }
                case 1: {
                    return ImmutableBiMap.of((K)this.entries[0].getKey(), (V)this.entries[0].getValue());
                }
            }
        }
        
        public Builder<K, V> put(final K k, final V v) {
            super.put(k, v);
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
        
        SerializedForm(final ImmutableBiMap<?, ?> immutableBiMap) {
            super(immutableBiMap);
        }
        
        @Override
        Object readResolve() {
            return ((ImmutableMap.SerializedForm)this).createMap(new ImmutableBiMap.Builder<Object, Object>());
        }
    }
}
