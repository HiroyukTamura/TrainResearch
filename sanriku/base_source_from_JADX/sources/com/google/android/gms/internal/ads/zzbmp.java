package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbmp implements zzegz<zzaur> {
    private final zzehm<Context> zzenp;
    private final zzbma zzfjo;
    private final zzehm<zzdhe> zzfjq;

    public zzbmp(zzbma zzbma, zzehm<Context> zzehm, zzehm<zzdhe> zzehm2) {
        this.zzfjo = zzbma;
        this.zzenp = zzehm;
        this.zzfjq = zzehm2;
    }

    public final /* synthetic */ Object get() {
        return (zzaur) zzehf.zza(new zzaur(this.zzenp.get(), this.zzfjq.get().zzgux), "Cannot return null from a non-@Nullable @Provides method");
    }
}
