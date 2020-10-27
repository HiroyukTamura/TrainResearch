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
import com.google.android.gms.fitness.data.DataType;

@SafeParcelable.Class(creator = "DataTypeResultCreator")
@SafeParcelable.Reserved({1000})
@Deprecated
public class DataTypeResult extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<DataTypeResult> CREATOR = new zze();
    @SafeParcelable.Field(getter = "getDataType", mo11969id = 3)
    private final DataType zzhz;
    @SafeParcelable.Field(getter = "getStatus", mo11969id = 1)
    private final Status zzqr;

    @ShowFirstParty
    @SafeParcelable.Constructor
    public DataTypeResult(@SafeParcelable.Param(mo11972id = 1) Status status, @SafeParcelable.Param(mo11972id = 3) DataType dataType) {
        this.zzqr = status;
        this.zzhz = dataType;
    }

    @ShowFirstParty
    public static DataTypeResult zzc(Status status) {
        return new DataTypeResult(status, (DataType) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof DataTypeResult) {
                DataTypeResult dataTypeResult = (DataTypeResult) obj;
                if (this.zzqr.equals(dataTypeResult.zzqr) && Objects.equal(this.zzhz, dataTypeResult.zzhz)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public DataType getDataType() {
        return this.zzhz;
    }

    public Status getStatus() {
        return this.zzqr;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzqr, this.zzhz);
    }

    public String toString() {
        return Objects.toStringHelper(this).add(NotificationCompat.CATEGORY_STATUS, this.zzqr).add("dataType", this.zzhz).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getStatus(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, getDataType(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
