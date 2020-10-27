package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.ads.zzabd;
import com.google.android.gms.internal.ads.zzazw;
import com.google.android.gms.internal.ads.zzazz;
import com.google.android.gms.internal.ads.zzdab;
import com.google.android.gms.internal.ads.zzuj;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;

final class zzo {
    private final String zzbmw;
    private final Map<String, String> zzbmx = new TreeMap();
    private String zzbmy;
    private String zzbmz;
    private final Context zzvf;

    public zzo(Context context, String str) {
        this.zzvf = context.getApplicationContext();
        this.zzbmw = str;
    }

    public final String getQuery() {
        return this.zzbmy;
    }

    public final void zza(zzuj zzuj, zzazz zzazz) {
        this.zzbmy = zzuj.zzcel.zzbmy;
        Bundle bundle = zzuj.zzcen;
        Bundle bundle2 = bundle != null ? bundle.getBundle(AdMobAdapter.class.getName()) : null;
        if (bundle2 != null) {
            String str = zzabd.zzcvq.get();
            for (String str2 : bundle2.keySet()) {
                if (str.equals(str2)) {
                    this.zzbmz = bundle2.getString(str2);
                } else if (str2.startsWith("csa_")) {
                    this.zzbmx.put(str2.substring(4), bundle2.getString(str2));
                }
            }
            this.zzbmx.put("SDKVersion", zzazz.zzbnd);
            if (zzabd.zzcvo.get().booleanValue()) {
                try {
                    Bundle zza = zzdab.zza(this.zzvf, new JSONArray(zzabd.zzcvp.get()));
                    for (String str3 : zza.keySet()) {
                        this.zzbmx.put(str3, zza.get(str3).toString());
                    }
                } catch (JSONException e) {
                    zzazw.zzc("Flag gads:afs:csa_tcf_data_to_collect not a valid JSON array", e);
                }
            }
        }
    }

    public final String zzkn() {
        return this.zzbmz;
    }

    public final String zzko() {
        return this.zzbmw;
    }

    public final Map<String, String> zzkp() {
        return this.zzbmx;
    }
}
