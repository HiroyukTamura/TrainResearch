package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

final /* synthetic */ class zzdca implements Callable {
    private final zzdri zzfmu;
    private final zzdri zzfvm;

    zzdca(zzdri zzdri, zzdri zzdri2) {
        this.zzfvm = zzdri;
        this.zzfmu = zzdri2;
    }

    public final Object call() {
        return new zzdby((String) this.zzfvm.get(), (String) this.zzfmu.get());
    }
}
