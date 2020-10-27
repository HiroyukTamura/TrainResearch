package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeUnit;

public final class zzcuz implements zzegz<zzdri<zzcvd>> {
    private final zzehm<zzdku> zzfju;
    private final zzehm<zzcvc> zzgld;
    private final zzehm<zzbqc> zzgle;

    public zzcuz(zzehm<zzdku> zzehm, zzehm<zzcvc> zzehm2, zzehm<zzbqc> zzehm3) {
        this.zzfju = zzehm;
        this.zzgld = zzehm2;
        this.zzgle = zzehm3;
    }

    public final /* synthetic */ Object get() {
        return (zzdri) zzehf.zza(this.zzfju.get().zza(zzdkr.GENERATE_SIGNALS, this.zzgle.get().zzail()).zza(this.zzgld.get()).zza((long) ((Integer) zzvj.zzpv().zzd(zzzz.zzcrr)).intValue(), TimeUnit.SECONDS).zzaud(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
