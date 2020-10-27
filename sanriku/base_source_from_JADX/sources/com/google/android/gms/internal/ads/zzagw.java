package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

final class zzagw extends zzagt {
    private final /* synthetic */ zzbaj zzbsv;

    zzagw(zzagx zzagx, zzbaj zzbaj) {
        this.zzbsv = zzbaj;
    }

    public final void zza(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
        this.zzbsv.set(parcelFileDescriptor);
    }
}
