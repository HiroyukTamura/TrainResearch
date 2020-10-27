package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Collections;
import java.util.List;

public final class zzyo extends zzwo {
    private zzahh zzchv;

    public final String getVersionString() {
        return "";
    }

    public final void initialize() throws RemoteException {
        zzazw.zzfa("The initialization is not processed because MobileAdsSettingsManager is not created successfully.");
        zzazm.zzzn.post(new zzyr(this));
    }

    public final void setAppMuted(boolean z) throws RemoteException {
    }

    public final void setAppVolume(float f) throws RemoteException {
    }

    public final void zza(zzahh zzahh) throws RemoteException {
        this.zzchv = zzahh;
    }

    public final void zza(zzalp zzalp) throws RemoteException {
    }

    public final void zza(zzyy zzyy) throws RemoteException {
    }

    public final void zza(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzb(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
    }

    public final void zzcf(String str) throws RemoteException {
    }

    public final void zzcg(String str) throws RemoteException {
    }

    public final float zzqb() throws RemoteException {
        return 1.0f;
    }

    public final boolean zzqc() throws RemoteException {
        return false;
    }

    public final List<zzaha> zzqd() throws RemoteException {
        return Collections.emptyList();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzqs() {
        zzahh zzahh = this.zzchv;
        if (zzahh != null) {
            try {
                zzahh.zzd(Collections.emptyList());
            } catch (RemoteException e) {
                zzazw.zzd("Could not notify onComplete event.", e);
            }
        }
    }
}
