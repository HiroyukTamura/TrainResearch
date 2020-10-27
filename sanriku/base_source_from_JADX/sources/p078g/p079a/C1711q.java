package p078g.p079a;

import java.util.concurrent.TimeUnit;
import p078g.p079a.p080A.p082b.C1599b;
import p078g.p079a.p080A.p091f.C1665d;
import p078g.p079a.p098x.C1727b;

/* renamed from: g.a.q */
public abstract class C1711q {

    /* renamed from: g.a.q$a */
    static final class C1712a implements C1727b, Runnable {

        /* renamed from: a */
        final Runnable f2056a;

        /* renamed from: b */
        final C1713b f2057b;

        /* renamed from: c */
        Thread f2058c;

        C1712a(Runnable runnable, C1713b bVar) {
            this.f2056a = runnable;
            this.f2057b = bVar;
        }

        /* renamed from: a */
        public boolean mo27340a() {
            return this.f2057b.mo27340a();
        }

        /* renamed from: b */
        public void mo27341b() {
            if (this.f2058c == Thread.currentThread()) {
                C1713b bVar = this.f2057b;
                if (bVar instanceof C1665d) {
                    ((C1665d) bVar).mo27397c();
                    return;
                }
            }
            this.f2057b.mo27341b();
        }

        public void run() {
            this.f2058c = Thread.currentThread();
            try {
                this.f2056a.run();
            } finally {
                mo27341b();
                this.f2058c = null;
            }
        }
    }

    /* renamed from: g.a.q$b */
    public static abstract class C1713b implements C1727b {
        /* renamed from: a */
        public abstract C1727b mo27387a(Runnable runnable, long j, TimeUnit timeUnit);
    }

    static {
        TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());
    }

    /* renamed from: a */
    public abstract C1713b mo27385a();

    /* renamed from: a */
    public C1727b mo27406a(Runnable runnable) {
        return mo27386a(runnable, 0, TimeUnit.NANOSECONDS);
    }

    /* renamed from: a */
    public C1727b mo27386a(Runnable runnable, long j, TimeUnit timeUnit) {
        C1713b a = mo27385a();
        C1599b.m2241a(runnable, "run is null");
        C1712a aVar = new C1712a(runnable, a);
        a.mo27387a(aVar, j, timeUnit);
        return aVar;
    }
}
