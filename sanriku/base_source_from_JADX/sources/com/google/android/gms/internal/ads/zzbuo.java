package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.Collections;
import java.util.Set;

public final class zzbuo implements zzegz<Set<zzbvt<zzo>>> {
    private final zzbuj zzfoh;

    private zzbuo(zzbuj zzbuj) {
        this.zzfoh = zzbuj;
    }

    public static zzbuo zzh(zzbuj zzbuj) {
        return new zzbuo(zzbuj);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzehf.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
