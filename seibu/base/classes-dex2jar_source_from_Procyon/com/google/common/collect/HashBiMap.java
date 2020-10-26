// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Collection;
import java.util.Set;
import java.util.Arrays;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import com.google.common.base.Objects;
import javax.annotation.Nullable;
import java.util.Map;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.AbstractMap;

@GwtCompatible(emulated = true)
public final class HashBiMap<K, V> extends AbstractMap<K, V> implements BiMap<K, V>, Serializable
{
    private static final double LOAD_FACTOR = 1.0;
    @GwtIncompatible("Not needed in emulated source")
    private static final long serialVersionUID = 0L;
    private transient BiEntry<K, V>[] hashTableKToV;
    private transient BiEntry<K, V>[] hashTableVToK;
    private transient BiMap<V, K> inverse;
    private transient int mask;
    private transient int modCount;
    private transient int size;
    
    private HashBiMap(final int n) {
        this.init(n);
    }
    
    public static <K, V> HashBiMap<K, V> create() {
        return create(16);
    }
    
    public static <K, V> HashBiMap<K, V> create(final int n) {
        return new HashBiMap<K, V>(n);
    }
    
    public static <K, V> HashBiMap<K, V> create(final Map<? extends K, ? extends V> m) {
        final HashBiMap<Object, Object> create = create(m.size());
        create.putAll(m);
        return (HashBiMap<K, V>)create;
    }
    
    private BiEntry<K, V>[] createTable(final int n) {
        return (BiEntry<K, V>[])new BiEntry[n];
    }
    
    private void delete(final BiEntry<K, V> biEntry) {
        final int n = biEntry.keyHash & this.mask;
        BiEntry<K, V> biEntry2 = null;
        for (BiEntry<K, V> nextInKToVBucket = this.hashTableKToV[n]; nextInKToVBucket != biEntry; nextInKToVBucket = nextInKToVBucket.nextInKToVBucket) {
            biEntry2 = nextInKToVBucket;
        }
        if (biEntry2 == null) {
            this.hashTableKToV[n] = biEntry.nextInKToVBucket;
        }
        else {
            biEntry2.nextInKToVBucket = biEntry.nextInKToVBucket;
        }
        final int n2 = biEntry.valueHash & this.mask;
        BiEntry<K, V> biEntry3 = null;
        for (BiEntry<K, V> nextInVToKBucket = this.hashTableVToK[n2]; nextInVToKBucket != biEntry; nextInVToKBucket = nextInVToKBucket.nextInVToKBucket) {
            biEntry3 = nextInVToKBucket;
        }
        if (biEntry3 == null) {
            this.hashTableVToK[n2] = biEntry.nextInVToKBucket;
        }
        else {
            biEntry3.nextInVToKBucket = biEntry.nextInVToKBucket;
        }
        --this.size;
        ++this.modCount;
    }
    
    private static int hash(@Nullable final Object o) {
        int hashCode;
        if (o == null) {
            hashCode = 0;
        }
        else {
            hashCode = o.hashCode();
        }
        return Hashing.smear(hashCode);
    }
    
    private void init(int closedTableSize) {
        CollectPreconditions.checkNonnegative(closedTableSize, "expectedSize");
        closedTableSize = Hashing.closedTableSize(closedTableSize, 1.0);
        this.hashTableKToV = this.createTable(closedTableSize);
        this.hashTableVToK = this.createTable(closedTableSize);
        this.mask = closedTableSize - 1;
        this.modCount = 0;
        this.size = 0;
    }
    
    private void insert(final BiEntry<K, V> biEntry) {
        final int n = biEntry.keyHash & this.mask;
        biEntry.nextInKToVBucket = this.hashTableKToV[n];
        this.hashTableKToV[n] = biEntry;
        final int n2 = biEntry.valueHash & this.mask;
        biEntry.nextInVToKBucket = this.hashTableVToK[n2];
        this.hashTableVToK[n2] = biEntry;
        ++this.size;
        ++this.modCount;
    }
    
    private V put(@Nullable final K k, @Nullable final V obj, final boolean b) {
        final int hash = hash(k);
        final int hash2 = hash(obj);
        final BiEntry<K, V> seekByKey = this.seekByKey(k, hash);
        if (seekByKey != null && hash2 == seekByKey.valueHash && Objects.equal(obj, seekByKey.value)) {
            return obj;
        }
        final BiEntry<K, V> seekByValue = this.seekByValue(obj, hash2);
        if (seekByValue != null) {
            if (!b) {
                final String value = String.valueOf(String.valueOf(obj));
                throw new IllegalArgumentException(new StringBuilder(value.length() + 23).append("value already present: ").append(value).toString());
            }
            this.delete(seekByValue);
        }
        if (seekByKey != null) {
            this.delete(seekByKey);
        }
        this.insert(new BiEntry<K, V>(k, hash, obj, hash2));
        this.rehashIfNecessary();
        V value2;
        if (seekByKey == null) {
            value2 = null;
        }
        else {
            value2 = seekByKey.value;
        }
        return value2;
    }
    
