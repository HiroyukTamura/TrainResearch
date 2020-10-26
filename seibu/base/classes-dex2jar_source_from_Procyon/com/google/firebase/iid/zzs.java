// 
// Decompiled by Procyon v0.5.36
// 

package com.google.firebase.iid;

import android.text.TextUtils;
import org.json.JSONException;
import android.util.Log;
import org.json.JSONObject;
import java.util.concurrent.TimeUnit;

final class zzs
{
    private static final long zzckR;
    private long timestamp;
    final String zzbPJ;
    private String zzbgW;
    
    static {
        zzckR = TimeUnit.DAYS.toMillis(7L);
    }
    
    private zzs(final String zzbPJ, final String zzbgW, final long timestamp) {
        this.zzbPJ = zzbPJ;
        this.zzbgW = zzbgW;
        this.timestamp = timestamp;
    }
    
    static String zzc(String s, final String s2, final long n) {
        try {
            final JSONObject jsonObject = new JSONObject();
            jsonObject.put("token", (Object)s);
            jsonObject.put("appVersion", (Object)s2);
            jsonObject.put("timestamp", n);
            s = jsonObject.toString();
            return s;
        }
        catch (JSONException obj) {
            s = String.valueOf(obj);
            Log.w("InstanceID/Store", new StringBuilder(String.valueOf(s).length() + 24).append("Failed to encode token: ").append(s).toString());
            return null;
        }
    }
    
    static zzs zzho(String value) {
        if (TextUtils.isEmpty((CharSequence)value)) {
            return null;
        }
        if (value.startsWith("{")) {
            try {
                final JSONObject jsonObject = new JSONObject(value);
                return new zzs(jsonObject.getString("token"), jsonObject.getString("appVersion"), jsonObject.getLong("timestamp"));
            }
            catch (JSONException obj) {
                value = String.valueOf(obj);
                Log.w("InstanceID/Store", new StringBuilder(String.valueOf(value).length() + 23).append("Failed to parse token: ").append(value).toString());
                return null;
            }
        }
        return new zzs(value, null, 0L);
    }
    
    final boolean zzhp(final String s) {
        return System.currentTimeMillis() > this.timestamp + zzs.zzckR || !s.equals(this.zzbgW);
    }
}
