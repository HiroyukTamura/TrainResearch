package com.google.android.gms.measurement.internal;

final class zzju implements Runnable {
    private final /* synthetic */ zzkk zza;
    private final /* synthetic */ Runnable zzb;

    zzju(zzjt zzjt, zzkk zzkk, Runnable runnable) {
        this.zza = zzkk;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzo();
        this.zza.zza(this.zzb);
        this.zza.zzl();
    }
}
