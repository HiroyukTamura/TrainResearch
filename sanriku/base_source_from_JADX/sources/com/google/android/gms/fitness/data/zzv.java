package com.google.android.gms.fitness.data;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.fitness.zzb;
import com.google.android.gms.internal.fitness.zzd;

public final class zzv extends zzb implements zzu {
    zzv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.data.IDataSourceListener");
    }

    public final void zzc(DataPoint dataPoint) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) dataPoint);
        zzb(1, zza);
    }
}
