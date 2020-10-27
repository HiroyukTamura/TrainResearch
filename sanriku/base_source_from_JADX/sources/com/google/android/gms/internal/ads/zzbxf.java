package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;

public final class zzbxf implements zzegz<zzbvt<zzo>> {
    private final zzehm<zzbyb> zzfip;
    private final zzbwx zzfpa;

    private zzbxf(zzbwx zzbwx, zzehm<zzbyb> zzehm) {
        this.zzfpa = zzbwx;
        this.zzfip = zzehm;
    }

    public static zzbxf zzc(zzbwx zzbwx, zzehm<zzbyb> zzehm) {
        return new zzbxf(zzbwx, zzehm);
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(new zzbvt(this.zzfip.get(), zzbab.zzdzv), "Cannot return null from a non-@Nullable @Provides method");
    }
}
