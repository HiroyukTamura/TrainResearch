package com.google.android.gms.internal.ads;

import java.util.Map;
import p009e.p010a.p011a.p012a.C0681a;

final class zzeeu implements Comparable<zzeeu>, Map.Entry<K, V> {
    private V value;
    private final /* synthetic */ zzeel zzicc;
    private final K zzicg;

    zzeeu(zzeel zzeel, K k, V v) {
        this.zzicc = zzeel;
        this.zzicg = k;
        this.value = v;
    }

    zzeeu(zzeel zzeel, Map.Entry<K, V> entry) {
        this(zzeel, (Comparable) entry.getKey(), entry.getValue());
    }

    private static boolean equals(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((zzeeu) obj).getKey());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return equals(this.zzicg, entry.getKey()) && equals(this.value, entry.getValue());
    }

    public final /* synthetic */ Object getKey() {
        return this.zzicg;
    }

    public final V getValue() {
        return this.value;
    }

    public final int hashCode() {
        K k = this.zzicg;
        int i = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.value;
        if (v != null) {
            i = v.hashCode();
        }
        return hashCode ^ i;
    }

    public final V setValue(V v) {
        this.zzicc.zzbgt();
        V v2 = this.value;
        this.value = v;
        return v2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzicg);
        String valueOf2 = String.valueOf(this.value);
        return C0681a.m313a(valueOf2.length() + valueOf.length() + 1, valueOf, "=", valueOf2);
    }
}
