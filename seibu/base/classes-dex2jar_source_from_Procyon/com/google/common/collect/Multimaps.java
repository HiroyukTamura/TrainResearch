// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Comparator;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import com.google.common.annotations.GwtIncompatible;
import java.util.Collections;
import com.google.common.base.Supplier;
import java.util.Iterator;
import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import javax.annotation.Nullable;
import java.util.SortedSet;
import java.util.Set;
import com.google.common.annotations.Beta;
import java.util.List;
import java.util.Map;
import java.util.Collection;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
public final class Multimaps
{
    private Multimaps() {
    }
    
    @Beta
    public static <K, V> Map<K, List<V>> asMap(final ListMultimap<K, V> listMultimap) {
        return (Map<K, List<V>>)listMultimap.asMap();
    }
    
    @Beta
    public static <K, V> Map<K, Collection<V>> asMap(final Multimap<K, V> multimap) {
        return multimap.asMap();
    }
    
    @Beta
    public static <K, V> Map<K, Set<V>> asMap(final SetMultimap<K, V> setMultimap) {
        return (Map<K, Set<V>>)setMultimap.asMap();
    }
    
    @Beta
    public static <K, V> Map<K, SortedSet<V>> asMap(final SortedSetMultimap<K, V> sortedSetMultimap) {
        return (Map<K, SortedSet<V>>)sortedSetMultimap.asMap();
    }
    
    static boolean equalsImpl(final Multimap<?, ?> multimap, @Nullable final Object o) {
        return o == multimap || (o instanceof Multimap && multimap.asMap().equals(((Multimap)o).asMap()));
    }
    
    public static <K, V> Multimap<K, V> filterEntries(final Multimap<K, V> multimap, final Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.checkNotNull(predicate);
        if (multimap instanceof SetMultimap) {
            return (Multimap<K, V>)filterEntries((SetMultimap<Object, Object>)multimap, (Predicate<? super Map.Entry<Object, Object>>)predicate);
        }
        if (multimap instanceof FilteredMultimap) {
            return filterFiltered((FilteredMultimap<K, V>)multimap, predicate);
        }
        return new FilteredEntryMultimap<K, V>((Multimap<K, V>)Preconditions.checkNotNull((FilteredMultimap<K, V>)multimap), predicate);
    }
    
    public static <K, V> SetMultimap<K, V> filterEntries(final SetMultimap<K, V> setMultimap, final Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.checkNotNull(predicate);
        if (setMultimap instanceof FilteredSetMultimap) {
            return filterFiltered((FilteredSetMultimap<K, V>)setMultimap, predicate);
        }
        return new FilteredEntrySetMultimap<K, V>((SetMultimap<K, V>)Preconditions.checkNotNull((FilteredSetMultimap<K, V>)setMultimap), predicate);
    }
    
    private static <K, V> Multimap<K, V> filterFiltered(final FilteredMultimap<K, V> filteredMultimap, final Predicate<? super Map.Entry<K, V>> predicate) {
        return new FilteredEntryMultimap<K, V>(filteredMultimap.unfiltered(), Predicates.and(filteredMultimap.entryPredicate(), predicate));
    }
    
    private static <K, V> SetMultimap<K, V> filterFiltered(final FilteredSetMultimap<K, V> filteredSetMultimap, final Predicate<? super Map.Entry<K, V>> predicate) {
        return new FilteredEntrySetMultimap<K, V>(filteredSetMultimap.unfiltered(), Predicates.and((Predicate<? super Map.Entry<K, V>>)filteredSetMultimap.entryPredicate(), predicate));
    }
    
    public static <K, V> ListMultimap<K, V> filterKeys(final ListMultimap<K, V> listMultimap, final Predicate<? super K> predicate) {
        if (listMultimap instanceof FilteredKeyListMultimap) {
            final FilteredKeyListMultimap<K, V> filteredKeyListMultimap = (FilteredKeyListMultimap<K, V>)listMultimap;
            return new FilteredKeyListMultimap<K, V>((ListMultimap<Object, Object>)filteredKeyListMultimap.unfiltered(), Predicates.and((Predicate<? super Object>)filteredKeyListMultimap.keyPredicate, (Predicate<? super Object>)predicate));
        }
        return new FilteredKeyListMultimap<K, V>(listMultimap, predicate);
    }
    
