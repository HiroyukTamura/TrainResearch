package p078g.p079a.p080A.p085e.p090e;

import p009e.p028d.p030b.p054b.C1532a;
import p078g.p079a.C1714r;
import p078g.p079a.C1716t;
import p078g.p079a.C1718v;
import p078g.p079a.p098x.C1727b;
import p078g.p079a.p099y.C1730a;
import p078g.p079a.p100z.C1742e;

/* renamed from: g.a.A.e.e.g */
public final class C1648g<T> extends C1714r<T> {

    /* renamed from: a */
    final C1718v<? extends T> f1940a;

    /* renamed from: b */
    final C1742e<? super Throwable, ? extends T> f1941b;

    /* renamed from: c */
    final T f1942c;

    /* renamed from: g.a.A.e.e.g$a */
    final class C1649a implements C1716t<T> {

        /* renamed from: a */
        private final C1716t<? super T> f1943a;

        C1649a(C1716t<? super T> tVar) {
            this.f1943a = tVar;
        }

        /* renamed from: a */
        public void mo27364a(C1727b bVar) {
            this.f1943a.mo27364a(bVar);
        }

        public void onError(Throwable th) {
            T t;
            C1648g gVar = C1648g.this;
            C1742e<? super Throwable, ? extends T> eVar = gVar.f1941b;
            if (eVar != null) {
                try {
                    t = eVar.apply(th);
                } catch (Throwable th2) {
                    C1532a.m2139a(th2);
                    this.f1943a.onError(new C1730a(th, th2));
                    return;
                }
            } else {
                t = gVar.f1942c;
            }
            if (t == null) {
                NullPointerException nullPointerException = new NullPointerException("Value supplied was null");
                nullPointerException.initCause(th);
                this.f1943a.onError(nullPointerException);
                return;
            }
            this.f1943a.onSuccess(t);
        }

        public void onSuccess(T t) {
            this.f1943a.onSuccess(t);
        }
    }

    public C1648g(C1718v<? extends T> vVar, C1742e<? super Throwable, ? extends T> eVar, T t) {
        this.f1940a = vVar;
        this.f1941b = eVar;
        this.f1942c = t;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo27377b(C1716t<? super T> tVar) {
        this.f1940a.mo27433a(new C1649a(tVar));
    }
}
