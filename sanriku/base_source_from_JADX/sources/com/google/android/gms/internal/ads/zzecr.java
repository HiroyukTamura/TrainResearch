package com.google.android.gms.internal.ads;

import java.util.Map;

final class zzecr<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzecp> zzhzg;

    private zzecr(Map.Entry<K, zzecp> entry) {
        this.zzhzg = entry;
    }

    public final K getKey() {
        return this.zzhzg.getKey();
    }

    public final Object getValue() {
        if (this.zzhzg.getValue() == null) {
            return null;
        }
        return zzecp.zzbfp();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzedo) {
            return this.zzhzg.getValue().zzn((zzedo) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public final zzecp zzbfr() {
        return this.zzhzg.getValue();
    }
}