    public static <K, V> Multimap<K, V> filterKeys(final Multimap<K, V> multimap, final Predicate<? super K> predicate) {
        if (multimap instanceof SetMultimap) {
            return (Multimap<K, V>)filterKeys((SetMultimap<Object, Object>)multimap, (Predicate<? super Object>)predicate);
        }
        if (multimap instanceof ListMultimap) {
            return (Multimap<K, V>)filterKeys((ListMultimap<Object, Object>)multimap, (Predicate<? super Object>)predicate);
        }
        if (multimap instanceof FilteredKeyMultimap) {
            final FilteredKeyMultimap filteredKeyMultimap = (FilteredKeyMultimap<K, V>)multimap;
            return new FilteredKeyMultimap<K, V>((Multimap<Object, Object>)filteredKeyMultimap.unfiltered, Predicates.and((Predicate<? super Object>)filteredKeyMultimap.keyPredicate, (Predicate<? super Object>)predicate));
        }
        if (multimap instanceof FilteredMultimap) {
            return filterFiltered((FilteredMultimap<K, V>)multimap, (Predicate<? super Map.Entry<K, V>>)Maps.keyPredicateOnEntries((Predicate<? super Object>)predicate));
        }
        return new FilteredKeyMultimap<K, V>((Multimap<Object, Object>)multimap, (Predicate<? super Object>)predicate);
    }
    
    public static <K, V> SetMultimap<K, V> filterKeys(final SetMultimap<K, V> setMultimap, final Predicate<? super K> predicate) {
        if (setMultimap instanceof FilteredKeySetMultimap) {
            final FilteredKeySetMultimap filteredKeySetMultimap = (FilteredKeySetMultimap<K, V>)setMultimap;
            return new FilteredKeySetMultimap<K, V>((SetMultimap<Object, Object>)filteredKeySetMultimap.unfiltered(), Predicates.and((Predicate<? super Object>)filteredKeySetMultimap.keyPredicate, (Predicate<? super Object>)predicate));
        }
        if (setMultimap instanceof FilteredSetMultimap) {
            return filterFiltered((FilteredSetMultimap<K, V>)setMultimap, (Predicate<? super Map.Entry<K, V>>)Maps.keyPredicateOnEntries((Predicate<? super Object>)predicate));
        }
        return new FilteredKeySetMultimap<K, V>(setMultimap, predicate);
    }
    
    public static <K, V> Multimap<K, V> filterValues(final Multimap<K, V> multimap, final Predicate<? super V> predicate) {
        return (Multimap<K, V>)filterEntries((Multimap<Object, Object>)multimap, Maps.valuePredicateOnEntries((Predicate<? super Object>)predicate));
    }
    
    public static <K, V> SetMultimap<K, V> filterValues(final SetMultimap<K, V> setMultimap, final Predicate<? super V> predicate) {
        return (SetMultimap<K, V>)filterEntries((SetMultimap<Object, Object>)setMultimap, Maps.valuePredicateOnEntries((Predicate<? super Object>)predicate));
    }
    
    public static <K, V> SetMultimap<K, V> forMap(final Map<K, V> map) {
        return new MapMultimap<K, V>(map);
    }
    
    public static <K, V> ImmutableListMultimap<K, V> index(final Iterable<V> iterable, final Function<? super V, K> function) {
        return index(iterable.iterator(), function);
    }
    
    public static <K, V> ImmutableListMultimap<K, V> index(final Iterator<V> iterator, final Function<? super V, K> function) {
        Preconditions.checkNotNull(function);
        final ImmutableListMultimap.Builder<K, V> builder = ImmutableListMultimap.builder();
        while (iterator.hasNext()) {
            final V next = iterator.next();
            Preconditions.checkNotNull(next, iterator);
            builder.put(function.apply(next), next);
        }
        return builder.build();
    }
    
    public static <K, V, M extends Multimap<K, V>> M invertFrom(final Multimap<? extends V, ? extends K> multimap, final M m) {
        Preconditions.checkNotNull(m);
        for (final Map.Entry<? extends V, ? extends K> entry : multimap.entries()) {
            m.put((K)entry.getValue(), (V)entry.getKey());
        }
        return m;
    }
    
    public static <K, V> ListMultimap<K, V> newListMultimap(final Map<K, Collection<V>> map, final Supplier<? extends List<V>> supplier) {
        return new CustomListMultimap<K, V>(map, supplier);
    }
    
    public static <K, V> Multimap<K, V> newMultimap(final Map<K, Collection<V>> map, final Supplier<? extends Collection<V>> supplier) {
        return new CustomMultimap<K, V>(map, supplier);
    }
    
    public static <K, V> SetMultimap<K, V> newSetMultimap(final Map<K, Collection<V>> map, final Supplier<? extends Set<V>> supplier) {
        return new CustomSetMultimap<K, V>(map, supplier);
    }
    
    public static <K, V> SortedSetMultimap<K, V> newSortedSetMultimap(final Map<K, Collection<V>> map, final Supplier<? extends SortedSet<V>> supplier) {
        return new CustomSortedSetMultimap<K, V>(map, supplier);
    }
    
    public static <K, V> ListMultimap<K, V> synchronizedListMultimap(final ListMultimap<K, V> listMultimap) {
        return Synchronized.listMultimap(listMultimap, null);
    }
    
