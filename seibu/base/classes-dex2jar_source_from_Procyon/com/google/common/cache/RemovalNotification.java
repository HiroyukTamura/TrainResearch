// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.cache;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.Beta;
import java.util.Map;

@Beta
@GwtCompatible
public final class RemovalNotification<K, V> implements Entry<K, V>
{
    private static final long serialVersionUID = 0L;
    private final RemovalCause cause;
    @Nullable
    private final K key;
    @Nullable
    private final V value;
    
    RemovalNotification(@Nullable final K key, @Nullable final V value, final RemovalCause removalCause) {
        this.key = key;
        this.value = value;
        this.cause = Preconditions.checkNotNull(removalCause);
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        boolean b2;
        final boolean b = b2 = false;
        if (o instanceof Entry) {
            final Entry entry = (Entry)o;
            b2 = b;
            if (Objects.equal(this.getKey(), entry.getKey())) {
                b2 = b;
                if (Objects.equal(this.getValue(), entry.getValue())) {
                    b2 = true;
                }
            }
        }
        return b2;
    }
    
    public RemovalCause getCause() {
        return this.cause;
    }
    
    @Nullable
    @Override
    public K getKey() {
        return this.key;
    }
    
    @Nullable
    @Override
    public V getValue() {
        return this.value;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        final Object key = this.getKey();
        final Object value = this.getValue();
        int hashCode2;
        if (key == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = key.hashCode();
        }
        if (value != null) {
            hashCode = value.hashCode();
        }
        return hashCode ^ hashCode2;
    }
    
    @Override
    public final V setValue(final V v) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(String.valueOf(this.getKey()));
        final String value2 = String.valueOf(String.valueOf(this.getValue()));
        return new StringBuilder(value.length() + 1 + value2.length()).append(value).append("=").append(value2).toString();
    }
    
    public boolean wasEvicted() {
        return this.cause.wasEvicted();
    }
}
