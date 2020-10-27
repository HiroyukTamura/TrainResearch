package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "AutoClickProtectionConfigurationParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzaqy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaqy> CREATOR = new zzaqx();
    @SafeParcelable.Field(mo11969id = 2)
    public final boolean zzdox;
    @SafeParcelable.Field(mo11969id = 3)
    @Nullable
    public final List<String> zzdoy;

    public zzaqy() {
        this(false, Collections.emptyList());
    }

    @SafeParcelable.Constructor
    public zzaqy(@SafeParcelable.Param(mo11972id = 2) boolean z, @SafeParcelable.Param(mo11972id = 3) List<String> list) {
        this.zzdox = z;
        this.zzdoy = list;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzdox);
        SafeParcelWriter.writeStringList(parcel, 3, this.zzdoy, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
