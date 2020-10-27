package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbuv implements zzegz<Set<zzbvt<zzbrp>>> {
    private final zzbuj zzfoh;

    private zzbuv(zzbuj zzbuj) {
        this.zzfoh = zzbuj;
    }

    public static zzbuv zzp(zzbuj zzbuj) {
        return new zzbuv(zzbuj);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzehf.zza(this.zzfoh.zzaji(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
