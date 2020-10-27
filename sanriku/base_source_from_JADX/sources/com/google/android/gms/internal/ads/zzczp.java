package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

public final class zzczp implements zzegz<zzczm> {
    private final zzehm<zzdrh> zzenm;
    private final zzehm<Context> zzenp;
    private final zzehm<zzcsz> zzeod;
    private final zzehm<String> zzfic;
    private final zzehm<zzdhe> zzfjq;
    private final zzehm<ScheduledExecutorService> zzfvp;
    private final zzehm<zzcsx> zzghp;

    private zzczp(zzehm<zzdrh> zzehm, zzehm<ScheduledExecutorService> zzehm2, zzehm<String> zzehm3, zzehm<zzcsz> zzehm4, zzehm<Context> zzehm5, zzehm<zzdhe> zzehm6, zzehm<zzcsx> zzehm7) {
        this.zzenm = zzehm;
        this.zzfvp = zzehm2;
        this.zzfic = zzehm3;
        this.zzeod = zzehm4;
        this.zzenp = zzehm5;
        this.zzfjq = zzehm6;
        this.zzghp = zzehm7;
    }

    public static zzczp zza(zzehm<zzdrh> zzehm, zzehm<ScheduledExecutorService> zzehm2, zzehm<String> zzehm3, zzehm<zzcsz> zzehm4, zzehm<Context> zzehm5, zzehm<zzdhe> zzehm6, zzehm<zzcsx> zzehm7) {
        return new zzczp(zzehm, zzehm2, zzehm3, zzehm4, zzehm5, zzehm6, zzehm7);
    }

    public final /* synthetic */ Object get() {
        return new zzczm(this.zzenm.get(), this.zzfvp.get(), this.zzfic.get(), this.zzeod.get(), this.zzenp.get(), this.zzfjq.get(), this.zzghp.get());
    }
}
