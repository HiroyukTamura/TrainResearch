package com.google.android.gms.measurement.internal;

final class zzaj implements Runnable {
    private final /* synthetic */ zzgz zza;
    private final /* synthetic */ zzag zzb;

    zzaj(zzag zzag, zzgz zzgz) {
        this.zzb = zzag;
        this.zza = zzgz;
    }

    public final void run() {
        this.zza.zzu();
        if (zzx.zza()) {
            this.zza.zzq().zza((Runnable) this);
            return;
        }
        boolean zzb2 = this.zzb.zzb();
        long unused = this.zzb.zzd = 0;
        if (zzb2) {
            this.zzb.zza();
        }
    }
}
