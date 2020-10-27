package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class zzehb<K, V> extends zzegw<K, V, V> {
    private static final zzehm<Map<Object, Object>> zzijg = zzehc.zzbb(Collections.emptyMap());

    private zzehb(Map<K, zzehm<V>> map) {
        super(map);
    }

    public static <K, V> zzehd<K, V> zzhw(int i) {
        return new zzehd<>(i);
    }

    public final /* synthetic */ Object get() {
        LinkedHashMap zzhu = zzegy.zzhu(zzbir().size());
        for (Map.Entry entry : zzbir().entrySet()) {
            zzhu.put(entry.getKey(), ((zzehm) entry.getValue()).get());
        }
        return Collections.unmodifiableMap(zzhu);
    }
}
