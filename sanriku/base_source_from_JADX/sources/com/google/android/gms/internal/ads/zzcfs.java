package com.google.android.gms.internal.ads;

public final class zzcfs implements zzegz<zzbvt<zzbrs>> {
    private final zzehm<zzcfr> zzfip;
    private final zzcft zzfxn;

    private zzcfs(zzcft zzcft, zzehm<zzcfr> zzehm) {
        this.zzfxn = zzcft;
        this.zzfip = zzehm;
    }

    public static zzcfs zza(zzcft zzcft, zzehm<zzcfr> zzehm) {
        return new zzcfs(zzcft, zzehm);
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(new zzbvt(this.zzfip.get(), zzbab.zzdzv), "Cannot return null from a non-@Nullable @Provides method");
    }
}
