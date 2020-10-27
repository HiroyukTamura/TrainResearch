package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.query.QueryInfo;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzyh {
    private final String zzbmy;
    private final Bundle zzchs;

    public zzyh(String str, Bundle bundle) {
        this.zzbmy = str;
        this.zzchs = bundle;
    }

    public static String zza(QueryInfo queryInfo) {
        String str = zzvj.zzpz().get(queryInfo);
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new JSONObject(str).optString("request_id", "");
        } catch (JSONException unused) {
            return "";
        }
    }

    public final String getQuery() {
        return this.zzbmy;
    }

    public final Bundle getQueryBundle() {
        return this.zzchs;
    }
}
