// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.RemoteException;
import android.os.Parcel;
import android.os.IBinder;
import android.os.IInterface;

public class zzed implements IInterface
{
    private final IBinder zzrD;
    private final String zzrE;
    
    protected zzed(final IBinder zzrD, final String zzrE) {
        this.zzrD = zzrD;
        this.zzrE = zzrE;
    }
    
    public IBinder asBinder() {
        return this.zzrD;
    }
    
    protected final Parcel zzZ() {
        final Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzrE);
        return obtain;
    }
    
    protected final Parcel zza(final int n, final Parcel parcel) throws RemoteException {
        final Parcel obtain = Parcel.obtain();
        try {
            this.zzrD.transact(n, parcel, obtain, 0);
            obtain.readException();
            return obtain;
        }
        catch (RuntimeException ex) {
            obtain.recycle();
            throw ex;
        }
        finally {
            parcel.recycle();
        }
    }
    
    protected final void zzb(final int n, final Parcel parcel) throws RemoteException {
        final Parcel obtain = Parcel.obtain();
        try {
            this.zzrD.transact(n, parcel, obtain, 0);
            obtain.readException();
        }
        finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
    
    protected final void zzc(final int n, final Parcel parcel) throws RemoteException {
        try {
            this.zzrD.transact(n, parcel, (Parcel)null, 1);
        }
        finally {
            parcel.recycle();
        }
    }
}
