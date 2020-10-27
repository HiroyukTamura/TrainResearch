package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzarc extends zzgi implements zzara {
    zzarc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    public final zzaqw zza(zzaqu zzaqu) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgj.zza(obtainAndWriteInterfaceToken, (Parcelable) zzaqu);
        Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
        zzaqw zzaqw = (zzaqw) zzgj.zza(transactAndReadException, zzaqw.CREATOR);
        transactAndReadException.recycle();
        return zzaqw;
    }

    public final void zza(zzaqu zzaqu, zzarb zzarb) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgj.zza(obtainAndWriteInterfaceToken, (Parcelable) zzaqu);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) zzarb);
        zza(2, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzarj zzarj, zzard zzard) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgj.zza(obtainAndWriteInterfaceToken, (Parcelable) zzarj);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) zzard);
        zza(4, obtainAndWriteInterfaceToken);
    }

    public final void zza(String str, zzard zzard) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) zzard);
        zza(7, obtainAndWriteInterfaceToken);
    }

    public final void zzb(zzarj zzarj, zzard zzard) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgj.zza(obtainAndWriteInterfaceToken, (Parcelable) zzarj);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) zzard);
        zza(5, obtainAndWriteInterfaceToken);
    }

    public final void zzc(zzarj zzarj, zzard zzard) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgj.zza(obtainAndWriteInterfaceToken, (Parcelable) zzarj);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) zzard);
        zza(6, obtainAndWriteInterfaceToken);
    }
}
