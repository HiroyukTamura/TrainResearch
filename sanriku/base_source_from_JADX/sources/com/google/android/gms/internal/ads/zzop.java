package com.google.android.gms.internal.ads;

public final class zzop {
    private byte[] data;
    private int zzbhi;
    private int zzbhj;
    private int zzbhk;

    public zzop() {
    }

    public zzop(byte[] bArr) {
        this(bArr, bArr.length);
    }

    private zzop(byte[] bArr, int i) {
        this.data = bArr;
        this.zzbhk = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0064, code lost:
        if (r1 == 8) goto L_0x0058;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzbe(int r12) {
        /*
            r11 = this;
            r0 = 0
            if (r12 != 0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = r12 / 8
            r2 = 0
            r3 = 0
        L_0x0008:
            r4 = 1
            r5 = 255(0xff, float:3.57E-43)
            r6 = 8
            if (r2 >= r1) goto L_0x0037
            int r7 = r11.zzbhj
            if (r7 == 0) goto L_0x0024
            byte[] r8 = r11.data
            int r9 = r11.zzbhi
            byte r10 = r8[r9]
            r10 = r10 & r5
            int r10 = r10 << r7
            int r9 = r9 + r4
            byte r8 = r8[r9]
            r8 = r8 & r5
            int r6 = r6 - r7
            int r6 = r8 >>> r6
            r6 = r6 | r10
            goto L_0x002a
        L_0x0024:
            byte[] r6 = r11.data
            int r7 = r11.zzbhi
            byte r6 = r6[r7]
        L_0x002a:
            int r12 = r12 + -8
            r5 = r5 & r6
            int r5 = r5 << r12
            r3 = r3 | r5
            int r5 = r11.zzbhi
            int r5 = r5 + r4
            r11.zzbhi = r5
            int r2 = r2 + 1
            goto L_0x0008
        L_0x0037:
            if (r12 <= 0) goto L_0x006b
            int r1 = r11.zzbhj
            int r1 = r1 + r12
            int r12 = 8 - r12
            int r12 = r5 >> r12
            byte r12 = (byte) r12
            byte[] r2 = r11.data
            int r7 = r11.zzbhi
            if (r1 <= r6) goto L_0x005c
            byte r8 = r2[r7]
            r8 = r8 & r5
            int r9 = r1 + -8
            int r8 = r8 << r9
            int r9 = r7 + 1
            byte r2 = r2[r9]
            r2 = r2 & r5
            int r5 = 16 - r1
            int r2 = r2 >> r5
            r2 = r2 | r8
            r12 = r12 & r2
            r12 = r12 | r3
        L_0x0058:
            int r7 = r7 + r4
            r11.zzbhi = r7
            goto L_0x0067
        L_0x005c:
            byte r2 = r2[r7]
            r2 = r2 & r5
            int r5 = 8 - r1
            int r2 = r2 >> r5
            r12 = r12 & r2
            r12 = r12 | r3
            if (r1 != r6) goto L_0x0067
            goto L_0x0058
        L_0x0067:
            r3 = r12
            int r1 = r1 % r6
            r11.zzbhj = r1
        L_0x006b:
            int r12 = r11.zzbhi
            if (r12 < 0) goto L_0x007e
            int r1 = r11.zzbhj
            if (r1 < 0) goto L_0x007e
            if (r1 >= r6) goto L_0x007e
            int r2 = r11.zzbhk
            if (r12 < r2) goto L_0x007d
            if (r12 != r2) goto L_0x007e
            if (r1 != 0) goto L_0x007e
        L_0x007d:
            r0 = 1
        L_0x007e:
            com.google.android.gms.internal.ads.zzoh.checkState(r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzop.zzbe(int):int");
    }
}
