package p078g.p079a.p080A.p084d;

import java.util.concurrent.atomic.AtomicReference;
import p078g.p079a.C1698d;
import p078g.p079a.p080A.p081a.C1588b;
import p078g.p079a.p093B.C1682a;
import p078g.p079a.p098x.C1727b;
import p078g.p079a.p099y.C1735b;

/* renamed from: g.a.A.d.d */
public final class C1605d extends AtomicReference<C1727b> implements C1698d, C1727b {
    /* renamed from: a */
    public void mo27361a(C1727b bVar) {
        C1588b.m2223c(this, bVar);
    }

    /* renamed from: a */
    public boolean mo27340a() {
        return get() == C1588b.DISPOSED;
    }

    /* renamed from: b */
    public void mo27341b() {
        C1588b.m2220a((AtomicReference<C1727b>) this);
    }

    public void onComplete() {
        lazySet(C1588b.DISPOSED);
    }

    public void onError(Throwable th) {
        lazySet(C1588b.DISPOSED);
        C1682a.m2372a((Throwable) new C1735b(th));
    }
}
