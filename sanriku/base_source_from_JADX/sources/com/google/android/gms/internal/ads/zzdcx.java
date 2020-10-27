package com.google.android.gms.internal.ads;

import android.os.Build;
import java.util.HashMap;
import java.util.concurrent.Callable;

final /* synthetic */ class zzdcx implements Callable {
    static final Callable zzgnf = new zzdcx();

    private zzdcx() {
    }

    public final Object call() {
        HashMap hashMap = new HashMap();
        String str = (String) zzvj.zzpv().zzd(zzzz.zzcjw);
        if (str != null && !str.isEmpty()) {
            if (Build.VERSION.SDK_INT >= ((Integer) zzvj.zzpv().zzd(zzzz.zzcjx)).intValue()) {
                for (String str2 : str.split(",", -1)) {
                    hashMap.put(str2, zzazk.zzeu(str2));
                }
            }
        }
        return new zzdcv(hashMap);
    }
}
