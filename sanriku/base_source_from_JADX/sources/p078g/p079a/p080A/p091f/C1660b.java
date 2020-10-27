package p078g.p079a.p080A.p091f;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p078g.p079a.C1711q;
import p078g.p079a.p080A.p081a.C1589c;
import p078g.p079a.p098x.C1726a;
import p078g.p079a.p098x.C1727b;

/* renamed from: g.a.A.f.b */
public final class C1660b extends C1711q {

    /* renamed from: c */
    static final C1666e f1973c;

    /* renamed from: d */
    static final C1666e f1974d;

    /* renamed from: e */
    private static final long f1975e = Long.getLong("rx2.io-keep-alive-time", 60).longValue();

    /* renamed from: f */
    private static final TimeUnit f1976f = TimeUnit.SECONDS;

    /* renamed from: g */
    static final C1663c f1977g;

    /* renamed from: h */
    static final C1661a f1978h;

    /* renamed from: a */
    final ThreadFactory f1979a = f1973c;

    /* renamed from: b */
    final AtomicReference<C1661a> f1980b = new AtomicReference<>(f1978h);

    /* renamed from: g.a.A.f.b$a */
    static final class C1661a implements Runnable {

        /* renamed from: a */
        private final long f1981a;

        /* renamed from: b */
        private final ConcurrentLinkedQueue<C1663c> f1982b;

        /* renamed from: c */
        final C1726a f1983c;

        /* renamed from: d */
        private final ScheduledExecutorService f1984d;

        /* renamed from: e */
        private final Future<?> f1985e;

        /* renamed from: f */
        private final ThreadFactory f1986f;

        C1661a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            this.f1981a = timeUnit != null ? timeUnit.toNanos(j) : 0;
            this.f1982b = new ConcurrentLinkedQueue<>();
            this.f1983c = new C1726a();
            this.f1986f = threadFactory;
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, C1660b.f1974d);
                long j2 = this.f1981a;
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, j2, j2, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f1984d = scheduledExecutorService;
            this.f1985e = scheduledFuture;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C1663c mo27389a() {
            if (this.f1983c.mo27340a()) {
                return C1660b.f1977g;
            }
            while (!this.f1982b.isEmpty()) {
                C1663c poll = this.f1982b.poll();
                if (poll != null) {
                    return poll;
                }
            }
            C1663c cVar = new C1663c(this.f1986f);
            this.f1983c.mo27348b(cVar);
            return cVar;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo27390a(C1663c cVar) {
            cVar.mo27393a(System.nanoTime() + this.f1981a);
            this.f1982b.offer(cVar);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo27391b() {
            this.f1983c.mo27341b();
            Future<?> future = this.f1985e;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f1984d;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        public void run() {
            if (!this.f1982b.isEmpty()) {
                long nanoTime = System.nanoTime();
                Iterator<C1663c> it = this.f1982b.iterator();
                while (it.hasNext()) {
                    C1663c next = it.next();
                    if (next.mo27394d() > nanoTime) {
                        return;
                    }
                    if (this.f1982b.remove(next) && this.f1983c.mo27349c(next)) {
                        next.mo27341b();
                    }
                }
            }
        }
    }

    /* renamed from: g.a.A.f.b$b */
    static final class C1662b extends C1711q.C1713b {

        /* renamed from: a */
        private final C1726a f1987a;

        /* renamed from: b */
        private final C1661a f1988b;

        /* renamed from: c */
        private final C1663c f1989c;

        /* renamed from: d */
        final AtomicBoolean f1990d = new AtomicBoolean();

        C1662b(C1661a aVar) {
            this.f1988b = aVar;
            this.f1987a = new C1726a();
            this.f1989c = aVar.mo27389a();
        }

        /* JADX WARNING: type inference failed for: r7v2, types: [g.a.A.a.c, g.a.x.b] */
        /* renamed from: a */
        public C1727b mo27387a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.f1987a.mo27340a()) {
                return C1589c.INSTANCE;
            }
            return this.f1989c.mo27395a(runnable, j, timeUnit, this.f1987a);
        }

        /* renamed from: a */
        public boolean mo27340a() {
            return this.f1990d.get();
        }

        /* renamed from: b */
        public void mo27341b() {
            if (this.f1990d.compareAndSet(false, true)) {
                this.f1987a.mo27341b();
                this.f1988b.mo27390a(this.f1989c);
            }
        }
    }

    /* renamed from: g.a.A.f.b$c */
    static final class C1663c extends C1665d {

        /* renamed from: c */
        private long f1991c = 0;

        C1663c(ThreadFactory threadFactory) {
            super(threadFactory);
        }

        /* renamed from: a */
        public void mo27393a(long j) {
            this.f1991c = j;
        }

        /* renamed from: d */
        public long mo27394d() {
            return this.f1991c;
        }
    }

    static {
        C1663c cVar = new C1663c(new C1666e("RxCachedThreadSchedulerShutdown"));
        f1977g = cVar;
        cVar.mo27341b();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        f1973c = new C1666e("RxCachedThreadScheduler", max);
        f1974d = new C1666e("RxCachedWorkerPoolEvictor", max);
        C1661a aVar = new C1661a(0, (TimeUnit) null, f1973c);
        f1978h = aVar;
        aVar.mo27391b();
    }

    public C1660b() {
        C1661a aVar = new C1661a(f1975e, f1976f, this.f1979a);
        if (!this.f1980b.compareAndSet(f1978h, aVar)) {
            aVar.mo27391b();
        }
    }

    /* renamed from: a */
    public C1711q.C1713b mo27385a() {
        return new C1662b(this.f1980b.get());
    }
}
