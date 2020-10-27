package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzdyk implements zzdzs {
    private static final ThreadLocal<Cipher> zzhqg = new zzdyj();
    private final SecretKeySpec zzhqh;
    private final int zzhqi;
    private final int zzhqj;

    public zzdyk(byte[] bArr, int i) throws GeneralSecurityException {
        zzdzy.zzfj(bArr.length);
        this.zzhqh = new SecretKeySpec(bArr, "AES");
        int blockSize = zzhqg.get().getBlockSize();
        this.zzhqj = blockSize;
        if (i < 12 || i > blockSize) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.zzhqi = i;
    }

    public final byte[] zzo(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.zzhqi;
        if (length <= Integer.MAX_VALUE - i) {
            byte[] bArr2 = new byte[(bArr.length + i)];
            byte[] zzfi = zzdzt.zzfi(i);
            System.arraycopy(zzfi, 0, bArr2, 0, this.zzhqi);
            int length2 = bArr.length;
            int i2 = this.zzhqi;
            Cipher cipher = zzhqg.get();
            byte[] bArr3 = new byte[this.zzhqj];
            System.arraycopy(zzfi, 0, bArr3, 0, this.zzhqi);
            cipher.init(1, this.zzhqh, new IvParameterSpec(bArr3));
            if (cipher.doFinal(bArr, 0, length2, bArr2, i2) == length2) {
                return bArr2;
            }
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
        throw new GeneralSecurityException(C0681a.m309a(43, "plaintext length can not exceed ", Integer.MAX_VALUE - this.zzhqi));
    }
}
