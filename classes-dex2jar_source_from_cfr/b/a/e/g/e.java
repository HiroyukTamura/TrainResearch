/*
 * Decompiled with CFR 0.139.
 */
package b.a.e.g;

import b.a.b.b;
import b.a.e.a.c;
import b.a.e.g.g;
import b.a.e.g.i;
import b.a.f.a;
import b.a.h;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class e
extends h.b
implements b {
    volatile boolean a;
    private final ScheduledExecutorService b;

    public e(ThreadFactory threadFactory) {
        this.b = i.a(threadFactory);
    }

    @Override
    public b a(Runnable runnable) {
        return this.a(runnable, 0L, null);
    }

    @Override
    public b a(Runnable runnable, long l2, TimeUnit timeUnit) {
        if (this.a) {
            return c.a;
        }
        return this.a(runnable, l2, timeUnit, null);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public b.a.e.g.h a(Runnable var1_1, long var2_3, TimeUnit var4_4, b.a.e.a.a var5_5) {
        var6_6 = new b.a.e.g.h(a.a(var1_1 /* !! */ ), var5_5);
        if (var5_5 != null && !var5_5.a(var6_6)) {
            return var6_6;
        }
        if (var2_3 > 0L) ** GOTO lbl8
        try {
            block4 : {
                var1_1 /* !! */  = this.b.submit(var6_6);
                break block4;
lbl8: // 1 sources:
                var1_1 /* !! */  = this.b.schedule(var6_6, var2_3, var4_4);
            }
            var6_6.a(var1_1 /* !! */ );
            return var6_6;
        }
        catch (RejectedExecutionException var1_2) {}
        if (var5_5 != null) {
            var5_5.b(var6_6);
        }
        a.a(var1_2);
        return var6_6;
    }

    @Override
    public void a() {
        if (!this.a) {
            this.a = true;
            this.b.shutdownNow();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public b b(Runnable var1_1, long var2_3, TimeUnit var4_4) {
        var5_5 = new g(a.a(var1_1 /* !! */ ));
        if (var2_3 > 0L) ** GOTO lbl6
        try {
            block2 : {
                var1_1 /* !! */  = this.b.submit(var5_5);
                break block2;
lbl6: // 1 sources:
                var1_1 /* !! */  = this.b.schedule(var5_5, var2_3, var4_4);
            }
            var5_5.a(var1_1 /* !! */ );
            return var5_5;
        }
        catch (RejectedExecutionException var1_2) {}
        a.a(var1_2);
        return c.a;
    }

    public void c() {
        if (!this.a) {
            this.a = true;
            this.b.shutdown();
        }
    }
}

