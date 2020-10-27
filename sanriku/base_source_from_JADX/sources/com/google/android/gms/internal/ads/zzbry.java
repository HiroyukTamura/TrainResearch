package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbry implements zzegz<zzbrr> {
    private final zzehm<Set<zzbvt<zzbrs>>> zzfjp;

    private zzbry(zzehm<Set<zzbvt<zzbrs>>> zzehm) {
        this.zzfjp = zzehm;
    }

    public static zzbry zzj(zzehm<Set<zzbvt<zzbrs>>> zzehm) {
        return new zzbry(zzehm);
    }

    public final /* synthetic */ Object get() {
        return new zzbrr(this.zzfjp.get());
    }
}
