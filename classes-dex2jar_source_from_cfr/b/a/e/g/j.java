/*
 * Decompiled with CFR 0.139.
 */
package b.a.e.g;

import b.a.b.b;
import b.a.e.a.c;
import b.a.e.g.f;
import b.a.e.g.g;
import b.a.e.g.i;
import b.a.h;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class j
extends h {
    static final f d;
    static final ScheduledExecutorService e;
    final ThreadFactory b;
    final AtomicReference<ScheduledExecutorService> c = new AtomicReference();

    static {
        e = Executors.newScheduledThreadPool(0);
        e.shutdown();
        d = new f("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5))), true);
    }

    public j() {
        this(d);
    }

    public j(ThreadFactory threadFactory) {
        this.b = threadFactory;
        this.c.lazySet(j.a(threadFactory));
    }

    static ScheduledExecutorService a(ThreadFactory threadFactory) {
        return i.a(threadFactory);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public b a(Runnable var1_1, long var2_3, TimeUnit var4_4) {
        var5_5 = new g(b.a.f.a.a(var1_1 /* !! */ ));
        if (var2_3 > 0L) ** GOTO lbl6
        try {
            block2 : {
                var1_1 /* !! */  = this.c.get().submit(var5_5);
                break block2;
lbl6: // 1 sources:
                var1_1 /* !! */  = this.c.get().schedule(var5_5, var2_3, var4_4);
            }
            var5_5.a(var1_1 /* !! */ );
            return var5_5;
        }
        catch (RejectedExecutionException var1_2) {}
        b.a.f.a.a(var1_2);
        return c.a;
    }

    @Override
    public h.b a() {
        return new a(this.c.get());
    }

    @Override
    public void b() {
        ScheduledExecutorService scheduledExecutorService;
        ExecutorService executorService;
        ExecutorService executorService2 = null;
        do {
            if ((scheduledExecutorService = this.c.get()) != e) {
                if (executorService2 != null) {
                    executorService2.shutdown();
                }
                return;
            }
            executorService = executorService2;
            if (executorService2 == null) {
                executorService = j.a(this.b);
            }
            executorService2 = executorService;
        } while (!this.c.compareAndSet(scheduledExecutorService, (ScheduledExecutorService)executorService));
    }

    static final class a
    extends h.b {
        final ScheduledExecutorService a;
        final b.a.b.a b;
        volatile boolean c;

        a(ScheduledExecutorService scheduledExecutorService) {
            this.a = scheduledExecutorService;
            this.b = new b.a.b.a();
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        @Override
        public b a(Runnable var1_1, long var2_3, TimeUnit var4_4) {
            if (this.c) {
                return c.a;
            }
            var5_5 = new b.a.e.g.h(b.a.f.a.a(var1_1 /* !! */ ), this.b);
            this.b.a(var5_5);
            if (var2_3 > 0L) ** GOTO lbl9
            try {
                block3 : {
                    var1_1 /* !! */  = this.a.submit(var5_5);
                    break block3;
lbl9: // 1 sources:
                    var1_1 /* !! */  = this.a.schedule(var5_5, var2_3, var4_4);
                }
                var5_5.a(var1_1 /* !! */ );
                return var5_5;
            }
            catch (RejectedExecutionException var1_2) {}
            this.a();
            b.a.f.a.a(var1_2);
            return c.a;
        }

        @Override
        public void a() {
            if (!this.c) {
                this.c = true;
                this.b.a();
            }
        }
    }

}

