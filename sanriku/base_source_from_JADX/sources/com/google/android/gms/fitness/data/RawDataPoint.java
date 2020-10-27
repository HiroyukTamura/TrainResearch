package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fitness.zzi;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@ShowFirstParty
@KeepName
@SafeParcelable.Class(creator = "RawDataPointCreator")
@SafeParcelable.Reserved({1000})
public final class RawDataPoint extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RawDataPoint> CREATOR = new zzz();
    @SafeParcelable.Field(getter = "getStartTimeNanos", mo11969id = 2)
    private final long zziu;
    @SafeParcelable.Field(getter = "getValues", mo11969id = 3)
    private final Value[] zziv;
    @SafeParcelable.Field(getter = "getRawTimestamp", mo11969id = 6)
    private final long zzix;
    @SafeParcelable.Field(getter = "getInsertionTimeMillis", mo11969id = 7)
    private final long zziy;
    @SafeParcelable.Field(getter = "getEndTimeNanos", mo11969id = 1)
    private final long zzlw;
    @SafeParcelable.Field(getter = "getDataSourceIndex", mo11969id = 4)
    private final int zzlx;
    @SafeParcelable.Field(getter = "getOriginalDataSourceIndex", mo11969id = 5)
    private final int zzly;

    @SafeParcelable.Constructor
    public RawDataPoint(@SafeParcelable.Param(mo11972id = 1) long j, @SafeParcelable.Param(mo11972id = 2) long j2, @SafeParcelable.Param(mo11972id = 3) Value[] valueArr, @SafeParcelable.Param(mo11972id = 4) int i, @SafeParcelable.Param(mo11972id = 5) int i2, @SafeParcelable.Param(mo11972id = 6) long j3, @SafeParcelable.Param(mo11972id = 7) long j4) {
        this.zzlw = j;
        this.zziu = j2;
        this.zzlx = i;
        this.zzly = i2;
        this.zzix = j3;
        this.zziy = j4;
        this.zziv = valueArr;
    }

    RawDataPoint(DataPoint dataPoint, List<DataSource> list) {
        this.zzlw = dataPoint.getTimestamp(TimeUnit.NANOSECONDS);
        this.zziu = dataPoint.getStartTime(TimeUnit.NANOSECONDS);
        this.zziv = dataPoint.zzf();
        this.zzlx = zzi.zza(dataPoint.getDataSource(), list);
        this.zzly = zzi.zza(dataPoint.zzg(), list);
        this.zzix = dataPoint.zzh();
        this.zziy = dataPoint.zzi();
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RawDataPoint)) {
            return false;
        }
        RawDataPoint rawDataPoint = (RawDataPoint) obj;
        return this.zzlw == rawDataPoint.zzlw && this.zziu == rawDataPoint.zziu && Arrays.equals(this.zziv, rawDataPoint.zziv) && this.zzlx == rawDataPoint.zzlx && this.zzly == rawDataPoint.zzly && this.zzix == rawDataPoint.zzix;
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zzlw), Long.valueOf(this.zziu));
    }

    public final String toString() {
        return String.format(Locale.US, "RawDataPoint{%s@[%s, %s](%d,%d)}", new Object[]{Arrays.toString(this.zziv), Long.valueOf(this.zziu), Long.valueOf(this.zzlw), Integer.valueOf(this.zzlx), Integer.valueOf(this.zzly)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.zzlw);
        SafeParcelWriter.writeLong(parcel, 2, this.zziu);
        SafeParcelWriter.writeTypedArray(parcel, 3, this.zziv, i, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzlx);
        SafeParcelWriter.writeInt(parcel, 5, this.zzly);
        SafeParcelWriter.writeLong(parcel, 6, this.zzix);
        SafeParcelWriter.writeLong(parcel, 7, this.zziy);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final Value[] zzf() {
        return this.zziv;
    }

    public final long zzh() {
        return this.zzix;
    }

    public final long zzi() {
        return this.zziy;
    }

    public final long zzq() {
        return this.zzlw;
    }

    public final long zzr() {
        return this.zziu;
    }

    public final int zzs() {
        return this.zzlx;
    }

    public final int zzt() {
        return this.zzly;
    }
}
