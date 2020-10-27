package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ServerSideVerificationOptionsParcelCreator")
public final class zzaua extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaua> CREATOR = new zzatz();
    @SafeParcelable.Field(mo11969id = 1)
    public final String zzdrf;
    @SafeParcelable.Field(mo11969id = 2)
    public final String zzdrg;

    public zzaua(ServerSideVerificationOptions serverSideVerificationOptions) {
        this(serverSideVerificationOptions.getUserId(), serverSideVerificationOptions.getCustomData());
    }

    @SafeParcelable.Constructor
    public zzaua(@SafeParcelable.Param(mo11972id = 1) String str, @SafeParcelable.Param(mo11972id = 2) String str2) {
        this.zzdrf = str;
        this.zzdrg = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzdrf, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzdrg, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
