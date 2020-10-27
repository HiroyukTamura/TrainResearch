package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

final /* synthetic */ class zzdct implements zzdah {
    static final zzdah zzgof = new zzdct();

    private zzdct() {
    }

    public final void zzs(Object obj) {
        try {
            ((JSONObject) obj).getJSONObject("sdk_env").put("container_version", 12451009);
        } catch (JSONException unused) {
        }
    }
}
