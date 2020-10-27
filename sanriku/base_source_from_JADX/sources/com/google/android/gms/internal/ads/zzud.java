package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AdDataParcelCreator")
public final class zzud extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzud> CREATOR = new zzuc();
    @SafeParcelable.Field(mo11969id = 1)
    public final String zzcec;
    @SafeParcelable.Field(mo11969id = 2)
    public final String zzced;

    @SafeParcelable.Constructor
    public zzud(@SafeParcelable.Param(mo11972id = 1) String str, @SafeParcelable.Param(mo11972id = 2) String str2) {
        this.zzcec = str;
        this.zzced = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzcec, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzced, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
