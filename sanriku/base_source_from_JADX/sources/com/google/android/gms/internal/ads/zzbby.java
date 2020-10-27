package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

public final class zzbby {
    public final boolean zzedr;
    public final int zzeds;
    public final int zzedt;
    public final int zzedu;
    private final String zzedv;
    public final int zzedw;
    public final int zzedx;
    public final int zzedy;
    public final int zzedz;
    public final boolean zzeea;
    public final int zzeeb;

    public zzbby(String str) {
        JSONObject jSONObject = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
            }
        }
        this.zzedr = zza(jSONObject, "aggressive_media_codec_release", zzzz.zzcju);
        this.zzeds = zzb(jSONObject, "byte_buffer_precache_limit", zzzz.zzcjd);
        this.zzedt = zzb(jSONObject, "exo_cache_buffer_size", zzzz.zzcjj);
        this.zzedu = zzb(jSONObject, "exo_connect_timeout_millis", zzzz.zzciz);
        this.zzedv = zzc(jSONObject, "exo_player_version", zzzz.zzciy);
        this.zzedw = zzb(jSONObject, "exo_read_timeout_millis", zzzz.zzcja);
        this.zzedx = zzb(jSONObject, "load_check_interval_bytes", zzzz.zzcjb);
        this.zzedy = zzb(jSONObject, "player_precache_limit", zzzz.zzcjc);
        this.zzedz = zzb(jSONObject, "socket_receive_buffer_size", zzzz.zzcje);
        this.zzeea = zza(jSONObject, "use_cache_data_source", zzzz.zzcpw);
        this.zzeeb = zzb(jSONObject, "min_retry_count", zzzz.zzcjg);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.google.android.gms.internal.ads.zzzk<java.lang.Boolean>, com.google.android.gms.internal.ads.zzzk] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean zza(org.json.JSONObject r1, java.lang.String r2, com.google.android.gms.internal.ads.zzzk<java.lang.Boolean> r3) {
        /*
            com.google.android.gms.internal.ads.zzzv r0 = com.google.android.gms.internal.ads.zzvj.zzpv()
            java.lang.Object r3 = r0.zzd(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            boolean r1 = zza((org.json.JSONObject) r1, (java.lang.String) r2, (boolean) r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbby.zza(org.json.JSONObject, java.lang.String, com.google.android.gms.internal.ads.zzzk):boolean");
    }

    private static boolean zza(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject != null) {
            try {
                return jSONObject.getBoolean(str);
            } catch (JSONException unused) {
            }
        }
        return z;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.gms.internal.ads.zzzk<java.lang.Integer>, com.google.android.gms.internal.ads.zzzk] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzb(org.json.JSONObject r0, java.lang.String r1, com.google.android.gms.internal.ads.zzzk<java.lang.Integer> r2) {
        /*
            if (r0 == 0) goto L_0x0007
            int r0 = r0.getInt(r1)     // Catch:{ JSONException -> 0x0007 }
            return r0
        L_0x0007:
            com.google.android.gms.internal.ads.zzzv r0 = com.google.android.gms.internal.ads.zzvj.zzpv()
            java.lang.Object r0 = r0.zzd(r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbby.zzb(org.json.JSONObject, java.lang.String, com.google.android.gms.internal.ads.zzzk):int");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.gms.internal.ads.zzzk<java.lang.String>, com.google.android.gms.internal.ads.zzzk] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String zzc(org.json.JSONObject r0, java.lang.String r1, com.google.android.gms.internal.ads.zzzk<java.lang.String> r2) {
        /*
            if (r0 == 0) goto L_0x0007
            java.lang.String r0 = r0.getString(r1)     // Catch:{ JSONException -> 0x0007 }
            return r0
        L_0x0007:
            com.google.android.gms.internal.ads.zzzv r0 = com.google.android.gms.internal.ads.zzvj.zzpv()
            java.lang.Object r0 = r0.zzd(r2)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbby.zzc(org.json.JSONObject, java.lang.String, com.google.android.gms.internal.ads.zzzk):java.lang.String");
    }
}
