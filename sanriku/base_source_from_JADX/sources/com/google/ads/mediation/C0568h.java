package com.google.ads.mediation;

import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

/* renamed from: com.google.ads.mediation.h */
final class C0568h implements RewardedVideoAdListener {

    /* renamed from: a */
    private final /* synthetic */ AbstractAdViewAdapter f121a;

    C0568h(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.f121a = abstractAdViewAdapter;
    }

    public final void onRewarded(RewardItem rewardItem) {
        this.f121a.zzmb.onRewarded(this.f121a, rewardItem);
    }

    public final void onRewardedVideoAdClosed() {
        this.f121a.zzmb.onAdClosed(this.f121a);
        InterstitialAd unused = this.f121a.zzma = null;
    }

    public final void onRewardedVideoAdFailedToLoad(int i) {
        this.f121a.zzmb.onAdFailedToLoad(this.f121a, i);
    }

    public final void onRewardedVideoAdLeftApplication() {
        this.f121a.zzmb.onAdLeftApplication(this.f121a);
    }

    public final void onRewardedVideoAdLoaded() {
        this.f121a.zzmb.onAdLoaded(this.f121a);
    }

    public final void onRewardedVideoAdOpened() {
        this.f121a.zzmb.onAdOpened(this.f121a);
    }

    public final void onRewardedVideoCompleted() {
        this.f121a.zzmb.onVideoCompleted(this.f121a);
    }

    public final void onRewardedVideoStarted() {
        this.f121a.zzmb.onVideoStarted(this.f121a);
    }
}
