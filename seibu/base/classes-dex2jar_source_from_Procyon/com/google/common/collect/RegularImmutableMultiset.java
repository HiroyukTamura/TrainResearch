// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(serializable = true)
class RegularImmutableMultiset<E> extends ImmutableMultiset<E>
{
    private final transient ImmutableMap<E, Integer> map;
    private final transient int size;
    
    RegularImmutableMultiset(final ImmutableMap<E, Integer> map, final int size) {
        this.map = map;
        this.size = size;
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        return this.map.containsKey(o);
    }
    
    @Override
    public int count(@Nullable final Object o) {
        final Integer n = this.map.get(o);
        if (n == null) {
            return 0;
        }
        return n;
    }
    
    @Override
    public ImmutableSet<E> elementSet() {
        return this.map.keySet();
    }
    
    @Override
    Entry<E> getEntry(final int n) {
        final Map.Entry<E, V> entry = this.map.entrySet().asList().get(n);
        return Multisets.immutableEntry((E)entry.getKey(), (int)entry.getValue());
    }
    
    @Override
    public int hashCode() {
        return this.map.hashCode();
    }
    
    @Override
    boolean isPartialView() {
        return this.map.isPartialView();
    }
    
    @Override
    public int size() {
        return this.size;
    }
}