    @Nullable
    private K putInverse(@Nullable final V v, @Nullable final K obj, final boolean b) {
        final int hash = hash(v);
        final int hash2 = hash(obj);
        final BiEntry<K, V> seekByValue = this.seekByValue(v, hash);
        if (seekByValue != null && hash2 == seekByValue.keyHash && Objects.equal(obj, seekByValue.key)) {
            return obj;
        }
        final BiEntry<K, V> seekByKey = this.seekByKey(obj, hash2);
        if (seekByKey != null) {
            if (!b) {
                final String value = String.valueOf(String.valueOf(obj));
                throw new IllegalArgumentException(new StringBuilder(value.length() + 23).append("value already present: ").append(value).toString());
            }
            this.delete(seekByKey);
        }
        if (seekByValue != null) {
            this.delete(seekByValue);
        }
        this.insert(new BiEntry<K, V>(obj, hash2, v, hash));
        this.rehashIfNecessary();
        K key;
        if (seekByValue == null) {
            key = null;
        }
        else {
            key = seekByValue.key;
        }
        return key;
    }
    
    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        final int count = Serialization.readCount(objectInputStream);
        this.init(count);
        Serialization.populateMap((Map<Object, Object>)this, objectInputStream, count);
    }
    
    private void rehashIfNecessary() {
        final BiEntry<K, V>[] hashTableKToV = this.hashTableKToV;
        if (Hashing.needsResizing(this.size, hashTableKToV.length, 1.0)) {
            final int n = hashTableKToV.length * 2;
            this.hashTableKToV = this.createTable(n);
            this.hashTableVToK = this.createTable(n);
            this.mask = n - 1;
            this.size = 0;
            for (int i = 0; i < hashTableKToV.length; ++i) {
                BiEntry<K, V> nextInKToVBucket;
                for (BiEntry<K, V> biEntry = hashTableKToV[i]; biEntry != null; biEntry = nextInKToVBucket) {
                    nextInKToVBucket = biEntry.nextInKToVBucket;
                    this.insert(biEntry);
                }
            }
            ++this.modCount;
        }
    }
    
    private BiEntry<K, V> seekByKey(@Nullable final Object o, final int n) {
        for (BiEntry<K, V> nextInKToVBucket = this.hashTableKToV[this.mask & n]; nextInKToVBucket != null; nextInKToVBucket = nextInKToVBucket.nextInKToVBucket) {
            if (n == nextInKToVBucket.keyHash && Objects.equal(o, nextInKToVBucket.key)) {
                return nextInKToVBucket;
            }
        }
        return null;
    }
    
    private BiEntry<K, V> seekByValue(@Nullable final Object o, final int n) {
        for (BiEntry<K, V> nextInVToKBucket = this.hashTableVToK[this.mask & n]; nextInVToKBucket != null; nextInVToKBucket = nextInVToKBucket.nextInVToKBucket) {
            if (n == nextInVToKBucket.valueHash && Objects.equal(o, nextInVToKBucket.value)) {
                return nextInVToKBucket;
            }
        }
        return null;
    }
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMap((Map<Object, Object>)this, objectOutputStream);
    }
    
    @Override
    public void clear() {
        this.size = 0;
        Arrays.fill(this.hashTableKToV, null);
        Arrays.fill(this.hashTableVToK, null);
        ++this.modCount;
    }
    
    @Override
    public boolean containsKey(@Nullable final Object o) {
        return this.seekByKey(o, hash(o)) != null;
    }
    
    @Override
    public boolean containsValue(@Nullable final Object o) {
        return this.seekByValue(o, hash(o)) != null;
    }
    
    @Override
    public Set<Entry<K, V>> entrySet() {
        return (Set<Entry<K, V>>)new EntrySet();
    }
    
    @Override
    public V forcePut(@Nullable final K k, @Nullable final V v) {
        return this.put(k, v, true);
    }
    
    @Nullable
    @Override
    public V get(@Nullable final Object o) {
        final BiEntry<K, V> seekByKey = this.seekByKey(o, hash(o));
        if (seekByKey == null) {
            return null;
        }
        return seekByKey.value;
    }
    
    @Override
    public BiMap<V, K> inverse() {
        if (this.inverse == null) {
            return this.inverse = new Inverse();
        }
        return this.inverse;
    }
    
    @Override
    public Set<K> keySet() {
        return (Set<K>)new KeySet();
    }
    
    @Override
    public V put(@Nullable final K k, @Nullable final V v) {
        return this.put(k, v, false);
    }
    
    @Override
    public V remove(@Nullable final Object o) {
        final BiEntry<K, V> seekByKey = this.seekByKey(o, hash(o));
        if (seekByKey == null) {
            return null;
        }
        this.delete(seekByKey);
        return seekByKey.value;
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    @Override
    public Set<V> values() {
        return this.inverse().keySet();
    }
    
    private static final class BiEntry<K, V> extends ImmutableEntry<K, V>
    {
        final int keyHash;
        @Nullable
        BiEntry<K, V> nextInKToVBucket;
        @Nullable
        BiEntry<K, V> nextInVToKBucket;
        final int valueHash;
        
        BiEntry(final K k, final int keyHash, final V v, final int valueHash) {
            super(k, v);
            this.keyHash = keyHash;
            this.valueHash = valueHash;
        }
    }
    
    private final class EntrySet extends Maps.EntrySet<K, V>
    {
        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new Itr<Entry<K, V>>() {
                Entry<K, V> output(final BiEntry<K, V> biEntry) {
                    return new MapEntry(biEntry);
                }
                
                class MapEntry extends AbstractMapEntry<K, V>
                {
                    BiEntry<K, V> delegate;
                    
                    MapEntry(final BiEntry<K, V> delegate) {
                        this.delegate = delegate;
                    }
                    
                    @Override
                    public K getKey() {
                        return this.delegate.key;
                    }
                    
                    @Override
                    public V getValue() {
                        return this.delegate.value;
                    }
                    
                    @Override
                    public V setValue(final V v) {
                        final V value = this.delegate.value;
                        final int access$300 = hash(v);
                        if (access$300 == this.delegate.valueHash && Objects.equal(v, value)) {
                            return v;
                        }
                        Preconditions.checkArgument(HashBiMap.this.seekByValue(v, access$300) == null, "value already present: %s", v);
                        HashBiMap.this.delete((BiEntry)this.delegate);
                        final BiEntry biEntry = new BiEntry(this.delegate.key, this.delegate.keyHash, v, access$300);
                        HashBiMap.this.insert(biEntry);
                        Itr.this.expectedModCount = HashBiMap.this.modCount;
                        if (Itr.this.toRemove == this.delegate) {
                            Itr.this.toRemove = (BiEntry<K, V>)biEntry;
                        }
                        this.delegate = (BiEntry<K, V>)biEntry;
                        return value;
                    }
                }
            };
        }
        
        @Override
        Map<K, V> map() {
            return (Map<K, V>)HashBiMap.this;
        }
    }
    
    private final class Inverse extends AbstractMap<V, K> implements BiMap<V, K>, Serializable
    {
        @Override
        public void clear() {
            this.forward().clear();
        }
        
        @Override
        public boolean containsKey(@Nullable final Object o) {
            return this.forward().containsValue(o);
        }
        
        @Override
        public Set<Entry<V, K>> entrySet() {
            return (Set<Entry<V, K>>)new Maps.EntrySet<V, K>() {
                @Override
                public Iterator<Entry<V, K>> iterator() {
                    return new Itr<Entry<V, K>>() {
                        Entry<V, K> output(final BiEntry<K, V> biEntry) {
                            return new InverseEntry(biEntry);
                        }
                        
                        class InverseEntry extends AbstractMapEntry<V, K>
                        {
                            BiEntry<K, V> delegate;
                            
                            InverseEntry(final BiEntry<K, V> delegate) {
                                this.delegate = delegate;
                            }
                            
                            @Override
                            public V getKey() {
                                return this.delegate.value;
                            }
                            
                            @Override
                            public K getValue() {
                                return this.delegate.key;
                            }
                            
                            @Override
                            public K setValue(final K k) {
                                final K key = this.delegate.key;
                                final int access$300 = hash(k);
                                if (access$300 == this.delegate.keyHash && Objects.equal(k, key)) {
                                    return k;
                                }
                                Preconditions.checkArgument(HashBiMap.this.seekByKey(k, access$300) == null, "value already present: %s", k);
                                HashBiMap.this.delete((BiEntry)this.delegate);
                                HashBiMap.this.insert(new BiEntry(k, access$300, this.delegate.value, this.delegate.valueHash));
                                Itr.this.expectedModCount = HashBiMap.this.modCount;
                                return key;
                            }
                        }
                    };
                }
                
                @Override
                Map<V, K> map() {
                    return Inverse.this;
                }
            };
        }
        
        @Override
        public K forcePut(@Nullable final V v, @Nullable final K k) {
            return (K)HashBiMap.this.putInverse(v, k, true);
        }
        
        BiMap<K, V> forward() {
            return (BiMap<K, V>)HashBiMap.this;
        }
        
        @Override
        public K get(@Nullable final Object o) {
            final BiEntry access$600 = HashBiMap.this.seekByValue(o, hash(o));
            if (access$600 == null) {
                return null;
            }
            return (K)access$600.key;
        }
        
        @Override
        public BiMap<K, V> inverse() {
            return this.forward();
        }
        
        @Override
        public Set<V> keySet() {
            return (Set<V>)new InverseKeySet();
        }
        
        @Override
        public K put(@Nullable final V v, @Nullable final K k) {
            return (K)HashBiMap.this.putInverse(v, k, false);
        }
        
        @Override
        public K remove(@Nullable final Object o) {
            final BiEntry access$600 = HashBiMap.this.seekByValue(o, hash(o));
            if (access$600 == null) {
                return null;
            }
            HashBiMap.this.delete(access$600);
            return (K)access$600.key;
        }
        
        @Override
        public int size() {
            return HashBiMap.this.size;
        }
        
        @Override
        public Set<K> values() {
            return this.forward().keySet();
        }
        
        Object writeReplace() {
            return new InverseSerializedForm(HashBiMap.this);
        }
        
        private final class InverseKeySet extends Maps.KeySet<V, K>
        {
            InverseKeySet() {
                super(Inverse.this);
            }
            
            @Override
            public Iterator<V> iterator() {
                return new Itr<V>() {
                    @Override
                    V output(final BiEntry<K, V> biEntry) {
                        return biEntry.value;
                    }
                };
            }
            
            @Override
            public boolean remove(@Nullable final Object o) {
                final BiEntry access$600 = HashBiMap.this.seekByValue(o, hash(o));
                if (access$600 == null) {
                    return false;
                }
                HashBiMap.this.delete(access$600);
                return true;
            }
        }
    }
    
    private static final class InverseSerializedForm<K, V> implements Serializable
    {
        private final HashBiMap<K, V> bimap;
        
        InverseSerializedForm(final HashBiMap<K, V> bimap) {
            this.bimap = bimap;
        }
        
        Object readResolve() {
            return this.bimap.inverse();
        }
    }
    
    abstract class Itr<T> implements Iterator<T>
    {
        int expectedModCount;
        BiEntry<K, V> next;
        int nextBucket;
        BiEntry<K, V> toRemove;
        
        Itr() {
            this.nextBucket = 0;
            this.next = null;
            this.toRemove = null;
            this.expectedModCount = HashBiMap.this.modCount;
        }
        
        private void checkForConcurrentModification() {
            if (HashBiMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
        
        @Override
        public boolean hasNext() {
            this.checkForConcurrentModification();
            if (this.next != null) {
                return true;
            }
            while (this.nextBucket < HashBiMap.this.hashTableKToV.length) {
                if (HashBiMap.this.hashTableKToV[this.nextBucket] != null) {
                    this.next = HashBiMap.this.hashTableKToV[this.nextBucket++];
                    return true;
                }
                ++this.nextBucket;
            }
            return false;
        }
        
        @Override
        public T next() {
            this.checkForConcurrentModification();
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            final BiEntry<K, V> next = this.next;
            this.next = next.nextInKToVBucket;
            this.toRemove = next;
            return this.output(next);
        }
        
        abstract T output(final BiEntry<K, V> p0);
        
        @Override
        public void remove() {
            this.checkForConcurrentModification();
            CollectPreconditions.checkRemove(this.toRemove != null);
            HashBiMap.this.delete((BiEntry)this.toRemove);
            this.expectedModCount = HashBiMap.this.modCount;
            this.toRemove = null;
        }
    }
    
    private final class KeySet extends Maps.KeySet<K, V>
    {
        KeySet() {
            super(HashBiMap.this);
        }
        
        @Override
        public Iterator<K> iterator() {
            return new Itr<K>() {
                @Override
                K output(final BiEntry<K, V> biEntry) {
                    return biEntry.key;
                }
            };
        }
        
        @Override
        public boolean remove(@Nullable final Object o) {
            final BiEntry access$400 = HashBiMap.this.seekByKey(o, hash(o));
            if (access$400 == null) {
                return false;
            }
            HashBiMap.this.delete(access$400);
            return true;
        }
    }
}
