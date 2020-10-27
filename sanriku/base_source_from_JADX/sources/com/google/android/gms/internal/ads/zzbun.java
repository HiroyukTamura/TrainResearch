package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbun implements zzegz<zzbra> {
    private final zzbuj zzfoh;
    private final zzehm<Set<zzbvt<zzbrc>>> zzfoi;

    private zzbun(zzbuj zzbuj, zzehm<Set<zzbvt<zzbrc>>> zzehm) {
        this.zzfoh = zzbuj;
        this.zzfoi = zzehm;
    }

    public static zzbun zza(zzbuj zzbuj, zzehm<Set<zzbvt<zzbrc>>> zzehm) {
        return new zzbun(zzbuj, zzehm);
    }

    public final /* synthetic */ Object get() {
        return (zzbra) zzehf.zza(this.zzfoh.zzc(this.zzfoi.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
