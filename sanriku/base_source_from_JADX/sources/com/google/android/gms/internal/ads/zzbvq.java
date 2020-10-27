package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbvq implements zzegz<zzbvp> {
    private final zzehm<Set<zzbvt<zzbvm>>> zzfjp;

    private zzbvq(zzehm<Set<zzbvt<zzbvm>>> zzehm) {
        this.zzfjp = zzehm;
    }

    public static zzbvq zzt(zzehm<Set<zzbvt<zzbvm>>> zzehm) {
        return new zzbvq(zzehm);
    }

    public final /* synthetic */ Object get() {
        return new zzbvp(this.zzfjp.get());
    }
}
