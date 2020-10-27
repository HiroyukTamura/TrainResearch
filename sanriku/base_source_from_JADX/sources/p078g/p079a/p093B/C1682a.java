package p078g.p079a.p093B;

import java.util.concurrent.Callable;
import p078g.p079a.C1711q;
import p078g.p079a.p080A.p082b.C1599b;
import p078g.p079a.p080A.p092g.C1679a;
import p078g.p079a.p099y.C1730a;
import p078g.p079a.p099y.C1735b;
import p078g.p079a.p099y.C1737d;

/* renamed from: g.a.B.a */
public final class C1682a {
    /* renamed from: a */
    static C1711q m2371a(Callable<C1711q> callable) {
        try {
            C1711q call = callable.call();
            C1599b.m2241a(call, "Scheduler Callable result can't be null");
            return call;
        } catch (Throwable th) {
            throw C1679a.m2365a(th);
        }
    }

    /* renamed from: a */
    public static void m2372a(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else {
            boolean z = true;
            if (!(th instanceof C1735b) && !(th instanceof IllegalStateException) && !(th instanceof NullPointerException) && !(th instanceof IllegalArgumentException) && !(th instanceof C1730a)) {
                z = false;
            }
            if (!z) {
                th = new C1737d(th);
            }
        }
        th.printStackTrace();
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    /* renamed from: b */
    public static C1711q m2373b(Callable<C1711q> callable) {
        C1599b.m2241a(callable, "Scheduler Callable can't be null");
        return m2371a(callable);
    }

    /* renamed from: c */
    public static C1711q m2374c(Callable<C1711q> callable) {
        C1599b.m2241a(callable, "Scheduler Callable can't be null");
        return m2371a(callable);
    }

    /* renamed from: d */
    public static C1711q m2375d(Callable<C1711q> callable) {
        C1599b.m2241a(callable, "Scheduler Callable can't be null");
        return m2371a(callable);
    }

    /* renamed from: e */
    public static C1711q m2376e(Callable<C1711q> callable) {
        C1599b.m2241a(callable, "Scheduler Callable can't be null");
        return m2371a(callable);
    }
}
