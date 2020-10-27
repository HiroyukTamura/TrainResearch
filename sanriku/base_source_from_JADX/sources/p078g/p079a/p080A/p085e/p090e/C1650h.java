package p078g.p079a.p080A.p085e.p090e;

import java.util.concurrent.atomic.AtomicReference;
import p078g.p079a.C1711q;
import p078g.p079a.C1714r;
import p078g.p079a.C1716t;
import p078g.p079a.C1718v;
import p078g.p079a.p080A.p081a.C1588b;
import p078g.p079a.p080A.p081a.C1591e;
import p078g.p079a.p098x.C1727b;

/* renamed from: g.a.A.e.e.h */
public final class C1650h<T> extends C1714r<T> {

    /* renamed from: a */
    final C1718v<? extends T> f1945a;

    /* renamed from: b */
    final C1711q f1946b;

    /* renamed from: g.a.A.e.e.h$a */
    static final class C1651a<T> extends AtomicReference<C1727b> implements C1716t<T>, C1727b, Runnable {

        /* renamed from: a */
        final C1716t<? super T> f1947a;

        /* renamed from: b */
        final C1591e f1948b = new C1591e();

        /* renamed from: c */
        final C1718v<? extends T> f1949c;

        C1651a(C1716t<? super T> tVar, C1718v<? extends T> vVar) {
            this.f1947a = tVar;
            this.f1949c = vVar;
        }

        /* renamed from: a */
        public void mo27364a(C1727b bVar) {
            C1588b.m2223c(this, bVar);
        }

        /* renamed from: a */
        public boolean mo27340a() {
            return C1588b.m2218a((C1727b) get());
        }

        /* renamed from: b */
        public void mo27341b() {
            C1588b.m2220a((AtomicReference<C1727b>) this);
            this.f1948b.mo27341b();
        }

        public void onError(Throwable th) {
            this.f1947a.onError(th);
        }

        public void onSuccess(T t) {
            this.f1947a.onSuccess(t);
        }

        public void run() {
            this.f1949c.mo27433a(this);
        }
    }

    public C1650h(C1718v<? extends T> vVar, C1711q qVar) {
        this.f1945a = vVar;
        this.f1946b = qVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo27377b(C1716t<? super T> tVar) {
        C1651a aVar = new C1651a(tVar, this.f1945a);
        tVar.mo27364a(aVar);
        C1727b a = this.f1946b.mo27406a(aVar);
        C1591e eVar = aVar.f1948b;
        if (eVar != null) {
            C1588b.m2221a((AtomicReference<C1727b>) eVar, a);
            return;
        }
        throw null;
    }
}
