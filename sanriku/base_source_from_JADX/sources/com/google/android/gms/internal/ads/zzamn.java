package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;

final class zzamn implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> {
    private final /* synthetic */ zzalv zzdgy;
    private final /* synthetic */ zzaml zzdgz;

    zzamn(zzaml zzaml, zzalv zzalv) {
        this.zzdgz = zzaml;
        this.zzdgy = zzalv;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final MediationRewardedAdCallback onSuccess(MediationRewardedAd mediationRewardedAd) {
        try {
            MediationRewardedAd unused = this.zzdgz.zzdgt = mediationRewardedAd;
            this.zzdgy.onAdLoaded();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
        return new zzauc(this.zzdgy);
    }

    public final void onFailure(String str) {
        try {
            String canonicalName = this.zzdgz.zzdgp.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 31 + String.valueOf(str).length());
            sb.append(canonicalName);
            sb.append("failed to loaded mediation ad: ");
            sb.append(str);
            zzazw.zzed(sb.toString());
            this.zzdgy.zzc(0, str);
            this.zzdgy.onAdFailedToLoad(0);
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
    }
}
