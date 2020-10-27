package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzcxi implements zzegz<zzcxg<zzcwx>> {
    private final zzehm<Clock> zzfhq;
    private final zzehm<zzcxa> zzgmx;

    public zzcxi(zzehm<zzcxa> zzehm, zzehm<Clock> zzehm2) {
        this.zzgmx = zzehm;
        this.zzfhq = zzehm2;
    }

    public final /* synthetic */ Object get() {
        return (zzcxg) zzehf.zza(new zzcxg(this.zzgmx.get(), 10000, this.zzfhq.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
