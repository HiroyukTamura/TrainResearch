package com.google.android.gms.internal.ads;

public final class zzcgz implements zzegz<zzcgs> {
    private final zzehm<zzdfa> zzeqj;
    private final zzehm<zzst> zzfyg;

    private zzcgz(zzehm<zzst> zzehm, zzehm<zzdfa> zzehm2) {
        this.zzfyg = zzehm;
        this.zzeqj = zzehm2;
    }

    public static zzcgz zzaa(zzehm<zzst> zzehm, zzehm<zzdfa> zzehm2) {
        return new zzcgz(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return new zzcgs(this.zzfyg.get(), this.zzeqj.get());
    }
}
