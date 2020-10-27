package p078g.p079a.p080A.p085e.p090e;

import p009e.p028d.p030b.p054b.C1532a;
import p078g.p079a.C1714r;
import p078g.p079a.C1716t;
import p078g.p079a.C1718v;
import p078g.p079a.p080A.p082b.C1599b;
import p078g.p079a.p098x.C1727b;
import p078g.p079a.p100z.C1742e;

/* renamed from: g.a.A.e.e.e */
public final class C1644e<T, R> extends C1714r<R> {

    /* renamed from: a */
    final C1718v<? extends T> f1930a;

    /* renamed from: b */
    final C1742e<? super T, ? extends R> f1931b;

    /* renamed from: g.a.A.e.e.e$a */
    static final class C1645a<T, R> implements C1716t<T> {

        /* renamed from: a */
        final C1716t<? super R> f1932a;

        /* renamed from: b */
        final C1742e<? super T, ? extends R> f1933b;

        C1645a(C1716t<? super R> tVar, C1742e<? super T, ? extends R> eVar) {
            this.f1932a = tVar;
            this.f1933b = eVar;
        }

        /* renamed from: a */
        public void mo27364a(C1727b bVar) {
            this.f1932a.mo27364a(bVar);
        }

        public void onError(Throwable th) {
            this.f1932a.onError(th);
        }

        public void onSuccess(T t) {
            try {
                Object apply = this.f1933b.apply(t);
                C1599b.m2241a(apply, "The mapper function returned a null value.");
                this.f1932a.onSuccess(apply);
            } catch (Throwable th) {
                C1532a.m2139a(th);
                onError(th);
            }
        }
    }

    public C1644e(C1718v<? extends T> vVar, C1742e<? super T, ? extends R> eVar) {
        this.f1930a = vVar;
        this.f1931b = eVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo27377b(C1716t<? super R> tVar) {
        this.f1930a.mo27433a(new C1645a(tVar, this.f1931b));
    }
}
