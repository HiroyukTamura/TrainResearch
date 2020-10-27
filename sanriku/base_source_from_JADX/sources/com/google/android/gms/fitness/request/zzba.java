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
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcp;
import java.util.concurrent.TimeUnit;

@ShowFirstParty
@SafeParcelable.Class(creator = "SessionStartRequestCreator")
@SafeParcelable.Reserved({3, 1000})
public final class zzba extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzba> CREATOR = new zzaz();
    @SafeParcelable.Field(getter = "getSession", mo11969id = 1)
    private final Session zzii;
    @SafeParcelable.Field(getter = "getCallbackBinder", mo11969id = 2, type = "android.os.IBinder")
    private final zzcm zzok;

    @SafeParcelable.Constructor
    zzba(@SafeParcelable.Param(mo11972id = 1) Session session, @SafeParcelable.Param(mo11972id = 2) IBinder iBinder) {
        this.zzii = session;
        this.zzok = zzcp.zzj(iBinder);
    }

    public zzba(Session session, zzcm zzcm) {
        Preconditions.checkArgument(session.getStartTime(TimeUnit.MILLISECONDS) <= System.currentTimeMillis(), "Cannot start a session in the future");
        Preconditions.checkArgument(session.isOngoing(), "Cannot start a session which has already ended");
        this.zzii = session;
        this.zzok = zzcm;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj != this) {
            return (obj instanceof zzba) && Objects.equal(this.zzii, ((zzba) obj).zzii);
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzii);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("session", this.zzii).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzii, i, false);
        zzcm zzcm = this.zzok;
        SafeParcelWriter.writeIBinder(parcel, 2, zzcm == null ? null : zzcm.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
