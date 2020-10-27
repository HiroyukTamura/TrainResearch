package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

@SafeParcelable.Class(creator = "DataSetCreator")
@SafeParcelable.Reserved({2})
public final class DataSet extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<DataSet> CREATOR = new zzi();
    @SafeParcelable.VersionField(getter = "getVersionCode", mo11975id = 1000)
    private final int versionCode;
    @SafeParcelable.Field(getter = "getDataSource", mo11969id = 1)
    private final DataSource zzia;
    @SafeParcelable.Field(getter = "serverHasMoreData", mo11969id = 5)
    private boolean zzis;
    @SafeParcelable.Field(getter = "getRawDataPoints", mo11969id = 3, type = "java.util.List")
    private final List<DataPoint> zzjb;
    @SafeParcelable.Field(getter = "getUniqueDataSources", mo11969id = 4)
    private final List<DataSource> zzjc;

    public static class Builder {
        private boolean zzja;
        private final DataSet zzjd;

        private Builder(DataSource dataSource) {
            this.zzja = false;
            this.zzjd = DataSet.create(dataSource);
        }

        public Builder add(DataPoint dataPoint) {
            Preconditions.checkState(!this.zzja, "Builder should not be mutated after calling #build.");
            this.zzjd.add(dataPoint);
            return this;
        }

        public Builder addAll(Iterable<DataPoint> iterable) {
            Preconditions.checkState(!this.zzja, "Builder should not be mutated after calling #build.");
            this.zzjd.addAll(iterable);
            return this;
        }

        public DataSet build() {
            Preconditions.checkState(!this.zzja, "DataSet#build() should only be called once.");
            this.zzja = true;
            return this.zzjd;
        }
    }

    @SafeParcelable.Constructor
    DataSet(@SafeParcelable.Param(mo11972id = 1000) int i, @SafeParcelable.Param(mo11972id = 1) DataSource dataSource, @SafeParcelable.Param(mo11972id = 3) List<RawDataPoint> list, @SafeParcelable.Param(mo11972id = 4) List<DataSource> list2, @SafeParcelable.Param(mo11972id = 5) boolean z) {
        this.zzis = false;
        this.versionCode = i;
        this.zzia = dataSource;
        this.zzis = z;
        this.zzjb = new ArrayList(list.size());
        this.zzjc = i < 2 ? Collections.singletonList(dataSource) : list2;
        for (RawDataPoint dataPoint : list) {
            this.zzjb.add(new DataPoint(this.zzjc, dataPoint));
        }
    }

    @ShowFirstParty
    private DataSet(DataSource dataSource) {
        this.zzis = false;
        this.versionCode = 3;
        this.zzia = (DataSource) Preconditions.checkNotNull(dataSource);
        this.zzjb = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.zzjc = arrayList;
        arrayList.add(this.zzia);
    }

    public DataSet(RawDataSet rawDataSet, List<DataSource> list) {
        this.zzis = false;
        this.versionCode = 3;
        this.zzia = list.get(rawDataSet.zzlx);
        this.zzjc = list;
        this.zzis = rawDataSet.zzis;
        List<RawDataPoint> list2 = rawDataSet.zzlz;
        this.zzjb = new ArrayList(list2.size());
        for (RawDataPoint dataPoint : list2) {
            this.zzjb.add(new DataPoint(this.zzjc, dataPoint));
        }
    }

    public static Builder builder(DataSource dataSource) {
        Preconditions.checkNotNull(dataSource, "DataSource should be specified");
        return new Builder(dataSource);
    }

    public static DataSet create(DataSource dataSource) {
        Preconditions.checkNotNull(dataSource, "DataSource should be specified");
        return new DataSet(dataSource);
    }

    @ShowFirstParty
    @Deprecated
    private final void zza(DataPoint dataPoint) {
        this.zzjb.add(dataPoint);
        DataSource originalDataSource = dataPoint.getOriginalDataSource();
        if (originalDataSource != null && !this.zzjc.contains(originalDataSource)) {
            this.zzjc.add(originalDataSource);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c7, code lost:
        if (r4 != 0.0d) goto L_0x00db;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00dd A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00de  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void zzb(com.google.android.gms.fitness.data.DataPoint r11) throws java.lang.IllegalArgumentException {
        /*
            com.google.android.gms.fitness.data.DataType r0 = r11.getDataType()
            java.lang.String r0 = r0.getName()
            com.google.android.gms.fitness.data.DataType r0 = com.google.android.gms.fitness.data.zzl.zzb(r0)
            java.lang.String r1 = "DataPoint out of range"
            if (r0 == 0) goto L_0x00da
            com.google.android.gms.fitness.data.DataType r0 = r11.getDataType()
            r2 = 0
        L_0x0015:
            java.util.List r3 = r0.getFields()
            int r3 = r3.size()
            if (r2 >= r3) goto L_0x00da
            java.util.List r3 = r0.getFields()
            java.lang.Object r3 = r3.get(r2)
            com.google.android.gms.fitness.data.Field r3 = (com.google.android.gms.fitness.data.Field) r3
            java.lang.String r3 = r3.getName()
            com.google.android.gms.fitness.data.Value r4 = r11.zzb(r2)
            boolean r4 = r4.isSet()
            if (r4 != 0) goto L_0x0061
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            java.util.List r5 = r0.getFields()
            java.lang.Object r5 = r5.get(r2)
            com.google.android.gms.fitness.data.Field r5 = (com.google.android.gms.fitness.data.Field) r5
            java.lang.Boolean r5 = r5.isOptional()
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x00d6
            java.util.Set<java.lang.String> r4 = com.google.android.gms.fitness.data.zzah.zzmi
            boolean r4 = r4.contains(r3)
            if (r4 != 0) goto L_0x00d6
            java.lang.String r0 = java.lang.String.valueOf(r3)
            java.lang.String r1 = " not set"
            java.lang.String r1 = r0.concat(r1)
            goto L_0x00db
        L_0x0061:
            java.util.List r4 = r0.getFields()
            java.lang.Object r4 = r4.get(r2)
            com.google.android.gms.fitness.data.Field r4 = (com.google.android.gms.fitness.data.Field) r4
            int r4 = r4.getFormat()
            double r4 = (double) r4
            r6 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x0080
            com.google.android.gms.fitness.data.Value r4 = r11.zzb(r2)
            int r4 = r4.asInt()
            double r4 = (double) r4
            goto L_0x008f
        L_0x0080:
            r6 = 4611686018427387904(0x4000000000000000, double:2.0)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x00d6
            com.google.android.gms.fitness.data.Value r4 = r11.zzb(r2)
            float r4 = r4.asFloat()
            double r4 = (double) r4
        L_0x008f:
            com.google.android.gms.fitness.data.zzah r6 = com.google.android.gms.fitness.data.zzah.zzw()
            com.google.android.gms.fitness.data.zzaj r6 = r6.zzj(r3)
            if (r6 == 0) goto L_0x00a2
            boolean r6 = r6.zza(r4)
            if (r6 != 0) goto L_0x00a2
            java.lang.String r1 = "Field out of range"
            goto L_0x00db
        L_0x00a2:
            java.lang.String r6 = r0.getName()
            com.google.android.gms.fitness.data.zzah r7 = com.google.android.gms.fitness.data.zzah.zzw()
            com.google.android.gms.fitness.data.zzaj r3 = r7.zza((java.lang.String) r6, (java.lang.String) r3)
            if (r3 == 0) goto L_0x00d6
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r6 = r11.getEndTime(r6)
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r8 = r11.getStartTime(r8)
            long r6 = r6 - r8
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 != 0) goto L_0x00ca
            r2 = 0
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x00da
            goto L_0x00db
        L_0x00ca:
            double r6 = (double) r6
            java.lang.Double.isNaN(r6)
            double r4 = r4 / r6
            boolean r3 = r3.zza(r4)
            if (r3 != 0) goto L_0x00d6
            goto L_0x00db
        L_0x00d6:
            int r2 = r2 + 1
            goto L_0x0015
        L_0x00da:
            r1 = 0
        L_0x00db:
            if (r1 != 0) goto L_0x00de
            return
        L_0x00de:
            java.lang.String r11 = java.lang.String.valueOf(r11)
            int r0 = r11.length()
            int r0 = r0 + 20
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
            java.lang.String r0 = "Invalid data point: "
            r2.append(r0)
            r2.append(r11)
            java.lang.String r11 = r2.toString()
            java.lang.String r0 = "Fitness"
            android.util.Log.w(r0, r11)
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            r11.<init>(r1)
            goto L_0x0105
        L_0x0104:
            throw r11
        L_0x0105:
            goto L_0x0104
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fitness.data.DataSet.zzb(com.google.android.gms.fitness.data.DataPoint):void");
    }

    private final List<RawDataPoint> zzk() {
        return zza(this.zzjc);
    }

    @Deprecated
    public final void add(DataPoint dataPoint) {
        DataSource dataSource = dataPoint.getDataSource();
        Preconditions.checkArgument(dataSource.getStreamIdentifier().equals(this.zzia.getStreamIdentifier()), "Conflicting data sources found %s vs %s", dataSource, this.zzia);
        dataPoint.zzj();
        zzb(dataPoint);
        zza(dataPoint);
    }

    @Deprecated
    public final void addAll(Iterable<DataPoint> iterable) {
        for (DataPoint add : iterable) {
            add(add);
        }
    }

    public final DataPoint createDataPoint() {
        return DataPoint.create(this.zzia);
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DataSet)) {
            return false;
        }
        DataSet dataSet = (DataSet) obj;
        return Objects.equal(this.zzia, dataSet.zzia) && Objects.equal(this.zzjb, dataSet.zzjb) && this.zzis == dataSet.zzis;
    }

    public final List<DataPoint> getDataPoints() {
        return Collections.unmodifiableList(this.zzjb);
    }

    public final DataSource getDataSource() {
        return this.zzia;
    }

    public final DataType getDataType() {
        return this.zzia.getDataType();
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzia);
    }

    public final boolean isEmpty() {
        return this.zzjb.isEmpty();
    }

    public final String toString() {
        List<RawDataPoint> zzk = zzk();
        Locale locale = Locale.US;
        Object[] objArr = new Object[2];
        objArr[0] = this.zzia.toDebugString();
        Object obj = zzk;
        if (this.zzjb.size() >= 10) {
            obj = String.format(Locale.US, "%d data points, first 5: %s", new Object[]{Integer.valueOf(this.zzjb.size()), zzk.subList(0, 5)});
        }
        objArr[1] = obj;
        return String.format(locale, "DataSet{%s %s}", objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getDataSource(), i, false);
        SafeParcelWriter.writeList(parcel, 3, zzk(), false);
        SafeParcelWriter.writeTypedList(parcel, 4, this.zzjc, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzis);
        SafeParcelWriter.writeInt(parcel, 1000, this.versionCode);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* access modifiers changed from: package-private */
    public final List<RawDataPoint> zza(List<DataSource> list) {
        ArrayList arrayList = new ArrayList(this.zzjb.size());
        for (DataPoint rawDataPoint : this.zzjb) {
            arrayList.add(new RawDataPoint(rawDataPoint, list));
        }
        return arrayList;
    }

    @ShowFirstParty
    @Deprecated
    public final void zza(Iterable<DataPoint> iterable) {
        for (DataPoint zza : iterable) {
            zza(zza);
        }
    }

    @ShowFirstParty
    public final boolean zze() {
        return this.zzis;
    }
}
