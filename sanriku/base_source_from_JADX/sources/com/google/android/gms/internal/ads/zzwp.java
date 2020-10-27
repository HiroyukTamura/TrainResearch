package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public interface zzwp extends IInterface {
    String getVersionString() throws RemoteException;

    void initialize() throws RemoteException;

    void setAppMuted(boolean z) throws RemoteException;

    void setAppVolume(float f) throws RemoteException;

    void zza(zzahh zzahh) throws RemoteException;

    void zza(zzalp zzalp) throws RemoteException;

    void zza(zzyy zzyy) throws RemoteException;

    void zza(String str, IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzb(IObjectWrapper iObjectWrapper, String str) throws RemoteException;

    void zzcf(String str) throws RemoteException;

    void zzcg(String str) throws RemoteException;

    float zzqb() throws RemoteException;

    boolean zzqc() throws RemoteException;

    List<zzaha> zzqd() throws RemoteException;
}
