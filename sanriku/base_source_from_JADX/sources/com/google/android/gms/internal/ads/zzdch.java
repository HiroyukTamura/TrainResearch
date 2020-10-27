package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.zzq;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdch implements zzdah<JSONObject> {
    private Bundle zzgpw;

    public zzdch(Bundle bundle) {
        this.zzgpw = bundle;
    }

    public final /* synthetic */ void zzs(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (this.zzgpw != null) {
            try {
                zzayu.zzb(zzayu.zzb(jSONObject, "device"), "play_store").put("parental_controls", zzq.zzkw().zzd(this.zzgpw));
            } catch (JSONException unused) {
                zzawr.zzeg("Failed putting parental controls bundle.");
            }
        }
    }
}
