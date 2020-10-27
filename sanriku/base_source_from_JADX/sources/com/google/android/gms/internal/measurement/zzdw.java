package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import p009e.p010a.p011a.p012a.C0681a;

final class zzdw<T> implements zzdv<T> {
    private volatile zzdv<T> zza;
    private volatile boolean zzb;
    @NullableDecl
    private T zzc;

    zzdw(zzdv<T> zzdv) {
        this.zza = (zzdv) zzdq.zza(zzdv);
    }

    public final String toString() {
        Object obj = this.zza;
        if (obj == null) {
            String valueOf = String.valueOf(this.zzc);
            obj = C0681a.m313a(valueOf.length() + 25, "<supplier that returned ", valueOf, ">");
        }
        String valueOf2 = String.valueOf(obj);
        return C0681a.m313a(valueOf2.length() + 19, "Suppliers.memoize(", valueOf2, ")");
    }

    public final T zza() {
        if (!this.zzb) {
            synchronized (this) {
                if (!this.zzb) {
                    T zza2 = this.zza.zza();
                    this.zzc = zza2;
                    this.zzb = true;
                    this.zza = null;
                    return zza2;
                }
            }
        }
        return this.zzc;
    }
}
