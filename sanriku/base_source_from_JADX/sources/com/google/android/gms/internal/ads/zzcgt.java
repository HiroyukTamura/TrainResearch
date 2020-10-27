package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

public final class zzcgt implements zzegz<Set<zzbvt<zzdla>>> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzchj> zzfhv;

    private zzcgt(zzehm<Executor> zzehm, zzehm<zzchj> zzehm2) {
        this.zzenm = zzehm;
        this.zzfhv = zzehm2;
    }

    public static zzcgt zzz(zzehm<Executor> zzehm, zzehm<zzchj> zzehm2) {
        return new zzcgt(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        Executor executor = this.zzenm.get();
        return (Set) zzehf.zza(((Boolean) zzvj.zzpv().zzd(zzzz.zzcqq)).booleanValue() ? Collections.singleton(new zzbvt(this.zzfhv.get(), executor)) : Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
