package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzamp extends zzalu {
    private final zzasy zzdgr;
    private final Adapter zzdhb;

    zzamp(Adapter adapter, zzasy zzasy) {
        this.zzdhb = adapter;
        this.zzdgr = zzasy;
    }

    public final void onAdClicked() throws RemoteException {
        zzasy zzasy = this.zzdgr;
        if (zzasy != null) {
            zzasy.zzak(ObjectWrapper.wrap(this.zzdhb));
        }
    }

    public final void onAdClosed() throws RemoteException {
        zzasy zzasy = this.zzdgr;
        if (zzasy != null) {
            zzasy.zzaj(ObjectWrapper.wrap(this.zzdhb));
        }
    }

    public final void onAdFailedToLoad(int i) throws RemoteException {
        zzasy zzasy = this.zzdgr;
        if (zzasy != null) {
            zzasy.zze(ObjectWrapper.wrap(this.zzdhb), i);
        }
    }

    public final void onAdImpression() throws RemoteException {
    }

    public final void onAdLeftApplication() throws RemoteException {
    }

    public final void onAdLoaded() throws RemoteException {
        zzasy zzasy = this.zzdgr;
        if (zzasy != null) {
            zzasy.zzag(ObjectWrapper.wrap(this.zzdhb));
        }
    }

    public final void onAdOpened() throws RemoteException {
        zzasy zzasy = this.zzdgr;
        if (zzasy != null) {
            zzasy.zzah(ObjectWrapper.wrap(this.zzdhb));
        }
    }

    public final void onAppEvent(String str, String str2) throws RemoteException {
    }

    public final void onVideoEnd() throws RemoteException {
    }

    public final void onVideoPause() throws RemoteException {
    }

    public final void onVideoPlay() throws RemoteException {
    }

    public final void zza(zzado zzado, String str) throws RemoteException {
    }

    public final void zza(zzalw zzalw) throws RemoteException {
    }

    public final void zza(zzate zzate) throws RemoteException {
        zzasy zzasy = this.zzdgr;
        if (zzasy != null) {
            zzasy.zza(ObjectWrapper.wrap(this.zzdhb), new zzatc(zzate.getType(), zzate.getAmount()));
        }
    }

    public final void zzb(Bundle bundle) throws RemoteException {
    }

    public final void zzb(zzatc zzatc) throws RemoteException {
    }

    public final void zzc(int i, String str) throws RemoteException {
    }

    public final void zzcx(int i) throws RemoteException {
    }

    public final void zzdl(String str) throws RemoteException {
    }

    public final void zzdm(String str) {
    }

    public final void zztp() throws RemoteException {
        zzasy zzasy = this.zzdgr;
        if (zzasy != null) {
            zzasy.zzai(ObjectWrapper.wrap(this.zzdhb));
        }
    }

    public final void zztq() throws RemoteException {
        zzasy zzasy = this.zzdgr;
        if (zzasy != null) {
            zzasy.zzam(ObjectWrapper.wrap(this.zzdhb));
        }
    }
}
