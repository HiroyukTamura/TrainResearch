package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "InstreamAdConfigurationParcelCreator")
public final class zzahm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzahm> CREATOR = new zzahp();
    @SafeParcelable.VersionField(mo11975id = 1000)
    public final int versionCode;
    @SafeParcelable.Field(mo11969id = 3)
    public final int zzbky;
    @SafeParcelable.Field(mo11969id = 1)
    public final int zzdbm;
    @SafeParcelable.Field(mo11969id = 2)
    public final String zzdbn;

    @SafeParcelable.Constructor
    public zzahm(@SafeParcelable.Param(mo11972id = 1000) int i, @SafeParcelable.Param(mo11972id = 1) int i2, @SafeParcelable.Param(mo11972id = 2) String str, @SafeParcelable.Param(mo11972id = 3) int i3) {
        this.versionCode = i;
        this.zzdbm = i2;
        this.zzdbn = str;
        this.zzbky = i3;
    }

    public zzahm(zzahy zzahy) {
        this(2, 1, zzahy.zzsq(), zzahy.getMediaAspectRatio());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzdbm);
        SafeParcelWriter.writeString(parcel, 2, this.zzdbn, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzbky);
        SafeParcelWriter.writeInt(parcel, 1000, this.versionCode);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
