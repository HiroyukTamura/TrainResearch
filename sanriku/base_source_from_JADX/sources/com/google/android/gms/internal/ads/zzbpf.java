package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzbpf implements zzegz<zzbpc> {
    private final zzehm<Clock> zzfhq;
    private final zzehm<zzawc> zzflz;

    private zzbpf(zzehm<Clock> zzehm, zzehm<zzawc> zzehm2) {
        this.zzfhq = zzehm;
        this.zzflz = zzehm2;
    }

    public static zzbpf zze(zzehm<Clock> zzehm, zzehm<zzawc> zzehm2) {
        return new zzbpf(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return new zzbpc(this.zzfhq.get(), this.zzflz.get());
    }
}
