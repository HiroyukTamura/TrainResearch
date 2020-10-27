package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbrj implements zzegz<zzbri> {
    private final zzehm<Set<zzbvt<zzbrl>>> zzfjp;

    private zzbrj(zzehm<Set<zzbvt<zzbrl>>> zzehm) {
        this.zzfjp = zzehm;
    }

    public static zzbrj zzh(zzehm<Set<zzbvt<zzbrl>>> zzehm) {
        return new zzbrj(zzehm);
    }

    public final /* synthetic */ Object get() {
        return new zzbri(this.zzfjp.get());
    }
}
