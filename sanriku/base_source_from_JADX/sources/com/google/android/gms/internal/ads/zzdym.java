package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

public final class zzdym implements zzdsb {
    private static final ThreadLocal<Cipher> zzhqk = new zzdyl();
    private static final ThreadLocal<Cipher> zzhql = new zzdyo();
    private final SecretKeySpec zzhqh;
    private final byte[] zzhqm;
    private final byte[] zzhqn;
    private final int zzhqo;

    public zzdym(byte[] bArr, int i) throws GeneralSecurityException {
        if (i == 12 || i == 16) {
            this.zzhqo = i;
            zzdzy.zzfj(bArr.length);
            this.zzhqh = new SecretKeySpec(bArr, "AES");
            Cipher cipher = zzhqk.get();
            cipher.init(1, this.zzhqh);
            byte[] zzp = zzp(cipher.doFinal(new byte[16]));
            this.zzhqm = zzp;
            this.zzhqn = zzp(zzp);
            return;
        }
        throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
    }

    private final byte[] zza(Cipher cipher, int i, byte[] bArr, int i2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bArr2;
        byte[] bArr3 = new byte[16];
        bArr3[15] = (byte) i;
        if (i3 == 0) {
            return cipher.doFinal(zzd(bArr3, this.zzhqm));
        }
        byte[] doFinal = cipher.doFinal(bArr3);
        int i4 = 0;
        while (i3 - i4 > 16) {
            for (int i5 = 0; i5 < 16; i5++) {
                doFinal[i5] = (byte) (doFinal[i5] ^ bArr[(i2 + i4) + i5]);
            }
            doFinal = cipher.doFinal(doFinal);
            i4 += 16;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i4 + i2, i2 + i3);
        if (copyOfRange.length == 16) {
            bArr2 = zzd(copyOfRange, this.zzhqm);
        } else {
            byte[] copyOf = Arrays.copyOf(this.zzhqn, 16);
            for (int i6 = 0; i6 < copyOfRange.length; i6++) {
                copyOf[i6] = (byte) (copyOf[i6] ^ copyOfRange[i6]);
            }
            copyOf[copyOfRange.length] = (byte) (copyOf[copyOfRange.length] ^ ByteCompanionObject.MIN_VALUE);
            bArr2 = copyOf;
        }
        return cipher.doFinal(zzd(doFinal, bArr2));
    }

    private static byte[] zzd(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    private static byte[] zzp(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        int i2 = 0;
        while (i2 < 15) {
            int i3 = i2 + 1;
            bArr2[i2] = (byte) ((bArr[i2] << 1) ^ ((bArr[i3] & UByte.MAX_VALUE) >>> 7));
            i2 = i3;
        }
        int i4 = bArr[15] << 1;
        if ((bArr[0] & ByteCompanionObject.MIN_VALUE) != 0) {
            i = 135;
        }
        bArr2[15] = (byte) (i4 ^ i);
        return bArr2;
    }

    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = bArr;
        int length = bArr3.length;
        int i = this.zzhqo;
        if (length <= (Integer.MAX_VALUE - i) - 16) {
            byte[] bArr4 = new byte[(bArr3.length + i + 16)];
            byte[] zzfi = zzdzt.zzfi(i);
            System.arraycopy(zzfi, 0, bArr4, 0, this.zzhqo);
            Cipher cipher = zzhqk.get();
            cipher.init(1, this.zzhqh);
            byte[] zza = zza(cipher, 0, zzfi, 0, zzfi.length);
            byte[] bArr5 = bArr2 == null ? new byte[0] : bArr2;
            byte[] zza2 = zza(cipher, 1, bArr5, 0, bArr5.length);
            Cipher cipher2 = zzhql.get();
            cipher2.init(1, this.zzhqh, new IvParameterSpec(zza));
            cipher2.doFinal(bArr, 0, bArr3.length, bArr4, this.zzhqo);
            byte[] zza3 = zza(cipher, 2, bArr4, this.zzhqo, bArr3.length);
            int length2 = bArr3.length + this.zzhqo;
            for (int i2 = 0; i2 < 16; i2++) {
                bArr4[length2 + i2] = (byte) ((zza2[i2] ^ zza[i2]) ^ zza3[i2]);
            }
            return bArr4;
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
