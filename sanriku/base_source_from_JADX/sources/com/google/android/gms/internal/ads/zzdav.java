package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdav implements zzdah<JSONObject> {
    private final AdvertisingIdClient.Info zzgoy;
    private final String zzgoz;

    public zzdav(AdvertisingIdClient.Info info, String str) {
        this.zzgoy = info;
        this.zzgoz = str;
    }

    public final /* synthetic */ void zzs(Object obj) {
        try {
            JSONObject zzb = zzayu.zzb((JSONObject) obj, "pii");
            if (this.zzgoy == null || TextUtils.isEmpty(this.zzgoy.getId())) {
                zzb.put("pdid", this.zzgoz);
                zzb.put("pdidtype", "ssaid");
                return;
            }
            zzb.put("rdid", this.zzgoy.getId());
            zzb.put("is_lat", this.zzgoy.isLimitAdTrackingEnabled());
            zzb.put("idtype", "adid");
        } catch (JSONException e) {
            zzawr.zza("Failed putting Ad ID.", e);
        }
    }
}
