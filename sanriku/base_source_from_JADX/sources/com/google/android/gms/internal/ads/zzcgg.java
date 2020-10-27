package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zztf;

public final class zzcgg implements zzegz<zzst> {
    private final zzehm<Context> zzenp;
    private final zzehm<zztf.zza.C2669zza> zzfic;
    private final zzehm<String> zzfmo;
    private final zzehm<zzazz> zzfnd;
    private final zzehm<String> zzfxx;

    private zzcgg(zzehm<Context> zzehm, zzehm<String> zzehm2, zzehm<zzazz> zzehm3, zzehm<zztf.zza.C2669zza> zzehm4, zzehm<String> zzehm5) {
        this.zzenp = zzehm;
        this.zzfmo = zzehm2;
        this.zzfnd = zzehm3;
        this.zzfic = zzehm4;
        this.zzfxx = zzehm5;
    }

    public static zzcgg zze(zzehm<Context> zzehm, zzehm<String> zzehm2, zzehm<zzazz> zzehm3, zzehm<zztf.zza.C2669zza> zzehm4, zzehm<String> zzehm5) {
        return new zzcgg(zzehm, zzehm2, zzehm3, zzehm4, zzehm5);
    }

    public final /* synthetic */ Object get() {
        String str = this.zzfmo.get();
        zzazz zzazz = this.zzfnd.get();
        zztf.zza.C2669zza zza = this.zzfic.get();
        String str2 = this.zzfxx.get();
        zzst zzst = new zzst(new zzsy(this.zzenp.get()));
        zzst.zza((zzsw) new zzcgh(zza, str, (zztf.zzu) ((zzecd) zztf.zzu.zzos().zzcn(zzazz.zzdzn).zzco(zzazz.zzdzo).zzcp(zzazz.zzdzp ? 0 : 2).zzbet()), str2));
        return (zzst) zzehf.zza(zzst, "Cannot return null from a non-@Nullable @Provides method");
    }
}
