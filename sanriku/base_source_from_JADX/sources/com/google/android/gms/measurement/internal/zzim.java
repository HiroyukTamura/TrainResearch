package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final class zzim implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zzik zzb;
    private final /* synthetic */ zzik zzc;
    private final /* synthetic */ long zzd;
    private final /* synthetic */ zzin zze;

    zzim(zzin zzin, Bundle bundle, zzik zzik, zzik zzik2, long j) {
        this.zze = zzin;
        this.zza = bundle;
        this.zzb = zzik;
        this.zzc = zzik2;
        this.zzd = j;
    }

    public final void run() {
        this.zze.zza(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
