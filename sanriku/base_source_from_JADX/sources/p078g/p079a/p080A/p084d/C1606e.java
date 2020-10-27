package p078g.p079a.p080A.p084d;

import java.util.concurrent.atomic.AtomicReference;
import p009e.p028d.p030b.p054b.C1532a;
import p078g.p079a.C1710p;
import p078g.p079a.p080A.p081a.C1588b;
import p078g.p079a.p093B.C1682a;
import p078g.p079a.p098x.C1727b;
import p078g.p079a.p099y.C1730a;
import p078g.p079a.p100z.C1738a;
import p078g.p079a.p100z.C1741d;

/* renamed from: g.a.A.d.e */
public final class C1606e<T> extends AtomicReference<C1727b> implements C1710p<T>, C1727b {

    /* renamed from: a */
    final C1741d<? super T> f1877a;

    /* renamed from: b */
    final C1741d<? super Throwable> f1878b;

    /* renamed from: c */
    final C1738a f1879c;

    /* renamed from: d */
    final C1741d<? super C1727b> f1880d;

    public C1606e(C1741d<? super T> dVar, C1741d<? super Throwable> dVar2, C1738a aVar, C1741d<? super C1727b> dVar3) {
        this.f1877a = dVar;
        this.f1878b = dVar2;
        this.f1879c = aVar;
        this.f1880d = dVar3;
    }

    /* renamed from: a */
    public void mo27336a(C1727b bVar) {
        if (C1588b.m2223c(this, bVar)) {
            try {
                this.f1880d.accept(this);
            } catch (Throwable th) {
                C1532a.m2139a(th);
                bVar.mo27341b();
                onError(th);
            }
        }
    }

    /* renamed from: a */
    public void mo27337a(T t) {
        if (!mo27340a()) {
            try {
                this.f1877a.accept(t);
            } catch (Throwable th) {
                C1532a.m2139a(th);
                ((C1727b) get()).mo27341b();
                onError(th);
            }
        }
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
        if (!mo27340a()) {
            lazySet(C1588b.DISPOSED);
            try {
                this.f1879c.run();
            } catch (Throwable th) {
                C1532a.m2139a(th);
                C1682a.m2372a(th);
            }
        }
    }

    public void onError(Throwable th) {
        if (!mo27340a()) {
            lazySet(C1588b.DISPOSED);
            try {
                this.f1878b.accept(th);
            } catch (Throwable th2) {
                C1532a.m2139a(th2);
                C1682a.m2372a((Throwable) new C1730a(th, th2));
            }
        } else {
            C1682a.m2372a(th);
        }
    }
}
