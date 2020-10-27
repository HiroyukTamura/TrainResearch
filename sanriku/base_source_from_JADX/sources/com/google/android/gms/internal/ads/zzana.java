package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzana implements Runnable {
    private final /* synthetic */ zzams zzdhi;

    zzana(zzams zzams) {
        this.zzdhi = zzams;
    }

    public final void run() {
        try {
            this.zzdhi.zzdgu.onAdLoaded();
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }
}
