package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "SafeBrowsingConfigParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzaum extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaum> CREATOR = new zzaul();
    @SafeParcelable.Field(mo11969id = 2)
    public final String zzdsd;
    @SafeParcelable.Field(mo11969id = 3)
    public final String zzdse;
    @SafeParcelable.Field(mo11969id = 4)
    public final boolean zzdsf;
    @SafeParcelable.Field(mo11969id = 5)
    public final boolean zzdsg;
    @SafeParcelable.Field(mo11969id = 6)
    public final List<String> zzdsh;
    @SafeParcelable.Field(mo11969id = 7)
    public final boolean zzdsi;
    @SafeParcelable.Field(mo11969id = 8)
    public final boolean zzdsj;
    @SafeParcelable.Field(mo11969id = 9)
    public final List<String> zzdsk;

    @SafeParcelable.Constructor
    public zzaum(@SafeParcelable.Param(mo11972id = 2) String str, @SafeParcelable.Param(mo11972id = 3) String str2, @SafeParcelable.Param(mo11972id = 4) boolean z, @SafeParcelable.Param(mo11972id = 5) boolean z2, @SafeParcelable.Param(mo11972id = 6) List<String> list, @SafeParcelable.Param(mo11972id = 7) boolean z3, @SafeParcelable.Param(mo11972id = 8) boolean z4, @SafeParcelable.Param(mo11972id = 9) List<String> list2) {
        this.zzdsd = str;
        this.zzdse = str2;
        this.zzdsf = z;
        this.zzdsg = z2;
        this.zzdsh = list;
        this.zzdsi = z3;
        this.zzdsj = z4;
        this.zzdsk = list2 == null ? new ArrayList<>() : list2;
    }

    @Nullable
    public static zzaum zzg(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        return new zzaum(jSONObject.optString("click_string", ""), jSONObject.optString("report_url", ""), jSONObject.optBoolean("rendered_ad_enabled", false), jSONObject.optBoolean("non_malicious_reporting_enabled", false), zzayu.zza(jSONObject.optJSONArray("allowed_headers"), (List<String>) null), jSONObject.optBoolean("protection_enabled", false), jSONObject.optBoolean("malicious_reporting_enabled", false), zzayu.zza(jSONObject.optJSONArray("webview_permissions"), (List<String>) null));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzdsd, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzdse, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzdsf);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzdsg);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzdsh, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzdsi);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdsj);
        SafeParcelWriter.writeStringList(parcel, 9, this.zzdsk, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
