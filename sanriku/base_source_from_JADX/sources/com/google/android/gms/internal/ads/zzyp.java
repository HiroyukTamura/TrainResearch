package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzyp implements Runnable {
    private final /* synthetic */ zzym zzchw;

    zzyp(zzym zzym) {
        this.zzchw = zzym;
    }

    public final void run() {
        if (this.zzchw.zzbmt != null) {
            try {
                this.zzchw.zzbmt.onAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzazw.zzd("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
