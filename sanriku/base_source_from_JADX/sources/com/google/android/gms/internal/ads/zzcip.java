package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

public final class zzcip implements zzegz<Set<zzbvt<zzbrc>>> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzcix> zzfyg;
    private final zzcin zzfzt;

    private zzcip(zzcin zzcin, zzehm<zzcix> zzehm, zzehm<Executor> zzehm2) {
        this.zzfzt = zzcin;
        this.zzfyg = zzehm;
        this.zzenm = zzehm2;
    }

    public static zzcip zzc(zzcin zzcin, zzehm<zzcix> zzehm, zzehm<Executor> zzehm2) {
        return new zzcip(zzcin, zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzehf.zza(zzcin.zzd(this.zzfyg.get(), this.zzenm.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
