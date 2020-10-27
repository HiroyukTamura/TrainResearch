package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import p009e.p010a.p011a.p012a.C0681a;

@SafeParcelable.Class(creator = "EventParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzao extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzao> CREATOR = new zzar();
    @SafeParcelable.Field(mo11969id = 2)
    public final String zza;
    @SafeParcelable.Field(mo11969id = 3)
    public final zzan zzb;
    @SafeParcelable.Field(mo11969id = 4)
    public final String zzc;
    @SafeParcelable.Field(mo11969id = 5)
    public final long zzd;

    zzao(zzao zzao, long j) {
        Preconditions.checkNotNull(zzao);
        this.zza = zzao.zza;
        this.zzb = zzao.zzb;
        this.zzc = zzao.zzc;
        this.zzd = j;
    }

    @SafeParcelable.Constructor
    public zzao(@SafeParcelable.Param(mo11972id = 2) String str, @SafeParcelable.Param(mo11972id = 3) zzan zzan, @SafeParcelable.Param(mo11972id = 4) String str2, @SafeParcelable.Param(mo11972id = 5) long j) {
        this.zza = str;
        this.zzb = zzan;
        this.zzc = str2;
        this.zzd = j;
    }

    public final String toString() {
        String str = this.zzc;
        String str2 = this.zza;
        String valueOf = String.valueOf(this.zzb);
        return C0681a.m324a(C0681a.m337b(valueOf.length() + C0681a.m336b(str2, C0681a.m336b(str, 21)), "origin=", str, ",name=", str2), ",params=", valueOf);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzb, i, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
