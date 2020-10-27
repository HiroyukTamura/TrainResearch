package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzbgv extends zzgi implements zzbgt {
    zzbgv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.measurement.IMeasurementManager");
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzbgr zzbgr) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) zzbgr);
        zza(2, obtainAndWriteInterfaceToken);
    }
}
