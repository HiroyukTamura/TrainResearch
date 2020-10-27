package com.google.android.gms.internal.ads;

final class zzmq {
    private int length;
    private int[] zzanx = new int[1000];
    private long[] zzany = new long[1000];
    private long[] zzaoa = new long[1000];
    private int[] zzawn = new int[1000];
    private int zzbcx = 1000;
    private int[] zzbcy = new int[1000];
    private zzjw[] zzbcz = new zzjw[1000];
    private zzhf[] zzbda = new zzhf[1000];
    private int zzbdb;
    private int zzbdc;
    private int zzbdd;
    private long zzbde = Long.MIN_VALUE;
    private long zzbdf = Long.MIN_VALUE;
    private boolean zzbdg = true;
    private boolean zzbdh = true;
    private zzhf zzbdi;

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0023, code lost:
        return -3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int zza(com.google.android.gms.internal.ads.zzhh r5, com.google.android.gms.internal.ads.zzjb r6, boolean r7, boolean r8, com.google.android.gms.internal.ads.zzhf r9, com.google.android.gms.internal.ads.zzmp r10) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.zzid()     // Catch:{ all -> 0x00a4 }
            r1 = -5
            r2 = -3
            r3 = -4
            if (r0 != 0) goto L_0x0024
            if (r8 == 0) goto L_0x0012
            r5 = 4
            r6.setFlags(r5)     // Catch:{ all -> 0x00a4 }
            monitor-exit(r4)
            return r3
        L_0x0012:
            com.google.android.gms.internal.ads.zzhf r6 = r4.zzbdi     // Catch:{ all -> 0x00a4 }
            if (r6 == 0) goto L_0x0022
            if (r7 != 0) goto L_0x001c
            com.google.android.gms.internal.ads.zzhf r6 = r4.zzbdi     // Catch:{ all -> 0x00a4 }
            if (r6 == r9) goto L_0x0022
        L_0x001c:
            com.google.android.gms.internal.ads.zzhf r6 = r4.zzbdi     // Catch:{ all -> 0x00a4 }
            r5.zzahd = r6     // Catch:{ all -> 0x00a4 }
            monitor-exit(r4)
            return r1
        L_0x0022:
            monitor-exit(r4)
            return r2
        L_0x0024:
            if (r7 != 0) goto L_0x009a
            com.google.android.gms.internal.ads.zzhf[] r7 = r4.zzbda     // Catch:{ all -> 0x00a4 }
            int r8 = r4.zzbdc     // Catch:{ all -> 0x00a4 }
            r7 = r7[r8]     // Catch:{ all -> 0x00a4 }
            if (r7 == r9) goto L_0x002f
            goto L_0x009a
        L_0x002f:
            java.nio.ByteBuffer r5 = r6.zzcs     // Catch:{ all -> 0x00a4 }
            r7 = 0
            r8 = 1
            if (r5 != 0) goto L_0x0037
            r5 = 1
            goto L_0x0038
        L_0x0037:
            r5 = 0
        L_0x0038:
            if (r5 == 0) goto L_0x003c
            monitor-exit(r4)
            return r2
        L_0x003c:
            long[] r5 = r4.zzaoa     // Catch:{ all -> 0x00a4 }
            int r9 = r4.zzbdc     // Catch:{ all -> 0x00a4 }
            r0 = r5[r9]     // Catch:{ all -> 0x00a4 }
            r6.timeUs = r0     // Catch:{ all -> 0x00a4 }
            int[] r5 = r4.zzawn     // Catch:{ all -> 0x00a4 }
            int r9 = r4.zzbdc     // Catch:{ all -> 0x00a4 }
            r5 = r5[r9]     // Catch:{ all -> 0x00a4 }
            r6.setFlags(r5)     // Catch:{ all -> 0x00a4 }
            int[] r5 = r4.zzanx     // Catch:{ all -> 0x00a4 }
            int r9 = r4.zzbdc     // Catch:{ all -> 0x00a4 }
            r5 = r5[r9]     // Catch:{ all -> 0x00a4 }
            r10.size = r5     // Catch:{ all -> 0x00a4 }
            long[] r5 = r4.zzany     // Catch:{ all -> 0x00a4 }
            int r9 = r4.zzbdc     // Catch:{ all -> 0x00a4 }
            r0 = r5[r9]     // Catch:{ all -> 0x00a4 }
            r10.zzavy = r0     // Catch:{ all -> 0x00a4 }
            com.google.android.gms.internal.ads.zzjw[] r5 = r4.zzbcz     // Catch:{ all -> 0x00a4 }
            int r9 = r4.zzbdc     // Catch:{ all -> 0x00a4 }
            r5 = r5[r9]     // Catch:{ all -> 0x00a4 }
            r10.zzaqs = r5     // Catch:{ all -> 0x00a4 }
            long r0 = r4.zzbde     // Catch:{ all -> 0x00a4 }
            long r5 = r6.timeUs     // Catch:{ all -> 0x00a4 }
            long r5 = java.lang.Math.max(r0, r5)     // Catch:{ all -> 0x00a4 }
            r4.zzbde = r5     // Catch:{ all -> 0x00a4 }
            int r5 = r4.length     // Catch:{ all -> 0x00a4 }
            int r5 = r5 - r8
            r4.length = r5     // Catch:{ all -> 0x00a4 }
            int r5 = r4.zzbdc     // Catch:{ all -> 0x00a4 }
            int r5 = r5 + r8
            r4.zzbdc = r5     // Catch:{ all -> 0x00a4 }
            int r6 = r4.zzbdb     // Catch:{ all -> 0x00a4 }
            int r6 = r6 + r8
            r4.zzbdb = r6     // Catch:{ all -> 0x00a4 }
            int r6 = r4.zzbcx     // Catch:{ all -> 0x00a4 }
            if (r5 != r6) goto L_0x0084
            r4.zzbdc = r7     // Catch:{ all -> 0x00a4 }
        L_0x0084:
            int r5 = r4.length     // Catch:{ all -> 0x00a4 }
            if (r5 <= 0) goto L_0x008f
            long[] r5 = r4.zzany     // Catch:{ all -> 0x00a4 }
            int r6 = r4.zzbdc     // Catch:{ all -> 0x00a4 }
            r6 = r5[r6]     // Catch:{ all -> 0x00a4 }
            goto L_0x0096
        L_0x008f:
            long r5 = r10.zzavy     // Catch:{ all -> 0x00a4 }
            int r7 = r10.size     // Catch:{ all -> 0x00a4 }
            long r7 = (long) r7     // Catch:{ all -> 0x00a4 }
            long r5 = r5 + r7
            r6 = r5
        L_0x0096:
            r10.zzbcw = r6     // Catch:{ all -> 0x00a4 }
            monitor-exit(r4)
            return r3
        L_0x009a:
            com.google.android.gms.internal.ads.zzhf[] r6 = r4.zzbda     // Catch:{ all -> 0x00a4 }
            int r7 = r4.zzbdc     // Catch:{ all -> 0x00a4 }
            r6 = r6[r7]     // Catch:{ all -> 0x00a4 }
            r5.zzahd = r6     // Catch:{ all -> 0x00a4 }
            monitor-exit(r4)
            return r1
        L_0x00a4:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzmq.zza(com.google.android.gms.internal.ads.zzhh, com.google.android.gms.internal.ads.zzjb, boolean, boolean, com.google.android.gms.internal.ads.zzhf, com.google.android.gms.internal.ads.zzmp):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00e6, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(long r6, int r8, long r9, int r11, com.google.android.gms.internal.ads.zzjw r12) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.zzbdg     // Catch:{ all -> 0x00e7 }
            r1 = 0
            if (r0 == 0) goto L_0x000e
            r0 = r8 & 1
            if (r0 != 0) goto L_0x000c
            monitor-exit(r5)
            return
        L_0x000c:
            r5.zzbdg = r1     // Catch:{ all -> 0x00e7 }
        L_0x000e:
            boolean r0 = r5.zzbdh     // Catch:{ all -> 0x00e7 }
            r2 = 1
            if (r0 != 0) goto L_0x0015
            r0 = 1
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            com.google.android.gms.internal.ads.zzoh.checkState(r0)     // Catch:{ all -> 0x00e7 }
            r5.zzei(r6)     // Catch:{ all -> 0x00e7 }
            long[] r0 = r5.zzaoa     // Catch:{ all -> 0x00e7 }
            int r3 = r5.zzbdd     // Catch:{ all -> 0x00e7 }
            r0[r3] = r6     // Catch:{ all -> 0x00e7 }
            long[] r6 = r5.zzany     // Catch:{ all -> 0x00e7 }
            int r7 = r5.zzbdd     // Catch:{ all -> 0x00e7 }
            r6[r7] = r9     // Catch:{ all -> 0x00e7 }
            int[] r6 = r5.zzanx     // Catch:{ all -> 0x00e7 }
            int r7 = r5.zzbdd     // Catch:{ all -> 0x00e7 }
            r6[r7] = r11     // Catch:{ all -> 0x00e7 }
            int[] r6 = r5.zzawn     // Catch:{ all -> 0x00e7 }
            int r7 = r5.zzbdd     // Catch:{ all -> 0x00e7 }
            r6[r7] = r8     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.internal.ads.zzjw[] r6 = r5.zzbcz     // Catch:{ all -> 0x00e7 }
            int r7 = r5.zzbdd     // Catch:{ all -> 0x00e7 }
            r6[r7] = r12     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.internal.ads.zzhf[] r6 = r5.zzbda     // Catch:{ all -> 0x00e7 }
            int r7 = r5.zzbdd     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.internal.ads.zzhf r8 = r5.zzbdi     // Catch:{ all -> 0x00e7 }
            r6[r7] = r8     // Catch:{ all -> 0x00e7 }
            int[] r6 = r5.zzbcy     // Catch:{ all -> 0x00e7 }
            int r7 = r5.zzbdd     // Catch:{ all -> 0x00e7 }
            r6[r7] = r1     // Catch:{ all -> 0x00e7 }
            int r6 = r5.length     // Catch:{ all -> 0x00e7 }
            int r6 = r6 + r2
            r5.length = r6     // Catch:{ all -> 0x00e7 }
            int r7 = r5.zzbcx     // Catch:{ all -> 0x00e7 }
            if (r6 != r7) goto L_0x00da
            int r6 = r5.zzbcx     // Catch:{ all -> 0x00e7 }
            int r6 = r6 + 1000
            int[] r7 = new int[r6]     // Catch:{ all -> 0x00e7 }
            long[] r8 = new long[r6]     // Catch:{ all -> 0x00e7 }
            long[] r9 = new long[r6]     // Catch:{ all -> 0x00e7 }
            int[] r10 = new int[r6]     // Catch:{ all -> 0x00e7 }
            int[] r11 = new int[r6]     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.internal.ads.zzjw[] r12 = new com.google.android.gms.internal.ads.zzjw[r6]     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.internal.ads.zzhf[] r0 = new com.google.android.gms.internal.ads.zzhf[r6]     // Catch:{ all -> 0x00e7 }
            int r2 = r5.zzbcx     // Catch:{ all -> 0x00e7 }
            int r3 = r5.zzbdc     // Catch:{ all -> 0x00e7 }
            int r2 = r2 - r3
            long[] r3 = r5.zzany     // Catch:{ all -> 0x00e7 }
            int r4 = r5.zzbdc     // Catch:{ all -> 0x00e7 }
            java.lang.System.arraycopy(r3, r4, r8, r1, r2)     // Catch:{ all -> 0x00e7 }
            long[] r3 = r5.zzaoa     // Catch:{ all -> 0x00e7 }
            int r4 = r5.zzbdc     // Catch:{ all -> 0x00e7 }
            java.lang.System.arraycopy(r3, r4, r9, r1, r2)     // Catch:{ all -> 0x00e7 }
            int[] r3 = r5.zzawn     // Catch:{ all -> 0x00e7 }
            int r4 = r5.zzbdc     // Catch:{ all -> 0x00e7 }
            java.lang.System.arraycopy(r3, r4, r10, r1, r2)     // Catch:{ all -> 0x00e7 }
            int[] r3 = r5.zzanx     // Catch:{ all -> 0x00e7 }
            int r4 = r5.zzbdc     // Catch:{ all -> 0x00e7 }
            java.lang.System.arraycopy(r3, r4, r11, r1, r2)     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.internal.ads.zzjw[] r3 = r5.zzbcz     // Catch:{ all -> 0x00e7 }
            int r4 = r5.zzbdc     // Catch:{ all -> 0x00e7 }
            java.lang.System.arraycopy(r3, r4, r12, r1, r2)     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.internal.ads.zzhf[] r3 = r5.zzbda     // Catch:{ all -> 0x00e7 }
            int r4 = r5.zzbdc     // Catch:{ all -> 0x00e7 }
            java.lang.System.arraycopy(r3, r4, r0, r1, r2)     // Catch:{ all -> 0x00e7 }
            int[] r3 = r5.zzbcy     // Catch:{ all -> 0x00e7 }
            int r4 = r5.zzbdc     // Catch:{ all -> 0x00e7 }
            java.lang.System.arraycopy(r3, r4, r7, r1, r2)     // Catch:{ all -> 0x00e7 }
            int r3 = r5.zzbdc     // Catch:{ all -> 0x00e7 }
            long[] r4 = r5.zzany     // Catch:{ all -> 0x00e7 }
            java.lang.System.arraycopy(r4, r1, r8, r2, r3)     // Catch:{ all -> 0x00e7 }
            long[] r4 = r5.zzaoa     // Catch:{ all -> 0x00e7 }
            java.lang.System.arraycopy(r4, r1, r9, r2, r3)     // Catch:{ all -> 0x00e7 }
            int[] r4 = r5.zzawn     // Catch:{ all -> 0x00e7 }
            java.lang.System.arraycopy(r4, r1, r10, r2, r3)     // Catch:{ all -> 0x00e7 }
            int[] r4 = r5.zzanx     // Catch:{ all -> 0x00e7 }
            java.lang.System.arraycopy(r4, r1, r11, r2, r3)     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.internal.ads.zzjw[] r4 = r5.zzbcz     // Catch:{ all -> 0x00e7 }
            java.lang.System.arraycopy(r4, r1, r12, r2, r3)     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.internal.ads.zzhf[] r4 = r5.zzbda     // Catch:{ all -> 0x00e7 }
            java.lang.System.arraycopy(r4, r1, r0, r2, r3)     // Catch:{ all -> 0x00e7 }
            int[] r4 = r5.zzbcy     // Catch:{ all -> 0x00e7 }
            java.lang.System.arraycopy(r4, r1, r7, r2, r3)     // Catch:{ all -> 0x00e7 }
            r5.zzany = r8     // Catch:{ all -> 0x00e7 }
            r5.zzaoa = r9     // Catch:{ all -> 0x00e7 }
            r5.zzawn = r10     // Catch:{ all -> 0x00e7 }
            r5.zzanx = r11     // Catch:{ all -> 0x00e7 }
            r5.zzbcz = r12     // Catch:{ all -> 0x00e7 }
            r5.zzbda = r0     // Catch:{ all -> 0x00e7 }
            r5.zzbcy = r7     // Catch:{ all -> 0x00e7 }
            r5.zzbdc = r1     // Catch:{ all -> 0x00e7 }
            int r7 = r5.zzbcx     // Catch:{ all -> 0x00e7 }
            r5.zzbdd = r7     // Catch:{ all -> 0x00e7 }
            int r7 = r5.zzbcx     // Catch:{ all -> 0x00e7 }
            r5.length = r7     // Catch:{ all -> 0x00e7 }
            r5.zzbcx = r6     // Catch:{ all -> 0x00e7 }
            monitor-exit(r5)
            return
        L_0x00da:
            int r6 = r5.zzbdd     // Catch:{ all -> 0x00e7 }
            int r6 = r6 + r2
            r5.zzbdd = r6     // Catch:{ all -> 0x00e7 }
            int r7 = r5.zzbcx     // Catch:{ all -> 0x00e7 }
            if (r6 != r7) goto L_0x00e5
            r5.zzbdd = r1     // Catch:{ all -> 0x00e7 }
        L_0x00e5:
            monitor-exit(r5)
            return
        L_0x00e7:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzmq.zza(long, int, long, int, com.google.android.gms.internal.ads.zzjw):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005d, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized long zzd(long r9, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.zzid()     // Catch:{ all -> 0x005e }
            r1 = -1
            if (r0 == 0) goto L_0x005c
            long[] r0 = r8.zzaoa     // Catch:{ all -> 0x005e }
            int r3 = r8.zzbdc     // Catch:{ all -> 0x005e }
            r3 = r0[r3]     // Catch:{ all -> 0x005e }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0014
            goto L_0x005c
        L_0x0014:
            long r3 = r8.zzbdf     // Catch:{ all -> 0x005e }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x001e
            if (r11 != 0) goto L_0x001e
            monitor-exit(r8)
            return r1
        L_0x001e:
            r11 = 0
            int r0 = r8.zzbdc     // Catch:{ all -> 0x005e }
            r3 = -1
            r4 = -1
        L_0x0023:
            int r5 = r8.zzbdd     // Catch:{ all -> 0x005e }
            if (r0 == r5) goto L_0x0040
            long[] r5 = r8.zzaoa     // Catch:{ all -> 0x005e }
            r6 = r5[r0]     // Catch:{ all -> 0x005e }
            int r5 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r5 > 0) goto L_0x0040
            int[] r5 = r8.zzawn     // Catch:{ all -> 0x005e }
            r5 = r5[r0]     // Catch:{ all -> 0x005e }
            r5 = r5 & 1
            if (r5 == 0) goto L_0x0038
            r4 = r11
        L_0x0038:
            int r0 = r0 + 1
            int r5 = r8.zzbcx     // Catch:{ all -> 0x005e }
            int r0 = r0 % r5
            int r11 = r11 + 1
            goto L_0x0023
        L_0x0040:
            if (r4 != r3) goto L_0x0044
            monitor-exit(r8)
            return r1
        L_0x0044:
            int r9 = r8.zzbdc     // Catch:{ all -> 0x005e }
            int r9 = r9 + r4
            int r10 = r8.zzbcx     // Catch:{ all -> 0x005e }
            int r9 = r9 % r10
            r8.zzbdc = r9     // Catch:{ all -> 0x005e }
            int r10 = r8.zzbdb     // Catch:{ all -> 0x005e }
            int r10 = r10 + r4
            r8.zzbdb = r10     // Catch:{ all -> 0x005e }
            int r10 = r8.length     // Catch:{ all -> 0x005e }
            int r10 = r10 - r4
            r8.length = r10     // Catch:{ all -> 0x005e }
            long[] r10 = r8.zzany     // Catch:{ all -> 0x005e }
            r9 = r10[r9]     // Catch:{ all -> 0x005e }
            monitor-exit(r8)
            return r9
        L_0x005c:
            monitor-exit(r8)
            return r1
        L_0x005e:
            r9 = move-exception
            monitor-exit(r8)
            goto L_0x0062
        L_0x0061:
            throw r9
        L_0x0062:
            goto L_0x0061
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzmq.zzd(long, boolean):long");
    }

    public final synchronized void zzei(long j) {
        this.zzbdf = Math.max(this.zzbdf, j);
    }

    public final synchronized boolean zzg(zzhf zzhf) {
        if (zzhf == null) {
            this.zzbdh = true;
            return false;
        }
        this.zzbdh = false;
        if (zzov.zza(zzhf, this.zzbdi)) {
            return false;
        }
        this.zzbdi = zzhf;
        return true;
    }

    public final synchronized long zzhu() {
        return Math.max(this.zzbde, this.zzbdf);
    }

    public final void zzia() {
        this.zzbdb = 0;
        this.zzbdc = 0;
        this.zzbdd = 0;
        this.length = 0;
        this.zzbdg = true;
    }

    public final void zzib() {
        this.zzbde = Long.MIN_VALUE;
        this.zzbdf = Long.MIN_VALUE;
    }

    public final int zzic() {
        return this.zzbdb + this.length;
    }

    public final synchronized boolean zzid() {
        return this.length != 0;
    }

    public final synchronized zzhf zzie() {
        if (this.zzbdh) {
            return null;
        }
        return this.zzbdi;
    }

    public final synchronized long zzif() {
        if (!zzid()) {
            return -1;
        }
        int i = ((this.zzbdc + this.length) - 1) % this.zzbcx;
        this.zzbdc = (this.zzbdc + this.length) % this.zzbcx;
        this.zzbdb += this.length;
        this.length = 0;
        return this.zzany[i] + ((long) this.zzanx[i]);
    }
}
