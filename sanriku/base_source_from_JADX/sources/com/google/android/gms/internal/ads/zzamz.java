package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import p009e.p028d.p029a.C0871a;

final class zzamz implements Runnable {
    private final /* synthetic */ zzams zzdhi;
    private final /* synthetic */ C0871a zzdhj;

    zzamz(zzams zzams, C0871a aVar) {
        this.zzdhi = zzams;
        this.zzdhj = aVar;
    }

    public final void run() {
        try {
            this.zzdhi.zzdgu.onAdFailedToLoad(zzane.zza(this.zzdhj));
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }
}
