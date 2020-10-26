// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.Set;
import java.util.Collection;
import java.util.Map;
import com.google.common.base.Predicate;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible
final class FilteredEntrySetMultimap<K, V> extends FilteredEntryMultimap<K, V> implements FilteredSetMultimap<K, V>
{
    FilteredEntrySetMultimap(final SetMultimap<K, V> setMultimap, final Predicate<? super Map.Entry<K, V>> predicate) {
        super(setMultimap, predicate);
    }
    
    @Override
    Set<Map.Entry<K, V>> createEntries() {
        return Sets.filter(this.unfiltered().entries(), this.entryPredicate());
    }
    
    @Override
    public Set<Map.Entry<K, V>> entries() {
        return (Set<Map.Entry<K, V>>)(Set)super.entries();
    }
    
    @Override
    public Set<V> get(final K k) {
        return (Set<V>)(Set)super.get(k);
    }
    
    @Override
    public Set<V> removeAll(final Object o) {
        return (Set<V>)(Set)super.removeAll(o);
    }
    
    @Override
    public Set<V> replaceValues(final K k, final Iterable<? extends V> iterable) {
        return (Set<V>)(Set)super.replaceValues(k, iterable);
    }
    
    @Override
    public SetMultimap<K, V> unfiltered() {
        return (SetMultimap<K, V>)(SetMultimap)this.unfiltered;
    }
}
