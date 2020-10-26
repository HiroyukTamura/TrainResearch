// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.io.Serializable;
import java.util.Map;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true, serializable = true)
class RegularImmutableBiMap<K, V> extends ImmutableBiMap<K, V>
{
    static final double MAX_LOAD_FACTOR = 1.2;
    private final transient ImmutableMapEntry<K, V>[] entries;
    private final transient int hashCode;
    private transient ImmutableBiMap<V, K> inverse;
    private final transient ImmutableMapEntry<K, V>[] keyTable;
    private final transient int mask;
    private final transient ImmutableMapEntry<K, V>[] valueTable;
    
    RegularImmutableBiMap(final int n, final ImmutableMapEntry.TerminalEntry<?, ?>[] array) {
        final int closedTableSize = Hashing.closedTableSize(n, 1.2);
        this.mask = closedTableSize - 1;
        final ImmutableMapEntry<Object, Object>[] entryArray = createEntryArray(closedTableSize);
        final ImmutableMapEntry<Object, Object>[] entryArray2 = createEntryArray(closedTableSize);
        final ImmutableMapEntry<K, V>[] entryArray3 = createEntryArray(n);
        int hashCode = 0;
        for (int i = 0; i < n; ++i) {
            final ImmutableMapEntry.TerminalEntry<?, ?> terminalEntry = array[i];
            final Object key = terminalEntry.getKey();
            final Object value = terminalEntry.getValue();
            final int hashCode2 = key.hashCode();
            final int hashCode3 = value.hashCode();
            final int n2 = Hashing.smear(hashCode2) & this.mask;
            final int n3 = Hashing.smear(hashCode3) & this.mask;
            ImmutableEntry<K, V> nextInKeyBucket;
            ImmutableMapEntry<K, V> immutableMapEntry;
            for (immutableMapEntry = (ImmutableMapEntry<K, V>)(nextInKeyBucket = (ImmutableEntry<K, V>)entryArray[n2]); nextInKeyBucket != null; nextInKeyBucket = (ImmutableEntry<K, V>)((ImmutableMapEntry<Object, Object>)nextInKeyBucket).getNextInKeyBucket()) {
                ImmutableMap.checkNoConflict(!key.equals(nextInKeyBucket.getKey()), "key", terminalEntry, nextInKeyBucket);
            }
            ImmutableEntry<K, V> nextInValueBucket;
            ImmutableMapEntry<K, V> immutableMapEntry2;
            for (immutableMapEntry2 = (ImmutableMapEntry<K, V>)(nextInValueBucket = (ImmutableEntry<K, V>)entryArray2[n3]); nextInValueBucket != null; nextInValueBucket = (ImmutableEntry<K, V>)((ImmutableMapEntry<Object, Object>)nextInValueBucket).getNextInValueBucket()) {
                ImmutableMap.checkNoConflict(!value.equals(nextInValueBucket.getValue()), "value", terminalEntry, nextInValueBucket);
            }
            Serializable s;
            if (immutableMapEntry == null && immutableMapEntry2 == null) {
                s = terminalEntry;
            }
            else {
                s = new NonTerminalBiMapEntry<Object, Object>(terminalEntry, immutableMapEntry, immutableMapEntry2);
            }
            entryArray[n2] = (ImmutableMapEntry<Object, Object>)s;
            entryArray3[i] = (ImmutableMapEntry<K, V>)(entryArray2[n3] = (ImmutableMapEntry<Object, Object>)s);
            hashCode += (hashCode2 ^ hashCode3);
        }
        this.keyTable = (ImmutableMapEntry<K, V>[])entryArray;
        this.valueTable = (ImmutableMapEntry<K, V>[])entryArray2;
        this.entries = entryArray3;
        this.hashCode = hashCode;
    }
    
    RegularImmutableBiMap(final ImmutableMapEntry.TerminalEntry<?, ?>... array) {
        this(array.length, array);
    }
    
