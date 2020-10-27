package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbpj implements zzegz<zzbvt<zzbrp>> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzbke> zzfip;

    private zzbpj(zzehm<zzbke> zzehm, zzehm<Executor> zzehm2) {
        this.zzfip = zzehm;
        this.zzenm = zzehm2;
    }

    public static zzbpj zzi(zzehm<zzbke> zzehm, zzehm<Executor> zzehm2) {
        return new zzbpj(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(new zzbvt(this.zzfip.get(), this.zzenm.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
