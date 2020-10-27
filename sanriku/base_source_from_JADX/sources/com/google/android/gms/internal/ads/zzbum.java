package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzbum implements zzegz<Set<zzbvt<zzbrs>>> {
    private final zzbuj zzfoh;

    private zzbum(zzbuj zzbuj) {
        this.zzfoh = zzbuj;
    }

    public static zzbum zzg(zzbuj zzbuj) {
        return new zzbum(zzbuj);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzehf.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
