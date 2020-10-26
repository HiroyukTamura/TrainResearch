// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.ListIterator;
import java.util.ConcurrentModificationException;
import java.util.AbstractCollection;
import java.util.Comparator;
import java.util.NavigableSet;
import com.google.common.annotations.GwtIncompatible;
import java.util.NavigableMap;
import java.util.Collections;
import java.util.SortedSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.RandomAccess;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Iterator;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Map;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

@GwtCompatible(emulated = true)
abstract class AbstractMapBasedMultimap<K, V> extends AbstractMultimap<K, V> implements Serializable
{
    private static final long serialVersionUID = 2447537837011683357L;
    private transient Map<K, Collection<V>> map;
    private transient int totalSize;
    
    protected AbstractMapBasedMultimap(final Map<K, Collection<V>> map) {
        Preconditions.checkArgument(map.isEmpty());
        this.map = map;
    }
    
    static /* synthetic */ int access$212(final AbstractMapBasedMultimap abstractMapBasedMultimap, int totalSize) {
        totalSize += abstractMapBasedMultimap.totalSize;
        return abstractMapBasedMultimap.totalSize = totalSize;
    }
    
    static /* synthetic */ int access$220(final AbstractMapBasedMultimap abstractMapBasedMultimap, int totalSize) {
        totalSize = abstractMapBasedMultimap.totalSize - totalSize;
        return abstractMapBasedMultimap.totalSize = totalSize;
    }
    
    private Collection<V> getOrCreateCollection(@Nullable final K k) {
        Collection<V> collection;
        if ((collection = this.map.get(k)) == null) {
            collection = this.createCollection(k);
            this.map.put(k, collection);
        }
        return collection;
    }
    
    private Iterator<V> iteratorOrListIterator(final Collection<V> collection) {
        if (collection instanceof List) {
            return (Iterator<V>)((List)collection).listIterator();
        }
        return collection.iterator();
    }
    
    private int removeValuesForKey(final Object o) {
        final Collection<V> collection = Maps.safeRemove(this.map, o);
        int size = 0;
        if (collection != null) {
            size = collection.size();
            collection.clear();
            this.totalSize -= size;
        }
        return size;
    }
    
    private List<V> wrapList(@Nullable final K k, final List<V> list, @Nullable final WrappedCollection collection) {
        if (list instanceof RandomAccess) {
            return new RandomAccessWrappedList(k, list, collection);
        }
        return new WrappedList(k, list, collection);
    }
    
    Map<K, Collection<V>> backingMap() {
        return this.map;
    }
    
