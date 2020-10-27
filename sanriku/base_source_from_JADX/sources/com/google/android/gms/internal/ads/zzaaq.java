package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract class zzaaq extends zzgk implements zzaar {
    public zzaaq() {
        super("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        String str;
        if (i == 1) {
            str = zzro();
        } else if (i != 2) {
            if (i == 3) {
                zzn(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
            } else if (i == 4) {
                recordClick();
            } else if (i != 5) {
                return false;
            } else {
                recordImpression();
            }
            parcel2.writeNoException();
            return true;
        } else {
            str = getContent();
        }
        parcel2.writeNoException();
        parcel2.writeString(str);
        return true;
    }
}
