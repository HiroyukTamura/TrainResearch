package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbmf implements zzegz<zzbsh> {
    private final zzbma zzfjo;
    private final zzehm<Set<zzbvt<zzbsm>>> zzfjp;

    public zzbmf(zzbma zzbma, zzehm<Set<zzbvt<zzbsm>>> zzehm) {
        this.zzfjo = zzbma;
        this.zzfjp = zzehm;
    }

    public static zzbsh zza(zzbma zzbma, Set<zzbvt<zzbsm>> set) {
        return (zzbsh) zzehf.zza(zzbma.zza(set), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfjo, this.zzfjp.get());
    }
}
