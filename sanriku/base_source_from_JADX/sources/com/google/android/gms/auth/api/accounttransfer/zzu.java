package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcelable;

public final class zzu implements Parcelable.Creator<zzt> {
    /* JADX WARNING: type inference failed for: r1v12, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v14, types: [android.os.Parcelable] */
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
            r4 = 0
            r4 = r1
            r6 = r4
            r7 = r6
            r8 = r7
            r5 = 0
        L_0x0011:
            int r1 = r11.dataPosition()
            if (r1 >= r0) goto L_0x005b
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r11)
            int r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            switch(r9) {
                case 1: goto L_0x004e;
                case 2: goto L_0x0048;
                case 3: goto L_0x0042;
                case 4: goto L_0x003c;
                case 5: goto L_0x0031;
                case 6: goto L_0x0026;
                default: goto L_0x0022;
            }
        L_0x0022:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r11, r1)
            goto L_0x0011
        L_0x0026:
            android.os.Parcelable$Creator<com.google.android.gms.auth.api.accounttransfer.DeviceMetaData> r8 = com.google.android.gms.auth.api.accounttransfer.DeviceMetaData.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r11, r1, r8)
            r8 = r1
            com.google.android.gms.auth.api.accounttransfer.DeviceMetaData r8 = (com.google.android.gms.auth.api.accounttransfer.DeviceMetaData) r8
            r1 = 6
            goto L_0x0053
        L_0x0031:
            android.os.Parcelable$Creator r7 = android.app.PendingIntent.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r11, r1, r7)
            r7 = r1
            android.app.PendingIntent r7 = (android.app.PendingIntent) r7
            r1 = 5
            goto L_0x0053
        L_0x003c:
            byte[] r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createByteArray(r11, r1)
            r1 = 4
            goto L_0x0053
        L_0x0042:
            int r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r11, r1)
            r1 = 3
            goto L_0x0053
        L_0x0048:
            java.lang.String r4 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r11, r1)
            r1 = 2
            goto L_0x0053
        L_0x004e:
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r11, r1)
            r1 = 1
        L_0x0053:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r2.add(r1)
            goto L_0x0011
        L_0x005b:
            int r1 = r11.dataPosition()
            if (r1 != r0) goto L_0x0068
            com.google.android.gms.auth.api.accounttransfer.zzt r11 = new com.google.android.gms.auth.api.accounttransfer.zzt
            r1 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return r11
        L_0x0068:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException r1 = new com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException
            r2 = 37
            java.lang.String r3 = "Overread allowed size end="
            java.lang.String r0 = p009e.p010a.p011a.p012a.C0681a.m309a((int) r2, (java.lang.String) r3, (int) r0)
            r1.<init>(r0, r11)
            goto L_0x0077
        L_0x0076:
            throw r1
        L_0x0077:
            goto L_0x0076
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.accounttransfer.zzu.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzt[i];
    }
}
