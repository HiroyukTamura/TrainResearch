package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ConditionalUserPropertyParcelCreator")
public final class zzw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzw> CREATOR = new zzz();
    @SafeParcelable.Field(mo11969id = 2)
    public String zza;
    @SafeParcelable.Field(mo11969id = 3)
    public String zzb;
    @SafeParcelable.Field(mo11969id = 4)
    public zzkr zzc;
    @SafeParcelable.Field(mo11969id = 5)
    public long zzd;
    @SafeParcelable.Field(mo11969id = 6)
    public boolean zze;
    @SafeParcelable.Field(mo11969id = 7)
    public String zzf;
    @SafeParcelable.Field(mo11969id = 8)
    public zzao zzg;
    @SafeParcelable.Field(mo11969id = 9)
    public long zzh;
    @SafeParcelable.Field(mo11969id = 10)
    public zzao zzi;
    @SafeParcelable.Field(mo11969id = 11)
    public long zzj;
    @SafeParcelable.Field(mo11969id = 12)
    public zzao zzk;

    zzw(zzw zzw) {
        Preconditions.checkNotNull(zzw);
        this.zza = zzw.zza;
        this.zzb = zzw.zzb;
        this.zzc = zzw.zzc;
        this.zzd = zzw.zzd;
        this.zze = zzw.zze;
        this.zzf = zzw.zzf;
        this.zzg = zzw.zzg;
        this.zzh = zzw.zzh;
        this.zzi = zzw.zzi;
        this.zzj = zzw.zzj;
        this.zzk = zzw.zzk;
    }

    @SafeParcelable.Constructor
    zzw(@SafeParcelable.Param(mo11972id = 2) String str, @SafeParcelable.Param(mo11972id = 3) String str2, @SafeParcelable.Param(mo11972id = 4) zzkr zzkr, @SafeParcelable.Param(mo11972id = 5) long j, @SafeParcelable.Param(mo11972id = 6) boolean z, @SafeParcelable.Param(mo11972id = 7) String str3, @SafeParcelable.Param(mo11972id = 8) zzao zzao, @SafeParcelable.Param(mo11972id = 9) long j2, @SafeParcelable.Param(mo11972id = 10) zzao zzao2, @SafeParcelable.Param(mo11972id = 11) long j3, @SafeParcelable.Param(mo11972id = 12) zzao zzao3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzkr;
        this.zzd = j;
        this.zze = z;
        this.zzf = str3;
        this.zzg = zzao;
        this.zzh = j2;
        this.zzi = zzao2;
        this.zzj = j3;
        this.zzk = zzao3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzc, i, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zze);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzg, i, false);
        SafeParcelWriter.writeLong(parcel, 9, this.zzh);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzi, i, false);
        SafeParcelWriter.writeLong(parcel, 11, this.zzj);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzk, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
