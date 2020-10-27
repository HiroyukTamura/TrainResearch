package com.google.android.gms.fitness.data;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.fitness.zza;
import com.google.android.gms.internal.fitness.zzd;

public abstract class zzt extends zza implements zzu {
    public zzt() {
        super("com.google.android.gms.fitness.data.IDataSourceListener");
    }

    public static zzu zza(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.data.IDataSourceListener");
        return queryLocalInterface instanceof zzu ? (zzu) queryLocalInterface : new zzv(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zzc((DataPoint) zzd.zza(parcel, DataPoint.CREATOR));
        return true;
    }
}
