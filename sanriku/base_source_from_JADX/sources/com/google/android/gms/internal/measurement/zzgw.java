package com.google.android.gms.internal.measurement;

import p009e.p010a.p011a.p012a.C0681a;

final class zzgw extends zzhd {
    private final int zzc;
    private final int zzd;

    zzgw(byte[] bArr, int i, int i2) {
        super(bArr);
        zzgt.zzb(i, i + i2, bArr.length);
        this.zzc = i;
        this.zzd = i2;
    }

    public final byte zza(int i) {
        int zza = zza();
        if (((zza - (i + 1)) | i) >= 0) {
            return this.zzb[this.zzc + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(C0681a.m309a(22, "Index < 0: ", i));
        }
        throw new ArrayIndexOutOfBoundsException(C0681a.m311a(40, "Index > length: ", i, ", ", zza));
    }

    public final int zza() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final byte zzb(int i) {
        return this.zzb[this.zzc + i];
    }

    /* access modifiers changed from: protected */
    public final int zze() {
        return this.zzc;
    }
}
