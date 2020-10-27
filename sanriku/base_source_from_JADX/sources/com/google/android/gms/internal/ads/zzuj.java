package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

@SafeParcelable.Class(creator = "AdRequestParcelCreator")
public final class zzuj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzuj> CREATOR = new zzul();
    @SafeParcelable.Field(mo11969id = 3)
    public final Bundle extras;
    @SafeParcelable.Field(mo11969id = 1)
    public final int versionCode;
    @SafeParcelable.Field(mo11969id = 7)
    public final int zzacq;
    @SafeParcelable.Field(mo11969id = 20)
    public final int zzacr;
    @SafeParcelable.Field(mo11969id = 21)
    @Nullable
    public final String zzacs;
    @SafeParcelable.Field(mo11969id = 8)
    public final boolean zzbli;
    @SafeParcelable.Field(mo11969id = 2)
    @Deprecated
    public final long zzceg;
    @SafeParcelable.Field(mo11969id = 4)
    @Deprecated
    public final int zzceh;
    @SafeParcelable.Field(mo11969id = 5)
    public final List<String> zzcei;
    @SafeParcelable.Field(mo11969id = 6)
    public final boolean zzcej;
    @SafeParcelable.Field(mo11969id = 9)
    public final String zzcek;
    @SafeParcelable.Field(mo11969id = 10)
    public final zzza zzcel;
    @SafeParcelable.Field(mo11969id = 12)
    public final String zzcem;
    @SafeParcelable.Field(mo11969id = 13)
    public final Bundle zzcen;
    @SafeParcelable.Field(mo11969id = 14)
    public final Bundle zzceo;
    @SafeParcelable.Field(mo11969id = 15)
    public final List<String> zzcep;
    @SafeParcelable.Field(mo11969id = 16)
    public final String zzceq;
    @SafeParcelable.Field(mo11969id = 17)
    public final String zzcer;
    @SafeParcelable.Field(mo11969id = 18)
    @Deprecated
    public final boolean zzces;
    @SafeParcelable.Field(mo11969id = 22)
    public final List<String> zzcet;
    @SafeParcelable.Field(mo11969id = 19)
    @Nullable
    public final zzud zzceu;
    @SafeParcelable.Field(mo11969id = 11)
    public final Location zzmp;

    @SafeParcelable.Constructor
    public zzuj(@SafeParcelable.Param(mo11972id = 1) int i, @SafeParcelable.Param(mo11972id = 2) long j, @SafeParcelable.Param(mo11972id = 3) Bundle bundle, @SafeParcelable.Param(mo11972id = 4) int i2, @SafeParcelable.Param(mo11972id = 5) List<String> list, @SafeParcelable.Param(mo11972id = 6) boolean z, @SafeParcelable.Param(mo11972id = 7) int i3, @SafeParcelable.Param(mo11972id = 8) boolean z2, @SafeParcelable.Param(mo11972id = 9) String str, @SafeParcelable.Param(mo11972id = 10) zzza zzza, @SafeParcelable.Param(mo11972id = 11) Location location, @SafeParcelable.Param(mo11972id = 12) String str2, @SafeParcelable.Param(mo11972id = 13) Bundle bundle2, @SafeParcelable.Param(mo11972id = 14) Bundle bundle3, @SafeParcelable.Param(mo11972id = 15) List<String> list2, @SafeParcelable.Param(mo11972id = 16) String str3, @SafeParcelable.Param(mo11972id = 17) String str4, @SafeParcelable.Param(mo11972id = 18) boolean z3, @SafeParcelable.Param(mo11972id = 19) zzud zzud, @SafeParcelable.Param(mo11972id = 20) int i4, @SafeParcelable.Param(mo11972id = 21) @Nullable String str5, @SafeParcelable.Param(mo11972id = 22) List<String> list3) {
        this.versionCode = i;
        this.zzceg = j;
        this.extras = bundle == null ? new Bundle() : bundle;
        this.zzceh = i2;
        this.zzcei = list;
        this.zzcej = z;
        this.zzacq = i3;
        this.zzbli = z2;
        this.zzcek = str;
        this.zzcel = zzza;
        this.zzmp = location;
        this.zzcem = str2;
        this.zzcen = bundle2 == null ? new Bundle() : bundle2;
        this.zzceo = bundle3;
        this.zzcep = list2;
        this.zzceq = str3;
        this.zzcer = str4;
        this.zzces = z3;
        this.zzceu = zzud;
        this.zzacr = i4;
        this.zzacs = str5;
        this.zzcet = list3 == null ? new ArrayList<>() : list3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzuj)) {
            return false;
        }
        zzuj zzuj = (zzuj) obj;
        return this.versionCode == zzuj.versionCode && this.zzceg == zzuj.zzceg && Objects.equal(this.extras, zzuj.extras) && this.zzceh == zzuj.zzceh && Objects.equal(this.zzcei, zzuj.zzcei) && this.zzcej == zzuj.zzcej && this.zzacq == zzuj.zzacq && this.zzbli == zzuj.zzbli && Objects.equal(this.zzcek, zzuj.zzcek) && Objects.equal(this.zzcel, zzuj.zzcel) && Objects.equal(this.zzmp, zzuj.zzmp) && Objects.equal(this.zzcem, zzuj.zzcem) && Objects.equal(this.zzcen, zzuj.zzcen) && Objects.equal(this.zzceo, zzuj.zzceo) && Objects.equal(this.zzcep, zzuj.zzcep) && Objects.equal(this.zzceq, zzuj.zzceq) && Objects.equal(this.zzcer, zzuj.zzcer) && this.zzces == zzuj.zzces && this.zzacr == zzuj.zzacr && Objects.equal(this.zzacs, zzuj.zzacs) && Objects.equal(this.zzcet, zzuj.zzcet);
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.versionCode), Long.valueOf(this.zzceg), this.extras, Integer.valueOf(this.zzceh), this.zzcei, Boolean.valueOf(this.zzcej), Integer.valueOf(this.zzacq), Boolean.valueOf(this.zzbli), this.zzcek, this.zzcel, this.zzmp, this.zzcem, this.zzcen, this.zzceo, this.zzcep, this.zzceq, this.zzcer, Boolean.valueOf(this.zzces), Integer.valueOf(this.zzacr), this.zzacs, this.zzcet);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeLong(parcel, 2, this.zzceg);
        SafeParcelWriter.writeBundle(parcel, 3, this.extras, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzceh);
        SafeParcelWriter.writeStringList(parcel, 5, this.zzcei, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzcej);
        SafeParcelWriter.writeInt(parcel, 7, this.zzacq);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzbli);
        SafeParcelWriter.writeString(parcel, 9, this.zzcek, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzcel, i, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzmp, i, false);
        SafeParcelWriter.writeString(parcel, 12, this.zzcem, false);
        SafeParcelWriter.writeBundle(parcel, 13, this.zzcen, false);
        SafeParcelWriter.writeBundle(parcel, 14, this.zzceo, false);
        SafeParcelWriter.writeStringList(parcel, 15, this.zzcep, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzceq, false);
        SafeParcelWriter.writeString(parcel, 17, this.zzcer, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzces);
        SafeParcelWriter.writeParcelable(parcel, 19, this.zzceu, i, false);
        SafeParcelWriter.writeInt(parcel, 20, this.zzacr);
        SafeParcelWriter.writeString(parcel, 21, this.zzacs, false);
        SafeParcelWriter.writeStringList(parcel, 22, this.zzcet, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
