package com.google.android.gms.internal.fitness;

import p009e.p010a.p011a.p012a.C0681a;

final class zzfi extends zzfp {
    private final int zzrm;
    private final int zzrn;

    zzfi(byte[] bArr, int i, int i2) {
        super(bArr);
        zzff.zzb(i, i + i2, bArr.length);
        this.zzrm = i;
        this.zzrn = i2;
    }

    public final int size() {
        return this.zzrn;
    }

    /* access modifiers changed from: protected */
    public final int zzas() {
        return this.zzrm;
    }

    public final byte zzh(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.zzrp[this.zzrm + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(C0681a.m309a(22, "Index < 0: ", i));
        }
        throw new ArrayIndexOutOfBoundsException(C0681a.m311a(40, "Index > length: ", i, ", ", size));
    }

    /* access modifiers changed from: package-private */
    public final byte zzi(int i) {
        return this.zzrp[this.zzrm + i];
    }
}
