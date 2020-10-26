// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.RemoteException;
import android.os.Parcel;
import android.os.IInterface;

public abstract class zzbfy extends zzee implements zzbfx
{
    public zzbfy() {
        this.attachInterface((IInterface)this, "com.google.android.gms.common.internal.service.ICommonCallbacks");
    }
    
    public boolean onTransact(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
        if (this.zza(n, parcel, parcel2, n2)) {
            return true;
        }
        if (n == 1) {
            this.zzaC(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
