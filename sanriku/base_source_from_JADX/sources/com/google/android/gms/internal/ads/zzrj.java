package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.appopen.AppOpenAdPresentationCallback;

public final class zzrj extends zzrr {
    private final AppOpenAdPresentationCallback zzbry;

    public zzrj(AppOpenAdPresentationCallback appOpenAdPresentationCallback) {
        this.zzbry = appOpenAdPresentationCallback;
    }

    public final void onAppOpenAdClosed() {
        this.zzbry.onAppOpenAdClosed();
    }
}
