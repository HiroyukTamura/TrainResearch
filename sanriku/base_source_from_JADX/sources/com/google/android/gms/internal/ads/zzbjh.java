package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;

public final class zzbjh implements zzegz<zzdly> {
    private final zzehm<Context> zzenp;

    public zzbjh(zzehm<Context> zzehm) {
        this.zzenp = zzehm;
    }

    public final /* synthetic */ Object get() {
        return (zzdly) zzehf.zza(new zzdly(this.zzenp.get(), zzq.zzlk().zzxx()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
