package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import p009e.p010a.p011a.p012a.C0681a;

final class zzdz<T> implements zzdv<T>, Serializable {
    @NullableDecl
    private final T zza;

    zzdz(@NullableDecl T t) {
        this.zza = t;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof zzdz) {
            return zzdo.zza(this.zza, ((zzdz) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        return C0681a.m313a(valueOf.length() + 22, "Suppliers.ofInstance(", valueOf, ")");
    }

    public final T zza() {
        return this.zza;
    }
}
