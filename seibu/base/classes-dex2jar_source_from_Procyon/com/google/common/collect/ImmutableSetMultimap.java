// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import com.google.common.base.MoreObjects;
import java.util.Set;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Iterator;
import java.util.Collection;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.Map;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true, serializable = true)
public class ImmutableSetMultimap<K, V> extends ImmutableMultimap<K, V> implements SetMultimap<K, V>
{
    @GwtIncompatible("not needed in emulated source.")
    private static final long serialVersionUID = 0L;
    private final transient ImmutableSet<V> emptySet;
    private transient ImmutableSet<Map.Entry<K, V>> entries;
    private transient ImmutableSetMultimap<V, K> inverse;
    
    ImmutableSetMultimap(final ImmutableMap<K, ImmutableSet<V>> immutableMap, final int n, @Nullable final Comparator<? super V> comparator) {
        super((ImmutableMap<K, ? extends ImmutableCollection<Object>>)immutableMap, n);
        this.emptySet = emptySet(comparator);
    }
    
    public static <K, V> Builder<K, V> builder() {
        return new Builder<K, V>();
    }
    
    public static <K, V> ImmutableSetMultimap<K, V> copyOf(final Multimap<? extends K, ? extends V> multimap) {
        return copyOf(multimap, (Comparator<? super V>)null);
    }
    
    private static <K, V> ImmutableSetMultimap<K, V> copyOf(final Multimap<? extends K, ? extends V> multimap, final Comparator<? super V> comparator) {
        Preconditions.checkNotNull(multimap);
        ImmutableSetMultimap<Object, Object> of = null;
        if (multimap.isEmpty() && comparator == null) {
            of = of();
        }
        else if (!(multimap instanceof ImmutableSetMultimap) || (of = (ImmutableSetMultimap<Object, Object>)multimap).isPartialView()) {
            final ImmutableMap.Builder<K, ImmutableSet<Object>> builder = ImmutableMap.builder();
            int n = 0;
            for (final Map.Entry<Object, Collection<Object>> entry : multimap.asMap().entrySet()) {
                final K key = entry.getKey();
                final ImmutableSet<Object> valueSet = valueSet((Comparator<? super Object>)comparator, (Collection<?>)entry.getValue());
                if (!valueSet.isEmpty()) {
                    builder.put(key, valueSet);
                    n += valueSet.size();
                }
            }
            return new ImmutableSetMultimap<K, V>((ImmutableMap<Object, ImmutableSet<Object>>)builder.build(), n, (Comparator<? super Object>)comparator);
        }
        return (ImmutableSetMultimap<K, V>)of;
    }
    
    private static <V> ImmutableSet<V> emptySet(@Nullable final Comparator<? super V> comparator) {
        if (comparator == null) {
            return ImmutableSet.of();
        }
        return (ImmutableSet<V>)ImmutableSortedSet.emptySet((Comparator<? super Object>)comparator);
    }
    
    private ImmutableSetMultimap<V, K> invert() {
        final Builder<V, K> builder = builder();
        for (final Map.Entry<K, Object> entry : this.entries()) {
            builder.put((V)entry.getValue(), entry.getKey());
        }
        final ImmutableSetMultimap<V, K> build = builder.build();
        build.inverse = (ImmutableSetMultimap<K, K>)this;
        return (ImmutableSetMultimap<V, K>)build;
    }
    
    public static <K, V> ImmutableSetMultimap<K, V> of() {
        return (ImmutableSetMultimap<K, V>)EmptyImmutableSetMultimap.INSTANCE;
    }
    
    public static <K, V> ImmutableSetMultimap<K, V> of(final K k, final V v) {
        final Builder<K, V> builder = builder();
        builder.put(k, v);
        return builder.build();
    }
    
    public static <K, V> ImmutableSetMultimap<K, V> of(final K k, final V v, final K i, final V v2) {
        final Builder<K, V> builder = builder();
        builder.put(k, v);
        builder.put(i, v2);
        return builder.build();
    }
    
    public static <K, V> ImmutableSetMultimap<K, V> of(final K k, final V v, final K i, final V v2, final K j, final V v3) {
        final Builder<K, V> builder = builder();
        builder.put(k, v);
        builder.put(i, v2);
        builder.put(j, v3);
        return builder.build();
    }
    
