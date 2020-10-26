// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.Iterator;
import javax.annotation.Nullable;
import java.util.Map;
import java.io.Serializable;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true, serializable = true)
final class RegularImmutableMap<K, V> extends ImmutableMap<K, V>
{
    private static final double MAX_LOAD_FACTOR = 1.2;
    private static final long serialVersionUID = 0L;
    private final transient ImmutableMapEntry<K, V>[] entries;
    private final transient int mask;
    private final transient ImmutableMapEntry<K, V>[] table;
    
    RegularImmutableMap(final int n, final ImmutableMapEntry.TerminalEntry<?, ?>[] array) {
        this.entries = this.createEntryArray(n);
        final int closedTableSize = Hashing.closedTableSize(n, 1.2);
        this.table = this.createEntryArray(closedTableSize);
        this.mask = closedTableSize - 1;
        for (int i = 0; i < n; ++i) {
            Serializable s = array[i];
            final Object key = ((ImmutableEntry<Object, V>)s).getKey();
            final int n2 = Hashing.smear(key.hashCode()) & this.mask;
            final ImmutableMapEntry<K, V> immutableMapEntry = this.table[n2];
            if (immutableMapEntry != null) {
                s = new NonTerminalMapEntry<K, V>((ImmutableMapEntry<Object, Object>)s, (ImmutableMapEntry<Object, Object>)immutableMapEntry);
            }
            this.table[n2] = (ImmutableMapEntry<K, V>)s;
            this.checkNoConflictInBucket((K)key, this.entries[i] = (ImmutableMapEntry<K, V>)s, immutableMapEntry);
        }
    }
    
    RegularImmutableMap(final ImmutableMapEntry.TerminalEntry<?, ?>... array) {
        this(array.length, array);
    }
    
    RegularImmutableMap(final Entry<?, ?>[] array) {
        final int length = array.length;
        this.entries = this.createEntryArray(length);
        final int closedTableSize = Hashing.closedTableSize(length, 1.2);
        this.table = this.createEntryArray(closedTableSize);
        this.mask = closedTableSize - 1;
        for (int i = 0; i < length; ++i) {
            final Entry<?, ?> entry = array[i];
            final Object key = entry.getKey();
            final Object value = entry.getValue();
            CollectPreconditions.checkEntryNotNull(key, value);
            final int n = Hashing.smear(key.hashCode()) & this.mask;
            final ImmutableMapEntry<K, V> immutableMapEntry = this.table[n];
            Serializable s;
            if (immutableMapEntry == null) {
                s = new ImmutableMapEntry.TerminalEntry<Object, Object>(key, value);
            }
            else {
                s = new NonTerminalMapEntry<Object, Object>(key, value, immutableMapEntry);
            }
            this.table[n] = (ImmutableMapEntry<K, V>)s;
            this.checkNoConflictInBucket((K)key, this.entries[i] = (ImmutableMapEntry<K, V>)s, immutableMapEntry);
        }
    }
    
    private void checkNoConflictInBucket(final K k, final ImmutableMapEntry<K, V> immutableMapEntry, ImmutableMapEntry<K, V> nextInKeyBucket) {
        while (nextInKeyBucket != null) {
            ImmutableMap.checkNoConflict(!k.equals(nextInKeyBucket.getKey()), "key", immutableMapEntry, nextInKeyBucket);
            nextInKeyBucket = nextInKeyBucket.getNextInKeyBucket();
        }
    }
    
    private ImmutableMapEntry<K, V>[] createEntryArray(final int n) {
        return (ImmutableMapEntry<K, V>[])new ImmutableMapEntry[n];
    }
    
    @Override
    ImmutableSet<Entry<K, V>> createEntrySet() {
        return (ImmutableSet<Entry<K, V>>)new EntrySet();
    }
    
    @Override
    public V get(@Nullable final Object o) {
        if (o != null) {
            for (ImmutableEntry<K, V> nextInKeyBucket = (ImmutableEntry<K, V>)this.table[Hashing.smear(o.hashCode()) & this.mask]; nextInKeyBucket != null; nextInKeyBucket = (ImmutableEntry<K, V>)((ImmutableMapEntry<Object, Object>)nextInKeyBucket).getNextInKeyBucket()) {
                if (o.equals(nextInKeyBucket.getKey())) {
                    return (V)nextInKeyBucket.getValue();
                }
            }
        }
        return null;
    }
    
    @Override
    boolean isPartialView() {
        return false;
    }
    
    @Override
    public int size() {
        return this.entries.length;
    }
    
    private class EntrySet extends ImmutableMapEntrySet<K, V>
    {
        @Override
        ImmutableList<Entry<K, V>> createAsList() {
            return new RegularImmutableAsList<Entry<K, V>>((ImmutableCollection<Entry<K, V>>)this, RegularImmutableMap.this.entries);
        }
        
        @Override
        public UnmodifiableIterator<Entry<K, V>> iterator() {
            return (UnmodifiableIterator<Entry<K, V>>)this.asList().iterator();
        }
        
        @Override
        ImmutableMap<K, V> map() {
            return (ImmutableMap<K, V>)RegularImmutableMap.this;
        }
    }
    
    private static final class NonTerminalMapEntry<K, V> extends ImmutableMapEntry<K, V>
    {
        private final ImmutableMapEntry<K, V> nextInKeyBucket;
        
        NonTerminalMapEntry(final ImmutableMapEntry<K, V> immutableMapEntry, final ImmutableMapEntry<K, V> nextInKeyBucket) {
            super(immutableMapEntry);
            this.nextInKeyBucket = nextInKeyBucket;
        }
        
        NonTerminalMapEntry(final K k, final V v, final ImmutableMapEntry<K, V> nextInKeyBucket) {
            super(k, v);
            this.nextInKeyBucket = nextInKeyBucket;
        }
        
        @Override
        ImmutableMapEntry<K, V> getNextInKeyBucket() {
            return this.nextInKeyBucket;
        }
        
        @Nullable
        @Override
        ImmutableMapEntry<K, V> getNextInValueBucket() {
            return null;
        }
    }
}
