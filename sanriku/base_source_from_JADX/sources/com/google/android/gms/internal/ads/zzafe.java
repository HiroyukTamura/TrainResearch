package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

public final class zzafe extends zzaek {
    private final UnifiedNativeAd.OnUnifiedNativeAdLoadedListener zzczq;

    public zzafe(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
        this.zzczq = onUnifiedNativeAdLoadedListener;
    }

    public final void zza(zzaes zzaes) {
        this.zzczq.onUnifiedNativeAdLoaded(new zzaex(zzaes));
    }
}
