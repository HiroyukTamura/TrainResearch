package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicReference;

public final class zznd extends zzni {
    private static final int[] zzbej = new int[0];
    private final zznm zzbek;
    private final AtomicReference<zzng> zzbel;

    public zznd() {
        this((zznm) null);
    }

    private zznd(zznm zznm) {
        this.zzbek = null;
        this.zzbel = new AtomicReference<>(new zzng());
    }

    private static boolean zza(zzhf zzhf, String str) {
        return str != null && TextUtils.equals(str, zzov.zzbh(zzhf.zzagz));
    }

    private static int zze(int i, int i2) {
        if (i == -1) {
            return i2 == -1 ? 0 : -1;
        }
        if (i2 == -1) {
            return 1;
        }
        return i - i2;
    }

    private static boolean zze(int i, boolean z) {
        int i2 = i & 3;
        if (i2 != 3) {
            return z && i2 == 2;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x017f, code lost:
        if (r11 <= r12) goto L_0x0184;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01b2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zznj[] zza(com.google.android.gms.internal.ads.zzhn[] r36, com.google.android.gms.internal.ads.zzna[] r37, int[][][] r38) throws com.google.android.gms.internal.ads.zzgq {
        /*
            r35 = this;
            r0 = r36
            int r1 = r0.length
            com.google.android.gms.internal.ads.zznj[] r2 = new com.google.android.gms.internal.ads.zznj[r1]
            r3 = r35
            java.util.concurrent.atomic.AtomicReference<com.google.android.gms.internal.ads.zzng> r4 = r3.zzbel
            java.lang.Object r4 = r4.get()
            com.google.android.gms.internal.ads.zzng r4 = (com.google.android.gms.internal.ads.zzng) r4
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x0012:
            r9 = 2
            if (r6 >= r1) goto L_0x0265
            r13 = r0[r6]
            int r13 = r13.getTrackType()
            if (r9 != r13) goto L_0x024d
            if (r7 != 0) goto L_0x0237
            r7 = r37[r6]
            r13 = r38[r6]
            int r14 = r4.zzbeq
            int r15 = r4.zzber
            int r11 = r4.zzbes
            int r9 = r4.viewportWidth
            int r5 = r4.viewportHeight
            boolean r10 = r4.zzbev
            boolean r12 = r4.zzbet
            boolean r3 = r4.zzbeu
            r20 = r1
            r19 = r4
            r24 = r8
            r0 = 0
            r1 = 0
            r4 = 0
            r21 = 0
            r22 = -1
            r23 = -1
        L_0x0042:
            int r8 = r7.length
            if (r0 >= r8) goto L_0x0217
            com.google.android.gms.internal.ads.zzmx r8 = r7.zzay(r0)
            r25 = r7
            java.util.ArrayList r7 = new java.util.ArrayList
            r26 = r2
            int r2 = r8.length
            r7.<init>(r2)
            r27 = r6
            r2 = 0
        L_0x0058:
            int r6 = r8.length
            if (r2 >= r6) goto L_0x0066
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)
            r7.add(r6)
            int r2 = r2 + 1
            goto L_0x0058
        L_0x0066:
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r9 == r2) goto L_0x0139
            if (r5 != r2) goto L_0x006f
            goto L_0x0139
        L_0x006f:
            r28 = r1
            r6 = 0
        L_0x0072:
            int r1 = r8.length
            if (r6 >= r1) goto L_0x0103
            com.google.android.gms.internal.ads.zzhf r1 = r8.zzax(r6)
            r29 = r4
            int r4 = r1.width
            if (r4 <= 0) goto L_0x00e9
            r30 = r12
            int r12 = r1.height
            if (r12 <= 0) goto L_0x00e0
            if (r10 == 0) goto L_0x009e
            r31 = r10
            if (r4 <= r12) goto L_0x008e
            r10 = 1
            goto L_0x008f
        L_0x008e:
            r10 = 0
        L_0x008f:
            r32 = r5
            if (r9 <= r5) goto L_0x0095
            r5 = 1
            goto L_0x0096
        L_0x0095:
            r5 = 0
        L_0x0096:
            if (r10 == r5) goto L_0x00a2
            r5 = r9
            r33 = r5
            r10 = r32
            goto L_0x00a7
        L_0x009e:
            r32 = r5
            r31 = r10
        L_0x00a2:
            r10 = r9
            r33 = r10
            r5 = r32
        L_0x00a7:
            int r9 = r4 * r5
            r34 = r11
            int r11 = r12 * r10
            if (r9 < r11) goto L_0x00b9
            android.graphics.Point r5 = new android.graphics.Point
            int r4 = com.google.android.gms.internal.ads.zzov.zzf(r11, r4)
            r5.<init>(r10, r4)
            goto L_0x00c3
        L_0x00b9:
            android.graphics.Point r4 = new android.graphics.Point
            int r9 = com.google.android.gms.internal.ads.zzov.zzf(r9, r12)
            r4.<init>(r9, r5)
            r5 = r4
        L_0x00c3:
            int r4 = r1.width
            int r1 = r1.height
            int r9 = r4 * r1
            int r10 = r5.x
            float r10 = (float) r10
            r11 = 1065017672(0x3f7ae148, float:0.98)
            float r10 = r10 * r11
            int r10 = (int) r10
            if (r4 < r10) goto L_0x00f3
            int r4 = r5.y
            float r4 = (float) r4
            float r4 = r4 * r11
            int r4 = (int) r4
            if (r1 < r4) goto L_0x00f3
            if (r9 >= r2) goto L_0x00f3
            r2 = r9
            goto L_0x00f3
        L_0x00e0:
            r32 = r5
            r33 = r9
            r31 = r10
            r34 = r11
            goto L_0x00f3
        L_0x00e9:
            r32 = r5
            r33 = r9
            r31 = r10
            r34 = r11
            r30 = r12
        L_0x00f3:
            int r6 = r6 + 1
            r4 = r29
            r12 = r30
            r10 = r31
            r5 = r32
            r9 = r33
            r11 = r34
            goto L_0x0072
        L_0x0103:
            r29 = r4
            r32 = r5
            r33 = r9
            r31 = r10
            r34 = r11
            r30 = r12
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r2 == r1) goto L_0x0147
            int r1 = r7.size()
            r4 = 1
            int r1 = r1 - r4
        L_0x011a:
            if (r1 < 0) goto L_0x0147
            java.lang.Object r4 = r7.get(r1)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            com.google.android.gms.internal.ads.zzhf r4 = r8.zzax(r4)
            int r4 = r4.zzey()
            r5 = -1
            if (r4 == r5) goto L_0x0133
            if (r4 <= r2) goto L_0x0136
        L_0x0133:
            r7.remove(r1)
        L_0x0136:
            int r1 = r1 + -1
            goto L_0x011a
        L_0x0139:
            r28 = r1
            r29 = r4
            r32 = r5
            r33 = r9
            r31 = r10
            r34 = r11
            r30 = r12
        L_0x0147:
            r1 = r13[r0]
            r5 = r21
            r6 = r22
            r9 = r23
            r4 = r29
            r2 = 0
        L_0x0152:
            int r10 = r8.length
            if (r2 >= r10) goto L_0x01f6
            r10 = r1[r2]
            boolean r10 = zze((int) r10, (boolean) r3)
            if (r10 == 0) goto L_0x01e2
            com.google.android.gms.internal.ads.zzhf r10 = r8.zzax(r2)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r2)
            boolean r11 = r7.contains(r11)
            if (r11 == 0) goto L_0x0186
            int r11 = r10.width
            r12 = -1
            if (r11 == r12) goto L_0x0173
            if (r11 > r14) goto L_0x0186
        L_0x0173:
            int r11 = r10.height
            if (r11 == r12) goto L_0x0179
            if (r11 > r15) goto L_0x0186
        L_0x0179:
            int r11 = r10.zzage
            if (r11 == r12) goto L_0x0182
            r12 = r34
            if (r11 > r12) goto L_0x0188
            goto L_0x0184
        L_0x0182:
            r12 = r34
        L_0x0184:
            r11 = 1
            goto L_0x0189
        L_0x0186:
            r12 = r34
        L_0x0188:
            r11 = 0
        L_0x0189:
            if (r11 != 0) goto L_0x0195
            if (r30 == 0) goto L_0x018e
            goto L_0x0195
        L_0x018e:
            r23 = r1
            r21 = r3
            r22 = r4
            goto L_0x01ea
        L_0x0195:
            r21 = r3
            r22 = r4
            if (r11 == 0) goto L_0x019d
            r3 = 2
            goto L_0x019e
        L_0x019d:
            r3 = 1
        L_0x019e:
            r4 = r1[r2]
            r23 = r1
            r1 = 0
            boolean r4 = zze((int) r4, (boolean) r1)
            if (r4 == 0) goto L_0x01ab
            int r3 = r3 + 1000
        L_0x01ab:
            if (r3 <= r5) goto L_0x01af
            r1 = 1
            goto L_0x01b0
        L_0x01af:
            r1 = 0
        L_0x01b0:
            if (r3 != r5) goto L_0x01d3
            int r1 = r10.zzey()
            if (r1 == r6) goto L_0x01c1
            int r1 = r10.zzey()
            int r1 = zze((int) r1, (int) r6)
            goto L_0x01c7
        L_0x01c1:
            int r1 = r10.zzage
            int r1 = zze((int) r1, (int) r9)
        L_0x01c7:
            if (r4 == 0) goto L_0x01ce
            if (r11 == 0) goto L_0x01ce
            if (r1 <= 0) goto L_0x01d2
            goto L_0x01d0
        L_0x01ce:
            if (r1 >= 0) goto L_0x01d2
        L_0x01d0:
            r1 = 1
            goto L_0x01d3
        L_0x01d2:
            r1 = 0
        L_0x01d3:
            if (r1 == 0) goto L_0x01ea
            int r1 = r10.zzage
            int r4 = r10.zzey()
            r9 = r1
            r28 = r2
            r5 = r3
            r6 = r4
            r4 = r8
            goto L_0x01ec
        L_0x01e2:
            r23 = r1
            r21 = r3
            r22 = r4
            r12 = r34
        L_0x01ea:
            r4 = r22
        L_0x01ec:
            int r2 = r2 + 1
            r34 = r12
            r3 = r21
            r1 = r23
            goto L_0x0152
        L_0x01f6:
            r21 = r3
            r22 = r4
            r12 = r34
            int r0 = r0 + 1
            r23 = r9
            r11 = r12
            r7 = r25
            r2 = r26
            r1 = r28
            r12 = r30
            r10 = r31
            r9 = r33
            r21 = r5
            r22 = r6
            r6 = r27
            r5 = r32
            goto L_0x0042
        L_0x0217:
            r28 = r1
            r26 = r2
            r29 = r4
            r27 = r6
            if (r29 != 0) goto L_0x0223
            r11 = 0
            goto L_0x022c
        L_0x0223:
            com.google.android.gms.internal.ads.zznf r11 = new com.google.android.gms.internal.ads.zznf
            r1 = r28
            r0 = r29
            r11.<init>(r0, r1)
        L_0x022c:
            r26[r27] = r11
            r0 = r26[r27]
            if (r0 == 0) goto L_0x0234
            r0 = 1
            goto L_0x0235
        L_0x0234:
            r0 = 0
        L_0x0235:
            r7 = r0
            goto L_0x0241
        L_0x0237:
            r20 = r1
            r26 = r2
            r19 = r4
            r27 = r6
            r24 = r8
        L_0x0241:
            r0 = r37[r27]
            int r0 = r0.length
            if (r0 <= 0) goto L_0x0249
            r12 = 1
            goto L_0x024a
        L_0x0249:
            r12 = 0
        L_0x024a:
            r8 = r24 | r12
            goto L_0x0257
        L_0x024d:
            r20 = r1
            r26 = r2
            r19 = r4
            r27 = r6
            r24 = r8
        L_0x0257:
            int r6 = r27 + 1
            r3 = r35
            r0 = r36
            r4 = r19
            r1 = r20
            r2 = r26
            goto L_0x0012
        L_0x0265:
            r26 = r2
            r19 = r4
            r24 = r8
            r3 = r1
            r0 = 0
            r1 = 0
            r2 = 0
        L_0x026f:
            if (r1 >= r3) goto L_0x0438
            r4 = r36[r1]
            int r4 = r4.getTrackType()
            r6 = 3
            r7 = 1
            if (r4 == r7) goto L_0x03a5
            r7 = 2
            if (r4 == r7) goto L_0x039e
            if (r4 == r6) goto L_0x02f6
            r4 = r36[r1]
            r4.getTrackType()
            r4 = r37[r1]
            r5 = r38[r1]
            r7 = r19
            boolean r6 = r7.zzbeu
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
        L_0x0291:
            int r12 = r4.length
            if (r9 >= r12) goto L_0x02e3
            com.google.android.gms.internal.ads.zzmx r12 = r4.zzay(r9)
            r13 = r5[r9]
            r14 = 0
        L_0x029c:
            int r15 = r12.length
            if (r14 >= r15) goto L_0x02dc
            r15 = r13[r14]
            boolean r15 = zze((int) r15, (boolean) r6)
            if (r15 == 0) goto L_0x02d1
            com.google.android.gms.internal.ads.zzhf r15 = r12.zzax(r14)
            int r15 = r15.zzagy
            r18 = 1
            r15 = r15 & 1
            if (r15 == 0) goto L_0x02b6
            r15 = 1
            goto L_0x02b7
        L_0x02b6:
            r15 = 0
        L_0x02b7:
            r20 = r3
            if (r15 == 0) goto L_0x02bd
            r15 = 2
            goto L_0x02be
        L_0x02bd:
            r15 = 1
        L_0x02be:
            r3 = r13[r14]
            r19 = r4
            r4 = 0
            boolean r3 = zze((int) r3, (boolean) r4)
            if (r3 == 0) goto L_0x02cb
            int r15 = r15 + 1000
        L_0x02cb:
            if (r15 <= r11) goto L_0x02d5
            r8 = r12
            r10 = r14
            r11 = r15
            goto L_0x02d5
        L_0x02d1:
            r20 = r3
            r19 = r4
        L_0x02d5:
            int r14 = r14 + 1
            r4 = r19
            r3 = r20
            goto L_0x029c
        L_0x02dc:
            r20 = r3
            r19 = r4
            int r9 = r9 + 1
            goto L_0x0291
        L_0x02e3:
            r20 = r3
            if (r8 != 0) goto L_0x02e9
            r3 = 0
            goto L_0x02ee
        L_0x02e9:
            com.google.android.gms.internal.ads.zznf r3 = new com.google.android.gms.internal.ads.zznf
            r3.<init>(r8, r10)
        L_0x02ee:
            r26[r1] = r3
            r5 = -1
            r15 = 0
            r17 = 2
            goto L_0x039a
        L_0x02f6:
            r20 = r3
            r7 = r19
            if (r2 != 0) goto L_0x03a2
            r2 = r37[r1]
            r3 = r38[r1]
            boolean r4 = r7.zzbeu
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
        L_0x0306:
            int r12 = r2.length
            if (r8 >= r12) goto L_0x0383
            com.google.android.gms.internal.ads.zzmx r12 = r2.zzay(r8)
            r13 = r3[r8]
            r14 = r11
            r11 = r10
            r10 = r9
            r9 = 0
        L_0x0314:
            int r15 = r12.length
            if (r9 >= r15) goto L_0x0378
            r15 = r13[r9]
            boolean r15 = zze((int) r15, (boolean) r4)
            if (r15 == 0) goto L_0x036e
            com.google.android.gms.internal.ads.zzhf r15 = r12.zzax(r9)
            int r5 = r15.zzagy
            r18 = 1
            r5 = r5 & 1
            if (r5 == 0) goto L_0x032e
            r5 = 1
            goto L_0x032f
        L_0x032e:
            r5 = 0
        L_0x032f:
            int r6 = r15.zzagy
            r17 = 2
            r6 = r6 & 2
            r22 = r2
            r2 = 0
            if (r6 == 0) goto L_0x033c
            r6 = 1
            goto L_0x033d
        L_0x033c:
            r6 = 0
        L_0x033d:
            boolean r23 = zza(r15, r2)
            if (r23 == 0) goto L_0x034d
            if (r5 == 0) goto L_0x0347
            r2 = 6
            goto L_0x035d
        L_0x0347:
            if (r6 != 0) goto L_0x034b
            r2 = 5
            goto L_0x035d
        L_0x034b:
            r2 = 4
            goto L_0x035d
        L_0x034d:
            if (r5 == 0) goto L_0x0351
            r2 = 3
            goto L_0x035d
        L_0x0351:
            if (r6 == 0) goto L_0x0372
            r2 = 0
            boolean r5 = zza(r15, r2)
            if (r5 == 0) goto L_0x035c
            r2 = 2
            goto L_0x035d
        L_0x035c:
            r2 = 1
        L_0x035d:
            r5 = r13[r9]
            r6 = 0
            boolean r5 = zze((int) r5, (boolean) r6)
            if (r5 == 0) goto L_0x0368
            int r2 = r2 + 1000
        L_0x0368:
            if (r2 <= r11) goto L_0x0372
            r11 = r2
            r10 = r9
            r14 = r12
            goto L_0x0372
        L_0x036e:
            r22 = r2
            r17 = 2
        L_0x0372:
            int r9 = r9 + 1
            r2 = r22
            r6 = 3
            goto L_0x0314
        L_0x0378:
            r22 = r2
            r17 = 2
            int r8 = r8 + 1
            r9 = r10
            r10 = r11
            r11 = r14
            r6 = 3
            goto L_0x0306
        L_0x0383:
            r17 = 2
            if (r11 != 0) goto L_0x0389
            r2 = 0
            goto L_0x038e
        L_0x0389:
            com.google.android.gms.internal.ads.zznf r2 = new com.google.android.gms.internal.ads.zznf
            r2.<init>(r11, r9)
        L_0x038e:
            r26[r1] = r2
            r2 = r26[r1]
            if (r2 == 0) goto L_0x0396
            r4 = 1
            goto L_0x0397
        L_0x0396:
            r4 = 0
        L_0x0397:
            r2 = r4
        L_0x0398:
            r5 = -1
            r15 = 0
        L_0x039a:
            r18 = 1
            goto L_0x0430
        L_0x039e:
            r20 = r3
            r7 = r19
        L_0x03a2:
            r17 = 2
            goto L_0x0398
        L_0x03a5:
            r20 = r3
            r7 = r19
            r17 = 2
            if (r0 != 0) goto L_0x0398
            r0 = r37[r1]
            r3 = r38[r1]
            boolean r4 = r7.zzbeu
            r5 = 0
            r6 = 0
            r8 = -1
            r9 = -1
        L_0x03b7:
            int r10 = r0.length
            if (r5 >= r10) goto L_0x0415
            com.google.android.gms.internal.ads.zzmx r10 = r0.zzay(r5)
            r11 = r3[r5]
            r12 = r9
            r9 = r8
            r8 = r6
            r6 = 0
        L_0x03c5:
            int r13 = r10.length
            if (r6 >= r13) goto L_0x040c
            r13 = r11[r6]
            boolean r13 = zze((int) r13, (boolean) r4)
            if (r13 == 0) goto L_0x0406
            com.google.android.gms.internal.ads.zzhf r13 = r10.zzax(r6)
            r14 = r11[r6]
            int r15 = r13.zzagy
            r18 = 1
            r15 = r15 & 1
            if (r15 == 0) goto L_0x03e3
            r15 = 0
            r16 = 1
            goto L_0x03e6
        L_0x03e3:
            r15 = 0
            r16 = 0
        L_0x03e6:
            boolean r13 = zza(r13, r15)
            if (r13 == 0) goto L_0x03f2
            if (r16 == 0) goto L_0x03f0
            r13 = 4
            goto L_0x03f7
        L_0x03f0:
            r13 = 3
            goto L_0x03f7
        L_0x03f2:
            if (r16 == 0) goto L_0x03f6
            r13 = 2
            goto L_0x03f7
        L_0x03f6:
            r13 = 1
        L_0x03f7:
            r15 = 0
            boolean r14 = zze((int) r14, (boolean) r15)
            if (r14 == 0) goto L_0x0400
            int r13 = r13 + 1000
        L_0x0400:
            if (r13 <= r8) goto L_0x0409
            r9 = r5
            r12 = r6
            r8 = r13
            goto L_0x0409
        L_0x0406:
            r15 = 0
            r18 = 1
        L_0x0409:
            int r6 = r6 + 1
            goto L_0x03c5
        L_0x040c:
            r15 = 0
            r18 = 1
            int r5 = r5 + 1
            r6 = r8
            r8 = r9
            r9 = r12
            goto L_0x03b7
        L_0x0415:
            r5 = -1
            r15 = 0
            r18 = 1
            if (r8 != r5) goto L_0x041d
            r3 = 0
            goto L_0x0426
        L_0x041d:
            com.google.android.gms.internal.ads.zzmx r0 = r0.zzay(r8)
            com.google.android.gms.internal.ads.zznf r3 = new com.google.android.gms.internal.ads.zznf
            r3.<init>(r0, r9)
        L_0x0426:
            r26[r1] = r3
            r0 = r26[r1]
            if (r0 == 0) goto L_0x042e
            r4 = 1
            goto L_0x042f
        L_0x042e:
            r4 = 0
        L_0x042f:
            r0 = r4
        L_0x0430:
            int r1 = r1 + 1
            r19 = r7
            r3 = r20
            goto L_0x026f
        L_0x0438:
            return r26
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zznd.zza(com.google.android.gms.internal.ads.zzhn[], com.google.android.gms.internal.ads.zzna[], int[][][]):com.google.android.gms.internal.ads.zznj[]");
    }
}
