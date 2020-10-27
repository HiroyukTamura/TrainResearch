package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fitness.zzi;
import java.util.List;

@KeepName
@SafeParcelable.Class(creator = "RawDataSetCreator")
@SafeParcelable.Reserved({2, 1000})
public final class RawDataSet extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RawDataSet> CREATOR = new zzaa();
    @SafeParcelable.Field(mo11969id = 4)
    public final boolean zzis;
    @SafeParcelable.Field(mo11969id = 1)
    public final int zzlx;
    @SafeParcelable.Field(mo11969id = 3)
    public final List<RawDataPoint> zzlz;

    @SafeParcelable.Constructor
    public RawDataSet(@SafeParcelable.Param(mo11972id = 1) int i, @SafeParcelable.Param(mo11972id = 3) List<RawDataPoint> list, @SafeParcelable.Param(mo11972id = 4) boolean z) {
        this.zzlx = i;
        this.zzlz = list;
        this.zzis = z;
    }

    public RawDataSet(DataSet dataSet, List<DataSource> list) {
        this.zzlz = dataSet.zza(list);
        this.zzis = dataSet.zze();
        this.zzlx = zzi.zza(dataSet.getDataSource(), list);
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RawDataSet)) {
            return false;
        }
        RawDataSet rawDataSet = (RawDataSet) obj;
        return this.zzlx == rawDataSet.zzlx && this.zzis == rawDataSet.zzis && Objects.equal(this.zzlz, rawDataSet.zzlz);
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzlx));
    }

    public final String toString() {
        return String.format("RawDataSet{%s@[%s]}", new Object[]{Integer.valueOf(this.zzlx), this.zzlz});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzlx);
        SafeParcelWriter.writeTypedList(parcel, 3, this.zzlz, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzis);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
