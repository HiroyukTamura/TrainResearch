package com.google.android.gms.internal.ads;

final class zzcor implements zzdqx<zzblx> {
    private final /* synthetic */ zzcom zzgfj;

    zzcor(zzcom zzcom) {
        this.zzgfj = zzcom;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        ((zzblx) obj).zzahk();
    }

    public final void zzb(Throwable th) {
        this.zzgfj.zzfoe.onAdFailedToLoad(zzcjk.zzd(th));
        zzdhn.zzc(th, "DelayedBannerAd.onFailure");
    }
}
