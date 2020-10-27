package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public final class zzco extends zzb implements zzcm {
    zzco(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IStatusCallback");
    }

    public final void onResult(Status status) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) status);
        zzb(1, zza);
    }
}
