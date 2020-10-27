package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzbpc implements zzbqx, zzbrp, zzbsm, zzbtm, zzub {
    private final Clock zzbnt;
    private final zzawc zzfly;

    public zzbpc(Clock clock, zzawc zzawc) {
        this.zzbnt = clock;
        this.zzfly = zzawc;
    }

    public final void onAdClicked() {
        this.zzfly.zzvs();
    }

    public final void onAdClosed() {
        this.zzfly.zzvt();
    }

    public final void onAdImpression() {
        this.zzfly.zzvr();
    }

    public final void onAdLeftApplication() {
    }

    public final void onAdLoaded() {
        this.zzfly.zzan(true);
    }

    public final void onAdOpened() {
    }

    public final void onRewardedVideoCompleted() {
    }

    public final void onRewardedVideoStarted() {
    }

    public final void zzb(zzasd zzasd, String str, String str2) {
    }

    public final void zzb(zzdha zzdha) {
        this.zzfly.zzey(this.zzbnt.elapsedRealtime());
    }

    public final void zzd(zzarj zzarj) {
    }

    public final void zzf(zzuj zzuj) {
        this.zzfly.zze(zzuj);
    }

    public final String zzvu() {
        return this.zzfly.zzvu();
    }
}
