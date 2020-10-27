package com.google.android.gms.internal.ads;

import android.util.Log;

final class zzhb {
    public final int index;
    private final zzhk[] zzads;
    private final zzno zzadt;
    private final zzhn[] zzaep;
    private final zzhj zzaeq;
    private final zzmk zzaex;
    public int zzafl;
    public long zzafm;
    public final zzmi zzafp;
    public final Object zzafq;
    public final zzmt[] zzafr;
    private final boolean[] zzafs;
    public final long zzaft;
    public boolean zzafu;
    public boolean zzafv;
    public boolean zzafw;
    public zzhb zzafx;
    public zznq zzafy;
    private zznq zzafz;

    public zzhb(zzhk[] zzhkArr, zzhn[] zzhnArr, long j, zzno zzno, zzhj zzhj, zzmk zzmk, Object obj, int i, int i2, boolean z, long j2) {
        this.zzads = zzhkArr;
        this.zzaep = zzhnArr;
        this.zzaft = j;
        this.zzadt = zzno;
        this.zzaeq = zzhj;
        this.zzaex = zzmk;
        this.zzafq = zzoh.checkNotNull(obj);
        this.index = i;
        this.zzafl = i2;
        this.zzafu = z;
        this.zzafm = j2;
        this.zzafr = new zzmt[zzhkArr.length];
        this.zzafs = new boolean[zzhkArr.length];
        this.zzafp = zzmk.zza(i2, zzhj.zzfc());
    }

    public final void release() {
        try {
            this.zzaex.zzb(this.zzafp);
        } catch (RuntimeException e) {
            Log.e("ExoPlayerImplInternal", "Period release failed.", e);
        }
    }

    public final long zza(long j, boolean z, boolean[] zArr) {
        zznl zznl = this.zzafy.zzbfh;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= zznl.length) {
                break;
            }
            boolean[] zArr2 = this.zzafs;
            if (z || !this.zzafy.zza(this.zzafz, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        long zza = this.zzafp.zza(zznl.zzil(), this.zzafs, this.zzafr, zArr, j);
        this.zzafz = this.zzafy;
        this.zzafw = false;
        int i2 = 0;
        while (true) {
            zzmt[] zzmtArr = this.zzafr;
            if (i2 < zzmtArr.length) {
                if (zzmtArr[i2] != null) {
                    zzoh.checkState(zznl.zzba(i2) != null);
                    this.zzafw = true;
                } else {
                    zzoh.checkState(zznl.zzba(i2) == null);
                }
                i2++;
            } else {
                this.zzaeq.zza(this.zzads, this.zzafy.zzbfg, zznl);
                return zza;
            }
        }
    }

    public final long zzb(long j, boolean z) {
        return zza(j, false, new boolean[this.zzads.length]);
    }

    public final void zzc(int i, boolean z) {
        this.zzafl = i;
        this.zzafu = z;
    }

    public final long zzev() {
        return this.zzaft - this.zzafm;
    }

    public final boolean zzew() {
        if (this.zzafv) {
            return !this.zzafw || this.zzafp.zzhq() == Long.MIN_VALUE;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzex() throws com.google.android.gms.internal.ads.zzgq {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzno r0 = r6.zzadt
            com.google.android.gms.internal.ads.zzhn[] r1 = r6.zzaep
            com.google.android.gms.internal.ads.zzmi r2 = r6.zzafp
            com.google.android.gms.internal.ads.zzna r2 = r2.zzho()
            com.google.android.gms.internal.ads.zznq r0 = r0.zza(r1, r2)
            com.google.android.gms.internal.ads.zznq r1 = r6.zzafz
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0016
        L_0x0014:
            r1 = 0
            goto L_0x0028
        L_0x0016:
            r4 = 0
        L_0x0017:
            com.google.android.gms.internal.ads.zznl r5 = r0.zzbfh
            int r5 = r5.length
            if (r4 >= r5) goto L_0x0027
            boolean r5 = r0.zza(r1, r4)
            if (r5 != 0) goto L_0x0024
            goto L_0x0014
        L_0x0024:
            int r4 = r4 + 1
            goto L_0x0017
        L_0x0027:
            r1 = 1
        L_0x0028:
            if (r1 == 0) goto L_0x002b
            return r3
        L_0x002b:
            r6.zzafy = r0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhb.zzex():boolean");
    }
}
