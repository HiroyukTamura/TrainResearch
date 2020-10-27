package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "AdValueParcelCreator")
public final class zzuo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzuo> CREATOR = new zzur();
    @SafeParcelable.Field(mo11969id = 1)
    public final int type;
    @SafeParcelable.Field(mo11969id = 2)
    public final int zzacj;
    @SafeParcelable.Field(mo11969id = 3)
    public final String zzack;
    @SafeParcelable.Field(mo11969id = 4)
    public final long zzacl;

    @SafeParcelable.Constructor
    public zzuo(@SafeParcelable.Param(mo11972id = 1) int i, @SafeParcelable.Param(mo11972id = 2) int i2, @SafeParcelable.Param(mo11972id = 3) String str, @SafeParcelable.Param(mo11972id = 4) long j) {
        this.type = i;
        this.zzacj = i2;
        this.zzack = str;
        this.zzacl = j;
    }

    public static zzuo zza(JSONObject jSONObject) throws JSONException {
        return new zzuo(jSONObject.getInt("type_num"), jSONObject.getInt("precision_num"), jSONObject.getString(FirebaseAnalytics.Param.CURRENCY), jSONObject.getLong("value"));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.type);
        SafeParcelWriter.writeInt(parcel, 2, this.zzacj);
        SafeParcelWriter.writeString(parcel, 3, this.zzack, false);
        SafeParcelWriter.writeLong(parcel, 4, this.zzacl);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
