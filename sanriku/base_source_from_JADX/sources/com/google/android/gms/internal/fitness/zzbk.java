package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataTypeResult;

public abstract class zzbk extends zza implements zzbl {
    public zzbk() {
        super("com.google.android.gms.fitness.internal.IDataTypeCallback");
    }

    public static zzbl zze(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IDataTypeCallback");
        return queryLocalInterface instanceof zzbl ? (zzbl) queryLocalInterface : new zzbn(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zza((DataTypeResult) zzd.zza(parcel, DataTypeResult.CREATOR));
        return true;
    }
}
