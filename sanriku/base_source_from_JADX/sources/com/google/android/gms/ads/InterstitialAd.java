package com.google.android.gms.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzub;
import com.google.android.gms.internal.ads.zzxx;

public final class InterstitialAd {
    private final zzxx zzacn;

    public InterstitialAd(Context context) {
        this.zzacn = new zzxx(context);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    public final AdListener getAdListener() {
        return this.zzacn.getAdListener();
    }

    public final Bundle getAdMetadata() {
        return this.zzacn.getAdMetadata();
    }

    public final String getAdUnitId() {
        return this.zzacn.getAdUnitId();
    }

    @Deprecated
    public final String getMediationAdapterClassName() {
        return this.zzacn.getMediationAdapterClassName();
    }

    @Nullable
    public final ResponseInfo getResponseInfo() {
        return this.zzacn.getResponseInfo();
    }

    public final boolean isLoaded() {
        return this.zzacn.isLoaded();
    }

    public final boolean isLoading() {
        return this.zzacn.isLoading();
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(AdRequest adRequest) {
        this.zzacn.zza(adRequest.zzdq());
    }

    public final void setAdListener(AdListener adListener) {
        this.zzacn.setAdListener(adListener);
        if (adListener != null && (adListener instanceof zzub)) {
            this.zzacn.zza((zzub) adListener);
        } else if (adListener == null) {
            this.zzacn.zza((zzub) null);
        }
    }

    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        this.zzacn.setAdMetadataListener(adMetadataListener);
    }

    public final void setAdUnitId(String str) {
        this.zzacn.setAdUnitId(str);
    }

    public final void setImmersiveMode(boolean z) {
        this.zzacn.setImmersiveMode(z);
    }

    public final void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        this.zzacn.setOnPaidEventListener(onPaidEventListener);
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.zzacn.setRewardedVideoAdListener(rewardedVideoAdListener);
    }

    public final void show() {
        this.zzacn.show();
    }

    public final void zzd(boolean z) {
        this.zzacn.zzd(true);
    }
}
