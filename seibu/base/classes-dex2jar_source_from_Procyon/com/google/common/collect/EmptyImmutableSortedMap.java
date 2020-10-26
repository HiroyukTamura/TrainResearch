// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.Collection;
import java.util.NavigableMap;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import java.util.Set;
import java.util.Map;
import java.util.Comparator;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
final class EmptyImmutableSortedMap<K, V> extends ImmutableSortedMap<K, V>
{
    private final transient ImmutableSortedSet<K> keySet;
    
    EmptyImmutableSortedMap(final Comparator<? super K> comparator) {
        this.keySet = ImmutableSortedSet.emptySet(comparator);
    }
    
    EmptyImmutableSortedMap(final Comparator<? super K> comparator, final ImmutableSortedMap<K, V> immutableSortedMap) {
        super(immutableSortedMap);
        this.keySet = ImmutableSortedSet.emptySet(comparator);
    }
    
    @Override
    public ImmutableSetMultimap<K, V> asMultimap() {
        return ImmutableSetMultimap.of();
    }
    
    @Override
    ImmutableSortedMap<K, V> createDescendingMap() {
        return new EmptyImmutableSortedMap(Ordering.from(this.comparator()).reverse(), (ImmutableSortedMap<Object, Object>)this);
    }
    
    @Override
    ImmutableSet<Entry<K, V>> createEntrySet() {
        throw new AssertionError((Object)"should never be called");
    }
    
    @Override
    public ImmutableSet<Entry<K, V>> entrySet() {
        return ImmutableSet.of();
    }
    
    @Override
    public V get(@Nullable final Object o) {
        return null;
    }
    
    @Override
    public ImmutableSortedMap<K, V> headMap(final K k, final boolean b) {
        Preconditions.checkNotNull(k);
        return this;
    }
    
    @Override
    public boolean isEmpty() {
        return true;
    }
    
    @Override
    boolean isPartialView() {
        return false;
    }
    
    @Override
    public ImmutableSortedSet<K> keySet() {
        return this.keySet;
    }
    
    @Override
    public int size() {
        return 0;
    }
    
    @Override
    public ImmutableSortedMap<K, V> tailMap(final K k, final boolean b) {
        Preconditions.checkNotNull(k);
        return this;
    }
    
    @Override
    public String toString() {
        return "{}";
    }
    
    @Override
    public ImmutableCollection<V> values() {
        return (ImmutableCollection<V>)ImmutableList.of();
    }
}
