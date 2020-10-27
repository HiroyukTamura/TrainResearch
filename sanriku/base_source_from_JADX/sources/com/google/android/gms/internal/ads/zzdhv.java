package com.google.android.gms.internal.ads;

public final class zzdhv implements zzegz<zzbvt<zzbrc>> {
    private final zzehm<zzdhy> zzflx;
    private final zzdhw zzgvo;

    private zzdhv(zzdhw zzdhw, zzehm<zzdhy> zzehm) {
        this.zzgvo = zzdhw;
        this.zzflx = zzehm;
    }

    public static zzdhv zza(zzdhw zzdhw, zzehm<zzdhy> zzehm) {
        return new zzdhv(zzdhw, zzehm);
    }

    public final /* synthetic */ Object get() {
        return (zzbvt) zzehf.zza(new zzbvt(this.zzflx.get(), zzbab.zzdzw), "Cannot return null from a non-@Nullable @Provides method");
    }
}
