package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

final /* synthetic */ class zzclq implements Callable {
    private final zzdri zzflc;
    private final zzdri zzfmu;
    private final zzdri zzfvm;

    zzclq(zzdri zzdri, zzdri zzdri2, zzdri zzdri3) {
        this.zzfvm = zzdri;
        this.zzfmu = zzdri2;
        this.zzflc = zzdri3;
    }

    public final Object call() {
        return new zzcmc((zzcmj) this.zzfvm.get(), (JSONObject) this.zzfmu.get(), (zzarp) this.zzflc.get());
    }
}
