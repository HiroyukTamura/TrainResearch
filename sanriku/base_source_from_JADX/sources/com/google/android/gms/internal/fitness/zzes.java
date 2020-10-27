package com.google.android.gms.internal.fitness;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

@SafeParcelable.Class(creator = "FitnessUnregistrationRequestCreator")
@SafeParcelable.Reserved({1000})
public final class zzes extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzes> CREATOR = new zzev();
    @SafeParcelable.Field(getter = "getDataSource", mo11969id = 1)
    private final DataSource zzia;

    @SafeParcelable.Constructor
    public zzes(@SafeParcelable.Param(mo11972id = 1) DataSource dataSource) {
        this.zzia = dataSource;
    }

    public final DataSource getDataSource() {
        return this.zzia;
    }

    public final String toString() {
        return String.format("ApplicationUnregistrationRequest{%s}", new Object[]{this.zzia});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzia, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
