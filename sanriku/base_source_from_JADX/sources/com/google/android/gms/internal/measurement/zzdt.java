package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import p009e.p010a.p011a.p012a.C0681a;

final class zzdt<T> extends zzdr<T> {
    private final T zza;

    zzdt(T t) {
        this.zza = t;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof zzdt) {
            return this.zza.equals(((zzdt) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        return C0681a.m313a(valueOf.length() + 13, "Optional.of(", valueOf, ")");
    }

    public final boolean zza() {
        return true;
    }

    public final T zzb() {
        return this.zza;
    }
}
