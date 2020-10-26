// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import android.os.Parcel;
import android.os.IBinder;
import android.os.IInterface;

public abstract class zzcad extends zzee implements zzcac
{
    public zzcad() {
        this.attachInterface((IInterface)this, "com.google.android.gms.flags.IFlagProvider");
    }
    
    public static zzcac asInterface(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.flags.IFlagProvider");
        if (queryLocalInterface instanceof zzcac) {
            return (zzcac)queryLocalInterface;
        }
        return new zzcae(binder);
    }
    
    public boolean onTransact(int intFlagValue, final Parcel parcel, final Parcel parcel2, final int n) throws RemoteException {
        if (this.zza(intFlagValue, parcel, parcel2, n)) {
            return true;
        }
        switch (intFlagValue) {
            default: {
                return false;
            }
            case 1: {
                this.init(IObjectWrapper.zza.zzM(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 2: {
                final boolean booleanFlagValue = this.getBooleanFlagValue(parcel.readString(), zzef.zza(parcel), parcel.readInt());
                parcel2.writeNoException();
                zzef.zza(parcel2, booleanFlagValue);
                return true;
            }
            case 3: {
                intFlagValue = this.getIntFlagValue(parcel.readString(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(intFlagValue);
                return true;
            }
            case 4: {
                final long longFlagValue = this.getLongFlagValue(parcel.readString(), parcel.readLong(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeLong(longFlagValue);
                return true;
            }
            case 5: {
                final String stringFlagValue = this.getStringFlagValue(parcel.readString(), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeString(stringFlagValue);
                return true;
            }
        }
    }
}
