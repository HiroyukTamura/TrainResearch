package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdbf implements zzdah<JSONObject> {
    private final JSONObject zzgpe;

    public zzdbf(JSONObject jSONObject) {
        this.zzgpe = jSONObject;
    }

    public final /* synthetic */ void zzs(Object obj) {
        try {
            JSONObject zzb = zzayu.zzb((JSONObject) obj, "content_info");
            JSONObject jSONObject = this.zzgpe;
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                zzb.put(next, jSONObject.get(next));
            }
        } catch (JSONException unused) {
            zzawr.zzeg("Failed putting app indexing json.");
        }
    }
}
