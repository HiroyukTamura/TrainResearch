package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbuu implements zzegz<Set<zzbvt<zzbqx>>> {
    private final zzbuj zzfoh;

    private zzbuu(zzbuj zzbuj) {
        this.zzfoh = zzbuj;
    }

    public static zzbuu zzo(zzbuj zzbuj) {
        return new zzbuu(zzbuj);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzehf.zza(this.zzfoh.zzajb(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
