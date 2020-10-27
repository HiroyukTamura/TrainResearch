package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataTypeResult;

public final class zzbn extends zzb implements zzbl {
    zzbn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IDataTypeCallback");
    }

    public final void zza(DataTypeResult dataTypeResult) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) dataTypeResult);
        zzb(1, zza);
    }
}
