package com.google.android.gms.measurement.internal;

final class zzjz implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzjw zzb;

    zzjz(zzjw zzjw, long j) {
        this.zzb = zzjw;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzb(this.zza);
    }
}
