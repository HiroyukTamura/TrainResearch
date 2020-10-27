package com.google.android.gms.internal.ads;

public final class zzbku implements zzegz<zzaku> {
    private final zzehm<zzakp> zzfhz;

    private zzbku(zzehm<zzakp> zzehm) {
        this.zzfhz = zzehm;
    }

    public static zzbku zzb(zzehm<zzakp> zzehm) {
        return new zzbku(zzehm);
    }

    public final /* synthetic */ Object get() {
        return (zzaku) zzehf.zza(this.zzfhz.get().zztc(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
