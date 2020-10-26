/*
 * Decompiled with CFR 0.139.
 */
package b.a.e.g;

import b.a.b.b;
import b.a.f.a;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class h
extends AtomicReferenceArray<Object>
implements b,
Runnable,
Callable<Object> {
    static final Object b = new Object();
    static final Object c = new Object();
    static final Object d = new Object();
    static final Object e = new Object();
    final Runnable a;

    public h(Runnable runnable, b.a.e.a.a a2) {
        super(3);
        this.a = runnable;
        this.lazySet(0, a2);
    }

    @Override
    public void a() {
        Object e2;
        Object object;
        while ((e2 = this.get(1)) != e && e2 != c && e2 != d) {
            boolean bl2 = this.get(2) != Thread.currentThread();
            object = bl2 ? d : c;
            if (!this.compareAndSet(1, e2, object)) continue;
            if (e2 == null) break;
            ((Future)e2).cancel(bl2);
            break;
        }
        while ((object = this.get(0)) != e && object != b) {
            if (object == null) {
                return;
            }
            if (!this.compareAndSet(0, object, b)) continue;
            ((b.a.e.a.a)object).c(this);
            break;
        }
    }

    public void a(Future<?> future) {
        Object e2;
        do {
            if ((e2 = this.get(1)) == e) {
                return;
            }
            if (e2 == c) {
                future.cancel(false);
                return;
            }
            if (e2 != d) continue;
            future.cancel(true);
            return;
        } while (!this.compareAndSet(1, e2, future));
    }

    @Override
    public Object call() {
        this.run();
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void run() {
        this.lazySet(2, Thread.currentThread());
        try {
            try {
                this.a.run();
            }
            catch (Throwable throwable3) {
                a.a(throwable3);
            }
        }
        catch (Throwable throwable2) {}
        this.lazySet(2, null);
        Object e2 = this.get(0);
        if (e2 != b && this.compareAndSet(0, e2, e) && e2 != null) {
            ((b.a.e.a.a)e2).c(this);
        }
        while ((e2 = this.get(1)) != c && e2 != d && !this.compareAndSet(1, e2, e)) {
        }
        return;
        this.lazySet(2, null);
        Object e3 = this.get(0);
        if (e3 != b && this.compareAndSet(0, e3, e) && e3 != null) {
            ((b.a.e.a.a)e3).c(this);
        }
        while ((e3 = this.get(1)) != c && e3 != d && !this.compareAndSet(1, e3, e)) {
        }
        throw throwable2;
    }
}

