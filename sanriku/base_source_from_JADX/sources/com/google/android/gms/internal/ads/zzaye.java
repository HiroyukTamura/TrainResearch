package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ExceptionParcelCreator")
public final class zzaye extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaye> CREATOR = new zzayg();
    @SafeParcelable.Field(mo11969id = 2)
    public final int errorCode;
    @SafeParcelable.Field(mo11969id = 1)
    public final String zzdxf;

    @SafeParcelable.Constructor
    zzaye(@SafeParcelable.Param(mo11972id = 1) @Nullable String str, @SafeParcelable.Param(mo11972id = 2) int i) {
        this.zzdxf = str == null ? "" : str;
        this.errorCode = i;
    }

    @Nullable
    public static zzaye zza(Throwable th, int i) {
        return new zzaye(th.getMessage(), i);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzdxf, false);
        SafeParcelWriter.writeInt(parcel, 2, this.errorCode);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
