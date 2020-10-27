package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcp;

@SafeParcelable.Class(creator = "DataUpdateListenerRegistrationRequestCreator")
@SafeParcelable.Reserved({1000})
public class DataUpdateListenerRegistrationRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DataUpdateListenerRegistrationRequest> CREATOR = new zzv();
    @SafeParcelable.Field(getter = "getDataType", mo11969id = 2)
    @Nullable
    private DataType zzhz;
    @SafeParcelable.Field(getter = "getDataSource", mo11969id = 1)
    @Nullable
    private DataSource zzia;
    @SafeParcelable.Field(getter = "getCallbackBinder", mo11969id = 4, type = "android.os.IBinder")
    @Nullable
    private final zzcm zzok;
    @SafeParcelable.Field(getter = "getIntent", mo11969id = 3)
    private final PendingIntent zzpk;

    public static class Builder {
        /* access modifiers changed from: private */
        public DataType zzhz;
        /* access modifiers changed from: private */
        public DataSource zzia;
        /* access modifiers changed from: private */
        public PendingIntent zzpk;

        public DataUpdateListenerRegistrationRequest build() {
            Preconditions.checkState((this.zzia == null && this.zzhz == null) ? false : true, "Set either dataSource or dataTYpe");
            Preconditions.checkNotNull(this.zzpk, "pendingIntent must be set");
            return new DataUpdateListenerRegistrationRequest(this);
        }

        public Builder setDataSource(DataSource dataSource) throws NullPointerException {
            Preconditions.checkNotNull(dataSource);
            this.zzia = dataSource;
            return this;
        }

        public Builder setDataType(DataType dataType) {
            Preconditions.checkNotNull(dataType);
            this.zzhz = dataType;
            return this;
        }

        public Builder setPendingIntent(PendingIntent pendingIntent) {
            Preconditions.checkNotNull(pendingIntent);
            this.zzpk = pendingIntent;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public DataUpdateListenerRegistrationRequest(@SafeParcelable.Param(mo11972id = 1) DataSource dataSource, @SafeParcelable.Param(mo11972id = 2) DataType dataType, @SafeParcelable.Param(mo11972id = 3) PendingIntent pendingIntent, @SafeParcelable.Param(mo11972id = 4) IBinder iBinder) {
        this.zzia = dataSource;
        this.zzhz = dataType;
        this.zzpk = pendingIntent;
        this.zzok = zzcp.zzj(iBinder);
    }

    private DataUpdateListenerRegistrationRequest(Builder builder) {
        this(builder.zzia, builder.zzhz, builder.zzpk, (IBinder) null);
    }

    public DataUpdateListenerRegistrationRequest(DataUpdateListenerRegistrationRequest dataUpdateListenerRegistrationRequest, IBinder iBinder) {
        this(dataUpdateListenerRegistrationRequest.zzia, dataUpdateListenerRegistrationRequest.zzhz, dataUpdateListenerRegistrationRequest.zzpk, iBinder);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof DataUpdateListenerRegistrationRequest) {
                DataUpdateListenerRegistrationRequest dataUpdateListenerRegistrationRequest = (DataUpdateListenerRegistrationRequest) obj;
                if (Objects.equal(this.zzia, dataUpdateListenerRegistrationRequest.zzia) && Objects.equal(this.zzhz, dataUpdateListenerRegistrationRequest.zzhz) && Objects.equal(this.zzpk, dataUpdateListenerRegistrationRequest.zzpk)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public DataSource getDataSource() {
        return this.zzia;
    }

    public DataType getDataType() {
        return this.zzhz;
    }

    @Nullable
    public PendingIntent getIntent() {
        return this.zzpk;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzia, this.zzhz, this.zzpk);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("dataSource", this.zzia).add("dataType", this.zzhz).add(BaseGmsClient.KEY_PENDING_INTENT, this.zzpk).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getDataSource(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getDataType(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, getIntent(), i, false);
        zzcm zzcm = this.zzok;
        SafeParcelWriter.writeIBinder(parcel, 4, zzcm == null ? null : zzcm.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
