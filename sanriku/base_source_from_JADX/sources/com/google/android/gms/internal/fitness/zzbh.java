package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataReadResult;

public final class zzbh extends zzb implements zzbf {
    zzbh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IDataReadCallback");
    }

    public final void zza(DataReadResult dataReadResult) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) dataReadResult);
        zzb(1, zza);
    }
}
