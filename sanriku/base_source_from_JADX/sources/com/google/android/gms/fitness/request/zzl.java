package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcp;

@ShowFirstParty
@SafeParcelable.Class(creator = "DataInsertRequestCreator")
@SafeParcelable.Reserved({3, 1000})
public final class zzl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzl> CREATOR = new zzk();
    @SafeParcelable.Field(getter = "getDataSet", mo11969id = 1)
    private final DataSet zzjd;
    @SafeParcelable.Field(getter = "getCallbackBinder", mo11969id = 2, type = "android.os.IBinder")
    private final zzcm zzok;
    @SafeParcelable.Field(getter = "shouldSkipSync", mo11969id = 4)
    private final boolean zzos;

    @SafeParcelable.Constructor
    zzl(@SafeParcelable.Param(mo11972id = 1) DataSet dataSet, @SafeParcelable.Param(mo11972id = 2) IBinder iBinder, @SafeParcelable.Param(mo11972id = 4) boolean z) {
        this.zzjd = dataSet;
        this.zzok = zzcp.zzj(iBinder);
        this.zzos = z;
    }

    public zzl(DataSet dataSet, zzcm zzcm, boolean z) {
        this.zzjd = dataSet;
        this.zzok = zzcm;
        this.zzos = z;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj != this) {
            return (obj instanceof zzl) && Objects.equal(this.zzjd, ((zzl) obj).zzjd);
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzjd);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("dataSet", this.zzjd).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzjd, i, false);
        zzcm zzcm = this.zzok;
        SafeParcelWriter.writeIBinder(parcel, 2, zzcm == null ? null : zzcm.asBinder(), false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzos);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
