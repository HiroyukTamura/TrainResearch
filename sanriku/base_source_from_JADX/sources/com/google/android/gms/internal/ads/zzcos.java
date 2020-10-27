package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzcos extends zzasx implements zzbsf {
    private zzasy zzgfk;
    private zzbsi zzgfl;
    private zzbwg zzgfm;

    public final synchronized void zza(IObjectWrapper iObjectWrapper, zzatc zzatc) throws RemoteException {
        if (this.zzgfk != null) {
            this.zzgfk.zza(iObjectWrapper, zzatc);
        }
    }

    public final synchronized void zza(zzasy zzasy) {
        this.zzgfk = zzasy;
    }

    public final synchronized void zza(zzbsi zzbsi) {
        this.zzgfl = zzbsi;
    }

    public final synchronized void zza(zzbwg zzbwg) {
        this.zzgfm = zzbwg;
    }

    public final synchronized void zzaf(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzgfk != null) {
            this.zzgfk.zzaf(iObjectWrapper);
        }
        if (this.zzgfm != null) {
            this.zzgfm.onInitializationSucceeded();
        }
    }

    public final synchronized void zzag(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzgfk != null) {
            this.zzgfk.zzag(iObjectWrapper);
        }
        if (this.zzgfl != null) {
            this.zzgfl.onAdLoaded();
        }
    }

    public final synchronized void zzah(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzgfk != null) {
            this.zzgfk.zzah(iObjectWrapper);
        }
    }

    public final synchronized void zzai(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzgfk != null) {
            this.zzgfk.zzai(iObjectWrapper);
        }
    }

    public final synchronized void zzaj(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzgfk != null) {
            this.zzgfk.zzaj(iObjectWrapper);
        }
    }

    public final synchronized void zzak(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzgfk != null) {
            this.zzgfk.zzak(iObjectWrapper);
        }
    }

    public final synchronized void zzal(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzgfk != null) {
            this.zzgfk.zzal(iObjectWrapper);
        }
    }

    public final synchronized void zzam(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzgfk != null) {
            this.zzgfk.zzam(iObjectWrapper);
        }
    }

    public final synchronized void zzb(Bundle bundle) throws RemoteException {
        if (this.zzgfk != null) {
            this.zzgfk.zzb(bundle);
        }
    }

    public final synchronized void zzd(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        if (this.zzgfk != null) {
            this.zzgfk.zzd(iObjectWrapper, i);
        }
        if (this.zzgfm != null) {
            this.zzgfm.zzdq(i);
        }
    }

    public final synchronized void zze(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        if (this.zzgfk != null) {
            this.zzgfk.zze(iObjectWrapper, i);
        }
        if (this.zzgfl != null) {
            this.zzgfl.onAdFailedToLoad(i);
        }
    }
}
