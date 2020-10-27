package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzbyr implements zzegz<Set<String>> {
    private final zzehm<zzcae> zzfji;

    public zzbyr(zzehm<zzcae> zzehm) {
        this.zzfji = zzehm;
    }

    public static Set<String> zza(zzcae zzcae) {
        return (Set) zzehf.zza(zzcae.zzalo() != null ? Collections.singleton("banner") : Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfji.get());
    }
}
