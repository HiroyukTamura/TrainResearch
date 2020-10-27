package com.google.android.gms.internal.ads;

import kotlin.UByte;

public final class zzeah {
    private final byte[] zzhsr = new byte[256];
    private int zzhss;
    private int zzhst;

    public zzeah(byte[] bArr) {
        for (int i = 0; i < 256; i++) {
            this.zzhsr[i] = (byte) i;
        }
        byte b = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            byte[] bArr2 = this.zzhsr;
            b = (b + bArr2[i2] + bArr[i2 % bArr.length]) & UByte.MAX_VALUE;
            byte b2 = bArr2[i2];
            bArr2[i2] = bArr2[b];
            bArr2[b] = b2;
        }
        this.zzhss = 0;
        this.zzhst = 0;
    }

    public final void zzt(byte[] bArr) {
        int i = this.zzhss;
        int i2 = this.zzhst;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            byte[] bArr2 = this.zzhsr;
            i2 = (i2 + bArr2[i]) & 255;
            byte b = bArr2[i];
            bArr2[i] = bArr2[i2];
            bArr2[i2] = b;
            bArr[i3] = (byte) (bArr2[(bArr2[i] + bArr2[i2]) & 255] ^ bArr[i3]);
        }
        this.zzhss = i;
        this.zzhst = i2;
    }
}
