/*
 * Decompiled with CFR 0.139.
 */
package b.a;

import b.a.e.g.e;
import java.util.concurrent.TimeUnit;

public abstract class h {
    static final long a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15L));

    public b.a.b.b a(Runnable runnable) {
        return this.a(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public b.a.b.b a(Runnable runnable, long l2, TimeUnit timeUnit) {
        b b2 = this.a();
        runnable = new a(b.a.f.a.a(runnable), b2);
        b2.a(runnable, l2, timeUnit);
        return runnable;
    }

    public abstract b a();

    public void b() {
    }

    static final class a
    implements b.a.b.b,
    Runnable {
        final Runnable a;
        final b b;
        Thread c;

        a(Runnable runnable, b b2) {
            this.a = runnable;
            this.b = b2;
        }

        @Override
        public void a() {
            if (this.c == Thread.currentThread() && this.b instanceof e) {
                ((e)this.b).c();
                return;
            }
            this.b.a();
        }

        @Override
        public void run() {
            this.c = Thread.currentThread();
            try {
                this.a.run();
                return;
            }
            finally {
                this.a();
                this.c = null;
            }
        }
    }

    public static abstract class b
    implements b.a.b.b {
        public long a(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        public b.a.b.b a(Runnable runnable) {
            return this.a(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public abstract b.a.b.b a(Runnable var1, long var2, TimeUnit var4);
    }

}

