package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import p043jp.reifrontier.gym.RFGDef;

final class zzbdn implements Runnable {
    private final /* synthetic */ String zzdxx;
    private final /* synthetic */ String zzegq;
    private final /* synthetic */ long zzegr;
    private final /* synthetic */ long zzegs;
    private final /* synthetic */ boolean zzegt;
    private final /* synthetic */ int zzegu;
    private final /* synthetic */ int zzegv;
    private final /* synthetic */ zzbdl zzegw;

    zzbdn(zzbdl zzbdl, String str, String str2, long j, long j2, boolean z, int i, int i2) {
        this.zzegw = zzbdl;
        this.zzdxx = str;
        this.zzegq = str2;
        this.zzegr = j;
        this.zzegs = j2;
        this.zzegt = z;
        this.zzegu = i;
        this.zzegv = i2;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.zzdxx);
        hashMap.put("cachedSrc", this.zzegq);
        hashMap.put("bufferedDuration", Long.toString(this.zzegr));
        hashMap.put("totalDuration", Long.toString(this.zzegs));
        hashMap.put("cacheReady", this.zzegt ? "1" : RFGDef.DEFAULT_GYM_ID);
        hashMap.put("playerCount", Integer.toString(this.zzegu));
        hashMap.put("playerPreparedCount", Integer.toString(this.zzegv));
        this.zzegw.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
