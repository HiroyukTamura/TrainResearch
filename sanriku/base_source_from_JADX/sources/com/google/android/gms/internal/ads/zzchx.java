package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class zzchx {
    private ConcurrentHashMap<String, String> zzfyz;

    public zzchx(zzcie zzcie) {
        this.zzfyz = zzcie.zzaoc();
    }

    public final void zzc(zzdha zzdha) {
        String str;
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (zzdha.zzgus.zzguo.size() > 0) {
            int i = zzdha.zzgus.zzguo.get(0).zzgtl;
            if (i == 1) {
                concurrentHashMap = this.zzfyz;
                str = "banner";
            } else if (i == 2) {
                concurrentHashMap = this.zzfyz;
                str = "interstitial";
            } else if (i == 3) {
                concurrentHashMap = this.zzfyz;
                str = "native_express";
            } else if (i == 4) {
                concurrentHashMap = this.zzfyz;
                str = "native_advanced";
            } else if (i != 5) {
                concurrentHashMap = this.zzfyz;
                str = "unknown";
            } else {
                concurrentHashMap = this.zzfyz;
                str = "rewarded";
            }
            concurrentHashMap.put("ad_format", str);
        }
        if (!TextUtils.isEmpty(zzdha.zzgus.zzgup.zzdoh)) {
            this.zzfyz.put("gqi", zzdha.zzgus.zzgup.zzdoh);
        }
    }

    public final void zzj(Bundle bundle) {
        if (bundle.containsKey("cnt")) {
            this.zzfyz.put("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            this.zzfyz.put("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
    }

    public final Map<String, String> zzrm() {
        return this.zzfyz;
    }
}
