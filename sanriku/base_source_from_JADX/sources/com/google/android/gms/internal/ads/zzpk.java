package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;

@TargetApi(16)
public final class zzpk {
    private final zzpj zzbjw;
    private final boolean zzbjx;
    private final long zzbjy;
    private final long zzbjz;
    private long zzbka;
    private long zzbkb;
    private long zzbkc;
    private boolean zzbkd;
    private long zzbke;
    private long zzbkf;
    private long zzbkg;

    public zzpk() {
        this(-1.0d);
    }

    private zzpk(double d) {
        long j;
        boolean z = d != -1.0d;
        this.zzbjx = z;
        if (z) {
            this.zzbjw = zzpj.zzjn();
            long j2 = (long) (1.0E9d / d);
            this.zzbjy = j2;
            j = (j2 * 80) / 100;
        } else {
            this.zzbjw = null;
            j = -1;
            this.zzbjy = -1;
        }
        this.zzbjz = j;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzpk(android.content.Context r3) {
        /*
            r2 = this;
            java.lang.String r0 = "window"
            java.lang.Object r3 = r3.getSystemService(r0)
            android.view.WindowManager r3 = (android.view.WindowManager) r3
            android.view.Display r0 = r3.getDefaultDisplay()
            if (r0 == 0) goto L_0x0018
            android.view.Display r3 = r3.getDefaultDisplay()
            float r3 = r3.getRefreshRate()
            double r0 = (double) r3
            goto L_0x001a
        L_0x0018:
            r0 = -4616189618054758400(0xbff0000000000000, double:-1.0)
        L_0x001a:
            r2.<init>((double) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpk.<init>(android.content.Context):void");
    }

    private final boolean zzg(long j, long j2) {
        return Math.abs((j2 - this.zzbke) - (j - this.zzbkf)) > 20000000;
    }

    public final void disable() {
        if (this.zzbjx) {
            this.zzbjw.zzjp();
        }
    }

    public final void enable() {
        this.zzbkd = false;
        if (this.zzbjx) {
            this.zzbjw.zzjo();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003c, code lost:
        if (zzg(r0, r12) != false) goto L_0x003e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0083 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzf(long r10, long r12) {
        /*
            r9 = this;
            r0 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r10
            boolean r2 = r9.zzbkd
            if (r2 == 0) goto L_0x0040
            long r2 = r9.zzbka
            int r4 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0019
            long r2 = r9.zzbkg
            r4 = 1
            long r2 = r2 + r4
            r9.zzbkg = r2
            long r2 = r9.zzbkc
            r9.zzbkb = r2
        L_0x0019:
            long r2 = r9.zzbkg
            r4 = 6
            r6 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 < 0) goto L_0x0038
            long r4 = r9.zzbkf
            long r4 = r0 - r4
            long r4 = r4 / r2
            long r2 = r9.zzbkb
            long r2 = r2 + r4
            boolean r4 = r9.zzg(r2, r12)
            if (r4 == 0) goto L_0x0031
            goto L_0x003e
        L_0x0031:
            long r4 = r9.zzbke
            long r4 = r4 + r2
            long r6 = r9.zzbkf
            long r4 = r4 - r6
            goto L_0x0042
        L_0x0038:
            boolean r2 = r9.zzg(r0, r12)
            if (r2 == 0) goto L_0x0040
        L_0x003e:
            r9.zzbkd = r6
        L_0x0040:
            r4 = r12
            r2 = r0
        L_0x0042:
            boolean r6 = r9.zzbkd
            r7 = 0
            if (r6 != 0) goto L_0x0051
            r9.zzbkf = r0
            r9.zzbke = r12
            r9.zzbkg = r7
            r12 = 1
            r9.zzbkd = r12
        L_0x0051:
            r9.zzbka = r10
            r9.zzbkc = r2
            com.google.android.gms.internal.ads.zzpj r10 = r9.zzbjw
            if (r10 == 0) goto L_0x0083
            long r10 = r10.zzbjr
            int r12 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r12 != 0) goto L_0x0060
            goto L_0x0083
        L_0x0060:
            com.google.android.gms.internal.ads.zzpj r10 = r9.zzbjw
            long r10 = r10.zzbjr
            long r12 = r9.zzbjy
            long r0 = r4 - r10
            long r0 = r0 / r12
            long r0 = r0 * r12
            long r0 = r0 + r10
            int r10 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r10 > 0) goto L_0x0073
            long r10 = r0 - r12
            goto L_0x0076
        L_0x0073:
            long r12 = r12 + r0
            r10 = r0
            r0 = r12
        L_0x0076:
            long r12 = r0 - r4
            long r4 = r4 - r10
            int r2 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x007e
            goto L_0x007f
        L_0x007e:
            r0 = r10
        L_0x007f:
            long r10 = r9.zzbjz
            long r0 = r0 - r10
            return r0
        L_0x0083:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpk.zzf(long, long):long");
    }
}
