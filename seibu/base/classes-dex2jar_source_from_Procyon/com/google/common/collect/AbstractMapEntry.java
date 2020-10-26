// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import com.google.common.base.Objects;
import javax.annotation.Nullable;
import com.google.common.annotations.GwtCompatible;
import java.util.Map;

@GwtCompatible
abstract class AbstractMapEntry<K, V> implements Entry<K, V>
{
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
    
    @Override
    public abstract K getKey();
    
    @Override
    public abstract V getValue();
    
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
    public V setValue(final V v) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(String.valueOf(this.getKey()));
        final String value2 = String.valueOf(String.valueOf(this.getValue()));
        return new StringBuilder(value.length() + 1 + value2.length()).append(value).append("=").append(value2).toString();
    }
}
