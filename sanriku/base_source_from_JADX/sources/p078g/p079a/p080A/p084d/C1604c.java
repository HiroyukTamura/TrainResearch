package p078g.p079a.p080A.p084d;

import java.util.concurrent.atomic.AtomicReference;
import p009e.p028d.p030b.p054b.C1532a;
import p078g.p079a.C1716t;
import p078g.p079a.p080A.p081a.C1588b;
import p078g.p079a.p093B.C1682a;
import p078g.p079a.p098x.C1727b;
import p078g.p079a.p099y.C1730a;
import p078g.p079a.p100z.C1741d;

/* renamed from: g.a.A.d.c */
public final class C1604c<T> extends AtomicReference<C1727b> implements C1716t<T>, C1727b {

    /* renamed from: a */
    final C1741d<? super T> f1875a;

    /* renamed from: b */
    final C1741d<? super Throwable> f1876b;

    public C1604c(C1741d<? super T> dVar, C1741d<? super Throwable> dVar2) {
        this.f1875a = dVar;
        this.f1876b = dVar2;
    }

    /* renamed from: a */
    public void mo27364a(C1727b bVar) {
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

    public void onError(Throwable th) {
        lazySet(C1588b.DISPOSED);
        try {
            this.f1876b.accept(th);
        } catch (Throwable th2) {
            C1532a.m2139a(th2);
            C1682a.m2372a((Throwable) new C1730a(th, th2));
        }
    }

    public void onSuccess(T t) {
        lazySet(C1588b.DISPOSED);
        try {
            this.f1875a.accept(t);
        } catch (Throwable th) {
            C1532a.m2139a(th);
            C1682a.m2372a(th);
        }
    }
}
