package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "PoolConfigurationCreator")
public final class zzdir extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdir> CREATOR = new zzdiw();
    private final zzdiu[] zzgwq;
    private final int[] zzgwr;
    private final int[] zzgws;
    @SafeParcelable.Field(getter = "getFormatInt", mo11969id = 1)
    private final int zzgwt;
    public final zzdiu zzgwu;
    @SafeParcelable.Field(mo11969id = 2)
    public final int zzgwv;
    @SafeParcelable.Field(mo11969id = 3)
    public final int zzgww;
    @SafeParcelable.Field(mo11969id = 4)
    public final int zzgwx;
    @SafeParcelable.Field(mo11969id = 5)
    public final String zzgwy;
    @SafeParcelable.Field(getter = "getPoolDiscardStrategyInt", mo11969id = 6)
    private final int zzgwz;
    public final int zzgxa;
    @SafeParcelable.Field(getter = "getPrecacheStartTriggerInt", mo11969id = 7)
    private final int zzgxb;
    private final int zzgxc;
    public final Context zzvf;

    @SafeParcelable.Constructor
    public zzdir(@SafeParcelable.Param(mo11972id = 1) int i, @SafeParcelable.Param(mo11972id = 2) int i2, @SafeParcelable.Param(mo11972id = 3) int i3, @SafeParcelable.Param(mo11972id = 4) int i4, @SafeParcelable.Param(mo11972id = 5) String str, @SafeParcelable.Param(mo11972id = 6) int i5, @SafeParcelable.Param(mo11972id = 7) int i6) {
        this.zzgwq = zzdiu.values();
        this.zzgwr = zzdit.zzatb();
        int[] zzatc = zzdit.zzatc();
        this.zzgws = zzatc;
        this.zzvf = null;
        this.zzgwt = i;
        this.zzgwu = this.zzgwq[i];
        this.zzgwv = i2;
        this.zzgww = i3;
        this.zzgwx = i4;
        this.zzgwy = str;
        this.zzgwz = i5;
        this.zzgxa = this.zzgwr[i5];
        this.zzgxb = i6;
        this.zzgxc = zzatc[i6];
    }

    private zzdir(Context context, zzdiu zzdiu, int i, int i2, int i3, String str, String str2, String str3) {
        this.zzgwq = zzdiu.values();
        this.zzgwr = zzdit.zzatb();
        this.zzgws = zzdit.zzatc();
        this.zzvf = context;
        this.zzgwt = zzdiu.ordinal();
        this.zzgwu = zzdiu;
        this.zzgwv = i;
        this.zzgww = i2;
        this.zzgwx = i3;
        this.zzgwy = str;
        int i4 = "oldest".equals(str2) ? zzdit.zzgxf : ("lru".equals(str2) || !"lfu".equals(str2)) ? zzdit.zzgxg : zzdit.zzgxh;
        this.zzgxa = i4;
        this.zzgwz = i4 - 1;
        "onAdClosed".equals(str3);
        int i5 = zzdit.zzgxj;
        this.zzgxc = i5;
        this.zzgxb = i5 - 1;
    }

    public static zzdir zza(zzdiu zzdiu, Context context) {
        if (zzdiu == zzdiu.Rewarded) {
            return new zzdir(context, zzdiu, ((Integer) zzvj.zzpv().zzd(zzzz.zzctg)).intValue(), ((Integer) zzvj.zzpv().zzd(zzzz.zzctm)).intValue(), ((Integer) zzvj.zzpv().zzd(zzzz.zzcto)).intValue(), (String) zzvj.zzpv().zzd(zzzz.zzctq), (String) zzvj.zzpv().zzd(zzzz.zzcti), (String) zzvj.zzpv().zzd(zzzz.zzctk));
        } else if (zzdiu == zzdiu.Interstitial) {
            return new zzdir(context, zzdiu, ((Integer) zzvj.zzpv().zzd(zzzz.zzcth)).intValue(), ((Integer) zzvj.zzpv().zzd(zzzz.zzctn)).intValue(), ((Integer) zzvj.zzpv().zzd(zzzz.zzctp)).intValue(), (String) zzvj.zzpv().zzd(zzzz.zzctr), (String) zzvj.zzpv().zzd(zzzz.zzctj), (String) zzvj.zzpv().zzd(zzzz.zzctl));
        } else if (zzdiu != zzdiu.AppOpen) {
            return null;
        } else {
            return new zzdir(context, zzdiu, ((Integer) zzvj.zzpv().zzd(zzzz.zzctu)).intValue(), ((Integer) zzvj.zzpv().zzd(zzzz.zzctw)).intValue(), ((Integer) zzvj.zzpv().zzd(zzzz.zzctx)).intValue(), (String) zzvj.zzpv().zzd(zzzz.zzcts), (String) zzvj.zzpv().zzd(zzzz.zzctt), (String) zzvj.zzpv().zzd(zzzz.zzctv));
        }
    }

    public static boolean zzasz() {
        return ((Boolean) zzvj.zzpv().zzd(zzzz.zzctf)).booleanValue();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzgwt);
        SafeParcelWriter.writeInt(parcel, 2, this.zzgwv);
        SafeParcelWriter.writeInt(parcel, 3, this.zzgww);
        SafeParcelWriter.writeInt(parcel, 4, this.zzgwx);
        SafeParcelWriter.writeString(parcel, 5, this.zzgwy, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzgwz);
        SafeParcelWriter.writeInt(parcel, 7, this.zzgxb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
