package com.squareup.picasso;

import android.content.Context;
import android.net.Uri;
import com.google.firebase.analytics.FirebaseAnalytics;

/* renamed from: com.squareup.picasso.p */
class C1505p extends C1491g {

    /* renamed from: b */
    private static final String[] f1651b = {"orientation"};

    /* renamed from: com.squareup.picasso.p$a */
    enum C1506a {
        MICRO(3, 96, 96),
        MINI(1, 512, 384),
        FULL(2, -1, -1);
        

        /* renamed from: a */
        final int f1655a;

        /* renamed from: b */
        final int f1656b;

        /* renamed from: c */
        final int f1657c;

        static {
            MICRO = new C1506a("MICRO", 0, 3, 96, 96);
            MINI = new C1506a("MINI", 1, 1, 512, 384);
            FULL = new C1506a("FULL", 2, 2, -1, -1);
        }

        private C1506a(int i, int i2, int i3) {
            this.f1655a = i;
            this.f1656b = i2;
            this.f1657c = i3;
        }
    }

    C1505p(Context context) {
        super(context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        if (r3 != null) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003a, code lost:
        if (r3 != null) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003c, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003f, code lost:
        r8 = 0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0035  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.squareup.picasso.C1530z.C1531a mo27173a(com.squareup.picasso.C1526x r17, int r18) throws java.io.IOException {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            android.content.Context r2 = r1.f1617a
            android.content.ContentResolver r9 = r2.getContentResolver()
            android.net.Uri r4 = r0.f1717d
            r2 = 0
            r10 = 0
            java.lang.String[] r5 = f1651b     // Catch:{ RuntimeException -> 0x0039, all -> 0x0032 }
            r6 = 0
            r7 = 0
            r8 = 0
            r3 = r9
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ RuntimeException -> 0x0039, all -> 0x0032 }
            if (r3 == 0) goto L_0x002f
            boolean r4 = r3.moveToFirst()     // Catch:{ RuntimeException -> 0x002d, all -> 0x002a }
            if (r4 != 0) goto L_0x0021
            goto L_0x002f
        L_0x0021:
            int r4 = r3.getInt(r2)     // Catch:{ RuntimeException -> 0x002d, all -> 0x002a }
            r3.close()
            r8 = r4
            goto L_0x0040
        L_0x002a:
            r0 = move-exception
            r10 = r3
            goto L_0x0033
        L_0x002d:
            goto L_0x003a
        L_0x002f:
            if (r3 == 0) goto L_0x003f
            goto L_0x003c
        L_0x0032:
            r0 = move-exception
        L_0x0033:
            if (r10 == 0) goto L_0x0038
            r10.close()
        L_0x0038:
            throw r0
        L_0x0039:
            r3 = r10
        L_0x003a:
            if (r3 == 0) goto L_0x003f
        L_0x003c:
            r3.close()
        L_0x003f:
            r8 = 0
        L_0x0040:
            android.net.Uri r3 = r0.f1717d
            java.lang.String r3 = r9.getType(r3)
            r11 = 1
            if (r3 == 0) goto L_0x0053
            java.lang.String r4 = "video/"
            boolean r3 = r3.startsWith(r4)
            if (r3 == 0) goto L_0x0053
            r12 = 1
            goto L_0x0054
        L_0x0053:
            r12 = 0
        L_0x0054:
            boolean r2 = r17.mo27265a()
            if (r2 == 0) goto L_0x00cf
            int r2 = r0.f1721h
            int r3 = r0.f1722i
            com.squareup.picasso.p$a r4 = com.squareup.picasso.C1505p.C1506a.MICRO
            int r5 = r4.f1656b
            if (r2 > r5) goto L_0x0069
            int r5 = r4.f1657c
            if (r3 > r5) goto L_0x0069
        L_0x0068:
            goto L_0x0076
        L_0x0069:
            com.squareup.picasso.p$a r4 = com.squareup.picasso.C1505p.C1506a.MINI
            int r5 = r4.f1656b
            if (r2 > r5) goto L_0x0074
            int r2 = r4.f1657c
            if (r3 > r2) goto L_0x0074
            goto L_0x0068
        L_0x0074:
            com.squareup.picasso.p$a r4 = com.squareup.picasso.C1505p.C1506a.FULL
        L_0x0076:
            r13 = r4
            if (r12 != 0) goto L_0x0095
            com.squareup.picasso.p$a r2 = com.squareup.picasso.C1505p.C1506a.FULL
            if (r13 != r2) goto L_0x0095
            android.content.Context r2 = r1.f1617a
            android.content.ContentResolver r2 = r2.getContentResolver()
            android.net.Uri r0 = r0.f1717d
            java.io.InputStream r0 = r2.openInputStream(r0)
            j.z r0 = p042j.C2080p.m3583a((java.io.InputStream) r0)
            com.squareup.picasso.z$a r2 = new com.squareup.picasso.z$a
            com.squareup.picasso.u$e r3 = com.squareup.picasso.C1513u.C1519e.DISK
            r2.<init>(r10, r0, r3, r8)
            return r2
        L_0x0095:
            android.net.Uri r2 = r0.f1717d
            long r14 = android.content.ContentUris.parseId(r2)
            android.graphics.BitmapFactory$Options r7 = com.squareup.picasso.C1530z.m2109b(r17)
            r7.inJustDecodeBounds = r11
            int r2 = r0.f1721h
            int r3 = r0.f1722i
            int r4 = r13.f1656b
            int r5 = r13.f1657c
            r6 = r7
            r11 = r7
            r7 = r17
            com.squareup.picasso.C1530z.m2107a(r2, r3, r4, r5, r6, r7)
            if (r12 == 0) goto L_0x00bf
            com.squareup.picasso.p$a r2 = com.squareup.picasso.C1505p.C1506a.FULL
            if (r13 != r2) goto L_0x00b8
            r2 = 1
            goto L_0x00ba
        L_0x00b8:
            int r2 = r13.f1655a
        L_0x00ba:
            android.graphics.Bitmap r2 = android.provider.MediaStore.Video.Thumbnails.getThumbnail(r9, r14, r2, r11)
            goto L_0x00c5
        L_0x00bf:
            int r2 = r13.f1655a
            android.graphics.Bitmap r2 = android.provider.MediaStore.Images.Thumbnails.getThumbnail(r9, r14, r2, r11)
        L_0x00c5:
            if (r2 == 0) goto L_0x00cf
            com.squareup.picasso.z$a r0 = new com.squareup.picasso.z$a
            com.squareup.picasso.u$e r3 = com.squareup.picasso.C1513u.C1519e.DISK
            r0.<init>(r2, r10, r3, r8)
            return r0
        L_0x00cf:
            android.content.Context r2 = r1.f1617a
            android.content.ContentResolver r2 = r2.getContentResolver()
            android.net.Uri r0 = r0.f1717d
            java.io.InputStream r0 = r2.openInputStream(r0)
            j.z r0 = p042j.C2080p.m3583a((java.io.InputStream) r0)
            com.squareup.picasso.z$a r2 = new com.squareup.picasso.z$a
            com.squareup.picasso.u$e r3 = com.squareup.picasso.C1513u.C1519e.DISK
            r2.<init>(r10, r0, r3, r8)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.C1505p.mo27173a(com.squareup.picasso.x, int):com.squareup.picasso.z$a");
    }

    /* renamed from: a */
    public boolean mo27174a(C1526x xVar) {
        Uri uri = xVar.f1717d;
        return FirebaseAnalytics.Param.CONTENT.equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }
}
