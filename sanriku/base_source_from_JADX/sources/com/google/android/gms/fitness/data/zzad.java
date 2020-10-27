package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SessionDataSetCreator")
@SafeParcelable.Reserved({1000})
public final class zzad extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzad> CREATOR = new zzaf();
    @SafeParcelable.Field(getter = "getSession", mo11969id = 1)
    private final Session zzii;
    @SafeParcelable.Field(getter = "getDataSet", mo11969id = 2)
    private final DataSet zzjd;

    @SafeParcelable.Constructor
    public zzad(@SafeParcelable.Param(mo11972id = 1) Session session, @SafeParcelable.Param(mo11972id = 2) DataSet dataSet) {
        this.zzii = session;
        this.zzjd = dataSet;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzad)) {
            return false;
        }
        zzad zzad = (zzad) obj;
        return Objects.equal(this.zzii, zzad.zzii) && Objects.equal(this.zzjd, zzad.zzjd);
    }

    public final DataSet getDataSet() {
        return this.zzjd;
    }

    public final Session getSession() {
        return this.zzii;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzii, this.zzjd);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("session", this.zzii).add("dataSet", this.zzjd).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzii, i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzjd, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
