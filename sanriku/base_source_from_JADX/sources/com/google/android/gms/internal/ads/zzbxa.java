package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbxa implements zzegz<Set<zzbvt<zzbqx>>> {
    private final zzehm<zzbyd> zzfip;
    private final zzbwx zzfpa;

    private zzbxa(zzbwx zzbwx, zzehm<zzbyd> zzehm) {
        this.zzfpa = zzbwx;
        this.zzfip = zzehm;
    }

    public static zzbxa zza(zzbwx zzbwx, zzehm<zzbyd> zzehm) {
        return new zzbxa(zzbwx, zzehm);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzehf.zza(this.zzfpa.zza(this.zzfip.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
