package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcvp implements zzegz<zzcvo> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzdri<String>> zzglq;

    private zzcvp(zzehm<zzdri<String>> zzehm, zzehm<Executor> zzehm2) {
        this.zzglq = zzehm;
        this.zzenm = zzehm2;
    }

    public static zzcvp zzaq(zzehm<zzdri<String>> zzehm, zzehm<Executor> zzehm2) {
        return new zzcvp(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return new zzcvo(this.zzglq.get(), this.zzenm.get());
    }
}
