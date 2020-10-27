package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzvq extends zzgk implements zzvr {
    public zzvq() {
        super("com.google.android.gms.ads.internal.client.IAdLoader");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        String str;
        if (i != 1) {
            if (i == 2) {
                str = getMediationAdapterClassName();
            } else if (i == 3) {
                boolean isLoading = isLoading();
                parcel2.writeNoException();
                zzgj.writeBoolean(parcel2, isLoading);
                return true;
            } else if (i == 4) {
                str = zzkh();
            } else if (i != 5) {
                return false;
            } else {
                zza((zzuj) zzgj.zza(parcel, zzuj.CREATOR), parcel.readInt());
            }
            parcel2.writeNoException();
            parcel2.writeString(str);
            return true;
        }
        zzb((zzuj) zzgj.zza(parcel, zzuj.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
