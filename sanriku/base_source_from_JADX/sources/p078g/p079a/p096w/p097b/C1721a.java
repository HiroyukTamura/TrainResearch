package p078g.p079a.p096w.p097b;

import android.os.Handler;
import android.os.Looper;
import p078g.p079a.C1711q;
import p078g.p079a.p080A.p092g.C1679a;

/* renamed from: g.a.w.b.a */
public final class C1721a {

    /* renamed from: a */
    private static final C1711q f2061a;

    /* renamed from: g.a.w.b.a$a */
    private static final class C1722a {

        /* renamed from: a */
        static final C1711q f2062a = new C1723b(new Handler(Looper.getMainLooper()), false);
    }

    static {
        try {
            C1711q qVar = C1722a.f2062a;
            if (qVar != null) {
                f2061a = qVar;
                return;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw C1679a.m2365a(th);
        }
    }

    /* renamed from: a */
    public static C1711q m2428a() {
        C1711q qVar = f2061a;
        if (qVar != null) {
            return qVar;
        }
        throw new NullPointerException("scheduler == null");
    }
}