    public static <K, V> Multimap<K, V> synchronizedMultimap(final Multimap<K, V> multimap) {
        return Synchronized.multimap(multimap, null);
    }
    
    public static <K, V> SetMultimap<K, V> synchronizedSetMultimap(final SetMultimap<K, V> setMultimap) {
        return Synchronized.setMultimap(setMultimap, null);
    }
    
    public static <K, V> SortedSetMultimap<K, V> synchronizedSortedSetMultimap(final SortedSetMultimap<K, V> sortedSetMultimap) {
        return Synchronized.sortedSetMultimap(sortedSetMultimap, null);
    }
    
    public static <K, V1, V2> ListMultimap<K, V2> transformEntries(final ListMultimap<K, V1> listMultimap, final Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new TransformedEntriesListMultimap<K, Object, V2>(listMultimap, entryTransformer);
    }
    
    public static <K, V1, V2> Multimap<K, V2> transformEntries(final Multimap<K, V1> multimap, final Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return (Multimap<K, V2>)new TransformedEntriesMultimap((Multimap<Object, Object>)multimap, (Maps.EntryTransformer<? super Object, ? super Object, Object>)entryTransformer);
    }
    
    public static <K, V1, V2> ListMultimap<K, V2> transformValues(final ListMultimap<K, V1> listMultimap, final Function<? super V1, V2> function) {
        Preconditions.checkNotNull(function);
        return transformEntries(listMultimap, (Maps.EntryTransformer<? super K, ? super V1, V2>)Maps.asEntryTransformer((Function<? super V1, V2>)function));
    }
    
    public static <K, V1, V2> Multimap<K, V2> transformValues(final Multimap<K, V1> multimap, final Function<? super V1, V2> function) {
        Preconditions.checkNotNull(function);
        return transformEntries(multimap, (Maps.EntryTransformer<? super K, ? super V1, V2>)Maps.asEntryTransformer((Function<? super V1, V2>)function));
    }
    
    private static <K, V> Collection<Map.Entry<K, V>> unmodifiableEntries(final Collection<Map.Entry<K, V>> c) {
        if (c instanceof Set) {
            return (Collection<Map.Entry<K, V>>)Maps.unmodifiableEntrySet((Set<Map.Entry<Object, Object>>)c);
        }
        return (Collection<Map.Entry<K, V>>)new Maps.UnmodifiableEntries(Collections.unmodifiableCollection((Collection<? extends Map.Entry<Object, Object>>)c));
    }
    
    @Deprecated
    public static <K, V> ListMultimap<K, V> unmodifiableListMultimap(final ImmutableListMultimap<K, V> immutableListMultimap) {
        return Preconditions.checkNotNull(immutableListMultimap);
    }
    
    public static <K, V> ListMultimap<K, V> unmodifiableListMultimap(final ListMultimap<K, V> listMultimap) {
        if (listMultimap instanceof UnmodifiableListMultimap || listMultimap instanceof ImmutableListMultimap) {
            return listMultimap;
        }
        return new UnmodifiableListMultimap<K, V>(listMultimap);
    }
    
    @Deprecated
    public static <K, V> Multimap<K, V> unmodifiableMultimap(final ImmutableMultimap<K, V> immutableMultimap) {
        return Preconditions.checkNotNull(immutableMultimap);
    }
    
    public static <K, V> Multimap<K, V> unmodifiableMultimap(final Multimap<K, V> multimap) {
        if (multimap instanceof UnmodifiableMultimap || multimap instanceof ImmutableMultimap) {
            return multimap;
        }
        return new UnmodifiableMultimap<K, V>(multimap);
    }
    
    @Deprecated
    public static <K, V> SetMultimap<K, V> unmodifiableSetMultimap(final ImmutableSetMultimap<K, V> immutableSetMultimap) {
        return Preconditions.checkNotNull(immutableSetMultimap);
    }
    
    public static <K, V> SetMultimap<K, V> unmodifiableSetMultimap(final SetMultimap<K, V> setMultimap) {
        if (setMultimap instanceof UnmodifiableSetMultimap || setMultimap instanceof ImmutableSetMultimap) {
            return setMultimap;
        }
        return new UnmodifiableSetMultimap<K, V>(setMultimap);
    }
    
    public static <K, V> SortedSetMultimap<K, V> unmodifiableSortedSetMultimap(final SortedSetMultimap<K, V> sortedSetMultimap) {
        if (sortedSetMultimap instanceof UnmodifiableSortedSetMultimap) {
            return sortedSetMultimap;
        }
        return new UnmodifiableSortedSetMultimap<K, V>(sortedSetMultimap);
    }
    
