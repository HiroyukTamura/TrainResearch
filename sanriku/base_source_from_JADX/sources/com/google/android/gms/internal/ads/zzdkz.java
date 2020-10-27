package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

public final class zzdkz implements zzegz<zzdku> {
    private final zzehm<zzdrh> zzenm;
    private final zzehm<zzdkt> zzerj;
    private final zzehm<ScheduledExecutorService> zzfix;

    private zzdkz(zzehm<zzdrh> zzehm, zzehm<ScheduledExecutorService> zzehm2, zzehm<zzdkt> zzehm3) {
        this.zzenm = zzehm;
        this.zzfix = zzehm2;
        this.zzerj = zzehm3;
    }

    public static zzdkz zzv(zzehm<zzdrh> zzehm, zzehm<ScheduledExecutorService> zzehm2, zzehm<zzdkt> zzehm3) {
        return new zzdkz(zzehm, zzehm2, zzehm3);
    }

    public final /* synthetic */ Object get() {
        return new zzdku(this.zzenm.get(), this.zzfix.get(), this.zzerj.get());
    }
}
