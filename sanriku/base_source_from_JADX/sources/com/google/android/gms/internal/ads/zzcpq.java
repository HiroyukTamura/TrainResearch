package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

final /* synthetic */ class zzcpq implements Callable {
    private final zzdri zzflc;
    private final zzdri zzfmu;
    private final zzdha zzgfq;
    private final zzcpn zzgfx;
    private final zzdgo zzggc;
    private final JSONObject zzggd;

    zzcpq(zzcpn zzcpn, zzdri zzdri, zzdri zzdri2, zzdha zzdha, zzdgo zzdgo, JSONObject jSONObject) {
        this.zzgfx = zzcpn;
        this.zzfmu = zzdri;
        this.zzflc = zzdri2;
        this.zzgfq = zzdha;
        this.zzggc = zzdgo;
        this.zzggd = jSONObject;
    }

    public final Object call() {
        return this.zzgfx.zza(this.zzfmu, this.zzflc, this.zzgfq, this.zzggc, this.zzggd);
    }
}
