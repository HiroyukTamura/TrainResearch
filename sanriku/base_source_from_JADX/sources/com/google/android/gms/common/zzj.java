package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

@SafeParcelable.Class(creator = "GoogleCertificatesQueryCreator")
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new zzm();
    @SafeParcelable.Field(getter = "getCallingPackage", mo11969id = 1)
    private final String zzak;
    @SafeParcelable.Field(getter = "getCallingCertificateBinder", mo11969id = 2, type = "android.os.IBinder")
    private final zzd zzal;
    @SafeParcelable.Field(getter = "getAllowTestKeys", mo11969id = 3)
    private final boolean zzam;
    @SafeParcelable.Field(defaultValue = "false", getter = "getIgnoreTestKeysOverride", mo11969id = 4)
    private final boolean zzan;

    @SafeParcelable.Constructor
    zzj(@SafeParcelable.Param(mo11972id = 1) String str, @SafeParcelable.Param(mo11972id = 2) IBinder iBinder, @SafeParcelable.Param(mo11972id = 3) boolean z, @SafeParcelable.Param(mo11972id = 4) boolean z2) {
        this.zzak = str;
        this.zzal = zza(iBinder);
        this.zzam = z;
        this.zzan = z2;
    }

    zzj(String str, zzd zzd, boolean z, boolean z2) {
        this.zzak = str;
        this.zzal = zzd;
        this.zzam = z;
        this.zzan = z2;
    }

    private static zzd zza(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        try {
            IObjectWrapper zzb = zzk.zzb(iBinder).zzb();
            byte[] bArr = zzb == null ? null : (byte[]) ObjectWrapper.unwrap(zzb);
            if (bArr != null) {
                return new zzg(bArr);
            }
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
            return null;
        } catch (RemoteException e) {
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e);
            return null;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        IBinder iBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzak, false);
        zzd zzd = this.zzal;
        if (zzd == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            iBinder = null;
        } else {
            iBinder = zzd.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 2, iBinder, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzam);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzan);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
