package com.google.android.gms.internal.ads;

import java.io.OutputStream;
import java.util.ArrayList;

public final class zzebd extends OutputStream {
    private static final byte[] zzhtn = new byte[0];
    private byte[] buffer = new byte[128];
    private final int zzhto = 128;
    private final ArrayList<zzeaq> zzhtp = new ArrayList<>();
    private int zzhtq;
    private int zzhtr;

    zzebd(int i) {
    }

    private final synchronized int size() {
        return this.zzhtq + this.zzhtr;
    }

    private final void zzfr(int i) {
        this.zzhtp.add(new zzeba(this.buffer));
        int length = this.zzhtq + this.buffer.length;
        this.zzhtq = length;
        this.buffer = new byte[Math.max(this.zzhto, Math.max(i, length >>> 1))];
        this.zzhtr = 0;
    }

    public final String toString() {
        return String.format("<ByteString.Output@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    public final synchronized void write(int i) {
        if (this.zzhtr == this.buffer.length) {
            zzfr(1);
        }
        byte[] bArr = this.buffer;
        int i2 = this.zzhtr;
        this.zzhtr = i2 + 1;
        bArr[i2] = (byte) i;
    }

    public final synchronized void write(byte[] bArr, int i, int i2) {
        if (i2 <= this.buffer.length - this.zzhtr) {
            System.arraycopy(bArr, i, this.buffer, this.zzhtr, i2);
            this.zzhtr += i2;
            return;
        }
        int length = this.buffer.length - this.zzhtr;
        System.arraycopy(bArr, i, this.buffer, this.zzhtr, length);
        int i3 = i2 - length;
        zzfr(i3);
        System.arraycopy(bArr, i + length, this.buffer, 0, i3);
        this.zzhtr = i3;
    }

    public final synchronized zzeaq zzbce() {
        if (this.zzhtr >= this.buffer.length) {
            this.zzhtp.add(new zzeba(this.buffer));
            this.buffer = zzhtn;
        } else if (this.zzhtr > 0) {
            byte[] bArr = this.buffer;
            int i = this.zzhtr;
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i));
            this.zzhtp.add(new zzeba(bArr2));
        }
        this.zzhtq += this.zzhtr;
        this.zzhtr = 0;
        return zzeaq.zzl(this.zzhtp);
    }
}
