package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;

public final class zzcot extends zzalu implements zzbsf {
    private zzalv zzdhw;
    private zzbsi zzgfl;

    public final synchronized void onAdClicked() throws RemoteException {
        if (this.zzdhw != null) {
            this.zzdhw.onAdClicked();
        }
    }

    public final synchronized void onAdClosed() throws RemoteException {
        if (this.zzdhw != null) {
            this.zzdhw.onAdClosed();
        }
    }

    public final synchronized void onAdFailedToLoad(int i) throws RemoteException {
        if (this.zzdhw != null) {
            this.zzdhw.onAdFailedToLoad(i);
        }
        if (this.zzgfl != null) {
            this.zzgfl.zzg(i, (String) null);
        }
    }

    public final synchronized void onAdImpression() throws RemoteException {
        if (this.zzdhw != null) {
            this.zzdhw.onAdImpression();
        }
    }

    public final synchronized void onAdLeftApplication() throws RemoteException {
        if (this.zzdhw != null) {
            this.zzdhw.onAdLeftApplication();
        }
    }

    public final synchronized void onAdLoaded() throws RemoteException {
        if (this.zzdhw != null) {
            this.zzdhw.onAdLoaded();
        }
        if (this.zzgfl != null) {
            this.zzgfl.onAdLoaded();
        }
    }

    public final synchronized void onAdOpened() throws RemoteException {
        if (this.zzdhw != null) {
            this.zzdhw.onAdOpened();
        }
    }

    public final synchronized void onAppEvent(String str, String str2) throws RemoteException {
        if (this.zzdhw != null) {
            this.zzdhw.onAppEvent(str, str2);
        }
    }

    public final synchronized void onVideoEnd() throws RemoteException {
        if (this.zzdhw != null) {
            this.zzdhw.onVideoEnd();
        }
    }

    public final synchronized void onVideoPause() throws RemoteException {
        if (this.zzdhw != null) {
            this.zzdhw.onVideoPause();
        }
    }

    public final synchronized void onVideoPlay() throws RemoteException {
        if (this.zzdhw != null) {
            this.zzdhw.onVideoPlay();
        }
    }

    public final synchronized void zza(zzado zzado, String str) throws RemoteException {
        if (this.zzdhw != null) {
            this.zzdhw.zza(zzado, str);
        }
    }

    public final synchronized void zza(zzalw zzalw) throws RemoteException {
        if (this.zzdhw != null) {
            this.zzdhw.zza(zzalw);
        }
    }

    public final synchronized void zza(zzate zzate) throws RemoteException {
        if (this.zzdhw != null) {
            this.zzdhw.zza(zzate);
        }
    }

    public final synchronized void zza(zzbsi zzbsi) {
        this.zzgfl = zzbsi;
    }

    public final synchronized void zzb(Bundle bundle) throws RemoteException {
        if (this.zzdhw != null) {
            this.zzdhw.zzb(bundle);
        }
    }

    public final synchronized void zzb(zzalv zzalv) {
        this.zzdhw = zzalv;
    }

    public final synchronized void zzb(zzatc zzatc) throws RemoteException {
        if (this.zzdhw != null) {
            this.zzdhw.zzb(zzatc);
        }
    }

    public final synchronized void zzc(int i, String str) throws RemoteException {
        if (this.zzdhw != null) {
            this.zzdhw.zzc(i, str);
        }
        if (this.zzgfl != null) {
            this.zzgfl.zzg(i, str);
        }
    }

    public final synchronized void zzcx(int i) throws RemoteException {
        if (this.zzdhw != null) {
            this.zzdhw.zzcx(i);
        }
    }

    public final synchronized void zzdl(String str) throws RemoteException {
        if (this.zzdhw != null) {
            this.zzdhw.zzdl(str);
        }
    }

    public final synchronized void zzdm(String str) throws RemoteException {
        if (this.zzdhw != null) {
            this.zzdhw.zzdm(str);
        }
    }

    public final synchronized void zztp() throws RemoteException {
        if (this.zzdhw != null) {
            this.zzdhw.zztp();
        }
    }

    public final synchronized void zztq() throws RemoteException {
        if (this.zzdhw != null) {
            this.zzdhw.zztq();
        }
    }
}
