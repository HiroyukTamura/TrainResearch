package com.google.android.gms.internal.ads;

import org.json.JSONObject;

final /* synthetic */ class zzclv implements zzdkb {
    static final zzdkb zzgaz = new zzclv();

    private zzclv() {
    }

    public final Object apply(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        zzawr.zzeg("Ad request signals:");
        zzawr.zzeg(jSONObject.toString(2));
        return jSONObject;
    }
}
