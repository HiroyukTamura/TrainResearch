package com.google.android.gms.internal.ads;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

public final class zzcck {
    private final Executor executor;
    private final zzcca zzfus;

    public zzcck(Executor executor2, zzcca zzcca) {
        this.executor = executor2;
        this.zzfus = zzcca;
    }

    public final zzdri<List<zzccp>> zzg(JSONObject jSONObject, String str) {
        zzdri<O> zzdri;
        String optString;
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return zzdqw.zzag(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (!(optJSONObject == null || (optString = optJSONObject.optString(AppMeasurementSdk.ConditionalUserProperty.NAME)) == null)) {
                String optString2 = optJSONObject.optString("type");
                char c = "string".equals(optString2) ? 1 : "image".equals(optString2) ? (char) 2 : 0;
                if (c == 1) {
                    zzdri = zzdqw.zzag(new zzccp(optString, optJSONObject.optString("string_value")));
                } else if (c == 2) {
                    zzdri = zzdqw.zzb(this.zzfus.zzc(optJSONObject, "image_value"), new zzccm(optString), this.executor);
                }
                arrayList.add(zzdri);
            }
            zzdri = zzdqw.zzag(null);
            arrayList.add(zzdri);
        }
        return zzdqw.zzb(zzdqw.zzi(arrayList), zzccn.zzdsc, this.executor);
    }
}
