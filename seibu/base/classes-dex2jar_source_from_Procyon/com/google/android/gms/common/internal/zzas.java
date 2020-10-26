// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzef;
import android.os.Parcel;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.zzee;

public abstract class zzas extends zzee implements zzar
{
    public zzas() {
        this.attachInterface((IInterface)this, "com.google.android.gms.common.internal.ICertData");
    }
    
    public static zzar zzI(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        if (queryLocalInterface instanceof zzar) {
            return (zzar)queryLocalInterface;
        }
        return new zzat(binder);
    }
    
    public boolean onTransact(int zzoZ, final Parcel parcel, final Parcel parcel2, final int n) throws RemoteException {
        if (this.zza(zzoZ, parcel, parcel2, n)) {
            return true;
        }
        switch (zzoZ) {
            default: {
                return false;
            }
            case 1: {
                final IObjectWrapper zzoY = this.zzoY();
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface)zzoY);
                return true;
            }
            case 2: {
                zzoZ = this.zzoZ();
                parcel2.writeNoException();
                parcel2.writeInt(zzoZ);
                return true;
            }
        }
    }
}
