package com.google.android.gms.internal.ads;

public final class zzbyn implements zzegz<zzbyl> {
    private final zzbyl zzfpr;

    private zzbyn(zzbyl zzbyl) {
        this.zzfpr = zzbyl;
    }

    public static zzbyn zze(zzbyl zzbyl) {
        return new zzbyn(zzbyl);
    }

    public final /* synthetic */ Object get() {
        zzbyl zzbyl = this.zzfpr;
        if (zzbyl != null) {
            return (zzbyl) zzehf.zza(zzbyl, "Cannot return null from a non-@Nullable @Provides method");
        }
        throw null;
    }
}
