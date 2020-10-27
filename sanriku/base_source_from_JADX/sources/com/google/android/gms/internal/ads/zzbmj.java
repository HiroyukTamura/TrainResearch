package com.google.android.gms.internal.ads;

public final class zzbmj implements zzegz<zzblx> {
    private final zzehm<zzblz> zzfcz;
    private final zzbma zzfjo;

    public zzbmj(zzbma zzbma, zzehm<zzblz> zzehm) {
        this.zzfjo = zzbma;
        this.zzfcz = zzehm;
    }

    public static zzblx zza(zzbma zzbma, Object obj) {
        return (zzblx) zzehf.zza((zzblz) obj, "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfjo, this.zzfcz.get());
    }
}
