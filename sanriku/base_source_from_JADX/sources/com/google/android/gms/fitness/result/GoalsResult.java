package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Goal;
import java.util.List;

@SafeParcelable.Class(creator = "GoalsResultCreator")
@SafeParcelable.Reserved({1000})
@Deprecated
public class GoalsResult extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<GoalsResult> CREATOR = new zzf();
    @SafeParcelable.Field(getter = "getStatus", mo11969id = 1)
    private final Status zzqr;
    @SafeParcelable.Field(getter = "getGoals", mo11969id = 2)
    private final List<Goal> zzqu;

    @ShowFirstParty
    @SafeParcelable.Constructor
    public GoalsResult(@SafeParcelable.Param(mo11972id = 1) Status status, @SafeParcelable.Param(mo11972id = 2) List<Goal> list) {
        this.zzqr = status;
        this.zzqu = list;
    }

    public List<Goal> getGoals() {
        return this.zzqu;
    }

    public Status getStatus() {
        return this.zzqr;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getStatus(), i, false);
        SafeParcelWriter.writeTypedList(parcel, 2, getGoals(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
