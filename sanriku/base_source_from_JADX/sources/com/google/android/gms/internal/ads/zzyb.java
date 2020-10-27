package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.InitializationStatus;
import java.util.HashMap;
import java.util.Map;

final /* synthetic */ class zzyb implements InitializationStatus {
    private final zzxw zzchl;

    zzyb(zzxw zzxw) {
        this.zzchl = zzxw;
    }

    public final Map getAdapterStatusMap() {
        zzxw zzxw = this.zzchl;
        HashMap hashMap = new HashMap();
        hashMap.put("com.google.android.gms.ads.MobileAds", new zzya(zzxw));
        return hashMap;
    }
}
