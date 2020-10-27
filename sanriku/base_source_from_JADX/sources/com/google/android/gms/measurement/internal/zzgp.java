package com.google.android.gms.measurement.internal;

final class zzgp implements Runnable {
    private final /* synthetic */ zzao zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzge zzc;

    zzgp(zzge zzge, zzao zzao, zzn zzn) {
        this.zzc = zzge;
        this.zza = zzao;
        this.zzb = zzn;
    }

    public final void run() {
        zzao zzb2 = this.zzc.zzb(this.zza, this.zzb);
        this.zzc.zza.zzo();
        this.zzc.zza.zza(zzb2, this.zzb);
    }
}
