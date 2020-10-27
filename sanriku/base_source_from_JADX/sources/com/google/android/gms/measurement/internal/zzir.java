package com.google.android.gms.measurement.internal;

final class zzir implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzin zzb;

    zzir(zzin zzin, long j) {
        this.zzb = zzin;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zze().zza(this.zza);
        this.zzb.zza = null;
    }
}
