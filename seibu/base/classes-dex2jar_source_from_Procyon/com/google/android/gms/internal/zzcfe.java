// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.RemoteException;
import java.util.List;
import android.os.Parcel;
import android.os.IInterface;

public abstract class zzcfe extends zzee implements zzcfd
{
    public zzcfe() {
        this.attachInterface((IInterface)this, "com.google.android.gms.measurement.internal.IMeasurementService");
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
                this.zza(zzef.zza(parcel, zzcez.CREATOR), zzef.zza(parcel, zzceh.CREATOR));
                parcel2.writeNoException();
                break;
            }
            case 2: {
                this.zza(zzef.zza(parcel, zzcji.CREATOR), zzef.zza(parcel, zzceh.CREATOR));
                parcel2.writeNoException();
                break;
            }
            case 4: {
                this.zza(zzef.zza(parcel, zzceh.CREATOR));
                parcel2.writeNoException();
                break;
            }
            case 5: {
                this.zza(zzef.zza(parcel, zzcez.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                break;
            }
            case 6: {
                this.zzb(zzef.zza(parcel, zzceh.CREATOR));
                parcel2.writeNoException();
                break;
            }
            case 7: {
                final List<zzcji> zza = this.zza(zzef.zza(parcel, zzceh.CREATOR), zzef.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList((List)zza);
                break;
            }
            case 9: {
                final byte[] zza2 = this.zza(zzef.zza(parcel, zzcez.CREATOR), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeByteArray(zza2);
                break;
            }
            case 10: {
                this.zza(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                break;
            }
            case 11: {
                final String zzc = this.zzc(zzef.zza(parcel, zzceh.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(zzc);
                break;
            }
            case 12: {
                this.zza(zzef.zza(parcel, zzcek.CREATOR), zzef.zza(parcel, zzceh.CREATOR));
                parcel2.writeNoException();
                break;
            }
            case 13: {
                this.zzb(zzef.zza(parcel, zzcek.CREATOR));
                parcel2.writeNoException();
                break;
            }
            case 14: {
                final List<zzcji> zza3 = this.zza(parcel.readString(), parcel.readString(), zzef.zza(parcel), zzef.zza(parcel, zzceh.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList((List)zza3);
                break;
            }
            case 15: {
                final List<zzcji> zza4 = this.zza(parcel.readString(), parcel.readString(), parcel.readString(), zzef.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList((List)zza4);
                break;
            }
            case 16: {
                final List<zzcek> zza5 = this.zza(parcel.readString(), parcel.readString(), zzef.zza(parcel, zzceh.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList((List)zza5);
                break;
            }
            case 17: {
                final List<zzcek> zzk = this.zzk(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeTypedList((List)zzk);
                break;
            }
        }
        return true;
    }
}
