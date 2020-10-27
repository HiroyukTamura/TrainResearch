package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

final class zzko implements Callable<String> {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzkk zzb;

    zzko(zzkk zzkk, zzn zzn) {
        this.zzb = zzkk;
        this.zza = zzn;
    }

    public final /* synthetic */ Object call() throws Exception {
        zzf zzc = this.zzb.zzc(this.zza);
        if (zzc != null) {
            return zzc.zzd();
        }
        this.zzb.zzr().zzi().zza("App info was null when attempting to get app instance id");
        return null;
    }
}
