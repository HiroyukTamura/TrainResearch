package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AdSizeParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzum extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzum> CREATOR = new zzup();
    @SafeParcelable.Field(mo11969id = 3)
    public final int height;
    @SafeParcelable.Field(mo11969id = 4)
    public final int heightPixels;
    @SafeParcelable.Field(mo11969id = 6)
    public final int width;
    @SafeParcelable.Field(mo11969id = 7)
    public final int widthPixels;
    @SafeParcelable.Field(mo11969id = 2)
    public final String zzacf;
    @SafeParcelable.Field(mo11969id = 9)
    public final boolean zzbnf;
    @SafeParcelable.Field(mo11969id = 5)
    public final boolean zzcew;
    @SafeParcelable.Field(mo11969id = 8)
    public final zzum[] zzcex;
    @SafeParcelable.Field(mo11969id = 10)
    public final boolean zzcey;
    @SafeParcelable.Field(mo11969id = 11)
    public boolean zzcez;
    @SafeParcelable.Field(mo11969id = 12)
    public boolean zzcfa;
    @SafeParcelable.Field(mo11969id = 13)
    private boolean zzcfb;
    @SafeParcelable.Field(mo11969id = 14)
    public boolean zzcfc;
    @SafeParcelable.Field(mo11969id = 15)
    public boolean zzcfd;

    public zzum() {
        this("interstitial_mb", 0, 0, true, 0, 0, (zzum[]) null, false, false, false, false, false, false, false);
    }

    public zzum(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x009c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzum(android.content.Context r13, com.google.android.gms.ads.AdSize[] r14) {
        /*
            r12 = this;
            r12.<init>()
            r0 = 0
            r1 = r14[r0]
            r12.zzcew = r0
            boolean r2 = r1.isFluid()
            r12.zzcey = r2
            boolean r2 = com.google.android.gms.ads.zzb.zza(r1)
            r12.zzcfc = r2
            boolean r2 = com.google.android.gms.ads.zzb.zzb(r1)
            r12.zzcfd = r2
            boolean r3 = r12.zzcey
            if (r3 == 0) goto L_0x002f
            com.google.android.gms.ads.AdSize r2 = com.google.android.gms.ads.AdSize.BANNER
            int r2 = r2.getWidth()
            r12.width = r2
            com.google.android.gms.ads.AdSize r2 = com.google.android.gms.ads.AdSize.BANNER
            int r2 = r2.getHeight()
        L_0x002c:
            r12.height = r2
            goto L_0x0047
        L_0x002f:
            if (r2 == 0) goto L_0x003c
            int r2 = r1.getWidth()
            r12.width = r2
            int r2 = com.google.android.gms.ads.zzb.zzc(r1)
            goto L_0x002c
        L_0x003c:
            int r2 = r1.getWidth()
            r12.width = r2
            int r2 = r1.getHeight()
            goto L_0x002c
        L_0x0047:
            int r2 = r12.width
            r3 = -1
            r4 = 1
            if (r2 != r3) goto L_0x004f
            r2 = 1
            goto L_0x0050
        L_0x004f:
            r2 = 0
        L_0x0050:
            int r3 = r12.height
            r5 = -2
            if (r3 != r5) goto L_0x0057
            r3 = 1
            goto L_0x0058
        L_0x0057:
            r3 = 0
        L_0x0058:
            android.content.res.Resources r5 = r13.getResources()
            android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
            if (r2 == 0) goto L_0x009f
            com.google.android.gms.internal.ads.zzvj.zzpr()
            boolean r6 = com.google.android.gms.internal.ads.zzazm.zzbn(r13)
            if (r6 == 0) goto L_0x007f
            com.google.android.gms.internal.ads.zzvj.zzpr()
            boolean r6 = com.google.android.gms.internal.ads.zzazm.zzbo(r13)
            if (r6 == 0) goto L_0x007f
            int r6 = r5.widthPixels
            com.google.android.gms.internal.ads.zzvj.zzpr()
            int r7 = com.google.android.gms.internal.ads.zzazm.zzbp(r13)
            int r6 = r6 - r7
            goto L_0x0081
        L_0x007f:
            int r6 = r5.widthPixels
        L_0x0081:
            r12.widthPixels = r6
            int r6 = r12.widthPixels
            float r6 = (float) r6
            float r7 = r5.density
            float r6 = r6 / r7
            double r6 = (double) r6
            int r8 = (int) r6
            double r9 = (double) r8
            java.lang.Double.isNaN(r6)
            java.lang.Double.isNaN(r9)
            double r6 = r6 - r9
            r9 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            int r11 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r11 < 0) goto L_0x00ac
            int r8 = r8 + 1
            goto L_0x00ac
        L_0x009f:
            int r8 = r12.width
            com.google.android.gms.internal.ads.zzvj.zzpr()
            int r6 = r12.width
            int r6 = com.google.android.gms.internal.ads.zzazm.zza((android.util.DisplayMetrics) r5, (int) r6)
            r12.widthPixels = r6
        L_0x00ac:
            if (r3 == 0) goto L_0x00b3
            int r6 = zzd(r5)
            goto L_0x00b5
        L_0x00b3:
            int r6 = r12.height
        L_0x00b5:
            com.google.android.gms.internal.ads.zzvj.zzpr()
            int r5 = com.google.android.gms.internal.ads.zzazm.zza((android.util.DisplayMetrics) r5, (int) r6)
            r12.heightPixels = r5
            java.lang.String r5 = "_as"
            java.lang.String r7 = "x"
            r9 = 26
            if (r2 != 0) goto L_0x00f3
            if (r3 == 0) goto L_0x00c9
            goto L_0x00f3
        L_0x00c9:
            boolean r2 = r12.zzcfd
            if (r2 == 0) goto L_0x00e7
            int r1 = r12.width
            int r2 = r12.height
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r1)
            r3.append(r7)
            r3.append(r2)
            r3.append(r5)
            java.lang.String r1 = r3.toString()
            goto L_0x0108
        L_0x00e7:
            boolean r2 = r12.zzcey
            if (r2 == 0) goto L_0x00ee
            java.lang.String r1 = "320x50_mb"
            goto L_0x0108
        L_0x00ee:
            java.lang.String r1 = r1.toString()
            goto L_0x0108
        L_0x00f3:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r9)
            r1.append(r8)
            r1.append(r7)
            r1.append(r6)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
        L_0x0108:
            r12.zzacf = r1
            int r1 = r14.length
            if (r1 <= r4) goto L_0x0124
            int r1 = r14.length
            com.google.android.gms.internal.ads.zzum[] r1 = new com.google.android.gms.internal.ads.zzum[r1]
            r12.zzcex = r1
            r1 = 0
        L_0x0113:
            int r2 = r14.length
            if (r1 >= r2) goto L_0x0127
            com.google.android.gms.internal.ads.zzum[] r2 = r12.zzcex
            com.google.android.gms.internal.ads.zzum r3 = new com.google.android.gms.internal.ads.zzum
            r4 = r14[r1]
            r3.<init>((android.content.Context) r13, (com.google.android.gms.ads.AdSize) r4)
            r2[r1] = r3
            int r1 = r1 + 1
            goto L_0x0113
        L_0x0124:
            r13 = 0
            r12.zzcex = r13
        L_0x0127:
            r12.zzbnf = r0
            r12.zzcez = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzum.<init>(android.content.Context, com.google.android.gms.ads.AdSize[]):void");
    }

    @SafeParcelable.Constructor
    zzum(@SafeParcelable.Param(mo11972id = 2) String str, @SafeParcelable.Param(mo11972id = 3) int i, @SafeParcelable.Param(mo11972id = 4) int i2, @SafeParcelable.Param(mo11972id = 5) boolean z, @SafeParcelable.Param(mo11972id = 6) int i3, @SafeParcelable.Param(mo11972id = 7) int i4, @SafeParcelable.Param(mo11972id = 8) zzum[] zzumArr, @SafeParcelable.Param(mo11972id = 9) boolean z2, @SafeParcelable.Param(mo11972id = 10) boolean z3, @SafeParcelable.Param(mo11972id = 11) boolean z4, @SafeParcelable.Param(mo11972id = 12) boolean z5, @SafeParcelable.Param(mo11972id = 13) boolean z6, @SafeParcelable.Param(mo11972id = 14) boolean z7, @SafeParcelable.Param(mo11972id = 15) boolean z8) {
        this.zzacf = str;
        this.height = i;
        this.heightPixels = i2;
        this.zzcew = z;
        this.width = i3;
        this.widthPixels = i4;
        this.zzcex = zzumArr;
        this.zzbnf = z2;
        this.zzcey = z3;
        this.zzcez = z4;
        this.zzcfa = z5;
        this.zzcfb = z6;
        this.zzcfc = z7;
        this.zzcfd = z8;
    }

    public static int zzb(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int zzc(DisplayMetrics displayMetrics) {
        return (int) (((float) zzd(displayMetrics)) * displayMetrics.density);
    }

    private static int zzd(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        if (i <= 400) {
            return 32;
        }
        return i <= 720 ? 50 : 90;
    }

    public static zzum zzph() {
        return new zzum("320x50_mb", 0, 0, false, 0, 0, (zzum[]) null, true, false, false, false, false, false, false);
    }

    public static zzum zzpi() {
        return new zzum("reward_mb", 0, 0, true, 0, 0, (zzum[]) null, false, false, false, false, false, false, false);
    }

    public static zzum zzpj() {
        return new zzum("interstitial_mb", 0, 0, false, 0, 0, (zzum[]) null, false, false, false, false, true, false, false);
    }

    public static zzum zzpk() {
        return new zzum("invalid", 0, 0, false, 0, 0, (zzum[]) null, false, false, false, true, false, false, false);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzacf, false);
        SafeParcelWriter.writeInt(parcel, 3, this.height);
        SafeParcelWriter.writeInt(parcel, 4, this.heightPixels);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzcew);
        SafeParcelWriter.writeInt(parcel, 6, this.width);
        SafeParcelWriter.writeInt(parcel, 7, this.widthPixels);
        SafeParcelWriter.writeTypedArray(parcel, 8, this.zzcex, i, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzbnf);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzcey);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzcez);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzcfa);
        SafeParcelWriter.writeBoolean(parcel, 13, this.zzcfb);
        SafeParcelWriter.writeBoolean(parcel, 14, this.zzcfc);
        SafeParcelWriter.writeBoolean(parcel, 15, this.zzcfd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final AdSize zzpl() {
        return zzb.zza(this.width, this.height, this.zzacf);
    }
}
