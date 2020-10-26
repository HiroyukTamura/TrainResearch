/*
 * Decompiled with CFR 0.139.
 */
package b.a.e.g;

import b.a.h;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class k
extends h {
    private static final k b = new k();

    k() {
    }

    public static k c() {
        return b;
    }

    @Override
    public b.a.b.b a(Runnable runnable) {
        b.a.f.a.a(runnable).run();
        return b.a.e.a.c.a;
    }

    @Override
    public b.a.b.b a(Runnable runnable, long l2, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(l2);
            b.a.f.a.a(runnable).run();
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            b.a.f.a.a(interruptedException);
        }
        return b.a.e.a.c.a;
    }

    @Override
    public h.b a() {
        return new c();
    }

    static final class a
    implements Runnable {
        private final Runnable a;
        private final c b;
        private final long c;

        a(Runnable runnable, c c2, long l2) {
            this.a = runnable;
            this.b = c2;
            this.c = l2;
        }

        @Override
        public void run() {
            if (!this.b.c) {
                long l2 = this.b.a(TimeUnit.MILLISECONDS);
                if (this.c > l2 && (l2 = this.c - l2) > 0L) {
                    try {
                        Thread.sleep(l2);
                    }
                    catch (InterruptedException interruptedException) {
                        Thread.currentThread().interrupt();
                        b.a.f.a.a(interruptedException);
                        return;
                    }
                }
                if (!this.b.c) {
                    this.a.run();
                }
            }
        }
    }

    static final class b
    implements Comparable<b> {
        final Runnable a;
        final long b;
        final int c;
        volatile boolean d;

        b(Runnable runnable, Long l2, int n2) {
            this.a = runnable;
            this.b = l2;
            this.c = n2;
        }

        public int a(b b2) {
            int n2 = b.a.e.b.b.a(this.b, b2.b);
            if (n2 == 0) {
                return b.a.e.b.b.a(this.c, b2.c);
            }
            return n2;
        }

        @Override
        public /* synthetic */ int compareTo(Object object) {
            return this.a((b)object);
        }
    }

    static final class c
    extends h.b
    implements b.a.b.b {
        final PriorityBlockingQueue<b> a = new PriorityBlockingQueue();
        final AtomicInteger b = new AtomicInteger();
        volatile boolean c;
        private final AtomicInteger d = new AtomicInteger();

        c() {
        }

        @Override
        public b.a.b.b a(Runnable runnable) {
            return this.a(runnable, this.a(TimeUnit.MILLISECONDS));
        }

        b.a.b.b a(Runnable object, long l2) {
            if (this.c) {
                return b.a.e.a.c.a;
            }
            object = new b((Runnable)object, l2, this.b.incrementAndGet());
            this.a.add((b)object);
            if (this.d.getAndIncrement() == 0) {
                int n2 = 1;
                do {
                    if (this.c) {
                        this.a.clear();
                        return b.a.e.a.c.a;
                    }
                    object = this.a.poll();
                    if (object == null) {
                        int n3;
                        n2 = n3 = this.d.addAndGet(-n2);
                        if (n3 != 0) continue;
                        return b.a.e.a.c.a;
                    }
                    if (((b)object).d) continue;
                    ((b)object).a.run();
                } while (true);
            }
            return b.a.b.c.a(new a((b)object));
        }

        @Override
        public b.a.b.b a(Runnable runnable, long l2, TimeUnit timeUnit) {
            l2 = this.a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(l2);
            return this.a(new b.a.e.g.k$a(runnable, this, l2), l2);
        }

        @Override
        public void a() {
            this.c = true;
        }

        final class a
        implements Runnable {
            final b a;

            a(b b2) {
                this.a = b2;
            }

            @Override
            public void run() {
                this.a.d = true;
                c.this.a.remove(this.a);
            }
        }

    }

}

