package com.google.android.gms.internal.ads;

public final class zzbmu implements zzegz<zzcnj<zzblx>> {
    private final zzehm<zzcru<zzblx, zzdhq, zzcot>> zzeua;
    private final zzehm<Boolean> zzfbw;
    private final zzehm<zzcqc> zzfby;

    public zzbmu(zzehm<Boolean> zzehm, zzehm<zzcqc> zzehm2, zzehm<zzcru<zzblx, zzdhq, zzcot>> zzehm3) {
        this.zzfbw = zzehm;
        this.zzfby = zzehm2;
        this.zzeua = zzehm3;
    }

    public final /* synthetic */ Object get() {
        boolean booleanValue = this.zzfbw.get().booleanValue();
        zzcnj zzcnj = (zzcqc) this.zzfby.get();
        zzcnj zzcnj2 = (zzcru) this.zzeua.get();
        if (!booleanValue) {
            zzcnj = zzcnj2;
        }
        return (zzcnj) zzehf.zza(zzcnj, "Cannot return null from a non-@Nullable @Provides method");
    }
}
