package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final /* synthetic */ class zzyv implements Runnable {
    private final zzatn zzchz;

    zzyv(zzatn zzatn) {
        this.zzchz = zzatn;
    }

    public final void run() {
        zzatn zzatn = this.zzchz;
        if (zzatn != null) {
            try {
                zzatn.onRewardedAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzazw.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
