package com.google.android.gms.internal.ads;

final class zzcuc implements zzdqx<zzbns> {
    private final /* synthetic */ zzctz zzgkk;
    private final /* synthetic */ zzbyp zzgkl;
    private final /* synthetic */ zzcub zzgkm;

    zzcuc(zzcub zzcub, zzctz zzctz, zzbyp zzbyp) {
        this.zzgkm = zzcub;
        this.zzgkk = zzctz;
        this.zzgkl = zzbyp;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzbns zzbns = (zzbns) obj;
        synchronized (this.zzgkm) {
            this.zzgkk.onSuccess(zzbns);
        }
    }

    public final void zzb(Throwable th) {
        this.zzgkl.zzaee().onAdFailedToLoad(zzcjk.zzd(th));
        zzdhn.zzc(th, "NativeAdLoader.onFailure");
        this.zzgkk.zzapn();
    }
}