    private static <V> Collection<V> unmodifiableValueCollection(final Collection<V> c) {
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
    
    static final class AsMap<K, V> extends ImprovedAbstractMap<K, Collection<V>>
    {
        private final Multimap<K, V> multimap;
        
        AsMap(final Multimap<K, V> multimap) {
            this.multimap = Preconditions.checkNotNull(multimap);
        }
        
        @Override
        public void clear() {
            this.multimap.clear();
        }
        
        @Override
        public boolean containsKey(final Object o) {
            return this.multimap.containsKey(o);
        }
        
        protected Set<Entry<K, Collection<V>>> createEntrySet() {
            return (Set<Entry<K, Collection<V>>>)new EntrySet();
        }
        
        @Override
        public Collection<V> get(final Object o) {
            if (this.containsKey(o)) {
                return this.multimap.get((K)o);
            }
            return null;
        }
        
        @Override
        public boolean isEmpty() {
            return this.multimap.isEmpty();
        }
        
        @Override
        public Set<K> keySet() {
            return this.multimap.keySet();
        }
        
        @Override
        public Collection<V> remove(final Object o) {
            if (this.containsKey(o)) {
                return this.multimap.removeAll(o);
            }
            return null;
        }
        
        void removeValuesForKey(final Object o) {
            this.multimap.keySet().remove(o);
        }
        
        @Override
        public int size() {
            return this.multimap.keySet().size();
        }
        
        class EntrySet extends Maps.EntrySet<K, Collection<V>>
        {
            @Override
            public Iterator<Entry<K, Collection<V>>> iterator() {
                return Maps.asMapEntryIterator(AsMap.this.multimap.keySet(), (Function<? super K, Collection<V>>)new Function<K, Collection<V>>() {
                    @Override
                    public Collection<V> apply(final K k) {
                        return AsMap.this.multimap.get(k);
                    }
                });
            }
            
            @Override
            Map<K, Collection<V>> map() {
                return (Map<K, Collection<V>>)AsMap.this;
            }
            
            @Override
            public boolean remove(final Object o) {
                if (!((Maps.EntrySet)this).contains(o)) {
                    return false;
                }
                AsMap.this.removeValuesForKey(((Entry)o).getKey());
                return true;
            }
        }
    }
    
    private static class CustomListMultimap<K, V> extends AbstractListMultimap<K, V>
    {
        @GwtIncompatible("java serialization not supported")
        private static final long serialVersionUID = 0L;
        transient Supplier<? extends List<V>> factory;
        
        CustomListMultimap(final Map<K, Collection<V>> map, final Supplier<? extends List<V>> supplier) {
            super(map);
            this.factory = Preconditions.checkNotNull(supplier);
        }
        
        @GwtIncompatible("java.io.ObjectInputStream")
        private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.factory = (Supplier<? extends List<V>>)objectInputStream.readObject();
            this.setMap((Map<K, Collection<V>>)objectInputStream.readObject());
        }
        
        @GwtIncompatible("java.io.ObjectOutputStream")
        private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(this.backingMap());
        }
        
