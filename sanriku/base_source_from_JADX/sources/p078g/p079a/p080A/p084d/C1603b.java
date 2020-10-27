package p078g.p079a.p080A.p084d;

import java.util.concurrent.atomic.AtomicReference;
import p009e.p028d.p030b.p054b.C1532a;
import p078g.p079a.C1698d;
import p078g.p079a.p080A.p081a.C1588b;
import p078g.p079a.p093B.C1682a;
import p078g.p079a.p098x.C1727b;
import p078g.p079a.p099y.C1735b;
import p078g.p079a.p100z.C1738a;
import p078g.p079a.p100z.C1741d;

/* renamed from: g.a.A.d.b */
public final class C1603b extends AtomicReference<C1727b> implements C1698d, C1727b, C1741d<Throwable> {

    /* renamed from: a */
    final C1741d<? super Throwable> f1873a;

    /* renamed from: b */
    final C1738a f1874b;

    public C1603b(C1738a aVar) {
        this.f1873a = this;
        this.f1874b = aVar;
    }

    public C1603b(C1741d<? super Throwable> dVar, C1738a aVar) {
        this.f1873a = dVar;
        this.f1874b = aVar;
    }

    /* renamed from: a */
    public void mo27361a(C1727b bVar) {
        C1588b.m2223c(this, bVar);
    }

    /* renamed from: a */
    public boolean mo27340a() {
        return get() == C1588b.DISPOSED;
    }

    public void accept(Object obj) throws Exception {
        C1682a.m2372a((Throwable) new C1735b((Throwable) obj));
    }

    /* renamed from: b */
    public void mo27341b() {
        C1588b.m2220a((AtomicReference<C1727b>) this);
    }

    public void onComplete() {
        try {
            this.f1874b.run();
        } catch (Throwable th) {
            C1532a.m2139a(th);
            C1682a.m2372a(th);
        }
        lazySet(C1588b.DISPOSED);
    }

    public void onError(Throwable th) {
        try {
            this.f1873a.accept(th);
        } catch (Throwable th2) {
            C1532a.m2139a(th2);
            C1682a.m2372a(th2);
        }
        lazySet(C1588b.DISPOSED);
    }
}
