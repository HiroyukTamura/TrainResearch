package com.google.android.gms.internal.ads;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

final class zzdbt implements zzdak<zzdah<JSONObject>> {
    private final JSONObject zzgpp;

    zzdbt(Context context) {
        this.zzgpp = zzarv.zzy(context);
    }

    public final zzdri<zzdah<JSONObject>> zzaqa() {
        return zzdqw.zzag(new zzdbw(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(JSONObject jSONObject) {
        try {
            jSONObject.put("gms_sdk_env", this.zzgpp);
        } catch (JSONException unused) {
            zzawr.zzeg("Failed putting version constants.");
        }
    }
}
