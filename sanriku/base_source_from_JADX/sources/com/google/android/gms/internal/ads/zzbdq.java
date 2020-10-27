package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import p043jp.reifrontier.gym.RFGDef;

final class zzbdq implements Runnable {
    private final /* synthetic */ String zzdxx;
    private final /* synthetic */ String zzegq;
    private final /* synthetic */ long zzegr;
    private final /* synthetic */ long zzegs;
    private final /* synthetic */ boolean zzegt;
    private final /* synthetic */ int zzegu;
    private final /* synthetic */ int zzegv;
    private final /* synthetic */ zzbdl zzegw;
    private final /* synthetic */ int zzegx;
    private final /* synthetic */ int zzegy;

    zzbdq(zzbdl zzbdl, String str, String str2, int i, int i2, long j, long j2, boolean z, int i3, int i4) {
        this.zzegw = zzbdl;
        this.zzdxx = str;
        this.zzegq = str2;
        this.zzegx = i;
        this.zzegy = i2;
        this.zzegr = j;
        this.zzegs = j2;
        this.zzegt = z;
        this.zzegu = i3;
        this.zzegv = i4;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.zzdxx);
        hashMap.put("cachedSrc", this.zzegq);
        hashMap.put("bytesLoaded", Integer.toString(this.zzegx));
        hashMap.put("totalBytes", Integer.toString(this.zzegy));
        hashMap.put("bufferedDuration", Long.toString(this.zzegr));
        hashMap.put("totalDuration", Long.toString(this.zzegs));
        hashMap.put("cacheReady", this.zzegt ? "1" : RFGDef.DEFAULT_GYM_ID);
        hashMap.put("playerCount", Integer.toString(this.zzegu));
        hashMap.put("playerPreparedCount", Integer.toString(this.zzegv));
        this.zzegw.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
