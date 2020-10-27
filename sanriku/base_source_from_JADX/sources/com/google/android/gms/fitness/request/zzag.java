package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fitness.zzeo;
import com.google.android.gms.internal.fitness.zzep;

@ShowFirstParty
@SafeParcelable.Class(creator = "ListClaimedBleDevicesRequestCreator")
@SafeParcelable.Reserved({2, 1000})
@Deprecated
public final class zzag extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzag> CREATOR = new zzaj();
    @SafeParcelable.Field(getter = "getCallbackBinder", mo11969id = 1, type = "android.os.IBinder")
    private final zzep zzpn;

    @SafeParcelable.Constructor
    zzag(@SafeParcelable.Param(mo11972id = 1) IBinder iBinder) {
        this.zzpn = zzeo.zzk(iBinder);
    }

    public zzag(zzep zzep) {
        this.zzpn = zzep;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 1, this.zzpn.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
