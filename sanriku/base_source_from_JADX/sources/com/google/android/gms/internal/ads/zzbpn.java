package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzc;

public final class zzbpn implements zzegz<zzc> {
    private final zzehm<Context> zzenp;
    private final zzbpk zzfmc;
    private final zzehm<zzaun> zzfmd;

    private zzbpn(zzbpk zzbpk, zzehm<Context> zzehm, zzehm<zzaun> zzehm2) {
        this.zzfmc = zzbpk;
        this.zzenp = zzehm;
        this.zzfmd = zzehm2;
    }

    public static zzbpn zza(zzbpk zzbpk, zzehm<Context> zzehm, zzehm<zzaun> zzehm2) {
        return new zzbpn(zzbpk, zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return (zzc) zzehf.zza(new zzc(this.zzenp.get(), this.zzfmd.get(), (zzaqy) null), "Cannot return null from a non-@Nullable @Provides method");
    }
}
