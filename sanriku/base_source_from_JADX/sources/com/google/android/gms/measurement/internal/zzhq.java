package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final class zzhq implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zzhh zzb;

    zzhq(zzhh zzhh, Bundle bundle) {
        this.zzb = zzhh;
        this.zza = bundle;
    }

    public final void run() {
        this.zzb.zzd(this.zza);
    }
}