    public static <K, V> ImmutableSetMultimap<K, V> of(final K k, final V v, final K i, final V v2, final K j, final V v3, final K l, final V v4) {
        final Builder<K, V> builder = builder();
        builder.put(k, v);
        builder.put(i, v2);
        builder.put(j, v3);
        builder.put(l, v4);
        return builder.build();
    }
    
    public static <K, V> ImmutableSetMultimap<K, V> of(final K k, final V v, final K i, final V v2, final K j, final V v3, final K l, final V v4, final K m, final V v5) {
        final Builder<K, V> builder = builder();
        builder.put(k, v);
        builder.put(i, v2);
        builder.put(j, v3);
        builder.put(l, v4);
        builder.put(m, v5);
        return builder.build();
    }
    
    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(final ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        final Comparator comparator = (Comparator)objectInputStream.readObject();
        final int int1 = objectInputStream.readInt();
        if (int1 < 0) {
            throw new InvalidObjectException(new StringBuilder(29).append("Invalid key count ").append(int1).toString());
        }
        final ImmutableMap.Builder<Object, ImmutableSet> builder = (ImmutableMap.Builder<Object, ImmutableSet>)ImmutableMap.builder();
        int n = 0;
        for (int i = 0; i < int1; ++i) {
            final Object object = objectInputStream.readObject();
            final int int2 = objectInputStream.readInt();
            if (int2 <= 0) {
                throw new InvalidObjectException(new StringBuilder(31).append("Invalid value count ").append(int2).toString());
            }
            final Object[] a = new Object[int2];
            for (int j = 0; j < int2; ++j) {
                a[j] = objectInputStream.readObject();
            }
            final ImmutableSet<Object> valueSet = valueSet((Comparator<? super Object>)comparator, (Collection<?>)Arrays.asList(a));
            if (valueSet.size() != a.length) {
                final String value = String.valueOf(String.valueOf(object));
                throw new InvalidObjectException(new StringBuilder(value.length() + 40).append("Duplicate key-value pairs exist for key ").append(value).toString());
            }
            builder.put(object, valueSet);
            n += int2;
        }
        try {
            FieldSettersHolder.MAP_FIELD_SETTER.set(this, builder.build());
            FieldSettersHolder.SIZE_FIELD_SETTER.set(this, n);
            FieldSettersHolder.EMPTY_SET_FIELD_SETTER.set(this, emptySet(comparator));
        }
        catch (IllegalArgumentException cause) {
            throw (InvalidObjectException)new InvalidObjectException(cause.getMessage()).initCause(cause);
        }
    }
    
