package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

final /* synthetic */ class zzclr implements Callable {
    private final zzdri zzfmu;
    private final zzdri zzfvm;

    zzclr(zzdri zzdri, zzdri zzdri2) {
        this.zzfvm = zzdri;
        this.zzfmu = zzdri2;
    }

    public final Object call() {
        return new zzcmg((JSONObject) this.zzfvm.get(), (zzarp) this.zzfmu.get());
    }
}
