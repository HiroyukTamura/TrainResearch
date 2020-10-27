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
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Device;
import com.google.android.gms.internal.fitness.zzbe;
import com.google.android.gms.internal.fitness.zzbf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import p009e.p010a.p011a.p012a.C0681a;

@SafeParcelable.Class(creator = "DataReadRequestCreator")
@SafeParcelable.Reserved({11, 15, 1000})
public class DataReadRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DataReadRequest> CREATOR = new zzn();
    public static final int NO_LIMIT = 0;
    @SafeParcelable.Field(getter = "getLimit", mo11969id = 10)
    private final int limit;
    @SafeParcelable.Field(getter = "getStartTimeMillis", mo11969id = 3)
    private final long zzib;
    @SafeParcelable.Field(getter = "getEndTimeMillis", mo11969id = 4)
    private final long zzic;
    @SafeParcelable.Field(getter = "getDataTypes", mo11969id = 1)
    private final List<DataType> zzio;
    @SafeParcelable.Field(getter = "getBucketType", mo11969id = 7)
    private final int zzir;
    @SafeParcelable.Field(getter = "getDataSources", mo11969id = 2)
    private final List<DataSource> zzon;
    @SafeParcelable.Field(getter = "getAggregatedDataTypes", mo11969id = 5)
    private final List<DataType> zzot;
    @SafeParcelable.Field(getter = "getAggregatedDataSources", mo11969id = 6)
    private final List<DataSource> zzou;
    @SafeParcelable.Field(getter = "getBucketDurationMillis", mo11969id = 8)
    private final long zzov;
    @SafeParcelable.Field(getter = "getActivityDataSource", mo11969id = 9)
    private final DataSource zzow;
    @SafeParcelable.Field(getter = "flushBufferBeforeRead", mo11969id = 12)
    private final boolean zzox;
    @SafeParcelable.Field(getter = "areServerQueriesEnabled", mo11969id = 13)
    private final boolean zzoy;
    @SafeParcelable.Field(getter = "getCallbackBinder", mo11969id = 14, type = "android.os.IBinder")
    @Nullable
    private final zzbf zzoz;
    @SafeParcelable.Field(getter = "getFilteredDevices", mo11969id = 16)
    private final List<Device> zzpa;
    @SafeParcelable.Field(getter = "getFilteredDataQualityStandards", mo11969id = 17)
    private final List<Integer> zzpb;
    @SafeParcelable.Field(getter = "getIntervalStartTimesNanos", mo11969id = 18)
    private final List<Long> zzpc;
    @SafeParcelable.Field(getter = "getIntervalEndTimesNanos", mo11969id = 19)
    private final List<Long> zzpd;

    public static class Builder {
        /* access modifiers changed from: private */
        public int limit = 0;
        /* access modifiers changed from: private */
        public long zzib;
        /* access modifiers changed from: private */
        public long zzic;
        /* access modifiers changed from: private */
        public List<DataType> zzio = new ArrayList();
        /* access modifiers changed from: private */
        public int zzir = 0;
        /* access modifiers changed from: private */
        public List<DataSource> zzon = new ArrayList();
        /* access modifiers changed from: private */
        public List<DataType> zzot = new ArrayList();
        /* access modifiers changed from: private */
        public List<DataSource> zzou = new ArrayList();
        /* access modifiers changed from: private */
        public long zzov = 0;
        /* access modifiers changed from: private */
        public DataSource zzow;
        private boolean zzox = false;
        /* access modifiers changed from: private */
        public boolean zzoy = false;
        /* access modifiers changed from: private */
        public final List<Device> zzpa = new ArrayList();
        /* access modifiers changed from: private */
        public final List<Integer> zzpb = new ArrayList();
        /* access modifiers changed from: private */
        public List<Long> zzpc = new ArrayList();
        /* access modifiers changed from: private */
        public List<Long> zzpd = new ArrayList();

        @Deprecated
        public Builder addFilteredDataQualityStandard(int i) {
            Preconditions.checkArgument(this.zzpa.isEmpty(), "Cannot add data quality standard filter when filtering by device.");
            this.zzpb.add(Integer.valueOf(i));
            return this;
        }

        public Builder aggregate(DataSource dataSource, DataType dataType) {
            Preconditions.checkNotNull(dataSource, "Attempting to add a null data source");
            Preconditions.checkState(!this.zzon.contains(dataSource), "Cannot add the same data source for aggregated and detailed");
            DataType dataType2 = dataSource.getDataType();
            List<DataType> aggregatesForInput = DataType.getAggregatesForInput(dataType2);
            Preconditions.checkArgument(!aggregatesForInput.isEmpty(), "Unsupported input data type specified for aggregation: %s", dataType2);
            Preconditions.checkArgument(aggregatesForInput.contains(dataType), "Invalid output aggregate data type specified: %s -> %s", dataType2, dataType);
            if (!this.zzou.contains(dataSource)) {
                this.zzou.add(dataSource);
            }
            return this;
        }

        public Builder aggregate(DataType dataType, DataType dataType2) {
            Preconditions.checkNotNull(dataType, "Attempting to use a null data type");
            Preconditions.checkState(!this.zzio.contains(dataType), "Cannot add the same data type as aggregated and detailed");
            List<DataType> aggregatesForInput = DataType.getAggregatesForInput(dataType);
            Preconditions.checkArgument(!aggregatesForInput.isEmpty(), "Unsupported input data type specified for aggregation: %s", dataType);
            Preconditions.checkArgument(aggregatesForInput.contains(dataType2), "Invalid output aggregate data type specified: %s -> %s", dataType, dataType2);
            if (!this.zzot.contains(dataType)) {
                this.zzot.add(dataType);
            }
            return this;
        }

        public Builder bucketByActivitySegment(int i, TimeUnit timeUnit) {
            Preconditions.checkArgument(this.zzir == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzir));
            Preconditions.checkArgument(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            this.zzir = 4;
            this.zzov = timeUnit.toMillis((long) i);
            return this;
        }

        public Builder bucketByActivitySegment(int i, TimeUnit timeUnit, DataSource dataSource) {
            Preconditions.checkArgument(this.zzir == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzir));
            Preconditions.checkArgument(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            Preconditions.checkArgument(dataSource != null, "Invalid activity data source specified");
            Preconditions.checkArgument(dataSource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", dataSource);
            this.zzow = dataSource;
            this.zzir = 4;
            this.zzov = timeUnit.toMillis((long) i);
            return this;
        }

        public Builder bucketByActivityType(int i, TimeUnit timeUnit) {
            Preconditions.checkArgument(this.zzir == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzir));
            Preconditions.checkArgument(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            this.zzir = 3;
            this.zzov = timeUnit.toMillis((long) i);
            return this;
        }

        public Builder bucketByActivityType(int i, TimeUnit timeUnit, DataSource dataSource) {
            Preconditions.checkArgument(this.zzir == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzir));
            Preconditions.checkArgument(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            Preconditions.checkArgument(dataSource != null, "Invalid activity data source specified");
            Preconditions.checkArgument(dataSource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", dataSource);
            this.zzow = dataSource;
            this.zzir = 3;
            this.zzov = timeUnit.toMillis((long) i);
            return this;
        }

        public Builder bucketBySession(int i, TimeUnit timeUnit) {
            Preconditions.checkArgument(this.zzir == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzir));
            Preconditions.checkArgument(i > 0, "Must specify a valid minimum duration for a session: %d", Integer.valueOf(i));
            this.zzir = 2;
            this.zzov = timeUnit.toMillis((long) i);
            return this;
        }

        public Builder bucketByTime(int i, TimeUnit timeUnit) {
            Preconditions.checkArgument(this.zzir == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzir));
            Preconditions.checkArgument(i > 0, "Must specify a valid minimum duration: %d", Integer.valueOf(i));
            this.zzir = 1;
            this.zzov = timeUnit.toMillis((long) i);
            return this;
        }

        public DataReadRequest build() {
            boolean z = false;
            Preconditions.checkState(!this.zzon.isEmpty() || !this.zzio.isEmpty() || !this.zzou.isEmpty() || !this.zzot.isEmpty(), "Must add at least one data source (aggregated or detailed)");
            if (this.zzir != 5) {
                Preconditions.checkState(this.zzib > 0, "Invalid start time: %s", Long.valueOf(this.zzib));
                long j = this.zzic;
                Preconditions.checkState(j > 0 && j > this.zzib, "Invalid end time: %s", Long.valueOf(this.zzic));
            }
            boolean z2 = this.zzou.isEmpty() && this.zzot.isEmpty();
            if (this.zzir == 0) {
                Preconditions.checkState(z2, "Must specify a valid bucketing strategy while requesting aggregation");
            }
            if (!z2) {
                if (this.zzir != 0) {
                    z = true;
                }
                Preconditions.checkState(z, "Must specify a valid bucketing strategy while requesting aggregation");
            }
            return new DataReadRequest(this);
        }

        public Builder enableServerQueries() {
            this.zzoy = true;
            return this;
        }

        public Builder read(DataSource dataSource) {
            Preconditions.checkNotNull(dataSource, "Attempting to add a null data source");
            Preconditions.checkArgument(!this.zzou.contains(dataSource), "Cannot add the same data source as aggregated and detailed");
            if (!this.zzon.contains(dataSource)) {
                this.zzon.add(dataSource);
            }
            return this;
        }

        public Builder read(DataType dataType) {
            Preconditions.checkNotNull(dataType, "Attempting to use a null data type");
            Preconditions.checkState(!this.zzot.contains(dataType), "Cannot add the same data type as aggregated and detailed");
            if (!this.zzio.contains(dataType)) {
                this.zzio.add(dataType);
            }
            return this;
        }

        public Builder setLimit(int i) {
            Preconditions.checkArgument(i > 0, "Invalid limit %d is specified", Integer.valueOf(i));
            this.limit = i;
            return this;
        }

        public Builder setTimeRange(long j, long j2, TimeUnit timeUnit) {
            this.zzib = timeUnit.toMillis(j);
            this.zzic = timeUnit.toMillis(j2);
            return this;
        }
    }

    private DataReadRequest(Builder builder) {
        this((List<DataType>) builder.zzio, (List<DataSource>) builder.zzon, builder.zzib, builder.zzic, (List<DataType>) builder.zzot, (List<DataSource>) builder.zzou, builder.zzir, builder.zzov, builder.zzow, builder.limit, false, builder.zzoy, (zzbf) null, (List<Device>) builder.zzpa, (List<Integer>) builder.zzpb, (List<Long>) builder.zzpc, (List<Long>) builder.zzpd);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DataReadRequest(com.google.android.gms.fitness.request.DataReadRequest r24, com.google.android.gms.internal.fitness.zzbf r25) {
        /*
            r23 = this;
            r0 = r24
            r1 = r23
            r17 = r25
            java.util.List<com.google.android.gms.fitness.data.DataType> r2 = r0.zzio
            java.util.List<com.google.android.gms.fitness.data.DataSource> r3 = r0.zzon
            long r4 = r0.zzib
            long r6 = r0.zzic
            java.util.List<com.google.android.gms.fitness.data.DataType> r8 = r0.zzot
            java.util.List<com.google.android.gms.fitness.data.DataSource> r9 = r0.zzou
            int r10 = r0.zzir
            long r11 = r0.zzov
            com.google.android.gms.fitness.data.DataSource r13 = r0.zzow
            int r14 = r0.limit
            boolean r15 = r0.zzox
            r22 = r1
            boolean r1 = r0.zzoy
            r16 = r1
            java.util.List<com.google.android.gms.fitness.data.Device> r1 = r0.zzpa
            r18 = r1
            java.util.List<java.lang.Integer> r1 = r0.zzpb
            r19 = r1
            java.util.List<java.lang.Long> r1 = r0.zzpc
            r20 = r1
            java.util.List<java.lang.Long> r0 = r0.zzpd
            r21 = r0
            r1 = r22
            r1.<init>((java.util.List<com.google.android.gms.fitness.data.DataType>) r2, (java.util.List<com.google.android.gms.fitness.data.DataSource>) r3, (long) r4, (long) r6, (java.util.List<com.google.android.gms.fitness.data.DataType>) r8, (java.util.List<com.google.android.gms.fitness.data.DataSource>) r9, (int) r10, (long) r11, (com.google.android.gms.fitness.data.DataSource) r13, (int) r14, (boolean) r15, (boolean) r16, (com.google.android.gms.internal.fitness.zzbf) r17, (java.util.List<com.google.android.gms.fitness.data.Device>) r18, (java.util.List<java.lang.Integer>) r19, (java.util.List<java.lang.Long>) r20, (java.util.List<java.lang.Long>) r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fitness.request.DataReadRequest.<init>(com.google.android.gms.fitness.request.DataReadRequest, com.google.android.gms.internal.fitness.zzbf):void");
    }

    @SafeParcelable.Constructor
    DataReadRequest(@SafeParcelable.Param(mo11972id = 1) List<DataType> list, @SafeParcelable.Param(mo11972id = 2) List<DataSource> list2, @SafeParcelable.Param(mo11972id = 3) long j, @SafeParcelable.Param(mo11972id = 4) long j2, @SafeParcelable.Param(mo11972id = 5) List<DataType> list3, @SafeParcelable.Param(mo11972id = 6) List<DataSource> list4, @SafeParcelable.Param(mo11972id = 7) int i, @SafeParcelable.Param(mo11972id = 8) long j3, @SafeParcelable.Param(mo11972id = 9) DataSource dataSource, @SafeParcelable.Param(mo11972id = 10) int i2, @SafeParcelable.Param(mo11972id = 12) boolean z, @SafeParcelable.Param(mo11972id = 13) boolean z2, @SafeParcelable.Param(mo11972id = 14) IBinder iBinder, @SafeParcelable.Param(mo11972id = 16) List<Device> list5, @SafeParcelable.Param(mo11972id = 17) List<Integer> list6, @SafeParcelable.Param(mo11972id = 18) List<Long> list7, @SafeParcelable.Param(mo11972id = 19) List<Long> list8) {
        this.zzio = list;
        this.zzon = list2;
        this.zzib = j;
        this.zzic = j2;
        this.zzot = list3;
        this.zzou = list4;
        this.zzir = i;
        this.zzov = j3;
        this.zzow = dataSource;
        this.limit = i2;
        this.zzox = z;
        this.zzoy = z2;
        this.zzoz = iBinder == null ? null : zzbe.zzc(iBinder);
        this.zzpa = list5 == null ? Collections.emptyList() : list5;
        this.zzpb = list6 == null ? Collections.emptyList() : list6;
        this.zzpc = list7 == null ? Collections.emptyList() : list7;
        this.zzpd = list8 == null ? Collections.emptyList() : list8;
        Preconditions.checkArgument(this.zzpc.size() == this.zzpd.size(), "Unequal number of interval start and end times.");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private DataReadRequest(List<DataType> list, List<DataSource> list2, long j, long j2, List<DataType> list3, List<DataSource> list4, int i, long j3, DataSource dataSource, int i2, boolean z, boolean z2, @Nullable zzbf zzbf, List<Device> list5, List<Integer> list6, List<Long> list7, List<Long> list8) {
        this(list, list2, j, j2, list3, list4, i, j3, dataSource, i2, z, z2, zzbf == null ? null : zzbf.asBinder(), list5, list6, list7, list8);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof DataReadRequest) {
                DataReadRequest dataReadRequest = (DataReadRequest) obj;
                if (this.zzio.equals(dataReadRequest.zzio) && this.zzon.equals(dataReadRequest.zzon) && this.zzib == dataReadRequest.zzib && this.zzic == dataReadRequest.zzic && this.zzir == dataReadRequest.zzir && this.zzou.equals(dataReadRequest.zzou) && this.zzot.equals(dataReadRequest.zzot) && Objects.equal(this.zzow, dataReadRequest.zzow) && this.zzov == dataReadRequest.zzov && this.zzoy == dataReadRequest.zzoy && this.limit == dataReadRequest.limit && this.zzox == dataReadRequest.zzox && Objects.equal(this.zzoz, dataReadRequest.zzoz) && Objects.equal(this.zzpa, dataReadRequest.zzpa) && Objects.equal(this.zzpb, dataReadRequest.zzpb)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @Nullable
    public DataSource getActivityDataSource() {
        return this.zzow;
    }

    public List<DataSource> getAggregatedDataSources() {
        return this.zzou;
    }

    public List<DataType> getAggregatedDataTypes() {
        return this.zzot;
    }

    public long getBucketDuration(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzov, TimeUnit.MILLISECONDS);
    }

    public int getBucketType() {
        return this.zzir;
    }

    public List<DataSource> getDataSources() {
        return this.zzon;
    }

    public List<DataType> getDataTypes() {
        return this.zzio;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzic, TimeUnit.MILLISECONDS);
    }

    @Deprecated
    public List<Integer> getFilteredDataQualityStandards() {
        return this.zzpb;
    }

    public int getLimit() {
        return this.limit;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzib, TimeUnit.MILLISECONDS);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzir), Long.valueOf(this.zzib), Long.valueOf(this.zzic));
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("DataReadRequest{");
        if (!this.zzio.isEmpty()) {
            for (DataType zzp : this.zzio) {
                a.append(zzp.zzp());
                a.append(" ");
            }
        }
        if (!this.zzon.isEmpty()) {
            for (DataSource debugString : this.zzon) {
                a.append(debugString.toDebugString());
                a.append(" ");
            }
        }
        if (this.zzir != 0) {
            a.append("bucket by ");
            a.append(Bucket.zza(this.zzir));
            if (this.zzov > 0) {
                a.append(" >");
                a.append(this.zzov);
                a.append("ms");
            }
            a.append(": ");
        }
        if (!this.zzot.isEmpty()) {
            for (DataType zzp2 : this.zzot) {
                a.append(zzp2.zzp());
                a.append(" ");
            }
        }
        if (!this.zzou.isEmpty()) {
            for (DataSource debugString2 : this.zzou) {
                a.append(debugString2.toDebugString());
                a.append(" ");
            }
        }
        a.append(String.format(Locale.US, "(%tF %tT - %tF %tT)", new Object[]{Long.valueOf(this.zzib), Long.valueOf(this.zzib), Long.valueOf(this.zzic), Long.valueOf(this.zzic)}));
        if (this.zzow != null) {
            a.append("activities: ");
            a.append(this.zzow.toDebugString());
        }
        if (!this.zzpb.isEmpty()) {
            a.append("quality: ");
            for (Integer intValue : this.zzpb) {
                a.append(DataSource.zzd(intValue.intValue()));
                a.append(" ");
            }
        }
        if (this.zzoy) {
            a.append(" +server");
        }
        a.append("}");
        return a.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getDataTypes(), false);
        SafeParcelWriter.writeTypedList(parcel, 2, getDataSources(), false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzib);
        SafeParcelWriter.writeLong(parcel, 4, this.zzic);
        SafeParcelWriter.writeTypedList(parcel, 5, getAggregatedDataTypes(), false);
        SafeParcelWriter.writeTypedList(parcel, 6, getAggregatedDataSources(), false);
        SafeParcelWriter.writeInt(parcel, 7, getBucketType());
        SafeParcelWriter.writeLong(parcel, 8, this.zzov);
        SafeParcelWriter.writeParcelable(parcel, 9, getActivityDataSource(), i, false);
        SafeParcelWriter.writeInt(parcel, 10, getLimit());
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzox);
        SafeParcelWriter.writeBoolean(parcel, 13, this.zzoy);
        zzbf zzbf = this.zzoz;
        SafeParcelWriter.writeIBinder(parcel, 14, zzbf == null ? null : zzbf.asBinder(), false);
        SafeParcelWriter.writeTypedList(parcel, 16, this.zzpa, false);
        SafeParcelWriter.writeIntegerList(parcel, 17, getFilteredDataQualityStandards(), false);
        SafeParcelWriter.writeLongList(parcel, 18, this.zzpc, false);
        SafeParcelWriter.writeLongList(parcel, 19, this.zzpd, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
