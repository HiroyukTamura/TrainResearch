package com.google.android.gms.internal.ads;

import java.util.Arrays;
import kotlin.UByte;

final class zzdzu {
    private static void zza(byte[] bArr, long j, int i) {
        int i2 = 0;
        while (i2 < 4) {
            bArr[i + i2] = (byte) ((int) (255 & j));
            i2++;
            j >>= 8;
        }
    }

    private static long zze(byte[] bArr, int i) {
        return ((long) (((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16))) & 4294967295L;
    }

    static byte[] zze(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        if (bArr3.length == 32) {
            long zzg = zzg(bArr3, 0, 0) & 67108863;
            int i = 2;
            long zzg2 = zzg(bArr3, 3, 2) & 67108611;
            long zzg3 = zzg(bArr3, 6, 4) & 67092735;
            long zzg4 = zzg(bArr3, 9, 6) & 66076671;
            long zzg5 = zzg(bArr3, 12, 8) & 1048575;
            long j = zzg2 * 5;
            long j2 = zzg3 * 5;
            long j3 = zzg4 * 5;
            long j4 = zzg5 * 5;
            int i2 = 17;
            byte[] bArr5 = new byte[17];
            long j5 = 0;
            long j6 = 0;
            long j7 = 0;
            long j8 = 0;
            long j9 = 0;
            int i3 = 0;
            while (i3 < bArr4.length) {
                int min = Math.min(16, bArr4.length - i3);
                System.arraycopy(bArr4, i3, bArr5, 0, min);
                bArr5[min] = 1;
                if (min != 16) {
                    Arrays.fill(bArr5, min + 1, i2, (byte) 0);
                }
                long zzg6 = j9 + zzg(bArr5, 0, 0);
                long zzg7 = j5 + zzg(bArr5, 3, i);
                long zzg8 = j6 + zzg(bArr5, 6, 4);
                long zzg9 = j7 + zzg(bArr5, 9, 6);
                long zzg10 = j8 + (zzg(bArr5, 12, 8) | ((long) (bArr5[16] << 24)));
                long j10 = (zzg10 * j) + (zzg9 * j2) + (zzg8 * j3) + (zzg7 * j4) + (zzg6 * zzg);
                long j11 = (zzg10 * j2) + (zzg9 * j3) + (zzg8 * j4) + (zzg7 * zzg) + (zzg6 * zzg2);
                long j12 = (zzg10 * j3) + (zzg9 * j4) + (zzg8 * zzg) + (zzg7 * zzg2) + (zzg6 * zzg3);
                long j13 = (zzg9 * zzg) + (zzg8 * zzg2) + (zzg7 * zzg3) + (zzg6 * zzg4);
                long j14 = zzg9 * zzg2;
                long j15 = zzg10 * zzg;
                long j16 = j11 + (j10 >> 26);
                long j17 = j12 + (j16 >> 26);
                long j18 = (zzg10 * j4) + j13 + (j17 >> 26);
                long j19 = j15 + j14 + (zzg8 * zzg3) + (zzg7 * zzg4) + (zzg6 * zzg5) + (j18 >> 26);
                long j20 = j19 >> 26;
                j8 = j19 & 67108863;
                long j21 = (j20 * 5) + (j10 & 67108863);
                i3 += 16;
                j6 = j17 & 67108863;
                j7 = j18 & 67108863;
                i2 = 17;
                i = 2;
                j9 = j21 & 67108863;
                j5 = (j16 & 67108863) + (j21 >> 26);
            }
            long j22 = j6 + (j5 >> 26);
            long j23 = j22 & 67108863;
            long j24 = j7 + (j22 >> 26);
            long j25 = j24 & 67108863;
            long j26 = j8 + (j24 >> 26);
            long j27 = j26 & 67108863;
            long j28 = ((j26 >> 26) * 5) + j9;
            long j29 = j28 >> 26;
            long j30 = j28 & 67108863;
            long j31 = (j5 & 67108863) + j29;
            long j32 = j30 + 5;
            long j33 = j32 & 67108863;
            long j34 = (j32 >> 26) + j31;
            long j35 = j23 + (j34 >> 26);
            long j36 = j25 + (j35 >> 26);
            long j37 = j36 & 67108863;
            long j38 = (j27 + (j36 >> 26)) - 67108864;
            long j39 = j38 >> 63;
            long j40 = j30 & j39;
            long j41 = j31 & j39;
            long j42 = j23 & j39;
            long j43 = j25 & j39;
            long j44 = j27 & j39;
            long j45 = j39 ^ -1;
            long j46 = j41 | (j34 & 67108863 & j45);
            long j47 = j42 | (j35 & 67108863 & j45);
            long j48 = j43 | (j37 & j45);
            long j49 = j44 | (j38 & j45);
            long zze = ((j40 | (j33 & j45) | (j46 << 26)) & 4294967295L) + zze(bArr3, 16);
            long zze2 = (((j46 >> 6) | (j47 << 20)) & 4294967295L) + zze(bArr3, 20) + (zze >> 32);
            long zze3 = (((j47 >> 12) | (j48 << 14)) & 4294967295L) + zze(bArr3, 24) + (zze2 >> 32);
            byte[] bArr6 = new byte[16];
            zza(bArr6, zze & 4294967295L, 0);
            zza(bArr6, zze2 & 4294967295L, 4);
            zza(bArr6, zze3 & 4294967295L, 8);
            zza(bArr6, ((((j48 >> 18) | (j49 << 8)) & 4294967295L) + zze(bArr3, 28) + (zze3 >> 32)) & 4294967295L, 12);
            return bArr6;
        }
        throw new IllegalArgumentException("The key length in bytes must be 32.");
    }

    private static long zzg(byte[] bArr, int i, int i2) {
        return (zze(bArr, i) >> i2) & 67108863;
    }
}
