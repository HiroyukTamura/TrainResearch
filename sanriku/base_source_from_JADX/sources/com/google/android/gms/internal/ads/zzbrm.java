package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

public final class zzbrm implements zzegz<zzbre> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzbri> zzexw;
    private final zzehm<Set<zzbvt<zzbrb>>> zzfjp;

    private zzbrm(zzehm<zzbri> zzehm, zzehm<Set<zzbvt<zzbrb>>> zzehm2, zzehm<Executor> zzehm3) {
        this.zzexw = zzehm;
        this.zzfjp = zzehm2;
        this.zzenm = zzehm3;
    }

    public static zzbrm zzi(zzehm<zzbri> zzehm, zzehm<Set<zzbvt<zzbrb>>> zzehm2, zzehm<Executor> zzehm3) {
        return new zzbrm(zzehm, zzehm2, zzehm3);
    }

    public final /* synthetic */ Object get() {
        return new zzbre(this.zzexw.get(), this.zzfjp.get(), this.zzenm.get());
    }
}
