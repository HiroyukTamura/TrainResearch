package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

final class zzim implements zzhv {
    private int zzags = -1;
    private ByteBuffer zzakn;
    private int zzalk = -1;
    private int[] zzall;
    private boolean zzalm;
    private int[] zzaln;
    private ByteBuffer zzalo;
    private boolean zzalp;

    public zzim() {
        ByteBuffer byteBuffer = zzhv.zzaig;
        this.zzalo = byteBuffer;
        this.zzakn = byteBuffer;
    }

    public final void flush() {
        this.zzakn = zzhv.zzaig;
        this.zzalp = false;
    }

    public final boolean isActive() {
        return this.zzalm;
    }

    public final void reset() {
        flush();
        this.zzalo = zzhv.zzaig;
        this.zzags = -1;
        this.zzalk = -1;
        this.zzaln = null;
        this.zzalm = false;
    }

    public final void zzb(int[] iArr) {
        this.zzall = iArr;
    }

    public final boolean zzb(int i, int i2, int i3) throws zzhu {
        boolean z = !Arrays.equals(this.zzall, this.zzaln);
        int[] iArr = this.zzall;
        this.zzaln = iArr;
        if (iArr == null) {
            this.zzalm = false;
            return z;
        } else if (i3 != 2) {
            throw new zzhu(i, i2, i3);
        } else if (!z && this.zzalk == i && this.zzags == i2) {
            return false;
        } else {
            this.zzalk = i;
            this.zzags = i2;
            this.zzalm = i2 != this.zzaln.length;
            int i4 = 0;
            while (true) {
                int[] iArr2 = this.zzaln;
                if (i4 >= iArr2.length) {
                    return true;
                }
                int i5 = iArr2[i4];
                if (i5 < i2) {
                    this.zzalm = (i5 != i4) | this.zzalm;
                    i4++;
                } else {
                    throw new zzhu(i, i2, i3);
                }
            }
        }
    }

    public final boolean zzfd() {
        return this.zzalp && this.zzakn == zzhv.zzaig;
    }

    public final int zzfi() {
        int[] iArr = this.zzaln;
        return iArr == null ? this.zzags : iArr.length;
    }

    public final int zzfj() {
        return 2;
    }

    public final void zzfk() {
        this.zzalp = true;
    }

    public final ByteBuffer zzfl() {
        ByteBuffer byteBuffer = this.zzakn;
        this.zzakn = zzhv.zzaig;
        return byteBuffer;
    }

    public final void zzi(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = (((limit - position) / (this.zzags * 2)) * this.zzaln.length) << 1;
        if (this.zzalo.capacity() < length) {
            this.zzalo = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.zzalo.clear();
        }
        while (position < limit) {
            for (int i : this.zzaln) {
                this.zzalo.putShort(byteBuffer.getShort((i * 2) + position));
            }
            position += this.zzags << 1;
        }
        byteBuffer.position(limit);
        this.zzalo.flip();
        this.zzakn = this.zzalo;
    }
}
