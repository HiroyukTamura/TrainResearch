package com.google.android.gms.internal.ads;

public final class zzbqr implements zzegz<zzbqs> {
    private final zzehm<zzdgo> zzfkc;
    private final zzehm<String> zzfmz;

    private zzbqr(zzehm<zzdgo> zzehm, zzehm<String> zzehm2) {
        this.zzfkc = zzehm;
        this.zzfmz = zzehm2;
    }

    public static zzbqr zzm(zzehm<zzdgo> zzehm, zzehm<String> zzehm2) {
        return new zzbqr(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return new zzbqs(this.zzfkc.get(), this.zzfmz.get());
    }
}
