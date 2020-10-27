package com.google.android.gms.measurement.internal;

final class zzjy implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzjw zzb;

    zzjy(zzjw zzjw, long j) {
        this.zzb = zzjw;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzc(this.zza);
    }
}
