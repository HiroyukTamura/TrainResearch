package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.appopen.AppOpenAd;

public final class zzrt extends AppOpenAd {
    private final zzrm zzbsa;

    public zzrt(zzrm zzrm) {
        this.zzbsa = zzrm;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzrs zzrs) {
        try {
            this.zzbsa.zza(zzrs);
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
    }

    /* access modifiers changed from: protected */
    public final zzvz zzdv() {
        try {
            return this.zzbsa.zzdv();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return null;
        }
    }
}
