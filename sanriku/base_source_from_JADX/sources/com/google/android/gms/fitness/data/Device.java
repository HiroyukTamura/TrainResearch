package com.google.android.gms.fitness.data;

import android.content.Context;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fitness.zzj;

@SafeParcelable.Class(creator = "DeviceCreator")
@SafeParcelable.Reserved({3, 1000})
public final class Device extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Device> CREATOR = new zzo();
    public static final int TYPE_CHEST_STRAP = 4;
    public static final int TYPE_HEAD_MOUNTED = 6;
    public static final int TYPE_PHONE = 1;
    public static final int TYPE_SCALE = 5;
    public static final int TYPE_TABLET = 2;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_WATCH = 3;
    @SafeParcelable.Field(getter = "getType", mo11969id = 5)
    private final int type;
    @SafeParcelable.Field(getter = "getManufacturer", mo11969id = 1)
    private final String zzkd;
    @SafeParcelable.Field(getter = "getModel", mo11969id = 2)
    private final String zzke;
    @SafeParcelable.Field(getter = "getUid", mo11969id = 4)
    private final String zzkf;
    @SafeParcelable.Field(getter = "getPlatformType", mo11969id = 6)
    private final int zzkg;

    public Device(String str, String str2, String str3, int i) {
        this(str, str2, str3, i, 0);
    }

    @ShowFirstParty
    @SafeParcelable.Constructor
    public Device(@SafeParcelable.Param(mo11972id = 1) String str, @SafeParcelable.Param(mo11972id = 2) String str2, @SafeParcelable.Param(mo11972id = 4) String str3, @SafeParcelable.Param(mo11972id = 5) int i, @SafeParcelable.Param(mo11972id = 6) int i2) {
        this.zzkd = (String) Preconditions.checkNotNull(str);
        this.zzke = (String) Preconditions.checkNotNull(str2);
        if (str3 != null) {
            this.zzkf = str3;
            this.type = i;
            this.zzkg = i2;
            return;
        }
        throw new IllegalStateException("Device UID is null.");
    }

    public static Device getLocalDevice(Context context) {
        int zza = zzj.zza(context);
        return new Device(Build.MANUFACTURER, Build.MODEL, Settings.Secure.getString(context.getContentResolver(), "android_id"), zza, 2);
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Device)) {
            return false;
        }
        Device device = (Device) obj;
        return Objects.equal(this.zzkd, device.zzkd) && Objects.equal(this.zzke, device.zzke) && Objects.equal(this.zzkf, device.zzkf) && this.type == device.type && this.zzkg == device.zzkg;
    }

    public final String getManufacturer() {
        return this.zzkd;
    }

    public final String getModel() {
        return this.zzke;
    }

    /* access modifiers changed from: package-private */
    public final String getStreamIdentifier() {
        return String.format("%s:%s:%s", new Object[]{this.zzkd, this.zzke, this.zzkf});
    }

    public final int getType() {
        return this.type;
    }

    public final String getUid() {
        return this.zzkf;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzkd, this.zzke, this.zzkf, Integer.valueOf(this.type));
    }

    public final String toString() {
        return String.format("Device{%s:%s:%s}", new Object[]{getStreamIdentifier(), Integer.valueOf(this.type), Integer.valueOf(this.zzkg)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getManufacturer(), false);
        SafeParcelWriter.writeString(parcel, 2, getModel(), false);
        SafeParcelWriter.writeString(parcel, 4, getUid(), false);
        SafeParcelWriter.writeInt(parcel, 5, getType());
        SafeParcelWriter.writeInt(parcel, 6, this.zzkg);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
