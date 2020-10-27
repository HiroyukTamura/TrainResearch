package p078g.p079a.p080A.p085e.p090e;

import java.util.concurrent.atomic.AtomicReference;
import p009e.p028d.p030b.p054b.C1532a;
import p078g.p079a.C1714r;
import p078g.p079a.C1716t;
import p078g.p079a.C1718v;
import p078g.p079a.p080A.p081a.C1588b;
import p078g.p079a.p080A.p082b.C1599b;
import p078g.p079a.p098x.C1727b;
import p078g.p079a.p100z.C1742e;

/* renamed from: g.a.A.e.e.b */
public final class C1639b<T, R> extends C1714r<R> {

    /* renamed from: a */
    final C1718v<? extends T> f1922a;

    /* renamed from: b */
    final C1742e<? super T, ? extends C1718v<? extends R>> f1923b;

    /* renamed from: g.a.A.e.e.b$a */
    static final class C1640a<T, R> extends AtomicReference<C1727b> implements C1716t<T>, C1727b {

        /* renamed from: a */
        final C1716t<? super R> f1924a;

        /* renamed from: b */
        final C1742e<? super T, ? extends C1718v<? extends R>> f1925b;

        /* renamed from: g.a.A.e.e.b$a$a */
        static final class C1641a<R> implements C1716t<R> {

            /* renamed from: a */
            final AtomicReference<C1727b> f1926a;

            /* renamed from: b */
            final C1716t<? super R> f1927b;

            C1641a(AtomicReference<C1727b> atomicReference, C1716t<? super R> tVar) {
                this.f1926a = atomicReference;
                this.f1927b = tVar;
            }

            /* renamed from: a */
            public void mo27364a(C1727b bVar) {
                C1588b.m2221a(this.f1926a, bVar);
            }

            public void onError(Throwable th) {
                this.f1927b.onError(th);
            }

            public void onSuccess(R r) {
                this.f1927b.onSuccess(r);
            }
        }

        C1640a(C1716t<? super R> tVar, C1742e<? super T, ? extends C1718v<? extends R>> eVar) {
            this.f1924a = tVar;
            this.f1925b = eVar;
        }

        /* renamed from: a */
        public void mo27364a(C1727b bVar) {
            if (C1588b.m2223c(this, bVar)) {
                this.f1924a.mo27364a(this);
            }
        }

        /* renamed from: a */
        public boolean mo27340a() {
            return C1588b.m2218a((C1727b) get());
        }

        /* renamed from: b */
        public void mo27341b() {
            C1588b.m2220a((AtomicReference<C1727b>) this);
        }

        public void onError(Throwable th) {
            this.f1924a.onError(th);
        }

        public void onSuccess(T t) {
            try {
                Object apply = this.f1925b.apply(t);
                C1599b.m2241a(apply, "The single returned by the mapper is null");
                C1718v vVar = (C1718v) apply;
                if (!mo27340a()) {
                    vVar.mo27433a(new C1641a(this, this.f1924a));
                }
            } catch (Throwable th) {
                C1532a.m2139a(th);
                this.f1924a.onError(th);
            }
        }
    }

    public C1639b(C1718v<? extends T> vVar, C1742e<? super T, ? extends C1718v<? extends R>> eVar) {
        this.f1923b = eVar;
        this.f1922a = vVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo27377b(C1716t<? super R> tVar) {
        this.f1922a.mo27433a(new C1640a(tVar, this.f1923b));
    }
}
