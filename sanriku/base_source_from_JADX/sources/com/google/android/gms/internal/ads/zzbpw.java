package com.google.android.gms.internal.ads;

public final class zzbpw implements zzegz<zzbvt<zzbtm>> {
    private final zzehm<zzbpv> zzfhv;
    private final zzbpx zzfmg;

    private zzbpw(zzbpx zzbpx, zzehm<zzbpv> zzehm) {
        this.zzfmg = zzbpx;
        this.zzfhv = zzehm;
    }

    public static zzbpw zza(zzbpx zzbpx, zzehm<zzbpv> zzehm) {
        return new zzbpw(zzbpx, zzehm);
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(new zzbvt(this.zzfhv.get(), zzbab.zzdzw), "Cannot return null from a non-@Nullable @Provides method");
    }
}
