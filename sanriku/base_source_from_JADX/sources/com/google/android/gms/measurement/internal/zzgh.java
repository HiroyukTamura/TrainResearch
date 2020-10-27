package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final /* synthetic */ class zzgh implements Runnable {
    private final zzge zza;
    private final zzn zzb;
    private final Bundle zzc;

    zzgh(zzge zzge, zzn zzn, Bundle bundle) {
        this.zza = zzge;
        this.zzb = zzn;
        this.zzc = bundle;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc);
    }
}
