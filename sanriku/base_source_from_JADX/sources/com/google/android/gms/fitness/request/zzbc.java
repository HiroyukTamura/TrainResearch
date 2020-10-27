package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fitness.zzck;
import com.google.android.gms.internal.fitness.zzcl;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

@ShowFirstParty
@SafeParcelable.Class(creator = "SessionStopRequestCreator")
@SafeParcelable.Reserved({4, 1000})
public final class zzbc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbc> CREATOR = new zzbb();
    @SafeParcelable.Field(getter = "getName", mo11969id = 1)
    @Nullable
    private final String name;
    @SafeParcelable.Field(getter = "getIdentifier", mo11969id = 2)
    @Nullable
    private final String zzma;
    @SafeParcelable.Field(getter = "getCallbackBinder", mo11969id = 3, type = "android.os.IBinder")
    private final zzcl zzqj;

    @SafeParcelable.Constructor
    zzbc(@SafeParcelable.Param(mo11972id = 1) String str, @SafeParcelable.Param(mo11972id = 2) String str2, @SafeParcelable.Param(mo11972id = 3) IBinder iBinder) {
        this.name = str;
        this.zzma = str2;
        this.zzqj = zzck.zzi(iBinder);
    }

    public zzbc(@Nullable String str, @Nullable String str2, zzcl zzcl) {
        this.name = str;
        this.zzma = str2;
        this.zzqj = zzcl;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj != this) {
            if (obj instanceof zzbc) {
                zzbc zzbc = (zzbc) obj;
                if (Objects.equal(this.name, zzbc.name) && Objects.equal(this.zzma, zzbc.zzma)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.name, this.zzma);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add(AppMeasurementSdk.ConditionalUserProperty.NAME, this.name).add("identifier", this.zzma).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.name, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzma, false);
        zzcl zzcl = this.zzqj;
        SafeParcelWriter.writeIBinder(parcel, 3, zzcl == null ? null : zzcl.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
