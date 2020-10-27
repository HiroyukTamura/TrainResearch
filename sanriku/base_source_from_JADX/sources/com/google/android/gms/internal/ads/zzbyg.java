package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.internal.ads.zztf;

public final class zzbyg implements zzegz<zzbyh> {
    private final zzehm<Context> zzenp;
    private final zzehm<zzauu> zzffy;
    private final zzehm<View> zzfgw;
    private final zzehm<zztf.zza.C2669zza> zzfic;
    private final zzehm<zzaur> zzfko;

    private zzbyg(zzehm<zzaur> zzehm, zzehm<Context> zzehm2, zzehm<zzauu> zzehm3, zzehm<View> zzehm4, zzehm<zztf.zza.C2669zza> zzehm5) {
        this.zzfko = zzehm;
        this.zzenp = zzehm2;
        this.zzffy = zzehm3;
        this.zzfgw = zzehm4;
        this.zzfic = zzehm5;
    }

    public static zzbyg zzd(zzehm<zzaur> zzehm, zzehm<Context> zzehm2, zzehm<zzauu> zzehm3, zzehm<View> zzehm4, zzehm<zztf.zza.C2669zza> zzehm5) {
        return new zzbyg(zzehm, zzehm2, zzehm3, zzehm4, zzehm5);
    }

    public final /* synthetic */ Object get() {
        return new zzbyh(this.zzfko.get(), this.zzenp.get(), this.zzffy.get(), this.zzfgw.get(), this.zzfic.get());
    }
}
