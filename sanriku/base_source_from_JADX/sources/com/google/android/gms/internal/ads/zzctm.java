package com.google.android.gms.internal.ads;

import android.os.RemoteException;

public final class zzctm implements zzub {
    private zzvl zzgjq;

    public final synchronized void onAdClicked() {
        if (this.zzgjq != null) {
            try {
                this.zzgjq.onAdClicked();
            } catch (RemoteException e) {
                zzazw.zzd("Remote Exception at onAdClicked.", e);
            }
        }
    }

    public final synchronized void zzb(zzvl zzvl) {
        this.zzgjq = zzvl;
    }
}
