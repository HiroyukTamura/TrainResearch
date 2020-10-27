package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Map;

abstract class zzegw<K, V, V2> implements zzegz<Map<K, V2>> {
    private final Map<K, zzehm<V>> zzijc;

    zzegw(Map<K, zzehm<V>> map) {
        this.zzijc = Collections.unmodifiableMap(map);
    }

    /* access modifiers changed from: package-private */
    public final Map<K, zzehm<V>> zzbir() {
        return this.zzijc;
    }
}
