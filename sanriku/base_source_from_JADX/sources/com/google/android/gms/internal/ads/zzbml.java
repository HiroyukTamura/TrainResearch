package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzbml implements zzegz<Set<zzbvt<zzbsm>>> {
    private final zzehm<zzbnn> zzfip;
    private final zzbma zzfjo;

    public zzbml(zzbma zzbma, zzehm<zzbnn> zzehm) {
        this.zzfjo = zzbma;
        this.zzfip = zzehm;
    }

    public static Set<zzbvt<zzbsm>> zza(zzbma zzbma, zzbnn zzbnn) {
        return (Set) zzehf.zza(Collections.singleton(new zzbvt(zzbnn, zzbab.zzdzw)), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfjo, this.zzfip.get());
    }
}
