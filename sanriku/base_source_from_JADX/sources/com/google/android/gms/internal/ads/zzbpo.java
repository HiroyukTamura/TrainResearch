package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;

public final class zzbpo implements zzegz<zzbvt<zzo>> {
    private final zzehm<zzbom> zzfip;
    private final zzbpm zzfme;

    private zzbpo(zzbpm zzbpm, zzehm<zzbom> zzehm) {
        this.zzfme = zzbpm;
        this.zzfip = zzehm;
    }

    public static zzbpo zza(zzbpm zzbpm, zzehm<zzbom> zzehm) {
        return new zzbpo(zzbpm, zzehm);
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(new zzbvt(this.zzfip.get(), zzbab.zzdzw), "Cannot return null from a non-@Nullable @Provides method");
    }
}
