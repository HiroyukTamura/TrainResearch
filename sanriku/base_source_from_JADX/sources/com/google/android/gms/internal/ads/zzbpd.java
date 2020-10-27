package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzbpd implements zzegz<zzawc> {
    private final zzehm<zzawo> zzeqb;
    private final zzehm<Clock> zzfhq;
    private final zzehm<zzdhe> zzfjq;

    private zzbpd(zzehm<Clock> zzehm, zzehm<zzawo> zzehm2, zzehm<zzdhe> zzehm3) {
        this.zzfhq = zzehm;
        this.zzeqb = zzehm2;
        this.zzfjq = zzehm3;
    }

    public static zzbpd zzg(zzehm<Clock> zzehm, zzehm<zzawo> zzehm2, zzehm<zzdhe> zzehm3) {
        return new zzbpd(zzehm, zzehm2, zzehm3);
    }

    public final /* synthetic */ Object get() {
        return (zzawc) zzehf.zza(this.zzeqb.get().zza(this.zzfhq.get(), this.zzfjq.get().zzgux), "Cannot return null from a non-@Nullable @Provides method");
    }
}
