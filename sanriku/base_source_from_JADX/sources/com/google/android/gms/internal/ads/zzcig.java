package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcig implements zzegz<zzcie> {
    private final zzehm<Executor> zzenm;
    private final zzehm<Context> zzenp;
    private final zzehm<zzbaa> zzets;
    private final zzehm<zzazz> zzffv;

    public zzcig(zzehm<Executor> zzehm, zzehm<zzbaa> zzehm2, zzehm<Context> zzehm3, zzehm<zzazz> zzehm4) {
        this.zzenm = zzehm;
        this.zzets = zzehm2;
        this.zzenp = zzehm3;
        this.zzffv = zzehm4;
    }

    public final /* synthetic */ Object get() {
        return new zzcie(this.zzenm.get(), this.zzets.get(), this.zzenp.get(), this.zzffv.get());
    }
}
