package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzbup implements zzegz<Set<zzbvt<zzbsm>>> {
    private final zzbuj zzfoh;

    private zzbup(zzbuj zzbuj) {
        this.zzfoh = zzbuj;
    }

    public static zzbup zzi(zzbuj zzbuj) {
        return new zzbup(zzbuj);
    }

    public static Set<zzbvt<zzbsm>> zzj(zzbuj zzbuj) {
        return (Set) zzehf.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzj(this.zzfoh);
    }
}
