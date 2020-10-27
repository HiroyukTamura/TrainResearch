package com.google.android.gms.internal.ads;

public final class zzbyd implements zzbqx {
    private final zzbro zzfpi;
    private final zzdgo zzfpj;

    public zzbyd(zzbro zzbro, zzdgo zzdgo) {
        this.zzfpi = zzbro;
        this.zzfpj = zzdgo;
    }

    public final void onAdClosed() {
    }

    public final void onAdLeftApplication() {
    }

    public final void onAdOpened() {
        int i = this.zzfpj.zzgub;
        if (i == 0 || i == 1) {
            this.zzfpi.onAdImpression();
        }
    }

    public final void onRewardedVideoCompleted() {
    }

    public final void onRewardedVideoStarted() {
    }

    public final void zzb(zzasd zzasd, String str, String str2) {
    }
}
