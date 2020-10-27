package com.squareup.picasso;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.StatFs;
import android.support.p001v4.media.session.PlaybackStateCompat;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import p009e.p010a.p011a.p012a.C0681a;
import p042j.C2072h;
import p042j.C2073i;

/* renamed from: com.squareup.picasso.G */
final class C1474G {

    /* renamed from: a */
    static final StringBuilder f1567a = new StringBuilder();

    /* renamed from: b */
    private static final C2073i f1568b = C2073i.f2895e.mo29221b("RIFF");

    /* renamed from: c */
    private static final C2073i f1569c = C2073i.f2895e.mo29221b("WEBP");

    /* renamed from: com.squareup.picasso.G$a */
    static class C1475a extends Handler {
        C1475a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            sendMessageDelayed(obtainMessage(), 1000);
        }
    }

    /* renamed from: com.squareup.picasso.G$b */
    private static class C1476b extends Thread {
        C1476b(Runnable runnable) {
            super(runnable);
        }

        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    /* renamed from: com.squareup.picasso.G$c */
    static class C1477c implements ThreadFactory {
        C1477c() {
        }

        public Thread newThread(Runnable runnable) {
            return new C1476b(runnable);
        }
    }

    /* renamed from: a */
    static int m2000a(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        return (int) ((((long) ((context.getApplicationInfo().flags & 1048576) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass())) * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) / 7);
    }

    /* renamed from: a */
    static int m2001a(Bitmap bitmap) {
        int allocationByteCount = bitmap.getAllocationByteCount();
        if (allocationByteCount >= 0) {
            return allocationByteCount;
        }
        throw new IllegalStateException("Negative size: " + bitmap);
    }

    @TargetApi(18)
    /* renamed from: a */
    static long m2002a(File file) {
        long j;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            j = (statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / 50;
        } catch (IllegalArgumentException unused) {
            j = 5242880;
        }
        return Math.max(Math.min(j, 52428800), 5242880);
    }

    /* renamed from: a */
    static Resources m2003a(Context context, C1526x xVar) throws FileNotFoundException {
        Uri uri;
        if (xVar.f1718e != 0 || (uri = xVar.f1717d) == null) {
            return context.getResources();
        }
        String authority = uri.getAuthority();
        if (authority != null) {
            try {
                return context.getPackageManager().getResourcesForApplication(authority);
            } catch (PackageManager.NameNotFoundException unused) {
                StringBuilder a = C0681a.m330a("Unable to obtain resources for package: ");
                a.append(xVar.f1717d);
                throw new FileNotFoundException(a.toString());
            }
        } else {
            StringBuilder a2 = C0681a.m330a("No package provided: ");
            a2.append(xVar.f1717d);
            throw new FileNotFoundException(a2.toString());
        }
    }

    /* renamed from: a */
    static <T> T m2004a(Context context, String str) {
        return context.getSystemService(str);
    }

    /* renamed from: a */
    static <T> T m2005a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* renamed from: a */
    static String m2006a(C1481c cVar) {
        return m2007a(cVar, "");
    }

    /* renamed from: a */
    static void m2010a(Looper looper) {
        C1475a aVar = new C1475a(looper);
        aVar.sendMessageDelayed(aVar.obtainMessage(), 1000);
    }

    /* renamed from: a */
    static void m2011a(String str, String str2, String str3, String str4) {
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", new Object[]{str, str2, str3, str4}));
    }

    /* renamed from: a */
    static boolean m2012a(C2072h hVar) throws IOException {
        return hVar.mo29145a(0, f1568b) && hVar.mo29145a(8, f1569c);
    }

    /* renamed from: b */
    static File m2013b(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* renamed from: a */
    static void m2009a() {
        if (!(Looper.getMainLooper().getThread() == Thread.currentThread())) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String m2008a(com.squareup.picasso.C1526x r6) {
        /*
            java.lang.StringBuilder r0 = f1567a
            java.lang.String r1 = r6.f1719f
            r2 = 50
            if (r1 == 0) goto L_0x0013
            int r1 = r1.length()
            int r1 = r1 + r2
            r0.ensureCapacity(r1)
            java.lang.String r1 = r6.f1719f
            goto L_0x0023
        L_0x0013:
            android.net.Uri r1 = r6.f1717d
            if (r1 == 0) goto L_0x0027
            java.lang.String r1 = r1.toString()
            int r3 = r1.length()
            int r3 = r3 + r2
            r0.ensureCapacity(r3)
        L_0x0023:
            r0.append(r1)
            goto L_0x002f
        L_0x0027:
            r0.ensureCapacity(r2)
            int r1 = r6.f1718e
            r0.append(r1)
        L_0x002f:
            r1 = 10
            r0.append(r1)
            float r2 = r6.f1727n
            r3 = 0
            r4 = 120(0x78, float:1.68E-43)
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0060
            java.lang.String r2 = "rotation:"
            r0.append(r2)
            float r2 = r6.f1727n
            r0.append(r2)
            boolean r2 = r6.f1730q
            if (r2 == 0) goto L_0x005d
            r2 = 64
            r0.append(r2)
            float r2 = r6.f1728o
            r0.append(r2)
            r0.append(r4)
            float r2 = r6.f1729p
            r0.append(r2)
        L_0x005d:
            r0.append(r1)
        L_0x0060:
            boolean r2 = r6.mo27265a()
            if (r2 == 0) goto L_0x007b
            java.lang.String r2 = "resize:"
            r0.append(r2)
            int r2 = r6.f1721h
            r0.append(r2)
            r0.append(r4)
            int r2 = r6.f1722i
            r0.append(r2)
            r0.append(r1)
        L_0x007b:
            boolean r2 = r6.f1723j
            if (r2 == 0) goto L_0x008a
            java.lang.String r2 = "centerCrop:"
            r0.append(r2)
            int r2 = r6.f1724k
            r0.append(r2)
            goto L_0x0093
        L_0x008a:
            boolean r2 = r6.f1725l
            if (r2 == 0) goto L_0x0096
            java.lang.String r2 = "centerInside"
            r0.append(r2)
        L_0x0093:
            r0.append(r1)
        L_0x0096:
            java.util.List<com.squareup.picasso.F> r2 = r6.f1720g
            r3 = 0
            if (r2 == 0) goto L_0x00b7
            int r2 = r2.size()
            r4 = 0
        L_0x00a0:
            if (r4 >= r2) goto L_0x00b7
            java.util.List<com.squareup.picasso.F> r5 = r6.f1720g
            java.lang.Object r5 = r5.get(r4)
            com.squareup.picasso.F r5 = (com.squareup.picasso.C1473F) r5
            java.lang.String r5 = r5.key()
            r0.append(r5)
            r0.append(r1)
            int r4 = r4 + 1
            goto L_0x00a0
        L_0x00b7:
            java.lang.String r6 = r0.toString()
            java.lang.StringBuilder r0 = f1567a
            r0.setLength(r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.C1474G.m2008a(com.squareup.picasso.x):java.lang.String");
    }

    /* renamed from: a */
    static String m2007a(C1481c cVar, String str) {
        StringBuilder sb = new StringBuilder(str);
        C1478a aVar = cVar.f1601m;
        if (aVar != null) {
            sb.append(aVar.f1572b.mo27266b());
        }
        List<C1478a> list = cVar.f1602n;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (i > 0 || aVar != null) {
                    sb.append(", ");
                }
                sb.append(list.get(i).f1572b.mo27266b());
            }
        }
        return sb.toString();
    }
}
