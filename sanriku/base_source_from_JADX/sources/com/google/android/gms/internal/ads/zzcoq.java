package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

public final class zzcoq implements zzegz<zzcom> {
    private final zzehm<zzdrh> zzenm;
    private final zzehm<zzbmt> zzfbp;
    private final zzehm<zzcns> zzfbt;
    private final zzehm<ScheduledExecutorService> zzfvp;
    private final zzehm<zzbra> zzgfi;

    public zzcoq(zzehm<zzbmt> zzehm, zzehm<zzcns> zzehm2, zzehm<zzbra> zzehm3, zzehm<ScheduledExecutorService> zzehm4, zzehm<zzdrh> zzehm5) {
        this.zzfbp = zzehm;
        this.zzfbt = zzehm2;
        this.zzgfi = zzehm3;
        this.zzfvp = zzehm4;
        this.zzenm = zzehm5;
    }

    public final /* synthetic */ Object get() {
        return new zzcom(this.zzfbp.get(), this.zzfbt.get(), this.zzgfi.get(), this.zzfvp.get(), this.zzenm.get());
    }
}
