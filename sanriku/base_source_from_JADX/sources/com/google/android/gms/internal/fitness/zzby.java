package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.zzai;
import com.google.android.gms.fitness.request.zzbk;
import com.google.android.gms.fitness.request.zzbo;

public final class zzby extends zzb implements zzbz {
    zzby(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
    }

    public final void zza(zzai zzai) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzai);
        zza(3, zza);
    }

    public final void zza(zzbk zzbk) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzbk);
        zza(1, zza);
    }

    public final void zza(zzbo zzbo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzbo);
        zza(2, zza);
    }
}
