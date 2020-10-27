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
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "ListSubscriptionsResultCreator")
@SafeParcelable.Reserved({3, 1000})
@Deprecated
public class ListSubscriptionsResult extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<ListSubscriptionsResult> CREATOR = new zzg();
    @SafeParcelable.Field(getter = "getStatus", mo11969id = 2)
    private final Status zzqr;
    @SafeParcelable.Field(getter = "getSubscriptions", mo11969id = 1)
    private final List<Subscription> zzqv;

    @ShowFirstParty
    @SafeParcelable.Constructor
    public ListSubscriptionsResult(@SafeParcelable.Param(mo11972id = 1) List<Subscription> list, @SafeParcelable.Param(mo11972id = 2) Status status) {
        this.zzqv = list;
        this.zzqr = status;
    }

    @ShowFirstParty
    public static ListSubscriptionsResult zzd(Status status) {
        return new ListSubscriptionsResult(Collections.emptyList(), status);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof ListSubscriptionsResult) {
                ListSubscriptionsResult listSubscriptionsResult = (ListSubscriptionsResult) obj;
                if (this.zzqr.equals(listSubscriptionsResult.zzqr) && Objects.equal(this.zzqv, listSubscriptionsResult.zzqv)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public Status getStatus() {
        return this.zzqr;
    }

    public List<Subscription> getSubscriptions() {
        return this.zzqv;
    }

    public List<Subscription> getSubscriptions(DataType dataType) {
        ArrayList arrayList = new ArrayList();
        for (Subscription next : this.zzqv) {
            if (dataType.equals(next.zzu())) {
                arrayList.add(next);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public int hashCode() {
        return Objects.hashCode(this.zzqr, this.zzqv);
    }

    public String toString() {
        return Objects.toStringHelper(this).add(NotificationCompat.CATEGORY_STATUS, this.zzqr).add("subscriptions", this.zzqv).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getSubscriptions(), false);
        SafeParcelWriter.writeParcelable(parcel, 2, getStatus(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
