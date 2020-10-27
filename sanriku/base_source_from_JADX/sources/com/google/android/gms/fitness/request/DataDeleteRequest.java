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
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SafeParcelable.Class(creator = "DataDeleteRequestCreator")
@SafeParcelable.Reserved({9, 1000})
public class DataDeleteRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DataDeleteRequest> CREATOR = new zzj();
    @SafeParcelable.Field(getter = "getStartTimeMillis", mo11969id = 1)
    private final long zzib;
    @SafeParcelable.Field(getter = "getEndTimeMillis", mo11969id = 2)
    private final long zzic;
    @SafeParcelable.Field(getter = "getDataTypes", mo11969id = 4)
    private final List<DataType> zzio;
    @SafeParcelable.Field(getter = "getCallbackBinder", mo11969id = 8, type = "android.os.IBinder")
    @Nullable
    private final zzcm zzok;
    @SafeParcelable.Field(getter = "getDataSources", mo11969id = 3)
    private final List<DataSource> zzon;
    @SafeParcelable.Field(getter = "getSessions", mo11969id = 5)
    private final List<Session> zzoo;
    @SafeParcelable.Field(getter = "deleteAllData", mo11969id = 6)
    private final boolean zzop;
    @SafeParcelable.Field(getter = "deleteAllSessions", mo11969id = 7)
    private final boolean zzoq;
    @SafeParcelable.Field(getter = "deleteByTimeRange", mo11969id = 10)
    private final boolean zzor;

    public static class Builder {
        /* access modifiers changed from: private */
        public long zzib;
        /* access modifiers changed from: private */
        public long zzic;
        /* access modifiers changed from: private */
        public List<DataType> zzio = new ArrayList();
        /* access modifiers changed from: private */
        public List<DataSource> zzon = new ArrayList();
        /* access modifiers changed from: private */
        public List<Session> zzoo = new ArrayList();
        /* access modifiers changed from: private */
        public boolean zzop = false;
        /* access modifiers changed from: private */
        public boolean zzoq = false;
        private boolean zzor = false;

        public Builder addDataSource(DataSource dataSource) {
            boolean z = true;
            Preconditions.checkArgument(!this.zzop, "All data is already marked for deletion.  addDataSource() cannot be combined with deleteAllData()");
            if (dataSource == null) {
                z = false;
            }
            Preconditions.checkArgument(z, "Must specify a valid data source");
            if (!this.zzon.contains(dataSource)) {
                this.zzon.add(dataSource);
            }
            return this;
        }

        public Builder addDataType(DataType dataType) {
            boolean z = true;
            Preconditions.checkArgument(!this.zzop, "All data is already marked for deletion.  addDataType() cannot be combined with deleteAllData()");
            if (dataType == null) {
                z = false;
            }
            Preconditions.checkArgument(z, "Must specify a valid data type");
            if (!this.zzio.contains(dataType)) {
                this.zzio.add(dataType);
            }
            return this;
        }

        public Builder addSession(Session session) {
            boolean z = true;
            Preconditions.checkArgument(!this.zzoq, "All sessions already marked for deletion.  addSession() cannot be combined with deleteAllSessions()");
            Preconditions.checkArgument(session != null, "Must specify a valid session");
            if (session.getEndTime(TimeUnit.MILLISECONDS) <= 0) {
                z = false;
            }
            Preconditions.checkArgument(z, "Cannot delete an ongoing session. Please stop the session prior to deleting it");
            this.zzoo.add(session);
            return this;
        }

        public DataDeleteRequest build() {
            long j = this.zzib;
            Preconditions.checkState(j > 0 && this.zzic > j, "Must specify a valid time interval");
            Preconditions.checkState((this.zzop || !this.zzon.isEmpty() || !this.zzio.isEmpty()) || (this.zzoq || !this.zzoo.isEmpty()), "No data or session marked for deletion");
            if (!this.zzoo.isEmpty()) {
                for (Session next : this.zzoo) {
                    Preconditions.checkState(next.getStartTime(TimeUnit.MILLISECONDS) >= this.zzib && next.getEndTime(TimeUnit.MILLISECONDS) <= this.zzic, "Session %s is outside the time interval [%d, %d]", next, Long.valueOf(this.zzib), Long.valueOf(this.zzic));
                }
            }
            return new DataDeleteRequest(this);
        }

        public Builder deleteAllData() {
            Preconditions.checkArgument(this.zzio.isEmpty(), "Specific data type already added for deletion. deleteAllData() will delete all data types and cannot be combined with addDataType()");
            Preconditions.checkArgument(this.zzon.isEmpty(), "Specific data source already added for deletion. deleteAllData() will delete all data sources and cannot be combined with addDataSource()");
            this.zzop = true;
            return this;
        }

        public Builder deleteAllSessions() {
            Preconditions.checkArgument(this.zzoo.isEmpty(), "Specific session already added for deletion. deleteAllData() will delete all sessions and cannot be combined with addSession()");
            this.zzoq = true;
            return this;
        }

        public Builder setTimeInterval(long j, long j2, TimeUnit timeUnit) {
            Preconditions.checkArgument(j > 0, "Invalid start time: %d", Long.valueOf(j));
            Preconditions.checkArgument(j2 > j, "Invalid end time: %d", Long.valueOf(j2));
            this.zzib = timeUnit.toMillis(j);
            this.zzic = timeUnit.toMillis(j2);
            return this;
        }
    }

    @SafeParcelable.Constructor
    DataDeleteRequest(@SafeParcelable.Param(mo11972id = 1) long j, @SafeParcelable.Param(mo11972id = 2) long j2, @SafeParcelable.Param(mo11972id = 3) List<DataSource> list, @SafeParcelable.Param(mo11972id = 4) List<DataType> list2, @SafeParcelable.Param(mo11972id = 5) List<Session> list3, @SafeParcelable.Param(mo11972id = 6) boolean z, @SafeParcelable.Param(mo11972id = 7) boolean z2, @SafeParcelable.Param(mo11972id = 10) boolean z3, @SafeParcelable.Param(mo11972id = 8) IBinder iBinder) {
        this.zzib = j;
        this.zzic = j2;
        this.zzon = Collections.unmodifiableList(list);
        this.zzio = Collections.unmodifiableList(list2);
        this.zzoo = list3;
        this.zzop = z;
        this.zzoq = z2;
        this.zzor = z3;
        this.zzok = zzcp.zzj(iBinder);
    }

    private DataDeleteRequest(long j, long j2, List<DataSource> list, List<DataType> list2, List<Session> list3, boolean z, boolean z2, boolean z3, @Nullable zzcm zzcm) {
        this.zzib = j;
        this.zzic = j2;
        this.zzon = Collections.unmodifiableList(list);
        this.zzio = Collections.unmodifiableList(list2);
        this.zzoo = list3;
        this.zzop = z;
        this.zzoq = z2;
        this.zzor = z3;
        this.zzok = zzcm;
    }

    private DataDeleteRequest(Builder builder) {
        this(builder.zzib, builder.zzic, (List<DataSource>) builder.zzon, (List<DataType>) builder.zzio, (List<Session>) builder.zzoo, builder.zzop, builder.zzoq, false, (zzcm) null);
    }

    public DataDeleteRequest(DataDeleteRequest dataDeleteRequest, zzcm zzcm) {
        this(dataDeleteRequest.zzib, dataDeleteRequest.zzic, dataDeleteRequest.zzon, dataDeleteRequest.zzio, dataDeleteRequest.zzoo, dataDeleteRequest.zzop, dataDeleteRequest.zzoq, dataDeleteRequest.zzor, zzcm);
    }

    public boolean deleteAllData() {
        return this.zzop;
    }

    public boolean deleteAllSessions() {
        return this.zzoq;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj != this) {
            if (obj instanceof DataDeleteRequest) {
                DataDeleteRequest dataDeleteRequest = (DataDeleteRequest) obj;
                if (this.zzib == dataDeleteRequest.zzib && this.zzic == dataDeleteRequest.zzic && Objects.equal(this.zzon, dataDeleteRequest.zzon) && Objects.equal(this.zzio, dataDeleteRequest.zzio) && Objects.equal(this.zzoo, dataDeleteRequest.zzoo) && this.zzop == dataDeleteRequest.zzop && this.zzoq == dataDeleteRequest.zzoq && this.zzor == dataDeleteRequest.zzor) {
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

    public List<DataType> getDataTypes() {
        return this.zzio;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzic, TimeUnit.MILLISECONDS);
    }

    public List<Session> getSessions() {
        return this.zzoo;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzib, TimeUnit.MILLISECONDS);
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zzib), Long.valueOf(this.zzic));
    }

    public String toString() {
        Objects.ToStringHelper add = Objects.toStringHelper(this).add("startTimeMillis", Long.valueOf(this.zzib)).add("endTimeMillis", Long.valueOf(this.zzic)).add("dataSources", this.zzon).add("dateTypes", this.zzio).add("sessions", this.zzoo).add("deleteAllData", Boolean.valueOf(this.zzop)).add("deleteAllSessions", Boolean.valueOf(this.zzoq));
        boolean z = this.zzor;
        if (z) {
            add.add("deleteByTimeRange", Boolean.valueOf(z));
        }
        return add.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.zzib);
        SafeParcelWriter.writeLong(parcel, 2, this.zzic);
        SafeParcelWriter.writeTypedList(parcel, 3, getDataSources(), false);
        SafeParcelWriter.writeTypedList(parcel, 4, getDataTypes(), false);
        SafeParcelWriter.writeTypedList(parcel, 5, getSessions(), false);
        SafeParcelWriter.writeBoolean(parcel, 6, deleteAllData());
        SafeParcelWriter.writeBoolean(parcel, 7, deleteAllSessions());
        zzcm zzcm = this.zzok;
        SafeParcelWriter.writeIBinder(parcel, 8, zzcm == null ? null : zzcm.asBinder(), false);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzor);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
