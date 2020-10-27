package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbor implements zzegz<zzbvt<zzbsr>> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzbta> zzfhv;

    private zzbor(zzehm<zzbta> zzehm, zzehm<Executor> zzehm2) {
        this.zzfhv = zzehm;
        this.zzenm = zzehm2;
    }

    public static zzbor zzc(zzehm<zzbta> zzehm, zzehm<Executor> zzehm2) {
        return new zzbor(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(new zzbvt(this.zzfhv.get(), this.zzenm.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
