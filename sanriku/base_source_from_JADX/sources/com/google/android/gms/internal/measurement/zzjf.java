package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

final class zzjf implements zzjg {
    zzjf() {
    }

    public final int zza(int i, Object obj, Object obj2) {
        zzjd zzjd = (zzjd) obj;
        zzjb zzjb = (zzjb) obj2;
        if (zzjd.isEmpty()) {
            return 0;
        }
        Iterator it = zzjd.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    public final Object zza(Object obj, Object obj2) {
        zzjd zzjd = (zzjd) obj;
        zzjd zzjd2 = (zzjd) obj2;
        if (!zzjd2.isEmpty()) {
            if (!zzjd.zzd()) {
                zzjd = zzjd.zzb();
            }
            zzjd.zza(zzjd2);
        }
        return zzjd;
    }

    public final Map<?, ?> zza(Object obj) {
        return (zzjd) obj;
    }

    public final zzje<?, ?> zzb(Object obj) {
        zzjb zzjb = (zzjb) obj;
        throw new NoSuchMethodError();
    }

    public final Map<?, ?> zzc(Object obj) {
        return (zzjd) obj;
    }

    public final boolean zzd(Object obj) {
        return !((zzjd) obj).zzd();
    }

    public final Object zze(Object obj) {
        ((zzjd) obj).zzc();
        return obj;
    }

    public final Object zzf(Object obj) {
        return zzjd.zza().zzb();
    }
}
