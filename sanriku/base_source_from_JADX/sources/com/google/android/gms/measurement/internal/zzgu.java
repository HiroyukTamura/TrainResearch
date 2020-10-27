package com.google.android.gms.measurement.internal;

final class zzgu implements Runnable {
    private final /* synthetic */ zzw zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzge zzc;

    zzgu(zzge zzge, zzw zzw, zzn zzn) {
        this.zzc = zzge;
        this.zza = zzw;
        this.zzb = zzn;
    }

    public final void run() {
        this.zzc.zza.zzo();
        if (this.zza.zzc.zza() == null) {
            this.zzc.zza.zzb(this.zza, this.zzb);
        } else {
            this.zzc.zza.zza(this.zza, this.zzb);
        }
    }
}
