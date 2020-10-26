// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.os.RemoteException;
import android.os.Parcelable$Creator;
import com.google.android.gms.internal.zzef;
import android.os.Bundle;
import android.os.Parcel;
import android.os.IInterface;
import com.google.android.gms.internal.zzee;

public abstract class zzav extends zzee implements zzau
{
    public zzav() {
        this.attachInterface((IInterface)this, "com.google.android.gms.common.internal.IGmsCallbacks");
    }
    
    public boolean onTransact(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
        if (this.zza(n, parcel, parcel2, n2)) {
            return true;
        }
        switch (n) {
            default: {
                return false;
            }
            case 1: {
                this.zza(parcel.readInt(), parcel.readStrongBinder(), zzef.zza(parcel, (android.os.Parcelable$Creator<Bundle>)Bundle.CREATOR));
                break;
            }
            case 2: {
                this.zza(parcel.readInt(), zzef.zza(parcel, (android.os.Parcelable$Creator<Bundle>)Bundle.CREATOR));
                break;
            }
        }
        parcel2.writeNoException();
        return true;
    }
}
