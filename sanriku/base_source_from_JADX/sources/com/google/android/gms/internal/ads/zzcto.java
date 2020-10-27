package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.AppEventListener;

public final class zzcto implements AppEventListener {
    private zzwh zzgjs;

    public final synchronized void onAppEvent(String str, String str2) {
        if (this.zzgjs != null) {
            try {
                this.zzgjs.onAppEvent(str, str2);
            } catch (RemoteException e) {
                zzazw.zzd("Remote Exception at onAppEvent.", e);
            }
        }
    }

    public final synchronized zzwh zzapk() {
        return this.zzgjs;
    }

    public final synchronized void zzb(zzwh zzwh) {
        this.zzgjs = zzwh;
    }
}
