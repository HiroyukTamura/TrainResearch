package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.fitness.zzce;
import com.google.android.gms.internal.fitness.zzcf;

@ShowFirstParty
@SafeParcelable.Class(creator = "ListSubscriptionsRequestCreator")
@SafeParcelable.Reserved({3, 1000})
public final class zzai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzai> CREATOR = new zzal();
    @SafeParcelable.Field(getter = "getDataType", mo11969id = 1)
    @Nullable
    private final DataType zzhz;
    @SafeParcelable.Field(getter = "getCallbackBinder", mo11969id = 2, type = "android.os.IBinder")
    private final zzcf zzpo;

    @SafeParcelable.Constructor
    zzai(@SafeParcelable.Param(mo11972id = 1) @Nullable DataType dataType, @SafeParcelable.Param(mo11972id = 2) @Nullable IBinder iBinder) {
        this.zzhz = dataType;
        this.zzpo = zzce.zzg(iBinder);
    }

    public zzai(@Nullable DataType dataType, zzcf zzcf) {
        this.zzhz = dataType;
        this.zzpo = zzcf;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzhz, i, false);
        zzcf zzcf = this.zzpo;
        SafeParcelWriter.writeIBinder(parcel, 2, zzcf == null ? null : zzcf.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
