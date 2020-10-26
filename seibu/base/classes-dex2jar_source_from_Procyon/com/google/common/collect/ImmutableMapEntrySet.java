// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.io.Serializable;
import com.google.common.annotations.GwtIncompatible;
import javax.annotation.Nullable;
import com.google.common.annotations.GwtCompatible;
import java.util.Map;

@GwtCompatible(emulated = true)
abstract class ImmutableMapEntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>>
{
    @Override
    public boolean contains(@Nullable final Object o) {
        boolean b2;
        final boolean b = b2 = false;
        if (o instanceof Map.Entry) {
            final Map.Entry entry = (Map.Entry)o;
            final V value = this.map().get(entry.getKey());
            b2 = b;
            if (value != null) {
                b2 = b;
                if (value.equals(entry.getValue())) {
                    b2 = true;
                }
            }
        }
        return b2;
    }
    
    @Override
    boolean isPartialView() {
        return this.map().isPartialView();
    }
    
    abstract ImmutableMap<K, V> map();
    
    @Override
    public int size() {
        return this.map().size();
    }
    
    @GwtIncompatible("serialization")
    @Override
    Object writeReplace() {
        return new EntrySetSerializedForm(this.map());
    }
    
    @GwtIncompatible("serialization")
    private static class EntrySetSerializedForm<K, V> implements Serializable
    {
        private static final long serialVersionUID = 0L;
        final ImmutableMap<K, V> map;
        
        EntrySetSerializedForm(final ImmutableMap<K, V> map) {
            this.map = map;
        }
        
        Object readResolve() {
            return this.map.entrySet();
        }
    }
}
