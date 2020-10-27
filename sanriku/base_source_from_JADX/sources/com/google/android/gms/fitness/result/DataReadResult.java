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
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawBucket;
import com.google.android.gms.fitness.data.RawDataSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@SafeParcelable.Class(creator = "DataReadResultCreator")
@SafeParcelable.Reserved({7, 1000})
public class DataReadResult extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<DataReadResult> CREATOR = new zzc();
    @SafeParcelable.Field(getter = "getRawDataSets", mo11969id = 1, type = "java.util.List")
    private final List<DataSet> zziq;
    @SafeParcelable.Field(getter = "getUniqueDataSources", mo11969id = 6)
    private final List<DataSource> zzjc;
    @SafeParcelable.Field(getter = "getStatus", mo11969id = 2)
    private final Status zzqr;
    @SafeParcelable.Field(getter = "getRawBuckets", mo11969id = 3, type = "java.util.List")
    private final List<Bucket> zzqs;
    @SafeParcelable.Field(getter = "getBatchCount", mo11969id = 5)
    private int zzqt;

    @SafeParcelable.Constructor
    DataReadResult(@SafeParcelable.Param(mo11972id = 1) List<RawDataSet> list, @SafeParcelable.Param(mo11972id = 2) Status status, @SafeParcelable.Param(mo11972id = 3) List<RawBucket> list2, @SafeParcelable.Param(mo11972id = 5) int i, @SafeParcelable.Param(mo11972id = 6) List<DataSource> list3) {
        this.zzqr = status;
        this.zzqt = i;
        this.zzjc = list3;
        this.zziq = new ArrayList(list.size());
        for (RawDataSet dataSet : list) {
            this.zziq.add(new DataSet(dataSet, list3));
        }
        this.zzqs = new ArrayList(list2.size());
        for (RawBucket bucket : list2) {
            this.zzqs.add(new Bucket(bucket, list3));
        }
    }

    @ShowFirstParty
    private DataReadResult(List<DataSet> list, List<Bucket> list2, Status status) {
        this.zziq = list;
        this.zzqr = status;
        this.zzqs = list2;
        this.zzqt = 1;
        this.zzjc = new ArrayList();
    }

    @ShowFirstParty
    public static DataReadResult zza(Status status, List<DataType> list, List<DataSource> list2) {
        ArrayList arrayList = new ArrayList();
        for (DataSource create : list2) {
            arrayList.add(DataSet.create(create));
        }
        for (DataType dataType : list) {
            arrayList.add(DataSet.create(new DataSource.Builder().setType(1).setDataType(dataType).setName("Default").build()));
        }
        return new DataReadResult(arrayList, Collections.emptyList(), status);
    }

    private static void zza(DataSet dataSet, List<DataSet> list) {
        for (DataSet next : list) {
            if (next.getDataSource().equals(dataSet.getDataSource())) {
                next.zza((Iterable<DataPoint>) dataSet.getDataPoints());
                return;
            }
        }
        list.add(dataSet);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof DataReadResult) {
                DataReadResult dataReadResult = (DataReadResult) obj;
                if (this.zzqr.equals(dataReadResult.zzqr) && Objects.equal(this.zziq, dataReadResult.zziq) && Objects.equal(this.zzqs, dataReadResult.zzqs)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public List<Bucket> getBuckets() {
        return this.zzqs;
    }

    public DataSet getDataSet(DataSource dataSource) {
        for (DataSet next : this.zziq) {
            if (dataSource.equals(next.getDataSource())) {
                return next;
            }
        }
        return DataSet.create(dataSource);
    }

    public DataSet getDataSet(DataType dataType) {
        for (DataSet next : this.zziq) {
            if (dataType.equals(next.getDataType())) {
                return next;
            }
        }
        return DataSet.create(new DataSource.Builder().setType(1).setDataType(dataType).build());
    }

    public List<DataSet> getDataSets() {
        return this.zziq;
    }

    public Status getStatus() {
        return this.zzqr;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzqr, this.zziq, this.zzqs);
    }

    public String toString() {
        Object obj;
        Object obj2;
        Objects.ToStringHelper add = Objects.toStringHelper(this).add(NotificationCompat.CATEGORY_STATUS, this.zzqr);
        if (this.zziq.size() > 5) {
            int size = this.zziq.size();
            StringBuilder sb = new StringBuilder(21);
            sb.append(size);
            sb.append(" data sets");
            obj = sb.toString();
        } else {
            obj = this.zziq;
        }
        Objects.ToStringHelper add2 = add.add("dataSets", obj);
        if (this.zzqs.size() > 5) {
            int size2 = this.zzqs.size();
            StringBuilder sb2 = new StringBuilder(19);
            sb2.append(size2);
            sb2.append(" buckets");
            obj2 = sb2.toString();
        } else {
            obj2 = this.zzqs;
        }
        return add2.add("buckets", obj2).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        ArrayList arrayList = new ArrayList(this.zziq.size());
        for (DataSet rawDataSet : this.zziq) {
            arrayList.add(new RawDataSet(rawDataSet, this.zzjc));
        }
        SafeParcelWriter.writeList(parcel, 1, arrayList, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getStatus(), i, false);
        ArrayList arrayList2 = new ArrayList(this.zzqs.size());
        for (Bucket rawBucket : this.zzqs) {
            arrayList2.add(new RawBucket(rawBucket, this.zzjc));
        }
        SafeParcelWriter.writeList(parcel, 3, arrayList2, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zzqt);
        SafeParcelWriter.writeTypedList(parcel, 6, this.zzjc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zzae() {
        return this.zzqt;
    }

    public final void zzb(DataReadResult dataReadResult) {
        for (DataSet zza : dataReadResult.getDataSets()) {
            zza(zza, this.zziq);
        }
        for (Bucket next : dataReadResult.getBuckets()) {
            Iterator<Bucket> it = this.zzqs.iterator();
            while (true) {
                if (!it.hasNext()) {
                    this.zzqs.add(next);
                    break;
                }
                Bucket next2 = it.next();
                if (next2.zza(next)) {
                    for (DataSet zza2 : next.getDataSets()) {
                        zza(zza2, next2.getDataSets());
                    }
                }
            }
        }
    }
}
