package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzdgm {
    private final Object lock = new Object();
    private final Clock zzbnt;
    private volatile long zzdup = 0;
    private volatile int zzgti = zzdgl.zzgte;

    public zzdgm(Clock clock) {
        this.zzbnt = clock;
    }

    private final void zzarr() {
        long currentTimeMillis = this.zzbnt.currentTimeMillis();
        synchronized (this.lock) {
            if (this.zzgti == zzdgl.zzgtg) {
                if (this.zzdup + ((Long) zzvj.zzpv().zzd(zzzz.zzcsm)).longValue() <= currentTimeMillis) {
                    this.zzgti = zzdgl.zzgte;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzr(int r5, int r6) {
        /*
            r4 = this;
            r4.zzarr()
            com.google.android.gms.common.util.Clock r0 = r4.zzbnt
            long r0 = r0.currentTimeMillis()
            java.lang.Object r2 = r4.lock
            monitor-enter(r2)
            int r3 = r4.zzgti     // Catch:{ all -> 0x001e }
            if (r3 == r5) goto L_0x0012
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            return
        L_0x0012:
            r4.zzgti = r6     // Catch:{ all -> 0x001e }
            int r5 = r4.zzgti     // Catch:{ all -> 0x001e }
            int r6 = com.google.android.gms.internal.ads.zzdgl.zzgtg     // Catch:{ all -> 0x001e }
            if (r5 != r6) goto L_0x001c
            r4.zzdup = r0     // Catch:{ all -> 0x001e }
        L_0x001c:
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            return
        L_0x001e:
            r5 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdgm.zzr(int, int):void");
    }

    public final boolean zzars() {
        boolean z;
        synchronized (this.lock) {
            zzarr();
            z = this.zzgti == zzdgl.zzgtf;
        }
        return z;
    }

    public final boolean zzart() {
        boolean z;
        synchronized (this.lock) {
            zzarr();
            z = this.zzgti == zzdgl.zzgtg;
        }
        return z;
    }

    public final void zzbn(boolean z) {
        int i;
        int i2;
        if (z) {
            i = zzdgl.zzgte;
            i2 = zzdgl.zzgtf;
        } else {
            i = zzdgl.zzgtf;
            i2 = zzdgl.zzgte;
        }
        zzr(i, i2);
    }

    public final void zzvx() {
        zzr(zzdgl.zzgtf, zzdgl.zzgtg);
    }
}
