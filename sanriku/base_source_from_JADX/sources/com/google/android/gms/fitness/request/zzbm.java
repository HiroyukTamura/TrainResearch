package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcp;

@ShowFirstParty
@SafeParcelable.Class(creator = "UnclaimBleDeviceRequestCreator")
@SafeParcelable.Reserved({1, 4, 1000})
public final class zzbm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbm> CREATOR = new zzbl();
    @SafeParcelable.Field(getter = "getDeviceAddress", mo11969id = 2)
    private final String deviceAddress;
    @SafeParcelable.Field(getter = "getCallbackBinder", mo11969id = 3, type = "android.os.IBinder")
    private final zzcm zzok;

    @SafeParcelable.Constructor
    zzbm(@SafeParcelable.Param(mo11972id = 2) String str, @SafeParcelable.Param(mo11972id = 3) IBinder iBinder) {
        this.deviceAddress = str;
        this.zzok = zzcp.zzj(iBinder);
    }

    public zzbm(String str, zzcm zzcm) {
        this.deviceAddress = str;
        this.zzok = zzcm;
    }

    public final String toString() {
        return String.format("UnclaimBleDeviceRequest{%s}", new Object[]{this.deviceAddress});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.deviceAddress, false);
        zzcm zzcm = this.zzok;
        SafeParcelWriter.writeIBinder(parcel, 3, zzcm == null ? null : zzcm.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
