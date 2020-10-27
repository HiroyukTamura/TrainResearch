package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

public final class zzdbb implements zzdah<JSONObject> {
    private final String zzgpc;

    public zzdbb(String str) {
        this.zzgpc = str;
    }

    public final /* synthetic */ void zzs(Object obj) {
        try {
            ((JSONObject) obj).put("ms", this.zzgpc);
        } catch (JSONException e) {
            zzawr.zza("Failed putting Ad ID.", e);
        }
    }
}
