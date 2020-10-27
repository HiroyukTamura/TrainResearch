package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ProgramRequestCreator")
public final class zzdne extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdne> CREATOR = new zzdnd();
    @SafeParcelable.VersionField(mo11975id = 1)
    private final int versionCode;
    @SafeParcelable.Field(mo11969id = 3)
    private final String zzhbk;
    @SafeParcelable.Field(mo11969id = 4)
    private final String zzhbl;
    @SafeParcelable.Field(mo11969id = 2)
    private final int zzhbm;
    @SafeParcelable.Field(mo11969id = 5)
    private final int zzhda;

    @SafeParcelable.Constructor
    zzdne(@SafeParcelable.Param(mo11972id = 1) int i, @SafeParcelable.Param(mo11972id = 2) int i2, @SafeParcelable.Param(mo11972id = 5) int i3, @SafeParcelable.Param(mo11972id = 3) String str, @SafeParcelable.Param(mo11972id = 4) String str2) {
        this.versionCode = i;
        this.zzhbm = i2;
        this.zzhbk = str;
        this.zzhbl = str2;
        this.zzhda = i3;
    }

    public zzdne(int i, zzgb zzgb, String str, String str2) {
        this(1, i, zzgb.zzw(), str, str2);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeInt(parcel, 2, this.zzhbm);
        SafeParcelWriter.writeString(parcel, 3, this.zzhbk, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzhbl, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zzhda);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
