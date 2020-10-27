package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbtu implements zzegz<zzbtp> {
    private final zzehm<Set<zzbvt<zzbtt>>> zzfjp;

    private zzbtu(zzehm<Set<zzbvt<zzbtt>>> zzehm) {
        this.zzfjp = zzehm;
    }

    public static zzbtu zzq(zzehm<Set<zzbvt<zzbtt>>> zzehm) {
        return new zzbtu(zzehm);
    }

    public final /* synthetic */ Object get() {
        return new zzbtp(this.zzfjp.get());
    }
}
