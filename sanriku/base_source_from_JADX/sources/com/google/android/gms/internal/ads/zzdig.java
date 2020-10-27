package com.google.android.gms.internal.ads;

public final class zzdig implements zzegz<zzdic> {
    private final zzehm<zzdia> zzfhn;
    private final zzdie zzgvr;
    private final zzehm<String> zzgvt;

    private zzdig(zzdie zzdie, zzehm<zzdia> zzehm, zzehm<String> zzehm2) {
        this.zzgvr = zzdie;
        this.zzfhn = zzehm;
        this.zzgvt = zzehm2;
    }

    public static zzdig zza(zzdie zzdie, zzehm<zzdia> zzehm, zzehm<String> zzehm2) {
        return new zzdig(zzdie, zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return (zzdic) zzehf.zza(this.zzfhn.get().zzgt(this.zzgvt.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
