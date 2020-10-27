package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzanx extends zzgi implements zzanv {
    zzanx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public final zzxl getVideoController() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(5, obtainAndWriteInterfaceToken());
        zzxl zzk = zzxk.zzk(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzk;
    }

    public final void zza(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzum zzum, zzanw zzanw) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        obtainAndWriteInterfaceToken.writeString(str);
        zzgj.zza(obtainAndWriteInterfaceToken, (Parcelable) bundle);
        zzgj.zza(obtainAndWriteInterfaceToken, (Parcelable) bundle2);
        zzgj.zza(obtainAndWriteInterfaceToken, (Parcelable) zzum);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) zzanw);
        zza(1, obtainAndWriteInterfaceToken);
    }

    public final void zza(String str, String str2, zzuj zzuj, IObjectWrapper iObjectWrapper, zzanj zzanj, zzalv zzalv, zzum zzum) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzgj.zza(obtainAndWriteInterfaceToken, (Parcelable) zzuj);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) zzanj);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) zzalv);
        zzgj.zza(obtainAndWriteInterfaceToken, (Parcelable) zzum);
        zza(13, obtainAndWriteInterfaceToken);
    }

    public final void zza(String str, String str2, zzuj zzuj, IObjectWrapper iObjectWrapper, zzank zzank, zzalv zzalv) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzgj.zza(obtainAndWriteInterfaceToken, (Parcelable) zzuj);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) zzank);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) zzalv);
        zza(14, obtainAndWriteInterfaceToken);
    }

    public final void zza(String str, String str2, zzuj zzuj, IObjectWrapper iObjectWrapper, zzanp zzanp, zzalv zzalv) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzgj.zza(obtainAndWriteInterfaceToken, (Parcelable) zzuj);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) zzanp);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) zzalv);
        zza(18, obtainAndWriteInterfaceToken);
    }

    public final void zza(String str, String str2, zzuj zzuj, IObjectWrapper iObjectWrapper, zzanq zzanq, zzalv zzalv) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzgj.zza(obtainAndWriteInterfaceToken, (Parcelable) zzuj);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) zzanq);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) zzalv);
        zza(16, obtainAndWriteInterfaceToken);
    }

    public final void zza(String[] strArr, Bundle[] bundleArr) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeStringArray(strArr);
        obtainAndWriteInterfaceToken.writeTypedArray(bundleArr, 0);
        zza(11, obtainAndWriteInterfaceToken);
    }

    public final boolean zzaa(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        Parcel transactAndReadException = transactAndReadException(17, obtainAndWriteInterfaceToken);
        boolean zza = zzgj.zza(transactAndReadException);
        transactAndReadException.recycle();
        return zza;
    }

    public final void zzb(String str, String str2, zzuj zzuj, IObjectWrapper iObjectWrapper, zzanq zzanq, zzalv zzalv) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzgj.zza(obtainAndWriteInterfaceToken, (Parcelable) zzuj);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) zzanq);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) zzalv);
        zza(20, obtainAndWriteInterfaceToken);
    }

    public final void zzdp(String str) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        zza(19, obtainAndWriteInterfaceToken);
    }

    public final zzaoj zztn() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
        zzaoj zzaoj = (zzaoj) zzgj.zza(transactAndReadException, zzaoj.CREATOR);
        transactAndReadException.recycle();
        return zzaoj;
    }

    public final zzaoj zzto() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken());
        zzaoj zzaoj = (zzaoj) zzgj.zza(transactAndReadException, zzaoj.CREATOR);
        transactAndReadException.recycle();
        return zzaoj;
    }

    public final void zzy(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zza(10, obtainAndWriteInterfaceToken);
    }

    public final boolean zzz(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        Parcel transactAndReadException = transactAndReadException(15, obtainAndWriteInterfaceToken);
        boolean zza = zzgj.zza(transactAndReadException);
        transactAndReadException.recycle();
        return zza;
    }
}
