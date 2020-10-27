package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzazw;
import p009e.p010a.p011a.p012a.C0681a;

@KeepName
@KeepForSdkWithMembers
public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {
    @VisibleForTesting
    private CustomEventBanner zzemy;
    @VisibleForTesting
    private CustomEventInterstitial zzemz;
    @VisibleForTesting
    private CustomEventNative zzena;
    private View zzms;

    @VisibleForTesting
    static final class zza implements CustomEventBannerListener {
        private final CustomEventAdapter zzemw;
        private final MediationBannerListener zzemx;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.zzemw = customEventAdapter;
            this.zzemx = mediationBannerListener;
        }

        public final void onAdClicked() {
            zzazw.zzed("Custom event adapter called onAdClicked.");
            this.zzemx.onAdClicked(this.zzemw);
        }

        public final void onAdClosed() {
            zzazw.zzed("Custom event adapter called onAdClosed.");
            this.zzemx.onAdClosed(this.zzemw);
        }

        public final void onAdFailedToLoad(int i) {
            zzazw.zzed("Custom event adapter called onAdFailedToLoad.");
            this.zzemx.onAdFailedToLoad(this.zzemw, i);
        }

        public final void onAdLeftApplication() {
            zzazw.zzed("Custom event adapter called onAdLeftApplication.");
            this.zzemx.onAdLeftApplication(this.zzemw);
        }

        public final void onAdLoaded(View view) {
            zzazw.zzed("Custom event adapter called onAdLoaded.");
            this.zzemw.zza(view);
            this.zzemx.onAdLoaded(this.zzemw);
        }

        public final void onAdOpened() {
            zzazw.zzed("Custom event adapter called onAdOpened.");
            this.zzemx.onAdOpened(this.zzemw);
        }
    }

    @VisibleForTesting
    static class zzb implements CustomEventNativeListener {
        private final CustomEventAdapter zzemw;
        private final MediationNativeListener zzenb;

        public zzb(CustomEventAdapter customEventAdapter, MediationNativeListener mediationNativeListener) {
            this.zzemw = customEventAdapter;
            this.zzenb = mediationNativeListener;
        }

        public final void onAdClicked() {
            zzazw.zzed("Custom event adapter called onAdClicked.");
            this.zzenb.onAdClicked(this.zzemw);
        }

        public final void onAdClosed() {
            zzazw.zzed("Custom event adapter called onAdClosed.");
            this.zzenb.onAdClosed(this.zzemw);
        }

        public final void onAdFailedToLoad(int i) {
            zzazw.zzed("Custom event adapter called onAdFailedToLoad.");
            this.zzenb.onAdFailedToLoad(this.zzemw, i);
        }

        public final void onAdImpression() {
            zzazw.zzed("Custom event adapter called onAdImpression.");
            this.zzenb.onAdImpression(this.zzemw);
        }

        public final void onAdLeftApplication() {
            zzazw.zzed("Custom event adapter called onAdLeftApplication.");
            this.zzenb.onAdLeftApplication(this.zzemw);
        }

        public final void onAdLoaded(NativeAdMapper nativeAdMapper) {
            zzazw.zzed("Custom event adapter called onAdLoaded.");
            this.zzenb.onAdLoaded((MediationNativeAdapter) this.zzemw, nativeAdMapper);
        }

        public final void onAdLoaded(UnifiedNativeAdMapper unifiedNativeAdMapper) {
            zzazw.zzed("Custom event adapter called onAdLoaded.");
            this.zzenb.onAdLoaded((MediationNativeAdapter) this.zzemw, unifiedNativeAdMapper);
        }

        public final void onAdOpened() {
            zzazw.zzed("Custom event adapter called onAdOpened.");
            this.zzenb.onAdOpened(this.zzemw);
        }
    }

    @VisibleForTesting
    class zzc implements CustomEventInterstitialListener {
        private final CustomEventAdapter zzemw;
        private final MediationInterstitialListener zzenc;

        public zzc(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.zzemw = customEventAdapter;
            this.zzenc = mediationInterstitialListener;
        }

        public final void onAdClicked() {
            zzazw.zzed("Custom event adapter called onAdClicked.");
            this.zzenc.onAdClicked(this.zzemw);
        }

        public final void onAdClosed() {
            zzazw.zzed("Custom event adapter called onAdClosed.");
            this.zzenc.onAdClosed(this.zzemw);
        }

        public final void onAdFailedToLoad(int i) {
            zzazw.zzed("Custom event adapter called onFailedToReceiveAd.");
            this.zzenc.onAdFailedToLoad(this.zzemw, i);
        }

        public final void onAdLeftApplication() {
            zzazw.zzed("Custom event adapter called onAdLeftApplication.");
            this.zzenc.onAdLeftApplication(this.zzemw);
        }

        public final void onAdLoaded() {
            zzazw.zzed("Custom event adapter called onReceivedAd.");
            this.zzenc.onAdLoaded(CustomEventAdapter.this);
        }

        public final void onAdOpened() {
            zzazw.zzed("Custom event adapter called onAdOpened.");
            this.zzenc.onAdOpened(this.zzemw);
        }
    }

    /* access modifiers changed from: private */
    public final void zza(View view) {
        this.zzms = view;
    }

    private static <T> T zzak(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            String message = th.getMessage();
            StringBuilder sb = new StringBuilder(C0681a.m336b(message, C0681a.m336b(str, 46)));
            sb.append("Could not instantiate custom event adapter: ");
            sb.append(str);
            sb.append(". ");
            sb.append(message);
            zzazw.zzfc(sb.toString());
            return null;
        }
    }

    public final View getBannerView() {
        return this.zzms;
    }

    public final void onDestroy() {
        CustomEventBanner customEventBanner = this.zzemy;
        if (customEventBanner != null) {
            customEventBanner.onDestroy();
        }
        CustomEventInterstitial customEventInterstitial = this.zzemz;
        if (customEventInterstitial != null) {
            customEventInterstitial.onDestroy();
        }
        CustomEventNative customEventNative = this.zzena;
        if (customEventNative != null) {
            customEventNative.onDestroy();
        }
    }

    public final void onPause() {
        CustomEventBanner customEventBanner = this.zzemy;
        if (customEventBanner != null) {
            customEventBanner.onPause();
        }
        CustomEventInterstitial customEventInterstitial = this.zzemz;
        if (customEventInterstitial != null) {
            customEventInterstitial.onPause();
        }
        CustomEventNative customEventNative = this.zzena;
        if (customEventNative != null) {
            customEventNative.onPause();
        }
    }

    public final void onResume() {
        CustomEventBanner customEventBanner = this.zzemy;
        if (customEventBanner != null) {
            customEventBanner.onResume();
        }
        CustomEventInterstitial customEventInterstitial = this.zzemz;
        if (customEventInterstitial != null) {
            customEventInterstitial.onResume();
        }
        CustomEventNative customEventNative = this.zzena;
        if (customEventNative != null) {
            customEventNative.onResume();
        }
    }

    public final void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        CustomEventBanner customEventBanner = (CustomEventBanner) zzak(bundle.getString("class_name"));
        this.zzemy = customEventBanner;
        if (customEventBanner == null) {
            mediationBannerListener.onAdFailedToLoad(this, 0);
            return;
        }
        this.zzemy.requestBannerAd(context, new zza(this, mediationBannerListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), adSize, mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        CustomEventInterstitial customEventInterstitial = (CustomEventInterstitial) zzak(bundle.getString("class_name"));
        this.zzemz = customEventInterstitial;
        if (customEventInterstitial == null) {
            mediationInterstitialListener.onAdFailedToLoad(this, 0);
            return;
        }
        this.zzemz.requestInterstitialAd(context, new zzc(this, mediationInterstitialListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    public final void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        CustomEventNative customEventNative = (CustomEventNative) zzak(bundle.getString("class_name"));
        this.zzena = customEventNative;
        if (customEventNative == null) {
            mediationNativeListener.onAdFailedToLoad(this, 0);
            return;
        }
        this.zzena.requestNativeAd(context, new zzb(this, mediationNativeListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), nativeMediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    public final void showInterstitial() {
        this.zzemz.showInterstitial();
    }
}
