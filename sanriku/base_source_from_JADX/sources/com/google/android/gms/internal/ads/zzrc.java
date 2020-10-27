package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;

public final class zzrc extends zzqv {
    private MessageDigest zzbrp;

    public final byte[] zzbr(String str) {
        byte[] bArr;
        byte[] bArr2;
        String[] split = str.split(" ");
        int i = 4;
        if (split.length == 1) {
            int zzbt = zzqz.zzbt(split[0]);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(zzbt);
            bArr = allocate.array();
        } else {
            if (split.length < 5) {
                bArr2 = new byte[(split.length << 1)];
                for (int i2 = 0; i2 < split.length; i2++) {
                    int zzbt2 = zzqz.zzbt(split[i2]);
                    int i3 = (zzbt2 >> 16) ^ (65535 & zzbt2);
                    byte[] bArr3 = {(byte) i3, (byte) (i3 >> 8)};
                    int i4 = i2 << 1;
                    bArr2[i4] = bArr3[0];
                    bArr2[i4 + 1] = bArr3[1];
                }
            } else {
                bArr2 = new byte[split.length];
                for (int i5 = 0; i5 < split.length; i5++) {
                    int zzbt3 = zzqz.zzbt(split[i5]);
                    bArr2[i5] = (byte) ((zzbt3 >> 24) ^ (((zzbt3 & 255) ^ ((zzbt3 >> 8) & 255)) ^ ((zzbt3 >> 16) & 255)));
                }
            }
            bArr = bArr2;
        }
        this.zzbrp = zzmm();
        synchronized (this.mLock) {
            if (this.zzbrp == null) {
                byte[] bArr4 = new byte[0];
                return bArr4;
            }
            this.zzbrp.reset();
            this.zzbrp.update(bArr);
            byte[] digest = this.zzbrp.digest();
            if (digest.length <= 4) {
                i = digest.length;
            }
            byte[] bArr5 = new byte[i];
            System.arraycopy(digest, 0, bArr5, 0, i);
            return bArr5;
        }
    }
}
