// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.ArrayList;
import java.util.List;
import com.google.common.base.Predicates;
import java.util.Collections;
import com.google.common.base.MoreObjects;
import java.util.Iterator;
import javax.annotation.Nullable;
import java.util.Set;
import java.util.Collection;
import com.google.common.base.Preconditions;
import java.util.Map;
import com.google.common.base.Predicate;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible
class FilteredEntryMultimap<K, V> extends AbstractMultimap<K, V> implements FilteredMultimap<K, V>
{
    final Predicate<? super Map.Entry<K, V>> predicate;
    final Multimap<K, V> unfiltered;
    
    FilteredEntryMultimap(final Multimap<K, V> multimap, final Predicate<? super Map.Entry<K, V>> predicate) {
        this.unfiltered = Preconditions.checkNotNull(multimap);
        this.predicate = Preconditions.checkNotNull(predicate);
    }
    
    static <E> Collection<E> filterCollection(final Collection<E> collection, final Predicate<? super E> predicate) {
        if (collection instanceof Set) {
            return (Collection<E>)Sets.filter((Set<Object>)collection, (Predicate<? super Object>)predicate);
        }
        return Collections2.filter(collection, predicate);
    }
    
    private boolean satisfies(final K k, final V v) {
        return this.predicate.apply(Maps.immutableEntry(k, v));
    }
    
    @Override
    public void clear() {
        this.entries().clear();
    }
    
    @Override
    public boolean containsKey(@Nullable final Object o) {
        return this.asMap().get(o) != null;
    }
    
    @Override
    Map<K, Collection<V>> createAsMap() {
        return new AsMap();
    }
    
    @Override
    Collection<Map.Entry<K, V>> createEntries() {
        return filterCollection(this.unfiltered.entries(), this.predicate);
    }
    
    @Override
    Multiset<K> createKeys() {
        return (Multiset<K>)new Keys();
    }
    
    @Override
    Collection<V> createValues() {
        return (Collection<V>)new FilteredMultimapValues((FilteredMultimap<Object, Object>)this);
    }
    
