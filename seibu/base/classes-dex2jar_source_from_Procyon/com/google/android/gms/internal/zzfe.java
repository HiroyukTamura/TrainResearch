// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.RemoteException;
import android.os.Parcel;
import android.os.IInterface;
import android.os.IBinder;

public abstract class zzfe extends zzee implements zzfd
{
    public static zzfd zzc(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        if (queryLocalInterface instanceof zzfd) {
            return (zzfd)queryLocalInterface;
        }
        return new zzff(binder);
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
                final String id = this.getId();
                parcel2.writeNoException();
                parcel2.writeString(id);
                return true;
            }
            case 2: {
                final boolean zzb = this.zzb(zzef.zza(parcel));
                parcel2.writeNoException();
                zzef.zza(parcel2, zzb);
                return true;
            }
            case 3: {
                final String zzq = this.zzq(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(zzq);
                return true;
            }
            case 4: {
                this.zzc(parcel.readString(), zzef.zza(parcel));
                parcel2.writeNoException();
                return true;
            }
        }
    }
}
