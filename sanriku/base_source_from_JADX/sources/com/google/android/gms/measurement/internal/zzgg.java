package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class zzgg implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzge zzb;

    zzgg(zzge zzge, zzn zzn) {
        this.zzb = zzge;
        this.zza = zzn;
    }

    public final void run() {
        this.zzb.zza.zzo();
        zzkk zza2 = this.zzb.zza;
        zzn zzn = this.zza;
        zza2.zzq().zzd();
        zza2.zzk();
        Preconditions.checkNotEmpty(zzn.zza);
        zza2.zzc(zzn);
    }
}
