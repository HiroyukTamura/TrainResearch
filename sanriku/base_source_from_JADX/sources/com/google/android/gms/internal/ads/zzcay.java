package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzcay implements zzegz<zzcaw> {
    private final zzehm<zzcdt> zzezj;
    private final zzehm<Clock> zzfhq;

    public zzcay(zzehm<zzcdt> zzehm, zzehm<Clock> zzehm2) {
        this.zzezj = zzehm;
        this.zzfhq = zzehm2;
    }

    public final /* synthetic */ Object get() {
        return new zzcaw(this.zzezj.get(), this.zzfhq.get());
    }
}
