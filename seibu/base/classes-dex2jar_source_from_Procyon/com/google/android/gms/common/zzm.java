// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common;

import com.google.android.gms.common.internal.safeparcel.zzd;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzas;
import android.os.IBinder;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzm extends zza
{
    public static final Parcelable$Creator<zzm> CREATOR;
    private final String zzaAl;
    private final zzg zzaAm;
    private final boolean zzaAn;
    
    static {
        CREATOR = (Parcelable$Creator)new zzn();
    }
    
    zzm(final String zzaAl, final IBinder binder, final boolean zzaAn) {
        this.zzaAl = zzaAl;
        this.zzaAm = zzG(binder);
        this.zzaAn = zzaAn;
    }
    
    zzm(final String zzaAl, final zzg zzaAm, final boolean zzaAn) {
        this.zzaAl = zzaAl;
        this.zzaAm = zzaAm;
        this.zzaAn = zzaAn;
    }
    
    private static zzg zzG(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        while (true) {
        Label_0060:
            while (true) {
                IObjectWrapper zzoY;
                try {
                    zzoY = zzas.zzI(binder).zzoY();
                    if (zzoY == null) {
                        final byte[] array = null;
                        if (array != null) {
                            return new zzh(array);
                        }
                        break Label_0060;
                    }
                }
                catch (RemoteException ex) {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", (Throwable)ex);
                    return null;
                }
                final byte[] array = com.google.android.gms.dynamic.zzn.zzE(zzoY);
                continue;
            }
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
            return null;
        }
    }
    
    public final void writeToParcel(final Parcel parcel, int zze) {
        zze = zzd.zze(parcel);
        zzd.zza(parcel, 1, this.zzaAl, false);
        IBinder binder;
        if (this.zzaAm == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            binder = null;
        }
        else {
            binder = this.zzaAm.asBinder();
        }
        zzd.zza(parcel, 2, binder, false);
        zzd.zza(parcel, 3, this.zzaAn);
        zzd.zzI(parcel, zze);
    }
}
