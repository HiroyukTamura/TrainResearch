package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcp;

@ShowFirstParty
@SafeParcelable.Class(creator = "ClaimBleDeviceRequestCreator")
@SafeParcelable.Reserved({4, 1000})
public final class zzf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzf> CREATOR = new zze();
    @SafeParcelable.Field(getter = "getDeviceAddress", mo11969id = 1)
    private final String deviceAddress;
    @SafeParcelable.Field(getter = "getBleDevice", mo11969id = 2)
    private final BleDevice zzoj;
    @SafeParcelable.Field(getter = "getCallbackBinder", mo11969id = 3, type = "android.os.IBinder")
    private final zzcm zzok;

    @SafeParcelable.Constructor
    zzf(@SafeParcelable.Param(mo11972id = 1) String str, @SafeParcelable.Param(mo11972id = 2) BleDevice bleDevice, @SafeParcelable.Param(mo11972id = 3) IBinder iBinder) {
        this.deviceAddress = str;
        this.zzoj = bleDevice;
        this.zzok = zzcp.zzj(iBinder);
    }

    public zzf(String str, BleDevice bleDevice, zzcm zzcm) {
        this.deviceAddress = str;
        this.zzoj = bleDevice;
        this.zzok = zzcm;
    }

    public final String toString() {
        return String.format("ClaimBleDeviceRequest{%s %s}", new Object[]{this.deviceAddress, this.zzoj});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.deviceAddress, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzoj, i, false);
        zzcm zzcm = this.zzok;
        SafeParcelWriter.writeIBinder(parcel, 3, zzcm == null ? null : zzcm.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
