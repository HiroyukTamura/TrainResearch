package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fitness.zzjn;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SafeParcelable.Class(creator = "BucketCreator")
@SafeParcelable.Reserved({1000})
public class Bucket extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Bucket> CREATOR = new zze();
    public static final int TYPE_ACTIVITY_SEGMENT = 4;
    public static final int TYPE_ACTIVITY_TYPE = 3;
    public static final int TYPE_SESSION = 2;
    public static final int TYPE_TIME = 1;
    @SafeParcelable.Field(getter = "getStartTimeMillis", mo11969id = 1)
    private final long zzib;
    @SafeParcelable.Field(getter = "getEndTimeMillis", mo11969id = 2)
    private final long zzic;
    @SafeParcelable.Field(getter = "getSession", mo11969id = 3)
    @Nullable
    private final Session zzii;
    @SafeParcelable.Field(getter = "getActivityType", mo11969id = 4)
    private final int zzip;
    @SafeParcelable.Field(getter = "getDataSets", mo11969id = 5)
    private final List<DataSet> zziq;
    @SafeParcelable.Field(getter = "getBucketType", mo11969id = 6)
    private final int zzir;
    @SafeParcelable.Field(getter = "serverHasMoreData", mo11969id = 7)
    private boolean zzis;

    @SafeParcelable.Constructor
    Bucket(@SafeParcelable.Param(mo11972id = 1) long j, @SafeParcelable.Param(mo11972id = 2) long j2, @SafeParcelable.Param(mo11972id = 3) @Nullable Session session, @SafeParcelable.Param(mo11972id = 4) int i, @SafeParcelable.Param(mo11972id = 5) List<DataSet> list, @SafeParcelable.Param(mo11972id = 6) int i2, @SafeParcelable.Param(mo11972id = 7) boolean z) {
        this.zzis = false;
        this.zzib = j;
        this.zzic = j2;
        this.zzii = session;
        this.zzip = i;
        this.zziq = list;
        this.zzir = i2;
        this.zzis = z;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Bucket(com.google.android.gms.fitness.data.RawBucket r11, java.util.List<com.google.android.gms.fitness.data.DataSource> r12) {
        /*
            r10 = this;
            long r1 = r11.zzib
            long r3 = r11.zzic
            com.google.android.gms.fitness.data.Session r5 = r11.zzii
            int r6 = r11.zzlv
            java.util.List<com.google.android.gms.fitness.data.RawDataSet> r0 = r11.zziq
            java.util.ArrayList r7 = new java.util.ArrayList
            int r8 = r0.size()
            r7.<init>(r8)
            java.util.Iterator r0 = r0.iterator()
        L_0x0017:
            boolean r8 = r0.hasNext()
            if (r8 == 0) goto L_0x002c
            java.lang.Object r8 = r0.next()
            com.google.android.gms.fitness.data.RawDataSet r8 = (com.google.android.gms.fitness.data.RawDataSet) r8
            com.google.android.gms.fitness.data.DataSet r9 = new com.google.android.gms.fitness.data.DataSet
            r9.<init>(r8, r12)
            r7.add(r9)
            goto L_0x0017
        L_0x002c:
            int r8 = r11.zzir
            boolean r9 = r11.zzis
            r0 = r10
            r0.<init>(r1, r3, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fitness.data.Bucket.<init>(com.google.android.gms.fitness.data.RawBucket, java.util.List):void");
    }

    @ShowFirstParty
    public static String zza(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "bug" : "intervals" : "segment" : "type" : "session" : "time" : "none";
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Bucket)) {
            return false;
        }
        Bucket bucket = (Bucket) obj;
        return this.zzib == bucket.zzib && this.zzic == bucket.zzic && this.zzip == bucket.zzip && Objects.equal(this.zziq, bucket.zziq) && this.zzir == bucket.zzir && this.zzis == bucket.zzis;
    }

    public String getActivity() {
        return zzjn.getName(this.zzip);
    }

    public int getBucketType() {
        return this.zzir;
    }

    @Nullable
    public DataSet getDataSet(DataType dataType) {
        for (DataSet next : this.zziq) {
            if (next.getDataType().equals(dataType)) {
                return next;
            }
        }
        return null;
    }

    public List<DataSet> getDataSets() {
        return this.zziq;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzic, TimeUnit.MILLISECONDS);
    }

    @Nullable
    public Session getSession() {
        return this.zzii;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzib, TimeUnit.MILLISECONDS);
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zzib), Long.valueOf(this.zzic), Integer.valueOf(this.zzip), Integer.valueOf(this.zzir));
    }

    public String toString() {
        return Objects.toStringHelper(this).add("startTime", Long.valueOf(this.zzib)).add("endTime", Long.valueOf(this.zzic)).add("activity", Integer.valueOf(this.zzip)).add("dataSets", this.zziq).add("bucketType", zza(this.zzir)).add("serverHasMoreData", Boolean.valueOf(this.zzis)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.zzib);
        SafeParcelWriter.writeLong(parcel, 2, this.zzic);
        SafeParcelWriter.writeParcelable(parcel, 3, getSession(), i, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzip);
        SafeParcelWriter.writeTypedList(parcel, 5, getDataSets(), false);
        SafeParcelWriter.writeInt(parcel, 6, getBucketType());
        SafeParcelWriter.writeBoolean(parcel, 7, zze());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean zza(Bucket bucket) {
        return this.zzib == bucket.zzib && this.zzic == bucket.zzic && this.zzip == bucket.zzip && this.zzir == bucket.zzir;
    }

    @ShowFirstParty
    public final int zzd() {
        return this.zzip;
    }

    public final boolean zze() {
        if (this.zzis) {
            return true;
        }
        for (DataSet zze : this.zziq) {
            if (zze.zze()) {
                return true;
            }
        }
        return false;
    }
}
