package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdab implements zzdak<zzdah<Bundle>> {
    private final zzdrh zzfur;
    private final Context zzzo;

    zzdab(zzdrh zzdrh, Context context) {
        this.zzfur = zzdrh;
        this.zzzo = context;
    }

    public static Bundle zza(Context context, JSONArray jSONArray) {
        Object obj;
        SharedPreferences sharedPreferences;
        String str;
        Bundle bundle = new Bundle();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            String optString = optJSONObject.optString("bk");
            String optString2 = optJSONObject.optString("sk");
            int optInt = optJSONObject.optInt("type", -1);
            int i2 = optInt != 0 ? optInt != 1 ? optInt != 2 ? 0 : zzdaf.zzgol : zzdaf.zzgok : zzdaf.zzgoj;
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && i2 != 0) {
                String[] split = optString2.split("/");
                if (split.length > 2 || split.length == 0) {
                    obj = null;
                } else {
                    if (split.length == 1) {
                        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                        str = split[0];
                    } else {
                        sharedPreferences = context.getSharedPreferences(split[0], 0);
                        str = split[1];
                    }
                    obj = sharedPreferences.getAll().get(str);
                }
                if (obj != null) {
                    int i3 = zzdag.zzgon[i2 - 1];
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3 && (obj instanceof Boolean)) {
                                bundle.putBoolean(optString, ((Boolean) obj).booleanValue());
                            }
                        } else if (obj instanceof Integer) {
                            bundle.putInt(optString, ((Integer) obj).intValue());
                        } else if (obj instanceof Long) {
                            bundle.putLong(optString, ((Long) obj).longValue());
                        } else if (obj instanceof Float) {
                            bundle.putFloat(optString, ((Float) obj).floatValue());
                        }
                    } else if (obj instanceof String) {
                        bundle.putString(optString, (String) obj);
                    }
                }
            }
        }
        return bundle;
    }

    public final zzdri<zzdah<Bundle>> zzaqa() {
        return this.zzfur.zzd(new zzdae(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdah zzaqp() throws Exception {
        String str = (String) zzvj.zzpv().zzd(zzzz.zzcsv);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new zzdad(zza(this.zzzo, new JSONArray(str)));
        } catch (JSONException e) {
            zzazw.zzb("JSON parsing error", e);
            return null;
        }
    }
}
