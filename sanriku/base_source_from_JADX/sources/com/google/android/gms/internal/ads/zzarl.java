package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "StringParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzarl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzarl> CREATOR = new zzaro();
    @SafeParcelable.Field(mo11969id = 2)
    String zzdpj;

    @SafeParcelable.Constructor
    public zzarl(@SafeParcelable.Param(mo11972id = 2) String str) {
        this.zzdpj = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzdpj, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
