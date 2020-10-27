package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

public final class zzox {
    private final int height;
    private final int width;
    public final List<byte[]> zzagk;
    public final int zzart;
    public final float zzbhm;

    private zzox(List<byte[]> list, int i, int i2, int i3, float f) {
        this.zzagk = list;
        this.zzart = i;
        this.width = i2;
        this.height = i3;
        this.zzbhm = f;
    }

    public static zzox zzf(zzos zzos) throws zzhi {
        float f;
        int i;
        int i2;
        try {
            zzos.zzbj(4);
            int readUnsignedByte = (zzos.readUnsignedByte() & 3) + 1;
            if (readUnsignedByte != 3) {
                ArrayList arrayList = new ArrayList();
                int readUnsignedByte2 = zzos.readUnsignedByte() & 31;
                for (int i3 = 0; i3 < readUnsignedByte2; i3++) {
                    arrayList.add(zzg(zzos));
                }
                int readUnsignedByte3 = zzos.readUnsignedByte();
                for (int i4 = 0; i4 < readUnsignedByte3; i4++) {
                    arrayList.add(zzg(zzos));
                }
                if (readUnsignedByte2 > 0) {
                    zzoq zzd = zzon.zzd((byte[]) arrayList.get(0), readUnsignedByte, ((byte[]) arrayList.get(0)).length);
                    int i5 = zzd.width;
                    int i6 = zzd.height;
                    f = zzd.zzbhm;
                    i2 = i5;
                    i = i6;
                } else {
                    i2 = -1;
                    i = -1;
                    f = 1.0f;
                }
                return new zzox(arrayList, readUnsignedByte, i2, i, f);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new zzhi("Error parsing AVC config", e);
        }
    }

    private static byte[] zzg(zzos zzos) {
        int readUnsignedShort = zzos.readUnsignedShort();
        int position = zzos.getPosition();
        zzos.zzbj(readUnsignedShort);
        return zzok.zzc(zzos.data, position, readUnsignedShort);
    }
}
