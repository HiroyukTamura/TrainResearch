package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;

final class zzamk implements InitializationCompleteCallback {
    private final /* synthetic */ zzahc zzdgo;

    zzamk(zzaml zzaml, zzahc zzahc) {
        this.zzdgo = zzahc;
    }

    public final void onInitializationFailed(String str) {
        try {
            this.zzdgo.onInitializationFailed(str);
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
    }

    public final void onInitializationSucceeded() {
        try {
            this.zzdgo.onInitializationSucceeded();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
    }
}
