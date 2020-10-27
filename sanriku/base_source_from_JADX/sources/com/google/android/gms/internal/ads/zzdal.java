package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

final /* synthetic */ class zzdal implements Callable {
    private final Object zzdel;
    private final List zzgnv;

    zzdal(List list, Object obj) {
        this.zzgnv = list;
        this.zzdel = obj;
    }

    public final Object call() {
        List<zzdri> list = this.zzgnv;
        Object obj = this.zzdel;
        for (zzdri zzdri : list) {
            zzdah zzdah = (zzdah) zzdri.get();
            if (zzdah != null) {
                zzdah.zzs(obj);
            }
        }
        return obj;
    }
}
