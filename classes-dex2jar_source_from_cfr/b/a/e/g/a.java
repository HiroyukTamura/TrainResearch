/*
 * Decompiled with CFR 0.139.
 */
package b.a.e.g;

import b.a.b.b;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

abstract class a
extends AtomicReference<Future<?>>
implements b {
    protected static final FutureTask<Void> c = new FutureTask<Object>(b.a.e.b.a.b, null);
    protected static final FutureTask<Void> d = new FutureTask<Object>(b.a.e.b.a.b, null);
    protected final Runnable a;
    protected Thread b;

    a(Runnable runnable) {
        this.a = runnable;
    }

    @Override
    public final void a() {
        Future future = (Future)this.get();
        if (future != c && future != d && this.compareAndSet(future, d) && future != null) {
            boolean bl2 = this.b != Thread.currentThread();
            future.cancel(bl2);
        }
    }

    public final void a(Future<?> future) {
        Future future2;
        do {
            if ((future2 = (Future)this.get()) == c) {
                return;
            }
            if (future2 != d) continue;
            boolean bl2 = this.b != Thread.currentThread();
            future.cancel(bl2);
            return;
        } while (!this.compareAndSet(future2, future));
    }
}

