package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzblj implements zzegz<Set<zzbvt<zzpz>>> {
    private final zzble zzfio;
    private final zzehm<zzbnn> zzfip;

    public zzblj(zzble zzble, zzehm<zzbnn> zzehm) {
        this.zzfio = zzble;
        this.zzfip = zzehm;
    }

    public final /* synthetic */ Object get() {
        return (Set) zzehf.zza(Collections.singleton(new zzbvt(this.zzfip.get(), zzbab.zzdzw)), "Cannot return null from a non-@Nullable @Provides method");
    }
}
