package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.zzt;
import com.google.android.gms.fitness.data.zzu;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcp;

@ShowFirstParty
@SafeParcelable.Class(creator = "SensorUnregistrationRequestCreator")
@SafeParcelable.Reserved({4, 1000})
public final class zzas extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzas> CREATOR = new zzar();
    @SafeParcelable.Field(getter = "getCallbackBinder", mo11969id = 3, type = "android.os.IBinder")
    private final zzcm zzok;
    @SafeParcelable.Field(getter = "getIntent", mo11969id = 2)
    private final PendingIntent zzpk;
    @SafeParcelable.Field(getter = "getListenerBinder", mo11969id = 1, type = "android.os.IBinder")
    private final zzu zzpt;

    @SafeParcelable.Constructor
    zzas(@SafeParcelable.Param(mo11972id = 1) IBinder iBinder, @SafeParcelable.Param(mo11972id = 2) PendingIntent pendingIntent, @SafeParcelable.Param(mo11972id = 3) IBinder iBinder2) {
        this.zzpt = iBinder == null ? null : zzt.zza(iBinder);
        this.zzpk = pendingIntent;
        this.zzok = zzcp.zzj(iBinder2);
    }

    public zzas(@Nullable zzu zzu, @Nullable PendingIntent pendingIntent, zzcm zzcm) {
        this.zzpt = zzu;
        this.zzpk = pendingIntent;
        this.zzok = zzcm;
    }

    public final String toString() {
        return String.format("SensorUnregistrationRequest{%s}", new Object[]{this.zzpt});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzu zzu = this.zzpt;
        IBinder iBinder = null;
        SafeParcelWriter.writeIBinder(parcel, 1, zzu == null ? null : zzu.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzpk, i, false);
        zzcm zzcm = this.zzok;
        if (zzcm != null) {
            iBinder = zzcm.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 3, iBinder, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
