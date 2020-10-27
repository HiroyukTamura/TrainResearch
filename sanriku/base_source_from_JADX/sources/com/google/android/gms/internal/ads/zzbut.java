package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbut implements zzegz<Set<zzbvt<zzbrc>>> {
    private final zzbuj zzfoh;

    private zzbut(zzbuj zzbuj) {
        this.zzfoh = zzbuj;
    }

    public static zzbut zzn(zzbuj zzbuj) {
        return new zzbut(zzbuj);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzehf.zza(this.zzfoh.zzajd(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
