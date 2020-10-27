package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzaod implements MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> {
    private final /* synthetic */ zzalv zzdhr;
    private final /* synthetic */ zzanj zzdht;

    zzaod(zzaoa zzaoa, zzanj zzanj, zzalv zzalv) {
        this.zzdht = zzanj;
        this.zzdhr = zzalv;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final MediationBannerAdCallback onSuccess(MediationBannerAd mediationBannerAd) {
        if (mediationBannerAd == null) {
            zzazw.zzfc("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.zzdht.zzdo("Adapter returned null.");
                return null;
            } catch (RemoteException e) {
                zzazw.zzc("", e);
                return null;
            }
        } else {
            try {
                this.zzdht.zzx(ObjectWrapper.wrap(mediationBannerAd.getView()));
            } catch (RemoteException e2) {
                zzazw.zzc("", e2);
            }
            return new zzaog(this.zzdhr);
        }
    }

    public final void onFailure(String str) {
        try {
            this.zzdht.zzdo(str);
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
    }
}
