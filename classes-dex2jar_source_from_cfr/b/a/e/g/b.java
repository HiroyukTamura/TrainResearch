/*
 * Decompiled with CFR 0.139.
 */
package b.a.e.g;

import b.a.e.a.d;
import b.a.e.g.e;
import b.a.e.g.f;
import b.a.h;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class b
extends h {
    static final b b;
    static final f c;
    static final int d;
    static final c e;
    final ThreadFactory f;
    final AtomicReference<b> g;

    static {
        d = b.a(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0));
        e = new c(new f("RxComputationShutdown"));
        e.a();
        c = new f("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5))), true);
        b = new b(0, c);
        b.b();
    }

    public b() {
        this(c);
    }

    public b(ThreadFactory threadFactory) {
        this.f = threadFactory;
        this.g = new AtomicReference<b>(b);
        this.b();
    }

    static int a(int n2, int n3) {
        int n4 = n2;
        if (n3 > 0) {
            if (n3 > n2) {
                return n2;
            }
            n4 = n3;
        }
        return n4;
    }

    @Override
    public b.a.b.b a(Runnable runnable, long l2, TimeUnit timeUnit) {
        return this.g.get().a().b(runnable, l2, timeUnit);
    }

    @Override
    public h.b a() {
        return new a(this.g.get().a());
    }

    @Override
    public void b() {
        b b2 = new b(d, this.f);
        if (!this.g.compareAndSet(b, b2)) {
            b2.b();
        }
    }

    static final class a
    extends h.b {
        volatile boolean a;
        private final d b;
        private final b.a.b.a c;
        private final d d;
        private final c e;

        a(c c2) {
            this.e = c2;
            this.b = new d();
            this.c = new b.a.b.a();
            this.d = new d();
            this.d.a(this.b);
            this.d.a(this.c);
        }

        @Override
        public b.a.b.b a(Runnable runnable) {
            if (this.a) {
                return b.a.e.a.c.a;
            }
            return this.e.a(runnable, 0L, TimeUnit.MILLISECONDS, this.b);
        }

        @Override
        public b.a.b.b a(Runnable runnable, long l2, TimeUnit timeUnit) {
            if (this.a) {
                return b.a.e.a.c.a;
            }
            return this.e.a(runnable, l2, timeUnit, this.c);
        }

        @Override
        public void a() {
            if (!this.a) {
                this.a = true;
                this.d.a();
            }
        }
    }

    static final class b {
        final int a;
        final c[] b;
        long c;

        b(int n2, ThreadFactory threadFactory) {
            this.a = n2;
            this.b = new c[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                this.b[i2] = new c(threadFactory);
            }
        }

        public c a() {
            int n2 = this.a;
            if (n2 == 0) {
                return b.e;
            }
            c[] arrc = this.b;
            long l2 = this.c;
            this.c = 1L + l2;
            return arrc[(int)(l2 % (long)n2)];
        }

        public void b() {
            c[] arrc = this.b;
            int n2 = arrc.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                arrc[i2].a();
            }
        }
    }

    static final class c
    extends e {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

}

