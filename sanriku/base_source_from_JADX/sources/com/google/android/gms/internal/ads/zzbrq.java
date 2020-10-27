package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbrq implements zzegz<zzbro> {
    private final zzehm<Set<zzbvt<zzbrp>>> zzfjp;

    private zzbrq(zzehm<Set<zzbvt<zzbrp>>> zzehm) {
        this.zzfjp = zzehm;
    }

    public static zzbrq zzi(zzehm<Set<zzbvt<zzbrp>>> zzehm) {
        return new zzbrq(zzehm);
    }

    public final /* synthetic */ Object get() {
        return new zzbro(this.zzfjp.get());
    }
}
