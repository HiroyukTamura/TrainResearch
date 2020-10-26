// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.os.RemoteException;
import com.google.android.gms.common.zzm;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzef;
import android.os.Parcel;
import android.os.IInterface;
import android.os.IBinder;
import com.google.android.gms.internal.zzee;

public abstract class zzaz extends zzee implements zzay
{
    public static zzay zzJ(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        if (queryLocalInterface instanceof zzay) {
            return (zzay)queryLocalInterface;
        }
        return new zzba(binder);
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
                final IObjectWrapper zzrF = this.zzrF();
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface)zzrF);
                break;
            }
            case 2: {
                final IObjectWrapper zzrG = this.zzrG();
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface)zzrG);
                break;
            }
            case 3: {
                final boolean zze = this.zze(parcel.readString(), IObjectWrapper.zza.zzM(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzef.zza(parcel2, zze);
                break;
            }
            case 4: {
                final boolean zzf = this.zzf(parcel.readString(), IObjectWrapper.zza.zzM(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzef.zza(parcel2, zzf);
                break;
            }
            case 5: {
                final boolean zza = this.zza(zzef.zza(parcel, zzm.CREATOR), IObjectWrapper.zza.zzM(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzef.zza(parcel2, zza);
                break;
            }
        }
        return true;
    }
}
