package com.google.android.gms.internal.ads;

public final class zzboy implements zzegz<zzbvt<zzbrp>> {
    private final zzbox zzflw;
    private final zzehm<zzbpc> zzflx;

    private zzboy(zzbox zzbox, zzehm<zzbpc> zzehm) {
        this.zzflw = zzbox;
        this.zzflx = zzehm;
    }

    public static zzboy zzb(zzbox zzbox, zzehm<zzbpc> zzehm) {
        return new zzboy(zzbox, zzehm);
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(new zzbvt(this.zzflx.get(), zzbab.zzdzw), "Cannot return null from a non-@Nullable @Provides method");
    }
}
