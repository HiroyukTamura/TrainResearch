package com.google.android.gms.internal.ads;

public final class zzbjz implements zzegz<zzbjw> {
    private final zzehm<zzawt> zzeqm;

    private zzbjz(zzehm<zzawt> zzehm) {
        this.zzeqm = zzehm;
    }

    public static zzbjz zza(zzehm<zzawt> zzehm) {
        return new zzbjz(zzehm);
    }

    public final /* synthetic */ Object get() {
        return new zzbjw(this.zzeqm.get());
    }
}
