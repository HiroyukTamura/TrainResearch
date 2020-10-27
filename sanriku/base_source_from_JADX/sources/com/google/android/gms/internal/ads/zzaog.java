package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardItem;

final class zzaog implements MediationBannerAdCallback, MediationInterstitialAdCallback, MediationNativeAdCallback, MediationRewardedAdCallback {
    private zzalv zzdhw;

    zzaog(zzalv zzalv) {
        this.zzdhw = zzalv;
    }

    public final void onAdClosed() {
        try {
            this.zzdhw.onAdClosed();
        } catch (RemoteException unused) {
        }
    }

    public final void onAdFailedToShow(String str) {
        try {
            String valueOf = String.valueOf(str);
            zzazw.zzfc(valueOf.length() != 0 ? "Mediated ad failed to show: ".concat(valueOf) : new String("Mediated ad failed to show: "));
            this.zzdhw.zzdm(str);
        } catch (RemoteException unused) {
        }
    }

    public final void onAdLeftApplication() {
        try {
            this.zzdhw.onAdLeftApplication();
        } catch (RemoteException unused) {
        }
    }

    public final void onAdOpened() {
        try {
            this.zzdhw.onAdOpened();
        } catch (RemoteException unused) {
        }
    }

    public final void onUserEarnedReward(RewardItem rewardItem) {
        try {
            this.zzdhw.zza((zzate) new zzaub(rewardItem));
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoComplete() {
        try {
            this.zzdhw.onVideoEnd();
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoMute() {
    }

    public final void onVideoPause() {
    }

    public final void onVideoPlay() {
        try {
            this.zzdhw.onVideoPlay();
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoStart() {
        try {
            this.zzdhw.zztp();
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoUnmute() {
    }

    public final void reportAdClicked() {
        try {
            this.zzdhw.onAdClicked();
        } catch (RemoteException unused) {
        }
    }

    public final void reportAdImpression() {
        try {
            this.zzdhw.onAdImpression();
        } catch (RemoteException unused) {
        }
    }
}
