package p078g.p079a.p080A.p091f;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p078g.p079a.C1711q;
import p078g.p079a.p080A.p081a.C1589c;
import p078g.p079a.p080A.p082b.C1599b;
import p078g.p079a.p093B.C1682a;
import p078g.p079a.p098x.C1726a;
import p078g.p079a.p098x.C1727b;

/* renamed from: g.a.A.f.i */
public final class C1672i extends C1711q {

    /* renamed from: b */
    static final C1666e f2012b = new C1666e("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);

    /* renamed from: c */
    static final ScheduledExecutorService f2013c;

    /* renamed from: a */
    final AtomicReference<ScheduledExecutorService> f2014a;

    /* renamed from: g.a.A.f.i$a */
    static final class C1673a extends C1711q.C1713b {

        /* renamed from: a */
        final ScheduledExecutorService f2015a;

        /* renamed from: b */
        final C1726a f2016b = new C1726a();

        /* renamed from: c */
        volatile boolean f2017c;

        C1673a(ScheduledExecutorService scheduledExecutorService) {
            this.f2015a = scheduledExecutorService;
        }

        /* JADX WARNING: type inference failed for: r4v7, types: [g.a.A.a.c, g.a.x.b] */
        /* JADX WARNING: type inference failed for: r4v10, types: [g.a.A.a.c, g.a.x.b] */
        /* renamed from: a */
        public C1727b mo27387a(Runnable runnable, long j, TimeUnit timeUnit) {
            Future future;
            if (this.f2017c) {
                return C1589c.INSTANCE;
            }
            C1599b.m2241a(runnable, "run is null");
            C1669g gVar = new C1669g(runnable, this.f2016b);
            this.f2016b.mo27348b(gVar);
            if (j <= 0) {
                try {
                    future = this.f2015a.submit(gVar);
                } catch (RejectedExecutionException e) {
                    mo27341b();
                    C1682a.m2372a((Throwable) e);
                    return C1589c.INSTANCE;
                }
            } else {
                future = this.f2015a.schedule(gVar, j, timeUnit);
            }
            gVar.mo27402a(future);
            return gVar;
        }

        /* renamed from: a */
        public boolean mo27340a() {
            return this.f2017c;
        }

        /* renamed from: b */
        public void mo27341b() {
            if (!this.f2017c) {
                this.f2017c = true;
                this.f2016b.mo27341b();
            }
        }
    }

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f2013c = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
    }

    public C1672i() {
        C1666e eVar = f2012b;
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.f2014a = atomicReference;
        atomicReference.lazySet(C1670h.m2352a(eVar));
    }

    /* renamed from: a */
    public C1711q.C1713b mo27385a() {
        return new C1673a(this.f2014a.get());
    }

    /* JADX WARNING: type inference failed for: r4v8, types: [g.a.A.a.c, g.a.x.b] */
    /* renamed from: a */
    public C1727b mo27386a(Runnable runnable, long j, TimeUnit timeUnit) {
        Future future;
        C1599b.m2241a(runnable, "run is null");
        C1668f fVar = new C1668f(runnable);
        if (j <= 0) {
            try {
                future = this.f2014a.get().submit(fVar);
            } catch (RejectedExecutionException e) {
                C1682a.m2372a((Throwable) e);
                return C1589c.INSTANCE;
            }
        } else {
            future = this.f2014a.get().schedule(fVar, j, timeUnit);
        }
        fVar.mo27400a(future);
        return fVar;
    }
}
