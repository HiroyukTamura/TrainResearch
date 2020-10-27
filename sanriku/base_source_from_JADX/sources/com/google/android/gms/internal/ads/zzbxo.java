package com.google.android.gms.internal.ads;

public final class zzbxo implements zzegz<zzbxp> {
    private final zzehm<zzbsu> zzexm;
    private final zzehm<zzbvp> zzfdt;

    private zzbxo(zzehm<zzbsu> zzehm, zzehm<zzbvp> zzehm2) {
        this.zzexm = zzehm;
        this.zzfdt = zzehm2;
    }

    public static zzbxo zzp(zzehm<zzbsu> zzehm, zzehm<zzbvp> zzehm2) {
        return new zzbxo(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return new zzbxp(this.zzexm.get(), this.zzfdt.get());
    }
}
