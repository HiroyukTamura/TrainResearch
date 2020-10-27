package p078g.p079a.p080A.p091f;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p078g.p079a.p080A.p081a.C1587a;
import p078g.p079a.p098x.C1727b;

/* renamed from: g.a.A.f.g */
public final class C1669g extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, C1727b {

    /* renamed from: b */
    static final Object f2003b = new Object();

    /* renamed from: c */
    static final Object f2004c = new Object();

    /* renamed from: d */
    static final Object f2005d = new Object();

    /* renamed from: e */
    static final Object f2006e = new Object();

    /* renamed from: a */
    final Runnable f2007a;

    public C1669g(Runnable runnable, C1587a aVar) {
        super(3);
        this.f2007a = runnable;
        lazySet(0, aVar);
    }

    /* renamed from: a */
    public void mo27402a(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj != f2006e) {
                if (obj == f2004c) {
                    future.cancel(false);
                    return;
                } else if (obj == f2005d) {
                    future.cancel(true);
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    /* renamed from: a */
    public boolean mo27340a() {
        Object obj = get(0);
        return obj == f2003b || obj == f2006e;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo27341b() {
        /*
            r5 = this;
        L_0x0000:
            r0 = 1
            java.lang.Object r1 = r5.get(r0)
            java.lang.Object r2 = f2006e
            r3 = 0
            if (r1 == r2) goto L_0x0035
            java.lang.Object r2 = f2004c
            if (r1 == r2) goto L_0x0035
            java.lang.Object r2 = f2005d
            if (r1 != r2) goto L_0x0013
            goto L_0x0035
        L_0x0013:
            r2 = 2
            java.lang.Object r2 = r5.get(r2)
            java.lang.Thread r4 = java.lang.Thread.currentThread()
            if (r2 == r4) goto L_0x0020
            r2 = 1
            goto L_0x0021
        L_0x0020:
            r2 = 0
        L_0x0021:
            if (r2 == 0) goto L_0x0026
            java.lang.Object r4 = f2005d
            goto L_0x0028
        L_0x0026:
            java.lang.Object r4 = f2004c
        L_0x0028:
            boolean r0 = r5.compareAndSet(r0, r1, r4)
            if (r0 == 0) goto L_0x0000
            if (r1 == 0) goto L_0x0035
            java.util.concurrent.Future r1 = (java.util.concurrent.Future) r1
            r1.cancel(r2)
        L_0x0035:
            java.lang.Object r0 = r5.get(r3)
            java.lang.Object r1 = f2006e
            if (r0 == r1) goto L_0x004f
            java.lang.Object r1 = f2003b
            if (r0 == r1) goto L_0x004f
            if (r0 != 0) goto L_0x0044
            goto L_0x004f
        L_0x0044:
            boolean r1 = r5.compareAndSet(r3, r0, r1)
            if (r1 == 0) goto L_0x0035
            g.a.A.a.a r0 = (p078g.p079a.p080A.p081a.C1587a) r0
            r0.mo27349c(r5)
        L_0x004f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p078g.p079a.p080A.p091f.C1669g.mo27341b():void");
    }

    public Object call() {
        run();
        return null;
    }

    public void run() {
        Object obj;
        Object obj2;
        lazySet(2, Thread.currentThread());
        try {
            this.f2007a.run();
        } catch (Throwable th) {
            lazySet(2, (Object) null);
            Object obj3 = get(0);
            if (!(obj3 == f2003b || !compareAndSet(0, obj3, f2006e) || obj3 == null)) {
                ((C1587a) obj3).mo27349c(this);
            }
            do {
                obj2 = get(1);
                if (obj2 == f2004c || obj2 == f2005d || compareAndSet(1, obj2, f2006e)) {
                    throw th;
                }
                obj2 = get(1);
                break;
            } while (compareAndSet(1, obj2, f2006e));
            throw th;
        }
        lazySet(2, (Object) null);
        Object obj4 = get(0);
        if (!(obj4 == f2003b || !compareAndSet(0, obj4, f2006e) || obj4 == null)) {
            ((C1587a) obj4).mo27349c(this);
        }
        do {
            obj = get(1);
            if (obj == f2004c || obj == f2005d || compareAndSet(1, obj, f2006e)) {
            }
            obj = get(1);
            return;
        } while (compareAndSet(1, obj, f2006e));
    }
}
