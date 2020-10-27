package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzdlc implements zzegz<zzdkt> {
    private final zzehm<Set<zzbvt<zzdla>>> zzfjp;

    private zzdlc(zzehm<Set<zzbvt<zzdla>>> zzehm) {
        this.zzfjp = zzehm;
    }

    public static zzdlc zzaq(zzehm<Set<zzbvt<zzdla>>> zzehm) {
        return new zzdlc(zzehm);
    }

    public final /* synthetic */ Object get() {
        return new zzdkt(this.zzfjp.get());
    }
}
