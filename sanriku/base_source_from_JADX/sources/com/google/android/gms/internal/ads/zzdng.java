package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

@SafeParcelable.Class(creator = "ProgramResponseCreator")
public final class zzdng extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdng> CREATOR = new zzdnf();
    @SafeParcelable.Field(mo11969id = 3)
    public final int status;
    @SafeParcelable.VersionField(mo11975id = 1)
    private final int versionCode;
    @SafeParcelable.Field(mo11969id = 2)
    public final byte[] zzhdb;

    @SafeParcelable.Constructor
    zzdng(@SafeParcelable.Param(mo11972id = 1) int i, @SafeParcelable.Param(mo11972id = 2) byte[] bArr, @SafeParcelable.Param(mo11972id = 3) int i2) {
        this.versionCode = i;
        this.zzhdb = bArr == null ? null : Arrays.copyOf(bArr, bArr.length);
        this.status = i2;
    }

    public zzdng(byte[] bArr, int i) {
        this(1, (byte[]) null, 1);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeByteArray(parcel, 2, this.zzhdb, false);
        SafeParcelWriter.writeInt(parcel, 3, this.status);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
