package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzblg implements zzegz<Set<zzbvt<zzbsm>>> {
    private final zzble zzfio;
    private final zzehm<zzbnn> zzfip;

    public zzblg(zzble zzble, zzehm<zzbnn> zzehm) {
        this.zzfio = zzble;
        this.zzfip = zzehm;
    }

    public final /* synthetic */ Object get() {
        return (Set) zzehf.zza(Collections.singleton(new zzbvt(this.zzfip.get(), zzbab.zzdzw)), "Cannot return null from a non-@Nullable @Provides method");
    }
}
