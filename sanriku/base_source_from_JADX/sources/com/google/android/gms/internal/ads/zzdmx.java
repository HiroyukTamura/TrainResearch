package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzdmx extends zzgi implements zzdmy {
    zzdmx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    public final zzdmw zza(zzdmu zzdmu) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgj.zza(obtainAndWriteInterfaceToken, (Parcelable) zzdmu);
        Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
        zzdmw zzdmw = (zzdmw) zzgj.zza(transactAndReadException, zzdmw.CREATOR);
        transactAndReadException.recycle();
        return zzdmw;
    }

    public final zzdng zza(zzdne zzdne) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgj.zza(obtainAndWriteInterfaceToken, (Parcelable) zzdne);
        Parcel transactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken);
        zzdng zzdng = (zzdng) zzgj.zza(transactAndReadException, zzdng.CREATOR);
        transactAndReadException.recycle();
        return zzdng;
    }

    public final void zza(zzdmp zzdmp) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgj.zza(obtainAndWriteInterfaceToken, (Parcelable) zzdmp);
        zza(2, obtainAndWriteInterfaceToken);
    }
}
