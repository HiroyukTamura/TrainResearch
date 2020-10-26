// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.RemoteException;
import android.os.Parcel;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;

public class zzee extends Binder implements IInterface
{
    public IBinder asBinder() {
        return (IBinder)this;
    }
    
    protected final boolean zza(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
        if (n > 16777215) {
            return super.onTransact(n, parcel, parcel2, n2);
        }
        parcel.enforceInterface(this.getInterfaceDescriptor());
        return false;
    }
}
