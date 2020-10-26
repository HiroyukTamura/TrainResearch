// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.Comparator;
import java.util.List;
import javax.annotation.Nullable;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Iterator;
import java.util.Collection;
import java.util.Map;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true, serializable = true)
public class ImmutableListMultimap<K, V> extends ImmutableMultimap<K, V> implements ListMultimap<K, V>
{
    @GwtIncompatible("Not needed in emulated source")
    private static final long serialVersionUID = 0L;
    private transient ImmutableListMultimap<V, K> inverse;
    
    ImmutableListMultimap(final ImmutableMap<K, ImmutableList<V>> immutableMap, final int n) {
        super((ImmutableMap<K, ? extends ImmutableCollection<Object>>)immutableMap, n);
    }
    
    public static <K, V> Builder<K, V> builder() {
        return new Builder<K, V>();
    }
    
    public static <K, V> ImmutableListMultimap<K, V> copyOf(final Multimap<? extends K, ? extends V> multimap) {
        Object of = null;
        if (multimap.isEmpty()) {
            of = of();
        }
        else if (!(multimap instanceof ImmutableListMultimap) || ((ImmutableMultimap)(of = multimap)).isPartialView()) {
            final ImmutableMap.Builder<K, ImmutableList<Object>> builder = ImmutableMap.builder();
            int n = 0;
            for (final Map.Entry<Object, Collection<Object>> entry : multimap.asMap().entrySet()) {
                final ImmutableList<Object> copy = ImmutableList.copyOf((Collection<?>)entry.getValue());
                if (!copy.isEmpty()) {
                    builder.put((K)entry.getKey(), copy);
                    n += copy.size();
                }
            }
            return new ImmutableListMultimap<K, V>((ImmutableMap<Object, ImmutableList<Object>>)builder.build(), n);
        }
        return (ImmutableListMultimap<K, V>)of;
    }
    
    private ImmutableListMultimap<V, K> invert() {
        final Builder<V, K> builder = builder();
        for (final Map.Entry<K, Object> entry : this.entries()) {
            builder.put((V)entry.getValue(), entry.getKey());
        }
        final ImmutableListMultimap<V, K> build = builder.build();
        build.inverse = (ImmutableListMultimap<K, K>)this;
        return (ImmutableListMultimap<V, K>)build;
    }
    
    public static <K, V> ImmutableListMultimap<K, V> of() {
        return (ImmutableListMultimap<K, V>)EmptyImmutableListMultimap.INSTANCE;
    }
    
    public static <K, V> ImmutableListMultimap<K, V> of(final K k, final V v) {
        final Builder<K, V> builder = builder();
        builder.put(k, v);
        return builder.build();
    }
    
    public static <K, V> ImmutableListMultimap<K, V> of(final K k, final V v, final K i, final V v2) {
        final Builder<K, V> builder = builder();
        builder.put(k, v);
        builder.put(i, v2);
        return builder.build();
    }
    
    public static <K, V> ImmutableListMultimap<K, V> of(final K k, final V v, final K i, final V v2, final K j, final V v3) {
        final Builder<K, V> builder = builder();
        builder.put(k, v);
        builder.put(i, v2);
        builder.put(j, v3);
        return builder.build();
    }
    
    public static <K, V> ImmutableListMultimap<K, V> of(final K k, final V v, final K i, final V v2, final K j, final V v3, final K l, final V v4) {
        final Builder<K, V> builder = builder();
        builder.put(k, v);
        builder.put(i, v2);
        builder.put(j, v3);
        builder.put(l, v4);
        return builder.build();
    }
    
    public static <K, V> ImmutableListMultimap<K, V> of(final K k, final V v, final K i, final V v2, final K j, final V v3, final K l, final V v4, final K m, final V v5) {
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
        final int int1 = objectInputStream.readInt();
        if (int1 < 0) {
            throw new InvalidObjectException(new StringBuilder(29).append("Invalid key count ").append(int1).toString());
        }
        final ImmutableMap.Builder<Object, ImmutableList<Object>> builder = ImmutableMap.builder();
        int n = 0;
        for (int i = 0; i < int1; ++i) {
            final Object object = objectInputStream.readObject();
            final int int2 = objectInputStream.readInt();
            if (int2 <= 0) {
                throw new InvalidObjectException(new StringBuilder(31).append("Invalid value count ").append(int2).toString());
            }
            final Object[] array = new Object[int2];
            for (int j = 0; j < int2; ++j) {
                array[j] = objectInputStream.readObject();
            }
            builder.put(object, ImmutableList.copyOf(array));
            n += int2;
        }
        try {
            FieldSettersHolder.MAP_FIELD_SETTER.set(this, builder.build());
            FieldSettersHolder.SIZE_FIELD_SETTER.set(this, n);
        }
        catch (IllegalArgumentException cause) {
            throw (InvalidObjectException)new InvalidObjectException(cause.getMessage()).initCause(cause);
        }
    }
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(final ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMultimap((Multimap<Object, Object>)this, objectOutputStream);
    }
    
    @Override
    public ImmutableList<V> get(@Nullable final K k) {
        ImmutableList<V> of;
        if ((of = (ImmutableList<V>)this.map.get(k)) == null) {
            of = ImmutableList.of();
        }
        return of;
    }
    
    @Override
    public ImmutableListMultimap<V, K> inverse() {
        ImmutableListMultimap<V, K> inverse;
        if ((inverse = this.inverse) == null) {
            inverse = this.invert();
            this.inverse = inverse;
        }
        return inverse;
    }
    
    @Deprecated
    @Override
    public ImmutableList<V> removeAll(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public ImmutableList<V> replaceValues(final K k, final Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }
    
    public static final class Builder<K, V> extends ImmutableMultimap.Builder<K, V>
    {
        public ImmutableListMultimap<K, V> build() {
            return (ImmutableListMultimap<K, V>)(ImmutableListMultimap)super.build();
        }
        
        public Builder<K, V> orderKeysBy(final Comparator<? super K> comparator) {
            super.orderKeysBy(comparator);
            return this;
        }
        
        public Builder<K, V> orderValuesBy(final Comparator<? super V> comparator) {
            super.orderValuesBy(comparator);
            return this;
        }
        
        public Builder<K, V> put(final K k, final V v) {
            super.put(k, v);
            return this;
        }
        
        public Builder<K, V> put(final Map.Entry<? extends K, ? extends V> entry) {
            super.put(entry);
            return this;
        }
        
        public Builder<K, V> putAll(final Multimap<? extends K, ? extends V> multimap) {
            super.putAll(multimap);
            return this;
        }
        
        public Builder<K, V> putAll(final K k, final Iterable<? extends V> iterable) {
            super.putAll(k, iterable);
            return this;
        }
        
        public Builder<K, V> putAll(final K k, final V... array) {
            super.putAll(k, array);
            return this;
        }
    }
}
