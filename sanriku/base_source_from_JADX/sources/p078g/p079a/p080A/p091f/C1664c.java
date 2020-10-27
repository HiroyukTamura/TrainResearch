package p078g.p079a.p080A.p091f;

import java.util.concurrent.ThreadFactory;
import p078g.p079a.C1711q;

/* renamed from: g.a.A.f.c */
public final class C1664c extends C1711q {

    /* renamed from: b */
    private static final C1666e f1992b = new C1666e("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));

    /* renamed from: a */
    final ThreadFactory f1993a = f1992b;

    /* renamed from: a */
    public C1711q.C1713b mo27385a() {
        return new C1665d(this.f1993a);
    }
}
