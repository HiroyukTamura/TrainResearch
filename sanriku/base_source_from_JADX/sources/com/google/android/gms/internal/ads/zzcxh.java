package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzcxh implements zzegz<zzcxg<zzdan>> {
    private final zzehm<zzdaq> zzeoz;
    private final zzehm<Clock> zzfhq;

    public zzcxh(zzehm<zzdaq> zzehm, zzehm<Clock> zzehm2) {
        this.zzeoz = zzehm;
        this.zzfhq = zzehm2;
    }

    public final /* synthetic */ Object get() {
        return (zzcxg) zzehf.zza(new zzcxg(this.zzeoz.get(), zzabf.zzcvx.get().longValue(), this.zzfhq.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
