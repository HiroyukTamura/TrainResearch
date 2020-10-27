package com.google.android.gms.internal.measurement;

final class zzfq extends zzeq<Object> {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    zzfq(Object[] objArr, int i, int i2) {
        this.zza = objArr;
        this.zzb = i;
        this.zzc = i2;
    }

    public final Object get(int i) {
        zzdq.zza(i, this.zzc);
        return this.zza[(i * 2) + this.zzb];
    }

    public final int size() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzh() {
        return true;
    }
}
