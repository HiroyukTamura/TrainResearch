package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcp;
import java.util.concurrent.TimeUnit;

@SafeParcelable.Class(creator = "DataUpdateRequestCreator")
@SafeParcelable.Reserved({1000})
public class DataUpdateRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DataUpdateRequest> CREATOR = new zzz();
    @SafeParcelable.Field(getter = "getStartTimeMillis", mo11969id = 1)
    private final long zzib;
    @SafeParcelable.Field(getter = "getEndTimeMillis", mo11969id = 2)
    private final long zzic;
    @SafeParcelable.Field(getter = "getDataSet", mo11969id = 3)
    private final DataSet zzjd;
    @SafeParcelable.Field(getter = "getCallbackBinder", mo11969id = 4, type = "android.os.IBinder")
    @Nullable
    private final zzcm zzok;

    public static class Builder {
        /* access modifiers changed from: private */
        public long zzib;
        /* access modifiers changed from: private */
        public long zzic;
        /* access modifiers changed from: private */
        public DataSet zzjd;

        public DataUpdateRequest build() {
            Preconditions.checkNotZero(this.zzib, (Object) "Must set a non-zero value for startTimeMillis/startTime");
            Preconditions.checkNotZero(this.zzic, (Object) "Must set a non-zero value for endTimeMillis/endTime");
            Preconditions.checkNotNull(this.zzjd, "Must set the data set");
            for (DataPoint next : this.zzjd.getDataPoints()) {
                long startTime = next.getStartTime(TimeUnit.MILLISECONDS);
                long endTime = next.getEndTime(TimeUnit.MILLISECONDS);
                Preconditions.checkState(!(startTime > endTime || (startTime != 0 && startTime < this.zzib) || ((startTime != 0 && startTime > this.zzic) || endTime > this.zzic || endTime < this.zzib)), "Data Point's startTimeMillis %d, endTimeMillis %d should lie between timeRange provided in the request. StartTimeMillis %d, EndTimeMillis: %d", Long.valueOf(startTime), Long.valueOf(endTime), Long.valueOf(this.zzib), Long.valueOf(this.zzic));
            }
            return new DataUpdateRequest(this);
        }

        public Builder setDataSet(DataSet dataSet) {
            Preconditions.checkNotNull(dataSet, "Must set the data set");
            this.zzjd = dataSet;
            return this;
        }

        public Builder setTimeInterval(long j, long j2, TimeUnit timeUnit) {
            Preconditions.checkArgument(j > 0, "Invalid start time :%d", Long.valueOf(j));
            Preconditions.checkArgument(j2 >= j, "Invalid end time :%d", Long.valueOf(j2));
            this.zzib = timeUnit.toMillis(j);
            this.zzic = timeUnit.toMillis(j2);
            return this;
        }
    }

    @SafeParcelable.Constructor
    public DataUpdateRequest(@SafeParcelable.Param(mo11972id = 1) long j, @SafeParcelable.Param(mo11972id = 2) long j2, @SafeParcelable.Param(mo11972id = 3) DataSet dataSet, @SafeParcelable.Param(mo11972id = 4) @Nullable IBinder iBinder) {
        this.zzib = j;
        this.zzic = j2;
        this.zzjd = dataSet;
        this.zzok = zzcp.zzj(iBinder);
    }

    private DataUpdateRequest(Builder builder) {
        this(builder.zzib, builder.zzic, builder.zzjd, (IBinder) null);
    }

    public DataUpdateRequest(DataUpdateRequest dataUpdateRequest, IBinder iBinder) {
        this(dataUpdateRequest.zzib, dataUpdateRequest.zzic, dataUpdateRequest.getDataSet(), iBinder);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj != this) {
            if (obj instanceof DataUpdateRequest) {
                DataUpdateRequest dataUpdateRequest = (DataUpdateRequest) obj;
                if (this.zzib == dataUpdateRequest.zzib && this.zzic == dataUpdateRequest.zzic && Objects.equal(this.zzjd, dataUpdateRequest.zzjd)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public IBinder getCallbackBinder() {
        zzcm zzcm = this.zzok;
        if (zzcm == null) {
            return null;
        }
        return zzcm.asBinder();
    }

    public DataSet getDataSet() {
        return this.zzjd;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzic, TimeUnit.MILLISECONDS);
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzib, TimeUnit.MILLISECONDS);
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zzib), Long.valueOf(this.zzic), this.zzjd);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("startTimeMillis", Long.valueOf(this.zzib)).add("endTimeMillis", Long.valueOf(this.zzic)).add("dataSet", this.zzjd).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.zzib);
        SafeParcelWriter.writeLong(parcel, 2, this.zzic);
        SafeParcelWriter.writeParcelable(parcel, 3, getDataSet(), i, false);
        SafeParcelWriter.writeIBinder(parcel, 4, getCallbackBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final long zzy() {
        return this.zzib;
    }

    public final long zzz() {
        return this.zzic;
    }
}
