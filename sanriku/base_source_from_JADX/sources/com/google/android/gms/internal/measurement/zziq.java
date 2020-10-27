package com.google.android.gms.internal.measurement;

import java.util.Map;

final class zziq<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzio> zza;

    private zziq(Map.Entry<K, zzio> entry) {
        this.zza = entry;
    }

    public final K getKey() {
        return this.zza.getKey();
    }

    public final Object getValue() {
        if (this.zza.getValue() == null) {
            return null;
        }
        return zzio.zza();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzjj) {
            return this.zza.getValue().zza((zzjj) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public final zzio zza() {
        return this.zza.getValue();
    }
}
