package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

public final class zzdzf implements zzdsb {
    private final zzdzs zzhrk;
    private final zzdss zzhrl;
    private final int zzhrm;

    public zzdzf(zzdzs zzdzs, zzdss zzdss, int i) {
        this.zzhrk = zzdzs;
        this.zzhrl = zzdss;
        this.zzhrm = i;
    }

    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] zzo = this.zzhrk.zzo(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] copyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8);
        return zzdys.zza(zzo, this.zzhrl.zzm(zzdys.zza(bArr2, zzo, copyOf)));
    }
}
