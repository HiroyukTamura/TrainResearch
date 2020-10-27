package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "NativeAdOptionsParcelCreator")
public final class zzaci extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaci> CREATOR = new zzacl();
    @SafeParcelable.Field(mo11969id = 1)
    public final int versionCode;
    @SafeParcelable.Field(mo11969id = 3)
    public final int zzbkx;
    @SafeParcelable.Field(mo11969id = 8)
    public final int zzbky;
    @SafeParcelable.Field(mo11969id = 4)
    public final boolean zzbkz;
    @SafeParcelable.Field(mo11969id = 5)
    public final int zzbla;
    @SafeParcelable.Field(mo11969id = 7)
    public final boolean zzblc;
    @SafeParcelable.Field(mo11969id = 2)
    public final boolean zzcyt;
    @SafeParcelable.Field(mo11969id = 6)
    @Nullable
    public final zzze zzcyu;

    @SafeParcelable.Constructor
    public zzaci(@SafeParcelable.Param(mo11972id = 1) int i, @SafeParcelable.Param(mo11972id = 2) boolean z, @SafeParcelable.Param(mo11972id = 3) int i2, @SafeParcelable.Param(mo11972id = 4) boolean z2, @SafeParcelable.Param(mo11972id = 5) int i3, @SafeParcelable.Param(mo11972id = 6) zzze zzze, @SafeParcelable.Param(mo11972id = 7) boolean z3, @SafeParcelable.Param(mo11972id = 8) int i4) {
        this.versionCode = i;
        this.zzcyt = z;
        this.zzbkx = i2;
        this.zzbkz = z2;
        this.zzbla = i3;
        this.zzcyu = zzze;
        this.zzblc = z3;
        this.zzbky = i4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzaci(NativeAdOptions nativeAdOptions) {
        this(4, nativeAdOptions.shouldReturnUrlsForImageAssets(), nativeAdOptions.getImageOrientation(), nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement(), nativeAdOptions.getVideoOptions() != null ? new zzze(nativeAdOptions.getVideoOptions()) : null, nativeAdOptions.zzjr(), nativeAdOptions.getMediaAspectRatio());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzcyt);
        SafeParcelWriter.writeInt(parcel, 3, this.zzbkx);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzbkz);
        SafeParcelWriter.writeInt(parcel, 5, this.zzbla);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzcyu, i, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzblc);
        SafeParcelWriter.writeInt(parcel, 8, this.zzbky);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
