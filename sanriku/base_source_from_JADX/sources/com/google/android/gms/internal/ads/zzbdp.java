package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

final class zzbdp implements Runnable {
    private final /* synthetic */ String zzdxx;
    private final /* synthetic */ String zzegq;
    private final /* synthetic */ zzbdl zzegw;
    private final /* synthetic */ int zzegy;

    zzbdp(zzbdl zzbdl, String str, String str2, int i) {
        this.zzegw = zzbdl;
        this.zzdxx = str;
        this.zzegq = str2;
        this.zzegy = i;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheComplete");
        hashMap.put("src", this.zzdxx);
        hashMap.put("cachedSrc", this.zzegq);
        hashMap.put("totalBytes", Integer.toString(this.zzegy));
        this.zzegw.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
