package p078g.p079a.p080A.p085e.p089d;

import p078g.p079a.C1706l;
import p078g.p079a.C1709o;
import p078g.p079a.C1710p;
import p078g.p079a.p080A.p084d.C1602a;
import p078g.p079a.p100z.C1740c;
import p078g.p079a.p100z.C1742e;

/* renamed from: g.a.A.e.d.c */
public final class C1625c<T, K> extends C1622a<T, T> {

    /* renamed from: b */
    final C1742e<? super T, K> f1897b;

    /* renamed from: c */
    final C1740c<? super K, ? super K> f1898c;

    /* renamed from: g.a.A.e.d.c$a */
    static final class C1626a<T, K> extends C1602a<T, T> {

        /* renamed from: d */
        final C1742e<? super T, K> f1899d;

        /* renamed from: e */
        final C1740c<? super K, ? super K> f1900e;

        /* renamed from: f */
        K f1901f;

        /* renamed from: g */
        boolean f1902g;

        C1626a(C1710p<? super T> pVar, C1742e<? super T, K> eVar, C1740c<? super K, ? super K> cVar) {
            super(pVar);
            this.f1899d = eVar;
            this.f1900e = cVar;
        }

        /* renamed from: a */
        public void mo27337a(T t) {
            if (!this.f1872c) {
                try {
                    K apply = this.f1899d.apply(t);
                    if (this.f1902g) {
                        boolean a = this.f1900e.mo27357a(this.f1901f, apply);
                        this.f1901f = apply;
                        if (a) {
                            return;
                        }
                    } else {
                        this.f1902g = true;
                        this.f1901f = apply;
                    }
                    this.f1870a.mo27337a(t);
                } catch (Throwable th) {
                    mo27358a(th);
                }
            }
        }
    }

    public C1625c(C1709o<T> oVar, C1742e<? super T, K> eVar, C1740c<? super K, ? super K> cVar) {
        super(oVar);
        this.f1897b = eVar;
        this.f1898c = cVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo27335b(C1710p<? super T> pVar) {
        ((C1706l) this.f1894a).mo27427a(new C1626a(pVar, this.f1897b, this.f1898c));
    }
}
