package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final class zzhr implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zzhh zzb;

    zzhr(zzhh zzhh, Bundle bundle) {
        this.zzb = zzhh;
        this.zza = bundle;
    }

    public final void run() {
        this.zzb.zzc(this.zza);
    }
}
