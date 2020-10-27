package com.google.android.gms.internal.ads;

public final class zzcap implements zzegz<zzbzx> {
    private final zzcaj zzfsy;

    private zzcap(zzcaj zzcaj) {
        this.zzfsy = zzcaj;
    }

    public static zzcap zzb(zzcaj zzcaj) {
        return new zzcap(zzcaj);
    }

    public static zzbzx zzc(zzcaj zzcaj) {
        return (zzbzx) zzehf.zza(zzcaj.zzalu(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzc(this.zzfsy);
    }
}
