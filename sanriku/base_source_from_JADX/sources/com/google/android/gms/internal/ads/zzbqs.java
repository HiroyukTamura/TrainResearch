package com.google.android.gms.internal.ads;

import org.json.JSONException;

public final class zzbqs extends zzxj {
    private final String zzfna;
    private final String zzfnb;

    public zzbqs(zzdgo zzdgo, String str) {
        String str2 = null;
        this.zzfnb = zzdgo == null ? null : zzdgo.zzfnb;
        str2 = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str) ? zzb(zzdgo) : str2;
        this.zzfna = str2 != null ? str2 : str;
    }

    private static String zzb(zzdgo zzdgo) {
        try {
            return zzdgo.zzgtu.getString("class_name");
        } catch (JSONException unused) {
            return null;
        }
    }

    public final String getMediationAdapterClassName() {
        return this.zzfna;
    }

    public final String getResponseId() {
        return this.zzfnb;
    }
}
