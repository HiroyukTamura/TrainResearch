package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

final /* synthetic */ class zzbqf implements Callable {
    private final zzbqc zzfmt;
    private final zzdri zzfmu;

    zzbqf(zzbqc zzbqc, zzdri zzdri) {
        this.zzfmt = zzbqc;
        this.zzfmu = zzdri;
    }

    public final Object call() {
        return this.zzfmt.zzc(this.zzfmu);
    }
}
