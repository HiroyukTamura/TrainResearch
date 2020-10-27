package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

public final class zzcaa extends zzcab {
    private final boolean zzdfh;
    private final boolean zzdfi;
    private final boolean zzdos;
    private final JSONObject zzfsm;
    private final boolean zzfsn;

    public zzcaa(zzdgo zzdgo, JSONObject jSONObject) {
        super(zzdgo);
        this.zzfsm = zzayu.zza(jSONObject, "tracking_urls_and_actions", "active_view");
        boolean z = false;
        this.zzdfi = zzayu.zza(false, jSONObject, "allow_pub_owned_ad_view");
        this.zzdfh = zzayu.zza(false, jSONObject, "attribution", "allow_pub_rendering");
        this.zzdos = zzayu.zza(false, jSONObject, "enable_omid");
        if (!(jSONObject == null || jSONObject.optJSONObject("overlay") == null)) {
            z = true;
        }
        this.zzfsn = z;
    }

    public final boolean zzaks() {
        return this.zzdos;
    }

    public final JSONObject zzalh() {
        JSONObject jSONObject = this.zzfsm;
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            return new JSONObject(this.zzfso.zzdob);
        } catch (JSONException unused) {
            return null;
        }
    }

    public final boolean zzali() {
        return this.zzfsn;
    }

    public final boolean zzalj() {
        return this.zzdfi;
    }

    public final boolean zzalk() {
        return this.zzdfh;
    }
}
