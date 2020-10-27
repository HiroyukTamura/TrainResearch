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
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.fitness.zzbg;
import com.google.android.gms.internal.fitness.zzbj;
import java.util.Arrays;
import java.util.List;

@SafeParcelable.Class(creator = "DataSourcesRequestCreator")
@SafeParcelable.Reserved({5, 1000})
public class DataSourcesRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DataSourcesRequest> CREATOR = new zzp();
    @SafeParcelable.Field(getter = "getDataTypes", mo11969id = 1)
    private final List<DataType> zzio;
    @SafeParcelable.Field(getter = "getDataSourceTypes", mo11969id = 2)
    private final List<Integer> zzpe;
    @SafeParcelable.Field(getter = "includeDbOnlySources", mo11969id = 3)
    private final boolean zzpf;
    @SafeParcelable.Field(getter = "getCallbackBinder", mo11969id = 4, type = "android.os.IBinder")
    @Nullable
    private final zzbg zzpg;

    public static class Builder {
        private boolean zzpf = false;
        /* access modifiers changed from: private */
        public DataType[] zzph = new DataType[0];
        /* access modifiers changed from: private */
        public int[] zzpi = {0, 1};

        public DataSourcesRequest build() {
            boolean z = true;
            Preconditions.checkState(this.zzph.length > 0, "Must add at least one data type");
            if (this.zzpi.length <= 0) {
                z = false;
            }
            Preconditions.checkState(z, "Must add at least one data source type");
            return new DataSourcesRequest(this);
        }

        public Builder setDataSourceTypes(int... iArr) {
            this.zzpi = iArr;
            return this;
        }

        public Builder setDataTypes(DataType... dataTypeArr) {
            this.zzph = dataTypeArr;
            return this;
        }
    }

    private DataSourcesRequest(Builder builder) {
        this((List<DataType>) ArrayUtils.toArrayList(builder.zzph), (List<Integer>) Arrays.asList(ArrayUtils.toWrapperArray(builder.zzpi)), false, (zzbg) null);
    }

    public DataSourcesRequest(DataSourcesRequest dataSourcesRequest, zzbg zzbg) {
        this(dataSourcesRequest.zzio, dataSourcesRequest.zzpe, dataSourcesRequest.zzpf, zzbg);
    }

    @SafeParcelable.Constructor
    DataSourcesRequest(@SafeParcelable.Param(mo11972id = 1) List<DataType> list, @SafeParcelable.Param(mo11972id = 2) List<Integer> list2, @SafeParcelable.Param(mo11972id = 3) boolean z, @SafeParcelable.Param(mo11972id = 4) IBinder iBinder) {
        this.zzio = list;
        this.zzpe = list2;
        this.zzpf = z;
        this.zzpg = zzbj.zzd(iBinder);
    }

    private DataSourcesRequest(List<DataType> list, List<Integer> list2, boolean z, @Nullable zzbg zzbg) {
        this.zzio = list;
        this.zzpe = list2;
        this.zzpf = z;
        this.zzpg = zzbg;
    }

    public List<DataType> getDataTypes() {
        return this.zzio;
    }

    public String toString() {
        Objects.ToStringHelper add = Objects.toStringHelper(this).add("dataTypes", this.zzio).add("sourceTypes", this.zzpe);
        if (this.zzpf) {
            add.add("includeDbOnlySources", "true");
        }
        return add.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getDataTypes(), false);
        SafeParcelWriter.writeIntegerList(parcel, 2, this.zzpe, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzpf);
        zzbg zzbg = this.zzpg;
        SafeParcelWriter.writeIBinder(parcel, 4, zzbg == null ? null : zzbg.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
