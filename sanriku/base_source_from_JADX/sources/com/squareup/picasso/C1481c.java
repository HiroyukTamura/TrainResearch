package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import com.squareup.picasso.C1509s;
import com.squareup.picasso.C1513u;
import com.squareup.picasso.C1530z;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p042j.C1016z;
import p042j.C2072h;
import p042j.C2085t;

/* renamed from: com.squareup.picasso.c */
class C1481c implements Runnable {

    /* renamed from: v */
    private static final Object f1587v = new Object();

    /* renamed from: w */
    private static final ThreadLocal<StringBuilder> f1588w = new C1482a();

    /* renamed from: x */
    private static final AtomicInteger f1589x = new AtomicInteger();

    /* renamed from: y */
    private static final C1530z f1590y = new C1483b();

    /* renamed from: a */
    final int f1591a = f1589x.incrementAndGet();

    /* renamed from: b */
    final C1513u f1592b;

    /* renamed from: c */
    final C1493i f1593c;

    /* renamed from: d */
    final C1488d f1594d;

    /* renamed from: e */
    final C1467B f1595e;

    /* renamed from: f */
    final String f1596f;

    /* renamed from: g */
    final C1526x f1597g;

    /* renamed from: h */
    final int f1598h;

    /* renamed from: i */
    int f1599i;

    /* renamed from: l */
    final C1530z f1600l;

    /* renamed from: m */
    C1478a f1601m;

    /* renamed from: n */
    List<C1478a> f1602n;

    /* renamed from: o */
    Bitmap f1603o;

    /* renamed from: p */
    Future<?> f1604p;

    /* renamed from: q */
    C1513u.C1519e f1605q;

    /* renamed from: r */
    Exception f1606r;

    /* renamed from: s */
    int f1607s;

    /* renamed from: t */
    int f1608t;

    /* renamed from: u */
    C1513u.C1520f f1609u;

    /* renamed from: com.squareup.picasso.c$a */
    static class C1482a extends ThreadLocal<StringBuilder> {
        C1482a() {
        }

        /* access modifiers changed from: protected */
        public Object initialValue() {
            return new StringBuilder("Picasso-");
        }
    }

    /* renamed from: com.squareup.picasso.c$b */
    static class C1483b extends C1530z {
        C1483b() {
        }

        /* renamed from: a */
        public C1530z.C1531a mo27173a(C1526x xVar, int i) throws IOException {
            throw new IllegalStateException("Unrecognized type of request: " + xVar);
        }

        /* renamed from: a */
        public boolean mo27174a(C1526x xVar) {
            return true;
        }
    }

    /* renamed from: com.squareup.picasso.c$c */
    static class C1484c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C1473F f1610a;

        /* renamed from: b */
        final /* synthetic */ RuntimeException f1611b;

        C1484c(C1473F f, RuntimeException runtimeException) {
            this.f1610a = f;
            this.f1611b = runtimeException;
        }

