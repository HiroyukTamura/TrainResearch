package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzafg implements zzaga<Object> {
    private final zzafj zzczu;

    public zzafg(zzafj zzafj) {
        this.zzczu = zzafj;
    }

    public final void zza(Object obj, Map<String, String> map) {
        if (this.zzczu != null) {
            String str = map.get(AppMeasurementSdk.ConditionalUserProperty.NAME);
            if (str == null) {
                zzazw.zzfb("Ad metadata with no name parameter.");
                str = "";
            }
            Bundle bundle = null;
            if (map.containsKey("info")) {
                try {
                    bundle = zzayu.zzh(new JSONObject(map.get("info")));
                } catch (JSONException e) {
                    zzazw.zzc("Failed to convert ad metadata to JSON.", e);
                }
            }
            if (bundle == null) {
                zzazw.zzfa("Failed to convert ad metadata to Bundle.");
            } else {
                this.zzczu.zza(str, bundle);
            }
        }
    }
}
