package com.google.android.gms.internal.ads;

import java.io.IOException;

public abstract class zzebf {
    int zzhts;
    int zzhtt;
    int zzhtu;
    zzebi zzhtv;
    private boolean zzhtw;

    private zzebf() {
        this.zzhtt = 100;
        this.zzhtu = Integer.MAX_VALUE;
        this.zzhtw = false;
    }

    static zzebf zzb(byte[] bArr, int i, int i2, boolean z) {
        zzebh zzebh = new zzebh(bArr, i, i2, z);
        try {
            zzebh.zzfu(i2);
            return zzebh;
        } catch (zzeco e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static long zzfh(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static int zzfw(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract double readDouble() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract String readString() throws IOException;

    public abstract int zzbcy() throws IOException;

    public abstract long zzbcz() throws IOException;

    public abstract long zzbda() throws IOException;

    public abstract int zzbdb() throws IOException;

    public abstract long zzbdc() throws IOException;

    public abstract int zzbdd() throws IOException;

    public abstract boolean zzbde() throws IOException;

    public abstract String zzbdf() throws IOException;

    public abstract zzeaq zzbdg() throws IOException;

    public abstract int zzbdh() throws IOException;

    public abstract int zzbdi() throws IOException;

    public abstract int zzbdj() throws IOException;

    public abstract long zzbdk() throws IOException;

    public abstract int zzbdl() throws IOException;

    public abstract long zzbdm() throws IOException;

    /* access modifiers changed from: package-private */
    public abstract long zzbdn() throws IOException;

    public abstract boolean zzbdo() throws IOException;

    public abstract int zzbdp();

    public abstract void zzfs(int i) throws zzeco;

    public abstract boolean zzft(int i) throws IOException;

    public abstract int zzfu(int i) throws zzeco;

    public abstract void zzfv(int i);
}
