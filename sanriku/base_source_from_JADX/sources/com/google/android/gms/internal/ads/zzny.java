package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzny implements zzns {
    private final boolean zzbgf;
    private final int zzbgg;
    private final byte[] zzbgh;
    private final zznp[] zzbgi;
    private int zzbgj;
    private int zzbgk;
    private int zzbgl;
    private zznp[] zzbgm;

    public zzny(boolean z, int i) {
        this(true, 65536, 0);
    }

    private zzny(boolean z, int i, int i2) {
        zzoh.checkArgument(true);
        zzoh.checkArgument(true);
        this.zzbgf = true;
        this.zzbgg = 65536;
        this.zzbgl = 0;
        this.zzbgm = new zznp[100];
        this.zzbgh = null;
        this.zzbgi = new zznp[1];
    }

    public final synchronized void reset() {
        if (this.zzbgf) {
            zzbc(0);
        }
    }

    public final synchronized void zza(zznp zznp) {
        this.zzbgi[0] = zznp;
        zza(this.zzbgi);
    }

    public final synchronized void zza(zznp[] zznpArr) {
        boolean z;
        if (this.zzbgl + zznpArr.length >= this.zzbgm.length) {
            this.zzbgm = (zznp[]) Arrays.copyOf(this.zzbgm, Math.max(this.zzbgm.length << 1, this.zzbgl + zznpArr.length));
        }
        for (zznp zznp : zznpArr) {
            if (zznp.data != null) {
                if (zznp.data.length != this.zzbgg) {
                    z = false;
                    zzoh.checkArgument(z);
                    zznp[] zznpArr2 = this.zzbgm;
                    int i = this.zzbgl;
                    this.zzbgl = i + 1;
                    zznpArr2[i] = zznp;
                }
            }
            z = true;
            zzoh.checkArgument(z);
            zznp[] zznpArr22 = this.zzbgm;
            int i2 = this.zzbgl;
            this.zzbgl = i2 + 1;
            zznpArr22[i2] = zznp;
        }
        this.zzbgk -= zznpArr.length;
        notifyAll();
    }

    public final synchronized void zzbc(int i) {
        boolean z = i < this.zzbgj;
        this.zzbgj = i;
        if (z) {
            zzn();
        }
    }

    public final synchronized zznp zzim() {
        zznp zznp;
        this.zzbgk++;
        if (this.zzbgl > 0) {
            zznp[] zznpArr = this.zzbgm;
            int i = this.zzbgl - 1;
            this.zzbgl = i;
            zznp = zznpArr[i];
            this.zzbgm[i] = null;
        } else {
            zznp = new zznp(new byte[this.zzbgg], 0);
        }
        return zznp;
    }

    public final int zzin() {
        return this.zzbgg;
    }

    public final synchronized int zziq() {
        return this.zzbgk * this.zzbgg;
    }

    public final synchronized void zzn() {
        int max = Math.max(0, zzov.zzf(this.zzbgj, this.zzbgg) - this.zzbgk);
        if (max < this.zzbgl) {
            Arrays.fill(this.zzbgm, max, this.zzbgl, (Object) null);
            this.zzbgl = max;
        }
    }
}
