package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zztf;

public final class zzbya implements zzegz<zzbyb> {
    private final zzehm<Context> zzenp;
    private final zzehm<zzazz> zzffv;
    private final zzehm<zztf.zza.C2669zza> zzfic;
    private final zzehm<zzbek> zzfjg;
    private final zzehm<zzdgo> zzfkc;

    private zzbya(zzehm<Context> zzehm, zzehm<zzbek> zzehm2, zzehm<zzdgo> zzehm3, zzehm<zzazz> zzehm4, zzehm<zztf.zza.C2669zza> zzehm5) {
        this.zzenp = zzehm;
        this.zzfjg = zzehm2;
        this.zzfkc = zzehm3;
        this.zzffv = zzehm4;
        this.zzfic = zzehm5;
    }

    public static zzbya zzc(zzehm<Context> zzehm, zzehm<zzbek> zzehm2, zzehm<zzdgo> zzehm3, zzehm<zzazz> zzehm4, zzehm<zztf.zza.C2669zza> zzehm5) {
        return new zzbya(zzehm, zzehm2, zzehm3, zzehm4, zzehm5);
    }

    public final /* synthetic */ Object get() {
        return new zzbyb(this.zzenp.get(), this.zzfjg.get(), this.zzfkc.get(), this.zzffv.get(), this.zzfic.get());
    }
}
