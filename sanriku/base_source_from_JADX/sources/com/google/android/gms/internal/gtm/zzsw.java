package com.google.android.gms.internal.gtm;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzsw {
    private static final zzsw zzbdr = new zzsw();
    private final zzta zzbds = new zzrz();
    private final ConcurrentMap<Class<?>, zzsz<?>> zzbdt = new ConcurrentHashMap();

    private zzsw() {
    }

    public static zzsw zzqs() {
        return zzbdr;
    }

    public final <T> zzsz<T> zzaf(T t) {
        return zzi(t.getClass());
    }

    public final <T> zzsz<T> zzi(Class<T> cls) {
        zzre.zza(cls, "messageType");
        zzsz<T> zzsz = (zzsz) this.zzbdt.get(cls);
        if (zzsz != null) {
            return zzsz;
        }
        zzsz<T> zzh = this.zzbds.zzh(cls);
        zzre.zza(cls, "messageType");
        zzre.zza(zzh, "schema");
        zzsz<T> putIfAbsent = this.zzbdt.putIfAbsent(cls, zzh);
        return putIfAbsent != null ? putIfAbsent : zzh;
    }
}
