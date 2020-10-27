package com.google.android.gms.measurement.internal;

final class zzgj implements Runnable {
    private final /* synthetic */ zzw zza;
    private final /* synthetic */ zzge zzb;

    zzgj(zzge zzge, zzw zzw) {
        this.zzb = zzge;
        this.zza = zzw;
    }

    public final void run() {
        this.zzb.zza.zzo();
        if (this.zza.zzc.zza() == null) {
            this.zzb.zza.zzb(this.zza);
        } else {
            this.zzb.zza.zza(this.zza);
        }
    }
}
