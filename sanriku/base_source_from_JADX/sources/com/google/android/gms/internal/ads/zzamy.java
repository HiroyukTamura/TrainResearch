package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzamy implements Runnable {
    private final /* synthetic */ zzams zzdhi;

    zzamy(zzams zzams) {
        this.zzdhi = zzams;
    }

    public final void run() {
        try {
            this.zzdhi.zzdgu.onAdLeftApplication();
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }
}
