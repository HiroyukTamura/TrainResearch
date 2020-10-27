package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcp;

@ShowFirstParty
@SafeParcelable.Class(creator = "UnsubscribeRequestCreator")
@SafeParcelable.Reserved({4, 1000})
public final class zzbo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbo> CREATOR = new zzbn();
    @SafeParcelable.Field(getter = "getDataType", mo11969id = 1)
    @Nullable
    private final DataType zzhz;
    @SafeParcelable.Field(getter = "getDataSource", mo11969id = 2)
    @Nullable
    private final DataSource zzia;
    @SafeParcelable.Field(getter = "getCallbackBinder", mo11969id = 3, type = "android.os.IBinder")
    @Nullable
    private final zzcm zzok;

    @SafeParcelable.Constructor
    zzbo(@SafeParcelable.Param(mo11972id = 1) DataType dataType, @SafeParcelable.Param(mo11972id = 2) DataSource dataSource, @SafeParcelable.Param(mo11972id = 3) IBinder iBinder) {
        this(dataType, dataSource, zzcp.zzj(iBinder));
    }

    public zzbo(@Nullable DataType dataType, @Nullable DataSource dataSource, @Nullable zzcm zzcm) {
        Preconditions.checkArgument((dataType == null) == (dataSource == null) ? false : true, "Must specify exactly one of dataType and dataSource.");
        this.zzhz = dataType;
        this.zzia = dataSource;
        this.zzok = zzcm;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof zzbo) {
                zzbo zzbo = (zzbo) obj;
                if (Objects.equal(this.zzia, zzbo.zzia) && Objects.equal(this.zzhz, zzbo.zzhz)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzia, this.zzhz);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzhz, i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzia, i, false);
        zzcm zzcm = this.zzok;
        SafeParcelWriter.writeIBinder(parcel, 3, zzcm == null ? null : zzcm.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
