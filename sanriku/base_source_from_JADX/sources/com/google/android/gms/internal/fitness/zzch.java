package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

public final class zzch extends zzb implements zzcf {
    zzch(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
    }

    public final void zza(ListSubscriptionsResult listSubscriptionsResult) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) listSubscriptionsResult);
        zzb(1, zza);
    }
}
