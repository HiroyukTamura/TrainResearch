package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.zzad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "SessionReadResultCreator")
@SafeParcelable.Reserved({4, 1000})
public class SessionReadResult extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<SessionReadResult> CREATOR = new zzh();
    @SafeParcelable.Field(getter = "getSessions", mo11969id = 1)
    private final List<Session> zzoo;
    @SafeParcelable.Field(getter = "getStatus", mo11969id = 3)
    private final Status zzqr;
    @SafeParcelable.Field(getter = "getSessionDataSets", mo11969id = 2)
    private final List<zzad> zzqw;

    @ShowFirstParty
    @SafeParcelable.Constructor
    public SessionReadResult(@SafeParcelable.Param(mo11972id = 1) List<Session> list, @SafeParcelable.Param(mo11972id = 2) List<zzad> list2, @SafeParcelable.Param(mo11972id = 3) Status status) {
        this.zzoo = list;
        this.zzqw = Collections.unmodifiableList(list2);
        this.zzqr = status;
    }

    @ShowFirstParty
    public static SessionReadResult zze(Status status) {
        return new SessionReadResult(new ArrayList(), new ArrayList(), status);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof SessionReadResult) {
                SessionReadResult sessionReadResult = (SessionReadResult) obj;
                if (this.zzqr.equals(sessionReadResult.zzqr) && Objects.equal(this.zzoo, sessionReadResult.zzoo) && Objects.equal(this.zzqw, sessionReadResult.zzqw)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public List<DataSet> getDataSet(Session session) {
        Preconditions.checkArgument(this.zzoo.contains(session), "Attempting to read data for session %s which was not returned", session);
        ArrayList arrayList = new ArrayList();
        for (zzad next : this.zzqw) {
            if (Objects.equal(session, next.getSession())) {
                arrayList.add(next.getDataSet());
            }
        }
        return arrayList;
    }

    public List<DataSet> getDataSet(Session session, DataType dataType) {
        Preconditions.checkArgument(this.zzoo.contains(session), "Attempting to read data for session %s which was not returned", session);
        ArrayList arrayList = new ArrayList();
        for (zzad next : this.zzqw) {
            if (Objects.equal(session, next.getSession()) && dataType.equals(next.getDataSet().getDataType())) {
                arrayList.add(next.getDataSet());
            }
        }
        return arrayList;
    }

    public List<Session> getSessions() {
        return this.zzoo;
    }

    public Status getStatus() {
        return this.zzqr;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzqr, this.zzoo, this.zzqw);
    }

    public String toString() {
        return Objects.toStringHelper(this).add(NotificationCompat.CATEGORY_STATUS, this.zzqr).add("sessions", this.zzoo).add("sessionDataSets", this.zzqw).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getSessions(), false);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzqw, false);
        SafeParcelWriter.writeParcelable(parcel, 3, getStatus(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
