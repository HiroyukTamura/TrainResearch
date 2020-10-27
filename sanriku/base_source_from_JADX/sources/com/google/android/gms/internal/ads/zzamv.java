package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzamv implements Runnable {
    private final /* synthetic */ zzams zzdhi;

    zzamv(zzams zzams) {
        this.zzdhi = zzams;
    }

    public final void run() {
        try {
            this.zzdhi.zzdgu.onAdClicked();
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }
}
