package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SignalConfigurationParcelCreator")
public final class zzavt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzavt> CREATOR = new zzavw();
    @SafeParcelable.Field(mo11969id = 2)
    public final String zzbna;
    @SafeParcelable.Field(mo11969id = 1)
    @Deprecated
    public final String zzbsc;
    @SafeParcelable.Field(mo11969id = 3)
    @Deprecated
    public final zzum zzdtf;
    @SafeParcelable.Field(mo11969id = 4)
    public final zzuj zzdtg;

    @SafeParcelable.Constructor
    public zzavt(@SafeParcelable.Param(mo11972id = 1) String str, @SafeParcelable.Param(mo11972id = 2) String str2, @SafeParcelable.Param(mo11972id = 3) zzum zzum, @SafeParcelable.Param(mo11972id = 4) zzuj zzuj) {
        this.zzbsc = str;
        this.zzbna = str2;
        this.zzdtf = zzum;
        this.zzdtg = zzuj;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzbsc, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzbna, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdtf, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzdtg, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
