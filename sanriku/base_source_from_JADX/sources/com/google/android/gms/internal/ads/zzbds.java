package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

final class zzbds implements Runnable {
    private final /* synthetic */ String zzdxx;
    private final /* synthetic */ String zzegq;
    private final /* synthetic */ long zzegs;
    private final /* synthetic */ zzbdl zzegw;

    zzbds(zzbdl zzbdl, String str, String str2, long j) {
        this.zzegw = zzbdl;
        this.zzdxx = str;
        this.zzegq = str2;
        this.zzegs = j;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheComplete");
        hashMap.put("src", this.zzdxx);
        hashMap.put("cachedSrc", this.zzegq);
        hashMap.put("totalDuration", Long.toString(this.zzegs));
        this.zzegw.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
