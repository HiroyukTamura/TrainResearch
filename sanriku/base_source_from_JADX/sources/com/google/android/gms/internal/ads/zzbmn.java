package com.google.android.gms.internal.ads;

public final class zzbmn implements zzegz<zzbvt<zzbsm>> {
    private final zzehm<zzbnl> zzfip;
    private final zzbma zzfjo;

    public zzbmn(zzbma zzbma, zzehm<zzbnl> zzehm) {
        this.zzfjo = zzbma;
        this.zzfip = zzehm;
    }

    public static zzbvt<zzbsm> zza(zzbma zzbma, zzbnl zzbnl) {
        return (zzbvt) zzehf.zza(new zzbvt(zzbnl, zzbab.zzdzv), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfjo, this.zzfip.get());
    }
}
