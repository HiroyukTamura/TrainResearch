package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

public final class zzafh extends zzaeq {
    private final UnifiedNativeAd.UnconfirmedClickListener zzczv;

    public zzafh(UnifiedNativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        this.zzczv = unconfirmedClickListener;
    }

    public final void onUnconfirmedClickCancelled() {
        this.zzczv.onUnconfirmedClickCancelled();
    }

    public final void onUnconfirmedClickReceived(String str) {
        this.zzczv.onUnconfirmedClickReceived(str);
    }
}
