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
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "DataSourcesResultCreator")
@SafeParcelable.Reserved({1000})
public class DataSourcesResult extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<DataSourcesResult> CREATOR = new zzd();
    @SafeParcelable.Field(getter = "getDataSources", mo11969id = 1)
    private final List<DataSource> zzon;
    @SafeParcelable.Field(getter = "getStatus", mo11969id = 2)
    private final Status zzqr;

    @ShowFirstParty
    @SafeParcelable.Constructor
    public DataSourcesResult(@SafeParcelable.Param(mo11972id = 1) List<DataSource> list, @SafeParcelable.Param(mo11972id = 2) Status status) {
        this.zzon = Collections.unmodifiableList(list);
        this.zzqr = status;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof DataSourcesResult) {
                DataSourcesResult dataSourcesResult = (DataSourcesResult) obj;
                if (this.zzqr.equals(dataSourcesResult.zzqr) && Objects.equal(this.zzon, dataSourcesResult.zzon)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public List<DataSource> getDataSources() {
        return this.zzon;
    }

    public List<DataSource> getDataSources(DataType dataType) {
        ArrayList arrayList = new ArrayList();
        for (DataSource next : this.zzon) {
            if (next.getDataType().equals(dataType)) {
                arrayList.add(next);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Status getStatus() {
        return this.zzqr;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzqr, this.zzon);
    }

    public String toString() {
        return Objects.toStringHelper(this).add(NotificationCompat.CATEGORY_STATUS, this.zzqr).add("dataSources", this.zzon).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getDataSources(), false);
        SafeParcelWriter.writeParcelable(parcel, 2, getStatus(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
