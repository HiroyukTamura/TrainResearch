package com.google.android.gms.tagmanager;

import android.annotation.TargetApi;
import android.util.LruCache;

@TargetApi(12)
final class zzdb<K, V> implements zzp<K, V> {
    private LruCache<K, V> zzahy;

    zzdb(int i, zzs<K, V> zzs) {
        this.zzahy = new zzdc(this, 1048576, zzs);
    }

    public final V get(K k) {
        return this.zzahy.get(k);
    }

    public final void zza(K k, V v) {
        this.zzahy.put(k, v);
    }
}
