package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GassEventParcelCreator")
public final class zzdmp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdmp> CREATOR = new zzdms();
    @SafeParcelable.VersionField(mo11975id = 1)
    private final int versionCode;
    @SafeParcelable.Field(mo11969id = 2)
    private final byte[] zzhcl;

    @SafeParcelable.Constructor
    zzdmp(@SafeParcelable.Param(mo11972id = 1) int i, @SafeParcelable.Param(mo11972id = 2) byte[] bArr) {
        this.versionCode = i;
        this.zzhcl = bArr;
    }

    public zzdmp(byte[] bArr) {
        this(1, bArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeByteArray(parcel, 2, this.zzhcl, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
