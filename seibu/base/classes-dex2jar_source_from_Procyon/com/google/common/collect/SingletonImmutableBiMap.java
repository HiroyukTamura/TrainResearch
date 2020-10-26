// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import javax.annotation.Nullable;
import java.util.Map;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true, serializable = true)
final class SingletonImmutableBiMap<K, V> extends ImmutableBiMap<K, V>
{
    transient ImmutableBiMap<V, K> inverse;
    final transient K singleKey;
    final transient V singleValue;
    
    SingletonImmutableBiMap(final K singleKey, final V singleValue) {
        CollectPreconditions.checkEntryNotNull(singleKey, singleValue);
        this.singleKey = singleKey;
        this.singleValue = singleValue;
    }
    
    private SingletonImmutableBiMap(final K singleKey, final V singleValue, final ImmutableBiMap<V, K> inverse) {
        this.singleKey = singleKey;
        this.singleValue = singleValue;
        this.inverse = inverse;
    }
    
    SingletonImmutableBiMap(final Entry<? extends K, ? extends V> entry) {
        this(entry.getKey(), entry.getValue());
    }
    
    @Override
    public boolean containsKey(@Nullable final Object obj) {
        return this.singleKey.equals(obj);
    }
    
    @Override
    public boolean containsValue(@Nullable final Object obj) {
        return this.singleValue.equals(obj);
    }
    
    @Override
    ImmutableSet<Entry<K, V>> createEntrySet() {
        return ImmutableSet.of(Maps.immutableEntry(this.singleKey, this.singleValue));
    }
    
    @Override
    ImmutableSet<K> createKeySet() {
        return ImmutableSet.of(this.singleKey);
    }
    
    @Override
    public V get(@Nullable final Object obj) {
        if (this.singleKey.equals(obj)) {
            return this.singleValue;
        }
        return null;
    }
    
    @Override
    public ImmutableBiMap<V, K> inverse() {
        ImmutableBiMap<V, K> inverse;
        if ((inverse = this.inverse) == null) {
            inverse = (ImmutableBiMap<V, K>)new SingletonImmutableBiMap(this.singleValue, this.singleKey, (ImmutableBiMap<Object, Object>)this);
            this.inverse = inverse;
        }
        return inverse;
    }
    
    @Override
    boolean isPartialView() {
        return false;
    }
    
    @Override
    public int size() {
        return 1;
    }
}
