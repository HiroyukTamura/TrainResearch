package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.common.internal.Preconditions;

public final class zzauc implements MediationRewardedAdCallback {
    private final zzalv zzdgu;

    public zzauc(zzalv zzalv) {
        this.zzdgu = zzalv;
    }

    public final void onAdClosed() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzazw.zzed("Adapter called onAdClosed.");
        try {
            this.zzdgu.onAdClosed();
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onAdFailedToShow(String str) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzazw.zzed("Adapter called onAdFailedToShow.");
        String valueOf = String.valueOf(str);
        zzazw.zzfc(valueOf.length() != 0 ? "Mediation ad failed to show: ".concat(valueOf) : new String("Mediation ad failed to show: "));
        try {
            this.zzdgu.zzdm(str);
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onAdOpened() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzazw.zzed("Adapter called onAdOpened.");
        try {
            this.zzdgu.onAdOpened();
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onUserEarnedReward(RewardItem rewardItem) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzazw.zzed("Adapter called onUserEarnedReward.");
        try {
            this.zzdgu.zza((zzate) new zzaub(rewardItem));
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onVideoComplete() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzazw.zzed("Adapter called onVideoComplete.");
        try {
            this.zzdgu.zztq();
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onVideoStart() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzazw.zzed("Adapter called onVideoStart.");
        try {
            this.zzdgu.zztp();
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }

    public final void reportAdClicked() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzazw.zzed("Adapter called reportAdClicked.");
        try {
            this.zzdgu.onAdClicked();
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }

    public final void reportAdImpression() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzazw.zzed("Adapter called reportAdImpression.");
        try {
            this.zzdgu.onAdImpression();
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }
}
