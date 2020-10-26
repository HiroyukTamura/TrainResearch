// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.io.Serializable;
import com.google.common.annotations.GwtIncompatible;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
final class ImmutableMapKeySet<K, V> extends ImmutableSet<K>
{
    private final ImmutableMap<K, V> map;
    
    ImmutableMapKeySet(final ImmutableMap<K, V> map) {
        this.map = map;
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        return this.map.containsKey(o);
    }
    
    @Override
    ImmutableList<K> createAsList() {
        return new ImmutableAsList<K>() {
            final /* synthetic */ ImmutableList val$entryList = ImmutableMapKeySet.this.map.entrySet().asList();
            
            @Override
            ImmutableCollection<K> delegateCollection() {
                return (ImmutableCollection<K>)ImmutableMapKeySet.this;
            }
            
            @Override
            public K get(final int n) {
                return ((Map.Entry)this.val$entryList.get(n)).getKey();
            }
        };
    }
    
    @Override
    boolean isPartialView() {
        return true;
    }
    
    @Override
    public UnmodifiableIterator<K> iterator() {
        return this.asList().iterator();
    }
    
    @Override
    public int size() {
        return this.map.size();
    }
    
    @GwtIncompatible("serialization")
    @Override
    Object writeReplace() {
        return new KeySetSerializedForm((ImmutableMap<Object, ?>)this.map);
    }
    
    @GwtIncompatible("serialization")
    private static class KeySetSerializedForm<K> implements Serializable
    {
        private static final long serialVersionUID = 0L;
        final ImmutableMap<K, ?> map;
        
        KeySetSerializedForm(final ImmutableMap<K, ?> map) {
            this.map = map;
        }
        
        Object readResolve() {
            return this.map.keySet();
        }
    }
}
