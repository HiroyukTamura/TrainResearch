package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

public final class zzbvu implements zzegz<zzbvs> {
    private final zzehm<Context> zzenp;
    private final zzehm<Set<zzbvt<zzpz>>> zzfjp;
    private final zzehm<zzdgo> zzfkc;

    private zzbvu(zzehm<Context> zzehm, zzehm<Set<zzbvt<zzpz>>> zzehm2, zzehm<zzdgo> zzehm3) {
        this.zzenp = zzehm;
        this.zzfjp = zzehm2;
        this.zzfkc = zzehm3;
    }

    public static zzbvu zzj(zzehm<Context> zzehm, zzehm<Set<zzbvt<zzpz>>> zzehm2, zzehm<zzdgo> zzehm3) {
        return new zzbvu(zzehm, zzehm2, zzehm3);
    }

    public final /* synthetic */ Object get() {
        return new zzbvs(this.zzenp.get(), this.zzfjp.get(), this.zzfkc.get());
    }
}
