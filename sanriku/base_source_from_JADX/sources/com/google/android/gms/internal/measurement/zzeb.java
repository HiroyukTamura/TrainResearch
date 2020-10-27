package com.google.android.gms.internal.measurement;

import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import p009e.p010a.p011a.p012a.C0681a;

abstract class zzeb<K, V> implements Map.Entry<K, V> {
    zzeb() {
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            return zzdo.zza(getKey(), entry.getKey()) && zzdo.zza(getValue(), entry.getValue());
        }
    }

    public abstract K getKey();

    public abstract V getValue();

    public int hashCode() {
        Object key = getKey();
        Object value = getValue();
        int i = 0;
        int hashCode = key == null ? 0 : key.hashCode();
        if (value != null) {
            i = value.hashCode();
        }
        return hashCode ^ i;
    }

    public V setValue(V v) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        String valueOf = String.valueOf(getKey());
        String valueOf2 = String.valueOf(getValue());
        return C0681a.m313a(valueOf2.length() + valueOf.length() + 1, valueOf, "=", valueOf2);
    }
}
