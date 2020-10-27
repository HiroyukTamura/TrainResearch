package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzyx implements Runnable {
    private final /* synthetic */ zzyu zzcib;

    zzyx(zzyu zzyu) {
        this.zzcib = zzyu;
    }

    public final void run() {
        if (this.zzcib.zzchy != null) {
            try {
                this.zzcib.zzchy.onRewardedVideoAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzazw.zzd("Could not notify onRewardedVideoAdFailedToLoad event.", e);
            }
        }
    }
}
