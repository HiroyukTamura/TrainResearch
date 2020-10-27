package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

public final class zzdby implements zzdah<JSONObject> {
    private String zzgps;
    private String zzgpt;

    public zzdby(String str, String str2) {
        this.zzgps = str;
        this.zzgpt = str2;
    }

    public final /* synthetic */ void zzs(Object obj) {
        try {
            JSONObject zzb = zzayu.zzb((JSONObject) obj, "pii");
            zzb.put("doritos", this.zzgps);
            zzb.put("doritos_v2", this.zzgpt);
        } catch (JSONException unused) {
            zzawr.zzeg("Failed putting doritos string.");
        }
    }
}
