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
import com.google.android.gms.internal.fitness.zzba;
import com.google.android.gms.internal.fitness.zzbd;

@ShowFirstParty
@SafeParcelable.Class(creator = "DailyTotalRequestCreator")
@SafeParcelable.Reserved({3, 1000})
public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new zzg();
    @SafeParcelable.Field(getter = "getDataType", mo11969id = 2)
    @Nullable
    private DataType zzhz;
    @SafeParcelable.Field(getter = "getCallbackBinder", mo11969id = 1, type = "android.os.IBinder")
    private final zzba zzol;
    @SafeParcelable.Field(getter = "getLocalDataOnly", mo11969id = 4)
    private final boolean zzom;

    @SafeParcelable.Constructor
    zzh(@SafeParcelable.Param(mo11972id = 1) IBinder iBinder, @SafeParcelable.Param(mo11972id = 2) @Nullable DataType dataType, @SafeParcelable.Param(mo11972id = 4) boolean z) {
        this.zzol = zzbd.zzb(iBinder);
        this.zzhz = dataType;
        this.zzom = z;
    }

    public zzh(zzba zzba, @Nullable DataType dataType, boolean z) {
        this.zzol = zzba;
        this.zzhz = dataType;
        this.zzom = z;
    }

    public final String toString() {
        Object[] objArr = new Object[1];
        DataType dataType = this.zzhz;
        objArr[0] = dataType == null ? "null" : dataType.zzp();
        return String.format("DailyTotalRequest{%s}", objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 1, this.zzol.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzhz, i, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzom);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
