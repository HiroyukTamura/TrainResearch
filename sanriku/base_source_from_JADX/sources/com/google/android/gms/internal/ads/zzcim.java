package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

public final class zzcim implements zzegz<Set<zzbvt<zzbqx>>> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzcix> zzfyg;
    private final zzcin zzfzt;

    private zzcim(zzcin zzcin, zzehm<zzcix> zzehm, zzehm<Executor> zzehm2) {
        this.zzfzt = zzcin;
        this.zzfyg = zzehm;
        this.zzenm = zzehm2;
    }

    public static zzcim zza(zzcin zzcin, zzehm<zzcix> zzehm, zzehm<Executor> zzehm2) {
        return new zzcim(zzcin, zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzehf.zza(zzcin.zze(this.zzfyg.get(), this.zzenm.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
