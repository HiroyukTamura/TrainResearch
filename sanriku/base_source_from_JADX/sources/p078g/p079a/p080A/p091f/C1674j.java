package p078g.p079a.p080A.p091f;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import p078g.p079a.C1711q;
import p078g.p079a.p080A.p081a.C1589c;
import p078g.p079a.p080A.p082b.C1599b;
import p078g.p079a.p093B.C1682a;
import p078g.p079a.p098x.C1727b;
import p078g.p079a.p098x.C1728c;

/* renamed from: g.a.A.f.j */
public final class C1674j extends C1711q {

    /* renamed from: a */
    private static final C1674j f2018a = new C1674j();

    /* renamed from: g.a.A.f.j$a */
    static final class C1675a implements Runnable {

        /* renamed from: a */
        private final Runnable f2019a;

        /* renamed from: b */
        private final C1677c f2020b;

        /* renamed from: c */
        private final long f2021c;

        C1675a(Runnable runnable, C1677c cVar, long j) {
            this.f2019a = runnable;
            this.f2020b = cVar;
            this.f2021c = j;
        }

        public void run() {
            if (!this.f2020b.f2029d) {
                C1677c cVar = this.f2020b;
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                if (cVar != null) {
                    long convert = timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
                    long j = this.f2021c;
                    if (j > convert) {
                        try {
                            Thread.sleep(j - convert);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            C1682a.m2372a((Throwable) e);
                            return;
                        }
                    }
                    if (!this.f2020b.f2029d) {
                        this.f2019a.run();
                        return;
                    }
                    return;
                }
                throw null;
            }
        }
    }

    /* renamed from: g.a.A.f.j$b */
    static final class C1676b implements Comparable<C1676b> {

        /* renamed from: a */
        final Runnable f2022a;

        /* renamed from: b */
        final long f2023b;

        /* renamed from: c */
        final int f2024c;

        /* renamed from: d */
        volatile boolean f2025d;

        C1676b(Runnable runnable, Long l, int i) {
            this.f2022a = runnable;
            this.f2023b = l.longValue();
            this.f2024c = i;
        }

        public int compareTo(Object obj) {
            C1676b bVar = (C1676b) obj;
            int a = C1599b.m2239a(this.f2023b, bVar.f2023b);
            if (a != 0) {
                return a;
            }
            int i = this.f2024c;
            int i2 = bVar.f2024c;
            if (i < i2) {
                return -1;
            }
            return i > i2 ? 1 : 0;
        }
    }

    /* renamed from: g.a.A.f.j$c */
    static final class C1677c extends C1711q.C1713b implements C1727b {

        /* renamed from: a */
        final PriorityBlockingQueue<C1676b> f2026a = new PriorityBlockingQueue<>();

        /* renamed from: b */
        private final AtomicInteger f2027b = new AtomicInteger();

        /* renamed from: c */
        final AtomicInteger f2028c = new AtomicInteger();

        /* renamed from: d */
        volatile boolean f2029d;

        /* renamed from: g.a.A.f.j$c$a */
        final class C1678a implements Runnable {

            /* renamed from: a */
            final C1676b f2030a;

            C1678a(C1676b bVar) {
                this.f2030a = bVar;
            }

            public void run() {
                this.f2030a.f2025d = true;
                C1677c.this.f2026a.remove(this.f2030a);
            }
        }

        C1677c() {
        }

        /* JADX WARNING: type inference failed for: r5v2, types: [g.a.A.a.c, g.a.x.b] */
        /* renamed from: a */
        public C1727b mo27387a(Runnable runnable, long j, TimeUnit timeUnit) {
            long millis = timeUnit.toMillis(j) + TimeUnit.MILLISECONDS.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
            C1675a aVar = new C1675a(runnable, this, millis);
            if (!this.f2029d) {
                C1676b bVar = new C1676b(aVar, Long.valueOf(millis), this.f2028c.incrementAndGet());
                this.f2026a.add(bVar);
                if (this.f2027b.getAndIncrement() != 0) {
                    return C1728c.m2443a(new C1678a(bVar));
                }
                int i = 1;
                while (true) {
                    if (this.f2029d) {
                        this.f2026a.clear();
                        break;
                    }
                    C1676b poll = this.f2026a.poll();
                    if (poll == null) {
                        i = this.f2027b.addAndGet(-i);
                        if (i == 0) {
                            break;
                        }
                    } else if (!poll.f2025d) {
                        poll.f2022a.run();
                    }
                }
            }
            return C1589c.INSTANCE;
        }

        /* renamed from: a */
        public boolean mo27340a() {
            return this.f2029d;
        }

        /* renamed from: b */
        public void mo27341b() {
            this.f2029d = true;
        }
    }

    C1674j() {
    }

    /* renamed from: b */
    public static C1674j m2358b() {
        return f2018a;
    }

    /* renamed from: a */
    public C1711q.C1713b mo27385a() {
        return new C1677c();
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [g.a.A.a.c, g.a.x.b] */
    /* renamed from: a */
    public C1727b mo27406a(Runnable runnable) {
        C1599b.m2241a(runnable, "run is null");
        runnable.run();
        return C1589c.INSTANCE;
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [g.a.A.a.c, g.a.x.b] */
    /* renamed from: a */
    public C1727b mo27386a(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            C1599b.m2241a(runnable, "run is null");
            runnable.run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            C1682a.m2372a((Throwable) e);
        }
        return C1589c.INSTANCE;
    }
}
