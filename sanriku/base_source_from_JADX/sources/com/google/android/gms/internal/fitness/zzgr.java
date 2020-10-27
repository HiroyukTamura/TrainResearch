package com.google.android.gms.internal.fitness;

import java.util.Map;

final class zzgr<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzgp> zzwr;

    private zzgr(Map.Entry<K, zzgp> entry) {
        this.zzwr = entry;
    }

    public final K getKey() {
        return this.zzwr.getKey();
    }

    public final Object getValue() {
        if (this.zzwr.getValue() == null) {
            return null;
        }
        return zzgp.zzbu();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzho) {
            return this.zzwr.getValue().zzh((zzho) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public final zzgp zzbw() {
        return this.zzwr.getValue();
    }
}
