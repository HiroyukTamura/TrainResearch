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
import com.google.android.gms.internal.fitness.zzbk;
import com.google.android.gms.internal.fitness.zzbl;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

@ShowFirstParty
@SafeParcelable.Class(creator = "DataTypeReadRequestCreator")
@SafeParcelable.Reserved({4, 1000})
public final class zzt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzt> CREATOR = new zzs();
    @SafeParcelable.Field(getter = "getName", mo11969id = 1)
    private final String name;
    @SafeParcelable.Field(getter = "getCallbackBinder", mo11969id = 3, type = "android.os.IBinder")
    private final zzbl zzpj;

    @SafeParcelable.Constructor
    zzt(@SafeParcelable.Param(mo11972id = 1) String str, @SafeParcelable.Param(mo11972id = 3) IBinder iBinder) {
        this.name = str;
        this.zzpj = zzbk.zze(iBinder);
    }

    public zzt(String str, zzbl zzbl) {
        this.name = str;
        this.zzpj = zzbl;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj != this) {
            return (obj instanceof zzt) && Objects.equal(this.name, ((zzt) obj).name);
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.name);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add(AppMeasurementSdk.ConditionalUserProperty.NAME, this.name).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.name, false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.zzpj.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
