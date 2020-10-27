package p078g.p079a.p080A.p085e.p089d;

import p078g.p079a.C1706l;
import p078g.p079a.C1709o;
import p078g.p079a.C1710p;
import p078g.p079a.p080A.p082b.C1599b;
import p078g.p079a.p080A.p084d.C1602a;
import p078g.p079a.p100z.C1742e;

/* renamed from: g.a.A.e.d.e */
public final class C1629e<T, U> extends C1622a<T, U> {

    /* renamed from: b */
    final C1742e<? super T, ? extends U> f1906b;

    /* renamed from: g.a.A.e.d.e$a */
    static final class C1630a<T, U> extends C1602a<T, U> {

        /* renamed from: d */
        final C1742e<? super T, ? extends U> f1907d;

        C1630a(C1710p<? super U> pVar, C1742e<? super T, ? extends U> eVar) {
            super(pVar);
            this.f1907d = eVar;
        }

        /* renamed from: a */
        public void mo27337a(T t) {
            if (!this.f1872c) {
                try {
                    Object apply = this.f1907d.apply(t);
                    C1599b.m2241a(apply, "The mapper function returned a null value.");
                    this.f1870a.mo27337a(apply);
                } catch (Throwable th) {
                    mo27358a(th);
                }
            }
        }
    }

    public C1629e(C1709o<T> oVar, C1742e<? super T, ? extends U> eVar) {
        super(oVar);
        this.f1906b = eVar;
    }

    /* renamed from: b */
    public void mo27335b(C1710p<? super U> pVar) {
        ((C1706l) this.f1894a).mo27427a(new C1630a(pVar, this.f1906b));
    }
}
