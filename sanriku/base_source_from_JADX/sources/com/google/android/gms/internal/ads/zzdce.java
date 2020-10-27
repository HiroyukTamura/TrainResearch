package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

final /* synthetic */ class zzdce implements Callable {
    private final zzdcb zzgpv;

    zzdce(zzdcb zzdcb) {
        this.zzgpv = zzdcb;
    }

    public final Object call() {
        zzdcb zzdcb = this.zzgpv;
        return new zzdcc(zzdcb.zzgpu.zze(zzdcb.zzdmi));
    }
}
