package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbux implements zzegz<Set<zzbvt<zzbsm>>> {
    private final zzbuj zzfoh;

    private zzbux(zzbuj zzbuj) {
        this.zzfoh = zzbuj;
    }

    public static zzbux zzr(zzbuj zzbuj) {
        return new zzbux(zzbuj);
    }

    public static Set<zzbvt<zzbsm>> zzs(zzbuj zzbuj) {
        return (Set) zzehf.zza(zzbuj.zzajc(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzs(this.zzfoh);
    }
}
