package com.google.android.gms.internal.ads;

public final class zzbqo implements zzegz<String> {
    private final zzehm<zzbpc> zzeqe;
    private final zzbqj zzfmy;

    private zzbqo(zzbqj zzbqj, zzehm<zzbpc> zzehm) {
        this.zzfmy = zzbqj;
        this.zzeqe = zzehm;
    }

    public static String zza(zzbqj zzbqj, zzbpc zzbpc) {
        return (String) zzehf.zza(zzbpc.zzvu(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static zzbqo zzb(zzbqj zzbqj, zzehm<zzbpc> zzehm) {
        return new zzbqo(zzbqj, zzehm);
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfmy, this.zzeqe.get());
    }
}
