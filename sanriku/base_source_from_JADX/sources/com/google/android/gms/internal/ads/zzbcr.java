package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

public final class zzbcr implements zzhj {
    private int zzbgj;
    private final zzny zzefl;
    private long zzefm;
    private long zzefn;
    private long zzefo;
    private long zzefp;
    private boolean zzefq;

    zzbcr() {
        this(15000, 30000, 2500, 5000);
    }

    private zzbcr(int i, int i2, long j, long j2) {
        this.zzefl = new zzny(true, 65536);
        this.zzefm = 15000000;
        this.zzefn = 30000000;
        this.zzefo = 2500000;
        this.zzefp = 5000000;
    }

    @VisibleForTesting
    private final void zzk(boolean z) {
        this.zzbgj = 0;
        this.zzefq = false;
        if (z) {
            this.zzefl.reset();
        }
    }

    public final void onStopped() {
        zzk(true);
    }

    public final void zza(zzhk[] zzhkArr, zzna zzna, zznl zznl) {
        this.zzbgj = 0;
        for (int i = 0; i < zzhkArr.length; i++) {
            if (zznl.zzba(i) != null) {
                this.zzbgj = zzov.zzbm(zzhkArr[i].getTrackType()) + this.zzbgj;
            }
        }
        this.zzefl.zzbc(this.zzbgj);
    }

    public final synchronized boolean zzc(long j, boolean z) {
        long j2;
        j2 = z ? this.zzefp : this.zzefo;
        return j2 <= 0 || j >= j2;
    }

    public final synchronized void zzdg(int i) {
        this.zzefo = ((long) i) * 1000;
    }

    public final synchronized void zzdh(int i) {
        this.zzefp = ((long) i) * 1000;
    }

    public final synchronized void zzdl(int i) {
        this.zzefm = ((long) i) * 1000;
    }

    public final synchronized void zzdm(int i) {
        this.zzefn = ((long) i) * 1000;
    }

    public final synchronized boolean zzdt(long j) {
        boolean z;
        z = false;
        char c = j > this.zzefn ? 0 : j < this.zzefm ? (char) 2 : 1;
        boolean z2 = this.zzefl.zziq() >= this.zzbgj;
        if (c == 2 || (c == 1 && this.zzefq && !z2)) {
            z = true;
        }
        this.zzefq = z;
        return z;
    }

    public final void zzfa() {
        zzk(false);
    }

    public final void zzfb() {
        zzk(true);
    }

    public final zzns zzfc() {
        return this.zzefl;
    }
}
