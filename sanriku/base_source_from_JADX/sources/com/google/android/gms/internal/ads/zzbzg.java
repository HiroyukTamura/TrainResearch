package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;

public final class zzbzg implements zzegz<zzbvs> {
    private final zzehm<Context> zzenp;
    private final zzehm<zzdgo> zzfkc;

    public zzbzg(zzehm<Context> zzehm, zzehm<zzdgo> zzehm2) {
        this.zzenp = zzehm;
        this.zzfkc = zzehm2;
    }

    public final /* synthetic */ Object get() {
        return (zzbvs) zzehf.zza(new zzbvs(this.zzenp.get(), new HashSet(), this.zzfkc.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
