package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AdLauncherIntentInfoCreator")
@SafeParcelable.Reserved({1})
public final class zzd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzd> CREATOR = new zza();
    @SafeParcelable.Field(mo11969id = 9)
    public final Intent intent;
    @SafeParcelable.Field(mo11969id = 4)
    public final String mimeType;
    @SafeParcelable.Field(mo11969id = 5)
    public final String packageName;
    @SafeParcelable.Field(mo11969id = 3)
    public final String url;
    @SafeParcelable.Field(mo11969id = 2)
    private final String zzdkh;
    @SafeParcelable.Field(mo11969id = 6)
    public final String zzdki;
    @SafeParcelable.Field(mo11969id = 7)
    public final String zzdkj;
    @SafeParcelable.Field(mo11969id = 8)
    private final String zzdkk;

    public zzd(Intent intent2) {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, intent2);
    }

    public zzd(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this(str, str2, str3, str4, str5, str6, str7, (Intent) null);
    }

    @SafeParcelable.Constructor
    public zzd(@SafeParcelable.Param(mo11972id = 2) String str, @SafeParcelable.Param(mo11972id = 3) String str2, @SafeParcelable.Param(mo11972id = 4) String str3, @SafeParcelable.Param(mo11972id = 5) String str4, @SafeParcelable.Param(mo11972id = 6) String str5, @SafeParcelable.Param(mo11972id = 7) String str6, @SafeParcelable.Param(mo11972id = 8) String str7, @SafeParcelable.Param(mo11972id = 9) Intent intent2) {
        this.zzdkh = str;
        this.url = str2;
        this.mimeType = str3;
        this.packageName = str4;
        this.zzdki = str5;
        this.zzdkj = str6;
        this.zzdkk = str7;
        this.intent = intent2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzdkh, false);
        SafeParcelWriter.writeString(parcel, 3, this.url, false);
        SafeParcelWriter.writeString(parcel, 4, this.mimeType, false);
        SafeParcelWriter.writeString(parcel, 5, this.packageName, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzdki, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzdkj, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzdkk, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.intent, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
