package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzyu extends zzasj {
    /* access modifiers changed from: private */
    public zzasn zzchy;

    public final void destroy() throws RemoteException {
    }

    public final Bundle getAdMetadata() throws RemoteException {
        return new Bundle();
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    public final boolean isLoaded() throws RemoteException {
        return false;
    }

    public final void pause() throws RemoteException {
    }

    public final void resume() throws RemoteException {
    }

    public final void setAppPackageName(String str) {
    }

    public final void setCustomData(String str) throws RemoteException {
    }

    public final void setImmersiveMode(boolean z) throws RemoteException {
    }

    public final void setUserId(String str) throws RemoteException {
    }

    public final void show() throws RemoteException {
    }

    public final void zza(zzasi zzasi) throws RemoteException {
    }

    public final void zza(zzasn zzasn) throws RemoteException {
        this.zzchy = zzasn;
    }

    public final void zza(zzast zzast) throws RemoteException {
        zzazw.zzfa("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzazm.zzzn.post(new zzyx(this));
    }

    public final void zza(zzwc zzwc) throws RemoteException {
    }

    public final void zzi(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final zzxg zzki() {
        return null;
    }

    public final void zzl(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final boolean zzqu() {
        return false;
    }
}
