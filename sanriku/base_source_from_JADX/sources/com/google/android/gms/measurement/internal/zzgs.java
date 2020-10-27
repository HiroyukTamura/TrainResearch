package com.google.android.gms.measurement.internal;

final class zzgs implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzge zzb;

    zzgs(zzge zzge, zzn zzn) {
        this.zzb = zzge;
        this.zza = zzn;
    }

    public final void run() {
        this.zzb.zza.zzo();
        this.zzb.zza.zzb(this.zza);
    }
}
