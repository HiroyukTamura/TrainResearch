// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.io.Serializable;
import com.google.common.annotations.GwtIncompatible;
import java.util.Map;
import java.util.Iterator;
import javax.annotation.Nullable;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
final class ImmutableMapValues<K, V> extends ImmutableCollection<V>
{
    private final ImmutableMap<K, V> map;
    
    ImmutableMapValues(final ImmutableMap<K, V> map) {
        this.map = map;
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        return o != null && Iterators.contains(this.iterator(), o);
    }
    
    @Override
    ImmutableList<V> createAsList() {
        return new ImmutableAsList<V>() {
            final /* synthetic */ ImmutableList val$entryList = ImmutableMapValues.this.map.entrySet().asList();
            
            @Override
            ImmutableCollection<V> delegateCollection() {
                return (ImmutableCollection<V>)ImmutableMapValues.this;
            }
            
            @Override
            public V get(final int n) {
                return ((Map.Entry)this.val$entryList.get(n)).getValue();
            }
        };
    }
    
    @Override
    boolean isPartialView() {
        return true;
    }
    
    @Override
    public UnmodifiableIterator<V> iterator() {
        return Maps.valueIterator(this.map.entrySet().iterator());
    }
    
    @Override
    public int size() {
        return this.map.size();
    }
    
    @GwtIncompatible("serialization")
    @Override
    Object writeReplace() {
        return new SerializedForm((ImmutableMap<?, Object>)this.map);
    }
    
    @GwtIncompatible("serialization")
    private static class SerializedForm<V> implements Serializable
    {
        private static final long serialVersionUID = 0L;
        final ImmutableMap<?, V> map;
        
        SerializedForm(final ImmutableMap<?, V> map) {
            this.map = map;
        }
        
        Object readResolve() {
            return this.map.values();
        }
    }
}