    RegularImmutableBiMap(final Entry<?, ?>[] array) {
        final int length = array.length;
        final int closedTableSize = Hashing.closedTableSize(length, 1.2);
        this.mask = closedTableSize - 1;
        final ImmutableMapEntry<Object, Object>[] entryArray = createEntryArray(closedTableSize);
        final ImmutableMapEntry<Object, Object>[] entryArray2 = createEntryArray(closedTableSize);
        final ImmutableMapEntry<Object, Object>[] entryArray3 = createEntryArray(length);
        int hashCode = 0;
        for (int i = 0; i < length; ++i) {
            final Entry<?, ?> entry = array[i];
            final Object key = entry.getKey();
            final Object value = entry.getValue();
            CollectPreconditions.checkEntryNotNull(key, value);
            final int hashCode2 = key.hashCode();
            final int hashCode3 = value.hashCode();
            final int n = Hashing.smear(hashCode2) & this.mask;
            final int n2 = Hashing.smear(hashCode3) & this.mask;
            ImmutableEntry<K, V> nextInKeyBucket;
            ImmutableMapEntry<K, V> immutableMapEntry;
            for (immutableMapEntry = (ImmutableMapEntry<K, V>)(nextInKeyBucket = (ImmutableEntry<K, V>)entryArray[n]); nextInKeyBucket != null; nextInKeyBucket = (ImmutableEntry<K, V>)((ImmutableMapEntry<Object, Object>)nextInKeyBucket).getNextInKeyBucket()) {
                ImmutableMap.checkNoConflict(!key.equals(nextInKeyBucket.getKey()), "key", entry, nextInKeyBucket);
            }
            ImmutableEntry<K, V> nextInValueBucket;
            ImmutableMapEntry<K, V> immutableMapEntry2;
            for (immutableMapEntry2 = (ImmutableMapEntry<K, V>)(nextInValueBucket = (ImmutableEntry<K, V>)entryArray2[n2]); nextInValueBucket != null; nextInValueBucket = (ImmutableEntry<K, V>)((ImmutableMapEntry<Object, Object>)nextInValueBucket).getNextInValueBucket()) {
                ImmutableMap.checkNoConflict(!value.equals(nextInValueBucket.getValue()), "value", entry, nextInValueBucket);
            }
            Serializable s;
            if (immutableMapEntry == null && immutableMapEntry2 == null) {
                s = new ImmutableMapEntry.TerminalEntry<Object, Object>(key, value);
            }
            else {
                s = new NonTerminalBiMapEntry<Object, Object>(key, value, immutableMapEntry, immutableMapEntry2);
            }
            entryArray[n] = (ImmutableMapEntry<Object, Object>)s;
            entryArray3[i] = (entryArray2[n2] = (ImmutableMapEntry<Object, Object>)s);
            hashCode += (hashCode2 ^ hashCode3);
        }
        this.keyTable = (ImmutableMapEntry<K, V>[])entryArray;
        this.valueTable = (ImmutableMapEntry<K, V>[])entryArray2;
        this.entries = (ImmutableMapEntry<K, V>[])entryArray3;
        this.hashCode = hashCode;
    }
    
    private static <K, V> ImmutableMapEntry<K, V>[] createEntryArray(final int n) {
        return (ImmutableMapEntry<K, V>[])new ImmutableMapEntry[n];
    }
    
    @Override
    ImmutableSet<Entry<K, V>> createEntrySet() {
        return (ImmutableSet<Entry<K, V>>)new ImmutableMapEntrySet<K, V>() {
            @Override
            ImmutableList<Entry<K, V>> createAsList() {
                return new RegularImmutableAsList<Entry<K, V>>((ImmutableCollection<Entry<K, V>>)this, RegularImmutableBiMap.this.entries);
            }
            
            @Override
            public int hashCode() {
                return RegularImmutableBiMap.this.hashCode;
            }
            
            @Override
            boolean isHashCodeFast() {
                return true;
            }
            
            @Override
            public UnmodifiableIterator<Entry<K, V>> iterator() {
                return (UnmodifiableIterator<Entry<K, V>>)this.asList().iterator();
            }
            
            @Override
            ImmutableMap<K, V> map() {
                return (ImmutableMap<K, V>)RegularImmutableBiMap.this;
            }
        };
    }
    
    @Nullable
    @Override
    public V get(@Nullable final Object o) {
        if (o != null) {
            for (ImmutableEntry<K, V> nextInKeyBucket = (ImmutableEntry<K, V>)this.keyTable[Hashing.smear(o.hashCode()) & this.mask]; nextInKeyBucket != null; nextInKeyBucket = (ImmutableEntry<K, V>)((ImmutableMapEntry<Object, Object>)nextInKeyBucket).getNextInKeyBucket()) {
                if (o.equals(nextInKeyBucket.getKey())) {
                    return (V)nextInKeyBucket.getValue();
                }
            }
        }
        return null;
    }
    
    @Override
    public ImmutableBiMap<V, K> inverse() {
        ImmutableBiMap<V, K> inverse;
        if ((inverse = this.inverse) == null) {
            inverse = new Inverse();
            this.inverse = inverse;
        }
        return inverse;
    }
    
