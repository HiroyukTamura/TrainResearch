package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcp;

@ShowFirstParty
@SafeParcelable.Class(creator = "SessionUnregistrationRequestCreator")
@SafeParcelable.Reserved({3, 1000})
public final class zzbe extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbe> CREATOR = new zzbd();
    @SafeParcelable.Field(getter = "getCallbackBinder", mo11969id = 2, type = "android.os.IBinder")
    private final zzcm zzok;
    @SafeParcelable.Field(getter = "getIntent", mo11969id = 1)
    private final PendingIntent zzpk;

    @SafeParcelable.Constructor
    zzbe(@SafeParcelable.Param(mo11972id = 1) PendingIntent pendingIntent, @SafeParcelable.Param(mo11972id = 2) IBinder iBinder) {
        this.zzpk = pendingIntent;
        this.zzok = zzcp.zzj(iBinder);
    }

    public zzbe(PendingIntent pendingIntent, zzcm zzcm) {
        this.zzpk = pendingIntent;
        this.zzok = zzcm;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof zzbe) && Objects.equal(this.zzpk, ((zzbe) obj).zzpk);
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzpk);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add(BaseGmsClient.KEY_PENDING_INTENT, this.zzpk).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzpk, i, false);
        zzcm zzcm = this.zzok;
        SafeParcelWriter.writeIBinder(parcel, 2, zzcm == null ? null : zzcm.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
