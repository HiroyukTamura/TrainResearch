package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.internal.ads.zzach;

final /* synthetic */ class zze implements zzach {
    private final UnifiedNativeAdView zzbln;

    zze(UnifiedNativeAdView unifiedNativeAdView) {
        this.zzbln = unifiedNativeAdView;
    }

    public final void setMediaContent(MediaContent mediaContent) {
        this.zzbln.zza(mediaContent);
    }
}
