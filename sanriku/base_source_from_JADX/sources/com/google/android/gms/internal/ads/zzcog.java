package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzcog extends zzani {
    private zzcnl<zzanv, zzcot> zzgey;
    private final /* synthetic */ zzcof zzgez;

    private zzcog(zzcof zzcof, zzcnl<zzanv, zzcot> zzcnl) {
        this.zzgez = zzcof;
        this.zzgey = zzcnl;
    }

    public final void zzdo(String str) throws RemoteException {
        ((zzcot) this.zzgey.zzgel).zzc(0, str);
    }

    public final void zzx(IObjectWrapper iObjectWrapper) throws RemoteException {
        View unused = this.zzgez.view = (View) ObjectWrapper.unwrap(iObjectWrapper);
        ((zzcot) this.zzgey.zzgel).onAdLoaded();
    }
}
