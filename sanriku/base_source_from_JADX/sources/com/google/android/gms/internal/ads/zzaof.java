package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;

final class zzaof implements MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> {
    private final /* synthetic */ zzalv zzdhr;
    private final /* synthetic */ zzanp zzdhv;

    zzaof(zzaoa zzaoa, zzanp zzanp, zzalv zzalv) {
        this.zzdhv = zzanp;
        this.zzdhr = zzalv;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final MediationNativeAdCallback onSuccess(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        if (unifiedNativeAdMapper == null) {
            zzazw.zzfc("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.zzdhv.zzdo("Adapter returned null.");
                return null;
            } catch (RemoteException e) {
                zzazw.zzc("", e);
                return null;
            }
        } else {
            try {
                this.zzdhv.zza(new zzang(unifiedNativeAdMapper));
            } catch (RemoteException e2) {
                zzazw.zzc("", e2);
            }
            return new zzaog(this.zzdhr);
        }
    }

    public final void onFailure(String str) {
        try {
            this.zzdhv.zzdo(str);
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
    }
}
