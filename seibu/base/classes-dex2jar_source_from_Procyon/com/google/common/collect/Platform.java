// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.Collections;
import java.util.Set;
import java.lang.reflect.Array;
import java.util.NavigableMap;
import java.util.Map;
import com.google.common.base.Predicate;
import java.util.NavigableSet;
import java.util.SortedMap;
import com.google.common.base.Function;
import java.util.SortedSet;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
final class Platform
{
    private Platform() {
    }
    
    static <K, V> SortedMap<K, V> mapsAsMapSortedSet(final SortedSet<K> set, final Function<? super K, V> function) {
        if (set instanceof NavigableSet) {
            return (SortedMap<K, V>)Maps.asMap((NavigableSet<Object>)set, (Function<? super Object, V>)function);
        }
        return Maps.asMapSortedIgnoreNavigable(set, function);
    }
    
    static <K, V> SortedMap<K, V> mapsFilterSortedMap(final SortedMap<K, V> sortedMap, final Predicate<? super Map.Entry<K, V>> predicate) {
        if (sortedMap instanceof NavigableMap) {
            return (SortedMap<K, V>)Maps.filterEntries((NavigableMap<Object, Object>)sortedMap, (Predicate<? super Map.Entry<Object, Object>>)predicate);
        }
        return Maps.filterSortedIgnoreNavigable(sortedMap, predicate);
    }
    
    static <K, V1, V2> SortedMap<K, V2> mapsTransformEntriesSortedMap(final SortedMap<K, V1> sortedMap, final Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        if (sortedMap instanceof NavigableMap) {
            return (SortedMap<K, V2>)Maps.transformEntries((NavigableMap<Object, Object>)sortedMap, (Maps.EntryTransformer<? super Object, ? super Object, V2>)entryTransformer);
        }
        return Maps.transformEntriesIgnoreNavigable((SortedMap<K, V1>)sortedMap, (Maps.EntryTransformer<? super K, ? super V1, V2>)entryTransformer);
    }
    
    static <T> T[] newArray(final T[] array, final int length) {
        return (T[])Array.newInstance(array.getClass().getComponentType(), length);
    }
    
    static <E> Set<E> newSetFromMap(final Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }
    
    static <E> SortedSet<E> setsFilterSortedSet(final SortedSet<E> set, final Predicate<? super E> predicate) {
        if (set instanceof NavigableSet) {
            return (SortedSet<E>)Sets.filter((NavigableSet<Object>)set, (Predicate<? super Object>)predicate);
        }
        return Sets.filterSortedIgnoreNavigable(set, predicate);
    }
    
    static MapMaker tryWeakKeys(final MapMaker mapMaker) {
        return mapMaker.weakKeys();
    }
}
