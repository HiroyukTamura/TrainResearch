package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;

final class zzaoh implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> {
    private final /* synthetic */ zzalv zzdhr;
    private final /* synthetic */ zzaoa zzdhs;
    private final /* synthetic */ zzanq zzdhx;

    zzaoh(zzaoa zzaoa, zzanq zzanq, zzalv zzalv) {
        this.zzdhs = zzaoa;
        this.zzdhx = zzanq;
        this.zzdhr = zzalv;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final MediationRewardedAdCallback onSuccess(MediationRewardedAd mediationRewardedAd) {
        if (mediationRewardedAd == null) {
            zzazw.zzfc("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.zzdhx.zzdo("Adapter returned null.");
                return null;
            } catch (RemoteException e) {
                zzazw.zzc("", e);
                return null;
            }
        } else {
            try {
                MediationRewardedAd unused = this.zzdhs.zzdgt = mediationRewardedAd;
                this.zzdhx.zzty();
            } catch (RemoteException e2) {
                zzazw.zzc("", e2);
            }
            return new zzaog(this.zzdhr);
        }
    }

    public final void onFailure(String str) {
        try {
            this.zzdhx.zzdo(str);
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
    }
}
