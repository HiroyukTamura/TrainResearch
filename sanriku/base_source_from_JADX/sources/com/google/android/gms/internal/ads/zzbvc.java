package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzbvc implements zzegz<Set<zzbvt<zzbvy>>> {
    private final zzbuj zzfoh;

    private zzbvc(zzbuj zzbuj) {
        this.zzfoh = zzbuj;
    }

    public static zzbvc zzx(zzbuj zzbuj) {
        return new zzbvc(zzbuj);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzehf.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
