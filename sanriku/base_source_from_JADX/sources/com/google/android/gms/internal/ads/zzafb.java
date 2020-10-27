package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeContentAd;

public final class zzafb extends zzadw {
    private final NativeContentAd.OnContentAdLoadedListener zzczn;

    public zzafb(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
        this.zzczn = onContentAdLoadedListener;
    }

    public final void zza(zzadk zzadk) {
        this.zzczn.onContentAdLoaded(new zzadp(zzadk));
    }
}
