package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzchm implements zzegz<zzchn> {
    private final zzehm<Context> zzenp;
    private final zzehm<zzdhm> zzeph;
    private final zzehm<zzchz> zzepi;
    private final zzehm<zzdgo> zzfgv;
    private final zzehm<zzdha> zzfys;

    private zzchm(zzehm<Context> zzehm, zzehm<zzdhm> zzehm2, zzehm<zzchz> zzehm3, zzehm<zzdha> zzehm4, zzehm<zzdgo> zzehm5) {
        this.zzenp = zzehm;
        this.zzeph = zzehm2;
        this.zzepi = zzehm3;
        this.zzfys = zzehm4;
        this.zzfgv = zzehm5;
    }

    public static zzchm zzf(zzehm<Context> zzehm, zzehm<zzdhm> zzehm2, zzehm<zzchz> zzehm3, zzehm<zzdha> zzehm4, zzehm<zzdgo> zzehm5) {
        return new zzchm(zzehm, zzehm2, zzehm3, zzehm4, zzehm5);
    }

    public final /* synthetic */ Object get() {
        return new zzchn(this.zzenp.get(), this.zzeph.get(), this.zzepi.get(), this.zzfys.get(), this.zzfgv.get());
    }
}
