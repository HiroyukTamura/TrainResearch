package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

public final class zzbzl implements zzegz<zzbky> {
    private final zzehm<Executor> zzenm;
    private final zzehm<Context> zzenp;
    private final zzehm<Clock> zzfhq;
    private final zzehm<zzpu> zzfqz;

    public zzbzl(zzehm<zzpu> zzehm, zzehm<Executor> zzehm2, zzehm<Context> zzehm3, zzehm<Clock> zzehm4) {
        this.zzfqz = zzehm;
        this.zzenm = zzehm2;
        this.zzenp = zzehm3;
        this.zzfhq = zzehm4;
    }

    public final /* synthetic */ Object get() {
        return (zzbky) zzehf.zza(new zzbky(this.zzenm.get(), new zzbkn(this.zzenp.get(), this.zzfqz.get()), this.zzfhq.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
