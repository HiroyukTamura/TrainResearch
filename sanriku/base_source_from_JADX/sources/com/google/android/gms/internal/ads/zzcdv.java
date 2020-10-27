package com.google.android.gms.internal.ads;

import org.json.JSONObject;

final /* synthetic */ class zzcdv implements zzdqj {
    private final String zzdbv;
    private final zzcdt zzfwe;
    private final JSONObject zzfwi;

    zzcdv(zzcdt zzcdt, String str, JSONObject jSONObject) {
        this.zzfwe = zzcdt;
        this.zzdbv = str;
        this.zzfwi = jSONObject;
    }

    public final zzdri zzf(Object obj) {
        return this.zzfwe.zza(this.zzdbv, this.zzfwi, (zzbek) obj);
    }
}
