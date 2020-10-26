// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.Nullable;
import java.util.Map;
import com.google.common.base.Preconditions;
import java.util.EnumMap;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true, serializable = true)
final class ImmutableEnumMap<K extends Enum<K>, V> extends ImmutableMap<K, V>
{
    private final transient EnumMap<K, V> delegate;
    
    private ImmutableEnumMap(final EnumMap<K, V> delegate) {
        this.delegate = delegate;
        Preconditions.checkArgument(!delegate.isEmpty());
    }
    
    static <K extends Enum<K>, V> ImmutableMap<K, V> asImmutable(final EnumMap<K, V> enumMap) {
        switch (enumMap.size()) {
            default: {
                return new ImmutableEnumMap<K, V>(enumMap);
            }
            case 0: {
                return ImmutableMap.of();
            }
            case 1: {
                final Map.Entry<K, V> entry = Iterables.getOnlyElement(enumMap.entrySet());
                return ImmutableMap.of(entry.getKey(), entry.getValue());
            }
        }
    }
    
    @Override
    public boolean containsKey(@Nullable final Object key) {
        return this.delegate.containsKey(key);
    }
    
    @Override
    ImmutableSet<Entry<K, V>> createEntrySet() {
        return (ImmutableSet<Entry<K, V>>)new ImmutableMapEntrySet<K, V>() {
            @Override
            public UnmodifiableIterator<Entry<K, V>> iterator() {
                return new UnmodifiableIterator<Entry<K, V>>() {
                    private final Iterator<Entry<K, V>> backingIterator = ImmutableEnumMap.this.delegate.entrySet().iterator();
                    
                    @Override
                    public boolean hasNext() {
                        return this.backingIterator.hasNext();
                    }
                    
                    @Override
                    public Entry<K, V> next() {
                        final Entry entry = this.backingIterator.next();
                        return Maps.immutableEntry((K)entry.getKey(), (V)entry.getValue());
                    }
                };
            }
            
            @Override
            ImmutableMap<K, V> map() {
                return (ImmutableMap<K, V>)ImmutableEnumMap.this;
            }
        };
    }
    
    @Override
    ImmutableSet<K> createKeySet() {
        return new ImmutableSet<K>() {
            @Override
            public boolean contains(final Object key) {
                return ImmutableEnumMap.this.delegate.containsKey(key);
            }
            
            @Override
            boolean isPartialView() {
                return true;
            }
            
            @Override
            public UnmodifiableIterator<K> iterator() {
                return Iterators.unmodifiableIterator((Iterator<K>)ImmutableEnumMap.this.delegate.keySet().iterator());
            }
            
            @Override
            public int size() {
                return ImmutableEnumMap.this.size();
            }
        };
    }
    
    @Override
    public V get(final Object key) {
        return this.delegate.get(key);
    }
    
    @Override
    boolean isPartialView() {
        return false;
    }
    
    @Override
    public int size() {
        return this.delegate.size();
    }
    
    @Override
    Object writeReplace() {
        return new EnumSerializedForm((EnumMap<Enum, Object>)this.delegate);
    }
    
    private static class EnumSerializedForm<K extends Enum<K>, V> implements Serializable
    {
        private static final long serialVersionUID = 0L;
        final EnumMap<K, V> delegate;
        
        EnumSerializedForm(final EnumMap<K, V> delegate) {
            this.delegate = delegate;
        }
        
        Object readResolve() {
            return new ImmutableEnumMap(this.delegate, null);
        }
    }
}
