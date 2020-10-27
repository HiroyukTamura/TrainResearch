package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface zzvz extends IInterface {
    void destroy() throws RemoteException;

    Bundle getAdMetadata() throws RemoteException;

    String getAdUnitId() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    zzxl getVideoController() throws RemoteException;

    boolean isLoading() throws RemoteException;

    boolean isReady() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void setImmersiveMode(boolean z) throws RemoteException;

    void setManualImpressionsEnabled(boolean z) throws RemoteException;

    void setUserId(String str) throws RemoteException;

    void showInterstitial() throws RemoteException;

    void stopLoading() throws RemoteException;

    void zza(zzaas zzaas) throws RemoteException;

    void zza(zzapq zzapq) throws RemoteException;

    void zza(zzapw zzapw, String str) throws RemoteException;

    void zza(zzasn zzasn) throws RemoteException;

    void zza(zzrn zzrn) throws RemoteException;

    void zza(zzum zzum) throws RemoteException;

    void zza(zzut zzut) throws RemoteException;

    void zza(zzvl zzvl) throws RemoteException;

    void zza(zzvm zzvm) throws RemoteException;

    void zza(zzwc zzwc) throws RemoteException;

    void zza(zzwh zzwh) throws RemoteException;

    void zza(zzwn zzwn) throws RemoteException;

    void zza(zzxf zzxf) throws RemoteException;

    void zza(zzxr zzxr) throws RemoteException;

    void zza(zzze zzze) throws RemoteException;

    boolean zza(zzuj zzuj) throws RemoteException;

    void zzbn(String str) throws RemoteException;

    IObjectWrapper zzke() throws RemoteException;

    void zzkf() throws RemoteException;

    zzum zzkg() throws RemoteException;

    String zzkh() throws RemoteException;

    zzxg zzki() throws RemoteException;

    zzwh zzkj() throws RemoteException;

    zzvm zzkk() throws RemoteException;
}
