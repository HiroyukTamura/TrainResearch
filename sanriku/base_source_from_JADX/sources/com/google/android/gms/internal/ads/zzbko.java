package com.google.android.gms.internal.ads;

import org.json.JSONObject;

final /* synthetic */ class zzbko implements Runnable {
    private final zzbek zzelg;
    private final JSONObject zzfhd;

    zzbko(zzbek zzbek, JSONObject jSONObject) {
        this.zzelg = zzbek;
        this.zzfhd = jSONObject;
    }

    public final void run() {
        this.zzelg.zza("AFMA_updateActiveView", this.zzfhd);
    }
}
