package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzbxi implements zzegz<Set<zzbvt<zzbvm>>> {
    private final zzehm<zzbyf> zzfip;

    private zzbxi(zzehm<zzbyf> zzehm) {
        this.zzfip = zzehm;
    }

    public static zzbxi zzw(zzehm<zzbyf> zzehm) {
        return new zzbxi(zzehm);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzehf.zza(Collections.singleton(zzbvt.zzb(this.zzfip.get(), zzbab.zzdzw)), "Cannot return null from a non-@Nullable @Provides method");
    }
}
