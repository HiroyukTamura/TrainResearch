package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.IInterface;
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
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcp;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "StartBleScanRequestCreator")
@SafeParcelable.Reserved({5, 1000})
@Deprecated
public class StartBleScanRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StartBleScanRequest> CREATOR = new zzbg();
    @SafeParcelable.Field(getter = "getDataTypes", mo11969id = 1)
    private final List<DataType> zzio;
    @SafeParcelable.Field(getter = "getCallbackBinder", mo11969id = 4, type = "android.os.IBinder")
    @Nullable
    private final zzcm zzok;
    @SafeParcelable.Field(getter = "getBleScanCallbackBinder", mo11969id = 2, type = "android.os.IBinder")
    @Nullable
    private final zzaf zzqk;
    @SafeParcelable.Field(getter = "getTimeoutSecs", mo11969id = 3)
    private final int zzql;
    @Nullable
    private final BleScanCallback zzqm;

    public static class Builder {
        private DataType[] zzph = new DataType[0];
        private int zzql = 10;
        private BleScanCallback zzqn;

        public StartBleScanRequest build() {
            Preconditions.checkState(this.zzqn != null, "Must set BleScanCallback");
            return new StartBleScanRequest((List) ArrayUtils.toArrayList(this.zzph), this.zzqn, this.zzql);
        }

        public Builder setBleScanCallback(BleScanCallback bleScanCallback) {
            this.zzqn = bleScanCallback;
            return this;
        }

        public Builder setDataTypes(DataType... dataTypeArr) {
            this.zzph = dataTypeArr;
            return this;
        }

        public Builder setTimeoutSecs(int i) {
            boolean z = true;
            Preconditions.checkArgument(i > 0, "Stop time must be greater than zero");
            if (i > 60) {
                z = false;
            }
            Preconditions.checkArgument(z, "Stop time must be less than 1 minute");
            this.zzql = i;
            return this;
        }
    }

    @SafeParcelable.Constructor
    StartBleScanRequest(@SafeParcelable.Param(mo11972id = 1) List<DataType> list, @SafeParcelable.Param(mo11972id = 2) IBinder iBinder, @SafeParcelable.Param(mo11972id = 3) int i, @SafeParcelable.Param(mo11972id = 4) IBinder iBinder2) {
        zzaf zzaf;
        this.zzio = list;
        if (iBinder == null) {
            zzaf = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.request.IBleScanCallback");
            zzaf = queryLocalInterface instanceof zzaf ? (zzaf) queryLocalInterface : new zzah(iBinder);
        }
        this.zzqk = zzaf;
        this.zzql = i;
        this.zzok = zzcp.zzj(iBinder2);
        this.zzqm = null;
    }

    private StartBleScanRequest(List<DataType> list, BleScanCallback bleScanCallback, int i) {
        this.zzio = list;
        this.zzqk = null;
        this.zzql = i;
        this.zzok = null;
        this.zzqm = bleScanCallback;
    }

    public StartBleScanRequest(List<DataType> list, @Nullable zzaf zzaf, int i, @Nullable zzcm zzcm) {
        this.zzio = list;
        this.zzqk = zzaf;
        this.zzql = i;
        this.zzok = zzcm;
        this.zzqm = null;
    }

    public List<DataType> getDataTypes() {
        return Collections.unmodifiableList(this.zzio);
    }

    public int getTimeoutSecs() {
        return this.zzql;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("dataTypes", this.zzio).add("timeoutSecs", Integer.valueOf(this.zzql)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getDataTypes(), false);
        zzaf zzaf = this.zzqk;
        IBinder iBinder = null;
        SafeParcelWriter.writeIBinder(parcel, 2, zzaf == null ? null : zzaf.asBinder(), false);
        SafeParcelWriter.writeInt(parcel, 3, getTimeoutSecs());
        zzcm zzcm = this.zzok;
        if (zzcm != null) {
            iBinder = zzcm.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 4, iBinder, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Nullable
    public final BleScanCallback zzad() {
        return this.zzqm;
    }
}
