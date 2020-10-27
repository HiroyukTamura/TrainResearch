package com.google.android.gms.internal.measurement;

import java.io.Serializable;

public abstract class zzdr<T> implements Serializable {
    zzdr() {
    }

    public static <T> zzdr<T> zza(T t) {
        return new zzdt(zzdq.zza(t));
    }

    public static <T> zzdr<T> zzc() {
        return zzdn.zza;
    }

    public abstract boolean zza();

    public abstract T zzb();
}
