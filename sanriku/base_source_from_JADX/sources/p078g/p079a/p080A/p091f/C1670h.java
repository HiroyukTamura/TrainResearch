package p078g.p079a.p080A.p091f;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: g.a.A.f.h */
public final class C1670h {

    /* renamed from: a */
    public static final boolean f2008a;

    /* renamed from: b */
    public static final int f2009b;

    /* renamed from: c */
    static final AtomicReference<ScheduledExecutorService> f2010c = new AtomicReference<>();

    /* renamed from: d */
    static final Map<ScheduledThreadPoolExecutor, Object> f2011d = new ConcurrentHashMap();

    /* renamed from: g.a.A.f.h$a */
    static final class C1671a implements Runnable {
        C1671a() {
        }

        public void run() {
            Iterator it = new ArrayList(C1670h.f2011d.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    C1670h.f2011d.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0026 A[SYNTHETIC, Splitter:B:10:0x0026] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0039 A[LOOP:0: B:19:0x0039->B:24:0x0066, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    static {
        /*
            java.util.concurrent.atomic.AtomicReference r0 = new java.util.concurrent.atomic.AtomicReference
            r0.<init>()
            f2010c = r0
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
            r0.<init>()
            f2011d = r0
            java.lang.String r0 = "rx2.purge-enabled"
            r1 = 1
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch:{ all -> 0x001f }
            if (r0 != 0) goto L_0x0018
            goto L_0x001f
        L_0x0018:
            java.lang.String r2 = "true"
            boolean r0 = r2.equals(r0)     // Catch:{ all -> 0x001f }
            goto L_0x0020
        L_0x001f:
            r0 = 1
        L_0x0020:
            f2008a = r0
            java.lang.String r2 = "rx2.purge-period-seconds"
            if (r0 == 0) goto L_0x0032
            java.lang.String r0 = java.lang.System.getProperty(r2)     // Catch:{ all -> 0x0032 }
            if (r0 != 0) goto L_0x002d
            goto L_0x0032
        L_0x002d:
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x0032 }
            goto L_0x0033
        L_0x0032:
            r0 = 1
        L_0x0033:
            f2009b = r0
            boolean r0 = f2008a
            if (r0 == 0) goto L_0x006a
        L_0x0039:
            java.util.concurrent.atomic.AtomicReference<java.util.concurrent.ScheduledExecutorService> r0 = f2010c
            java.lang.Object r0 = r0.get()
            java.util.concurrent.ScheduledExecutorService r0 = (java.util.concurrent.ScheduledExecutorService) r0
            if (r0 == 0) goto L_0x0044
            goto L_0x006a
        L_0x0044:
            g.a.A.f.e r2 = new g.a.A.f.e
            java.lang.String r3 = "RxSchedulerPurge"
            r2.<init>(r3)
            java.util.concurrent.ScheduledExecutorService r4 = java.util.concurrent.Executors.newScheduledThreadPool(r1, r2)
            java.util.concurrent.atomic.AtomicReference<java.util.concurrent.ScheduledExecutorService> r2 = f2010c
            boolean r0 = r2.compareAndSet(r0, r4)
            if (r0 == 0) goto L_0x0066
            g.a.A.f.h$a r5 = new g.a.A.f.h$a
            r5.<init>()
            int r0 = f2009b
            long r8 = (long) r0
            java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.SECONDS
            r6 = r8
            r4.scheduleAtFixedRate(r5, r6, r8, r10)
            goto L_0x006a
        L_0x0066:
            r4.shutdownNow()
            goto L_0x0039
        L_0x006a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p078g.p079a.p080A.p091f.C1670h.<clinit>():void");
    }

    /* renamed from: a */
    public static ScheduledExecutorService m2352a(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (f2008a && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            f2011d.put((ScheduledThreadPoolExecutor) newScheduledThreadPool, newScheduledThreadPool);
        }
        return newScheduledThreadPool;
    }
}
