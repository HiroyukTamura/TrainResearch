package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbmo implements zzegz<zzbvt<zzpz>> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzbnr> zzfip;
    private final zzbma zzfjo;

    public zzbmo(zzbma zzbma, zzehm<zzbnr> zzehm, zzehm<Executor> zzehm2) {
        this.zzfjo = zzbma;
        this.zzfip = zzehm;
        this.zzenm = zzehm2;
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(new zzbvt(this.zzfip.get(), this.zzenm.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
