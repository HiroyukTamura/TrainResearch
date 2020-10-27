package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

public final class zzdlf implements zzegz<zzdld> {
    private final zzehm<Executor> zzenm;
    private final zzehm<Context> zzenp;
    private final zzehm<zzbaa> zzeoh;
    private final zzehm<zzdgz> zzfek;
    private final zzehm<zzdt> zzfgx;
    private final zzehm<Clock> zzfhq;
    private final zzehm<zzazz> zzfib;
    private final zzehm<String> zzgmb;
    private final zzehm<String> zzgml;
    private final zzehm<zzcqi> zzhaq;

    private zzdlf(zzehm<Executor> zzehm, zzehm<zzbaa> zzehm2, zzehm<zzcqi> zzehm3, zzehm<zzazz> zzehm4, zzehm<String> zzehm5, zzehm<String> zzehm6, zzehm<Context> zzehm7, zzehm<zzdgz> zzehm8, zzehm<Clock> zzehm9, zzehm<zzdt> zzehm10) {
        this.zzenm = zzehm;
        this.zzeoh = zzehm2;
        this.zzhaq = zzehm3;
        this.zzfib = zzehm4;
        this.zzgmb = zzehm5;
        this.zzgml = zzehm6;
        this.zzenp = zzehm7;
        this.zzfek = zzehm8;
        this.zzfhq = zzehm9;
        this.zzfgx = zzehm10;
    }

    public static zzdlf zzb(zzehm<Executor> zzehm, zzehm<zzbaa> zzehm2, zzehm<zzcqi> zzehm3, zzehm<zzazz> zzehm4, zzehm<String> zzehm5, zzehm<String> zzehm6, zzehm<Context> zzehm7, zzehm<zzdgz> zzehm8, zzehm<Clock> zzehm9, zzehm<zzdt> zzehm10) {
        return new zzdlf(zzehm, zzehm2, zzehm3, zzehm4, zzehm5, zzehm6, zzehm7, zzehm8, zzehm9, zzehm10);
    }

    public final /* synthetic */ Object get() {
        return new zzdld(this.zzenm.get(), this.zzeoh.get(), this.zzhaq.get(), this.zzfib.get(), this.zzgmb.get(), this.zzgml.get(), this.zzenp.get(), this.zzfek.get(), this.zzfhq.get(), this.zzfgx.get());
    }
}
