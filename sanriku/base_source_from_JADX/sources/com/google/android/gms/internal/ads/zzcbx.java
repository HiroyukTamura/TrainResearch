package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

public final class zzcbx implements zzegz<zzcbv> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzaym> zzeuf;
    private final zzehm<Clock> zzfhq;

    public zzcbx(zzehm<zzaym> zzehm, zzehm<Clock> zzehm2, zzehm<Executor> zzehm3) {
        this.zzeuf = zzehm;
        this.zzfhq = zzehm2;
        this.zzenm = zzehm3;
    }

    public final /* synthetic */ Object get() {
        return new zzcbv(this.zzeuf.get(), this.zzfhq.get(), this.zzenm.get());
    }
}
