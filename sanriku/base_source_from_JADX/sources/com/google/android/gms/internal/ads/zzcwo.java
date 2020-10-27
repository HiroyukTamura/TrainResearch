package com.google.android.gms.internal.ads;

public final class zzcwo implements zzegz<zzcwm> {
    private final zzehm<zzbpc> zzeqe;
    private final zzehm<zzdhy> zzero;
    private final zzehm<zzdhe> zzfjq;
    private final zzehm<String> zzgmb;
    private final zzehm<String> zzgml;

    private zzcwo(zzehm<String> zzehm, zzehm<String> zzehm2, zzehm<zzbpc> zzehm3, zzehm<zzdhy> zzehm4, zzehm<zzdhe> zzehm5) {
        this.zzgmb = zzehm;
        this.zzgml = zzehm2;
        this.zzeqe = zzehm3;
        this.zzero = zzehm4;
        this.zzfjq = zzehm5;
    }

    public static zzcwo zzg(zzehm<String> zzehm, zzehm<String> zzehm2, zzehm<zzbpc> zzehm3, zzehm<zzdhy> zzehm4, zzehm<zzdhe> zzehm5) {
        return new zzcwo(zzehm, zzehm2, zzehm3, zzehm4, zzehm5);
    }

    public final /* synthetic */ Object get() {
        return new zzcwm(this.zzgmb.get(), this.zzgml.get(), this.zzeqe.get(), this.zzero.get(), this.zzfjq.get());
    }
}
