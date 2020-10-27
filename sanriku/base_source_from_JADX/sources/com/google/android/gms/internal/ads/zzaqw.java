package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "AdResponseParcelCreator")
public final class zzaqw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaqw> CREATOR = new zzaqv();
    @SafeParcelable.Field(mo11969id = 5)
    private final int errorCode;
    @SafeParcelable.Field(mo11969id = 12)
    private final int orientation;
    @SafeParcelable.Field(mo11969id = 1)
    private final int versionCode;
    @SafeParcelable.Field(mo11969id = 37)
    @Nullable
    private final zzaqy zzblw;
    @SafeParcelable.Field(mo11969id = 49)
    private final boolean zzbmg;
    @SafeParcelable.Field(mo11969id = 53)
    private final boolean zzbmh;
    @SafeParcelable.Field(mo11969id = 23)
    private final boolean zzbnf;
    @SafeParcelable.Field(mo11969id = 31)
    private final boolean zzcey;
    @SafeParcelable.Field(mo11969id = 32)
    private final boolean zzcez;
    @SafeParcelable.Field(mo11969id = 4)
    private final List<String> zzdeu;
    @SafeParcelable.Field(mo11969id = 6)
    private final List<String> zzdev;
    @SafeParcelable.Field(mo11969id = 52)
    private final List<String> zzdew;
    @SafeParcelable.Field(mo11969id = 40)
    private final List<String> zzdey;
    @SafeParcelable.Field(mo11969id = 42)
    private final boolean zzdez;
    @SafeParcelable.Field(mo11969id = 11)
    private final long zzdfb;
    @SafeParcelable.Field(mo11969id = 2)
    private final String zzdku;
    @SafeParcelable.Field(mo11969id = 24)
    private final boolean zzdme;
    @SafeParcelable.Field(mo11969id = 38)
    private final boolean zzdmr;
    @SafeParcelable.Field(mo11969id = 39)
    @Nullable
    private String zzdms;
    @SafeParcelable.Field(mo11969id = 47)
    private final boolean zzdne;
    @SafeParcelable.Field(mo11969id = 3)
    private String zzdnr;
    @SafeParcelable.Field(mo11969id = 7)
    private final long zzdns;
    @SafeParcelable.Field(mo11969id = 8)
    private final boolean zzdnt;
    @SafeParcelable.Field(mo11969id = 9)
    private final long zzdnu;
    @SafeParcelable.Field(mo11969id = 10)
    private final List<String> zzdnv;
    @SafeParcelable.Field(mo11969id = 13)
    private final String zzdnw;
    @SafeParcelable.Field(mo11969id = 14)
    private final long zzdnx;
    @SafeParcelable.Field(mo11969id = 15)
    private final String zzdny;
    @SafeParcelable.Field(mo11969id = 18)
    private final boolean zzdnz;
    @SafeParcelable.Field(mo11969id = 19)
    private final String zzdoa;
    @SafeParcelable.Field(mo11969id = 21)
    private final String zzdob;
    @SafeParcelable.Field(mo11969id = 22)
    private final boolean zzdoc;
    @SafeParcelable.Field(mo11969id = 25)
    private final boolean zzdod;
    @SafeParcelable.Field(mo11969id = 26)
    private final boolean zzdoe;
    @SafeParcelable.Field(mo11969id = 28)
    private zzari zzdof;
    @SafeParcelable.Field(mo11969id = 29)
    private String zzdog;
    @SafeParcelable.Field(mo11969id = 30)
    private final String zzdoh;
    @SafeParcelable.Field(mo11969id = 33)
    @Nullable
    private final zzatc zzdoi;
    @SafeParcelable.Field(mo11969id = 34)
    @Nullable
    private final List<String> zzdoj;
    @SafeParcelable.Field(mo11969id = 35)
    @Nullable
    private final List<String> zzdok;
    @SafeParcelable.Field(mo11969id = 36)
    private final boolean zzdol;
    @SafeParcelable.Field(mo11969id = 43)
    @Nullable
    private final String zzdom;
    @SafeParcelable.Field(mo11969id = 44)
    @Nullable
    private final zzaum zzdon;
    @SafeParcelable.Field(mo11969id = 45)
    @Nullable
    private final String zzdoo;
    @SafeParcelable.Field(mo11969id = 46)
    private final boolean zzdop;
    @SafeParcelable.Field(mo11969id = 48)
    private Bundle zzdoq;
    @SafeParcelable.Field(mo11969id = 50)
    private final int zzdor;
    @SafeParcelable.Field(mo11969id = 51)
    private final boolean zzdos;
    @SafeParcelable.Field(mo11969id = 54)
    @Nullable
    private final String zzdot;
    @SafeParcelable.Field(mo11969id = 55)
    @Nullable
    private String zzdou;
    @SafeParcelable.Field(mo11969id = 56)
    private boolean zzdov;
    @SafeParcelable.Field(mo11969id = 57)
    private boolean zzdow;

    @SafeParcelable.Constructor
    zzaqw(@SafeParcelable.Param(mo11972id = 1) int i, @SafeParcelable.Param(mo11972id = 2) String str, @SafeParcelable.Param(mo11972id = 3) String str2, @SafeParcelable.Param(mo11972id = 4) List<String> list, @SafeParcelable.Param(mo11972id = 5) int i2, @SafeParcelable.Param(mo11972id = 6) List<String> list2, @SafeParcelable.Param(mo11972id = 7) long j, @SafeParcelable.Param(mo11972id = 8) boolean z, @SafeParcelable.Param(mo11972id = 9) long j2, @SafeParcelable.Param(mo11972id = 10) List<String> list3, @SafeParcelable.Param(mo11972id = 11) long j3, @SafeParcelable.Param(mo11972id = 12) int i3, @SafeParcelable.Param(mo11972id = 13) String str3, @SafeParcelable.Param(mo11972id = 14) long j4, @SafeParcelable.Param(mo11972id = 15) String str4, @SafeParcelable.Param(mo11972id = 18) boolean z2, @SafeParcelable.Param(mo11972id = 19) String str5, @SafeParcelable.Param(mo11972id = 21) String str6, @SafeParcelable.Param(mo11972id = 22) boolean z3, @SafeParcelable.Param(mo11972id = 23) boolean z4, @SafeParcelable.Param(mo11972id = 24) boolean z5, @SafeParcelable.Param(mo11972id = 25) boolean z6, @SafeParcelable.Param(mo11972id = 26) boolean z7, @SafeParcelable.Param(mo11972id = 28) zzari zzari, @SafeParcelable.Param(mo11972id = 29) String str7, @SafeParcelable.Param(mo11972id = 30) String str8, @SafeParcelable.Param(mo11972id = 31) boolean z8, @SafeParcelable.Param(mo11972id = 32) boolean z9, @SafeParcelable.Param(mo11972id = 33) zzatc zzatc, @SafeParcelable.Param(mo11972id = 34) List<String> list4, @SafeParcelable.Param(mo11972id = 35) List<String> list5, @SafeParcelable.Param(mo11972id = 36) boolean z10, @SafeParcelable.Param(mo11972id = 37) zzaqy zzaqy, @SafeParcelable.Param(mo11972id = 38) boolean z11, @SafeParcelable.Param(mo11972id = 39) String str9, @SafeParcelable.Param(mo11972id = 40) List<String> list6, @SafeParcelable.Param(mo11972id = 42) boolean z12, @SafeParcelable.Param(mo11972id = 43) String str10, @SafeParcelable.Param(mo11972id = 44) zzaum zzaum, @SafeParcelable.Param(mo11972id = 45) String str11, @SafeParcelable.Param(mo11972id = 46) boolean z13, @SafeParcelable.Param(mo11972id = 47) boolean z14, @SafeParcelable.Param(mo11972id = 48) Bundle bundle, @SafeParcelable.Param(mo11972id = 49) boolean z15, @SafeParcelable.Param(mo11972id = 50) int i4, @SafeParcelable.Param(mo11972id = 51) boolean z16, @SafeParcelable.Param(mo11972id = 52) List<String> list7, @SafeParcelable.Param(mo11972id = 53) boolean z17, @SafeParcelable.Param(mo11972id = 54) String str12, @SafeParcelable.Param(mo11972id = 55) @Nullable String str13, @SafeParcelable.Param(mo11972id = 56) boolean z18, @SafeParcelable.Param(mo11972id = 57) boolean z19) {
        zzarl zzarl;
        zzari zzari2 = zzari;
        this.versionCode = i;
        this.zzdku = str;
        this.zzdnr = str2;
        List<String> list8 = null;
        this.zzdeu = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i2;
        this.zzdev = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.zzdns = j;
        this.zzdnt = z;
        this.zzdnu = j2;
        this.zzdnv = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.zzdfb = j3;
        this.orientation = i3;
        this.zzdnw = str3;
        this.zzdnx = j4;
        this.zzdny = str4;
        this.zzdnz = z2;
        this.zzdoa = str5;
        this.zzdob = str6;
        this.zzdoc = z3;
        this.zzbnf = z4;
        this.zzdme = z5;
        this.zzdod = z6;
        this.zzdop = z13;
        this.zzdoe = z7;
        this.zzdof = zzari2;
        this.zzdog = str7;
        this.zzdoh = str8;
        if (this.zzdnr == null && zzari2 != null && (zzarl = (zzarl) zzari2.zza(zzarl.CREATOR)) != null && !TextUtils.isEmpty(zzarl.zzdpj)) {
            this.zzdnr = zzarl.zzdpj;
        }
        this.zzcey = z8;
        this.zzcez = z9;
        this.zzdoi = zzatc;
        this.zzdoj = list4;
        this.zzdok = list5;
        this.zzdol = z10;
        this.zzblw = zzaqy;
        this.zzdmr = z11;
        this.zzdms = str9;
        this.zzdey = list6;
        this.zzdez = z12;
        this.zzdom = str10;
        this.zzdon = zzaum;
        this.zzdoo = str11;
        this.zzdne = z14;
        this.zzdoq = bundle;
        this.zzbmg = z15;
        this.zzdor = i4;
        this.zzdos = z16;
        this.zzdew = list7 != null ? Collections.unmodifiableList(list7) : list8;
        this.zzbmh = z17;
        this.zzdot = str12;
        this.zzdou = str13;
        this.zzdov = z18;
        this.zzdow = z19;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeString(parcel, 2, this.zzdku, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzdnr, false);
        SafeParcelWriter.writeStringList(parcel, 4, this.zzdeu, false);
        SafeParcelWriter.writeInt(parcel, 5, this.errorCode);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzdev, false);
        SafeParcelWriter.writeLong(parcel, 7, this.zzdns);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdnt);
        SafeParcelWriter.writeLong(parcel, 9, this.zzdnu);
        SafeParcelWriter.writeStringList(parcel, 10, this.zzdnv, false);
        SafeParcelWriter.writeLong(parcel, 11, this.zzdfb);
        SafeParcelWriter.writeInt(parcel, 12, this.orientation);
        SafeParcelWriter.writeString(parcel, 13, this.zzdnw, false);
        SafeParcelWriter.writeLong(parcel, 14, this.zzdnx);
        SafeParcelWriter.writeString(parcel, 15, this.zzdny, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzdnz);
        SafeParcelWriter.writeString(parcel, 19, this.zzdoa, false);
        SafeParcelWriter.writeString(parcel, 21, this.zzdob, false);
        SafeParcelWriter.writeBoolean(parcel, 22, this.zzdoc);
        SafeParcelWriter.writeBoolean(parcel, 23, this.zzbnf);
        SafeParcelWriter.writeBoolean(parcel, 24, this.zzdme);
        SafeParcelWriter.writeBoolean(parcel, 25, this.zzdod);
        SafeParcelWriter.writeBoolean(parcel, 26, this.zzdoe);
        SafeParcelWriter.writeParcelable(parcel, 28, this.zzdof, i, false);
        SafeParcelWriter.writeString(parcel, 29, this.zzdog, false);
        SafeParcelWriter.writeString(parcel, 30, this.zzdoh, false);
        SafeParcelWriter.writeBoolean(parcel, 31, this.zzcey);
        SafeParcelWriter.writeBoolean(parcel, 32, this.zzcez);
        SafeParcelWriter.writeParcelable(parcel, 33, this.zzdoi, i, false);
        SafeParcelWriter.writeStringList(parcel, 34, this.zzdoj, false);
        SafeParcelWriter.writeStringList(parcel, 35, this.zzdok, false);
        SafeParcelWriter.writeBoolean(parcel, 36, this.zzdol);
        SafeParcelWriter.writeParcelable(parcel, 37, this.zzblw, i, false);
        SafeParcelWriter.writeBoolean(parcel, 38, this.zzdmr);
        SafeParcelWriter.writeString(parcel, 39, this.zzdms, false);
        SafeParcelWriter.writeStringList(parcel, 40, this.zzdey, false);
        SafeParcelWriter.writeBoolean(parcel, 42, this.zzdez);
        SafeParcelWriter.writeString(parcel, 43, this.zzdom, false);
        SafeParcelWriter.writeParcelable(parcel, 44, this.zzdon, i, false);
        SafeParcelWriter.writeString(parcel, 45, this.zzdoo, false);
        SafeParcelWriter.writeBoolean(parcel, 46, this.zzdop);
        SafeParcelWriter.writeBoolean(parcel, 47, this.zzdne);
        SafeParcelWriter.writeBundle(parcel, 48, this.zzdoq, false);
        SafeParcelWriter.writeBoolean(parcel, 49, this.zzbmg);
        SafeParcelWriter.writeInt(parcel, 50, this.zzdor);
        SafeParcelWriter.writeBoolean(parcel, 51, this.zzdos);
        SafeParcelWriter.writeStringList(parcel, 52, this.zzdew, false);
        SafeParcelWriter.writeBoolean(parcel, 53, this.zzbmh);
        SafeParcelWriter.writeString(parcel, 54, this.zzdot, false);
        SafeParcelWriter.writeString(parcel, 55, this.zzdou, false);
        SafeParcelWriter.writeBoolean(parcel, 56, this.zzdov);
        SafeParcelWriter.writeBoolean(parcel, 57, this.zzdow);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
