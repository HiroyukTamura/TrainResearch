package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzbve implements zzegz<zzcqi> {
    private final zzehm<zzcqk> zzerm;
    private final zzehm<Clock> zzfhq;
    private final zzbuj zzfoh;

    private zzbve(zzbuj zzbuj, zzehm<Clock> zzehm, zzehm<zzcqk> zzehm2) {
        this.zzfoh = zzbuj;
        this.zzfhq = zzehm;
        this.zzerm = zzehm2;
    }

    public static zzbve zza(zzbuj zzbuj, zzehm<Clock> zzehm, zzehm<zzcqk> zzehm2) {
        return new zzbve(zzbuj, zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return (zzcqi) zzehf.zza(this.zzfoh.zza(this.zzfhq.get(), this.zzerm.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
