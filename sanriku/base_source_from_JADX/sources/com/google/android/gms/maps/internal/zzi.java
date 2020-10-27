package com.google.android.gms.maps.internal;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.maps.zzb;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.internal.maps.zzu;

public abstract class zzi extends zzb implements zzh {
    public zzi() {
        super("com.google.android.gms.maps.internal.IInfoWindowAdapter");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        IObjectWrapper iObjectWrapper;
        if (i == 1) {
            iObjectWrapper = zzh(zzu.zzg(parcel.readStrongBinder()));
        } else if (i != 2) {
            return false;
        } else {
            iObjectWrapper = zzi(zzu.zzg(parcel.readStrongBinder()));
        }
        parcel2.writeNoException();
        zzc.zza(parcel2, (IInterface) iObjectWrapper);
        return true;
    }
}