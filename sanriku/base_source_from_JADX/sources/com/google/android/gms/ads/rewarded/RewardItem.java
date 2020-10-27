package com.google.android.gms.ads.rewarded;

public interface RewardItem {
    public static final RewardItem DEFAULT_REWARD = new zza();

    int getAmount();

    String getType();
}
