package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SubscriptionCreator")
@SafeParcelable.Reserved({1000})
public class Subscription extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Subscription> CREATOR = new zzai();
    @SafeParcelable.Field(getter = "getDataType", mo11969id = 2)
    private final DataType zzhz;
    @SafeParcelable.Field(getter = "getDataSource", mo11969id = 1)
    private final DataSource zzia;
    @SafeParcelable.Field(getter = "getSamplingRateMicros", mo11969id = 3)
    private final long zzmc;
    @SafeParcelable.Field(getter = "getAccuracyMode", mo11969id = 4)
    private final int zzmd;

    @ShowFirstParty
    public static class zza {
        /* access modifiers changed from: private */
        public DataType zzhz;
        /* access modifiers changed from: private */
        public DataSource zzia;
        /* access modifiers changed from: private */
        public long zzmc = -1;
        /* access modifiers changed from: private */
        public int zzmd = 2;

        public final zza zza(DataSource dataSource) {
            this.zzia = dataSource;
            return this;
        }

        public final zza zza(DataType dataType) {
            this.zzhz = dataType;
            return this;
        }

        public final Subscription zzv() {
            DataSource dataSource;
            boolean z = false;
            Preconditions.checkState((this.zzia == null && this.zzhz == null) ? false : true, "Must call setDataSource() or setDataType()");
            DataType dataType = this.zzhz;
            if (dataType == null || (dataSource = this.zzia) == null || dataType.equals(dataSource.getDataType())) {
                z = true;
            }
            Preconditions.checkState(z, "Specified data type is incompatible with specified data source");
            return new Subscription(this);
        }
    }

    @SafeParcelable.Constructor
    Subscription(@SafeParcelable.Param(mo11972id = 1) DataSource dataSource, @SafeParcelable.Param(mo11972id = 2) DataType dataType, @SafeParcelable.Param(mo11972id = 3) long j, @SafeParcelable.Param(mo11972id = 4) int i) {
        this.zzia = dataSource;
        this.zzhz = dataType;
        this.zzmc = j;
        this.zzmd = i;
    }

    private Subscription(zza zza2) {
        this.zzhz = zza2.zzhz;
        this.zzia = zza2.zzia;
        this.zzmc = zza2.zzmc;
        this.zzmd = zza2.zzmd;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Subscription)) {
            return false;
        }
        Subscription subscription = (Subscription) obj;
        return Objects.equal(this.zzia, subscription.zzia) && Objects.equal(this.zzhz, subscription.zzhz) && this.zzmc == subscription.zzmc && this.zzmd == subscription.zzmd;
    }

    @Nullable
    public DataSource getDataSource() {
        return this.zzia;
    }

    @Nullable
    public DataType getDataType() {
        return this.zzhz;
    }

    public int hashCode() {
        DataSource dataSource = this.zzia;
        return Objects.hashCode(dataSource, dataSource, Long.valueOf(this.zzmc), Integer.valueOf(this.zzmd));
    }

    public String toDebugString() {
        Object[] objArr = new Object[1];
        DataSource dataSource = this.zzia;
        objArr[0] = dataSource == null ? this.zzhz.getName() : dataSource.toDebugString();
        return String.format("Subscription{%s}", objArr);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("dataSource", this.zzia).add("dataType", this.zzhz).add("samplingIntervalMicros", Long.valueOf(this.zzmc)).add("accuracyMode", Integer.valueOf(this.zzmd)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getDataSource(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getDataType(), i, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzmc);
        SafeParcelWriter.writeInt(parcel, 4, this.zzmd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final DataType zzu() {
        DataType dataType = this.zzhz;
        return dataType == null ? this.zzia.getDataType() : dataType;
    }
}
