package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;

@SafeParcelable.Class(creator = "DailyTotalResultCreator")
@SafeParcelable.Reserved({1000})
public class DailyTotalResult extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<DailyTotalResult> CREATOR = new zzb();
    @SafeParcelable.Field(getter = "getTotal", mo11969id = 2)
    private final DataSet zzjd;
    @SafeParcelable.Field(getter = "getStatus", mo11969id = 1)
    private final Status zzqr;

    @SafeParcelable.Constructor
    DailyTotalResult(@SafeParcelable.Param(mo11972id = 1) Status status, @SafeParcelable.Param(mo11972id = 2) DataSet dataSet) {
        this.zzqr = status;
        this.zzjd = dataSet;
    }

    @ShowFirstParty
    private DailyTotalResult(DataSet dataSet, Status status) {
        this.zzqr = status;
        this.zzjd = dataSet;
    }

    @ShowFirstParty
    public static DailyTotalResult zza(Status status, DataType dataType) {
        return new DailyTotalResult(DataSet.create(new DataSource.Builder().setType(1).setDataType(dataType).build()), status);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof DailyTotalResult) {
                DailyTotalResult dailyTotalResult = (DailyTotalResult) obj;
                if (this.zzqr.equals(dailyTotalResult.zzqr) && Objects.equal(this.zzjd, dailyTotalResult.zzjd)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public Status getStatus() {
        return this.zzqr;
    }

    @Nullable
    public DataSet getTotal() {
        return this.zzjd;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzqr, this.zzjd);
    }

    public String toString() {
        return Objects.toStringHelper(this).add(NotificationCompat.CATEGORY_STATUS, this.zzqr).add("dataPoint", this.zzjd).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getStatus(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getTotal(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
