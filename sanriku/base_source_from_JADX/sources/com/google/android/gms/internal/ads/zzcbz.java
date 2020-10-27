package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.Callable;
import org.json.JSONObject;
import p009e.p010a.p011a.p012a.C0681a;

final /* synthetic */ class zzcbz implements Callable {
    private final zzdgo zzfjm;
    private final zzcbw zzfuu;
    private final zzdha zzfvc;
    private final JSONObject zzfvd;

    zzcbz(zzcbw zzcbw, zzdha zzdha, zzdgo zzdgo, JSONObject jSONObject) {
        this.zzfuu = zzcbw;
        this.zzfvc = zzdha;
        this.zzfjm = zzdgo;
        this.zzfvd = jSONObject;
    }

    public final Object call() {
        zzdha zzdha = this.zzfvc;
        zzdgo zzdgo = this.zzfjm;
        JSONObject jSONObject = this.zzfvd;
        zzbzx zzbzx = new zzbzx();
        zzbzx.zzdr(jSONObject.optInt("template_id", -1));
        zzbzx.zzfy(jSONObject.optString("custom_template_id"));
        JSONObject optJSONObject = jSONObject.optJSONObject("omid_settings");
        zzbzx.zzfz(optJSONObject != null ? optJSONObject.optString("omid_partner_name") : null);
        zzdhe zzdhe = zzdha.zzgur.zzfll;
        if (zzdhe.zzguy.contains(Integer.toString(zzbzx.zzakw()))) {
            if (zzbzx.zzakw() == 3) {
                if (zzbzx.getCustomTemplateId() == null) {
                    throw new zzcqm("No custom template id for custom template ad response.", 0);
                } else if (!zzdhe.zzguz.contains(zzbzx.getCustomTemplateId())) {
                    throw new zzcqm("Unexpected custom template id in the response.", 0);
                }
            }
            zzbzx.setStarRating(jSONObject.optDouble("rating", -1.0d));
            String optString = jSONObject.optString("headline", (String) null);
            if (zzdgo.zzdpp) {
                zzq.zzkw();
                String zzxj = zzaxa.zzxj();
                optString = C0681a.m313a(C0681a.m336b(optString, C0681a.m336b(zzxj, 3)), zzxj, " : ", optString);
            }
            zzbzx.zzn("headline", optString);
            zzbzx.zzn("body", jSONObject.optString("body", (String) null));
            zzbzx.zzn("call_to_action", jSONObject.optString("call_to_action", (String) null));
            zzbzx.zzn("store", jSONObject.optString("store", (String) null));
            zzbzx.zzn(FirebaseAnalytics.Param.PRICE, jSONObject.optString(FirebaseAnalytics.Param.PRICE, (String) null));
            zzbzx.zzn("advertiser", jSONObject.optString("advertiser", (String) null));
            return zzbzx;
        }
        throw new zzcqm(C0681a.m309a(32, "Invalid template ID: ", zzbzx.zzakw()), 0);
    }
}
