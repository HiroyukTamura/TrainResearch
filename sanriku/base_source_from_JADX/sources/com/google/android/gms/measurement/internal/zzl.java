package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzw;

final class zzl implements Runnable {
    private final /* synthetic */ zzw zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ AppMeasurementDynamiteService zzd;

    zzl(AppMeasurementDynamiteService appMeasurementDynamiteService, zzw zzw, String str, String str2) {
        this.zzd = appMeasurementDynamiteService;
        this.zza = zzw;
        this.zzb = str;
        this.zzc = str2;
    }

    public final void run() {
        this.zzd.zza.zzw().zza(this.zza, this.zzb, this.zzc);
    }
}
