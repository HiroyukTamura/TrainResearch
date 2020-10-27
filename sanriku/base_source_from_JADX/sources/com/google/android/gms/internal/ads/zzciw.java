package com.google.android.gms.internal.ads;

public final class zzciw implements zzegz<zzcix> {
    private final zzehm<zzbgy> zzenk;
    private final zzehm<zzcil> zzfyg;

    private zzciw(zzehm<zzcil> zzehm, zzehm<zzbgy> zzehm2) {
        this.zzfyg = zzehm;
        this.zzenk = zzehm2;
    }

    public static zzciw zzah(zzehm<zzcil> zzehm, zzehm<zzbgy> zzehm2) {
        return new zzciw(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return new zzcix(this.zzfyg.get(), this.zzenk.get());
    }
}
