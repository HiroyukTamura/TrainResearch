package p078g.p079a.p080A.p091f;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p078g.p079a.C1711q;
import p078g.p079a.p080A.p081a.C1589c;
import p078g.p079a.p080A.p081a.C1590d;
import p078g.p079a.p098x.C1726a;
import p078g.p079a.p098x.C1727b;

/* renamed from: g.a.A.f.a */
public final class C1656a extends C1711q {

    /* renamed from: c */
    static final C1658b f1959c;

    /* renamed from: d */
    static final C1666e f1960d;

    /* renamed from: e */
    static final int f1961e;

    /* renamed from: f */
    static final C1659c f1962f;

    /* renamed from: a */
    final ThreadFactory f1963a = f1960d;

    /* renamed from: b */
    final AtomicReference<C1658b> f1964b = new AtomicReference<>(f1959c);

    /* renamed from: g.a.A.f.a$a */
    static final class C1657a extends C1711q.C1713b {

        /* renamed from: a */
        private final C1590d f1965a = new C1590d();

        /* renamed from: b */
        private final C1726a f1966b = new C1726a();

        /* renamed from: c */
        private final C1590d f1967c;

        /* renamed from: d */
        private final C1659c f1968d;

        /* renamed from: e */
        volatile boolean f1969e;

        C1657a(C1659c cVar) {
            this.f1968d = cVar;
            C1590d dVar = new C1590d();
            this.f1967c = dVar;
            dVar.mo27348b(this.f1965a);
            this.f1967c.mo27348b(this.f1966b);
        }

        /* JADX WARNING: type inference failed for: r7v2, types: [g.a.A.a.c, g.a.x.b] */
        /* renamed from: a */
        public C1727b mo27387a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.f1969e) {
                return C1589c.INSTANCE;
            }
            return this.f1968d.mo27395a(runnable, j, timeUnit, this.f1966b);
        }

        /* renamed from: a */
        public boolean mo27340a() {
            return this.f1969e;
        }

        /* renamed from: b */
        public void mo27341b() {
            if (!this.f1969e) {
                this.f1969e = true;
                this.f1967c.mo27341b();
            }
        }
    }

    /* renamed from: g.a.A.f.a$b */
    static final class C1658b {

        /* renamed from: a */
        final int f1970a;

        /* renamed from: b */
        final C1659c[] f1971b;

        /* renamed from: c */
        long f1972c;

        C1658b(int i, ThreadFactory threadFactory) {
            this.f1970a = i;
            this.f1971b = new C1659c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.f1971b[i2] = new C1659c(threadFactory);
            }
        }

        /* renamed from: a */
        public C1659c mo27388a() {
            int i = this.f1970a;
            if (i == 0) {
                return C1656a.f1962f;
            }
            C1659c[] cVarArr = this.f1971b;
            long j = this.f1972c;
            this.f1972c = 1 + j;
            return cVarArr[(int) (j % ((long) i))];
        }
    }

    /* renamed from: g.a.A.f.a$c */
    static final class C1659c extends C1665d {
        C1659c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int intValue = Integer.getInteger("rx2.computation-threads", 0).intValue();
        if (intValue > 0 && intValue <= availableProcessors) {
            availableProcessors = intValue;
        }
        f1961e = availableProcessors;
        C1659c cVar = new C1659c(new C1666e("RxComputationShutdown"));
        f1962f = cVar;
        cVar.mo27341b();
        C1666e eVar = new C1666e("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        f1960d = eVar;
        C1658b bVar = new C1658b(0, eVar);
        f1959c = bVar;
        for (C1659c b : bVar.f1971b) {
            b.mo27341b();
        }
    }

    public C1656a() {
        C1658b bVar = new C1658b(f1961e, this.f1963a);
        if (!this.f1964b.compareAndSet(f1959c, bVar)) {
            for (C1659c b : bVar.f1971b) {
                b.mo27341b();
            }
        }
    }

    /* renamed from: a */
    public C1711q.C1713b mo27385a() {
        return new C1657a(this.f1964b.get().mo27388a());
    }

    /* renamed from: a */
    public C1727b mo27386a(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.f1964b.get().mo27388a().mo27396b(runnable, j, timeUnit);
    }
}
