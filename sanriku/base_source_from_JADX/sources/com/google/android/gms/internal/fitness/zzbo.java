package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.GoalsResult;

public final class zzbo extends zzb implements zzbm {
    zzbo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IGoalsReadCallback");
    }

    public final void zza(GoalsResult goalsResult) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) goalsResult);
        zzb(1, zza);
    }
}
