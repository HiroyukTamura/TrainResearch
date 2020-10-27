package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.NonNull;

public final class zzw implements zzx {
    private final IBinder zza;

    zzw(@NonNull IBinder iBinder) {
        this.zza = iBinder;
    }

    @NonNull
    public final IBinder asBinder() {
        return this.zza;
    }

    public final void zza(@NonNull Message message) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken("com.google.android.gms.iid.IMessengerCompat");
        obtain.writeInt(1);
        message.writeToParcel(obtain, 0);
        try {
            this.zza.transact(1, obtain, (Parcel) null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
