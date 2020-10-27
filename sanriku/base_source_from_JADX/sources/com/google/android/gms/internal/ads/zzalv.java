package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;

public interface zzalv extends IInterface {
    void onAdClicked() throws RemoteException;

    void onAdClosed() throws RemoteException;

    void onAdFailedToLoad(int i) throws RemoteException;

    void onAdImpression() throws RemoteException;

    void onAdLeftApplication() throws RemoteException;

    void onAdLoaded() throws RemoteException;

    void onAdOpened() throws RemoteException;

    void onAppEvent(String str, String str2) throws RemoteException;

    void onVideoEnd() throws RemoteException;

    void onVideoPause() throws RemoteException;

    void onVideoPlay() throws RemoteException;

    void zza(zzado zzado, String str) throws RemoteException;

    void zza(zzalw zzalw) throws RemoteException;

    void zza(zzate zzate) throws RemoteException;

    void zzb(Bundle bundle) throws RemoteException;

    void zzb(zzatc zzatc) throws RemoteException;

    void zzc(int i, String str) throws RemoteException;

    void zzcx(int i) throws RemoteException;

    void zzdl(String str) throws RemoteException;

    void zzdm(String str) throws RemoteException;

    void zztp() throws RemoteException;

    void zztq() throws RemoteException;
}
