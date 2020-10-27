package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final /* synthetic */ class zzctu implements zzbrc {
    private final zzctp zzgkb;
    private final zzahu zzgkc;

    zzctu(zzctp zzctp, zzahu zzahu) {
        this.zzgkb = zzctp;
        this.zzgkc = zzahu;
    }

    public final void onAdFailedToLoad(int i) {
        zzctp zzctp = this.zzgkb;
        zzahu zzahu = this.zzgkc;
        zzctp.onAdFailedToLoad(i);
        if (zzahu != null) {
            try {
                zzahu.onInstreamAdFailedToLoad(i);
            } catch (RemoteException e) {
                zzazw.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
