package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdcv implements zzdah<JSONObject> {
    private final Map<String, Object> zzgqb;

    public zzdcv(Map<String, Object> map) {
        this.zzgqb = map;
    }

    public final /* synthetic */ void zzs(Object obj) {
        try {
            ((JSONObject) obj).put("video_decoders", zzq.zzkw().zzj((Map<String, ?>) this.zzgqb));
        } catch (JSONException e) {
            String valueOf = String.valueOf(e.getMessage());
            zzawr.zzeg(valueOf.length() != 0 ? "Could not encode video decoder properties: ".concat(valueOf) : new String("Could not encode video decoder properties: "));
        }
    }
}
