// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import android.os.Parcel;
import android.os.IInterface;

public abstract class zzbdo extends zzee implements zzbdn
{
    public zzbdo() {
        this.attachInterface((IInterface)this, "com.google.android.gms.common.api.internal.IStatusCallback");
    }
    
    public boolean onTransact(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
        if (this.zza(n, parcel, parcel2, n2)) {
            return true;
        }
        if (n == 1) {
            this.zzu(zzef.zza(parcel, Status.CREATOR));
            return true;
        }
        return false;
    }
}
