package com.google.android.gms.internal.ads;

final class zzkq implements zzkl {
    private final zzos zzavw;
    private final int zzawf = this.zzavw.zzje();
    private final int zzawi = (this.zzavw.zzje() & 255);
    private int zzawj;
    private int zzawk;

    public zzkq(zzkk zzkk) {
        zzos zzos = zzkk.zzavw;
        this.zzavw = zzos;
        zzos.zzbi(12);
    }

    public final int zzgw() {
        return this.zzawf;
    }

    public final int zzgx() {
        int i = this.zzawi;
        if (i == 8) {
            return this.zzavw.readUnsignedByte();
        }
        if (i == 16) {
            return this.zzavw.readUnsignedShort();
        }
        int i2 = this.zzawj;
        this.zzawj = i2 + 1;
        if (i2 % 2 != 0) {
            return this.zzawk & 15;
        }
        int readUnsignedByte = this.zzavw.readUnsignedByte();
        this.zzawk = readUnsignedByte;
        return (readUnsignedByte & 240) >> 4;
    }

    public final boolean zzgy() {
        return false;
    }
}
