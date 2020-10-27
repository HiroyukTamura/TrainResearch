package com.google.android.gms.measurement.internal;

final class zzka implements Runnable {
    long zza;
    long zzb;
    final /* synthetic */ zzkb zzc;

    zzka(zzkb zzkb, long j, long j2) {
        this.zzc = zzkb;
        this.zza = j;
        this.zzb = j2;
    }

    public final void run() {
        this.zzc.zza.zzq().zza((Runnable) new zzkd(this));
    }
}
