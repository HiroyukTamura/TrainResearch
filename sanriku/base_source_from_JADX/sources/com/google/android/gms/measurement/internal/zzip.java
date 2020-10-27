package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final class zzip implements Runnable {
    private final /* synthetic */ zzik zza;
    private final /* synthetic */ zzik zzb;
    private final /* synthetic */ long zzc;
    private final /* synthetic */ boolean zzd;
    private final /* synthetic */ zzin zze;

    zzip(zzin zzin, zzik zzik, zzik zzik2, long j, boolean z) {
        this.zze = zzin;
        this.zza = zzik;
        this.zzb = zzik2;
        this.zzc = j;
        this.zzd = z;
    }

    public final void run() {
        this.zze.zza(this.zza, this.zzb, this.zzc, this.zzd, (Bundle) null);
    }
}
