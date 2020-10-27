package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.GoalsReadRequest;

public final class zzbu extends zzb implements zzbv {
    zzbu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IGoogleFitGoalsApi");
    }

    public final void zza(GoalsReadRequest goalsReadRequest) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) goalsReadRequest);
        zza(1, zza);
    }
}
