package com.google.android.gms.measurement.internal;

final class zzgq implements Runnable {
    private final /* synthetic */ zzkr zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzge zzc;

    zzgq(zzge zzge, zzkr zzkr, zzn zzn) {
        this.zzc = zzge;
        this.zza = zzkr;
        this.zzb = zzn;
    }

    public final void run() {
        this.zzc.zza.zzo();
        if (this.zza.zza() == null) {
            this.zzc.zza.zzb(this.zza, this.zzb);
        } else {
            this.zzc.zza.zza(this.zza, this.zzb);
        }
    }
}
