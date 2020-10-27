package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzbmm implements zzegz<Set<zzbvt<zzpz>>> {
    private final zzehm<zzbnn> zzfip;
    private final zzbma zzfjo;

    public zzbmm(zzbma zzbma, zzehm<zzbnn> zzehm) {
        this.zzfjo = zzbma;
        this.zzfip = zzehm;
    }

    public final /* synthetic */ Object get() {
        return (Set) zzehf.zza(Collections.singleton(new zzbvt(this.zzfip.get(), zzbab.zzdzw)), "Cannot return null from a non-@Nullable @Provides method");
    }
}
