package p078g.p079a.p080A.p091f;

import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import p078g.p079a.C1711q;
import p078g.p079a.p080A.p081a.C1587a;
import p078g.p079a.p080A.p081a.C1589c;
import p078g.p079a.p080A.p082b.C1599b;
import p078g.p079a.p093B.C1682a;
import p078g.p079a.p098x.C1727b;

/* renamed from: g.a.A.f.d */
public class C1665d extends C1711q.C1713b implements C1727b {

    /* renamed from: a */
    private final ScheduledExecutorService f1994a;

    /* renamed from: b */
    volatile boolean f1995b;

    public C1665d(ThreadFactory threadFactory) {
        this.f1994a = C1670h.m2352a(threadFactory);
    }

    /* renamed from: a */
    public C1669g mo27395a(Runnable runnable, long j, TimeUnit timeUnit, C1587a aVar) {
        Future future;
        C1599b.m2241a(runnable, "run is null");
        C1669g gVar = new C1669g(runnable, aVar);
        if (aVar != null && !aVar.mo27348b(gVar)) {
            return gVar;
        }
        if (j <= 0) {
            try {
                future = this.f1994a.submit(gVar);
            } catch (RejectedExecutionException e) {
                if (aVar != null) {
                    aVar.mo27347a(gVar);
                }
                C1682a.m2372a((Throwable) e);
            }
        } else {
            future = this.f1994a.schedule(gVar, j, timeUnit);
        }
        gVar.mo27402a(future);
        return gVar;
    }

    /* JADX WARNING: type inference failed for: r7v2, types: [g.a.A.a.c, g.a.x.b] */
    /* renamed from: a */
    public C1727b mo27387a(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.f1995b ? C1589c.INSTANCE : mo27395a(runnable, j, timeUnit, (C1587a) null);
    }

    /* renamed from: a */
    public boolean mo27340a() {
        return this.f1995b;
    }

    /* JADX WARNING: type inference failed for: r4v6, types: [g.a.A.a.c, g.a.x.b] */
    /* renamed from: b */
    public C1727b mo27396b(Runnable runnable, long j, TimeUnit timeUnit) {
        Future future;
        C1599b.m2241a(runnable, "run is null");
        C1668f fVar = new C1668f(runnable);
        if (j <= 0) {
            try {
                future = this.f1994a.submit(fVar);
            } catch (RejectedExecutionException e) {
                C1682a.m2372a((Throwable) e);
                return C1589c.INSTANCE;
            }
        } else {
            future = this.f1994a.schedule(fVar, j, timeUnit);
        }
        fVar.mo27400a(future);
        return fVar;
    }

    /* renamed from: b */
    public void mo27341b() {
        if (!this.f1995b) {
            this.f1995b = true;
            this.f1994a.shutdownNow();
        }
    }

    /* renamed from: c */
    public void mo27397c() {
        if (!this.f1995b) {
            this.f1995b = true;
            this.f1994a.shutdown();
        }
    }
}
