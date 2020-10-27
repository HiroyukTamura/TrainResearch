package com.google.android.gms.internal.ads;

public final class zzbow implements zzegz<zzbvt<zzub>> {
    private final zzbox zzflw;
    private final zzehm<zzbpc> zzflx;

    private zzbow(zzbox zzbox, zzehm<zzbpc> zzehm) {
        this.zzflw = zzbox;
        this.zzflx = zzehm;
    }

    public static zzbow zza(zzbox zzbox, zzehm<zzbpc> zzehm) {
        return new zzbow(zzbox, zzehm);
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(new zzbvt(this.zzflx.get(), zzbab.zzdzw), "Cannot return null from a non-@Nullable @Provides method");
    }
}
