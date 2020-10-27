package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.zzab;
import com.google.android.gms.fitness.request.zzt;

public final class zzbs extends zzb implements zzbt {
    zzbs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
    }

    public final void zza(DataTypeCreateRequest dataTypeCreateRequest) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) dataTypeCreateRequest);
        zza(1, zza);
    }

    public final void zza(zzab zzab) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzab);
        zza(22, zza);
    }

    public final void zza(zzt zzt) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzt);
        zza(2, zza);
    }
}