    @Override
    boolean isPartialView() {
        return false;
    }
    
    @Override
    public int size() {
        return this.entries.length;
    }
    
    private final class Inverse extends ImmutableBiMap<V, K>
    {
        @Override
        ImmutableSet<Entry<V, K>> createEntrySet() {
            return (ImmutableSet<Entry<V, K>>)new InverseEntrySet();
        }
        
        @Override
        public K get(@Nullable final Object o) {
            if (o != null) {
                for (ImmutableMapEntry<K, Object> nextInValueBucket = (ImmutableMapEntry<K, Object>)RegularImmutableBiMap.this.valueTable[Hashing.smear(o.hashCode()) & RegularImmutableBiMap.this.mask]; nextInValueBucket != null; nextInValueBucket = nextInValueBucket.getNextInValueBucket()) {
                    if (o.equals(nextInValueBucket.getValue())) {
                        return nextInValueBucket.getKey();
                    }
                }
            }
            return null;
        }
        
        @Override
        public ImmutableBiMap<K, V> inverse() {
            return (ImmutableBiMap<K, V>)RegularImmutableBiMap.this;
        }
        
        @Override
        boolean isPartialView() {
            return false;
        }
        
        @Override
        public int size() {
            return this.inverse().size();
        }
        
        @Override
        Object writeReplace() {
            return new InverseSerializedForm(RegularImmutableBiMap.this);
        }
        
        final class InverseEntrySet extends ImmutableMapEntrySet<V, K>
        {
            @Override
            ImmutableList<Entry<V, K>> createAsList() {
                return new ImmutableAsList<Entry<V, K>>() {
                    @Override
                    ImmutableCollection<Entry<V, K>> delegateCollection() {
                        return (ImmutableCollection<Entry<V, K>>)InverseEntrySet.this;
                    }
                    
                    @Override
                    public Entry<V, K> get(final int n) {
                        final ImmutableMapEntry immutableMapEntry = RegularImmutableBiMap.this.entries[n];
                        return Maps.immutableEntry((V)immutableMapEntry.getValue(), (K)immutableMapEntry.getKey());
                    }
                };
            }
            
            @Override
            public int hashCode() {
                return RegularImmutableBiMap.this.hashCode;
            }
            
            @Override
            boolean isHashCodeFast() {
                return true;
            }
            
            @Override
            public UnmodifiableIterator<Entry<V, K>> iterator() {
                return (UnmodifiableIterator<Entry<V, K>>)this.asList().iterator();
            }
            
            @Override
            ImmutableMap<V, K> map() {
                return Inverse.this;
            }
        }
    }
    
    private static class InverseSerializedForm<K, V> implements Serializable
    {
        private static final long serialVersionUID = 1L;
        private final ImmutableBiMap<K, V> forward;
        
        InverseSerializedForm(final ImmutableBiMap<K, V> forward) {
            this.forward = forward;
        }
        
        Object readResolve() {
            return this.forward.inverse();
        }
    }
    
    private static final class NonTerminalBiMapEntry<K, V> extends ImmutableMapEntry<K, V>
    {
        @Nullable
        private final ImmutableMapEntry<K, V> nextInKeyBucket;
        @Nullable
        private final ImmutableMapEntry<K, V> nextInValueBucket;
        
        NonTerminalBiMapEntry(final ImmutableMapEntry<K, V> immutableMapEntry, @Nullable final ImmutableMapEntry<K, V> nextInKeyBucket, @Nullable final ImmutableMapEntry<K, V> nextInValueBucket) {
            super(immutableMapEntry);
            this.nextInKeyBucket = nextInKeyBucket;
            this.nextInValueBucket = nextInValueBucket;
        }
        
        NonTerminalBiMapEntry(final K k, final V v, @Nullable final ImmutableMapEntry<K, V> nextInKeyBucket, @Nullable final ImmutableMapEntry<K, V> nextInValueBucket) {
            super(k, v);
            this.nextInKeyBucket = nextInKeyBucket;
            this.nextInValueBucket = nextInValueBucket;
        }
        
        @Nullable
        @Override
        ImmutableMapEntry<K, V> getNextInKeyBucket() {
            return this.nextInKeyBucket;
        }
        
        @Nullable
        @Override
        ImmutableMapEntry<K, V> getNextInValueBucket() {
            return this.nextInValueBucket;
        }
    }
}
