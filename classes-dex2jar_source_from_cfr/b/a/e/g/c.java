/*
 * Decompiled with CFR 0.139.
 */
package b.a.e.g;

import b.a.e.g.e;
import b.a.e.g.f;
import b.a.h;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class c
extends h {
    static final f b;
    static final f c;
    static final c d;
    static final a g;
    private static final TimeUnit h;
    final ThreadFactory e;
    final AtomicReference<a> f;

    static {
        h = TimeUnit.SECONDS;
        d = new c(new f("RxCachedThreadSchedulerShutdown"));
        d.a();
        int n2 = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5)));
        b = new f("RxCachedThreadScheduler", n2);
        c = new f("RxCachedWorkerPoolEvictor", n2);
        g = new a(0L, null, b);
        g.d();
    }

    public c() {
        this(b);
    }

    public c(ThreadFactory threadFactory) {
        this.e = threadFactory;
        this.f = new AtomicReference<a>(g);
        this.b();
    }

    @Override
    public h.b a() {
        return new b(this.f.get());
    }

    @Override
    public void b() {
        a a2 = new a(60L, h, this.e);
        if (!this.f.compareAndSet(g, a2)) {
            a2.d();
        }
    }

    static final class a
    implements Runnable {
        final b.a.b.a a;
        private final long b;
        private final ConcurrentLinkedQueue<c> c;
        private final ScheduledExecutorService d;
        private final Future<?> e;
        private final ThreadFactory f;

        a(long l2, TimeUnit object, ThreadFactory object2) {
            l2 = object != null ? ((TimeUnit)((Object)object)).toNanos(l2) : 0L;
            this.b = l2;
            this.c = new ConcurrentLinkedQueue();
            this.a = new b.a.b.a();
            this.f = object2;
            Object var5_4 = null;
            if (object != null) {
                object = Executors.newScheduledThreadPool(1, c.c);
                object2 = object.scheduleWithFixedDelay(this, this.b, this.b, TimeUnit.NANOSECONDS);
            } else {
                object2 = null;
                object = var5_4;
            }
            this.d = object;
            this.e = object2;
        }

        c a() {
            c c2;
            if (this.a.b()) {
                return c.d;
            }
            while (!this.c.isEmpty()) {
                c2 = this.c.poll();
                if (c2 == null) continue;
                return c2;
            }
            c2 = new c(this.f);
            this.a.a(c2);
            return c2;
        }

        void a(c c2) {
            c2.a(this.c() + this.b);
            this.c.offer(c2);
        }

        void b() {
            if (!this.c.isEmpty()) {
                long l2 = this.c();
                for (c c2 : this.c) {
                    if (c2.b() > l2) break;
                    if (!this.c.remove(c2)) continue;
                    this.a.b(c2);
                }
            }
        }

        long c() {
            return System.nanoTime();
        }

        void d() {
            this.a.a();
            if (this.e != null) {
                this.e.cancel(true);
            }
            if (this.d != null) {
                this.d.shutdownNow();
            }
        }

        @Override
        public void run() {
            this.b();
        }
    }

    static final class b
    extends h.b {
        final AtomicBoolean a = new AtomicBoolean();
        private final b.a.b.a b;
        private final a c;
        private final c d;

        b(a a2) {
            this.c = a2;
            this.b = new b.a.b.a();
            this.d = a2.a();
        }

        @Override
        public b.a.b.b a(Runnable runnable, long l2, TimeUnit timeUnit) {
            if (this.b.b()) {
                return b.a.e.a.c.a;
            }
            return this.d.a(runnable, l2, timeUnit, this.b);
        }

        @Override
        public void a() {
            if (this.a.compareAndSet(false, true)) {
                this.b.a();
                this.c.a(this.d);
            }
        }
    }

    static final class c
    extends e {
        private long b = 0L;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }

        public void a(long l2) {
            this.b = l2;
        }

        public long b() {
            return this.b;
        }
    }

}

