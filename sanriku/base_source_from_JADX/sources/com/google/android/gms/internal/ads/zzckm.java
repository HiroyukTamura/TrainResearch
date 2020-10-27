package com.google.android.gms.internal.ads;

import org.json.JSONObject;

final /* synthetic */ class zzckm implements zzdqj {
    private final zzckn zzgbl;
    private final zzud zzgbm;

    zzckm(zzckn zzckn, zzud zzud) {
        this.zzgbl = zzckn;
        this.zzgbm = zzud;
    }

    public final zzdri zzf(Object obj) {
        zzud zzud = this.zzgbm;
        String str = (String) obj;
        String str2 = zzud.zzcec;
        String str3 = zzud.zzced;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("headers", new JSONObject());
        jSONObject3.put("body", str2);
        jSONObject2.put("base_url", "");
        jSONObject2.put("signals", new JSONObject(str3));
        jSONObject.put("request", jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", new JSONObject());
        return zzdqw.zzag(jSONObject);
    }
}
