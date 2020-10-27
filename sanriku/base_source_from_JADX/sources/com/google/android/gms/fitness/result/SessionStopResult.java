package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Session;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "SessionStopResultCreator")
@SafeParcelable.Reserved({4, 1000})
public class SessionStopResult extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<SessionStopResult> CREATOR = new zzi();
    @SafeParcelable.Field(getter = "getSessions", mo11969id = 3)
    private final List<Session> zzoo;
    @SafeParcelable.Field(getter = "getStatus", mo11969id = 2)
    private final Status zzqr;

    @ShowFirstParty
    @SafeParcelable.Constructor
    public SessionStopResult(@SafeParcelable.Param(mo11972id = 2) Status status, @SafeParcelable.Param(mo11972id = 3) List<Session> list) {
        this.zzqr = status;
        this.zzoo = Collections.unmodifiableList(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof SessionStopResult) {
                SessionStopResult sessionStopResult = (SessionStopResult) obj;
                if (this.zzqr.equals(sessionStopResult.zzqr) && Objects.equal(this.zzoo, sessionStopResult.zzoo)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public List<Session> getSessions() {
        return this.zzoo;
    }

    public Status getStatus() {
        return this.zzqr;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzqr, this.zzoo);
    }

    public String toString() {
        return Objects.toStringHelper(this).add(NotificationCompat.CATEGORY_STATUS, this.zzqr).add("sessions", this.zzoo).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getStatus(), i, false);
        SafeParcelWriter.writeTypedList(parcel, 3, getSessions(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
