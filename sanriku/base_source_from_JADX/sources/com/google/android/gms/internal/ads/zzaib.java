package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.instream.InstreamAd;

public final class zzaib extends zzahx {
    private final InstreamAd.InstreamAdLoadCallback zzdbp;

    public zzaib(InstreamAd.InstreamAdLoadCallback instreamAdLoadCallback) {
        this.zzdbp = instreamAdLoadCallback;
    }

    public final void onInstreamAdFailedToLoad(int i) {
        this.zzdbp.onInstreamAdFailedToLoad(i);
    }

    public final void zza(zzaho zzaho) {
        this.zzdbp.onInstreamAdLoaded(new zzahz(zzaho));
    }
}
