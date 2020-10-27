package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "VersionInfoParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzazz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzazz> CREATOR = new zzbac();
    @SafeParcelable.Field(mo11969id = 2)
    public String zzbnd;
    @SafeParcelable.Field(mo11969id = 3)
    public int zzdzn;
    @SafeParcelable.Field(mo11969id = 4)
    public int zzdzo;
    @SafeParcelable.Field(mo11969id = 5)
    public boolean zzdzp;
    @SafeParcelable.Field(mo11969id = 6)
    private boolean zzdzq;

    public zzazz(int i, int i2, boolean z) {
        this(i, i2, z, false, false);
    }

    public zzazz(int i, int i2, boolean z, boolean z2) {
        this(i, i2, true, false, false);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzazz(int r8, int r9, boolean r10, boolean r11, boolean r12) {
        /*
            r7 = this;
            if (r10 == 0) goto L_0x0005
            java.lang.String r11 = "0"
            goto L_0x0007
        L_0x0005:
            java.lang.String r11 = "1"
        L_0x0007:
            int r12 = r11.length()
            int r12 = r12 + 36
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r12)
            java.lang.String r12 = "afma-sdk-a-v"
            r0.append(r12)
            r0.append(r8)
            java.lang.String r12 = "."
            r0.append(r12)
            r0.append(r9)
            java.lang.String r2 = p009e.p010a.p011a.p012a.C0681a.m324a((java.lang.StringBuilder) r0, (java.lang.String) r12, (java.lang.String) r11)
            r6 = 0
            r1 = r7
            r3 = r8
            r4 = r9
            r5 = r10
            r1.<init>((java.lang.String) r2, (int) r3, (int) r4, (boolean) r5, (boolean) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzazz.<init>(int, int, boolean, boolean, boolean):void");
    }

    @SafeParcelable.Constructor
    zzazz(@SafeParcelable.Param(mo11972id = 2) String str, @SafeParcelable.Param(mo11972id = 3) int i, @SafeParcelable.Param(mo11972id = 4) int i2, @SafeParcelable.Param(mo11972id = 5) boolean z, @SafeParcelable.Param(mo11972id = 6) boolean z2) {
        this.zzbnd = str;
        this.zzdzn = i;
        this.zzdzo = i2;
        this.zzdzp = z;
        this.zzdzq = z2;
    }

    public static zzazz zzyi() {
        return new zzazz(12451009, 12451009, true);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzbnd, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzdzn);
        SafeParcelWriter.writeInt(parcel, 4, this.zzdzo);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzdzp);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzdzq);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
