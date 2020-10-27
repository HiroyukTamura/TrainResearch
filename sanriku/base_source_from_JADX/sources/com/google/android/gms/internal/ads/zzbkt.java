package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbkt implements zzegz<zzbkg> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzpu> zzfhx;
    private final zzehm<zzaku> zzfhy;

    private zzbkt(zzehm<zzpu> zzehm, zzehm<zzaku> zzehm2, zzehm<Executor> zzehm3) {
        this.zzfhx = zzehm;
        this.zzfhy = zzehm2;
        this.zzenm = zzehm3;
    }

    public static zzbkt zzb(zzehm<zzpu> zzehm, zzehm<zzaku> zzehm2, zzehm<Executor> zzehm3) {
        return new zzbkt(zzehm, zzehm2, zzehm3);
    }

    public final /* synthetic */ Object get() {
        return (zzbkg) zzehf.zza(new zzbkg(this.zzfhx.get().zzkt(), this.zzfhy.get(), this.zzenm.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
