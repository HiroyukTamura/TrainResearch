package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.zzt;
import com.google.android.gms.fitness.data.zzu;
import java.util.concurrent.TimeUnit;

@SafeParcelable.Class(creator = "FitnessSensorServiceRequestCreator")
@SafeParcelable.Reserved({1000})
public class FitnessSensorServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<FitnessSensorServiceRequest> CREATOR = new zzb();
    public static final int UNSPECIFIED = -1;
    @SafeParcelable.Field(getter = "getDataSource", mo11969id = 1)
    private final DataSource zzia;
    @SafeParcelable.Field(getter = "getListenerBinder", mo11969id = 2, type = "android.os.IBinder")
    private final zzu zzpt;
    @SafeParcelable.Field(getter = "getSamplingRateMicros", mo11969id = 3)
    private final long zzqy;
    @SafeParcelable.Field(getter = "getBatchIntervalMicros", mo11969id = 4)
    private final long zzqz;

    @SafeParcelable.Constructor
    FitnessSensorServiceRequest(@SafeParcelable.Param(mo11972id = 1) DataSource dataSource, @SafeParcelable.Param(mo11972id = 2) IBinder iBinder, @SafeParcelable.Param(mo11972id = 3) long j, @SafeParcelable.Param(mo11972id = 4) long j2) {
        this.zzia = dataSource;
        this.zzpt = zzt.zza(iBinder);
        this.zzqy = j;
        this.zzqz = j2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FitnessSensorServiceRequest)) {
            return false;
        }
        FitnessSensorServiceRequest fitnessSensorServiceRequest = (FitnessSensorServiceRequest) obj;
        return Objects.equal(this.zzia, fitnessSensorServiceRequest.zzia) && this.zzqy == fitnessSensorServiceRequest.zzqy && this.zzqz == fitnessSensorServiceRequest.zzqz;
    }

    public long getBatchInterval(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzqz, TimeUnit.MICROSECONDS);
    }

    public DataSource getDataSource() {
        return this.zzia;
    }

    public SensorEventDispatcher getDispatcher() {
        return new zzc(this.zzpt);
    }

    public long getSamplingRate(TimeUnit timeUnit) {
        long j = this.zzqy;
        if (j == -1) {
            return -1;
        }
        return timeUnit.convert(j, TimeUnit.MICROSECONDS);
    }

    public int hashCode() {
        return Objects.hashCode(this.zzia, Long.valueOf(this.zzqy), Long.valueOf(this.zzqz));
    }

    public String toString() {
        return String.format("FitnessSensorServiceRequest{%s}", new Object[]{this.zzia});
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getDataSource(), i, false);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzpt.asBinder(), false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzqy);
        SafeParcelWriter.writeLong(parcel, 4, this.zzqz);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
