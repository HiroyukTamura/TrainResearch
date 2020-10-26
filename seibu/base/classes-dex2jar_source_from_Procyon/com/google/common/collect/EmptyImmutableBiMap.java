// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import javax.annotation.Nullable;
import java.util.Set;
import java.util.Map;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
final class EmptyImmutableBiMap extends ImmutableBiMap<Object, Object>
{
    static final EmptyImmutableBiMap INSTANCE;
    
    static {
        INSTANCE = new EmptyImmutableBiMap();
    }
    
    private EmptyImmutableBiMap() {
    }
    
    @Override
    public ImmutableSetMultimap<Object, Object> asMultimap() {
        return ImmutableSetMultimap.of();
    }
    
    @Override
    ImmutableSet<Entry<Object, Object>> createEntrySet() {
        throw new AssertionError((Object)"should never be called");
    }
    
    @Override
    public ImmutableSet<Entry<Object, Object>> entrySet() {
        return ImmutableSet.of();
    }
    
    @Override
    public Object get(@Nullable final Object o) {
        return null;
    }
    
    @Override
    public ImmutableBiMap<Object, Object> inverse() {
        return this;
    }
    
    @Override
    public boolean isEmpty() {
        return true;
    }
    
    @Override
    boolean isPartialView() {
        return false;
    }
    
    @Override
    public ImmutableSet<Object> keySet() {
        return ImmutableSet.of();
    }
    
    Object readResolve() {
        return EmptyImmutableBiMap.INSTANCE;
    }
    
    @Override
    public int size() {
        return 0;
    }
}
