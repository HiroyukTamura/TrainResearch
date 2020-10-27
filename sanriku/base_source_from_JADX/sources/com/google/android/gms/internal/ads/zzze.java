package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "VideoOptionsParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzze extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzze> CREATOR = new zzzh();
    @SafeParcelable.Field(mo11969id = 2)
    public final boolean zzacy;
    @SafeParcelable.Field(mo11969id = 3)
    public final boolean zzacz;
    @SafeParcelable.Field(mo11969id = 4)
    public final boolean zzada;

    public zzze(VideoOptions videoOptions) {
        this(videoOptions.getStartMuted(), videoOptions.getCustomControlsRequested(), videoOptions.getClickToExpandRequested());
    }

    @SafeParcelable.Constructor
    public zzze(@SafeParcelable.Param(mo11972id = 2) boolean z, @SafeParcelable.Param(mo11972id = 3) boolean z2, @SafeParcelable.Param(mo11972id = 4) boolean z3) {
        this.zzacy = z;
        this.zzacz = z2;
        this.zzada = z3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzacy);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzacz);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzada);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
