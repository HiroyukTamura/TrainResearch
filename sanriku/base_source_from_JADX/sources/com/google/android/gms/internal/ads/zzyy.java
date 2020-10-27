package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "RequestConfigurationParcelCreator")
public final class zzyy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzyy> CREATOR = new zzzb();
    @SafeParcelable.Field(mo11969id = 1)
    private final int zzacq;
    @SafeParcelable.Field(mo11969id = 2)
    private final int zzacr;

    @SafeParcelable.Constructor
    public zzyy(@SafeParcelable.Param(mo11972id = 1) int i, @SafeParcelable.Param(mo11972id = 2) int i2) {
        this.zzacq = i;
        this.zzacr = i2;
    }

    public zzyy(RequestConfiguration requestConfiguration) {
        this.zzacq = requestConfiguration.getTagForChildDirectedTreatment();
        this.zzacr = requestConfiguration.getTagForUnderAgeOfConsent();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzacq);
        SafeParcelWriter.writeInt(parcel, 2, this.zzacr);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
