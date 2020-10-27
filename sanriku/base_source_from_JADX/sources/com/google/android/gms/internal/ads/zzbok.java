package com.google.android.gms.internal.ads;

public final class zzbok implements zzegz<String> {
    private final zzboi zzflg;

    private zzbok(zzboi zzboi) {
        this.zzflg = zzboi;
    }

    public static zzbok zza(zzboi zzboi) {
        return new zzbok(zzboi);
    }

    public static String zzb(zzboi zzboi) {
        return (String) zzehf.zza(zzboi.zzaig(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzb(this.zzflg);
    }
}