        public void run() {
            StringBuilder a = C0681a.m330a("Transformation ");
            a.append(this.f1610a.key());
            a.append(" crashed with exception.");
            throw new RuntimeException(a.toString(), this.f1611b);
        }
    }

    /* renamed from: com.squareup.picasso.c$d */
    static class C1485d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ StringBuilder f1612a;

        C1485d(StringBuilder sb) {
            this.f1612a = sb;
        }

        public void run() {
            throw new NullPointerException(this.f1612a.toString());
        }
    }

    /* renamed from: com.squareup.picasso.c$e */
    static class C1486e implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C1473F f1613a;

        C1486e(C1473F f) {
            this.f1613a = f;
        }

        public void run() {
            StringBuilder a = C0681a.m330a("Transformation ");
            a.append(this.f1613a.key());
            a.append(" returned input Bitmap but recycled it.");
            throw new IllegalStateException(a.toString());
        }
    }

    /* renamed from: com.squareup.picasso.c$f */
    static class C1487f implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C1473F f1614a;

        C1487f(C1473F f) {
            this.f1614a = f;
        }

        public void run() {
            StringBuilder a = C0681a.m330a("Transformation ");
            a.append(this.f1614a.key());
            a.append(" mutated input Bitmap but failed to recycle the original.");
            throw new IllegalStateException(a.toString());
        }
    }

    C1481c(C1513u uVar, C1493i iVar, C1488d dVar, C1467B b, C1478a aVar, C1530z zVar) {
        this.f1592b = uVar;
        this.f1593c = iVar;
        this.f1594d = dVar;
        this.f1595e = b;
        this.f1601m = aVar;
        this.f1596f = aVar.f1579i;
        C1526x xVar = aVar.f1572b;
        this.f1597g = xVar;
        this.f1609u = xVar.f1733t;
        this.f1598h = aVar.f1575e;
        this.f1599i = aVar.f1576f;
        this.f1600l = zVar;
        this.f1608t = zVar.mo27240a();
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x02b7  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0253  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.graphics.Bitmap m2020a(com.squareup.picasso.C1526x r27, android.graphics.Bitmap r28, int r29) {
        /*
            r0 = r27
            r1 = r29
            int r2 = r28.getWidth()
            int r3 = r28.getHeight()
            boolean r4 = r0.f1726m
            android.graphics.Matrix r10 = new android.graphics.Matrix
            r10.<init>()
            boolean r5 = r27.mo27267c()
            if (r5 != 0) goto L_0x0021
            if (r1 == 0) goto L_0x001c
            goto L_0x0021
        L_0x001c:
            r6 = r2
            r8 = r3
            r3 = r10
            goto L_0x02a7
        L_0x0021:
            int r5 = r0.f1721h
            int r7 = r0.f1722i
            float r8 = r0.f1727n
            r9 = 0
            int r9 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r9 == 0) goto L_0x018a
            double r11 = (double) r8
            double r13 = java.lang.Math.toRadians(r11)
            double r13 = java.lang.Math.cos(r13)
            double r11 = java.lang.Math.toRadians(r11)
            double r11 = java.lang.Math.sin(r11)
            boolean r5 = r0.f1730q
            if (r5 == 0) goto L_0x0106
            float r5 = r0.f1728o
            float r7 = r0.f1729p
            r10.setRotate(r8, r5, r7)
            float r5 = r0.f1728o
            double r7 = (double) r5
            r15 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r15 = r15 - r13
            java.lang.Double.isNaN(r7)
            double r7 = r7 * r15
            float r9 = r0.f1729p
            r18 = r7
            double r6 = (double) r9
            java.lang.Double.isNaN(r6)
            double r6 = r6 * r11
            double r6 = r6 + r18
            double r8 = (double) r9
            java.lang.Double.isNaN(r8)
            double r8 = r8 * r15
            r15 = r4
            double r4 = (double) r5
            java.lang.Double.isNaN(r4)
            double r4 = r4 * r11
            double r8 = r8 - r4
            int r4 = r0.f1721h
            r16 = r2
            r18 = r3
            double r2 = (double) r4
            java.lang.Double.isNaN(r2)
            double r2 = r2 * r13
            double r2 = r2 + r6
            r19 = r2
            double r1 = (double) r4
            java.lang.Double.isNaN(r1)
            double r1 = r1 * r11
            double r1 = r1 + r8
            r21 = r1
            double r1 = (double) r4
            java.lang.Double.isNaN(r1)
            double r1 = r1 * r13
            double r1 = r1 + r6
            int r3 = r0.f1722i
            r23 = r6
            double r5 = (double) r3
            java.lang.Double.isNaN(r5)
            double r5 = r5 * r11
            double r1 = r1 - r5
            double r4 = (double) r4
            java.lang.Double.isNaN(r4)
            double r4 = r4 * r11
            double r4 = r4 + r8
            double r6 = (double) r3
            java.lang.Double.isNaN(r6)
            double r6 = r6 * r13
            double r6 = r6 + r4
            double r4 = (double) r3
            java.lang.Double.isNaN(r4)
            double r4 = r4 * r11
            double r4 = r23 - r4
            double r11 = (double) r3
            java.lang.Double.isNaN(r11)
            double r11 = r11 * r13
            double r11 = r11 + r8
            r3 = r10
            r13 = r23
            r23 = r6
            r25 = r11
            r10 = r19
            r19 = r25
            double r6 = java.lang.Math.max(r13, r10)
            double r6 = java.lang.Math.max(r1, r6)
            double r6 = java.lang.Math.max(r4, r6)
            double r10 = java.lang.Math.min(r13, r10)
            double r1 = java.lang.Math.min(r1, r10)
            double r1 = java.lang.Math.min(r4, r1)
            r4 = r21
            double r10 = java.lang.Math.max(r8, r4)
            r12 = r23
            double r10 = java.lang.Math.max(r12, r10)
            r21 = r15
            r14 = r19
            double r10 = java.lang.Math.max(r14, r10)
            double r4 = java.lang.Math.min(r8, r4)
            double r4 = java.lang.Math.min(r12, r4)
            double r4 = java.lang.Math.min(r14, r4)
            double r6 = r6 - r1
            double r1 = java.lang.Math.floor(r6)
            int r1 = (int) r1
            double r10 = r10 - r4
            double r4 = java.lang.Math.floor(r10)
            int r7 = (int) r4
            r5 = r1
            goto L_0x0191
        L_0x0106:
            r16 = r2
            r18 = r3
            r21 = r4
            r3 = r10
            r3.setRotate(r8)
            int r1 = r0.f1721h
            double r4 = (double) r1
            java.lang.Double.isNaN(r4)
            double r4 = r4 * r13
            double r6 = (double) r1
            java.lang.Double.isNaN(r6)
            double r6 = r6 * r11
            double r8 = (double) r1
            java.lang.Double.isNaN(r8)
            double r8 = r8 * r13
            int r2 = r0.f1722i
            r19 = r6
            double r6 = (double) r2
            java.lang.Double.isNaN(r6)
            double r6 = r6 * r11
            double r8 = r8 - r6
            double r6 = (double) r1
            java.lang.Double.isNaN(r6)
            double r6 = r6 * r11
            double r0 = (double) r2
            java.lang.Double.isNaN(r0)
            double r0 = r0 * r13
            double r0 = r0 + r6
            double r6 = (double) r2
            java.lang.Double.isNaN(r6)
            double r6 = r6 * r11
            double r6 = -r6
            double r10 = (double) r2
            java.lang.Double.isNaN(r10)
            double r10 = r10 * r13
            r12 = 0
            double r14 = java.lang.Math.max(r12, r4)
            double r14 = java.lang.Math.max(r8, r14)
            double r14 = java.lang.Math.max(r6, r14)
            double r4 = java.lang.Math.min(r12, r4)
            double r4 = java.lang.Math.min(r8, r4)
            double r4 = java.lang.Math.min(r6, r4)
            r6 = r19
            double r8 = java.lang.Math.max(r12, r6)
            double r8 = java.lang.Math.max(r0, r8)
            double r8 = java.lang.Math.max(r10, r8)
            double r6 = java.lang.Math.min(r12, r6)
            double r0 = java.lang.Math.min(r0, r6)
            double r0 = java.lang.Math.min(r10, r0)
            double r14 = r14 - r4
            double r4 = java.lang.Math.floor(r14)
            int r5 = (int) r4
            double r8 = r8 - r0
            double r0 = java.lang.Math.floor(r8)
            int r7 = (int) r0
            goto L_0x0191
        L_0x018a:
            r16 = r2
            r18 = r3
            r21 = r4
            r3 = r10
        L_0x0191:
            r0 = 5
            r1 = 2
            r2 = r29
            if (r2 == 0) goto L_0x01cd
            r4 = 270(0x10e, float:3.78E-43)
            r6 = 90
            switch(r2) {
                case 3: goto L_0x01a6;
                case 4: goto L_0x01a6;
                case 5: goto L_0x01a3;
                case 6: goto L_0x01a3;
                case 7: goto L_0x01a0;
                case 8: goto L_0x01a0;
                default: goto L_0x019e;
            }
        L_0x019e:
            r8 = 0
            goto L_0x01a8
        L_0x01a0:
            r8 = 270(0x10e, float:3.78E-43)
            goto L_0x01a8
        L_0x01a3:
            r8 = 90
            goto L_0x01a8
        L_0x01a6:
            r8 = 180(0xb4, float:2.52E-43)
        L_0x01a8:
            r9 = 1
            if (r2 == r1) goto L_0x01b5
            r10 = 7
            if (r2 == r10) goto L_0x01b5
            r10 = 4
            if (r2 == r10) goto L_0x01b5
            if (r2 == r0) goto L_0x01b5
            r2 = 1
            goto L_0x01b6
        L_0x01b5:
            r2 = -1
        L_0x01b6:
            if (r8 == 0) goto L_0x01c5
            float r10 = (float) r8
            r3.preRotate(r10)
            if (r8 == r6) goto L_0x01c0
            if (r8 != r4) goto L_0x01c5
        L_0x01c0:
            r25 = r7
            r7 = r5
            r5 = r25
        L_0x01c5:
            if (r2 == r9) goto L_0x01cd
            float r2 = (float) r2
            r4 = 1065353216(0x3f800000, float:1.0)
            r3.postScale(r2, r4)
        L_0x01cd:
            r2 = r27
            boolean r4 = r2.f1723j
            if (r4 == 0) goto L_0x025c
            if (r5 == 0) goto L_0x01dd
            float r4 = (float) r5
            r6 = r16
            float r8 = (float) r6
            float r4 = r4 / r8
            r8 = r18
            goto L_0x01e4
        L_0x01dd:
            r6 = r16
            float r4 = (float) r7
            r8 = r18
            float r9 = (float) r8
            float r4 = r4 / r9
        L_0x01e4:
            if (r7 == 0) goto L_0x01e9
            float r9 = (float) r7
            float r10 = (float) r8
            goto L_0x01eb
        L_0x01e9:
            float r9 = (float) r5
            float r10 = (float) r6
        L_0x01eb:
            float r9 = r9 / r10
            int r10 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r10 <= 0) goto L_0x0219
            float r0 = (float) r8
            float r9 = r9 / r4
            float r9 = r9 * r0
            double r9 = (double) r9
            double r9 = java.lang.Math.ceil(r9)
            int r0 = (int) r9
            int r2 = r2.f1724k
            r9 = r2 & 48
            r10 = 48
            if (r9 != r10) goto L_0x0204
            r1 = 0
            goto L_0x0210
        L_0x0204:
            r9 = 80
            r2 = r2 & r9
            if (r2 != r9) goto L_0x020c
            int r1 = r8 - r0
            goto L_0x0210
        L_0x020c:
            int r2 = r8 - r0
            int r1 = r2 / 2
        L_0x0210:
            float r2 = (float) r7
            float r9 = (float) r0
            float r9 = r2 / r9
            r2 = r1
            r1 = r6
            r10 = r21
            goto L_0x024b
        L_0x0219:
            int r10 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r10 >= 0) goto L_0x0245
            float r10 = (float) r6
            float r4 = r4 / r9
            float r4 = r4 * r10
            double r10 = (double) r4
            double r10 = java.lang.Math.ceil(r10)
            int r4 = (int) r10
            int r2 = r2.f1724k
            r10 = r2 & 3
            r11 = 3
            if (r10 != r11) goto L_0x0230
            r2 = 0
            goto L_0x0239
        L_0x0230:
            r2 = r2 & r0
            if (r2 != r0) goto L_0x0236
            int r2 = r6 - r4
            goto L_0x0239
        L_0x0236:
            int r2 = r6 - r4
            int r2 = r2 / r1
        L_0x0239:
            float r0 = (float) r5
            float r1 = (float) r4
            float r0 = r0 / r1
            r17 = r2
            r1 = r4
            r10 = r21
            r2 = 0
            r4 = r0
            r0 = r8
            goto L_0x024d
        L_0x0245:
            r1 = r6
            r0 = r8
            r4 = r9
            r10 = r21
            r2 = 0
        L_0x024b:
            r17 = 0
        L_0x024d:
            boolean r5 = m2025a((boolean) r10, (int) r6, (int) r8, (int) r5, (int) r7)
            if (r5 == 0) goto L_0x0256
            r3.preScale(r4, r9)
        L_0x0256:
            r9 = r0
            r8 = r1
            r7 = r2
            r6 = r17
            goto L_0x02ab
        L_0x025c:
            r6 = r16
            r8 = r18
            r10 = r21
            boolean r0 = r2.f1725l
            if (r0 == 0) goto L_0x0286
            if (r5 == 0) goto L_0x026b
            float r0 = (float) r5
            float r1 = (float) r6
            goto L_0x026d
        L_0x026b:
            float r0 = (float) r7
            float r1 = (float) r8
        L_0x026d:
            float r0 = r0 / r1
            if (r7 == 0) goto L_0x0273
            float r1 = (float) r7
            float r2 = (float) r8
            goto L_0x0275
        L_0x0273:
            float r1 = (float) r5
            float r2 = (float) r6
        L_0x0275:
            float r1 = r1 / r2
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r2 >= 0) goto L_0x027b
            goto L_0x027c
        L_0x027b:
            r0 = r1
        L_0x027c:
            boolean r1 = m2025a((boolean) r10, (int) r6, (int) r8, (int) r5, (int) r7)
            if (r1 == 0) goto L_0x02a7
            r3.preScale(r0, r0)
            goto L_0x02a7
        L_0x0286:
            if (r5 != 0) goto L_0x028a
            if (r7 == 0) goto L_0x02a7
        L_0x028a:
            if (r5 != r6) goto L_0x028e
            if (r7 == r8) goto L_0x02a7
        L_0x028e:
            if (r5 == 0) goto L_0x0293
            float r0 = (float) r5
            float r1 = (float) r6
            goto L_0x0295
        L_0x0293:
            float r0 = (float) r7
            float r1 = (float) r8
        L_0x0295:
            float r0 = r0 / r1
            if (r7 == 0) goto L_0x029b
            float r1 = (float) r7
            float r2 = (float) r8
            goto L_0x029d
        L_0x029b:
            float r1 = (float) r5
            float r2 = (float) r6
        L_0x029d:
            float r1 = r1 / r2
            boolean r2 = m2025a((boolean) r10, (int) r6, (int) r8, (int) r5, (int) r7)
            if (r2 == 0) goto L_0x02a7
            r3.preScale(r0, r1)
        L_0x02a7:
            r9 = r8
            r7 = 0
            r8 = r6
            r6 = 0
        L_0x02ab:
            r11 = 1
            r5 = r28
            r10 = r3
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r5, r6, r7, r8, r9, r10, r11)
            r1 = r28
            if (r0 == r1) goto L_0x02bb
            r28.recycle()
            goto L_0x02bc
        L_0x02bb:
            r0 = r1
        L_0x02bc:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.C1481c.m2020a(com.squareup.picasso.x, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }

    /* renamed from: a */
    static Bitmap m2021a(C1016z zVar, C1526x xVar) throws IOException {
        Intrinsics.checkParameterIsNotNull(zVar, "$this$buffer");
        C2085t tVar = new C2085t(zVar);
        boolean a = C1474G.m2012a((C2072h) tVar);
        boolean z = xVar.f1731r && Build.VERSION.SDK_INT < 21;
        BitmapFactory.Options b = C1530z.m2109b(xVar);
        boolean z2 = b != null && b.inJustDecodeBounds;
        if (a || z) {
            byte[] b2 = tVar.mo29149b();
            if (z2) {
                BitmapFactory.decodeByteArray(b2, 0, b2.length, b);
                C1530z.m2108a(xVar.f1721h, xVar.f1722i, b, xVar);
            }
            return BitmapFactory.decodeByteArray(b2, 0, b2.length, b);
        }
        InputStream n = tVar.mo29174n();
        if (z2) {
            C1504o oVar = new C1504o(n);
            oVar.mo27229a(false);
            long a2 = oVar.mo27228a(1024);
            BitmapFactory.decodeStream(oVar, (Rect) null, b);
            C1530z.m2108a(xVar.f1721h, xVar.f1722i, b, xVar);
            oVar.mo27232h(a2);
            oVar.mo27229a(true);
            n = oVar;
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(n, (Rect) null, b);
        if (decodeStream != null) {
            return decodeStream;
        }
        throw new IOException("Failed to decode stream.");
    }

    /* renamed from: a */
    static Bitmap m2022a(List<C1473F> list, Bitmap bitmap) {
        int size = list.size();
        int i = 0;
        while (i < size) {
            C1473F f = list.get(i);
            try {
                Bitmap transform = f.transform(bitmap);
                if (transform == null) {
                    StringBuilder a = C0681a.m330a("Transformation ");
                    a.append(f.key());
                    a.append(" returned null after ");
                    a.append(i);
                    a.append(" previous transformation(s).\n\nTransformation list:\n");
                    for (C1473F key : list) {
                        a.append(key.key());
                        a.append(10);
                    }
                    C1513u.f1671p.post(new C1485d(a));
                    return null;
                } else if (transform == bitmap && bitmap.isRecycled()) {
                    C1513u.f1671p.post(new C1486e(f));
                    return null;
                } else if (transform == bitmap || bitmap.isRecycled()) {
                    i++;
                    bitmap = transform;
                } else {
                    C1513u.f1671p.post(new C1487f(f));
                    return null;
                }
            } catch (RuntimeException e) {
                C1513u.f1671p.post(new C1484c(f, e));
                return null;
            }
        }
        return bitmap;
    }

    /* renamed from: a */
    private static boolean m2025a(boolean z, int i, int i2, int i3, int i4) {
        return !z || (i3 != 0 && i > i3) || (i4 != 0 && i2 > i4);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        r0 = r2.f1604p;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo27199a() {
        /*
            r2 = this;
            com.squareup.picasso.a r0 = r2.f1601m
            r1 = 0
            if (r0 != 0) goto L_0x001a
            java.util.List<com.squareup.picasso.a> r0 = r2.f1602n
            if (r0 == 0) goto L_0x000f
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x001a
        L_0x000f:
            java.util.concurrent.Future<?> r0 = r2.f1604p
            if (r0 == 0) goto L_0x001a
            boolean r0 = r0.cancel(r1)
            if (r0 == 0) goto L_0x001a
            r1 = 1
        L_0x001a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.C1481c.mo27199a():boolean");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* renamed from: b */
    android.graphics.Bitmap mo27200b() throws java.io.IOException {
        /*
            r9 = this;
            int r0 = r9.f1598h
            boolean r0 = com.squareup.picasso.C1507q.m2061a(r0)
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L_0x0035
            com.squareup.picasso.d r0 = r9.f1594d
            java.lang.String r3 = r9.f1596f
            android.graphics.Bitmap r0 = r0.get(r3)
            if (r0 == 0) goto L_0x0036
            com.squareup.picasso.B r2 = r9.f1595e
            android.os.Handler r2 = r2.f1539c
            r2.sendEmptyMessage(r1)
            com.squareup.picasso.u$e r1 = com.squareup.picasso.C1513u.C1519e.MEMORY
            r9.f1605q = r1
            com.squareup.picasso.u r1 = r9.f1592b
            boolean r1 = r1.f1686n
            if (r1 == 0) goto L_0x0034
            com.squareup.picasso.x r1 = r9.f1597g
            java.lang.String r1 = r1.mo27266b()
            java.lang.String r2 = "Hunter"
            java.lang.String r3 = "decoded"
            java.lang.String r4 = "from cache"
            com.squareup.picasso.C1474G.m2011a(r2, r3, r1, r4)
        L_0x0034:
            return r0
        L_0x0035:
            r0 = r2
        L_0x0036:
            int r3 = r9.f1608t
            if (r3 != 0) goto L_0x003f
            com.squareup.picasso.r r3 = com.squareup.picasso.C1508r.OFFLINE
            int r3 = r3.f1664a
            goto L_0x0041
        L_0x003f:
            int r3 = r9.f1599i
        L_0x0041:
            r9.f1599i = r3
            com.squareup.picasso.z r4 = r9.f1600l
            com.squareup.picasso.x r5 = r9.f1597g
            com.squareup.picasso.z$a r3 = r4.mo27173a((com.squareup.picasso.C1526x) r5, (int) r3)
            if (r3 == 0) goto L_0x0073
            com.squareup.picasso.u$e r0 = r3.mo27288c()
            r9.f1605q = r0
            int r0 = r3.mo27287b()
            r9.f1607s = r0
            android.graphics.Bitmap r0 = r3.mo27286a()
            if (r0 != 0) goto L_0x0073
            j.z r0 = r3.mo27289d()
            com.squareup.picasso.x r3 = r9.f1597g     // Catch:{ all -> 0x006e }
            android.graphics.Bitmap r3 = m2021a((p042j.C1016z) r0, (com.squareup.picasso.C1526x) r3)     // Catch:{ all -> 0x006e }
            r0.close()     // Catch:{ IOException -> 0x006c }
        L_0x006c:
            r0 = r3
            goto L_0x0073
        L_0x006e:
            r1 = move-exception
            r0.close()     // Catch:{ IOException -> 0x0072 }
        L_0x0072:
            throw r1
        L_0x0073:
            if (r0 == 0) goto L_0x0126
            com.squareup.picasso.u r3 = r9.f1592b
            boolean r3 = r3.f1686n
            if (r3 == 0) goto L_0x008a
            com.squareup.picasso.x r3 = r9.f1597g
            java.lang.String r3 = r3.mo27266b()
            java.lang.String r4 = "Hunter"
            java.lang.String r5 = "decoded"
            java.lang.String r6 = ""
            com.squareup.picasso.C1474G.m2011a(r4, r5, r3, r6)
        L_0x008a:
            com.squareup.picasso.B r3 = r9.f1595e
            if (r3 == 0) goto L_0x0125
            int r4 = com.squareup.picasso.C1474G.m2001a((android.graphics.Bitmap) r0)
            android.os.Handler r3 = r3.f1539c
            r5 = 2
            android.os.Message r4 = r3.obtainMessage(r5, r4, r1)
            r3.sendMessage(r4)
            com.squareup.picasso.x r3 = r9.f1597g
            boolean r4 = r3.mo27267c()
            r5 = 1
            if (r4 != 0) goto L_0x00b1
            java.util.List<com.squareup.picasso.F> r3 = r3.f1720g
            if (r3 == 0) goto L_0x00ab
            r3 = 1
            goto L_0x00ac
        L_0x00ab:
            r3 = 0
        L_0x00ac:
            if (r3 == 0) goto L_0x00af
            goto L_0x00b1
        L_0x00af:
            r3 = 0
            goto L_0x00b2
        L_0x00b1:
            r3 = 1
        L_0x00b2:
            if (r3 != 0) goto L_0x00b8
            int r3 = r9.f1607s
            if (r3 == 0) goto L_0x0126
        L_0x00b8:
            java.lang.Object r3 = f1587v
            monitor-enter(r3)
            com.squareup.picasso.x r4 = r9.f1597g     // Catch:{ all -> 0x0122 }
            boolean r4 = r4.mo27267c()     // Catch:{ all -> 0x0122 }
            if (r4 != 0) goto L_0x00c7
            int r4 = r9.f1607s     // Catch:{ all -> 0x0122 }
            if (r4 == 0) goto L_0x00e4
        L_0x00c7:
            com.squareup.picasso.x r4 = r9.f1597g     // Catch:{ all -> 0x0122 }
            int r6 = r9.f1607s     // Catch:{ all -> 0x0122 }
            android.graphics.Bitmap r0 = m2020a(r4, r0, r6)     // Catch:{ all -> 0x0122 }
            com.squareup.picasso.u r4 = r9.f1592b     // Catch:{ all -> 0x0122 }
            boolean r4 = r4.f1686n     // Catch:{ all -> 0x0122 }
            if (r4 == 0) goto L_0x00e4
            java.lang.String r4 = "Hunter"
            java.lang.String r6 = "transformed"
            com.squareup.picasso.x r7 = r9.f1597g     // Catch:{ all -> 0x0122 }
            java.lang.String r7 = r7.mo27266b()     // Catch:{ all -> 0x0122 }
            java.lang.String r8 = ""
            com.squareup.picasso.C1474G.m2011a(r4, r6, r7, r8)     // Catch:{ all -> 0x0122 }
        L_0x00e4:
            com.squareup.picasso.x r4 = r9.f1597g     // Catch:{ all -> 0x0122 }
            java.util.List<com.squareup.picasso.F> r4 = r4.f1720g     // Catch:{ all -> 0x0122 }
            if (r4 == 0) goto L_0x00eb
            goto L_0x00ec
        L_0x00eb:
            r5 = 0
        L_0x00ec:
            if (r5 == 0) goto L_0x010b
            com.squareup.picasso.x r4 = r9.f1597g     // Catch:{ all -> 0x0122 }
            java.util.List<com.squareup.picasso.F> r4 = r4.f1720g     // Catch:{ all -> 0x0122 }
            android.graphics.Bitmap r0 = m2022a((java.util.List<com.squareup.picasso.C1473F>) r4, (android.graphics.Bitmap) r0)     // Catch:{ all -> 0x0122 }
            com.squareup.picasso.u r4 = r9.f1592b     // Catch:{ all -> 0x0122 }
            boolean r4 = r4.f1686n     // Catch:{ all -> 0x0122 }
            if (r4 == 0) goto L_0x010b
            java.lang.String r4 = "Hunter"
            java.lang.String r5 = "transformed"
            com.squareup.picasso.x r6 = r9.f1597g     // Catch:{ all -> 0x0122 }
            java.lang.String r6 = r6.mo27266b()     // Catch:{ all -> 0x0122 }
            java.lang.String r7 = "from custom transformations"
            com.squareup.picasso.C1474G.m2011a(r4, r5, r6, r7)     // Catch:{ all -> 0x0122 }
        L_0x010b:
            monitor-exit(r3)     // Catch:{ all -> 0x0122 }
            if (r0 == 0) goto L_0x0126
            com.squareup.picasso.B r3 = r9.f1595e
            if (r3 == 0) goto L_0x0121
            int r2 = com.squareup.picasso.C1474G.m2001a((android.graphics.Bitmap) r0)
            android.os.Handler r3 = r3.f1539c
            r4 = 3
            android.os.Message r1 = r3.obtainMessage(r4, r2, r1)
            r3.sendMessage(r1)
            goto L_0x0126
        L_0x0121:
            throw r2
        L_0x0122:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0122 }
            throw r0
        L_0x0125:
            throw r2
        L_0x0126:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.C1481c.mo27200b():android.graphics.Bitmap");
    }

    public void run() {
        Handler handler;
        try {
            m2024a(this.f1597g);
            if (this.f1592b.f1686n) {
                C1474G.m2011a("Hunter", "executing", C1474G.m2006a(this), "");
            }
            Bitmap b = mo27200b();
            this.f1603o = b;
            if (b == null) {
                this.f1593c.mo27221b(this);
            } else {
                this.f1593c.mo27219a(this);
            }
        } catch (C1509s.C1511b e) {
            if (!((e.f1668b & C1508r.OFFLINE.f1664a) != 0) || e.f1667a != 504) {
                this.f1606r = e;
            }
            handler = this.f1593c.f1629i;
        } catch (IOException e2) {
            this.f1606r = e2;
            Handler handler2 = this.f1593c.f1629i;
            handler2.sendMessageDelayed(handler2.obtainMessage(5, this), 500);
        } catch (OutOfMemoryError e3) {
            StringWriter stringWriter = new StringWriter();
            this.f1595e.mo27175a().mo27178a(new PrintWriter(stringWriter));
            this.f1606r = new RuntimeException(stringWriter.toString(), e3);
            handler = this.f1593c.f1629i;
        } catch (Exception e4) {
            this.f1606r = e4;
            handler = this.f1593c.f1629i;
        } catch (Throwable th) {
            Thread.currentThread().setName("Picasso-Idle");
            throw th;
        }
        Thread.currentThread().setName("Picasso-Idle");
        handler.sendMessage(handler.obtainMessage(6, this));
        Thread.currentThread().setName("Picasso-Idle");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27198a(C1478a aVar) {
        boolean z;
        boolean z2 = true;
        if (this.f1601m == aVar) {
            this.f1601m = null;
            z = true;
        } else {
            List<C1478a> list = this.f1602n;
            z = list != null ? list.remove(aVar) : false;
        }
        if (z && aVar.f1572b.f1733t == this.f1609u) {
            C1513u.C1520f fVar = C1513u.C1520f.LOW;
            List<C1478a> list2 = this.f1602n;
            boolean z3 = list2 != null && !list2.isEmpty();
            if (this.f1601m == null && !z3) {
                z2 = false;
            }
            if (z2) {
                C1478a aVar2 = this.f1601m;
                if (aVar2 != null) {
                    fVar = aVar2.f1572b.f1733t;
                }
                if (z3) {
                    int size = this.f1602n.size();
                    for (int i = 0; i < size; i++) {
                        C1513u.C1520f fVar2 = this.f1602n.get(i).f1572b.f1733t;
                        if (fVar2.ordinal() > fVar.ordinal()) {
                            fVar = fVar2;
                        }
                    }
                }
            }
            this.f1609u = fVar;
        }
        if (this.f1592b.f1686n) {
            C1474G.m2011a("Hunter", "removed", aVar.f1572b.mo27266b(), C1474G.m2007a(this, "from "));
        }
    }

    /* renamed from: a */
    static C1481c m2023a(C1513u uVar, C1493i iVar, C1488d dVar, C1467B b, C1478a aVar) {
        C1526x xVar = aVar.f1572b;
        List<C1530z> a = uVar.mo27246a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            C1530z zVar = a.get(i);
            if (zVar.mo27174a(xVar)) {
                return new C1481c(uVar, iVar, dVar, b, aVar, zVar);
            }
        }
        return new C1481c(uVar, iVar, dVar, b, aVar, f1590y);
    }

    /* renamed from: a */
    static void m2024a(C1526x xVar) {
        Uri uri = xVar.f1717d;
        String valueOf = uri != null ? String.valueOf(uri.getPath()) : Integer.toHexString(xVar.f1718e);
        StringBuilder sb = f1588w.get();
        sb.ensureCapacity(valueOf.length() + 8);
        sb.replace(8, sb.length(), valueOf);
        Thread.currentThread().setName(sb.toString());
    }
}
