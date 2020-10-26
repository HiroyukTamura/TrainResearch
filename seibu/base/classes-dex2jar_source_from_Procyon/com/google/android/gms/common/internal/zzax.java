// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.os.RemoteException;
import android.os.Parcel;
import android.os.IBinder;

final class zzax implements zzaw
{
    private final IBinder zzrD;
    
    zzax(final IBinder zzrD) {
        this.zzrD = zzrD;
    }
    
    public final IBinder asBinder() {
        return this.zzrD;
    }
    
    @Override
    public final void zza(final zzau zzau, final zzx zzx) throws RemoteException {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            obtain.writeStrongBinder(zzau.asBinder());
            obtain.writeInt(1);
            zzx.writeToParcel(obtain, 0);
            this.zzrD.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
