package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzxx;

public final class PublisherInterstitialAd {
    private final zzxx zzacn;

    public PublisherInterstitialAd(Context context) {
        this.zzacn = new zzxx(context, this);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    public final AdListener getAdListener() {
        return this.zzacn.getAdListener();
    }

    public final String getAdUnitId() {
        return this.zzacn.getAdUnitId();
    }

    public final AppEventListener getAppEventListener() {
        return this.zzacn.getAppEventListener();
    }

    @Deprecated
    public final String getMediationAdapterClassName() {
        return this.zzacn.getMediationAdapterClassName();
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzacn.getOnCustomRenderedAdLoadedListener();
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
    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        this.zzacn.zza(publisherAdRequest.zzdq());
    }

    public final void setAdListener(AdListener adListener) {
        this.zzacn.setAdListener(adListener);
    }

    public final void setAdUnitId(String str) {
        this.zzacn.setAdUnitId(str);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        this.zzacn.setAppEventListener(appEventListener);
    }

    @KeepForSdk
    @Deprecated
    public final void setCorrelator(Correlator correlator) {
    }

    public final void setImmersiveMode(boolean z) {
        this.zzacn.setImmersiveMode(z);
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzacn.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener);
    }

    public final void show() {
        this.zzacn.show();
    }
}
