package com.google.android.gms.measurement.internal;

final class zzkj extends zzag {
    private final /* synthetic */ zzkk zza;
    private final /* synthetic */ zzkg zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzkj(zzkg zzkg, zzgz zzgz, zzkk zzkk) {
        super(zzgz);
        this.zzb = zzkg;
        this.zza = zzkk;
    }

    public final void zza() {
        this.zzb.zzf();
        this.zzb.zzr().zzx().zza("Starting upload from DelayedRunnable");
        this.zza.zzl();
    }
}
