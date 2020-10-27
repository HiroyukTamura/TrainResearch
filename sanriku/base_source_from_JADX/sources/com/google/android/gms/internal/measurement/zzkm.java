package com.google.android.gms.internal.measurement;

import java.util.Map;
import p009e.p010a.p011a.p012a.C0681a;

final class zzkm implements Comparable<zzkm>, Map.Entry<K, V> {
    private final K zza;
    private V zzb;
    private final /* synthetic */ zzkd zzc;

    zzkm(zzkd zzkd, K k, V v) {
        this.zzc = zzkd;
        this.zza = k;
        this.zzb = v;
    }

    zzkm(zzkd zzkd, Map.Entry<K, V> entry) {
        this(zzkd, (Comparable) entry.getKey(), entry.getValue());
    }

    private static boolean zza(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((zzkm) obj).getKey());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return zza(this.zza, entry.getKey()) && zza(this.zzb, entry.getValue());
    }

    public final /* synthetic */ Object getKey() {
        return this.zza;
    }

    public final V getValue() {
        return this.zzb;
    }

    public final int hashCode() {
        K k = this.zza;
        int i = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.zzb;
        if (v != null) {
            i = v.hashCode();
        }
        return hashCode ^ i;
    }

    public final V setValue(V v) {
        this.zzc.zzf();
        V v2 = this.zzb;
        this.zzb = v;
        return v2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        String valueOf2 = String.valueOf(this.zzb);
        return C0681a.m313a(valueOf2.length() + valueOf.length() + 1, valueOf, "=", valueOf2);
    }
}
