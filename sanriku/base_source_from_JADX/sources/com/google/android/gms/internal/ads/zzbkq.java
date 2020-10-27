package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

public final class zzbkq implements zzegz<zzbkp> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzaku> zzfhn;
    private final zzehm<zzbkn> zzfho;
    private final zzehm<zzbkg> zzfhp;
    private final zzehm<Clock> zzfhq;

    private zzbkq(zzehm<zzaku> zzehm, zzehm<zzbkn> zzehm2, zzehm<Executor> zzehm3, zzehm<zzbkg> zzehm4, zzehm<Clock> zzehm5) {
        this.zzfhn = zzehm;
        this.zzfho = zzehm2;
        this.zzenm = zzehm3;
        this.zzfhp = zzehm4;
        this.zzfhq = zzehm5;
    }

    public static zzbkq zza(zzehm<zzaku> zzehm, zzehm<zzbkn> zzehm2, zzehm<Executor> zzehm3, zzehm<zzbkg> zzehm4, zzehm<Clock> zzehm5) {
        return new zzbkq(zzehm, zzehm2, zzehm3, zzehm4, zzehm5);
    }

    public final /* synthetic */ Object get() {
        return new zzbkp(this.zzfhn.get(), this.zzfho.get(), this.zzenm.get(), this.zzfhp.get(), this.zzfhq.get());
    }
}
