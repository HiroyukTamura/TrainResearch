package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract class zzacv extends zzgk implements zzacs {
    public zzacv() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public static zzacs zzo(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
        return queryLocalInterface instanceof zzacs ? (zzacs) queryLocalInterface : new zzacu(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        int i3;
        if (i == 1) {
            IObjectWrapper zzrv = zzrv();
            parcel2.writeNoException();
            zzgj.zza(parcel2, (IInterface) zzrv);
        } else if (i == 2) {
            Uri uri = getUri();
            parcel2.writeNoException();
            zzgj.zzb(parcel2, uri);
        } else if (i != 3) {
            if (i == 4) {
                i3 = getWidth();
            } else if (i != 5) {
                return false;
            } else {
                i3 = getHeight();
            }
            parcel2.writeNoException();
            parcel2.writeInt(i3);
        } else {
            double scale = getScale();
            parcel2.writeNoException();
            parcel2.writeDouble(scale);
        }
        return true;
    }
}