    private static <V> ImmutableSet<V> valueSet(@Nullable final Comparator<? super V> comparator, final Collection<? extends V> collection) {
        if (comparator == null) {
            return ImmutableSet.copyOf(collection);
        }
        return (ImmutableSet<V>)ImmutableSortedSet.copyOf((Comparator<? super Object>)comparator, (Collection<?>)collection);
    }
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.valueComparator());
        Serialization.writeMultimap((Multimap<Object, Object>)this, objectOutputStream);
    }
    
    @Override
    public ImmutableSet<Map.Entry<K, V>> entries() {
        ImmutableSet<Map.Entry<K, V>> entries;
        if ((entries = this.entries) == null) {
            entries = (ImmutableSet<Map.Entry<K, V>>)new EntrySet((ImmutableSetMultimap<Object, Object>)this);
            this.entries = entries;
        }
        return entries;
    }
    
    @Override
    public ImmutableSet<V> get(@Nullable final K k) {
        return MoreObjects.firstNonNull((ImmutableSet<V>)this.map.get(k), this.emptySet);
    }
    
    @Override
    public ImmutableSetMultimap<V, K> inverse() {
        ImmutableSetMultimap<V, K> inverse;
        if ((inverse = this.inverse) == null) {
            inverse = this.invert();
            this.inverse = inverse;
        }
        return inverse;
    }
    
    @Deprecated
    @Override
    public ImmutableSet<V> removeAll(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public ImmutableSet<V> replaceValues(final K k, final Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }
    
    @Nullable
    Comparator<? super V> valueComparator() {
        if (this.emptySet instanceof ImmutableSortedSet) {
            return (Comparator<? super V>)((ImmutableSortedSet)this.emptySet).comparator();
        }
        return null;
    }
    
    public static final class Builder<K, V> extends ImmutableMultimap.Builder<K, V>
    {
        public Builder() {
            this.builderMultimap = (Multimap<K, V>)new ImmutableSetMultimap.BuilderMultimap<Object, Object>();
        }
        
        public ImmutableSetMultimap<K, V> build() {
            if (this.keyComparator != null) {
                final ImmutableSetMultimap.BuilderMultimap<Object, Object> builderMultimap = new ImmutableSetMultimap.BuilderMultimap<Object, Object>();
                final ArrayList<Object> arrayList = Lists.newArrayList((Iterable<?>)this.builderMultimap.asMap().entrySet());
                Collections.sort(arrayList, (Comparator<? super Object>)Ordering.from(this.keyComparator).onKeys());
                for (final Map.Entry<Object, V> entry : arrayList) {
                    builderMultimap.putAll(entry.getKey(), (Iterable<?>)entry.getValue());
                }
                this.builderMultimap = (Multimap<K, V>)builderMultimap;
            }
            return (ImmutableSetMultimap<K, V>)copyOf((Multimap<?, ?>)this.builderMultimap, (Comparator<? super Object>)this.valueComparator);
        }
        
        public Builder<K, V> orderKeysBy(final Comparator<? super K> comparator) {
            this.keyComparator = (Comparator<? super K>)Preconditions.checkNotNull((Comparator<? super K>)comparator);
            return this;
        }
        
        public Builder<K, V> orderValuesBy(final Comparator<? super V> comparator) {
            super.orderValuesBy(comparator);
            return this;
        }
        
        public Builder<K, V> put(final K k, final V v) {
            this.builderMultimap.put(Preconditions.checkNotNull(k), Preconditions.checkNotNull(v));
            return this;
        }
        
        public Builder<K, V> put(final Map.Entry<? extends K, ? extends V> entry) {
            this.builderMultimap.put(Preconditions.checkNotNull((K)entry.getKey()), Preconditions.checkNotNull((V)entry.getValue()));
            return this;
        }
        
        public Builder<K, V> putAll(final Multimap<? extends K, ? extends V> multimap) {
            for (final Map.Entry<? extends K, Collection<? extends V>> entry : multimap.asMap().entrySet()) {
                this.putAll(entry.getKey(), entry.getValue());
            }
            return this;
        }
        
        public Builder<K, V> putAll(final K k, final Iterable<? extends V> iterable) {
            final Collection<V> value = this.builderMultimap.get(Preconditions.checkNotNull(k));
            final Iterator<? extends V> iterator = iterable.iterator();
            while (iterator.hasNext()) {
                value.add(Preconditions.checkNotNull((V)iterator.next()));
            }
            return this;
        }
        
        public Builder<K, V> putAll(final K k, final V... a) {
            return this.putAll(k, (Iterable<? extends V>)Arrays.asList(a));
        }
    }
    
    private static class BuilderMultimap<K, V> extends AbstractMapBasedMultimap<K, V>
    {
        private static final long serialVersionUID = 0L;
        
        BuilderMultimap() {
            super(new LinkedHashMap());
        }
        
        @Override
        Collection<V> createCollection() {
            return (Collection<V>)Sets.newLinkedHashSet();
        }
    }
    
    private static final class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>>
    {
        private final transient ImmutableSetMultimap<K, V> multimap;
        
        EntrySet(final ImmutableSetMultimap<K, V> multimap) {
            this.multimap = multimap;
        }
        
        @Override
        public boolean contains(@Nullable final Object o) {
            if (o instanceof Map.Entry) {
                final Map.Entry entry = (Map.Entry)o;
                return this.multimap.containsEntry(entry.getKey(), entry.getValue());
            }
            return false;
        }
        
        @Override
        boolean isPartialView() {
            return false;
        }
        
        @Override
        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return this.multimap.entryIterator();
        }
        
        @Override
        public int size() {
            return this.multimap.size();
        }
    }
}
