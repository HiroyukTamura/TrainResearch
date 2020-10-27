package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdbj implements zzdah<JSONObject> {
    private String zzgpi;

    public zzdbj(String str) {
        this.zzgpi = str;
    }

    public final /* synthetic */ void zzs(Object obj) {
        try {
            JSONObject zzb = zzayu.zzb((JSONObject) obj, "pii");
            if (!TextUtils.isEmpty(this.zzgpi)) {
                zzb.put("attok", this.zzgpi);
            }
        } catch (JSONException e) {
            zzawr.zza("Failed putting attestation token.", e);
        }
    }
}
