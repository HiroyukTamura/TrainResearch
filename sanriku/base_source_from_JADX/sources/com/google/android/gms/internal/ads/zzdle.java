package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzdle implements zzegz<zzakp> {
    private final zzehm<Context> zzenp;
    private final zzehm<zzazz> zzfnd;
    private final zzdlb zzhap;

    public zzdle(zzdlb zzdlb, zzehm<Context> zzehm, zzehm<zzazz> zzehm2) {
        this.zzhap = zzdlb;
        this.zzenp = zzehm;
        this.zzfnd = zzehm2;
    }

    public final /* synthetic */ Object get() {
        return (zzakp) zzehf.zza(new zzakg().zzb(this.zzenp.get(), this.zzfnd.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