    @Override
    public void clear() {
        final Iterator<Collection<V>> iterator = this.map.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().clear();
        }
        this.map.clear();
        this.totalSize = 0;
    }
    
    @Override
    public boolean containsKey(@Nullable final Object o) {
        return this.map.containsKey(o);
    }
    
    @Override
    Map<K, Collection<V>> createAsMap() {
        if (this.map instanceof SortedMap) {
            return new SortedAsMap((SortedMap)this.map);
        }
        return new AsMap(this.map);
    }
    
    abstract Collection<V> createCollection();
    
    Collection<V> createCollection(@Nullable final K k) {
        return this.createCollection();
    }
    
    @Override
    Set<K> createKeySet() {
        if (this.map instanceof SortedMap) {
            return (Set<K>)new SortedKeySet((SortedMap)this.map);
        }
        return (Set<K>)new KeySet(this.map);
    }
    
    Collection<V> createUnmodifiableEmptyCollection() {
        return this.unmodifiableCollectionSubclass(this.createCollection());
    }
    
    @Override
    public Collection<Map.Entry<K, V>> entries() {
        return super.entries();
    }
    
    @Override
    Iterator<Map.Entry<K, V>> entryIterator() {
        return new Itr<Map.Entry<K, V>>() {
            Map.Entry<K, V> output(final K k, final V v) {
                return Maps.immutableEntry(k, v);
            }
        };
    }
    
    @Override
    public Collection<V> get(@Nullable final K k) {
        Collection<V> collection;
        if ((collection = this.map.get(k)) == null) {
            collection = this.createCollection(k);
        }
        return this.wrapCollection(k, collection);
    }
    
    @Override
    public boolean put(@Nullable final K k, @Nullable final V v) {
        final Collection<V> collection = this.map.get(k);
        if (collection == null) {
            final Collection<V> collection2 = this.createCollection(k);
            if (collection2.add(v)) {
                ++this.totalSize;
                this.map.put(k, collection2);
                return true;
            }
            throw new AssertionError((Object)"New Collection violated the Collection spec");
        }
        else {
            if (collection.add(v)) {
                ++this.totalSize;
                return true;
            }
            return false;
        }
    }
    
    @Override
    public Collection<V> removeAll(@Nullable final Object o) {
        final Collection<V> collection = this.map.remove(o);
        if (collection == null) {
            return this.createUnmodifiableEmptyCollection();
        }
        final Collection<V> collection2 = this.createCollection();
        collection2.addAll((Collection<? extends V>)collection);
        this.totalSize -= collection.size();
        collection.clear();
        return this.unmodifiableCollectionSubclass(collection2);
    }
    
    @Override
    public Collection<V> replaceValues(@Nullable final K k, final Iterable<? extends V> iterable) {
        final Iterator<? extends V> iterator = iterable.iterator();
        if (!iterator.hasNext()) {
            return this.removeAll(k);
        }
        final Collection<Object> orCreateCollection = (Collection<Object>)this.getOrCreateCollection(k);
        final Collection<V> collection = this.createCollection();
        collection.addAll((Collection<? extends V>)orCreateCollection);
        this.totalSize -= orCreateCollection.size();
        orCreateCollection.clear();
        while (iterator.hasNext()) {
            if (orCreateCollection.add(iterator.next())) {
                ++this.totalSize;
            }
        }
        return this.unmodifiableCollectionSubclass(collection);
    }
    
    final void setMap(final Map<K, Collection<V>> map) {
        this.map = map;
        this.totalSize = 0;
        for (final Collection<V> collection : map.values()) {
            Preconditions.checkArgument(!collection.isEmpty());
            this.totalSize += collection.size();
        }
    }
    
    @Override
    public int size() {
        return this.totalSize;
    }
    
    Collection<V> unmodifiableCollectionSubclass(final Collection<V> c) {
        if (c instanceof SortedSet) {
            return (Collection<V>)Collections.unmodifiableSortedSet((SortedSet<Object>)c);
        }
        if (c instanceof Set) {
            return (Collection<V>)Collections.unmodifiableSet((Set<?>)c);
        }
        if (c instanceof List) {
            return (Collection<V>)Collections.unmodifiableList((List<?>)c);
        }
        return Collections.unmodifiableCollection((Collection<? extends V>)c);
    }
    
    @Override
    Iterator<V> valueIterator() {
        return new Itr<V>() {
            @Override
            V output(final K k, final V v) {
                return v;
            }
        };
    }
    
    @Override
    public Collection<V> values() {
        return super.values();
    }
    
    Collection<V> wrapCollection(@Nullable final K k, final Collection<V> collection) {
        if (collection instanceof SortedSet) {
            return new WrappedSortedSet(k, (SortedSet<V>)collection, null);
        }
        if (collection instanceof Set) {
            return new WrappedSet(k, (Set<V>)collection);
        }
        if (collection instanceof List) {
            return this.wrapList(k, (List<V>)collection, null);
        }
        return new WrappedCollection(k, collection, null);
    }
    
    private class AsMap extends ImprovedAbstractMap<K, Collection<V>>
    {
        final transient Map<K, Collection<V>> submap;
        
        AsMap(final Map<K, Collection<V>> submap) {
            this.submap = submap;
        }
        
        @Override
        public void clear() {
            if (this.submap == AbstractMapBasedMultimap.this.map) {
                AbstractMapBasedMultimap.this.clear();
                return;
            }
            Iterators.clear(new AsMapIterator());
        }
        
        @Override
        public boolean containsKey(final Object o) {
            return Maps.safeContainsKey(this.submap, o);
        }
        
        protected Set<Entry<K, Collection<V>>> createEntrySet() {
            return (Set<Entry<K, Collection<V>>>)new AsMapEntries();
        }
        
        @Override
        public boolean equals(@Nullable final Object o) {
            return this == o || this.submap.equals(o);
        }
        
        @Override
        public Collection<V> get(final Object o) {
            final Collection<V> collection = Maps.safeGet(this.submap, o);
            if (collection == null) {
                return null;
            }
            return AbstractMapBasedMultimap.this.wrapCollection(o, collection);
        }
        
        @Override
        public int hashCode() {
            return this.submap.hashCode();
        }
        
        @Override
        public Set<K> keySet() {
            return AbstractMapBasedMultimap.this.keySet();
        }
        
        @Override
        public Collection<V> remove(final Object o) {
            final Collection<V> collection = this.submap.remove(o);
            if (collection == null) {
                return null;
            }
            final Collection<V> collection2 = AbstractMapBasedMultimap.this.createCollection();
            collection2.addAll((Collection<? extends V>)collection);
            AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, collection.size());
            collection.clear();
            return collection2;
        }
        
        @Override
        public int size() {
            return this.submap.size();
        }
        
        @Override
        public String toString() {
            return this.submap.toString();
        }
        
        Entry<K, Collection<V>> wrapEntry(final Entry<K, Collection<V>> entry) {
            final K key = entry.getKey();
            return Maps.immutableEntry(key, AbstractMapBasedMultimap.this.wrapCollection(key, entry.getValue()));
        }
        
        class AsMapEntries extends Maps.EntrySet<K, Collection<V>>
        {
            @Override
            public boolean contains(final Object o) {
                return Collections2.safeContains(AsMap.this.submap.entrySet(), o);
            }
            
            @Override
            public Iterator<Entry<K, Collection<V>>> iterator() {
                return new AsMapIterator();
            }
            
            @Override
            Map<K, Collection<V>> map() {
                return AsMap.this;
            }
            
            @Override
            public boolean remove(final Object o) {
                if (!this.contains(o)) {
                    return false;
                }
                AbstractMapBasedMultimap.this.removeValuesForKey(((Entry)o).getKey());
                return true;
            }
        }
        
        class AsMapIterator implements Iterator<Entry<K, Collection<V>>>
        {
            Collection<V> collection;
            final Iterator<Entry<K, Collection<V>>> delegateIterator;
            
            AsMapIterator() {
                this.delegateIterator = AsMap.this.submap.entrySet().iterator();
            }
            
            @Override
            public boolean hasNext() {
                return this.delegateIterator.hasNext();
            }
            
            @Override
            public Entry<K, Collection<V>> next() {
                final Entry entry = this.delegateIterator.next();
                this.collection = entry.getValue();
                return AsMap.this.wrapEntry(entry);
            }
            
            @Override
            public void remove() {
                this.delegateIterator.remove();
                AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, this.collection.size());
                this.collection.clear();
            }
        }
    }
    
    private abstract class Itr<T> implements Iterator<T>
    {
        Collection<V> collection;
        K key;
        final Iterator<Map.Entry<K, Collection<V>>> keyIterator;
        Iterator<V> valueIterator;
        
        Itr() {
            this.keyIterator = AbstractMapBasedMultimap.this.map.entrySet().iterator();
            this.key = null;
            this.collection = null;
            this.valueIterator = Iterators.emptyModifiableIterator();
        }
        
        @Override
        public boolean hasNext() {
            return this.keyIterator.hasNext() || this.valueIterator.hasNext();
        }
        
        @Override
        public T next() {
            if (!this.valueIterator.hasNext()) {
                final Map.Entry entry = this.keyIterator.next();
                this.key = entry.getKey();
                this.collection = entry.getValue();
                this.valueIterator = this.collection.iterator();
            }
            return this.output(this.key, this.valueIterator.next());
        }
        
        abstract T output(final K p0, final V p1);
        
        @Override
        public void remove() {
            this.valueIterator.remove();
            if (this.collection.isEmpty()) {
                this.keyIterator.remove();
            }
            AbstractMapBasedMultimap.this.totalSize--;
        }
    }
    
    private class KeySet extends Maps.KeySet<K, Collection<V>>
    {
        KeySet(final Map<K, Collection<V>> map) {
            super(map);
        }
        
        @Override
        public void clear() {
            Iterators.clear(this.iterator());
        }
        
        @Override
        public boolean containsAll(final Collection<?> collection) {
            return ((Maps.KeySet<K, Collection<V>>)this).map().keySet().containsAll(collection);
        }
        
        @Override
        public boolean equals(@Nullable final Object o) {
            return this == o || ((Maps.KeySet<K, Collection<V>>)this).map().keySet().equals(o);
        }
        
        @Override
        public int hashCode() {
            return ((Maps.KeySet<K, Collection<V>>)this).map().keySet().hashCode();
        }
        
        @Override
        public Iterator<K> iterator() {
            return new Iterator<K>() {
                Map.Entry<K, Collection<V>> entry;
                final /* synthetic */ Iterator val$entryIterator = ((Maps.KeySet<K, Collection<V>>)this).map().entrySet().iterator();
                
                @Override
                public boolean hasNext() {
                    return this.val$entryIterator.hasNext();
                }
                
                @Override
                public K next() {
                    this.entry = (Map.Entry<K, Collection<V>>)this.val$entryIterator.next();
                    return this.entry.getKey();
                }
                
                @Override
                public void remove() {
                    CollectPreconditions.checkRemove(this.entry != null);
                    final Collection<V> collection = this.entry.getValue();
                    this.val$entryIterator.remove();
                    AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, collection.size());
                    collection.clear();
                }
            };
        }
        
        @Override
        public boolean remove(final Object o) {
            int size = 0;
            final Collection<V> collection = ((Maps.KeySet<K, Collection<V>>)this).map().remove(o);
            if (collection != null) {
                size = collection.size();
                collection.clear();
                AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, size);
            }
            return size > 0;
        }
    }
    
    @GwtIncompatible("NavigableAsMap")
    class NavigableAsMap extends SortedAsMap implements NavigableMap<K, Collection<V>>
    {
        NavigableAsMap(final NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }
        
        @Override
        public Entry<K, Collection<V>> ceilingEntry(final K k) {
            final Map.Entry<K, Collection<V>> ceilingEntry = this.sortedMap().ceilingEntry(k);
            if (ceilingEntry == null) {
                return null;
            }
            return ((AsMap)this).wrapEntry(ceilingEntry);
        }
        
        @Override
        public K ceilingKey(final K k) {
            return this.sortedMap().ceilingKey(k);
        }
        
        NavigableSet<K> createKeySet() {
            return new AbstractMapBasedMultimap.NavigableKeySet(this.sortedMap());
        }
        
        @Override
        public NavigableSet<K> descendingKeySet() {
            return this.descendingMap().navigableKeySet();
        }
        
        @Override
        public NavigableMap<K, Collection<V>> descendingMap() {
            return new NavigableAsMap(this.sortedMap().descendingMap());
        }
        
        @Override
        public Entry<K, Collection<V>> firstEntry() {
            final Map.Entry<K, Collection<V>> firstEntry = this.sortedMap().firstEntry();
            if (firstEntry == null) {
                return null;
            }
            return ((AsMap)this).wrapEntry(firstEntry);
        }
        
        @Override
        public Entry<K, Collection<V>> floorEntry(final K k) {
            final Map.Entry<K, Collection<V>> floorEntry = this.sortedMap().floorEntry(k);
            if (floorEntry == null) {
                return null;
            }
            return ((AsMap)this).wrapEntry(floorEntry);
        }
        
        @Override
        public K floorKey(final K k) {
            return this.sortedMap().floorKey(k);
        }
        
        @Override
        public NavigableMap<K, Collection<V>> headMap(final K k) {
            return this.headMap(k, false);
        }
        
        @Override
        public NavigableMap<K, Collection<V>> headMap(final K k, final boolean b) {
            return new NavigableAsMap(this.sortedMap().headMap(k, b));
        }
        
        @Override
        public Entry<K, Collection<V>> higherEntry(final K k) {
            final Map.Entry<K, Collection<V>> higherEntry = this.sortedMap().higherEntry(k);
            if (higherEntry == null) {
                return null;
            }
            return ((AsMap)this).wrapEntry(higherEntry);
        }
        
        @Override
        public K higherKey(final K k) {
            return this.sortedMap().higherKey(k);
        }
        
        @Override
        public NavigableSet<K> keySet() {
            return (NavigableSet<K>)(NavigableSet)super.keySet();
        }
        
        @Override
        public Entry<K, Collection<V>> lastEntry() {
            final Map.Entry<K, Collection<V>> lastEntry = this.sortedMap().lastEntry();
            if (lastEntry == null) {
                return null;
            }
            return ((AsMap)this).wrapEntry(lastEntry);
        }
        
        @Override
        public Entry<K, Collection<V>> lowerEntry(final K k) {
            final Map.Entry<K, Collection<V>> lowerEntry = this.sortedMap().lowerEntry(k);
            if (lowerEntry == null) {
                return null;
            }
            return ((AsMap)this).wrapEntry(lowerEntry);
        }
        
        @Override
        public K lowerKey(final K k) {
            return this.sortedMap().lowerKey(k);
        }
        
        @Override
        public NavigableSet<K> navigableKeySet() {
            return this.keySet();
        }
        
        Entry<K, Collection<V>> pollAsMapEntry(final Iterator<Entry<K, Collection<V>>> iterator) {
            if (!iterator.hasNext()) {
                return null;
            }
            final Entry entry = iterator.next();
            final Collection<V> collection = AbstractMapBasedMultimap.this.createCollection();
            collection.addAll(entry.getValue());
            iterator.remove();
            return Maps.immutableEntry((K)entry.getKey(), AbstractMapBasedMultimap.this.unmodifiableCollectionSubclass(collection));
        }
        
        @Override
        public Entry<K, Collection<V>> pollFirstEntry() {
            return this.pollAsMapEntry(((Maps.ImprovedAbstractMap<K, Collection<V>>)this).entrySet().iterator());
        }
        
        @Override
        public Entry<K, Collection<V>> pollLastEntry() {
            return (Entry<K, Collection<V>>)this.pollAsMapEntry((Iterator<Entry<Object, Collection<V>>>)this.descendingMap().entrySet().iterator());
        }
        
        NavigableMap<K, Collection<V>> sortedMap() {
            return (NavigableMap<K, Collection<V>>)(NavigableMap)super.sortedMap();
        }
        
        @Override
        public NavigableMap<K, Collection<V>> subMap(final K k, final K i) {
            return this.subMap(k, true, i, false);
        }
        
        @Override
        public NavigableMap<K, Collection<V>> subMap(final K k, final boolean b, final K i, final boolean b2) {
            return new NavigableAsMap(this.sortedMap().subMap(k, b, i, b2));
        }
        
        @Override
        public NavigableMap<K, Collection<V>> tailMap(final K k) {
            return this.tailMap(k, true);
        }
        
        @Override
        public NavigableMap<K, Collection<V>> tailMap(final K k, final boolean b) {
            return new NavigableAsMap(this.sortedMap().tailMap(k, b));
        }
    }
    
    @GwtIncompatible("NavigableSet")
    class NavigableKeySet extends SortedKeySet implements NavigableSet<K>
    {
        NavigableKeySet(final NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }
        
        @Override
        public K ceiling(final K k) {
            return this.sortedMap().ceilingKey(k);
        }
        
        @Override
        public Iterator<K> descendingIterator() {
            return this.descendingSet().iterator();
        }
        
        @Override
        public NavigableSet<K> descendingSet() {
            return new NavigableKeySet(this.sortedMap().descendingMap());
        }
        
        @Override
        public K floor(final K k) {
            return this.sortedMap().floorKey(k);
        }
        
        @Override
        public NavigableSet<K> headSet(final K k) {
            return this.headSet(k, false);
        }
        
        @Override
        public NavigableSet<K> headSet(final K k, final boolean b) {
            return new NavigableKeySet(this.sortedMap().headMap(k, b));
        }
        
        @Override
        public K higher(final K k) {
            return this.sortedMap().higherKey(k);
        }
        
        @Override
        public K lower(final K k) {
            return this.sortedMap().lowerKey(k);
        }
        
        @Override
        public K pollFirst() {
            return Iterators.pollNext(((KeySet)this).iterator());
        }
        
        @Override
        public K pollLast() {
            return Iterators.pollNext(this.descendingIterator());
        }
        
        NavigableMap<K, Collection<V>> sortedMap() {
            return (NavigableMap<K, Collection<V>>)(NavigableMap)super.sortedMap();
        }
        
        @Override
        public NavigableSet<K> subSet(final K k, final K i) {
            return this.subSet(k, true, i, false);
        }
        
        @Override
        public NavigableSet<K> subSet(final K k, final boolean b, final K i, final boolean b2) {
            return new NavigableKeySet(this.sortedMap().subMap(k, b, i, b2));
        }
        
        @Override
        public NavigableSet<K> tailSet(final K k) {
            return this.tailSet(k, true);
        }
        
        @Override
        public NavigableSet<K> tailSet(final K k, final boolean b) {
            return new NavigableKeySet(this.sortedMap().tailMap(k, b));
        }
    }
    
    private class RandomAccessWrappedList extends WrappedList implements RandomAccess
    {
        RandomAccessWrappedList(final K k, @Nullable final List<V> list, final WrappedCollection collection) {
            super(k, list, collection);
        }
    }
    
    private class SortedAsMap extends AsMap implements SortedMap<K, Collection<V>>
    {
        SortedSet<K> sortedKeySet;
        
        SortedAsMap(final SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }
        
        @Override
        public Comparator<? super K> comparator() {
            return this.sortedMap().comparator();
        }
        
        SortedSet<K> createKeySet() {
            return new AbstractMapBasedMultimap.SortedKeySet(this.sortedMap());
        }
        
        @Override
        public K firstKey() {
            return this.sortedMap().firstKey();
        }
        
        @Override
        public SortedMap<K, Collection<V>> headMap(final K k) {
            return new SortedAsMap(this.sortedMap().headMap(k));
        }
        
        @Override
        public SortedSet<K> keySet() {
            SortedSet<K> sortedKeySet;
            if ((sortedKeySet = this.sortedKeySet) == null) {
                sortedKeySet = this.createKeySet();
                this.sortedKeySet = sortedKeySet;
            }
            return sortedKeySet;
        }
        
        @Override
        public K lastKey() {
            return this.sortedMap().lastKey();
        }
        
        SortedMap<K, Collection<V>> sortedMap() {
            return (SortedMap<K, Collection<V>>)(SortedMap)this.submap;
        }
        
        @Override
        public SortedMap<K, Collection<V>> subMap(final K k, final K i) {
            return new SortedAsMap(this.sortedMap().subMap(k, i));
        }
        
        @Override
        public SortedMap<K, Collection<V>> tailMap(final K k) {
            return new SortedAsMap(this.sortedMap().tailMap(k));
        }
    }
    
    private class SortedKeySet extends KeySet implements SortedSet<K>
    {
        SortedKeySet(final SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }
        
        @Override
        public Comparator<? super K> comparator() {
            return this.sortedMap().comparator();
        }
        
        @Override
        public K first() {
            return this.sortedMap().firstKey();
        }
        
        @Override
        public SortedSet<K> headSet(final K k) {
            return new SortedKeySet(this.sortedMap().headMap(k));
        }
        
        @Override
        public K last() {
            return this.sortedMap().lastKey();
        }
        
        SortedMap<K, Collection<V>> sortedMap() {
            return (SortedMap<K, Collection<V>>)(SortedMap)super.map();
        }
        
        @Override
        public SortedSet<K> subSet(final K k, final K i) {
            return new SortedKeySet(this.sortedMap().subMap(k, i));
        }
        
        @Override
        public SortedSet<K> tailSet(final K k) {
            return new SortedKeySet(this.sortedMap().tailMap(k));
        }
    }
    
    private class WrappedCollection extends AbstractCollection<V>
    {
        final WrappedCollection ancestor;
        final Collection<V> ancestorDelegate;
        Collection<V> delegate;
        final K key;
        
        WrappedCollection(final K key, @Nullable final Collection<V> delegate, final WrappedCollection ancestor) {
            this.key = key;
            this.delegate = delegate;
            this.ancestor = ancestor;
            Collection<V> delegate2;
            if (ancestor == null) {
                delegate2 = null;
            }
            else {
                delegate2 = ancestor.getDelegate();
            }
            this.ancestorDelegate = delegate2;
        }
        
        @Override
        public boolean add(final V v) {
            this.refreshIfEmpty();
            final boolean empty = this.delegate.isEmpty();
            final boolean add = this.delegate.add(v);
            if (add) {
                AbstractMapBasedMultimap.this.totalSize++;
                if (empty) {
                    this.addToMap();
                }
            }
            return add;
        }
        
        @Override
        public boolean addAll(final Collection<? extends V> collection) {
            boolean addAll;
            if (collection.isEmpty()) {
                addAll = false;
            }
            else {
                final int size = this.size();
                final boolean b = addAll = this.delegate.addAll(collection);
                if (b) {
                    AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.delegate.size() - size);
                    addAll = b;
                    if (size == 0) {
                        this.addToMap();
                        return b;
                    }
                }
            }
            return addAll;
        }
        
        void addToMap() {
            if (this.ancestor != null) {
                this.ancestor.addToMap();
                return;
            }
            AbstractMapBasedMultimap.this.map.put(this.key, this.delegate);
        }
        
        @Override
        public void clear() {
            final int size = this.size();
            if (size == 0) {
                return;
            }
            this.delegate.clear();
            AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, size);
            this.removeIfEmpty();
        }
        
        @Override
        public boolean contains(final Object o) {
            this.refreshIfEmpty();
            return this.delegate.contains(o);
        }
        
        @Override
        public boolean containsAll(final Collection<?> collection) {
            this.refreshIfEmpty();
            return this.delegate.containsAll(collection);
        }
        
        @Override
        public boolean equals(@Nullable final Object o) {
            if (o == this) {
                return true;
            }
            this.refreshIfEmpty();
            return this.delegate.equals(o);
        }
        
        WrappedCollection getAncestor() {
            return this.ancestor;
        }
        
        Collection<V> getDelegate() {
            return this.delegate;
        }
        
        K getKey() {
            return this.key;
        }
        
        @Override
        public int hashCode() {
            this.refreshIfEmpty();
            return this.delegate.hashCode();
        }
        
        @Override
        public Iterator<V> iterator() {
            this.refreshIfEmpty();
            return new WrappedIterator();
        }
        
        void refreshIfEmpty() {
            if (this.ancestor != null) {
                this.ancestor.refreshIfEmpty();
                if (this.ancestor.getDelegate() != this.ancestorDelegate) {
                    throw new ConcurrentModificationException();
                }
            }
            else if (this.delegate.isEmpty()) {
                final Collection<V> delegate = AbstractMapBasedMultimap.this.map.get(this.key);
                if (delegate != null) {
                    this.delegate = delegate;
                }
            }
        }
        
        @Override
        public boolean remove(final Object o) {
            this.refreshIfEmpty();
            final boolean remove = this.delegate.remove(o);
            if (remove) {
                AbstractMapBasedMultimap.this.totalSize--;
                this.removeIfEmpty();
            }
            return remove;
        }
        
        @Override
        public boolean removeAll(final Collection<?> collection) {
            boolean removeAll;
            if (collection.isEmpty()) {
                removeAll = false;
            }
            else {
                final int size = this.size();
                final boolean b = removeAll = this.delegate.removeAll(collection);
                if (b) {
                    AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.delegate.size() - size);
                    this.removeIfEmpty();
                    return b;
                }
            }
            return removeAll;
        }
        
        void removeIfEmpty() {
            if (this.ancestor != null) {
                this.ancestor.removeIfEmpty();
            }
            else if (this.delegate.isEmpty()) {
                AbstractMapBasedMultimap.this.map.remove(this.key);
            }
        }
        
        @Override
        public boolean retainAll(final Collection<?> collection) {
            Preconditions.checkNotNull(collection);
            final int size = this.size();
            final boolean retainAll = this.delegate.retainAll(collection);
            if (retainAll) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.delegate.size() - size);
                this.removeIfEmpty();
            }
            return retainAll;
        }
        
        @Override
        public int size() {
            this.refreshIfEmpty();
            return this.delegate.size();
        }
        
        @Override
        public String toString() {
            this.refreshIfEmpty();
            return this.delegate.toString();
        }
        
        class WrappedIterator implements Iterator<V>
        {
            final Iterator<V> delegateIterator;
            final Collection<V> originalDelegate;
            
            WrappedIterator() {
                this.originalDelegate = WrappedCollection.this.delegate;
                this.delegateIterator = (Iterator<V>)AbstractMapBasedMultimap.this.iteratorOrListIterator(WrappedCollection.this.delegate);
            }
            
            WrappedIterator(final Iterator<V> delegateIterator) {
                this.originalDelegate = WrappedCollection.this.delegate;
                this.delegateIterator = delegateIterator;
            }
            
            Iterator<V> getDelegateIterator() {
                this.validateIterator();
                return this.delegateIterator;
            }
            
            @Override
            public boolean hasNext() {
                this.validateIterator();
                return this.delegateIterator.hasNext();
            }
            
            @Override
            public V next() {
                this.validateIterator();
                return this.delegateIterator.next();
            }
            
            @Override
            public void remove() {
                this.delegateIterator.remove();
                AbstractMapBasedMultimap.this.totalSize--;
                WrappedCollection.this.removeIfEmpty();
            }
            
            void validateIterator() {
                WrappedCollection.this.refreshIfEmpty();
                if (WrappedCollection.this.delegate != this.originalDelegate) {
                    throw new ConcurrentModificationException();
                }
            }
        }
    }
    
    private class WrappedList extends WrappedCollection implements List<V>
    {
        WrappedList(final K k, @Nullable final List<V> list, final WrappedCollection collection) {
            super(k, list, collection);
        }
        
        @Override
        public void add(final int n, final V v) {
            ((WrappedCollection)this).refreshIfEmpty();
            final boolean empty = ((WrappedCollection)this).getDelegate().isEmpty();
            this.getListDelegate().add(n, v);
            AbstractMapBasedMultimap.this.totalSize++;
            if (empty) {
                ((WrappedCollection)this).addToMap();
            }
        }
        
        @Override
        public boolean addAll(int size, final Collection<? extends V> collection) {
            boolean addAll;
            if (collection.isEmpty()) {
                addAll = false;
            }
            else {
                final int size2 = ((WrappedCollection)this).size();
                final boolean b = addAll = this.getListDelegate().addAll(size, collection);
                if (b) {
                    size = ((WrappedCollection)this).getDelegate().size();
                    AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, size - size2);
                    addAll = b;
                    if (size2 == 0) {
                        ((WrappedCollection)this).addToMap();
                        return b;
                    }
                }
            }
            return addAll;
        }
        
        @Override
        public V get(final int n) {
            ((WrappedCollection)this).refreshIfEmpty();
            return this.getListDelegate().get(n);
        }
        
        List<V> getListDelegate() {
            return (List<V>)(List)((WrappedCollection)this).getDelegate();
        }
        
        @Override
        public int indexOf(final Object o) {
            ((WrappedCollection)this).refreshIfEmpty();
            return this.getListDelegate().indexOf(o);
        }
        
        @Override
        public int lastIndexOf(final Object o) {
            ((WrappedCollection)this).refreshIfEmpty();
            return this.getListDelegate().lastIndexOf(o);
        }
        
        @Override
        public ListIterator<V> listIterator() {
            ((WrappedCollection)this).refreshIfEmpty();
            return new WrappedListIterator();
        }
        
        @Override
        public ListIterator<V> listIterator(final int n) {
            ((WrappedCollection)this).refreshIfEmpty();
            return new WrappedListIterator(n);
        }
        
        @Override
        public V remove(final int n) {
            ((WrappedCollection)this).refreshIfEmpty();
            final V remove = this.getListDelegate().remove(n);
            AbstractMapBasedMultimap.this.totalSize--;
            ((WrappedCollection)this).removeIfEmpty();
            return remove;
        }
        
        @Override
        public V set(final int n, final V v) {
            ((WrappedCollection)this).refreshIfEmpty();
            return this.getListDelegate().set(n, v);
        }
        
        @Override
        public List<V> subList(final int n, final int n2) {
            ((WrappedCollection)this).refreshIfEmpty();
            final AbstractMapBasedMultimap this$0 = AbstractMapBasedMultimap.this;
            final Object key = ((WrappedCollection)this).getKey();
            final List<V> subList = this.getListDelegate().subList(n, n2);
            AbstractCollection<V> ancestor;
            if (((WrappedCollection)this).getAncestor() == null) {
                ancestor = this;
            }
            else {
                ancestor = ((WrappedCollection)this).getAncestor();
            }
            return this$0.wrapList(key, subList, (WrappedCollection)ancestor);
        }
        
        private class WrappedListIterator extends WrappedIterator implements ListIterator<V>
        {
            WrappedListIterator() {
                (WrappedCollection)WrappedList.this.super();
            }
            
            public WrappedListIterator(final int n) {
                super(WrappedList.this.getListDelegate().listIterator(n));
            }
            
            private ListIterator<V> getDelegateListIterator() {
                return (ListIterator<V>)(ListIterator)((WrappedIterator)this).getDelegateIterator();
            }
            
            @Override
            public void add(final V v) {
                final boolean empty = WrappedList.this.isEmpty();
                this.getDelegateListIterator().add(v);
                AbstractMapBasedMultimap.this.totalSize++;
                if (empty) {
                    ((WrappedCollection)WrappedList.this).addToMap();
                }
            }
            
            @Override
            public boolean hasPrevious() {
                return this.getDelegateListIterator().hasPrevious();
            }
            
            @Override
            public int nextIndex() {
                return this.getDelegateListIterator().nextIndex();
            }
            
            @Override
            public V previous() {
                return this.getDelegateListIterator().previous();
            }
            
            @Override
            public int previousIndex() {
                return this.getDelegateListIterator().previousIndex();
            }
            
            @Override
            public void set(final V v) {
                this.getDelegateListIterator().set(v);
            }
        }
    }
    
    @GwtIncompatible("NavigableSet")
    class WrappedNavigableSet extends WrappedSortedSet implements NavigableSet<V>
    {
        WrappedNavigableSet(final K k, @Nullable final NavigableSet<V> set, final WrappedCollection collection) {
            super(k, set, collection);
        }
        
        private NavigableSet<V> wrap(final NavigableSet<V> set) {
            final AbstractMapBasedMultimap this$0 = AbstractMapBasedMultimap.this;
            final K key = this.key;
            AbstractCollection<V> ancestor;
            if (((WrappedCollection)this).getAncestor() == null) {
                ancestor = this;
            }
            else {
                ancestor = ((WrappedCollection)this).getAncestor();
            }
            return new WrappedNavigableSet(key, set, (WrappedCollection)ancestor);
        }
        
        @Override
        public V ceiling(final V v) {
            return this.getSortedSetDelegate().ceiling(v);
        }
        
        @Override
        public Iterator<V> descendingIterator() {
            return new WrappedIterator(this.getSortedSetDelegate().descendingIterator());
        }
        
        @Override
        public NavigableSet<V> descendingSet() {
            return this.wrap(this.getSortedSetDelegate().descendingSet());
        }
        
        @Override
        public V floor(final V v) {
            return this.getSortedSetDelegate().floor(v);
        }
        
        NavigableSet<V> getSortedSetDelegate() {
            return (NavigableSet<V>)(NavigableSet)super.getSortedSetDelegate();
        }
        
        @Override
        public NavigableSet<V> headSet(final V v, final boolean b) {
            return this.wrap(this.getSortedSetDelegate().headSet(v, b));
        }
        
        @Override
        public V higher(final V v) {
            return this.getSortedSetDelegate().higher(v);
        }
        
        @Override
        public V lower(final V v) {
            return this.getSortedSetDelegate().lower(v);
        }
        
        @Override
        public V pollFirst() {
            return Iterators.pollNext(((WrappedCollection)this).iterator());
        }
        
        @Override
        public V pollLast() {
            return Iterators.pollNext(this.descendingIterator());
        }
        
        @Override
        public NavigableSet<V> subSet(final V v, final boolean b, final V v2, final boolean b2) {
            return this.wrap(this.getSortedSetDelegate().subSet(v, b, v2, b2));
        }
        
        @Override
        public NavigableSet<V> tailSet(final V v, final boolean b) {
            return this.wrap(this.getSortedSetDelegate().tailSet(v, b));
        }
    }
    
    private class WrappedSet extends WrappedCollection implements Set<V>
    {
        WrappedSet(final K k, final Set<V> set) {
            super(k, set, null);
        }
        
        @Override
        public boolean removeAll(final Collection<?> collection) {
            boolean removeAllImpl;
            if (collection.isEmpty()) {
                removeAllImpl = false;
            }
            else {
                final int size = ((WrappedCollection)this).size();
                final boolean b = removeAllImpl = Sets.removeAllImpl((Set)this.delegate, collection);
                if (b) {
                    AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.delegate.size() - size);
                    ((WrappedCollection)this).removeIfEmpty();
                    return b;
                }
            }
            return removeAllImpl;
        }
    }
    
    private class WrappedSortedSet extends WrappedCollection implements SortedSet<V>
    {
        WrappedSortedSet(final K k, @Nullable final SortedSet<V> set, final WrappedCollection collection) {
            super(k, set, collection);
        }
        
        @Override
        public Comparator<? super V> comparator() {
            return this.getSortedSetDelegate().comparator();
        }
        
        @Override
        public V first() {
            ((WrappedCollection)this).refreshIfEmpty();
            return this.getSortedSetDelegate().first();
        }
        
        SortedSet<V> getSortedSetDelegate() {
            return (SortedSet<V>)(SortedSet)((WrappedCollection)this).getDelegate();
        }
        
        @Override
        public SortedSet<V> headSet(final V v) {
            ((WrappedCollection)this).refreshIfEmpty();
            final AbstractMapBasedMultimap this$0 = AbstractMapBasedMultimap.this;
            final K key = ((WrappedCollection)this).getKey();
            final SortedSet<V> headSet = this.getSortedSetDelegate().headSet(v);
            AbstractCollection<V> ancestor;
            if (((WrappedCollection)this).getAncestor() == null) {
                ancestor = this;
            }
            else {
                ancestor = ((WrappedCollection)this).getAncestor();
            }
            return new WrappedSortedSet(key, headSet, (WrappedCollection)ancestor);
        }
        
        @Override
        public V last() {
            ((WrappedCollection)this).refreshIfEmpty();
            return this.getSortedSetDelegate().last();
        }
        
        @Override
        public SortedSet<V> subSet(final V v, final V v2) {
            ((WrappedCollection)this).refreshIfEmpty();
            final AbstractMapBasedMultimap this$0 = AbstractMapBasedMultimap.this;
            final K key = ((WrappedCollection)this).getKey();
            final SortedSet<V> subSet = this.getSortedSetDelegate().subSet(v, v2);
            AbstractCollection<V> ancestor;
            if (((WrappedCollection)this).getAncestor() == null) {
                ancestor = this;
            }
            else {
                ancestor = ((WrappedCollection)this).getAncestor();
            }
            return new WrappedSortedSet(key, subSet, (WrappedCollection)ancestor);
        }
        
        @Override
        public SortedSet<V> tailSet(final V v) {
            ((WrappedCollection)this).refreshIfEmpty();
            final AbstractMapBasedMultimap this$0 = AbstractMapBasedMultimap.this;
            final K key = ((WrappedCollection)this).getKey();
            final SortedSet<V> tailSet = this.getSortedSetDelegate().tailSet(v);
            AbstractCollection<V> ancestor;
            if (((WrappedCollection)this).getAncestor() == null) {
                ancestor = this;
            }
            else {
                ancestor = ((WrappedCollection)this).getAncestor();
            }
            return new WrappedSortedSet(key, tailSet, (WrappedCollection)ancestor);
        }
    }
}