        protected List<V> createCollection() {
            return (List<V>)this.factory.get();
        }
    }
    
    private static class CustomMultimap<K, V> extends AbstractMapBasedMultimap<K, V>
    {
        @GwtIncompatible("java serialization not supported")
        private static final long serialVersionUID = 0L;
        transient Supplier<? extends Collection<V>> factory;
        
        CustomMultimap(final Map<K, Collection<V>> map, final Supplier<? extends Collection<V>> supplier) {
            super(map);
            this.factory = Preconditions.checkNotNull(supplier);
        }
        
        @GwtIncompatible("java.io.ObjectInputStream")
        private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.factory = (Supplier<? extends Collection<V>>)objectInputStream.readObject();
            this.setMap((Map<K, Collection<V>>)objectInputStream.readObject());
        }
        
        @GwtIncompatible("java.io.ObjectOutputStream")
        private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(this.backingMap());
        }
        
        protected Collection<V> createCollection() {
            return (Collection<V>)this.factory.get();
        }
    }
    
    private static class CustomSetMultimap<K, V> extends AbstractSetMultimap<K, V>
    {
        @GwtIncompatible("not needed in emulated source")
        private static final long serialVersionUID = 0L;
        transient Supplier<? extends Set<V>> factory;
        
        CustomSetMultimap(final Map<K, Collection<V>> map, final Supplier<? extends Set<V>> supplier) {
            super(map);
            this.factory = Preconditions.checkNotNull(supplier);
        }
        
        @GwtIncompatible("java.io.ObjectInputStream")
        private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.factory = (Supplier<? extends Set<V>>)objectInputStream.readObject();
            this.setMap((Map<K, Collection<V>>)objectInputStream.readObject());
        }
        
        @GwtIncompatible("java.io.ObjectOutputStream")
        private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(this.backingMap());
        }
        
        protected Set<V> createCollection() {
            return (Set<V>)this.factory.get();
        }
    }
    
    private static class CustomSortedSetMultimap<K, V> extends AbstractSortedSetMultimap<K, V>
    {
        @GwtIncompatible("not needed in emulated source")
        private static final long serialVersionUID = 0L;
        transient Supplier<? extends SortedSet<V>> factory;
        transient Comparator<? super V> valueComparator;
        
        CustomSortedSetMultimap(final Map<K, Collection<V>> map, final Supplier<? extends SortedSet<V>> supplier) {
            super(map);
            this.factory = Preconditions.checkNotNull(supplier);
            this.valueComparator = (Comparator<? super V>)((SortedSet)supplier.get()).comparator();
        }
        
        @GwtIncompatible("java.io.ObjectInputStream")
        private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.factory = (Supplier<? extends SortedSet<V>>)objectInputStream.readObject();
            this.valueComparator = (Comparator<? super V>)((SortedSet)this.factory.get()).comparator();
            this.setMap((Map<K, Collection<V>>)objectInputStream.readObject());
        }
        
        @GwtIncompatible("java.io.ObjectOutputStream")
        private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(this.backingMap());
        }
        
        protected SortedSet<V> createCollection() {
            return (SortedSet<V>)this.factory.get();
        }
        
        @Override
        public Comparator<? super V> valueComparator() {
            return this.valueComparator;
        }
    }
    
    abstract static class Entries<K, V> extends AbstractCollection<Map.Entry<K, V>>
    {
        @Override
        public void clear() {
            this.multimap().clear();
        }
        
        @Override
        public boolean contains(@Nullable final Object o) {
            if (o instanceof Map.Entry) {
                final Map.Entry entry = (Map.Entry)o;
                return this.multimap().containsEntry(entry.getKey(), entry.getValue());
            }
            return false;
        }
        
        abstract Multimap<K, V> multimap();
        
        @Override
        public boolean remove(@Nullable final Object o) {
            if (o instanceof Map.Entry) {
                final Map.Entry entry = (Map.Entry)o;
                return this.multimap().remove(entry.getKey(), entry.getValue());
            }
            return false;
        }
        
        @Override
        public int size() {
            return this.multimap().size();
        }
    }
    
    static class Keys<K, V> extends AbstractMultiset<K>
    {
        final Multimap<K, V> multimap;
        
        Keys(final Multimap<K, V> multimap) {
            this.multimap = multimap;
        }
        
        @Override
        public void clear() {
            this.multimap.clear();
        }
        
        @Override
        public boolean contains(@Nullable final Object o) {
            return this.multimap.containsKey(o);
        }
        
        @Override
        public int count(@Nullable final Object o) {
            final Collection<V> collection = Maps.safeGet(this.multimap.asMap(), o);
            if (collection == null) {
                return 0;
            }
            return collection.size();
        }
        
        @Override
        Set<Entry<K>> createEntrySet() {
            return (Set<Entry<K>>)new KeysEntrySet();
        }
        
        @Override
        int distinctElements() {
            return this.multimap.asMap().size();
        }
        
        @Override
        public Set<K> elementSet() {
            return this.multimap.keySet();
        }
        
        @Override
        Iterator<Entry<K>> entryIterator() {
            return new TransformedIterator<Map.Entry<K, Collection<V>>, Entry<K>>(this.multimap.asMap().entrySet().iterator()) {
                @Override
                Entry<K> transform(final Map.Entry<K, Collection<V>> entry) {
                    return new Multisets.AbstractEntry<K>() {
                        @Override
                        public int getCount() {
                            return entry.getValue().size();
                        }
                        
                        @Override
                        public K getElement() {
                            return entry.getKey();
                        }
                    };
                }
            };
        }
        
        @Override
        public Iterator<K> iterator() {
            return Maps.keyIterator(this.multimap.entries().iterator());
        }
        
        @Override
        public int remove(@Nullable final Object o, final int n) {
            CollectPreconditions.checkNonnegative(n, "occurrences");
            int count;
            if (n == 0) {
                count = this.count(o);
            }
            else {
                final Collection<V> collection = Maps.safeGet(this.multimap.asMap(), o);
                if (collection == null) {
                    return 0;
                }
                final int size = collection.size();
                if (n >= size) {
                    collection.clear();
                    return size;
                }
                final Iterator<V> iterator = collection.iterator();
                int n2 = 0;
                while (true) {
                    count = size;
                    if (n2 >= n) {
                        break;
                    }
                    iterator.next();
                    iterator.remove();
                    ++n2;
                }
            }
            return count;
        }
        
        class KeysEntrySet extends Multisets.EntrySet<K>
        {
            @Override
            public boolean contains(@Nullable final Object o) {
                boolean b2;
                final boolean b = b2 = false;
                if (o instanceof Entry) {
                    final Entry entry = (Entry)o;
                    final Collection<V> collection = Keys.this.multimap.asMap().get(entry.getElement());
                    b2 = b;
                    if (collection != null) {
                        b2 = b;
                        if (collection.size() == entry.getCount()) {
                            b2 = true;
                        }
                    }
                }
                return b2;
            }
            
            @Override
            public boolean isEmpty() {
                return Keys.this.multimap.isEmpty();
            }
            
            @Override
            public Iterator<Entry<K>> iterator() {
                return Keys.this.entryIterator();
            }
            
            @Override
            Multiset<K> multiset() {
                return (Multiset<K>)Keys.this;
            }
            
            @Override
            public boolean remove(@Nullable final Object o) {
                if (o instanceof Entry) {
                    final Entry entry = (Entry)o;
                    final Collection<V> collection = Keys.this.multimap.asMap().get(entry.getElement());
                    if (collection != null && collection.size() == entry.getCount()) {
                        collection.clear();
                        return true;
                    }
                }
                return false;
            }
            
            @Override
            public int size() {
                return Keys.this.distinctElements();
            }
        }
    }
    
    private static class MapMultimap<K, V> extends AbstractMultimap<K, V> implements SetMultimap<K, V>, Serializable
    {
        private static final long serialVersionUID = 7845222491160860175L;
        final Map<K, V> map;
        
        MapMultimap(final Map<K, V> map) {
            this.map = Preconditions.checkNotNull(map);
        }
        
        @Override
        public void clear() {
            this.map.clear();
        }
        
        @Override
        public boolean containsEntry(final Object o, final Object o2) {
            return this.map.entrySet().contains(Maps.immutableEntry(o, o2));
        }
        
        @Override
        public boolean containsKey(final Object o) {
            return this.map.containsKey(o);
        }
        
        @Override
        public boolean containsValue(final Object o) {
            return this.map.containsValue(o);
        }
        
        @Override
        Map<K, Collection<V>> createAsMap() {
            return (Map<K, Collection<V>>)new AsMap((Multimap<Object, Object>)this);
        }
        
        @Override
        public Set<Map.Entry<K, V>> entries() {
            return this.map.entrySet();
        }
        
        @Override
        Iterator<Map.Entry<K, V>> entryIterator() {
            return this.map.entrySet().iterator();
        }
        
        @Override
        public Set<V> get(final K k) {
            return new Sets.ImprovedAbstractSet<V>() {
                @Override
                public Iterator<V> iterator() {
                    return new Iterator<V>() {
                        int i;
                        
                        @Override
                        public boolean hasNext() {
                            return this.i == 0 && MapMultimap.this.map.containsKey(k);
                        }
                        
                        @Override
                        public V next() {
                            if (!this.hasNext()) {
                                throw new NoSuchElementException();
                            }
                            ++this.i;
                            return MapMultimap.this.map.get(k);
                        }
                        
                        @Override
                        public void remove() {
                            boolean b = true;
                            if (this.i != 1) {
                                b = false;
                            }
                            CollectPreconditions.checkRemove(b);
                            this.i = -1;
                            MapMultimap.this.map.remove(k);
                        }
                    };
                }
                
                @Override
                public int size() {
                    if (MapMultimap.this.map.containsKey(k)) {
                        return 1;
                    }
                    return 0;
                }
            };
        }
        
        @Override
        public int hashCode() {
            return this.map.hashCode();
        }
        
        @Override
        public Set<K> keySet() {
            return this.map.keySet();
        }
        
        @Override
        public boolean put(final K k, final V v) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean putAll(final Multimap<? extends K, ? extends V> multimap) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean putAll(final K k, final Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean remove(final Object o, final Object o2) {
            return this.map.entrySet().remove(Maps.immutableEntry(o, o2));
        }
        
        @Override
        public Set<V> removeAll(final Object o) {
            final HashSet<V> set = new HashSet<V>(2);
            if (!this.map.containsKey(o)) {
                return set;
            }
            set.add(this.map.remove(o));
            return set;
        }
        
        @Override
        public Set<V> replaceValues(final K k, final Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public int size() {
            return this.map.size();
        }
        
        @Override
        public Collection<V> values() {
            return this.map.values();
        }
    }
    
    private static final class TransformedEntriesListMultimap<K, V1, V2> extends TransformedEntriesMultimap<K, V1, V2> implements ListMultimap<K, V2>
    {
        TransformedEntriesListMultimap(final ListMultimap<K, V1> listMultimap, final Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            super(listMultimap, entryTransformer);
        }
        
        @Override
        public List<V2> get(final K k) {
            return this.transform(k, this.fromMultimap.get(k));
        }
        
        @Override
        public List<V2> removeAll(final Object o) {
            return this.transform(o, this.fromMultimap.removeAll(o));
        }
        
        @Override
        public List<V2> replaceValues(final K k, final Iterable<? extends V2> iterable) {
            throw new UnsupportedOperationException();
        }
        
        List<V2> transform(final K k, final Collection<V1> collection) {
            return Lists.transform((List<Object>)collection, (Function<? super Object, ? extends V2>)Maps.asValueToValueFunction((Maps.EntryTransformer<? super K, ? super F, ? extends T>)this.transformer, k));
        }
    }
    
    private static class TransformedEntriesMultimap<K, V1, V2> extends AbstractMultimap<K, V2>
    {
        final Multimap<K, V1> fromMultimap;
        final Maps.EntryTransformer<? super K, ? super V1, V2> transformer;
        
        TransformedEntriesMultimap(final Multimap<K, V1> multimap, final Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            this.fromMultimap = Preconditions.checkNotNull(multimap);
            this.transformer = (Maps.EntryTransformer<? super K, ? super V1, V2>)Preconditions.checkNotNull((Maps.EntryTransformer)entryTransformer);
        }
        
        @Override
        public void clear() {
            this.fromMultimap.clear();
        }
        
        @Override
        public boolean containsKey(final Object o) {
            return this.fromMultimap.containsKey(o);
        }
        
        @Override
        Map<K, Collection<V2>> createAsMap() {
            return Maps.transformEntries(this.fromMultimap.asMap(), (Maps.EntryTransformer<? super K, ? super Collection<V1>, Collection<V2>>)new Maps.EntryTransformer<K, Collection<V1>, Collection<V2>>() {
                public Collection<V2> transformEntry(final K k, final Collection<V1> collection) {
                    return TransformedEntriesMultimap.this.transform(k, collection);
                }
            });
        }
        
        @Override
        Collection<V2> createValues() {
            return Collections2.transform(this.fromMultimap.entries(), (Function<? super Map.Entry<K, V1>, V2>)Maps.asEntryToValueFunction((Maps.EntryTransformer<? super Object, ? super Object, T>)this.transformer));
        }
        
        @Override
        Iterator<Map.Entry<K, V2>> entryIterator() {
            return Iterators.transform(this.fromMultimap.entries().iterator(), (Function<? super Map.Entry<K, V1>, ? extends Map.Entry<K, V2>>)Maps.asEntryToEntryFunction((Maps.EntryTransformer<? super Object, ? super Object, V2>)this.transformer));
        }
        
        @Override
        public Collection<V2> get(final K k) {
            return this.transform(k, this.fromMultimap.get(k));
        }
        
        @Override
        public boolean isEmpty() {
            return this.fromMultimap.isEmpty();
        }
        
        @Override
        public Set<K> keySet() {
            return this.fromMultimap.keySet();
        }
        
        @Override
        public Multiset<K> keys() {
            return this.fromMultimap.keys();
        }
        
        @Override
        public boolean put(final K k, final V2 v2) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean putAll(final Multimap<? extends K, ? extends V2> multimap) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean putAll(final K k, final Iterable<? extends V2> iterable) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean remove(final Object o, final Object o2) {
            return this.get(o).remove(o2);
        }
        
        @Override
        public Collection<V2> removeAll(final Object o) {
            return this.transform(o, this.fromMultimap.removeAll(o));
        }
        
        @Override
        public Collection<V2> replaceValues(final K k, final Iterable<? extends V2> iterable) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public int size() {
            return this.fromMultimap.size();
        }
        
        Collection<V2> transform(final K k, final Collection<V1> collection) {
            final Function<? super V1, V2> valueToValueFunction = Maps.asValueToValueFunction(this.transformer, k);
            if (collection instanceof List) {
                return (Collection<V2>)Lists.transform((List<Object>)collection, (Function<? super Object, ?>)valueToValueFunction);
            }
            return Collections2.transform((Collection<F>)collection, (Function<? super F, V2>)valueToValueFunction);
        }
    }
    
    private static class UnmodifiableListMultimap<K, V> extends UnmodifiableMultimap<K, V> implements ListMultimap<K, V>
    {
        private static final long serialVersionUID = 0L;
        
        UnmodifiableListMultimap(final ListMultimap<K, V> listMultimap) {
            super(listMultimap);
        }
        
        public ListMultimap<K, V> delegate() {
            return (ListMultimap<K, V>)(ListMultimap)super.delegate();
        }
        
        @Override
        public List<V> get(final K k) {
            return Collections.unmodifiableList((List<? extends V>)this.delegate().get(k));
        }
        
        @Override
        public List<V> removeAll(final Object o) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public List<V> replaceValues(final K k, final Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }
    }
    
    private static class UnmodifiableMultimap<K, V> extends ForwardingMultimap<K, V> implements Serializable
    {
        private static final long serialVersionUID = 0L;
        final Multimap<K, V> delegate;
        transient Collection<Map.Entry<K, V>> entries;
        transient Set<K> keySet;
        transient Multiset<K> keys;
        transient Map<K, Collection<V>> map;
        transient Collection<V> values;
        
        UnmodifiableMultimap(final Multimap<K, V> multimap) {
            this.delegate = Preconditions.checkNotNull(multimap);
        }
        
        @Override
        public Map<K, Collection<V>> asMap() {
            Map<K, Collection<V>> map;
            if ((map = this.map) == null) {
                map = Collections.unmodifiableMap((Map<? extends K, ? extends Collection<V>>)Maps.transformValues((Map<? extends K, Collection<V>>)this.delegate.asMap(), (Function<? super Collection<V>, ? extends V>)new Function<Collection<V>, Collection<V>>() {
                    @Override
                    public Collection<V> apply(final Collection<V> collection) {
                        return (Collection<V>)unmodifiableValueCollection((Collection<Object>)collection);
                    }
                }));
                this.map = map;
            }
            return map;
        }
        
        @Override
        public void clear() {
            throw new UnsupportedOperationException();
        }
        
        @Override
        protected Multimap<K, V> delegate() {
            return this.delegate;
        }
        
        @Override
        public Collection<Map.Entry<K, V>> entries() {
            Collection<Map.Entry<K, V>> entries;
            if ((entries = this.entries) == null) {
                entries = (Collection<Map.Entry<K, V>>)unmodifiableEntries((Collection<Map.Entry<Object, Object>>)this.delegate.entries());
                this.entries = entries;
            }
            return entries;
        }
        
        @Override
        public Collection<V> get(final K k) {
            return (Collection<V>)unmodifiableValueCollection((Collection<Object>)this.delegate.get(k));
        }
        
        @Override
        public Set<K> keySet() {
            Set<K> keySet;
            if ((keySet = this.keySet) == null) {
                keySet = Collections.unmodifiableSet((Set<? extends K>)this.delegate.keySet());
                this.keySet = keySet;
            }
            return keySet;
        }
        
        @Override
        public Multiset<K> keys() {
            Multiset<K> keys;
            if ((keys = this.keys) == null) {
                keys = Multisets.unmodifiableMultiset((Multiset<? extends K>)this.delegate.keys());
                this.keys = keys;
            }
            return keys;
        }
        
        @Override
        public boolean put(final K k, final V v) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean putAll(final Multimap<? extends K, ? extends V> multimap) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean putAll(final K k, final Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean remove(final Object o, final Object o2) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public Collection<V> removeAll(final Object o) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public Collection<V> replaceValues(final K k, final Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public Collection<V> values() {
            Collection<V> values;
            if ((values = this.values) == null) {
                values = Collections.unmodifiableCollection((Collection<? extends V>)this.delegate.values());
                this.values = values;
            }
            return values;
        }
    }
    
    private static class UnmodifiableSetMultimap<K, V> extends UnmodifiableMultimap<K, V> implements SetMultimap<K, V>
    {
        private static final long serialVersionUID = 0L;
        
        UnmodifiableSetMultimap(final SetMultimap<K, V> setMultimap) {
            super(setMultimap);
        }
        
        public SetMultimap<K, V> delegate() {
            return (SetMultimap<K, V>)(SetMultimap)super.delegate();
        }
        
        @Override
        public Set<Map.Entry<K, V>> entries() {
            return Maps.unmodifiableEntrySet(this.delegate().entries());
        }
        
        @Override
        public Set<V> get(final K k) {
            return Collections.unmodifiableSet((Set<? extends V>)this.delegate().get(k));
        }
        
        @Override
        public Set<V> removeAll(final Object o) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public Set<V> replaceValues(final K k, final Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }
    }
    
    private static class UnmodifiableSortedSetMultimap<K, V> extends UnmodifiableSetMultimap<K, V> implements SortedSetMultimap<K, V>
    {
        private static final long serialVersionUID = 0L;
        
        UnmodifiableSortedSetMultimap(final SortedSetMultimap<K, V> sortedSetMultimap) {
            super(sortedSetMultimap);
        }
        
        public SortedSetMultimap<K, V> delegate() {
            return (SortedSetMultimap<K, V>)(SortedSetMultimap)super.delegate();
        }
        
        @Override
        public SortedSet<V> get(final K k) {
            return Collections.unmodifiableSortedSet(this.delegate().get(k));
        }
        
        @Override
        public SortedSet<V> removeAll(final Object o) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public SortedSet<V> replaceValues(final K k, final Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public Comparator<? super V> valueComparator() {
            return this.delegate().valueComparator();
        }
    }
}
