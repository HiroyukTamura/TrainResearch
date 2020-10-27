package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.SessionStopResult;

public final class zzcn extends zzb implements zzcl {
    zzcn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.ISessionStopCallback");
    }

    public final void zza(SessionStopResult sessionStopResult) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) sessionStopResult);
        zzb(1, zza);
    }
}
