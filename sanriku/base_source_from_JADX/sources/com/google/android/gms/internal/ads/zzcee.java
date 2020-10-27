package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import java.util.concurrent.Executor;

public final class zzcee implements zzegz<zzced> {
    private final zzehm<Context> zzenp;
    private final zzehm<Executor> zzfjj;
    private final zzehm<zzazz> zzfnd;
    private final zzehm<zzdt> zzfqu;
    private final zzehm<zza> zzfvn;
    private final zzehm<zzbes> zzfwt;

    public zzcee(zzehm<Context> zzehm, zzehm<Executor> zzehm2, zzehm<zzdt> zzehm3, zzehm<zzazz> zzehm4, zzehm<zza> zzehm5, zzehm<zzbes> zzehm6) {
        this.zzenp = zzehm;
        this.zzfjj = zzehm2;
        this.zzfqu = zzehm3;
        this.zzfnd = zzehm4;
        this.zzfvn = zzehm5;
        this.zzfwt = zzehm6;
    }

    public final /* synthetic */ Object get() {
        return new zzced(this.zzenp.get(), this.zzfjj.get(), this.zzfqu.get(), this.zzfnd.get(), this.zzfvn.get(), this.zzfwt.get());
    }
}
