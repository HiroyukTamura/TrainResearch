package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

public final class zzpd {
    public final List<byte[]> zzagk;
    public final int zzart;

    private zzpd(List<byte[]> list, int i) {
        this.zzagk = list;
        this.zzart = i;
    }

    public static zzpd zzh(zzos zzos) throws zzhi {
        try {
            zzos.zzbj(21);
            int readUnsignedByte = zzos.readUnsignedByte() & 3;
            int readUnsignedByte2 = zzos.readUnsignedByte();
            int position = zzos.getPosition();
            int i = 0;
            for (int i2 = 0; i2 < readUnsignedByte2; i2++) {
                zzos.zzbj(1);
                int readUnsignedShort = zzos.readUnsignedShort();
                for (int i3 = 0; i3 < readUnsignedShort; i3++) {
                    int readUnsignedShort2 = zzos.readUnsignedShort();
                    i += readUnsignedShort2 + 4;
                    zzos.zzbj(readUnsignedShort2);
                }
            }
            zzos.zzbi(position);
            byte[] bArr = new byte[i];
            int i4 = 0;
            for (int i5 = 0; i5 < readUnsignedByte2; i5++) {
                zzos.zzbj(1);
                int readUnsignedShort3 = zzos.readUnsignedShort();
                for (int i6 = 0; i6 < readUnsignedShort3; i6++) {
                    int readUnsignedShort4 = zzos.readUnsignedShort();
                    System.arraycopy(zzon.zzbhb, 0, bArr, i4, zzon.zzbhb.length);
                    int length = i4 + zzon.zzbhb.length;
                    System.arraycopy(zzos.data, zzos.getPosition(), bArr, length, readUnsignedShort4);
                    i4 = length + readUnsignedShort4;
                    zzos.zzbj(readUnsignedShort4);
                }
            }
            return new zzpd(i == 0 ? null : Collections.singletonList(bArr), readUnsignedByte + 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new zzhi("Error parsing HEVC config", e);
        }
    }
}
