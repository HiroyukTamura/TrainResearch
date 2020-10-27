package com.google.android.gms.internal.ads;

public final class zzbva implements zzegz<zzbuj> {
    private final zzbuj zzfoh;

    private zzbva(zzbuj zzbuj) {
        this.zzfoh = zzbuj;
    }

    public static zzbva zzv(zzbuj zzbuj) {
        return new zzbva(zzbuj);
    }

    public final /* synthetic */ Object get() {
        zzbuj zzbuj = this.zzfoh;
        if (zzbuj != null) {
            return (zzbuj) zzehf.zza(zzbuj, "Cannot return null from a non-@Nullable @Provides method");
        }
        throw null;
    }
}
