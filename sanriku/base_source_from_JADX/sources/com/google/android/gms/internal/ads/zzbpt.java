package com.google.android.gms.internal.ads;

public final class zzbpt implements zzegz<zzbvt<zzbrs>> {
    private final zzehm<zzbqa> zzfhv;
    private final zzbpm zzfme;

    private zzbpt(zzbpm zzbpm, zzehm<zzbqa> zzehm) {
        this.zzfme = zzbpm;
        this.zzfhv = zzehm;
    }

    public static zzbpt zzc(zzbpm zzbpm, zzehm<zzbqa> zzehm) {
        return new zzbpt(zzbpm, zzehm);
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(new zzbvt(this.zzfhv.get(), zzbab.zzdzw), "Cannot return null from a non-@Nullable @Provides method");
    }
}
