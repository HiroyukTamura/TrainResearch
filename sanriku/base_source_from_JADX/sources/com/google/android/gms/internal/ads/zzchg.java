package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

public final class zzchg implements zzegz<Set<zzbvt<zzdla>>> {
    private final zzehm<Executor> zzenm;
    private final zzehm<Context> zzenp;
    private final zzehm<String> zzfyk;
    private final zzehm<Map<zzdkr, zzchl>> zzfyl;

    public zzchg(zzehm<String> zzehm, zzehm<Context> zzehm2, zzehm<Executor> zzehm3, zzehm<Map<zzdkr, zzchl>> zzehm4) {
        this.zzfyk = zzehm;
        this.zzenp = zzehm2;
        this.zzenm = zzehm3;
        this.zzfyl = zzehm4;
    }

    public final /* synthetic */ Object get() {
        Set set;
        String str = this.zzfyk.get();
        Context context = this.zzenp.get();
        Executor executor = this.zzenm.get();
        Map map = this.zzfyl.get();
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcqq)).booleanValue()) {
            zzst zzst = new zzst(new zzsy(context));
            zzst.zza((zzsw) new zzchi(str));
            set = Collections.singleton(new zzbvt(new zzchj(zzst, map), executor));
        } else {
            set = Collections.emptySet();
        }
        return (Set) zzehf.zza(set, "Cannot return null from a non-@Nullable @Provides method");
    }
}
