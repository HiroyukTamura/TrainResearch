package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;

@ShowFirstParty
@VisibleForTesting
public final class zzq extends zzi<zzq> {
    private String zztv;
    private String zztw;
    private String zztx;
    private String zzty;

    public final void setAppId(String str) {
        this.zztx = str;
    }

    public final void setAppInstallerId(String str) {
        this.zzty = str;
    }

    public final void setAppName(String str) {
        this.zztv = str;
    }

    public final void setAppVersion(String str) {
        this.zztw = str;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("appName", this.zztv);
        hashMap.put("appVersion", this.zztw);
        hashMap.put("appId", this.zztx);
        hashMap.put("appInstallerId", this.zzty);
        return zzi.zza((Object) hashMap);
    }

    /* renamed from: zza */
    public final void zzb(zzq zzq) {
        if (!TextUtils.isEmpty(this.zztv)) {
            zzq.zztv = this.zztv;
        }
        if (!TextUtils.isEmpty(this.zztw)) {
            zzq.zztw = this.zztw;
        }
        if (!TextUtils.isEmpty(this.zztx)) {
            zzq.zztx = this.zztx;
        }
        if (!TextUtils.isEmpty(this.zzty)) {
            zzq.zzty = this.zzty;
        }
    }

    public final String zzaz() {
        return this.zztv;
    }

    public final String zzba() {
        return this.zztw;
    }

    public final String zzbb() {
        return this.zztx;
    }

    public final String zzbc() {
        return this.zzty;
    }
}
