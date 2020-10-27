package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzanb implements Runnable {
    private final /* synthetic */ zzams zzdhi;

    zzanb(zzams zzams) {
        this.zzdhi = zzams;
    }

    public final void run() {
        try {
            this.zzdhi.zzdgu.onAdOpened();
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }
}
