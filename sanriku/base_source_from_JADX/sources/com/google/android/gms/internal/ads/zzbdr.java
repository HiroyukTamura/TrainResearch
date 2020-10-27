package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

final class zzbdr implements Runnable {
    private final /* synthetic */ String val$message;
    private final /* synthetic */ String zzdxx;
    private final /* synthetic */ String zzegq;
    private final /* synthetic */ zzbdl zzegw;
    private final /* synthetic */ String zzegz;

    zzbdr(zzbdl zzbdl, String str, String str2, String str3, String str4) {
        this.zzegw = zzbdl;
        this.zzdxx = str;
        this.zzegq = str2;
        this.zzegz = str3;
        this.val$message = str4;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheCanceled");
        hashMap.put("src", this.zzdxx);
        if (!TextUtils.isEmpty(this.zzegq)) {
            hashMap.put("cachedSrc", this.zzegq);
        }
        hashMap.put("type", zzbdl.zzfn(this.zzegz));
        hashMap.put("reason", this.zzegz);
        if (!TextUtils.isEmpty(this.val$message)) {
            hashMap.put("message", this.val$message);
        }
        this.zzegw.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
