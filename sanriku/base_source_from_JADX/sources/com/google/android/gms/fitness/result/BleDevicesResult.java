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
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "BleDevicesResultCreator")
@SafeParcelable.Reserved({1000})
@Deprecated
public class BleDevicesResult extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<BleDevicesResult> CREATOR = new zza();
    @SafeParcelable.Field(getter = "getClaimedBleDevices", mo11969id = 1)
    private final List<BleDevice> zzqq;
    @SafeParcelable.Field(getter = "getStatus", mo11969id = 2)
    private final Status zzqr;

    @ShowFirstParty
    @SafeParcelable.Constructor
    public BleDevicesResult(@SafeParcelable.Param(mo11972id = 1) List<BleDevice> list, @SafeParcelable.Param(mo11972id = 2) Status status) {
        this.zzqq = Collections.unmodifiableList(list);
        this.zzqr = status;
    }

    @ShowFirstParty
    public static BleDevicesResult zzb(Status status) {
        return new BleDevicesResult(Collections.emptyList(), status);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof BleDevicesResult) {
                BleDevicesResult bleDevicesResult = (BleDevicesResult) obj;
                if (this.zzqr.equals(bleDevicesResult.zzqr) && Objects.equal(this.zzqq, bleDevicesResult.zzqq)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public List<BleDevice> getClaimedBleDevices() {
        return this.zzqq;
    }

    public List<BleDevice> getClaimedBleDevices(DataType dataType) {
        ArrayList arrayList = new ArrayList();
        for (BleDevice next : this.zzqq) {
            if (next.getDataTypes().contains(dataType)) {
                arrayList.add(next);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Status getStatus() {
        return this.zzqr;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzqr, this.zzqq);
    }

    public String toString() {
        return Objects.toStringHelper(this).add(NotificationCompat.CATEGORY_STATUS, this.zzqr).add("bleDevices", this.zzqq).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getClaimedBleDevices(), false);
        SafeParcelWriter.writeParcelable(parcel, 2, getStatus(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
