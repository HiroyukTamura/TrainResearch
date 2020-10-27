package p078g.p079a.p080A.p085e.p089d;

import java.util.concurrent.atomic.AtomicReference;
import p078g.p079a.C1706l;
import p078g.p079a.C1709o;
import p078g.p079a.C1710p;
import p078g.p079a.C1711q;
import p078g.p079a.p080A.p081a.C1588b;
import p078g.p079a.p098x.C1727b;

/* renamed from: g.a.A.e.d.h */
public final class C1634h<T> extends C1622a<T, T> {

    /* renamed from: b */
    final C1711q f1915b;

    /* renamed from: g.a.A.e.d.h$a */
    static final class C1635a<T> extends AtomicReference<C1727b> implements C1710p<T>, C1727b {

        /* renamed from: a */
        final C1710p<? super T> f1916a;

        /* renamed from: b */
        final AtomicReference<C1727b> f1917b = new AtomicReference<>();

        C1635a(C1710p<? super T> pVar) {
            this.f1916a = pVar;
        }

        /* renamed from: a */
        public void mo27336a(C1727b bVar) {
            C1588b.m2223c(this.f1917b, bVar);
        }

        /* renamed from: a */
        public void mo27337a(T t) {
            this.f1916a.mo27337a(t);
        }

        /* renamed from: a */
        public boolean mo27340a() {
            return C1588b.m2218a((C1727b) get());
        }

        /* renamed from: b */
        public void mo27341b() {
            C1588b.m2220a(this.f1917b);
            C1588b.m2220a((AtomicReference<C1727b>) this);
        }

        public void onComplete() {
            this.f1916a.onComplete();
        }

        public void onError(Throwable th) {
            this.f1916a.onError(th);
        }
    }

    /* renamed from: g.a.A.e.d.h$b */
    final class C1636b implements Runnable {

        /* renamed from: a */
        private final C1635a<T> f1918a;

        C1636b(C1635a<T> aVar) {
            this.f1918a = aVar;
        }

        public void run() {
            ((C1706l) C1634h.this.f1894a).mo27427a(this.f1918a);
        }
    }

    public C1634h(C1709o<T> oVar, C1711q qVar) {
        super(oVar);
        this.f1915b = qVar;
    }

    /* renamed from: b */
    public void mo27335b(C1710p<? super T> pVar) {
        C1635a aVar = new C1635a(pVar);
        pVar.mo27336a((C1727b) aVar);
        C1588b.m2223c(aVar, this.f1915b.mo27406a(new C1636b(aVar)));
    }
}
