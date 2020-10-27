package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcp;

@ShowFirstParty
@SafeParcelable.Class(creator = "SubscribeRequestCreator")
@SafeParcelable.Reserved({4, 1000})
public final class zzbk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbk> CREATOR = new zzbj();
    @SafeParcelable.Field(getter = "getCallbackBinder", mo11969id = 3, type = "android.os.IBinder")
    @Nullable
    private final zzcm zzok;
    @SafeParcelable.Field(getter = "getSubscription", mo11969id = 1)
    @Nullable
    private Subscription zzqo;
    @SafeParcelable.Field(getter = "isServerOnly", mo11969id = 2)
    private final boolean zzqp;

    @SafeParcelable.Constructor
    zzbk(@SafeParcelable.Param(mo11972id = 1) Subscription subscription, @SafeParcelable.Param(mo11972id = 2) boolean z, @SafeParcelable.Param(mo11972id = 3) IBinder iBinder) {
        this.zzqo = subscription;
        this.zzqp = z;
        this.zzok = zzcp.zzj(iBinder);
    }

    public zzbk(Subscription subscription, boolean z, @Nullable zzcm zzcm) {
        this.zzqo = subscription;
        this.zzqp = false;
        this.zzok = zzcm;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("subscription", this.zzqo).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzqo, i, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzqp);
        zzcm zzcm = this.zzok;
        SafeParcelWriter.writeIBinder(parcel, 3, zzcm == null ? null : zzcm.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
