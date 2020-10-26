// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.Iterator;
import java.util.Collection;
import java.util.Set;
import java.util.NavigableMap;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import java.util.Map;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
final class RegularImmutableSortedMap<K, V> extends ImmutableSortedMap<K, V>
{
    private final transient RegularImmutableSortedSet<K> keySet;
    private final transient ImmutableList<V> valueList;
    
    RegularImmutableSortedMap(final RegularImmutableSortedSet<K> keySet, final ImmutableList<V> valueList) {
        this.keySet = keySet;
        this.valueList = valueList;
    }
    
    RegularImmutableSortedMap(final RegularImmutableSortedSet<K> keySet, final ImmutableList<V> valueList, final ImmutableSortedMap<K, V> immutableSortedMap) {
        super(immutableSortedMap);
        this.keySet = keySet;
        this.valueList = valueList;
    }
    
    private ImmutableSortedMap<K, V> getSubMap(final int n, final int n2) {
        if (n == 0 && n2 == this.size()) {
            return this;
        }
        if (n == n2) {
            return ImmutableSortedMap.emptyMap(this.comparator());
        }
        return ImmutableSortedMap.from(this.keySet.getSubSet(n, n2), this.valueList.subList(n, n2));
    }
    
    @Override
    ImmutableSortedMap<K, V> createDescendingMap() {
        return new RegularImmutableSortedMap((RegularImmutableSortedSet)this.keySet.descendingSet(), (ImmutableList<Object>)this.valueList.reverse(), (ImmutableSortedMap<Object, Object>)this);
    }
    
    @Override
    ImmutableSet<Entry<K, V>> createEntrySet() {
        return (ImmutableSet<Entry<K, V>>)new EntrySet();
    }
    
    @Override
    public V get(@Nullable final Object o) {
        final int index = this.keySet.indexOf(o);
        if (index == -1) {
            return null;
        }
        return (V)this.valueList.get(index);
    }
    
    @Override
    public ImmutableSortedMap<K, V> headMap(final K k, final boolean b) {
        return this.getSubMap(0, this.keySet.headIndex(Preconditions.checkNotNull(k), b));
    }
    
    @Override
    public ImmutableSortedSet<K> keySet() {
        return this.keySet;
    }
    
    @Override
    public ImmutableSortedMap<K, V> tailMap(final K k, final boolean b) {
        return this.getSubMap(this.keySet.tailIndex(Preconditions.checkNotNull(k), b), this.size());
    }
    
    @Override
    public ImmutableCollection<V> values() {
        return this.valueList;
    }
    
    private class EntrySet extends ImmutableMapEntrySet<K, V>
    {
        @Override
        ImmutableList<Entry<K, V>> createAsList() {
            return new ImmutableAsList<Entry<K, V>>() {
                private final ImmutableList<K> keyList = RegularImmutableSortedMap.this.keySet().asList();
                
                @Override
                ImmutableCollection<Entry<K, V>> delegateCollection() {
                    return (ImmutableCollection<Entry<K, V>>)EntrySet.this;
                }
                
                @Override
                public Entry<K, V> get(final int n) {
                    return Maps.immutableEntry(this.keyList.get(n), RegularImmutableSortedMap.this.valueList.get(n));
                }
            };
        }
        
        @Override
        public UnmodifiableIterator<Entry<K, V>> iterator() {
            return (UnmodifiableIterator<Entry<K, V>>)this.asList().iterator();
        }
        
        @Override
        ImmutableMap<K, V> map() {
            return (ImmutableMap<K, V>)RegularImmutableSortedMap.this;
        }
    }
}
