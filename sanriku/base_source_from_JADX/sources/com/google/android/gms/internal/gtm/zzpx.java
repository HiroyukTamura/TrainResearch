package com.google.android.gms.internal.gtm;

import p009e.p010a.p011a.p012a.C0681a;

final class zzpx extends zzqc {
    private final int zzawb;
    private final int zzawc;

    zzpx(byte[] bArr, int i, int i2) {
        super(bArr);
        zzps.zzb(i, i + i2, bArr.length);
        this.zzawb = i;
        this.zzawc = i2;
    }

    public final int size() {
        return this.zzawc;
    }

    public final byte zzak(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.zzawe[this.zzawb + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(C0681a.m309a(22, "Index < 0: ", i));
        }
        throw new ArrayIndexOutOfBoundsException(C0681a.m311a(40, "Index > length: ", i, ", ", size));
    }

    /* access modifiers changed from: package-private */
    public final byte zzal(int i) {
        return this.zzawe[this.zzawb + i];
    }

    /* access modifiers changed from: protected */
    public final int zznf() {
        return this.zzawb;
    }
}
