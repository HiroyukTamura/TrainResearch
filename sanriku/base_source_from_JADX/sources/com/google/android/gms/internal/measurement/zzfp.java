package com.google.android.gms.internal.measurement;

import java.util.Map;

final class zzfp<K, V> extends zzey<Map.Entry<K, V>> {
    private final transient zzeu<K, V> zza;
    /* access modifiers changed from: private */
    public final transient Object[] zzb;
    private final transient int zzc = 0;
    /* access modifiers changed from: private */
    public final transient int zzd;

    zzfp(zzeu<K, V> zzeu, Object[] objArr, int i, int i2) {
        this.zza = zzeu;
        this.zzb = objArr;
        this.zzd = i2;
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return value != null && value.equals(this.zza.get(key));
        }
    }

    public final int size() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final int zzb(Object[] objArr, int i) {
        return zzc().zzb(objArr, i);
    }

    /* renamed from: zzb */
    public final zzfz<Map.Entry<K, V>> iterator() {
        return (zzfz) zzc().iterator();
    }

    /* access modifiers changed from: package-private */
    public final zzeq<Map.Entry<K, V>> zzd() {
        return new zzfo(this);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzh() {
        return true;
    }
}
