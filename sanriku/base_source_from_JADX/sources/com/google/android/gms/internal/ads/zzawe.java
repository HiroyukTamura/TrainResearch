package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.internal.zzq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzawe {
    private String zzdmu;
    private final long zzdub;
    private final List<String> zzduc = new ArrayList();
    private final List<String> zzdud = new ArrayList();
    private final Map<String, zzalk> zzdue = new HashMap();
    private String zzduf;
    private JSONObject zzdug;
    private boolean zzduh;

    public zzawe(String str, long j) {
        JSONObject optJSONObject;
        this.zzduh = false;
        this.zzdmu = str;
        this.zzdub = j;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.zzdug = jSONObject;
                if (jSONObject.optInt(NotificationCompat.CATEGORY_STATUS, -1) != 1) {
                    this.zzduh = false;
                    zzazw.zzfc("App settings could not be fetched successfully.");
                    return;
                }
                this.zzduh = true;
                this.zzduf = this.zzdug.optString("app_id");
                JSONArray optJSONArray = this.zzdug.optJSONArray("ad_unit_id_settings");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        String optString = jSONObject2.optString("format");
                        String optString2 = jSONObject2.optString("ad_unit_id");
                        if (!TextUtils.isEmpty(optString)) {
                            if (!TextUtils.isEmpty(optString2)) {
                                if ("interstitial".equalsIgnoreCase(optString)) {
                                    this.zzdud.add(optString2);
                                } else if ("rewarded".equalsIgnoreCase(optString) && (optJSONObject = jSONObject2.optJSONObject("mediation_config")) != null) {
                                    this.zzdue.put(optString2, new zzalk(optJSONObject));
                                }
                            }
                        }
                    }
                }
                JSONArray optJSONArray2 = this.zzdug.optJSONArray("persistable_banner_ad_unit_ids");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        this.zzduc.add(optJSONArray2.optString(i2));
                    }
                }
            } catch (JSONException e) {
                zzazw.zzd("Exception occurred while processing app setting json", e);
                zzq.zzla().zza(e, "AppSettings.parseAppSettingsJson");
            }
        }
    }

    public final long zzwf() {
        return this.zzdub;
    }

    public final boolean zzwg() {
        return this.zzduh;
    }

    public final String zzwh() {
        return this.zzdmu;
    }

    public final String zzwi() {
        return this.zzduf;
    }

    public final Map<String, zzalk> zzwj() {
        return this.zzdue;
    }

    public final JSONObject zzwk() {
        return this.zzdug;
    }
}
