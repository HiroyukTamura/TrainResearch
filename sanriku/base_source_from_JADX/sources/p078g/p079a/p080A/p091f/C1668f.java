package p078g.p079a.p080A.p091f;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import p078g.p079a.p080A.p082b.C1592a;
import p078g.p079a.p098x.C1727b;

/* renamed from: g.a.A.f.f */
public final class C1668f extends C1668f implements Callable<Void>, C1727b {

    /* renamed from: c */
    protected static final FutureTask<Void> f1999c = new FutureTask<>(C1592a.f1864b, (Object) null);

    /* renamed from: d */
    protected static final FutureTask<Void> f2000d = new FutureTask<>(C1592a.f1864b, (Object) null);

    /* renamed from: a */
    protected final Runnable f2001a;

    /* renamed from: b */
    protected Thread f2002b;

    public C1668f(Runnable runnable) {
        this.f2001a = runnable;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [g.a.A.f.f, java.util.concurrent.atomic.AtomicReference] */
    /* renamed from: a */
    public final boolean mo27340a() {
        Future future = (Future) get();
        return future == f1999c || future == f2000d;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [g.a.A.f.f, java.util.concurrent.atomic.AtomicReference] */
    /* renamed from: b */
    public final void mo27341b() {
        FutureTask<Void> futureTask;
        Future future = (Future) get();
        if (future != f1999c && future != (futureTask = f2000d) && compareAndSet(future, futureTask) && future != null) {
            future.cancel(this.f2002b != Thread.currentThread());
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [g.a.A.f.f, java.util.concurrent.atomic.AtomicReference] */
    public Object call() throws Exception {
        this.f2002b = Thread.currentThread();
        try {
            this.f2001a.run();
            return null;
        } finally {
            lazySet(f1999c);
            this.f2002b = null;
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [g.a.A.f.f, java.util.concurrent.atomic.AtomicReference] */
    /* renamed from: a */
    public final void mo27400a(Future future) {
        Future future2;
        do {
            future2 = (Future) get();
            if (future2 != f1999c) {
                if (future2 == f2000d) {
                    future.cancel(this.f2002b != Thread.currentThread());
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(future2, future));
    }
}
