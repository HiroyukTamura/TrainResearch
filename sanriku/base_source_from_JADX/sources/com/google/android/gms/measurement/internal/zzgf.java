package com.google.android.gms.measurement.internal;

final class zzgf implements Runnable {
    private final /* synthetic */ zzhe zza;
    private final /* synthetic */ zzgd zzb;

    zzgf(zzgd zzgd, zzhe zzhe) {
        this.zzb = zzgd;
        this.zza = zzhe;
    }

    public final void run() {
        this.zzb.zza(this.zza);
        this.zzb.zza();
    }
}
