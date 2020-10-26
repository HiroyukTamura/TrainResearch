// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Collection;
import com.google.common.base.Predicate;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible
final class FilteredKeyListMultimap<K, V> extends FilteredKeyMultimap<K, V> implements ListMultimap<K, V>
{
    FilteredKeyListMultimap(final ListMultimap<K, V> listMultimap, final Predicate<? super K> predicate) {
        super(listMultimap, predicate);
    }
    
    @Override
    public List<V> get(final K k) {
        return (List<V>)(List)super.get(k);
    }
    
    @Override
    public List<V> removeAll(@Nullable final Object o) {
        return (List<V>)(List)super.removeAll(o);
    }
    
    @Override
    public List<V> replaceValues(final K k, final Iterable<? extends V> iterable) {
        return (List<V>)(List)super.replaceValues(k, iterable);
    }
    
    @Override
    public ListMultimap<K, V> unfiltered() {
        return (ListMultimap<K, V>)(ListMultimap)super.unfiltered();
    }
}
