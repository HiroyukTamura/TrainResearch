package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcan implements zzegz<zzaur> {
    private final zzehm<Context> zzenp;
    private final zzehm<zzdhe> zzfjq;
    private final zzcaj zzfsy;

    private zzcan(zzcaj zzcaj, zzehm<Context> zzehm, zzehm<zzdhe> zzehm2) {
        this.zzfsy = zzcaj;
        this.zzenp = zzehm;
        this.zzfjq = zzehm2;
    }

    public static zzcan zza(zzcaj zzcaj, zzehm<Context> zzehm, zzehm<zzdhe> zzehm2) {
        return new zzcan(zzcaj, zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return (zzaur) zzehf.zza(new zzaur(this.zzenp.get(), this.zzfjq.get().zzgux), "Cannot return null from a non-@Nullable @Provides method");
    }
}
