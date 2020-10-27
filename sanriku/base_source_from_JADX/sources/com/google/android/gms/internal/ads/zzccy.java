package com.google.android.gms.internal.ads;

import java.util.HashMap;
import p043jp.reifrontier.gym.RFGDef;

final /* synthetic */ class zzccy implements zzpz {
    private final zzbek zzelg;

    zzccy(zzbek zzbek) {
        this.zzelg = zzbek;
    }

    public final void zza(zzqa zzqa) {
        zzbek zzbek = this.zzelg;
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", zzqa.zzbot ? "1" : RFGDef.DEFAULT_GYM_ID);
        zzbek.zza("onAdVisibilityChanged", hashMap);
    }
}
