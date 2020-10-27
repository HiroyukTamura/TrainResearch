package com.google.android.gms.measurement.internal;

final class zzkn implements Runnable {
    private final /* synthetic */ zzkq zza;
    private final /* synthetic */ zzkk zzb;

    zzkn(zzkk zzkk, zzkq zzkq) {
        this.zzb = zzkk;
        this.zza = zzkq;
    }

    public final void run() {
        this.zzb.zza(this.zza);
        this.zzb.zza();
    }
}
