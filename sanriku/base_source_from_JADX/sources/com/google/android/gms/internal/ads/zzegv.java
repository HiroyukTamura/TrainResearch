package com.google.android.gms.internal.ads;

import java.util.LinkedHashMap;

public class zzegv<K, V, V2> {
    final LinkedHashMap<K, zzehm<V>> zzijb;

    zzegv(int i) {
        this.zzijb = zzegy.zzhu(i);
    }

    /* access modifiers changed from: package-private */
    public zzegv<K, V, V2> zza(K k, zzehm<V> zzehm) {
        this.zzijb.put(zzehf.zza(k, "key"), zzehf.zza(zzehm, "provider"));
        return this;
    }
}
