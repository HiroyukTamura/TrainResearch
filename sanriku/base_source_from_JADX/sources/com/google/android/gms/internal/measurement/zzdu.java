package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class zzdu {
    public static <T> zzdv<T> zza(zzdv<T> zzdv) {
        return ((zzdv instanceof zzdw) || (zzdv instanceof zzdx)) ? zzdv : zzdv instanceof Serializable ? new zzdx(zzdv) : new zzdw(zzdv);
    }

    public static <T> zzdv<T> zza(@NullableDecl T t) {
        return new zzdz(t);
    }
}