    @Override
    Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError((Object)"should never be called");
    }
    
    @Override
    public Predicate<? super Map.Entry<K, V>> entryPredicate() {
        return this.predicate;
    }
    
    @Override
    public Collection<V> get(final K k) {
        return filterCollection(this.unfiltered.get(k), new ValuePredicate(k));
    }
    
    @Override
    public Set<K> keySet() {
        return this.asMap().keySet();
    }
    
    @Override
    public Collection<V> removeAll(@Nullable final Object o) {
        return MoreObjects.firstNonNull(this.asMap().remove(o), this.unmodifiableEmptyCollection());
    }
    
    boolean removeEntriesIf(final Predicate<? super Map.Entry<K, Collection<V>>> predicate) {
        final Iterator<Map.Entry<K, Collection<V>>> iterator = this.unfiltered.asMap().entrySet().iterator();
        boolean b = false;
        while (iterator.hasNext()) {
            final Map.Entry<K, Collection<V>> entry = iterator.next();
            final K key = entry.getKey();
            final Collection<V> filterCollection = filterCollection(entry.getValue(), new ValuePredicate(key));
            if (!filterCollection.isEmpty() && predicate.apply(Maps.immutableEntry(key, filterCollection))) {
                if (filterCollection.size() == entry.getValue().size()) {
                    iterator.remove();
                }
                else {
                    filterCollection.clear();
                }
                b = true;
            }
        }
        return b;
    }
    
    @Override
    public int size() {
        return this.entries().size();
    }
    
    @Override
    public Multimap<K, V> unfiltered() {
        return this.unfiltered;
    }
    
    Collection<V> unmodifiableEmptyCollection() {
        if (this.unfiltered instanceof SetMultimap) {
            return (Collection<V>)Collections.emptySet();
        }
        return (Collection<V>)Collections.emptyList();
    }
    
    class AsMap extends ImprovedAbstractMap<K, Collection<V>>
    {
        @Override
        public void clear() {
            FilteredEntryMultimap.this.clear();
        }
        
        @Override
        public boolean containsKey(@Nullable final Object o) {
            return this.get(o) != null;
        }
        
        @Override
        Set<Entry<K, Collection<V>>> createEntrySet() {
            return (Set<Entry<K, Collection<V>>>)new Maps.EntrySet<K, Collection<V>>() {
                @Override
                public Iterator<Entry<K, Collection<V>>> iterator() {
                    return new AbstractIterator<Entry<K, Collection<V>>>() {
                        final Iterator<Entry<K, Collection<V>>> backingIterator = FilteredEntryMultimap.this.unfiltered.asMap().entrySet().iterator();
                        
                        @Override
                        protected Entry<K, Collection<V>> computeNext() {
                            while (this.backingIterator.hasNext()) {
                                final Entry entry = this.backingIterator.next();
                                final K key = (K)entry.getKey();
                                final Collection<V> filterCollection = FilteredEntryMultimap.filterCollection((Collection<V>)entry.getValue(), new ValuePredicate(key));
                                if (!filterCollection.isEmpty()) {
                                    return Maps.immutableEntry(key, filterCollection);
                                }
                            }
                            return (Entry<K, Collection<V>>)((AbstractIterator<Map.Entry>)this).endOfData();
                        }
                    };
                }
                
                @Override
                Map<K, Collection<V>> map() {
                    return AsMap.this;
                }
                
                @Override
                public boolean removeAll(final Collection<?> collection) {
                    return FilteredEntryMultimap.this.removeEntriesIf(Predicates.in((Collection<? extends Entry<K, Collection<V>>>)collection));
                }
                
                @Override
                public boolean retainAll(final Collection<?> collection) {
                    return FilteredEntryMultimap.this.removeEntriesIf(Predicates.not(Predicates.in((Collection<? extends Entry<K, Collection<V>>>)collection)));
                }
                
                @Override
                public int size() {
                    return Iterators.size(this.iterator());
                }
            };
        }
        
        @Override
        Set<K> createKeySet() {
            return (Set<K>)new Maps.KeySet<K, Collection<V>>(this) {
                @Override
                public boolean remove(@Nullable final Object o) {
                    return AsMap.this.remove(o) != null;
                }
                
                @Override
                public boolean removeAll(final Collection<?> collection) {
                    return FilteredEntryMultimap.this.removeEntriesIf(Maps.keyPredicateOnEntries(Predicates.in(collection)));
                }
                
                @Override
                public boolean retainAll(final Collection<?> collection) {
                    return FilteredEntryMultimap.this.removeEntriesIf(Maps.keyPredicateOnEntries(Predicates.not(Predicates.in((Collection<? extends K>)collection))));
                }
            };
        }
        
        @Override
        Collection<Collection<V>> createValues() {
            return (Collection<Collection<V>>)new Maps.Values<K, Collection<V>>(this) {
                @Override
                public boolean remove(@Nullable final Object o) {
                    if (o instanceof Collection) {
                        final Collection collection = (Collection)o;
                        final Iterator<Map.Entry<K, Collection<V>>> iterator = FilteredEntryMultimap.this.unfiltered.asMap().entrySet().iterator();
                        while (iterator.hasNext()) {
                            final Map.Entry<K, Collection<V>> entry = iterator.next();
                            final Collection<V> filterCollection = FilteredEntryMultimap.filterCollection(entry.getValue(), new ValuePredicate(entry.getKey()));
                            if (!filterCollection.isEmpty() && collection.equals(filterCollection)) {
                                if (filterCollection.size() == entry.getValue().size()) {
                                    iterator.remove();
                                }
                                else {
                                    filterCollection.clear();
                                }
                                return true;
                            }
                        }
                    }
                    return false;
                }
                
                @Override
                public boolean removeAll(final Collection<?> collection) {
                    return FilteredEntryMultimap.this.removeEntriesIf(Maps.valuePredicateOnEntries(Predicates.in(collection)));
                }
                
                @Override
                public boolean retainAll(final Collection<?> collection) {
                    return FilteredEntryMultimap.this.removeEntriesIf(Maps.valuePredicateOnEntries(Predicates.not(Predicates.in((Collection<? extends V>)collection))));
                }
            };
        }
        
        @Override
        public Collection<V> get(@Nullable final Object o) {
            final Collection<V> collection = FilteredEntryMultimap.this.unfiltered.asMap().get(o);
            if (collection != null) {
                final Collection<V> filterCollection = FilteredEntryMultimap.filterCollection(collection, new ValuePredicate((K)o));
                if (!filterCollection.isEmpty()) {
                    return filterCollection;
                }
            }
            return null;
        }
        
        @Override
        public Collection<V> remove(@Nullable final Object o) {
            final Collection<V> collection = FilteredEntryMultimap.this.unfiltered.asMap().get(o);
            if (collection != null) {
                final ArrayList<Object> arrayList = Lists.newArrayList();
                final Iterator<V> iterator = collection.iterator();
                while (iterator.hasNext()) {
                    final V next = iterator.next();
                    if (FilteredEntryMultimap.this.satisfies(o, next)) {
                        iterator.remove();
                        arrayList.add(next);
                    }
                }
                if (!arrayList.isEmpty()) {
                    if (FilteredEntryMultimap.this.unfiltered instanceof SetMultimap) {
                        return (Collection<V>)Collections.unmodifiableSet((Set<?>)Sets.newLinkedHashSet((Iterable<?>)arrayList));
                    }
                    return (Collection<V>)Collections.unmodifiableList((List<?>)arrayList);
                }
            }
            return null;
        }
    }
    
    class Keys extends Multimaps.Keys<K, V>
    {
        Keys() {
            super(FilteredEntryMultimap.this);
        }
        
        @Override
        public Set<Entry<K>> entrySet() {
            return (Set<Entry<K>>)new Multisets.EntrySet<K>() {
                private boolean removeEntriesIf(final Predicate<? super Entry<K>> predicate) {
                    return FilteredEntryMultimap.this.removeEntriesIf(new Predicate<Map.Entry<K, Collection<V>>>() {
                        @Override
                        public boolean apply(final Map.Entry<K, Collection<V>> entry) {
                            return predicate.apply(Multisets.immutableEntry(entry.getKey(), entry.getValue().size()));
                        }
                    });
                }
                
                @Override
                public Iterator<Entry<K>> iterator() {
                    return ((Multimaps.Keys<K, V>)Keys.this).entryIterator();
                }
                
                @Override
                Multiset<K> multiset() {
                    return (Multiset<K>)Keys.this;
                }
                
                @Override
                public boolean removeAll(final Collection<?> collection) {
                    return this.removeEntriesIf(Predicates.in((Collection<? extends Entry<K>>)collection));
                }
                
                @Override
                public boolean retainAll(final Collection<?> collection) {
                    return this.removeEntriesIf(Predicates.not(Predicates.in((Collection<? extends Entry<K>>)collection)));
                }
                
                @Override
                public int size() {
                    return FilteredEntryMultimap.this.keySet().size();
                }
            };
        }
        
        @Override
        public int remove(@Nullable final Object o, final int n) {
            CollectPreconditions.checkNonnegative(n, "occurrences");
            int count;
            if (n == 0) {
                count = ((Multimaps.Keys)this).count(o);
            }
            else {
                final Collection<V> collection = FilteredEntryMultimap.this.unfiltered.asMap().get(o);
                if (collection == null) {
                    return 0;
                }
                int n2 = 0;
                final Iterator<V> iterator = collection.iterator();
                while (true) {
                    count = n2;
                    if (!iterator.hasNext()) {
                        break;
                    }
                    if (!FilteredEntryMultimap.this.satisfies(o, iterator.next())) {
                        continue;
                    }
                    final int n3 = n2 + 1;
                    if ((n2 = n3) > n) {
                        continue;
                    }
                    iterator.remove();
                    n2 = n3;
                }
            }
            return count;
        }
    }
    
    final class ValuePredicate implements Predicate<V>
    {
        private final K key;
        
        ValuePredicate(final K key) {
            this.key = key;
        }
        
        @Override
        public boolean apply(@Nullable final V v) {
            return FilteredEntryMultimap.this.satisfies(this.key, v);
        }
    }
}
