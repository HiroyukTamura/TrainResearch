package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface zzatf extends IInterface {
    Bundle getAdMetadata() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    boolean isLoaded() throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException;

    void zza(zzatk zzatk) throws RemoteException;

    void zza(zzats zzats) throws RemoteException;

    void zza(zzaua zzaua) throws RemoteException;

    void zza(zzuj zzuj, zzatn zzatn) throws RemoteException;

    void zza(zzxa zzxa) throws RemoteException;

    void zza(zzxf zzxf) throws RemoteException;

    void zzb(zzuj zzuj, zzatn zzatn) throws RemoteException;

    void zzh(IObjectWrapper iObjectWrapper) throws RemoteException;

    zzxg zzki() throws RemoteException;

    zzate zzqt() throws RemoteException;
}
