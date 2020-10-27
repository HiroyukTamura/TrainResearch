package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import kotlin.jvm.internal.LongCompanionObject;
import p009e.p010a.p011a.p012a.C0681a;

@SafeParcelable.Class(creator = "DeviceOrientationRequestCreator")
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new zzk();
    @SafeParcelable.Field(defaultValueUnchecked = "DeviceOrientationRequest.DEFAULT_SHOULD_USE_MAG", mo11969id = 1)
    private boolean zzt;
    @SafeParcelable.Field(defaultValueUnchecked = "DeviceOrientationRequest.DEFAULT_MINIMUM_SAMPLING_PERIOD_MS", mo11969id = 2)
    private long zzu;
    @SafeParcelable.Field(defaultValueUnchecked = "DeviceOrientationRequest.DEFAULT_SMALLEST_ANGLE_CHANGE_RADIANS", mo11969id = 3)
    private float zzv;
    @SafeParcelable.Field(defaultValueUnchecked = "DeviceOrientationRequest.DEFAULT_EXPIRE_AT_MS", mo11969id = 4)
    private long zzw;
    @SafeParcelable.Field(defaultValueUnchecked = "DeviceOrientationRequest.DEFAULT_NUM_UPDATES", mo11969id = 5)
    private int zzx;

    public zzj() {
        this(true, 50, 0.0f, LongCompanionObject.MAX_VALUE, Integer.MAX_VALUE);
    }

    @SafeParcelable.Constructor
    zzj(@SafeParcelable.Param(mo11972id = 1) boolean z, @SafeParcelable.Param(mo11972id = 2) long j, @SafeParcelable.Param(mo11972id = 3) float f, @SafeParcelable.Param(mo11972id = 4) long j2, @SafeParcelable.Param(mo11972id = 5) int i) {
        this.zzt = z;
        this.zzu = j;
        this.zzv = f;
        this.zzw = j2;
        this.zzx = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzj)) {
            return false;
        }
        zzj zzj = (zzj) obj;
        return this.zzt == zzj.zzt && this.zzu == zzj.zzu && Float.compare(this.zzv, zzj.zzv) == 0 && this.zzw == zzj.zzw && this.zzx == zzj.zzx;
    }

    public final int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.zzt), Long.valueOf(this.zzu), Float.valueOf(this.zzv), Long.valueOf(this.zzw), Integer.valueOf(this.zzx));
    }

    public final String toString() {
        StringBuilder a = C0681a.m330a("DeviceOrientationRequest[mShouldUseMag=");
        a.append(this.zzt);
        a.append(" mMinimumSamplingPeriodMs=");
        a.append(this.zzu);
        a.append(" mSmallestAngleChangeRadians=");
        a.append(this.zzv);
        long j = this.zzw;
        if (j != LongCompanionObject.MAX_VALUE) {
            a.append(" expireIn=");
            a.append(j - SystemClock.elapsedRealtime());
            a.append("ms");
        }
        if (this.zzx != Integer.MAX_VALUE) {
            a.append(" num=");
            a.append(this.zzx);
        }
        a.append(']');
        return a.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zzt);
        SafeParcelWriter.writeLong(parcel, 2, this.zzu);
        SafeParcelWriter.writeFloat(parcel, 3, this.zzv);
        SafeParcelWriter.writeLong(parcel, 4, this.zzw);
        SafeParcelWriter.writeInt(parcel, 5, this.zzx);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
