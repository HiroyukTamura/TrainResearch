package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import p043jp.reifrontier.gym.RFGDef;

final class zzbdo implements Runnable {
    private final /* synthetic */ String zzdxx;
    private final /* synthetic */ String zzegq;
    private final /* synthetic */ boolean zzegt = false;
    private final /* synthetic */ zzbdl zzegw;
    private final /* synthetic */ int zzegx;
    private final /* synthetic */ int zzegy;

    zzbdo(zzbdl zzbdl, String str, String str2, int i, int i2, boolean z) {
        this.zzegw = zzbdl;
        this.zzdxx = str;
        this.zzegq = str2;
        this.zzegx = i;
        this.zzegy = i2;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.zzdxx);
        hashMap.put("cachedSrc", this.zzegq);
        hashMap.put("bytesLoaded", Integer.toString(this.zzegx));
        hashMap.put("totalBytes", Integer.toString(this.zzegy));
        hashMap.put("cacheReady", this.zzegt ? "1" : RFGDef.DEFAULT_GYM_ID);
        this.zzegw.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
