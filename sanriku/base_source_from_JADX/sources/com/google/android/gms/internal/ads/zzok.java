package com.google.android.gms.internal.ads;

import android.util.Pair;

public final class zzok {
    private static final byte[] zzbhb = {0, 0, 0, 1};
    private static final int[] zzbhc = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] zzbhd = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    private static int zza(zzop zzop) {
        int zzbe = zzop.zzbe(5);
        return zzbe == 31 ? zzop.zzbe(6) + 32 : zzbe;
    }

    private static int zzb(zzop zzop) {
        int zzbe = zzop.zzbe(4);
        if (zzbe == 15) {
            return zzop.zzbe(24);
        }
        zzoh.checkArgument(zzbe < 13);
        return zzbhc[zzbe];
    }

    public static byte[] zzc(byte[] bArr, int i, int i2) {
        byte[] bArr2 = zzbhb;
        byte[] bArr3 = new byte[(bArr2.length + i2)];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i, bArr3, zzbhb.length, i2);
        return bArr3;
    }

    public static Pair<Integer, Integer> zze(byte[] bArr) {
        zzop zzop = new zzop(bArr);
        int zza = zza(zzop);
        int zzb = zzb(zzop);
        int zzbe = zzop.zzbe(4);
        if (zza == 5 || zza == 29) {
            zzb = zzb(zzop);
            if (zza(zzop) == 22) {
                zzbe = zzop.zzbe(4);
            }
        }
        int i = zzbhd[zzbe];
        zzoh.checkArgument(i != -1);
        return Pair.create(Integer.valueOf(zzb), Integer.valueOf(i));
    }
}
