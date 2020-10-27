package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.util.PlatformVersion;

public final class zzaol implements MediationInterstitialAdapter {
    private Uri uri;
    /* access modifiers changed from: private */
    public Activity zzdia;
    /* access modifiers changed from: private */
    public MediationInterstitialListener zzdib;

    public final void onDestroy() {
        zzazw.zzed("Destroying AdMobCustomTabsAdapter adapter.");
    }

    public final void onPause() {
        zzazw.zzed("Pausing AdMobCustomTabsAdapter adapter.");
    }

    public final void onResume() {
        zzazw.zzed("Resuming AdMobCustomTabsAdapter adapter.");
    }

    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzdib = mediationInterstitialListener;
        if (mediationInterstitialListener == null) {
            zzazw.zzfc("Listener not set for mediation. Returning.");
        } else if (!(context instanceof Activity)) {
            zzazw.zzfc("AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.zzdib.onAdFailedToLoad(this, 0);
        } else {
            if (!(PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzaaw.zzj(context))) {
                zzazw.zzfc("Default browser does not support custom tabs. Bailing out.");
                this.zzdib.onAdFailedToLoad(this, 0);
                return;
            }
            String string = bundle.getString("tab_url");
            if (TextUtils.isEmpty(string)) {
                zzazw.zzfc("The tab_url retrieved from mediation metadata is empty. Bailing out.");
                this.zzdib.onAdFailedToLoad(this, 0);
                return;
            }
            this.zzdia = (Activity) context;
            this.uri = Uri.parse(string);
            this.zzdib.onAdLoaded(this);
        }
    }

    public final void showInterstitial() {
        CustomTabsIntent build = new CustomTabsIntent.Builder().build();
        build.intent.setData(this.uri);
        zzaxa.zzdwf.post(new zzaon(this, new AdOverlayInfoParcel(new zzd(build.intent), (zzub) null, new zzaok(this), (zzt) null, new zzazz(0, 0, false))));
        zzq.zzla().zzvx();
    }
}
