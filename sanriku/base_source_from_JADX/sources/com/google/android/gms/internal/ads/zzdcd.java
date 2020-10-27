package com.google.android.gms.internal.ads;

import android.location.Location;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdcd implements zzdah<JSONObject> {
    private final Location zzmp;

    public zzdcd(Location location) {
        this.zzmp = location;
    }

    public final /* synthetic */ void zzs(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        try {
            if (this.zzmp != null) {
                JSONObject jSONObject2 = new JSONObject();
                Float valueOf = Float.valueOf(this.zzmp.getAccuracy() * 1000.0f);
                Long valueOf2 = Long.valueOf(this.zzmp.getTime() * 1000);
                Long valueOf3 = Long.valueOf((long) (this.zzmp.getLatitude() * 1.0E7d));
                Long valueOf4 = Long.valueOf((long) (this.zzmp.getLongitude() * 1.0E7d));
                jSONObject2.put("radius", valueOf);
                jSONObject2.put("lat", valueOf3);
                jSONObject2.put("long", valueOf4);
                jSONObject2.put("time", valueOf2);
                jSONObject.put("uule", jSONObject2);
            }
        } catch (JSONException e) {
            zzawr.zza("Failed adding location to the request JSON.", e);
        }
    }
}
