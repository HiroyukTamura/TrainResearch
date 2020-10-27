package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;

public final class zzuf extends zzvp {
    private final AdListener zzcee;

    public zzuf(AdListener adListener) {
        this.zzcee = adListener;
    }

    public final AdListener getAdListener() {
        return this.zzcee;
    }

    public final void onAdClicked() {
        this.zzcee.onAdClicked();
    }

    public final void onAdClosed() {
        this.zzcee.onAdClosed();
    }

    public final void onAdFailedToLoad(int i) {
        this.zzcee.onAdFailedToLoad(i);
    }

    public final void onAdImpression() {
        this.zzcee.onAdImpression();
    }

    public final void onAdLeftApplication() {
        this.zzcee.onAdLeftApplication();
    }

    public final void onAdLoaded() {
        this.zzcee.onAdLoaded();
    }

    public final void onAdOpened() {
        this.zzcee.onAdOpened();
    }
}
