package com.google.android.gms.internal.fitness;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzia {
    private static final zzia zzyh = new zzia();
    private final zzib zzyi = new zzhb();
    private final ConcurrentMap<Class<?>, zzic<?>> zzyj = new ConcurrentHashMap();

    private zzia() {
    }

    public static zzia zzcp() {
        return zzyh;
    }

    public final <T> zzic<T> zze(Class<T> cls) {
        zzgk.zza(cls, "messageType");
        zzic<T> zzic = (zzic) this.zzyj.get(cls);
        if (zzic != null) {
            return zzic;
        }
        zzic<T> zzd = this.zzyi.zzd(cls);
        zzgk.zza(cls, "messageType");
        zzgk.zza(zzd, "schema");
        zzic<T> putIfAbsent = this.zzyj.putIfAbsent(cls, zzd);
        return putIfAbsent != null ? putIfAbsent : zzd;
    }

    public final <T> zzic<T> zzl(T t) {
        return zze(t.getClass());
    }
}
