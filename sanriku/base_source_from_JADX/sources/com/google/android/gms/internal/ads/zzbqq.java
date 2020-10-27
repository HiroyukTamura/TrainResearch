package com.google.android.gms.internal.ads;

public final class zzbqq implements zzegz<zzdhe> {
    private final zzbqj zzfmy;

    private zzbqq(zzbqj zzbqj) {
        this.zzfmy = zzbqj;
    }

    public static zzbqq zzm(zzbqj zzbqj) {
        return new zzbqq(zzbqj);
    }

    public static zzdhe zzn(zzbqj zzbqj) {
        return (zzdhe) zzehf.zza(zzbqj.zzain(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzn(this.zzfmy);
    }
}
