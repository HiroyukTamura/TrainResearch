package com.google.android.gms.measurement.internal;

import android.content.Intent;

final /* synthetic */ class zzjs implements Runnable {
    private final zzjt zza;
    private final int zzb;
    private final zzez zzc;
    private final Intent zzd;

    zzjs(zzjt zzjt, int i, zzez zzez, Intent intent) {
        this.zza = zzjt;
        this.zzb = i;
        this.zzc = zzez;
        this.zzd = intent;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc, this.zzd);
    }
}
