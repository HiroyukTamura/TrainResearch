package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;

final class zzaoc implements MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> {
    private final /* synthetic */ zzank zzdhq;
    private final /* synthetic */ zzalv zzdhr;
    private final /* synthetic */ zzaoa zzdhs;

    zzaoc(zzaoa zzaoa, zzank zzank, zzalv zzalv) {
        this.zzdhs = zzaoa;
        this.zzdhq = zzank;
        this.zzdhr = zzalv;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final MediationInterstitialAdCallback onSuccess(MediationInterstitialAd mediationInterstitialAd) {
        if (mediationInterstitialAd == null) {
            zzazw.zzfc("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.zzdhq.zzdo("Adapter returned null.");
                return null;
            } catch (RemoteException e) {
                zzazw.zzc("", e);
                return null;
            }
        } else {
            try {
                MediationInterstitialAd unused = this.zzdhs.zzdho = mediationInterstitialAd;
                this.zzdhq.zzty();
            } catch (RemoteException e2) {
                zzazw.zzc("", e2);
            }
            return new zzaog(this.zzdhr);
        }
    }

    public final void onFailure(String str) {
        try {
            this.zzdhq.zzdo(str);
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
    }
}
