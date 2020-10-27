package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@SafeParcelable.Class(creator = "BleDeviceCreator")
@SafeParcelable.Reserved({1000})
@Deprecated
public class BleDevice extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<BleDevice> CREATOR = new zzd();
    @SafeParcelable.Field(getter = "getName", mo11969id = 2)
    private final String name;
    @SafeParcelable.Field(getter = "getAddress", mo11969id = 1)
    private final String zzim;
    @SafeParcelable.Field(getter = "getSupportedProfiles", mo11969id = 3)
    private final List<String> zzin;
    @SafeParcelable.Field(getter = "getDataTypes", mo11969id = 4)
    private final List<DataType> zzio;

    @SafeParcelable.Constructor
    BleDevice(@SafeParcelable.Param(mo11972id = 1) String str, @SafeParcelable.Param(mo11972id = 2) String str2, @SafeParcelable.Param(mo11972id = 3) List<String> list, @SafeParcelable.Param(mo11972id = 4) List<DataType> list2) {
        this.zzim = str;
        this.name = str2;
        this.zzin = Collections.unmodifiableList(list);
        this.zzio = Collections.unmodifiableList(list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BleDevice)) {
            return false;
        }
        BleDevice bleDevice = (BleDevice) obj;
        return this.name.equals(bleDevice.name) && this.zzim.equals(bleDevice.zzim) && new HashSet(this.zzin).equals(new HashSet(bleDevice.zzin)) && new HashSet(this.zzio).equals(new HashSet(bleDevice.zzio));
    }

    public String getAddress() {
        return this.zzim;
    }

    public List<DataType> getDataTypes() {
        return this.zzio;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getSupportedProfiles() {
        return this.zzin;
    }

    public int hashCode() {
        return Objects.hashCode(this.name, this.zzim, this.zzin, this.zzio);
    }

    public String toString() {
        return Objects.toStringHelper(this).add(AppMeasurementSdk.ConditionalUserProperty.NAME, this.name).add("address", this.zzim).add("dataTypes", this.zzio).add("supportedProfiles", this.zzin).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getAddress(), false);
        SafeParcelWriter.writeString(parcel, 2, getName(), false);
        SafeParcelWriter.writeStringList(parcel, 3, getSupportedProfiles(), false);
        SafeParcelWriter.writeTypedList(parcel, 4, getDataTypes(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
