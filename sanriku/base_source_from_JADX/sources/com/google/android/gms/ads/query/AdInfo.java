package com.google.android.gms.ads.query;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzazw;
import org.json.JSONException;
import org.json.JSONObject;

@KeepForSdk
public class AdInfo {
    private final QueryInfo zzhas;
    private final String zzhat;

    @KeepForSdk
    public AdInfo(QueryInfo queryInfo, String str) {
        this.zzhas = queryInfo;
        this.zzhat = str;
    }

    @KeepForSdk
    public static String getRequestId(String str) {
        String str2;
        if (str == null) {
            str2 = "adString passed to AdInfo.getRequestId() cannot be null. Returning empty string.";
        } else {
            try {
                return new JSONObject(str).optString("request_id", "");
            } catch (JSONException unused) {
                str2 = "Invalid adString passed to AdInfo.getRequestId(). Returning empty string.";
            }
        }
        zzazw.zzfc(str2);
        return "";
    }

    @KeepForSdk
    public String getAdString() {
        return this.zzhat;
    }

    @KeepForSdk
    public QueryInfo getQueryInfo() {
        return this.zzhas;
    }
}
