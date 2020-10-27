package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.concurrent.TimeUnit;

@SafeParcelable.Class(creator = "DataUpdateNotificationCreator")
@SafeParcelable.Reserved({1000})
public class DataUpdateNotification extends AbstractSafeParcelable {
    public static final String ACTION = "com.google.android.gms.fitness.DATA_UPDATE_NOTIFICATION";
    public static final Parcelable.Creator<DataUpdateNotification> CREATOR = new zzn();
    public static final String EXTRA_DATA_UPDATE_NOTIFICATION = "vnd.google.fitness.data_udpate_notification";
    public static final int OPERATION_DELETE = 2;
    public static final int OPERATION_INSERT = 1;
    public static final int OPERATION_UPDATE = 3;
    @SafeParcelable.Field(getter = "getDataType", mo11969id = 5)
    private final DataType zzhz;
    @SafeParcelable.Field(getter = "getDataSource", mo11969id = 4)
    private final DataSource zzia;
    @SafeParcelable.Field(getter = "getUpdateStartTimeNanos", mo11969id = 1)
    private final long zzka;
    @SafeParcelable.Field(getter = "getUpdateEndTimeNanos", mo11969id = 2)
    private final long zzkb;
    @SafeParcelable.Field(getter = "getOperationType", mo11969id = 3)
    private final int zzkc;

    @SafeParcelable.Constructor
    public DataUpdateNotification(@SafeParcelable.Param(mo11972id = 1) long j, @SafeParcelable.Param(mo11972id = 2) long j2, @SafeParcelable.Param(mo11972id = 3) int i, @SafeParcelable.Param(mo11972id = 4) DataSource dataSource, @SafeParcelable.Param(mo11972id = 5) DataType dataType) {
        this.zzka = j;
        this.zzkb = j2;
        this.zzkc = i;
        this.zzia = dataSource;
        this.zzhz = dataType;
    }

    public static DataUpdateNotification getDataUpdateNotification(Intent intent) {
        return (DataUpdateNotification) SafeParcelableSerializer.deserializeFromIntentExtra(intent, EXTRA_DATA_UPDATE_NOTIFICATION, CREATOR);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DataUpdateNotification)) {
            return false;
        }
        DataUpdateNotification dataUpdateNotification = (DataUpdateNotification) obj;
        return this.zzka == dataUpdateNotification.zzka && this.zzkb == dataUpdateNotification.zzkb && this.zzkc == dataUpdateNotification.zzkc && Objects.equal(this.zzia, dataUpdateNotification.zzia) && Objects.equal(this.zzhz, dataUpdateNotification.zzhz);
    }

    public DataSource getDataSource() {
        return this.zzia;
    }

    public DataType getDataType() {
        return this.zzhz;
    }

    public int getOperationType() {
        return this.zzkc;
    }

    public long getUpdateEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzkb, TimeUnit.NANOSECONDS);
    }

    public long getUpdateStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzka, TimeUnit.NANOSECONDS);
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zzka), Long.valueOf(this.zzkb), Integer.valueOf(this.zzkc), this.zzia, this.zzhz);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("updateStartTimeNanos", Long.valueOf(this.zzka)).add("updateEndTimeNanos", Long.valueOf(this.zzkb)).add("operationType", Integer.valueOf(this.zzkc)).add("dataSource", this.zzia).add("dataType", this.zzhz).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.zzka);
        SafeParcelWriter.writeLong(parcel, 2, this.zzkb);
        SafeParcelWriter.writeInt(parcel, 3, getOperationType());
        SafeParcelWriter.writeParcelable(parcel, 4, getDataSource(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, getDataType(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
