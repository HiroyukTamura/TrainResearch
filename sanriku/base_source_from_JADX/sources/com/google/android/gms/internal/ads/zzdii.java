package com.google.android.gms.internal.ads;

public final class zzdii implements zzegz<zzawo> {
    private final zzdie zzgvr;
    private final zzehm<zzdic> zzgvs;

    private zzdii(zzdie zzdie, zzehm<zzdic> zzehm) {
        this.zzgvr = zzdie;
        this.zzgvs = zzehm;
    }

    public static zzdii zzc(zzdie zzdie, zzehm<zzdic> zzehm) {
        return new zzdii(zzdie, zzehm);
    }

    public final /* synthetic */ Object get() {
        return (zzawo) zzehf.zza(this.zzgvs.get().zzdtl, "Cannot return null from a non-@Nullable @Provides method");
    }
}
