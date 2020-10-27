package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbpe implements zzegz<zzbvt<zzbvy>> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzbwb> zzfip;

    private zzbpe(zzehm<zzbwb> zzehm, zzehm<Executor> zzehm2) {
        this.zzfip = zzehm;
        this.zzenm = zzehm2;
    }

    public static zzbpe zzd(zzehm<zzbwb> zzehm, zzehm<Executor> zzehm2) {
        return new zzbpe(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(new zzbvt(this.zzfip.get(), this.zzenm.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
