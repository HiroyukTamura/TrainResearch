package com.google.android.gms.ads.rewarded;

import androidx.annotation.NonNull;

public abstract class RewardedAdCallback {
    public static final int ERROR_CODE_AD_REUSED = 1;
    public static final int ERROR_CODE_APP_NOT_FOREGROUND = 3;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_NOT_READY = 2;

    public void onRewardedAdClosed() {
    }

    public void onRewardedAdFailedToShow(int i) {
    }

    public void onRewardedAdOpened() {
    }

    public abstract void onUserEarnedReward(@NonNull RewardItem rewardItem);
}
