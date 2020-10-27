package com.google.android.gms.ads;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzxw;
import com.google.android.gms.internal.ads.zzyf;

public class MobileAds {

    @Deprecated
    public static final class Settings {
        private final zzyf zzaco = new zzyf();

        @Deprecated
        public final String getTrackingId() {
            return null;
        }

        @Deprecated
        public final boolean isGoogleAnalyticsEnabled() {
            return false;
        }

        @Deprecated
        public final Settings setGoogleAnalyticsEnabled(boolean z) {
            return this;
        }

        @Deprecated
        public final Settings setTrackingId(String str) {
            return this;
        }
    }

    private MobileAds() {
    }

    public static InitializationStatus getInitializationStatus() {
        return zzxw.zzqq().getInitializationStatus();
    }

    @NonNull
    public static RequestConfiguration getRequestConfiguration() {
        return zzxw.zzqq().getRequestConfiguration();
    }

    public static RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        return zzxw.zzqq().getRewardedVideoAdInstance(context);
    }

    public static String getVersionString() {
        return zzxw.zzqq().getVersionString();
    }

    @RequiresPermission("android.permission.INTERNET")
    public static void initialize(Context context) {
        initialize(context, (String) null, (Settings) null);
    }

    public static void initialize(Context context, OnInitializationCompleteListener onInitializationCompleteListener) {
        zzxw.zzqq().zza(context, (String) null, onInitializationCompleteListener);
    }

    @RequiresPermission("android.permission.INTERNET")
    @Deprecated
    public static void initialize(Context context, String str) {
        initialize(context, str, (Settings) null);
    }

    @RequiresPermission("android.permission.INTERNET")
    @Deprecated
    public static void initialize(Context context, String str, Settings settings) {
        zzxw.zzqq().zza(context, str, (OnInitializationCompleteListener) null);
    }

    public static void openDebugMenu(Context context, String str) {
        zzxw.zzqq().openDebugMenu(context, str);
    }

    @KeepForSdk
    public static void registerRtbAdapter(Class<? extends RtbAdapter> cls) {
        zzxw.zzqq().registerRtbAdapter(cls);
    }

    public static void setAppMuted(boolean z) {
        zzxw.zzqq().setAppMuted(z);
    }

    public static void setAppVolume(float f) {
        zzxw.zzqq().setAppVolume(f);
    }

    public static void setRequestConfiguration(@NonNull RequestConfiguration requestConfiguration) {
        zzxw.zzqq().setRequestConfiguration(requestConfiguration);
    }
}
