package com.google.android.gms.internal.ads;

public final class zzbwa implements zzegz<zzbwb> {
    private final zzehm<zzdld> zzets;
    private final zzehm<zzdgo> zzfgv;

    private zzbwa(zzehm<zzdgo> zzehm, zzehm<zzdld> zzehm2) {
        this.zzfgv = zzehm;
        this.zzets = zzehm2;
    }

    public static zzbwa zzo(zzehm<zzdgo> zzehm, zzehm<zzdld> zzehm2) {
        return new zzbwa(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return new zzbwb(this.zzfgv.get(), this.zzets.get());
    }
}
