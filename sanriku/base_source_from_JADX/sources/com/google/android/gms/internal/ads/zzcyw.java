package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

public final class zzcyw implements zzegz<zzcyu> {
    private final zzehm<Context> zzenp;
    private final zzehm<zzdrh> zzgln;
    private final zzehm<Set<String>> zzgma;

    private zzcyw(zzehm<zzdrh> zzehm, zzehm<Context> zzehm2, zzehm<Set<String>> zzehm3) {
        this.zzgln = zzehm;
        this.zzenp = zzehm2;
        this.zzgma = zzehm3;
    }

    public static zzcyw zzs(zzehm<zzdrh> zzehm, zzehm<Context> zzehm2, zzehm<Set<String>> zzehm3) {
        return new zzcyw(zzehm, zzehm2, zzehm3);
    }

    public final /* synthetic */ Object get() {
        return new zzcyu(this.zzgln.get(), this.zzenp.get(), this.zzgma.get());
    }
}
