package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcelable;

public final class zzs implements Parcelable.Creator<zzr> {
    /* JADX WARNING: type inference failed for: r1v7, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r11) {
        /*
            r10 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r11)
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            r1 = 0
            r3 = 0
            r4 = r1
            r5 = r4
            r6 = r5
            r7 = r6
        L_0x000f:
            int r1 = r11.dataPosition()
            if (r1 >= r0) goto L_0x0055
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r11)
            int r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            r9 = 1
            if (r8 == r9) goto L_0x0049
            r9 = 2
            if (r8 == r9) goto L_0x003f
            r9 = 3
            if (r8 == r9) goto L_0x003a
            r9 = 4
            if (r8 == r9) goto L_0x0035
            r9 = 5
            if (r8 == r9) goto L_0x0030
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r11, r1)
            goto L_0x000f
        L_0x0030:
            java.lang.String r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r11, r1)
            goto L_0x004d
        L_0x0035:
            java.lang.String r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r11, r1)
            goto L_0x004d
        L_0x003a:
            java.lang.String r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r11, r1)
            goto L_0x004d
        L_0x003f:
            android.os.Parcelable$Creator<com.google.android.gms.auth.api.accounttransfer.zzt> r4 = com.google.android.gms.auth.api.accounttransfer.zzt.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r11, r1, r4)
            r4 = r1
            com.google.android.gms.auth.api.accounttransfer.zzt r4 = (com.google.android.gms.auth.api.accounttransfer.zzt) r4
            goto L_0x004d
        L_0x0049:
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r11, r1)
        L_0x004d:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
            r2.add(r1)
            goto L_0x000f
        L_0x0055:
            int r1 = r11.dataPosition()
            if (r1 != r0) goto L_0x0062
            com.google.android.gms.auth.api.accounttransfer.zzr r11 = new com.google.android.gms.auth.api.accounttransfer.zzr
            r1 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return r11
        L_0x0062:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException r1 = new com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException
            r2 = 37
            java.lang.String r3 = "Overread allowed size end="
            java.lang.String r0 = p009e.p010a.p011a.p012a.C0681a.m309a((int) r2, (java.lang.String) r3, (int) r0)
            r1.<init>(r0, r11)
            goto L_0x0071
        L_0x0070:
            throw r1
        L_0x0071:
            goto L_0x0070
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.accounttransfer.zzs.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzr[i];
    }
}
