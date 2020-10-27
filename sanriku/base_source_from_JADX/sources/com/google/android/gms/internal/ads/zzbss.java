package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbss implements zzegz<zzbsq> {
    private final zzehm<Set<zzbvt<zzbsr>>> zzfjp;

    private zzbss(zzehm<Set<zzbvt<zzbsr>>> zzehm) {
        this.zzfjp = zzehm;
    }

    public static zzbss zzn(zzehm<Set<zzbvt<zzbsr>>> zzehm) {
        return new zzbss(zzehm);
    }

    public final /* synthetic */ Object get() {
        return new zzbsq(this.zzfjp.get());
    }
}
