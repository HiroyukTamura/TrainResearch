package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ShowFirstParty
@SafeParcelable.Class(creator = "ApplicationCreator")
@SafeParcelable.Reserved({2, 3, 1000})
public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new zzb();
    public static final zzc zzil = new zzc("com.google.android.gms");
    @SafeParcelable.Field(getter = "getPackageName", mo11969id = 1)
    private final String packageName;

    @SafeParcelable.Constructor
    public zzc(@SafeParcelable.Param(mo11972id = 1) String str) {
        this.packageName = (String) Preconditions.checkNotNull(str);
    }

    public static zzc zza(String str) {
        return "com.google.android.gms".equals(str) ? zzil : new zzc(str);
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzc)) {
            return false;
        }
        return this.packageName.equals(((zzc) obj).packageName);
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final int hashCode() {
        return this.packageName.hashCode();
    }

    public final String toString() {
        return String.format("Application{%s}", new Object[]{this.packageName});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.packageName, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
