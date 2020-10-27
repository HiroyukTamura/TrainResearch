package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbvz implements zzegz<zzbvx> {
    private final zzehm<Set<zzbvt<zzbvy>>> zzfjp;

    private zzbvz(zzehm<Set<zzbvt<zzbvy>>> zzehm) {
        this.zzfjp = zzehm;
    }

    public static zzbvz zzu(zzehm<Set<zzbvt<zzbvy>>> zzehm) {
        return new zzbvz(zzehm);
    }

    public final /* synthetic */ Object get() {
        return new zzbvx(this.zzfjp.get());
    }
}
