package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.List;

public final class zzht {
    private static final int[] zzaia = {1, 2, 3, 6};
    private static final int[] zzaib = {48000, 44100, 32000};
    private static final int[] zzaic = {24000, 22050, 16000};
    private static final int[] zzaid = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] zzaie = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] zzaif = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static zzhf zza(zzos zzos, String str, String str2, zzja zzja) {
        int i = zzaib[(zzos.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = zzos.readUnsignedByte();
        int i2 = zzaid[(readUnsignedByte & 56) >> 3];
        if ((readUnsignedByte & 4) != 0) {
            i2++;
        }
        return zzhf.zza(str, "audio/ac3", (String) null, -1, -1, i2, i, (List<byte[]>) null, (zzja) null, 0, str2);
    }

    public static zzhf zzb(zzos zzos, String str, String str2, zzja zzja) {
        zzos.zzbj(2);
        int i = zzaib[(zzos.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = zzos.readUnsignedByte();
        int i2 = zzaid[(readUnsignedByte & 14) >> 1];
        if ((readUnsignedByte & 1) != 0) {
            i2++;
        }
        return zzhf.zza(str, "audio/eac3", (String) null, -1, -1, i2, i, (List<byte[]>) null, (zzja) null, 0, str2);
    }

    public static int zzfh() {
        return 1536;
    }

    public static int zzh(ByteBuffer byteBuffer) {
        int i = 6;
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            i = zzaia[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4];
        }
        return i * 256;
    }
}
