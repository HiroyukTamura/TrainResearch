package com.google.android.gms.internal.ads;

public final class zzbym implements zzegz<zzcae> {
    private final zzbyl zzfpr;

    private zzbym(zzbyl zzbyl) {
        this.zzfpr = zzbyl;
    }

    public static zzbym zzc(zzbyl zzbyl) {
        return new zzbym(zzbyl);
    }

    public static zzcae zzd(zzbyl zzbyl) {
        return (zzcae) zzehf.zza(zzbyl.zzakd(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzd(this.zzfpr);
    }
}
